package com.jxkj.managecenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.common.result.ResultTypeEnum;
import com.jxkj.managecenter.entity.BlogInfo;
import com.jxkj.managecenter.entity.BlogInfoTag;
import com.jxkj.managecenter.entity.BlogInfoType;
import com.jxkj.managecenter.entity.Favorites;
import com.jxkj.managecenter.mapper.BlogInfoMapper;
import com.jxkj.managecenter.mapper.BlogInfoTagMapper;
import com.jxkj.managecenter.mapper.BlogInfoTypeMapper;
import com.jxkj.managecenter.mapper.FavoritesMapper;
import com.jxkj.managecenter.service.IBlogInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

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
    private FavoritesMapper favoritesMapper;

    @Autowired
    private BlogInfoTagMapper blogInfoTagMapper;

    @Autowired
    private BlogInfoTypeMapper blogInfoTypeMapper;

    private QueryWrapper<BlogInfo> queryWrapper = new QueryWrapper<>();
    IPage<BlogInfo> page = new Page(1, 10);

    @Override
    public ResultBody pagingQuery() {
        queryWrapper.eq("blog_status", 1);
        IPage<BlogInfo> blogInfo = blogInfoMapper.selectPage(page, queryWrapper);
        return ResultBodyUtil.success(blogInfo);
    }

    @Override
    public ResultBody findIssueBlog(String key) {
        queryWrapper.eq("blog_status", 1).like("title", key)
                .or().like("content", key);
        IPage<BlogInfo> blogInfo = blogInfoMapper.selectPage(page, queryWrapper);
        return ResultBodyUtil.success(blogInfo);
    }

    @Override
    public ResultBody addLikeNum(Long id) {
        BlogInfo blogInfo = blogInfoMapper.selectById(id);
        blogInfo.setLikeNum(blogInfo.getLikeNum() + 1);
        blogInfoMapper.updateById(blogInfo);
        return ResultBodyUtil.success();
    }

    @Override
    public ResultBody favorites(Long blogId, Long favoritesId, Long userId) {
        QueryWrapper<Favorites> wrapper = new QueryWrapper<>();
        BlogInfo blogInfo = blogInfoMapper.selectById(blogId);
        List<Favorites> favorites = favoritesMapper.selectList(wrapper.eq("t_user_id", userId));
        boolean exist = favorites.stream().anyMatch(u -> u.getId().equals(favoritesId));
        if (exist) {
            blogInfo.setTFavoritesId(favoritesId);
            return ResultBodyUtil.success();
        } else {
            return ResultBodyUtil.error(ResultTypeEnum.Favorites_NOT_EXIST.getCode(), ResultTypeEnum.Favorites_NOT_EXIST.getMsg());
        }
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
        return ResultBodyUtil.success();
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
            if (infoTag == null) {
                blogInfoTagMapper.insert(blogInfoTag);
            } else {
                blogInfoTagMapper.updateById(blogInfoTag);
            }
        }
        QueryWrapper<BlogInfoType> queryType = new QueryWrapper<>();
        BlogInfoType blogInfoType = blogInfoTypeMapper.selectOne(queryType.eq("t_blog_info_id", blogInfo.getId()));
        if (blogInfoType == null){
            BlogInfoType infoType = new BlogInfoType();
            infoType.setTBlogInfoId(blogInfo.getId());
            infoType.setTBlogTypeId(typeId);
            blogInfoTypeMapper.insert(infoType);
        }else {
            blogInfoType.setTBlogTypeId(typeId);
            blogInfoTypeMapper.updateById(blogInfoType);
        }

        return ResultBodyUtil.success();
    }

    @Override
    public ResultBody deleteBlogInfo(Long id) {
        blogInfoMapper.deleteById(id);
        QueryWrapper<BlogInfoType> queryWrapper = new QueryWrapper<>();
        QueryWrapper<BlogInfoTag> wrapper = new QueryWrapper<>();
        blogInfoTypeMapper.delete(queryWrapper.eq("t_blog_info_id", id));
        blogInfoTagMapper.delete(wrapper.eq("t_blog_info_id", id));
        return ResultBodyUtil.success();
    }
}
