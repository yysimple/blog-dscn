package com.jxkj.usercenter.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.common.result.ResultTypeEnum;
import com.jxkj.usercenter.entity.User;
import com.jxkj.usercenter.entity.UserInfo;
import com.jxkj.usercenter.form.UserForm;
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

    @Autowired
    private IUserInfoService iUserInfoService;

    /**
     * 功能描述 用户注册
     * @author ysq
     * @param [user]
     * @return com.jxkj.common.result.ResultBody
     * @date 2020/5/23
     */
    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public ResultBody userRegister(UserForm userForm) {
        if (StrUtil.hasBlank(userForm.getUser().getUsername())) {
            return ResultBodyUtil.error(ResultTypeEnum.USERNAME_NOT_EMPTY.getCode(),
                    ResultTypeEnum.PASSWORD_NOT_EMPTY.getMsg());
        }
        if (StrUtil.hasBlank(userForm.getUser().getPassword())) {
            return ResultBodyUtil.error(ResultTypeEnum.PASSWORD_NOT_EMPTY.getCode(),
                    ResultTypeEnum.PASSWORD_NOT_EMPTY.getMsg());
        }
        QueryWrapper<User> queryWrapper = Wrappers.query();
        queryWrapper.eq("username", userForm.getUser().getUsername());
        List<User> users = userMapper.selectList(queryWrapper);
        boolean usernameIsExist = users.stream().anyMatch(u -> u.getUsername().equals(userForm.getUser().getUsername()));
        if (usernameIsExist) {
            return ResultBodyUtil.error(ResultTypeEnum.USER_ALREADY_EXIST.getCode(),
                    ResultTypeEnum.USER_ALREADY_EXIST.getMsg());
        }
        userMapper.userRegister(userForm.getUser());
        QueryWrapper<User> username = new QueryWrapper<User>().eq("username", userForm.getUser().getUsername());
        userForm.getUserInfo().setTUserId(userMapper.selectOne(username).getId());
        iUserInfoService.saveMessage(userForm.getUserInfo());
        return ResultBodyUtil.success();
    }
    /**
     * 功能描述 用户登录
     * @author ysq
     * @param [username, password]
     * @return com.jxkj.common.result.ResultBody
     * @date 2020/5/23
     */
    @Override
    public ResultBody userLogin(String username, String password) {
        QueryWrapper<User> queryWrapper = Wrappers.query();
        queryWrapper.eq("username", username).last("limit 1");
        User user = userMapper.selectOne(queryWrapper);
        if (null == user) {
            return ResultBodyUtil.error(ResultTypeEnum.USER_NOT_EXIST.getCode(), ResultTypeEnum.USER_NOT_EXIST.getMsg());
        }
        if (!user.getPassword().equals(password)) {
            return ResultBodyUtil.error(ResultTypeEnum.PASSWORD_NOT_TRUE.getCode(), ResultTypeEnum.PASSWORD_NOT_TRUE.getMsg());
        }
        return ResultBodyUtil.success(user);
    }

    /**
     * 功能描述 修改密码
     * @author ysq
     * @param [userId, newPassword]
     * @return com.jxkj.common.result.ResultBody
     * @date 2020/5/23
     */
    @Override
    public ResultBody updatePassword(Long userId, String newPassword) {
        User user = userMapper.selectById(userId);
        if (null == user){
            return ResultBodyUtil.error(ResultTypeEnum.USER_NOT_EXIST.getCode(),ResultTypeEnum.USER_NOT_EXIST.getMsg());
        }
        if (null == newPassword || "".equals(newPassword)){
            return ResultBodyUtil.error(ResultTypeEnum.PASSWORD_NOT_EMPTY.getCode(),ResultTypeEnum.PASSWORD_NOT_EMPTY.getMsg());
        }
        user.setPassword(newPassword);
        int i = userMapper.updateById(user);
        return ResultBodyUtil.success(i);
    }

    /**
     * 功能描述  假删数据
     * @author ysq
     * @param [userId]
     * @return com.jxkj.common.result.ResultBody
     * @date 2020/5/23
     */
    @Override
    public ResultBody deleteById(Long userId) {
        User user = userMapper.selectById(userId);
        if (null == user){
            return ResultBodyUtil.error(ResultTypeEnum.USER_NOT_EXIST.getCode(),ResultTypeEnum.USER_NOT_EXIST.getMsg());
        }
        user.setDeleteStatus(1);
        int i = userMapper.updateById(user);
        return ResultBodyUtil.success(i);
    }
}
