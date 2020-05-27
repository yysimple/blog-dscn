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
}
