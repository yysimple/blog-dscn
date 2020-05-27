package com.jxkj.usercenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.common.result.ResultTypeEnum;
import com.jxkj.usercenter.entity.UserLevel;
import com.jxkj.usercenter.mapper.UserLevelMapper;
import com.jxkj.usercenter.service.IUserLevelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;

/**
 * <p>
 * 用户等级表 服务实现类
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-20
 */
@Service
public class UserLevelServiceImpl extends ServiceImpl<UserLevelMapper, UserLevel> implements IUserLevelService {

    @Autowired
    private UserLevelMapper userLevelMapper;

    /**
     * 功能描述  增加积分
     * @author ysq
     * @param [userId, integral]
     * @return com.jxkj.common.result.ResultBody
     * @date 2020/5/27
     */
    @Override
    public ResultBody increaseIntegral(Long userId, Integer integral) {
        QueryWrapper<UserLevel> tUserId = new QueryWrapper<UserLevel>().eq("t_user_id", userId);
        UserLevel userLevel = userLevelMapper.selectOne(tUserId);
        if (null == userLevel){
            return ResultBodyUtil.error(ResultTypeEnum.USER_NOT_EXIST.getCode(), ResultTypeEnum.USER_NOT_EXIST.getMsg());
        }
        userLevel.setScore(userLevel.getScore()+integral);
        userLevelMapper.updateById(userLevel);
        return ResultBodyUtil.success();
    }

    /**
     * 功能描述 查询级别
     *
     * @param userId
     * @return com.jxkj.common.result.ResultBody
     * @author ysq
     * @date 2020/5/27
     */
    @Override
    public ResultBody updateLevel(Long userId) {
        QueryWrapper<UserLevel> tUserId = new QueryWrapper<UserLevel>().eq("t_user_id", userId);
        UserLevel userLevel = userLevelMapper.selectOne(tUserId);
        if (null == userLevel){
            return ResultBodyUtil.error(ResultTypeEnum.USER_NOT_EXIST.getCode(), ResultTypeEnum.USER_NOT_EXIST.getMsg());
        }
        Integer score = userLevel.getScore();
        if (score >=1000000){
            userLevel.setLevel(15);
        }else if(score >= 800000){
            userLevel.setLevel(14);
        }else if(score >= 500000){
            userLevel.setLevel(13);
        }else if(score >= 300000){
            userLevel.setLevel(12);
        }else if(score >= 200000){
            userLevel.setLevel(11);
        }else if(score >= 100000){
            userLevel.setLevel(10);
        }else if(score >= 50000){
            userLevel.setLevel(9);
        }else if(score >= 30000){
            userLevel.setLevel(8);
        }else if(score >= 10000){
            userLevel.setLevel(7);
        }else if(score >= 5000){
            userLevel.setLevel(6);
        }else if(score >= 2000){
            userLevel.setLevel(5);
        }else if(score >= 1000){
            userLevel.setLevel(4);
        }else if(score >= 500){
            userLevel.setLevel(3);
        }else if(score >= 100){
            userLevel.setLevel(2);
        }else {
            userLevel.setLevel(1);
        }
        userLevelMapper.updateById(userLevel);
        return ResultBodyUtil.success(userLevel.getLevel());
    }
}
