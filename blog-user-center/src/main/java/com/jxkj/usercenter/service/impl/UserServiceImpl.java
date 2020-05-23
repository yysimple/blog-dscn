package com.jxkj.usercenter.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.common.result.ResultTypeEnum;
import com.jxkj.usercenter.entity.User;
import com.jxkj.usercenter.mapper.UserMapper;
import com.jxkj.usercenter.service.IUserInfoService;
import com.jxkj.usercenter.service.IUserLevelService;
import com.jxkj.usercenter.service.IUserRoleService;
import com.jxkj.usercenter.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.RouteMatcher;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-20
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;


    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public ResultBody userRegister(User user) {
        // 使用日志打印
        log.info("user：{}" , user);
        if (StrUtil.hasBlank(user.getUsername())) {
            return ResultBodyUtil.error(ResultTypeEnum.USERNAME_NOT_EMPTY.getCode(),
                    ResultTypeEnum.PASSWORD_NOT_EMPTY.getMsg());
        }
        if (StrUtil.hasBlank(user.getPassword())) {
            return ResultBodyUtil.error(ResultTypeEnum.PASSWORD_NOT_EMPTY.getCode(),
                    ResultTypeEnum.PASSWORD_NOT_EMPTY.getMsg());
        }
        QueryWrapper<User> queryWrapper = Wrappers.query();
        queryWrapper.eq("username", user.getUsername());
        List<User> users = userMapper.selectList(queryWrapper);
        boolean usernameIsExist = users.stream().anyMatch(u -> u.getUsername().equals(user.getUsername()));
        if (usernameIsExist) {
            return ResultBodyUtil.error(ResultTypeEnum.USER_ALREADY_EXIST.getCode(),
                    ResultTypeEnum.USER_ALREADY_EXIST.getMsg());
        }
        userMapper.userRegister(user);
        return ResultBodyUtil.success();
    }

    @Override
    public ResultBody userLogin(User user) {
        return null;
    }
}
