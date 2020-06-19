package com.jxkj.managecenter.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_blog_info_category")
@ApiModel(value="关联对象", description="关联对象")
public class BlogInfoCategory implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long tBlogInfoId;

    private Long tCategoryColumnId;
}
