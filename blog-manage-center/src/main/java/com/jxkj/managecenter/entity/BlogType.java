package com.jxkj.managecenter.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jxkj.managecenter.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * <p>
 * 博客类型表
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Alias("blogType")
@TableName("t_blog_type")
@ApiModel(value="BlogType对象", description="博客类型表")
public class BlogType extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "博客类型")
    private String type;

    private Integer status;
}
