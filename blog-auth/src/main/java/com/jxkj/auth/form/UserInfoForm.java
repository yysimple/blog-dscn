package com.jxkj.auth.form;

import lombok.Data;

/**
 * 项目: blog-dscn
 * <p>
 * 功能描述: 用户登录的基本信息
 *
 * @author: WuChengXing
 * @create: 2020-07-24 20:29
 **/
@Data
public class UserInfoForm {
    /**
     * 用户登录的用户名或者手机号
     */
    private String nameAndPhone;

    /**
     * 登录密码
     */
    private String password;
}
