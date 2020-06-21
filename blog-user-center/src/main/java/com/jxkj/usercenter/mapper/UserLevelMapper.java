package com.jxkj.usercenter.mapper;

import com.jxkj.usercenter.entity.UserLevel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户等级表 Mapper 接口
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-20
 */
@Repository
public interface UserLevelMapper extends BaseMapper<UserLevel> {

    /**
     * 功能描述: 通过用户id查找用户等级信息
     *
     * @Author wcx
     * @param userId
     * @return com.jxkj.usercenter.entity.UserLevel
     **/
    UserLevel findLevelByUserId(Long userId);
}
