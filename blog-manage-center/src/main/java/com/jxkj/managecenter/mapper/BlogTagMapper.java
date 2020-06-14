package com.jxkj.managecenter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxkj.managecenter.entity.BlogTag;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 博客标签表 Mapper 接口
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
@Repository
public interface BlogTagMapper extends BaseMapper<BlogTag> {

    /**
     * 功能描述: 保存博客信息，并主键回填
     *
     * @Author wcx
     * @param blogTag
     * @return void
     **/
    void saveBlogTag(BlogTag blogTag);

    /**
     * 功能描述: 通过标签名查找对应的博客标签对象
     *
     * @Author wcx
     * @param tagName
     * @return com.jxkj.managecenter.entity.BlogTag
     **/
    BlogTag findBlogTagByTagName(String tagName);
}
