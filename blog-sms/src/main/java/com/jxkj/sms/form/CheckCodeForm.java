package com.jxkj.sms.form;

import lombok.Data;

/**
 * 项目: blog-dscn
 * <p>
 * 功能描述: 校验验证码
 *
 * @author: WuChengXing
 * @create: 2020-07-24 20:56
 **/
@Data
public class CheckCodeForm {
    /**
     * 验证码
     */
    private String code;

    /**
     * 手机号
     */
    private String phone;
}
