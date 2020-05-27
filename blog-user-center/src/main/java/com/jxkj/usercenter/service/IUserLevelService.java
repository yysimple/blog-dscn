package com.jxkj.usercenter.service;

import com.jxkj.common.result.ResultBody;
import com.jxkj.usercenter.entity.UserLevel;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户等级表 服务类
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-20
 */
public interface IUserLevelService extends IService<UserLevel> {

    /**
     * 功能描述 增加积分
     * @author ysq
     * @param [userId, integral]
     * @return com.jxkj.common.result.ResultBody
     * @date 2020/5/27
     */
    ResultBody increaseIntegral(Long userId, Integer integral);

    /**
     * 功能描述 查询级别
     * @author ysq
     * @param [userId]
     * @return com.jxkj.common.result.ResultBody
     * @date 2020/5/27
     */
    ResultBody updateLevel(Long userId);

}
