package com.jxkj.managecenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.common.result.ResultTypeEnum;
import com.jxkj.managecenter.entity.BlogInfo;
import com.jxkj.managecenter.entity.BlogInfoTag;
import com.jxkj.managecenter.entity.BlogTag;
import com.jxkj.managecenter.mapper.BlogInfoTagMapper;
import com.jxkj.managecenter.mapper.BlogTagMapper;
import com.jxkj.managecenter.service.IBlogTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 博客标签表 服务实现类
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
@Service
public class BlogTagServiceImpl extends ServiceImpl<BlogTagMapper, BlogTag> implements IBlogTagService {

    @Autowired
    private BlogTagMapper blogTagMapper;

    @Autowired
    private IBlogTagService iBlogTagService;

    @Autowired
    private BlogInfoTagMapper blogInfoTagMapper;

    @Override
    public ResultBody saveOrUpdateBlogTag(BlogTag blogTag) {
        QueryWrapper<BlogTag> queryWrapper = new QueryWrapper<>();
        List<BlogTag> tagList = blogTagMapper.selectList(queryWrapper);
        boolean exist = tagList.stream().anyMatch(u -> u.getTagName().equals(blogTag.getTagName()));
        if (!exist) {
            return ResultBodyUtil.success(iBlogTagService.saveOrUpdate(blogTag));
        } else {
            return ResultBodyUtil.error(
                    ResultTypeEnum.ALREADY_EXIST.getCode(),
                    ResultTypeEnum.ALREADY_EXIST.getMsg());
        }
    }

    @Override
    public ResultBody deleteById(Long id) {
        QueryWrapper<BlogInfoTag> queryWrapper = new QueryWrapper<>();
        List<BlogInfoTag> blogInfoTag = blogInfoTagMapper.selectList(queryWrapper.eq("t_blog_tag_id", id));
        if (blogInfoTag.isEmpty()) {
            blogTagMapper.deleteById(id);
            return ResultBodyUtil.success();
        } else {
            return ResultBodyUtil.error(ResultTypeEnum.CAN_NOT_DELETE.getCode(), ResultTypeEnum.CAN_NOT_DELETE.getMsg());
        }
    }

    @Override
    public ResultBody findPVTopNBlogByTagId(Long tagId, Integer number) {
        BlogTag blogTag = blogTagMapper.findAllBlogByTagId(tagId);
        List<BlogInfo> blogInfos = blogTag.getBlogInfos();
        if (number <= 0) {
            number = 10;
        }
        if (number >= 100) {
            number = 100;
        }
        List<BlogInfo> blogInfoList = blogInfos.stream()
                .distinct()
                .sorted(Comparator.comparing(BlogInfo::getPageViewNum, Comparator.nullsFirst(Integer::compareTo)).reversed())
                .limit(number).collect(Collectors.toList());
        blogTag.setBlogInfos(blogInfoList);
        return ResultBodyUtil.success(blogTag);
    }

    @Override
    public ResultBody findBlogTagNyName(String tagName) {
        QueryWrapper<BlogTag> queryWrapper = Wrappers.query();
        queryWrapper.eq("tag_name", tagName);
        BlogTag blogTag = blogTagMapper.selectOne(queryWrapper);
        return ResultBodyUtil.success(blogTag);
    }
}
