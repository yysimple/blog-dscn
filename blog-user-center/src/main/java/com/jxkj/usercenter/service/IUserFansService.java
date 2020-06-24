package com.jxkj.usercenter.service;

import com.jxkj.common.result.ResultBody;
import com.jxkj.usercenter.entity.UserFans;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户粉丝表 服务类
 * </p>
 *
 * @author GuJunBin
 * @since 2020-06-21
 */
public interface IUserFansService extends IService<UserFans> {

    /**
     * 功能描述: 获取对应用户的所有粉丝数
     *
     * @param userId
     * @return com.jxkj.common.result.ResultBody
     * @Author wcx
     **/
    ResultBody getUserAllFans(Long userId);

    /**
     * 功能描述: 关注用户
     *
     * @param userId
     * @param fanId
     * @return com.jxkj.common.result.ResultBody
     * @Author wcx
     **/
    ResultBody attention(Long userId, Long fanId);

    /**
     * 功能描述: 获取两个用户之间关注关系
     *
     * @param userId
     * @param fanId
     * @return com.jxkj.common.result.ResultBody
     * @Author wcx
     **/
    ResultBody getAttentionStatus(Long userId, Long fanId);
}
