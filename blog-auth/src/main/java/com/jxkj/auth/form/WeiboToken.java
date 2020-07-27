package com.jxkj.auth.form;

import lombok.Data;

/**
 * 项目: test-oauth2
 * <p>
 * 功能描述: 微博返回的token信息
 *
 * @author: WuChengXing
 * @create: 2020-07-25 15:49
 **/
@Data
public class WeiboToken {
    /**
     * 微博token信息
     */
    private String access_token;

    /**
     * token过期时间（即将废弃）
     */
    private String remind_in;

    /**
     * token过期时间
     */
    private String expires_in;

    /**
     * 用户的微博唯一id
     */
    private String uid;

    /**
     * 是否实名
     */
    private String isRealName;
}
