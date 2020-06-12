package com.jxkj.managecenter.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.jxkj.managecenter.vo.base.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
@Data
public class UserVO extends BaseVO {

    private String username;

    private String password;

    private UserInfoVO userInfo;
}
