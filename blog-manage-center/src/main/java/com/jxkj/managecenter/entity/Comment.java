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
 * 评论表
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_comment")
@ApiModel(value="Comment对象", description="评论表")
public class Comment extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评论内容")
    private String content;

    @ApiModelProperty(value = "关联博客id")
    private Long tBlogInfoId;

    @ApiModelProperty(value = "该条评论对应的用户id")
    private Long commentUserId;

}
