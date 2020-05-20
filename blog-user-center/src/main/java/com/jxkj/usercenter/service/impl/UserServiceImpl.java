package com.jxkj.usercenter.service.impl;

import com.jxkj.usercenter.entity.User;
import com.jxkj.usercenter.mapper.UserMapper;
import com.jxkj.usercenter.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
