package com.jxkj.usercenter.service;

import com.jxkj.common.result.ResultBody;
import com.jxkj.usercenter.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jxkj.usercenter.entity.UserInfo;
import com.jxkj.usercenter.form.UserForm;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-20
 */
public interface IUserService extends IService<User> {

    ResultBody userRegister(UserForm userForm);

    ResultBody userLogin(String username, String password);

    ResultBody updatePassword(Long userId, String newPassword);

    ResultBody deleteById(Long userId);

    ResultBody activation(Long userId);
}
