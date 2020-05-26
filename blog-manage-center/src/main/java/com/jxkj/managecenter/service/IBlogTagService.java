package com.jxkj.managecenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxkj.common.result.ResultBody;
import com.jxkj.managecenter.entity.BlogTag;

/**
 * <p>
 * 博客标签表 服务类
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
public interface IBlogTagService extends IService<BlogTag> {


    ResultBody saveOrUpdateBlogTag(BlogTag blogTag);

    /**
     * 功能描述: 删除标签
     *
     * @author GuJunBin
     * @param id
     * @return com.jxkj.common.result.ResultBody
     */
    ResultBody deleteById(Long id);
}
