package com.jxkj.managecenter.service.impl;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.managecenter.entity.*;
import com.jxkj.managecenter.feign.UserInfoFeignService;
import com.jxkj.managecenter.mapper.*;
import com.jxkj.managecenter.service.IBlogInfoService;
import com.jxkj.managecenter.vo.BlogInfoVO;
import com.jxkj.managecenter.vo.BlogUserInfoVO;
import com.jxkj.managecenter.vo.UserInfoVO;
import com.jxkj.managecenter.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 博客基本信息表 服务实现类
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
@Service
@Slf4j
public class BlogInfoServiceImpl extends ServiceImpl<BlogInfoMapper, BlogInfo> implements IBlogInfoService {

    @Autowired
    private BlogInfoMapper blogInfoMapper;

    @Autowired
    private BlogLikeUserMapper blogLikeUserMapper;

    @Autowired
    private BlogFavoritesUserMapper blogFavoritesUserMapper;

    @Autowired
    private BlogInfoTagMapper blogInfoTagMapper;

    @Autowired
    private BlogInfoTypeMapper blogInfoTypeMapper;

    @Autowired
    private UserInfoFeignService userInfoFeignService;

    @Autowired
    private BlogTagMapper blogTagMapper;

    @Autowired
    private CategoryColumnMapper categoryColumnMapper;

    @Autowired
    private BlogInfoCategoryMapper blogInfoCategoryMapper;

    @Autowired
    private BlogTypeMapper blogTypeMapper;

    private QueryWrapper<BlogInfo> queryWrapper = new QueryWrapper<>();
    IPage<BlogInfo> page = new Page(1, 10);

    @Override
    public ResultBody pagingQuery() {
        queryWrapper.eq("blog_status", 1);
        IPage<BlogInfo> blogInfo = blogInfoMapper.selectPage(page, queryWrapper);
        return ResultBodyUtil.success(blogInfo);
    }

    @Override
    public ResultBody listUserBlog(Long userId) {
        queryWrapper.eq("blog_status", 1).eq("t_user_id", userId);
        List<BlogInfo> blogInfoList = blogInfoMapper.selectList(queryWrapper);
        return ResultBodyUtil.success(blogInfoList);
    }

    @Override
    public ResultBody listPageUserBlog(Long userId) {
        queryWrapper.eq("blog_status", 1).eq("t_user_id", userId);
        IPage<BlogInfo> blogInfoIPage = blogInfoMapper.selectPage(page, queryWrapper);
        return ResultBodyUtil.success(blogInfoIPage);
    }


