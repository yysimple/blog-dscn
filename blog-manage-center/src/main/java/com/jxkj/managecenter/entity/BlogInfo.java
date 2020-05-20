package com.jxkj.managecenter.entity;

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
 * 博客基本信息表
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_blog_info")
@ApiModel(value="BlogInfo对象", description="博客基本信息表")
public class BlogInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "博客id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "博客标题")
    private String title;

    @ApiModelProperty(value = "博客内容")
    private String content;

    @ApiModelProperty(value = "博客浏览数")
    private Integer pageViewNum;

    @ApiModelProperty(value = "点赞数")
    private Integer likeNum;

    private String blogLinkUrl;

    @ApiModelProperty(value = "关联收藏夹id")
    private Long tFavoritesId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    @ApiModelProperty(value = "删除状态，0为真实删除，1为假删")
    private Integer deleteStatus;

    @ApiModelProperty(value = "用户id")
    private Long tUserId;


}