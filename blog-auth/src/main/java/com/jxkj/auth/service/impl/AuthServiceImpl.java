package com.jxkj.auth.service.impl;

import com.jxkj.auth.form.UserInfoForm;
import com.jxkj.auth.service.AuthService;
import com.jxkj.common.result.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

    @Override
    public ResultBody login(UserInfoForm userInfoForm) {
        return null;
    }

    @Override
    public ResultBody webLogin() {
        return null;
    }

    @Override
    public ResultBody gitHubLogin() {
        return null;
    }
}
