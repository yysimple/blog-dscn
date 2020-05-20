package com.jxkj.usercenter.service.impl;

import com.jxkj.usercenter.entity.BlogInfo;
import com.jxkj.usercenter.mapper.BlogInfoMapper;
import com.jxkj.usercenter.service.IBlogInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
