package com.jxkj.blogresource.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_resource_type")
@ApiModel(value="ResourceType对象", description="资源类型")
public class ResourceType implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "类型ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "资源类型名")
    private String typeName;

    @ApiModelProperty(value = "父分类ID")
    private Long parentId;

    @ApiModelProperty(value = "层级")
    private Integer typeLevel;

    @ApiModelProperty(value = "删除状态，0-未删除，1-已删除")
    private Integer deleteStatus;


}
