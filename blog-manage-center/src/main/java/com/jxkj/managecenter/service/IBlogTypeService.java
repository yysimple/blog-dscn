package com.jxkj.managecenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxkj.common.result.ResultBody;
import com.jxkj.managecenter.entity.BlogType;

/**
 * <p>
 * 博客类型表 服务类
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
public interface IBlogTypeService extends IService<BlogType> {

    ResultBody saveOrUpdateType(BlogType blogType);
}
