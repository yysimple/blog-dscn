package com.jxkj.managecenter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxkj.managecenter.entity.BlogInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 博客基本信息表 Mapper 接口
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
@Repository
public interface BlogInfoMapper extends BaseMapper<BlogInfo> {

    /**
     * 功能描述: 插入博客信息并回填主键id
     *
     * @param blogInfo
     * @return void
     * @author GuJunBin
     */
    void insertBlogInfo(BlogInfo blogInfo);

    /**
     * 功能描述
     *
     * @param blogId
     * @return com.jxkj.managecenter.entity.BlogInfo
     * @author ysq
     * @date 2020/5/27
     */
    BlogInfo findBlogInfoAndTagsByBlogInfoId(Long blogId);

    /**
     * 功能描述: 通过用户id查询其对应所有的详细博客信息
     *
     * @param userId
     * @return java.util.List<com.jxkj.managecenter.entity.BlogInfo>
     * @Author wcx
     **/
    List<BlogInfo> findAllBlogByUserId(Long userId);

    /**
     * 功能描述: 彻底删除博客信息
     *
     * @param id
     * @return void
     * @author GuJunBin
     */
    void deleteInfoById(Long id);

    /**
     * 功能描述: 查询一周内访问量最高的10条博客并排序
     *
     * @param
     * @return void
     * @author GuJunBin
     */
    List<BlogInfo> selectListOrderByViewNum();

    /**
     * 功能描述: 查询每篇博客的详细信息
     *
     * @param
     * @return java.util.List<com.jxkj.managecenter.entity.BlogInfo>
     * @Author wcx
     **/
    List<BlogInfo> findAllBlogDetails();

    /**
     * 功能描述: 查询最近发布的 N 条博客
     *
     * @param number
     * @return java.util.List<com.jxkj.managecenter.entity.BlogInfo>
     * @Author wcx
     **/
    List<BlogInfo> findRecentlyTopNumberBlogInfo(Integer number);

    /**
     * 功能描述: 查询对应用户最近发布的 N 条博客
     *
     * @param number
     * @param userId
     * @return java.util.List<com.jxkj.managecenter.entity.BlogInfo>
     * @Author wcx
     **/
    List<BlogInfo> findRecentlyTopNumberBlogInfoByUserId(@Param("number") Integer number, @Param("userId") Long userId);

    /**
     * 功能描述: 查询最早发布的几条博客
     *
     * @param number
     * @return java.util.List<com.jxkj.managecenter.entity.BlogInfo>
     * @Author wcx
     **/
    List<BlogInfo> findOldTopNumberBlogInfo(Integer number);

    /**
     * 功能描述: 查询相应用户最早发布的几条博客
     *
     * @param number
     * @param userId
     * @return java.util.List<com.jxkj.managecenter.entity.BlogInfo>
     * @Author wcx
     **/
    List<BlogInfo> findOldTopNumberBlogInfoByUserId(@Param("number") Integer number, @Param("userId") Long userId);

    /**
     * 功能描述: 查询该用户最早发布的一条博客
     *
     * @param userId
     * @return com.jxkj.managecenter.entity.BlogInfo
     * @Author wcx
     **/
    BlogInfo findOldOneBlog(Long userId);

    /**
     * 功能描述: 查询该用户最新发布的一条博客
     *
     * @param userId
     * @return com.jxkj.managecenter.entity.BlogInfo
     * @Author wcx
     **/
    BlogInfo findRecentlyOneBlog(Long userId);

    /**
     * 功能描述: 统计当月时间该用户发布博客的数量
     *
     * @param date
     * @param userId
     * @return java.lang.Integer
     * @Author wcx
     **/
    Integer countBlogNumberByUserId(@Param("date") String date, @Param("userId") Long userId);

    /**
     * 功能描述: 查询对应用户访问量最高的几篇博客
     *
     * @param number
     * @param userId
     * @return java.util.List<com.jxkj.managecenter.entity.BlogInfo>
     * @Author wcx
     **/
    List<BlogInfo> findTopNumberPageViewByUserId(@Param("number") Integer number, @Param("userId") Long userId);

    /**
     * 功能描述: 根据博客的标签id查询所有博客
     * @author WuChengxing
     * @date 2020/7/23
     * @param blogTagId
     * @return java.util.List<com.jxkj.managecenter.entity.BlogInfo>
     */
    List<BlogInfo> listBlogInfoByBlogTagId(Long blogTagId);
}
