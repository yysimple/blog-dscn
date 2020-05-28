package com.jxkj.usercenter.service;

import com.jxkj.common.result.ResultBody;
import com.jxkj.usercenter.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jxkj.usercenter.entity.UserInfo;
import com.jxkj.usercenter.form.UserForm;
import io.swagger.models.auth.In;
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

    /**
     * 功能描述 用户注册
     * @author ysq
     * @param userForm
     * @return com.jxkj.common.result.ResultBody
     * @date 2020/5/27
     */
    ResultBody userRegister(UserForm userForm);

    /**
     * 功能描述 用户登录
     * @author ysq
     * @param username, password
     * @return com.jxkj.common.result.ResultBody
     * @date 2020/5/23
     */
    ResultBody userLogin(String username, String password);

    /**
     * 功能描述 修改密码
     * @author ysq
     * @param userId, newPassword
     * @return com.jxkj.common.result.ResultBody
     * @date 2020/5/23
     */
    ResultBody updatePassword(Long userId, String newPassword);

    /**
     * 功能描述  重新激活用户
     * @author ysq
     * @param userId
     * @return com.jxkj.common.result.ResultBody
     * @date 2020/5/27
     */
    ResultBody deleteById(Long userId);

    /**
     * 功能描述  重新激活用户
     * @author ysq
     * @param userId
     * @return com.jxkj.common.result.ResultBody
     * @date 2020/5/27
     */
    ResultBody activation(Long userId);
    /**
     * 功能描述 分页查询所有用户
     * @author ysq
     * @Param []
     * @return com.jxkj.common.result.ResultBody
     * @date 2020/5/28
     */
    ResultBody selectAll(Long current, Long size);
}
