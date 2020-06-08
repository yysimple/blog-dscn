package com.jxkj.blogresource.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

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
@ApiModel(value = "ResourceType对象", description = "资源所属类型")
public class ResourceType implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "类型ID", hidden = true)
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "资源所属类型名")
    private String typeName;

    @ApiModelProperty(value = "父分类ID")
    private Long parentId;

    @ApiModelProperty(value = "层级")
    private Integer typeLevel;

    @TableLogic
    @ApiModelProperty(value = "删除状态，0-未删除，1-已删除", hidden = true)
    private Integer deleteStatus;

    @ApiModelProperty(value = "子分类",hidden = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @TableField(exist = false)
    private List<ResourceType> children;

}
