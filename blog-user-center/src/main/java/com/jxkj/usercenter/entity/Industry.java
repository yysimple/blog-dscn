package com.jxkj.usercenter.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.jxkj.usercenter.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

/**
 * <p>
 * 行业表
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_industry")
@Alias("industry")
@ApiModel(value="Industry对象", description="行业表")
public class Industry extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "行业编号")
    private String industryNo;

    @ApiModelProperty(value = "行业名称")
    private String industryName;
}
