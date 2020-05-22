package com.jxkj.managecenter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxkj.managecenter.entity.BlogTag;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 博客所属类别表 Mapper 接口
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
@Repository
public interface BlogTagMapper extends BaseMapper<BlogTag> {

    List<String> getTagName();
}
