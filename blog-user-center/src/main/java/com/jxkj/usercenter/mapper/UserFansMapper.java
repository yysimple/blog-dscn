package com.jxkj.usercenter.mapper;

import com.jxkj.usercenter.entity.UserFans;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户粉丝表 Mapper 接口
 * </p>
 *
 * @author GuJunBin
 * @since 2020-06-21
 */
@Repository
public interface UserFansMapper extends BaseMapper<UserFans> {

    /**
     * 功能描述: 关注用户
     *
     * @param userId
     * @param fanId
     * @return com.jxkj.usercenter.entity.UserFans
     * @Author wcx
     **/
    UserFans attention(@Param("userId") Long userId, @Param("fanId") Long fanId);
}
