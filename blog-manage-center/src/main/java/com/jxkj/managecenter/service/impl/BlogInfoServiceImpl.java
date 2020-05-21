package com.jxkj.managecenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxkj.managecenter.entity.BlogInfo;
import com.jxkj.managecenter.mapper.BlogInfoMapper;
import com.jxkj.managecenter.service.IBlogInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

    @Resource
    private BlogInfoMapper blogInfoMapper;

    @Override
    public void updateDelStatusById(Long id) {
        BlogInfo blogInfo = blogInfoMapper.selectById(id);
        blogInfo.setDeleteStatus(1);
        blogInfoMapper.updateById(blogInfo);
    }
}
