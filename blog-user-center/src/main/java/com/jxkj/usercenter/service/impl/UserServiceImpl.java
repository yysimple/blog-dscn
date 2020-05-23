package com.jxkj.usercenter.service.impl;

import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.usercenter.entity.User;
import com.jxkj.usercenter.mapper.UserMapper;
import com.jxkj.usercenter.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.RouteMatcher;
import org.springframework.web.bind.annotation.RequestParam;

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

    private UserMapper userMapper;

    @Override
    public ResultBody userRegister(User user) {
        System.out.println(user.getUsername());
        userMapper.userRegister(user);
        return ResultBodyUtil.success();
    }
}
