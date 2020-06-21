package com.jxkj.managecenter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxkj.managecenter.entity.BlogInfo;
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
     * @Author wcx
     * @param userId
     * @return java.util.List<com.jxkj.managecenter.entity.BlogInfo>
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
     * @Author wcx
     * @param
     * @return java.util.List<com.jxkj.managecenter.entity.BlogInfo>
     **/
    List<BlogInfo> findAllBlogDetails();
}
