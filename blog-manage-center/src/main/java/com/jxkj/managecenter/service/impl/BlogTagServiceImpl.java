package com.jxkj.managecenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.common.result.ResultTypeEnum;
import com.jxkj.managecenter.entity.BlogTag;
import com.jxkj.managecenter.mapper.BlogTagMapper;
import com.jxkj.managecenter.service.IBlogTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public ResultBody saveOrUpdateBlogTag(BlogTag blogTag) {
        QueryWrapper<BlogTag> queryWrapper = new QueryWrapper<>();
        List<BlogTag> tagList = blogTagMapper.selectList(queryWrapper);
        boolean b = tagList.stream().anyMatch(u -> u.getTagName().equals(blogTag.getTagName()));
        if (!b && blogTag.getId() == null){
            return ResultBodyUtil.success(blogTagMapper.insert(blogTag));
        }else if (!b && blogTag.getId() != null) {
            return ResultBodyUtil.success(blogTagMapper.updateById(blogTag));
        }else {
            return ResultBodyUtil.error(
                    ResultTypeEnum.ALREADY_EXIST.getCode(),
                    ResultTypeEnum.ALREADY_EXIST.getMsg());
        }
    }
}
