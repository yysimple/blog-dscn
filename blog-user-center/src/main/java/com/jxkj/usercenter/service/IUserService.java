package com.jxkj.usercenter.service;

import com.jxkj.common.result.ResultBody;
import com.jxkj.usercenter.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jxkj.usercenter.entity.UserInfo;
import com.jxkj.usercenter.form.BlogInfoAndTagForm;
import com.jxkj.usercenter.form.BlogInfoForm;
import com.jxkj.usercenter.form.UserForm;
import io.swagger.models.auth.In;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
     *
     * @param userForm
     * @return com.jxkj.common.result.ResultBody
     * @author ysq
     * @date 2020/5/27
     */
    ResultBody userRegister(UserForm userForm);

    /**
     * 功能描述 用户登录
     *
     * @param username, password
     * @return com.jxkj.common.result.ResultBody
     * @author ysq
     * @date 2020/5/23
     */
    ResultBody userLogin(String username, String password);

    /**
     * 功能描述 修改密码
     *
     * @param userId, newPassword
     * @return com.jxkj.common.result.ResultBody
     * @author ysq
     * @date 2020/5/23
     */
    ResultBody updatePassword(Long userId, String newPassword);

    /**
     * 功能描述  删除用户
     *
     * @param userId
     * @return com.jxkj.common.result.ResultBody
     * @author ysq
     * @date 2020/5/27
     */
    ResultBody deleteById(Long userId);

    /**
     * 功能描述  重新激活用户
     *
     * @param userId
     * @return com.jxkj.common.result.ResultBody
     * @author ysq
     * @date 2020/5/27
     */
    ResultBody activation(Long userId);

    /**
     * 功能描述 分页查询所有用户
     *
     * @return com.jxkj.common.result.ResultBody
     * @author ysq
     * @Param []
     * @date 2020/5/28
     */
    ResultBody selectAll(Long current, Long size);

    /**
     * 功能描述  添加博客并积分
     *
     * @return com.jxkj.common.result.ResultBody
     * @author ysq
     * @Param [blogInfo 博客内容, tagIds 标签id , typeId 类型id, userId 用户id]
     * @date 2020/5/29
     */
    ResultBody saveBlogInfo(BlogInfoAndTagForm blogInfoAndTagForm, Long typeId, Long userId);

    /**
     * 功能描述: 通过过滤标签名字进行博客的保存
     *
     * @param blogInfoAndTagForm
     * @param typeId
     * @param userId
     * @return com.jxkj.common.result.ResultBody
     * @Author wcx
     **/
    ResultBody saveBlogInfoByTagNames(BlogInfoAndTagForm blogInfoAndTagForm, Long typeId, Long userId);

    /**
     * 功能描述  删除博客并减分
     *
     * @return com.jxkj.common.result.ResultBody
     * @author ysq
     * @Param [userId, blogId]
     * @date 2020/6/4
     */
    ResultBody deleteBlogInfoById(Long userId, Long blogId);

    /**
     * 功能描述 查询用户详细信息
     *
     * @return com.jxkj.common.result.ResultBody
     * @author ysq
     * @Param [userId]
     * @date 2020/5/30
     */
    ResultBody selectUserInfoById(Long userId);
}
