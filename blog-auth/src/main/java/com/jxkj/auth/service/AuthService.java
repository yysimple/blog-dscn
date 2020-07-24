package com.jxkj.auth.service;

import com.jxkj.auth.form.UserInfoForm;
import com.jxkj.common.result.ResultBody;

/**
 * 项目: blog-dscn
 * <p>
 * 功能描述: 授权接口
 *
 * @author: WuChengXing
 * @create: 2020-07-24 20:18
 **/
public interface AuthService {

    /**
     * 功能描述: 登录接口
     * @author WuChengxing
     * @date 2020/7/24
     * @param userInfoForm
     * @return com.jxkj.common.result.ResultBody
     */
    ResultBody login(UserInfoForm userInfoForm);

    /**
     * 功能描述: 微博登录
     * @author WuChengxing
     * @date 2020/7/24
     * @param
     * @return com.jxkj.common.result.ResultBody
     */
    ResultBody webLogin();

    /**
     * 功能描述: github登录
     * @author WuChengxing
     * @date 2020/7/24
     * @param
     * @return com.jxkj.common.result.ResultBody
     */
    ResultBody gitHubLogin();
}
