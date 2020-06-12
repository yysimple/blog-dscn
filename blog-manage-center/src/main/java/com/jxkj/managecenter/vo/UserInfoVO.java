package com.jxkj.managecenter.vo;

import com.jxkj.managecenter.vo.base.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 功能描述:
 * 修改：抽离公共字段，增加头像字段
 *
 * @Author GuJunBin
 * @Version 1.0
 */
@Data
public class UserInfoVO extends BaseVO implements Serializable {

    private String avatarUrl;

    @ApiModelProperty(value = "真实姓名")
    private String realName;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "出生日期")
    private LocalDateTime birthday;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "手机号")
    private String phoneNumber;

    @ApiModelProperty(value = "性别")
    private String gender;

    @ApiModelProperty(value = "职位")
    private String position;

    @ApiModelProperty(value = "公司")
    private String company;

    @ApiModelProperty(value = "学历")
    private String education;

    @ApiModelProperty(value = "行业")
    private String industry;

    @ApiModelProperty(value = "开始工作时间")
    private LocalDateTime startWorkingTime;

    @ApiModelProperty(value = "个人简介")
    private String remark;

}
