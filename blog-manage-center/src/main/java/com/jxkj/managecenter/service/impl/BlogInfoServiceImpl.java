package com.jxkj.managecenter.service.impl;

import com.jxkj.managecenter.entity.BlogInfo;
import com.jxkj.managecenter.mapper.BlogInfoMapper;
import com.jxkj.managecenter.service.IBlogInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客基本信息表 服务实现类
 * </p>
 *
 * @author gjb
 * @since 2020-05-19
 */
@Service
public class BlogInfoServiceImpl extends ServiceImpl<BlogInfoMapper, BlogInfo> implements IBlogInfoService {

}
