package com.jxkj.auth.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 项目: blog-dscn
 * <p>
 * 功能描述: 微博登录的基本信息
 *
 * @author: WuChengXing
 * @create: 2020-07-27 08:55
 **/
@Data
@ConfigurationProperties(prefix = "oauth2.weibo")
@Component
public class WeiboLoginProperties {
    /**
     * 微博客户端id
     */
    private String clientId;

    /**
     * 微博
     */
    private String clientSecret;

    /**
     * 授权类型
     */
    private String grantType;

    /**
     * 微博里面的授权回调地址
     */
    private String redirectUri;
}