    @Override
    public ResultBody findIssueBlog(String key) {
        queryWrapper.eq("blog_status", 1).like("title", key)
                .or().like("content", key);
        IPage<BlogInfo> blogInfo = blogInfoMapper.selectPage(page, queryWrapper);
        return ResultBodyUtil.success(blogInfo);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ResultBody addLikeNum(Long id, Long userId) {
        BlogInfo blogInfo = blogInfoMapper.selectById(id);
        QueryWrapper<BlogLikeUser> queryWrapper = new QueryWrapper<>();
        BlogLikeUser likeUser = blogLikeUserMapper.selectOne(queryWrapper.eq("blog_id", id).eq("user_id", userId));
        if (likeUser == null) {
            blogInfo.setLikeNum(blogInfo.getLikeNum() + 1);
            BlogLikeUser blogLikeUser = new BlogLikeUser();
            blogLikeUser.setBlogId(id);
            blogLikeUser.setUserId(userId);
            blogLikeUserMapper.insert(blogLikeUser);
        } else {
            blogInfo.setLikeNum(blogInfo.getLikeNum() - 1);
            blogLikeUserMapper.deleteById(likeUser.getId());
        }
        blogInfoMapper.updateById(blogInfo);
        return ResultBodyUtil.success();
    }

    @Override
    public ResultBody addViewNum(Long id) {
        BlogInfo blogInfo = blogInfoMapper.selectById(id);
        blogInfo.setPageViewNum(blogInfo.getPageViewNum() + 1);
        blogInfoMapper.updateById(blogInfo);
        return ResultBodyUtil.success();
    }

    @Override
    public ResultBody favorites(Long blogId, Long userId, Long favoritesId) {
        QueryWrapper<BlogFavoritesUser> wrapper = new QueryWrapper<>();
        BlogFavoritesUser favoritesUser = blogFavoritesUserMapper.selectOne(wrapper.eq("blog_id", blogId).eq("favorites_id", favoritesId).eq("user_id", userId));
        if (favoritesUser == null) {
            BlogFavoritesUser blogFavoritesUser = new BlogFavoritesUser();
            blogFavoritesUser.setBlogId(blogId);
            blogFavoritesUser.setUserId(userId);
            blogFavoritesUser.setFavoritesId(favoritesId);
            blogFavoritesUserMapper.insert(blogFavoritesUser);
        } else {
            blogFavoritesUserMapper.deleteById(favoritesUser.getId());
        }
        return ResultBodyUtil.success();
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ResultBody saveBlogInfo(BlogInfo blogInfo, Long[] tagIds, Long typeId) {
        blogInfoMapper.insertBlogInfo(blogInfo);
        for (int i = 0; i < tagIds.length; i++) {
            BlogInfoTag blogInfoTag = new BlogInfoTag();
            Long tagId = tagIds[i];
            blogInfoTag.setTBlogInfoId(blogInfo.getId());
            blogInfoTag.setTBlogTagId(tagId);
            blogInfoTagMapper.insert(blogInfoTag);
        }
        BlogInfoType blogInfoType = new BlogInfoType();
        blogInfoType.setTBlogInfoId(blogInfo.getId());
        blogInfoType.setTBlogTypeId(typeId);
        blogInfoTypeMapper.insert(blogInfoType);
        return ResultBodyUtil.success(blogInfo.getBlogStatus() == 1);
    }

    /**
     * 功能描述: 保存博客
     *
     * @param blogInfo
     * @param categoryNames
     * @param tagNames
     * @param typeId
     * @return com.jxkj.common.result.ResultBody
     * @Author wcx
     **/
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public ResultBody saveBlogInfo(BlogInfo blogInfo, String[] categoryNames, String[] tagNames, Long typeId) {
        blogInfoMapper.insertBlogInfo(blogInfo);
        List<BlogTag> blogTags = blogTagMapper.selectList(null);
        for (int i = 0; i < tagNames.length; i++) {
            BlogInfoTag blogInfoTag = new BlogInfoTag();
            int finalI = i;
            boolean isExistTagName = blogTags.stream().anyMatch(blogTag -> blogTag.getTagName()
                    .toLowerCase().equals(tagNames[finalI].toLowerCase()));
            if (!isExistTagName) {
                BlogTag blogTag = new BlogTag();
                blogTag.setTagName(tagNames[finalI]);
                blogTag.setCreateTime(LocalDateTime.now());
                blogTag.setUpdateTime(LocalDateTime.now());
                blogTagMapper.saveBlogTag(blogTag);
                blogInfoTag.setTBlogInfoId(blogInfo.getId());
                blogInfoTag.setTBlogTagId(blogTag.getId());
            } else {
                blogInfoTag.setTBlogInfoId(blogInfo.getId());
                blogInfoTag.setTBlogTagId(blogTagMapper.findBlogTagByTagName(tagNames[i]).getId());
            }
            blogInfoTagMapper.insert(blogInfoTag);
        }
        List<CategoryColumn> categoryColumns = categoryColumnMapper.selectList(null);
        for (int i = 0; i < categoryNames.length; i++) {
            BlogInfoCategory blogInfoCategory = new BlogInfoCategory();
            int finalI = i;
            boolean isExistCategoryName = categoryColumns.stream().anyMatch(categoryColumn -> categoryColumn
                    .getCategoryName().toLowerCase().equals(categoryNames[finalI].toLowerCase()));
            if (!isExistCategoryName) {
                CategoryColumn categoryColumn = new CategoryColumn();
                categoryColumn.setCategoryName(categoryNames[i]);
                categoryColumn.setCreateTime(LocalDateTime.now());
                categoryColumn.setUpdateTime(LocalDateTime.now());
                categoryColumn.setTUserId(blogInfo.getTUserId());
                categoryColumnMapper.saveCategoryColumn(categoryColumn);
                blogInfoCategory.setTBlogInfoId(blogInfo.getId());
                blogInfoCategory.setTCategoryColumnId(categoryColumn.getId());
            }else {
                blogInfoCategory.setTBlogInfoId(blogInfo.getId());
                blogInfoCategory.setTCategoryColumnId(categoryColumnMapper.getCategoryByCategoryName(categoryNames[i]).getId());
            }
            blogInfoCategoryMapper.insert(blogInfoCategory);
        }
        BlogInfoType blogInfoType = new BlogInfoType();
        blogInfoType.setTBlogInfoId(blogInfo.getId());
        blogInfoType.setTBlogTypeId(typeId);
        blogInfoTypeMapper.insert(blogInfoType);
        BlogType blogType = blogTypeMapper.selectById(typeId);
        String typeName = blogType.getType();
        BlogInfoVO blogInfoVO = new BlogInfoVO();
        BeanUtils.copyProperties(blogInfo, blogInfoVO);
        blogInfoVO.setTypeName(typeName);
        return ResultBodyUtil.success(blogInfoVO);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ResultBody updateBlogInfo(BlogInfo blogInfo, Long[] tagIds, Long typeId) {
        blogInfoMapper.updateById(blogInfo);
        QueryWrapper<BlogInfoTag> wrapper = new QueryWrapper<>();
        for (int i = 0; i < tagIds.length; i++) {
            Long tagId = tagIds[i];
            BlogInfoTag blogInfoTag = new BlogInfoTag();
            blogInfoTag.setTBlogInfoId(blogInfo.getId());
            blogInfoTag.setTBlogTagId(tagId);
            BlogInfoTag infoTag = blogInfoTagMapper.selectOne(wrapper.
                    eq("t_blog_info_id", blogInfo.getId()).
                    eq("t_blog_tag_id", tagId));
            if (null == infoTag) {
                blogInfoTagMapper.insert(blogInfoTag);
            } else {
                blogInfoTagMapper.updateById(blogInfoTag);
            }
        }
        QueryWrapper<BlogInfoType> queryType = new QueryWrapper<>();
        BlogInfoType blogInfoType = blogInfoTypeMapper.selectOne(queryType.eq("t_blog_info_id", blogInfo.getId()));
        if (null == blogInfoType) {
            BlogInfoType infoType = new BlogInfoType();
            infoType.setTBlogInfoId(blogInfo.getId());
            infoType.setTBlogTypeId(typeId);
            blogInfoTypeMapper.insert(infoType);
        } else {
            blogInfoType.setTBlogTypeId(typeId);
            blogInfoTypeMapper.updateById(blogInfoType);
        }
        return ResultBodyUtil.success();
    }

    @Override
    public ResultBody findBlogInfoAndTagsByBlogInfoId(Long blogId) {
        BlogInfo blogInfo = blogInfoMapper.findBlogInfoAndTagsByBlogInfoId(blogId);
        return ResultBodyUtil.success(blogInfo);
    }

    @Override
    public ResultBody recoverBlogInfoById(Long id) {
        BlogInfo blogInfo = blogInfoMapper.selectById(id);
        blogInfo.setDeleteStatus(0);
        blogInfoMapper.updateById(blogInfo);
        return ResultBodyUtil.success();
    }

    @Override
    public ResultBody findAllDeletedBlog() {
        queryWrapper.eq("delete_status", 1);
        IPage<BlogInfo> blogInfoIPage = blogInfoMapper.selectPage(page, queryWrapper);
        return ResultBodyUtil.success(blogInfoIPage);
    }

    @Override
    public ResultBody removeBlogInfoById(Long id) {
        blogInfoMapper.deleteInfoById(id);
        return ResultBodyUtil.success();
    }

    @Override
    //TODO 分布式事务
    public ResultBody listOrderByViewNum() {
        List<BlogInfo> blogInfoList = blogInfoMapper.selectListOrderByViewNum();
        List<BlogUserInfoVO> blogUserInfoVOS = new ArrayList<>();
        for (BlogInfo blogInfo : blogInfoList) {
            BlogUserInfoVO blogUserInfoVO = new BlogUserInfoVO();
            blogUserInfoVO.setBlogInfo(blogInfo);
            ResultBody resultBody = userInfoFeignService.selectUserInfoById(blogInfo.getTUserId());
            Object data = resultBody.getData();
            JSONObject jsonObject = JSONUtil.parseObj(data, false);
            UserVO userVO = JSON.parseObject(jsonObject.toString(), UserVO.class);
            blogUserInfoVO.setUser(userVO);
            blogUserInfoVOS.add(blogUserInfoVO);
        }
        return ResultBodyUtil.success(blogUserInfoVOS);
    }

    @Override
    public ResultBody findRecentlyTopNumberBlogInfo(Integer number) {
        List<BlogInfo> blogInfos = blogInfoMapper.findRecentlyTopNumberBlogInfo(number);
        return ResultBodyUtil.success(blogInfos);
    }
}
