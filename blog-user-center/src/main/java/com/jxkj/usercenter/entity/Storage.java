package com.jxkj.usercenter.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 测试分布式锁的库存表
 * </p>
 *
 * @author wcx
 * @since 2020-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_storage")
@ApiModel(value="Storage对象", description="测试分布式锁的库存表")
public class Storage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long productId;

    private Long orderId;

    private Integer total;

    private Integer used;

    private Integer residue;


}
