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
 * 回复表
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_reply")
@ApiModel(value="Reply对象", description="回复表")
public class Reply extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "回复内容")
    private String content;

    @ApiModelProperty(value = "回复类型，区分是回复评论，还是回复的回复(comment,reply)")
    private String replyType;

    @ApiModelProperty(value = "评论的id")
    private Long tCommentId;

    private Long tReplyId;

    @ApiModelProperty(value = "该条评论的回复用户id")
    private Long replyUserId;


}
