package com.jxkj.managecenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxkj.managecenter.entity.BlogLikeUser;
import com.jxkj.managecenter.mapper.BlogLikeUserMapper;
import com.jxkj.managecenter.service.IBlogLikeUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户点赞信息关联表 服务实现类
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
@Service
public class BlogLikeUserServiceImpl extends ServiceImpl<BlogLikeUserMapper, BlogLikeUser> implements IBlogLikeUserService {

}