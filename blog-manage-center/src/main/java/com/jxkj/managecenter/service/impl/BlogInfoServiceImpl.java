package com.jxkj.managecenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.common.result.ResultTypeEnum;
import com.jxkj.managecenter.entity.BlogInfo;
import com.jxkj.managecenter.entity.Favorites;
import com.jxkj.managecenter.mapper.BlogInfoMapper;
import com.jxkj.managecenter.mapper.FavoritesMapper;
import com.jxkj.managecenter.service.IBlogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class BlogInfoServiceImpl extends ServiceImpl<BlogInfoMapper, BlogInfo> implements IBlogInfoService {

    @Autowired
    private BlogInfoMapper blogInfoMapper;

    @Autowired
    private FavoritesMapper favoritesMapper;

    @Autowired
    private IBlogInfoService iBlogInfoService;

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
        boolean b = favorites.stream().anyMatch(u -> u.getId().equals(favoritesId));
        if (b) {
            blogInfo.setTFavoritesId(favoritesId);
            return ResultBodyUtil.success();
        } else {
            return ResultBodyUtil.error(
                    ResultTypeEnum.NOT_EXIST.getCode(),
                    ResultTypeEnum.NOT_EXIST.getMsg());
        }
    }
}
