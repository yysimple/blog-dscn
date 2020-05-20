package com.jxkj.usercenter.service.impl;

import com.jxkj.usercenter.entity.BlogType;
import com.jxkj.usercenter.mapper.BlogTypeMapper;
import com.jxkj.usercenter.service.IBlogTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客类型表 服务实现类
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
@Service
public class BlogTypeServiceImpl extends ServiceImpl<BlogTypeMapper, BlogType> implements IBlogTypeService {

}
