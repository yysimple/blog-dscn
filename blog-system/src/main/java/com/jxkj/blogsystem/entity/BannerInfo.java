package com.jxkj.blogsystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jxkj.blogsystem.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author ysq
 * @description
 * @date 2020/5/30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "t_banner_info")
@ApiModel(value = "TBannerInfo对象", description = "轮播图表")
public class BannerInfo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "轮播图片")
    private String picture;

    @ApiModelProperty(value = "图片链接地址")
    private String linkUrl;
}
