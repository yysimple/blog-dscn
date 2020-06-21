package com.jxkj.usercenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.usercenter.entity.UserFans;
import com.jxkj.usercenter.entity.UserLevel;
import com.jxkj.usercenter.mapper.UserFansMapper;
import com.jxkj.usercenter.mapper.UserLevelMapper;
import com.jxkj.usercenter.service.IUserLevelService;
import com.jxkj.usercenter.service.UserStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
@Service
public class UserStatisticsServiceImpl implements UserStatisticsService {

    @Autowired
    private UserFansMapper userFansMapper;

    @Autowired
    private IUserLevelService userLevelService;

    @Autowired
    private UserLevelMapper userLevelMapper;

    @Override
    public ResultBody userAllStatistics(Long userId) {
        QueryWrapper<UserFans> queryWrapper = Wrappers.query();
        queryWrapper.eq("user_id", userId);
        long countFans = userFansMapper.selectList(queryWrapper).stream().count();
        UserLevel userLevel = userLevelMapper.findLevelByUserId(userId);
        Integer score = userLevel.getScore();
        Map<String, Object> map = new ConcurrentHashMap<>(16);
        map.put("countFans", countFans);
        map.put("score", score);
        return ResultBodyUtil.success(map);
    }
}
