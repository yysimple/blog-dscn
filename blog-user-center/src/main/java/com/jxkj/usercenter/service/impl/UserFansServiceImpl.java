package com.jxkj.usercenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.usercenter.entity.UserFans;
import com.jxkj.usercenter.mapper.UserFansMapper;
import com.jxkj.usercenter.service.IUserFansService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户粉丝表 服务实现类
 * </p>
 *
 * @author GuJunBin
 * @since 2020-06-21
 */
@Service
public class UserFansServiceImpl extends ServiceImpl<UserFansMapper, UserFans> implements IUserFansService {

    @Autowired
    private UserFansMapper userFansMapper;

    @Override
    public ResultBody getUserAllFans(Long userId) {
        QueryWrapper<UserFans> queryWrapper = Wrappers.query();
        queryWrapper.eq("user_id", userId);
        long countFans = userFansMapper.selectList(queryWrapper).stream().count();
        return ResultBodyUtil.success(countFans);
    }
}
