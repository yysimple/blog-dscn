package com.jxkj.usercenter.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

/**
 * <p>
 * 用户粉丝表
 * </p>
 *
 * @author GuJunBin
 * @since 2020-06-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user_fans")
@Alias("userFans")
@ApiModel(value="UserFans对象", description="用户粉丝表")
public class UserFans implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long userId;

    private Long fanId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    /**
     * 关注的状态，1为关注，0为取消关注
     */
    private Integer status;


}
