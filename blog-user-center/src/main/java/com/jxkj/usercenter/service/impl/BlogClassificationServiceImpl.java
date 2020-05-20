package com.jxkj.usercenter.service.impl;

import com.jxkj.usercenter.entity.BlogClassification;
import com.jxkj.usercenter.mapper.BlogClassificationMapper;
import com.jxkj.usercenter.service.IBlogClassificationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客所属类别表 服务实现类
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
@Service
public class BlogClassificationServiceImpl extends ServiceImpl<BlogClassificationMapper, BlogClassification> implements IBlogClassificationService {

}
