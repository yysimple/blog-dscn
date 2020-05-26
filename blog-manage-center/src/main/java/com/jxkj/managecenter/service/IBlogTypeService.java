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

    /**
     * 功能描述: 保存or更新博客类型 忽略大小写
     *
     * @author GuJunBin
     * @param blogType
     * @return com.jxkj.common.result.ResultBody
     */
    ResultBody saveOrUpdateType(BlogType blogType);

    /**
     * 功能描述: 删除博客类型
     *
     * @author GuJunBin
     * @param id
     * @return com.jxkj.common.result.ResultBody
     */
    ResultBody deleteById(Long id);
}
