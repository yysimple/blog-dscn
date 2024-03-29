package com.jxkj.managecenter.service;

import com.jxkj.common.result.ResultBody;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
public interface StatisticsService {

    /**
     * 功能描述: 统计用户的原创博客、获赞数、访问数
     *
     * @param userId
     * @return com.jxkj.common.result.ResultBody
     * @Author wcx
     **/
    ResultBody allStatistics(Long userId);

    /**
     * 功能描述: 统计改用户下的博客总数
     *
     * @param userId
     * @return com.jxkj.common.result.ResultBody
     * @Author wcx
     **/
    ResultBody countBlogNumber(Long userId);

    /**
     * 功能描述: 用于图表统计
     *
     * @param
     * @return com.jxkj.common.result.ResultBody
     * @Author wcx
     **/
    ResultBody countForChart();

    /**
     * 功能描述: 根据用户id查询访问数，用于展示图表
     *
     * @Author wcx
     * @param userId
     * @return com.jxkj.common.result.ResultBody
     **/
    ResultBody countPageViewForChart(Long userId);

    /**
     * 功能描述: 统计单篇博客
     *
     * @param blogId
     * @return com.jxkj.common.result.ResultBody
     * @Author wcx
     **/
    ResultBody getOneBlogStatistics(Long blogId);

    /**
     * 功能描述: 博客归档
     *
     * @param userId
     * @return com.jxkj.common.result.ResultBody
     * @Author wcx
     **/
    ResultBody countBlogArchive(Long userId);

    /**
     * 功能描述: 统计每个收藏夹下有多少篇博客
     *
     * @param favoriteId
     * @return com.jxkj.common.result.ResultBody
     * @Author wcx
     **/
    ResultBody countBlogNumberInFavorites(Long favoriteId);

    /**
     * 功能描述: 统计博客文章管理模块需要的数据
     *
     * @Author wcx
     * @param userId
     * @return com.jxkj.common.result.ResultBody
     **/
    ResultBody countForBlogManage(Long userId);

    /**
     * 功能描述: 统计单篇博客的数据
     *
     * @Author wcx
     * @param blogId
     * @return com.jxkj.common.result.ResultBody
     **/
    ResultBody countForOneBlog(Long blogId);

    /**
     * 功能描述: 使用redis原生锁和Lua脚本进行锁操作
     * @author 吴呈兴
     * @date 2020/7/17
     * @param
     * @return com.jxkj.common.result.ResultBody
     */
    ResultBody findAllBlogDetailsByRedisLock();

    /**
     * 功能描述: 使用分布式锁框架Redisson进行锁操作
     * @author 吴呈兴
     * @date 2020/7/17
     * @param
     * @return com.jxkj.common.result.ResultBody
     */
    ResultBody findAllBlogDetailsByRedisson();
}
