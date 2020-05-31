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
import java.time.LocalDateTime;

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
@TableName("t_resource")
@ApiModel(value="Resource对象", description="资源表单")
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "资源 ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "资源文件路径")
    private String fileUrl;

    @ApiModelProperty(value = "资源名")
    private String resourceName;

    @ApiModelProperty(value = "所属分类ID")
    private Long typeId;

    @ApiModelProperty(value = "所需积分")
    private Integer integral;

    @ApiModelProperty(value = "资源标签")
    private String tag;

    @ApiModelProperty(value = "资源描述")
    private String message;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    @ApiModelProperty(value = "删除状态，0-未删除，1-已删除")
    private Integer deleteStatus;


}
