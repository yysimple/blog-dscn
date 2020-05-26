package com.jxkj.usercenter.form;

import com.jxkj.usercenter.entity.User;
import com.jxkj.usercenter.entity.UserInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author ysq
 * @description 用户注册form
 * @date 2020/5/26
 */
@Data
@ApiModel(value = "用户注册")
public class UserForm {
    @ApiModelProperty(value = "账号密码")
    private User user;

    @ApiModelProperty(value = "详细信息")
    private UserInfo userInfo;
}
