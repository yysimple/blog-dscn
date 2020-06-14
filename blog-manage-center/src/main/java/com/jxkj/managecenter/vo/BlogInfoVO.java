package com.jxkj.managecenter.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
@Data
public class BlogInfoVO {

    private Long id;

    @ApiModelProperty(value = "创建时间", hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间", hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "博客标题")
    private String title;

    @ApiModelProperty(value = "博客内容")
    private String content;

    @ApiModelProperty(value = "博客浏览数")
    private Integer pageViewNum;

    @ApiModelProperty(value = "点赞数")
    private Integer likeNum;

    @ApiModelProperty(value = "博客URL地址")
    private String blogLinkUrl;

    @ApiModelProperty(value = "用户id")
    private Long tUserId;

    @ApiModelProperty(value = "博客状态，0为草稿，1为发布")
    private Integer blogStatus;
}
