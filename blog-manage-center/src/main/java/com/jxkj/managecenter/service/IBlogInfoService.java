package com.jxkj.managecenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxkj.common.result.ResultBody;
import com.jxkj.managecenter.entity.BlogInfo;

/**
 * <p>
 * 博客基本信息表 服务类
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
public interface IBlogInfoService extends IService<BlogInfo> {


    /**
     * 功能描述: 分页查询所有已发布博客信息
     *
     * @author GuJunBin
     * @param
     * @return com.jxkj.common.result.ResultBody
     */
    ResultBody pagingQuery();

    /**
     * 功能描述: 根据标题和文章内容模糊查询发布博客信息
     * 
     * @author GuJunBin
     * @param key 
     * @return com.jxkj.common.result.ResultBody
     */
    ResultBody findIssueBlog(String key);

    /**
     * 功能描述: 点赞
     *
     * @author GuJunBin
     * @param id
     * @return com.jxkj.common.result.ResultBody
     */
    ResultBody addLikeNum(Long id);

    /**
     * 功能描述: 收藏
     *
     * @author GuJunBin
     * @param blogId
	 * @param favoritesId
	 * @param userId
     * @return com.jxkj.common.result.ResultBody
     */
    ResultBody favorites(Long blogId, Long favoritesId, Long userId);

    /**
     * 功能描述: 保存博客信息
     *
     * @author GuJunBin
     * @param blogInfo 博客信息
	 * @param tagIds  标签Id
     * @param typeId  类型Id
     * @return com.jxkj.common.result.ResultBody
     */
    ResultBody saveBlogInfo(BlogInfo blogInfo, Long[] tagIds, Long typeId);

    /**
     * 功能描述: 更新博客信息
     *
     * @author GuJunBin
     * @param blogInfo
	 * @param tagIds
     * @return com.jxkj.common.result.ResultBody
     */
    ResultBody updateBlogInfo(BlogInfo blogInfo, Long[] tagIds, Long typeId);

    /**
     * 功能描述: 删除博客信息
     *
     * @author GuJunBin
     * @param id
     * @return com.jxkj.common.result.ResultBody
     */
    ResultBody deleteBlogInfo(Long id);
}
