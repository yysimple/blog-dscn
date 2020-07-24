package com.jxkj.sms.service;


import com.jxkj.common.result.ResultBody;
import com.jxkj.sms.form.CheckCodeForm;

/**
 * 功能描述：
 * 修改日志：
 * - 2020/1/12, 3:48 吴呈兴 创建
 *
 * @author 吴呈兴
 * @version 1.0.0.RELEASE
 */
public interface ShortMessageService {

    /**
     * 功能描述: 验证码，用于DSCN用户注册
     *
     * @param phone
     * @return cn.jxwxkj.bean.ResultBody
     * @Author 吴呈兴
     **/
    ResultBody sendToDSCNRegister(String phone);

    /**
     * 功能描述: 校验验证码
     * @author WuChengxing
     * @date 2020/7/24
     * @param checkCodeForm
     * @return com.jxkj.common.result.ResultBody
     */
    ResultBody checkCode(CheckCodeForm checkCodeForm);

    /**
     * 功能描述: 验证码，用于DSCN用户注册
     *
     * @param phone
     * @return cn.jxwxkj.bean.ResultBody
     * @Author 吴呈兴
     **/
    ResultBody sendToDSCNRegisterTest(String phone);

    /**
     * 功能描述: 校验验证码
     * @author WuChengxing
     * @date 2020/7/24
     * @param checkCodeForm
     * @return com.jxkj.common.result.ResultBody
     */
    ResultBody checkCodeTest(CheckCodeForm checkCodeForm);
}
