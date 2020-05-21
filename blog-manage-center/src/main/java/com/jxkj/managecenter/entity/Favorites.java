package com.jxkj.managecenter.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jxkj.managecenter.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * <p>
 * 收藏夹表
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
@Data
@Alias("favorites")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_favorites")
@ApiModel(value="Favorites对象", description="收藏夹表")
public class Favorites extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "收藏夹名称")
    private String favoritesName;

    @ApiModelProperty(value = "收藏夹关注数")
    private Integer followers;

    @ApiModelProperty(value = "收藏夹的状态，0为公开，1为私密")
    private Integer showStatus;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "收藏夹对应的用户id")
    private Long tUserId;


}
