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
     * @Author wcx
     * @param userId
     * @return com.jxkj.common.result.ResultBody
     **/
    ResultBody getUserAllFans(Long userId);
}
