package com.jxkj.usercenter.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.jxkj.usercenter.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user")
@ApiModel(value="User对象", description="用户表")
public class  User extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户名")
    @NotNull(message = "请输入用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    @NotNull(message = "请输入密码")
    private String password;

    @ApiModelProperty(value = "用户详细信息")
    private UserInfo userInfo;

}
