package com.jxkj.usercenter.service.impl;

import com.jxkj.usercenter.entity.BlogInfoClassification;
import com.jxkj.usercenter.mapper.BlogInfoClassificationMapper;
import com.jxkj.usercenter.service.IBlogInfoClassificationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客信息和分类关联表 服务实现类
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
@Service
public class BlogInfoClassificationServiceImpl extends ServiceImpl<BlogInfoClassificationMapper, BlogInfoClassification> implements IBlogInfoClassificationService {

}
