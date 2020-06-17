package com.jxkj.managecenter.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jxkj.managecenter.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

import java.util.Date;
import java.io.Serializable;

/**
 * 分类专栏(TCategoryColumn)实体类
 *
 * @author makejava
 * @since 2020-06-12 23:14:37
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_category_column")
@Alias("categoryColumn")
@ApiModel(value="分类专栏", description="分类专栏")
public class CategoryColumn extends BaseEntity {

    private String categoryName;

    private Long tUserId;

}