package com.jxkj.usercenter.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jxkj.usercenter.base.entity.BaseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 用户详细信息
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user_info")
@Alias("userInfo")
@ApiModel(value="UserInfo对象", description="用户详细信息")
public class UserInfo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "真实姓名")
    private String realName;

    @ApiModelProperty(value = "头像")
    private String avatarUrl;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "出生日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "手机号")
    private String phoneNumber;

    @ApiModelProperty(value = "性别")
    @Length(max = 5)
    private String gender;

    @ApiModelProperty(value = "职位")
    private String position;

    @ApiModelProperty(value = "公司")
    private String company;

    @ApiModelProperty(value = "学历")
    private String education;

    @ApiModelProperty(value = "行业")
    private String industry;

    @ApiModelProperty(value = "学校")
    private String school;

    @ApiModelProperty(value = "开始工作时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startWorkingTime;

    @ApiModelProperty(value = "个人简介")
    private String remark;

    private Long tUserId;

}
