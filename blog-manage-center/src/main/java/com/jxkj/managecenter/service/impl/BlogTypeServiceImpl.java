package com.jxkj.managecenter.service.impl;

import com.jxkj.managecenter.entity.BlogType;
import com.jxkj.managecenter.mapper.BlogTypeMapper;
import com.jxkj.managecenter.service.IBlogTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客类型表 服务实现类
 * </p>
 *
 * @author gjb
 * @since 2020-05-19
 */
@Service
public class BlogTypeServiceImpl extends ServiceImpl<BlogTypeMapper, BlogType> implements IBlogTypeService {

}
