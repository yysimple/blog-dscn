package com.jxkj.usercenter.service.impl;

import com.jxkj.usercenter.entity.BlogInfoType;
import com.jxkj.usercenter.mapper.BlogInfoTypeMapper;
import com.jxkj.usercenter.service.IBlogInfoTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客和类型的关联表 服务实现类
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
@Service
public class BlogInfoTypeServiceImpl extends ServiceImpl<BlogInfoTypeMapper, BlogInfoType> implements IBlogInfoTypeService {

}
