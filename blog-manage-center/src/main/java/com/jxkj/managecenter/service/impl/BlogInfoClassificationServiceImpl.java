package com.jxkj.managecenter.service.impl;

import com.jxkj.managecenter.entity.BlogInfoClassification;
import com.jxkj.managecenter.mapper.BlogInfoClassificationMapper;
import com.jxkj.managecenter.service.IBlogInfoClassificationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客信息和分类关联表 服务实现类
 * </p>
 *
 * @author gjb
 * @since 2020-05-19
 */
@Service
public class BlogInfoClassificationServiceImpl extends ServiceImpl<BlogInfoClassificationMapper, BlogInfoClassification> implements IBlogInfoClassificationService {

}
