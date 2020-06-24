package com.jxkj.managecenter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxkj.managecenter.entity.BlogLikeUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 功能描述:
 *
 * @Author GuJunBin
 * @Version 1.0
 */
@Repository
public interface BlogLikeUserMapper extends BaseMapper<BlogLikeUser> {

    /**
     * 功能描述: 查询用户是否已经点赞
     *
     * @param blogId
     * @param userId
     * @return com.jxkj.managecenter.entity.BlogLikeUser
     * @Author wcx
     **/
    BlogLikeUser filterIsLike(@Param("blogId") Long blogId, @Param("userId") Long userId);
}
