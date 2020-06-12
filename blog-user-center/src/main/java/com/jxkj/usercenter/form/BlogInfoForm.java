package com.jxkj.usercenter.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author ysq
 * @description
 * @date 2020/6/4
 */
@Data
@ApiModel(value = "用户注册")
public class BlogInfoForm {

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

    @ApiModelProperty(value = "用户id")
    private Long tUserId;

    @ApiModelProperty(value = "博客状态，0为草稿，1为发布")
    private Integer blogStatus;

}
