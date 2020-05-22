package com.jxkj.managecenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxkj.managecenter.entity.BlogTag;
import com.jxkj.managecenter.mapper.BlogTagMapper;
import com.jxkj.managecenter.service.IBlogTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 博客所属类别表 服务实现类
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
    public Boolean existTagName(BlogTag blogTag) {
        List<String> tagName = blogTagMapper.getTagName();
        boolean contains = tagName.contains(blogTag.getTagName());
        return contains;
    }
}
