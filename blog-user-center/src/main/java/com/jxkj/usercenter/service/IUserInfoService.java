package com.jxkj.usercenter.service;

import com.jxkj.common.result.ResultBody;
import com.jxkj.usercenter.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户详细信息 服务类
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-20
 */
public interface IUserInfoService extends IService<UserInfo> {

    ResultBody selectById(Long id);

    ResultBody saveMessage(UserInfo userInfo);

    ResultBody update(UserInfo userInfo);

}
