package com.jxkj.managecenter.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 功能描述:
 *
 * @Author GuJunBin
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_blog_like_user")
@ApiModel(value="BlogLikeUser对象", description="博客点赞用户表")
public class BlogLikeUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id")
    @ApiModelProperty(value = "表id")
    private Long id;

    @ApiModelProperty(value = "博客id")
    private Long blogId;

    @ApiModelProperty(value = "用户id")
    private Long userId;

}
