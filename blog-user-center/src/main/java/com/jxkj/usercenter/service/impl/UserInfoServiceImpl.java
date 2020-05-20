package com.jxkj.usercenter.service.impl;

import com.jxkj.usercenter.entity.UserInfo;
import com.jxkj.usercenter.mapper.UserInfoMapper;
import com.jxkj.usercenter.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户详细信息 服务实现类
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-20
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
