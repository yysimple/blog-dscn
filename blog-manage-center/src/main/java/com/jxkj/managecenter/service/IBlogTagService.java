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


    /**
     * 功能描述: 新增or更新博客标签
     *
     * @param blogTag
     * @return com.jxkj.common.result.ResultBody
     * @author GuJunBin
     */
    ResultBody saveOrUpdateBlogTag(BlogTag blogTag);

    /**
     * 功能描述: 删除标签
     *
     * @param id
     * @return com.jxkj.common.result.ResultBody
     * @author GuJunBin
     */
    ResultBody deleteById(Long id);

    /**
     * 功能描述: 根据标签id查询所有的博客
     *
     * @Author wcx
     * @param tagId
     * @param number
     * @return com.jxkj.common.result.ResultBody
     **/
    ResultBody findPVTopNBlogByTagId(Long tagId, Integer number);

    /**
     * 功能描述: 根据标签名查询对应的标签
     *
     * @Author wcx
     * @param tagName
     * @return com.jxkj.common.result.ResultBody
     **/
    ResultBody findBlogTagNyName(String tagName);
}
