package com.jxkj.managecenter.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jxkj.managecenter.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.List;

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
public class BlogInfo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

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

    @ApiModelProperty(value = "博客标签信息", hidden = true)
    @TableField(select = false, exist = false)
    private List<BlogTag> blogTags;

    @ApiModelProperty(value = "博客类型", hidden = true)
    @TableField(select = false, exist = false)
    private BlogType blogType;

    @TableField(select = false, exist = false)
    private List<CategoryColumn> categoryColumns;

    @TableField(select = false, exist = false)
    private List<BlogLikeUser> blogLikeUsers;

    @TableField(select = false, exist = false)
    private List<Favorites> favorites;


}
