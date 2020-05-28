package com.jxkj.managecenter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxkj.managecenter.entity.BlogInfo;
import org.springframework.stereotype.Repository;

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
     * @author GuJunBin
     * @param blogInfo
     * @return void
     */
    void insertBlogInfo(BlogInfo blogInfo);

    /**
     * 功能描述
     * @author ysq
     * @param blogId
     * @return com.jxkj.managecenter.entity.BlogInfo
     * @date 2020/5/27
     */
    BlogInfo findBlogInfoAndTagsByBlogInfoId(Long blogId);
}
