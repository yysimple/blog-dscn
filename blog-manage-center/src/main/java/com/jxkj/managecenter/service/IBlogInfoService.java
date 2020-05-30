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
     * @param
     * @return com.jxkj.common.result.ResultBody
     * @author GuJunBin
     */
    ResultBody pagingQuery();

    /**
     * 功能描述: 查询用户所有已发布博客信息
     *
     * @param userId
     * @return com.jxkj.common.result.ResultBody
     * @author GuJunBin
     */
    ResultBody listUserBlog(Long userId);

    /**
     * 功能描述: 分页查询用户所有已发布博客信息
     *
     * @param userId
     * @return com.jxkj.common.result.ResultBody
     * @author GuJunBin
     */
    ResultBody listPageUserBlog(Long userId);

    /**
     * 功能描述: 根据标题和文章内容模糊查询发布博客信息
     *
     * @param key
     * @return com.jxkj.common.result.ResultBody
     * @author GuJunBin
     */
    ResultBody findIssueBlog(String key);

    /**
     * 功能描述: 点赞
     *
     * @param id
     * @return com.jxkj.common.result.ResultBody
     * @author GuJunBin
     */
    ResultBody addLikeNum(Long id);

    /**
     * 功能描述: 访问
     *
     * @author GuJunBin
     * @param id
     * @return com.jxkj.common.result.ResultBody
     */
    ResultBody addViewNum(Long id);

    /**
     * 功能描述: 收藏
     *
     * @param blogId
     * @param favoritesId
     * @param userId
     * @return com.jxkj.common.result.ResultBody
     * @author GuJunBin
     */
    ResultBody favorites(Long blogId, Long favoritesId, Long userId);

    /**
     * 功能描述: 保存博客信息
     *
     * @param blogInfo 博客信息
     * @param tagIds   标签Id
     * @param typeId   类型Id
     * @return com.jxkj.common.result.ResultBody
     * @author GuJunBin
     */
    ResultBody saveBlogInfo(BlogInfo blogInfo, Long[] tagIds, Long typeId);

    /**
     * 功能描述: 更新博客信息
     *
     * @param blogInfo
     * @param tagIds
     * @return com.jxkj.common.result.ResultBody
     * @author GuJunBin
     */
    ResultBody updateBlogInfo(BlogInfo blogInfo, Long[] tagIds, Long typeId);

    /**
     * 功能描述 查询博客和标签信息
     *
     * @param blogId
     * @return com.jxkj.common.result.ResultBody
     * @author ysq
     * @date 2020/5/27
     */
    ResultBody findBlogInfoAndTagsByBlogInfoId(Long blogId);

    /**
     * 功能描述: 回收已删除博客信息
     *
     * @param id
     * @return com.jxkj.common.result.ResultBody
     * @author GuJunBin
     */
    ResultBody recoverBlogInfoById(Long id);

    /**
     * 功能描述: 分页查询已删除博客信息
     *
     * @param
     * @return com.jxkj.common.result.ResultBody
     * @author GuJunBin
     */
    ResultBody findAllDeletedBlog();

    /**
     * 功能描述: 彻底删除博客信息
     *
     * @param id
     * @return com.jxkj.common.result.ResultBody
     * @author GuJunBin
     */
    ResultBody removeBlogInfoById(Long id);

    /**
     * 功能描述: 查询访问量最高的10条博客并排序
     *
     * @author GuJunBin
     * @param
     * @return com.jxkj.common.result.ResultBody
     */
    ResultBody listOrderByViewNum();
}
