package com.jxkj.auth.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jxkj.auth.form.UserInfoForm;
import com.jxkj.auth.form.WeiboToken;
import com.jxkj.auth.properties.WeiboLoginProperties;
import com.jxkj.auth.service.AuthService;
import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * 项目: blog-dscn
 * <p>
 * 功能描述: 实现类
 *
 * @author: WuChengXing
 * @create: 2020-07-24 20:34
 **/
@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WeiboLoginProperties weiboLoginProperties;

    @Override
    public ResultBody login(UserInfoForm userInfoForm) {
        return null;
    }

    @Override
    public ResultBody weiboLogin(String code) {
        JSONObject json = new JSONObject();
        String resp =
                restTemplate.postForObject("https://api.weibo.com/oauth2/access_token?client_id="
                                + weiboLoginProperties.getClientId()
                                + "&client_secret="
                                + weiboLoginProperties.getClientSecret()
                                + "&grant_type="
                                + weiboLoginProperties.getGrantType()
                                + "&redirect_uri="
                                + weiboLoginProperties.getRedirectUri()
                                + "&code=" + code,
                        json,
                        String.class);
        WeiboToken weiboToken = JSON.parseObject(resp, WeiboToken.class);
        String token = weiboToken.getAccess_token();
        String uid = weiboToken.getUid();
        Map forObject = restTemplate.getForObject("https://api.weibo.com/2/users/show.json?access_token="
                        + token
                        + "&uid="
                        + uid,
                Map.class);
        JSONObject weiboInfoJson = new JSONObject(forObject);
        return ResultBodyUtil.success(weiboInfoJson);
    }

    @Override
    public ResultBody gitHubLogin() {
        return null;
    }
}
