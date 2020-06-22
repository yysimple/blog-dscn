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
     * 功能描述: 点赞或取消点赞
     *
     * @param id
     * @param userId
     * @return com.jxkj.common.result.ResultBody
     * @author GuJunBin
     */
    ResultBody addLikeNum(Long id, Long userId);

    /**
     * 功能描述: 访问
     *
     * @param id
     * @return com.jxkj.common.result.ResultBody
     * @author GuJunBin
     */
    ResultBody addViewNum(Long id);

    /**
     * 功能描述: 收藏或取消收藏
     *
     * @param blogId
     * @param userId
     * @param favoritesId
     * @return com.jxkj.common.result.ResultBody
     * @author GuJunBin
     */
    ResultBody favorites(Long blogId, Long userId, Long favoritesId);

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
     * 功能描述: 保存博客信息，重写保存方法，用于判断数据库是否存在重名tagName
     *
     * @param blogInfo
     * @param categoryNames
     * @param tagNames
     * @param typeId
     * @return com.jxkj.common.result.ResultBody
     * @Author wcx
     **/
    ResultBody saveBlogInfo(BlogInfo blogInfo, String[] categoryNames, String[] tagNames, Long typeId);

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
     * @param
     * @return com.jxkj.common.result.ResultBody
     * @author GuJunBin
     */
    ResultBody listOrderByViewNum();

    /**
     * 功能描述: 查询最近发布的 N 条博客
     *
     * @param number
     * @return com.jxkj.common.result.ResultBody
     * @Author wcx
     **/
    ResultBody findRecentlyTopNumberBlogInfo(Integer number);

    /**
     * 功能描述: 查询对应用户最近发布的 N 条博客
     *
     * @param number
     * @param userId
     * @return com.jxkj.common.result.ResultBody
     * @Author wcx
     **/
    ResultBody findRecentlyTopNumberBlogInfoByUserId(Integer number, Long userId);

    /**
     * 功能描述: 查询最早发布的几条博客
     *
     * @param number
     * @return com.jxkj.common.result.ResultBody
     * @Author wcx
     **/
    ResultBody findOldTopNumberBlogInfo(Integer number);
}
