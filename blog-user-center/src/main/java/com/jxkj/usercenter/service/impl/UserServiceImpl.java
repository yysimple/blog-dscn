package com.jxkj.usercenter.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.common.result.ResultTypeEnum;
import com.jxkj.managecenter.entity.BlogInfo;
import com.jxkj.managecenter.service.IBlogInfoService;
import com.jxkj.usercenter.entity.User;
import com.jxkj.usercenter.entity.UserLevel;
import com.jxkj.usercenter.entity.UserRole;
import com.jxkj.usercenter.form.UserForm;
import com.jxkj.usercenter.mapper.UserLevelMapper;
import com.jxkj.usercenter.mapper.UserMapper;
import com.jxkj.usercenter.mapper.UserRoleMapper;
import com.jxkj.usercenter.service.IUserInfoService;
import com.jxkj.usercenter.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


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

    public static final Long DEFAULT_PERMISSIONS = 2L;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private UserLevelMapper userLevelMapper;

    @Autowired
    private IUserInfoService iUserInfoService;


    private QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    IPage<User> page = new Page(1, 10);

    /** 
     * 功能描述 用户注册
     * @author ysq
     * @param userForm
     * @return com.jxkj.common.result.ResultBody
     * @date 2020/5/27
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
        QueryWrapper<User> username = queryWrapper.eq("username", userForm.getUser().getUsername());
        Long userId = userMapper.selectOne(username).getId();
        userForm.getUserInfo().setTUserId(userId);
        iUserInfoService.saveMessage(userForm.getUserInfo());
        //添加用户权限
        UserRole userRole = new UserRole();
        userRole.setTUserId(userId);
        userRole.setTRoleId(DEFAULT_PERMISSIONS);
        userRoleMapper.insert(userRole);
        //添加用户等级和积分
        UserLevel userLevel = new UserLevel();
        userLevel.setTUserId(userId);
        userLevelMapper.insert(userLevel);
        return ResultBodyUtil.success();
    }
    /**
     * 功能描述 用户登录
     * @author ysq
     * @param username, password
     * @return com.jxkj.common.result.ResultBody
     * @date 2020/5/23
     */
    @Override
    public ResultBody userLogin(String username, String password) {
        QueryWrapper<User> queryWrapper = Wrappers.query();
        queryWrapper.eq("username", username).last("limit 1");
        User user = userMapper.selectOne(queryWrapper);
        if (null == user) {
            return ResultBodyUtil.error(ResultTypeEnum.USER_NOT_EXIST.getCode(),
                    ResultTypeEnum.USER_NOT_EXIST.getMsg());
        }
        if (!user.getPassword().equals(password)) {
            return ResultBodyUtil.error(ResultTypeEnum.PASSWORD_NOT_TRUE.getCode(),
                    ResultTypeEnum.PASSWORD_NOT_TRUE.getMsg());
        }
        return ResultBodyUtil.success(user);
    }

    /**
     * 功能描述 修改密码
     * @author ysq
     * @param userId, newPassword
     * @return com.jxkj.common.result.ResultBody
     * @date 2020/5/23
     */
    @Override
    public ResultBody updatePassword(Long userId, String newPassword) {
        User user = userMapper.selectById(userId);
        if (null == user){
            return ResultBodyUtil.error(ResultTypeEnum.USER_NOT_EXIST.getCode(),
                    ResultTypeEnum.USER_NOT_EXIST.getMsg());
        }
        if (null == newPassword || "".equals(newPassword)){
            return ResultBodyUtil.error(ResultTypeEnum.PASSWORD_NOT_EMPTY.getCode(),
                    ResultTypeEnum.PASSWORD_NOT_EMPTY.getMsg());
        }
        user.setPassword(newPassword);
        userMapper.updateById(user);
        return ResultBodyUtil.success();
    }

    /**
     * 功能描述  假删数据
     * @author ysq
     * @param userId
     * @return com.jxkj.common.result.ResultBody
     * @date 2020/5/23
     */
    @Override
    public ResultBody deleteById(Long userId) {
        User user = userMapper.selectById(userId);
        if (null == user){
            return ResultBodyUtil.error(ResultTypeEnum.USER_NOT_EXIST.getCode(),
                    ResultTypeEnum.USER_NOT_EXIST.getMsg());
        }
        user.setDeleteStatus(1);
        userMapper.updateById(user);
        return ResultBodyUtil.success();
    }
    /**
     * 功能描述  重新激活用户
     * @author ysq
     * @param userId
     * @return com.jxkj.common.result.ResultBody
     * @date 2020/5/27
     */
    @Override
    public ResultBody activation(Long userId) {
        User user = userMapper.selectById(userId);
        if (null == user){
            return ResultBodyUtil.error(ResultTypeEnum.USER_NOT_EXIST.getCode(),
                    ResultTypeEnum.USER_NOT_EXIST.getMsg());
        }
        user.setDeleteStatus(0);
        userMapper.updateById(user);
        return ResultBodyUtil.success();
    }

    /**
     * 功能描述 分页查询所有用户
     *
     * @return com.jxkj.common.result.ResultBody
     * @author ysq
     * @Param []
     * @date 2020/5/28
     */
    @Override
    public ResultBody selectAll(Long current, Long size) {
        if (null != current && 0L < current){
            page.setCurrent(current);
        }
        if (null != size && 0L <size){
            page.setPages(size);
        }
        QueryWrapper<User> delete_status = queryWrapper.eq("delete_status", 0);
        IPage<User> userIPage = userMapper.selectPage(page, delete_status);
        return ResultBodyUtil.success(userIPage);
    }


    @Override
    public ResultBody saveBlogInfo(BlogInfo blogInfo, Long[] tagIds, Long typeId, Long userId) {

        return null;
    }

    @Override
    public ResultBody selectUserInfoById(Long userId) {
        return ResultBodyUtil.success(userMapper.selectUserInfoById(userId));
    }
}
