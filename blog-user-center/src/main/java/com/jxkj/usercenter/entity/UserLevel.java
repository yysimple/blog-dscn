package com.jxkj.usercenter.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.jxkj.usercenter.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户等级表
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user_level")
@ApiModel(value="UserLevel对象", description="用户等级表")
public class UserLevel extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "级别")
    private Integer level;

    @ApiModelProperty(value = "积分数")
    private Integer score;
 
    private Long tUserId;


}
