package com.jxkj.managecenter.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jxkj.managecenter.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 博客所属类别表
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_blog_classification")
@ApiModel(value="BlogClassification对象", description="博客所属类别表")
public class BlogClassification extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "分类名")
    private String classificationName;
}
