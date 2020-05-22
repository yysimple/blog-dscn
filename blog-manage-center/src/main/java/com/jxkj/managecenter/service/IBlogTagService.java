package com.jxkj.managecenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxkj.managecenter.entity.BlogTag;

/**
 * <p>
 * 博客所属类别表 服务类
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
public interface IBlogTagService extends IService<BlogTag> {

    Boolean existTagName(BlogTag blogTag);
}
