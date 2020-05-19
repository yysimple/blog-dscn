package com.jxkj.usercenter.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 回复表
 * </p>
 *
 * @author gjb
 * @since 2020-05-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_reply")
@ApiModel(value="Reply对象", description="回复表")
public class Reply implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "回复内容")
    private String content;

    @ApiModelProperty(value = "回复类型，区分是回复评论，还是回复的回复(comment,reply)")
    private String replyType;

    @ApiModelProperty(value = "评论的id")
    private Long tCommentId;

    private Long tReplyId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    @ApiModelProperty(value = "删除状态，0为真实删除，1为假删")
    private Integer deleteStatus;

    @ApiModelProperty(value = "该条评论的回复用户id")
    private Long replyUserId;


}
