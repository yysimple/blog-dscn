package com.jxkj.usercenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.common.result.ResultTypeEnum;
import com.jxkj.usercenter.constant.enums.GradeEnum;
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
     *
     * @param userId, integral
     * @return com.jxkj.common.result.ResultBody
     * @author ysq
     * @date 2020/5/27
     */
    @Override
    public ResultBody increaseIntegral(Long userId, Integer integral) {
        QueryWrapper<UserLevel> tUserId = new QueryWrapper<UserLevel>().eq("t_user_id", userId);
        UserLevel userLevel = userLevelMapper.selectOne(tUserId);
        if (null == userLevel) {
            return ResultBodyUtil.error(ResultTypeEnum.USER_NOT_EXIST.getCode(), ResultTypeEnum.USER_NOT_EXIST.getMsg());
        }
        userLevel.setScore(userLevel.getScore() + integral);
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
        if (null == userLevel) {
            return ResultBodyUtil.error(ResultTypeEnum.USER_NOT_EXIST.getCode(), ResultTypeEnum.USER_NOT_EXIST.getMsg());
        }
        Integer score = userLevel.getScore();
        if (score >= GradeEnum.GRADE_FIFTEEN.getScore()) {
            userLevel.setLevel(GradeEnum.GRADE_FIFTEEN.getGeade());
        } else if (score >= GradeEnum.GRADE_FOURTEEN.getScore()) {
            userLevel.setLevel(GradeEnum.GRADE_FOURTEEN.getGeade());
        } else if (score >= GradeEnum.GRADE_THIRTEEN.getScore()) {
            userLevel.setLevel(GradeEnum.GRADE_THIRTEEN.getGeade());
        } else if (score >= GradeEnum.GRADE_TWELVE.getScore()) {
            userLevel.setLevel(GradeEnum.GRADE_TWELVE.getGeade());
        } else if (score >= GradeEnum.GRADE_ELEVEN.getScore()) {
            userLevel.setLevel(GradeEnum.GRADE_ELEVEN.getGeade());
        } else if (score >= GradeEnum.GRADE_TEN.getScore()) {
            userLevel.setLevel(GradeEnum.GRADE_TEN.getGeade());
        } else if (score >= GradeEnum.GRADE_NINE.getScore()) {
            userLevel.setLevel(GradeEnum.GRADE_NINE.getGeade());
        } else if (score >= GradeEnum.GRADE_EIGHT.getScore()) {
            userLevel.setLevel(GradeEnum.GRADE_EIGHT.getGeade());
        } else if (score >= GradeEnum.GRADE_SEVEN.getScore()) {
            userLevel.setLevel(GradeEnum.GRADE_SEVEN.getGeade());
        } else if (score >= GradeEnum.GRADE_SIX.getScore()) {
            userLevel.setLevel(GradeEnum.GRADE_SIX.getGeade());
        } else if (score >= GradeEnum.GRADE_FIVE.getScore()) {
            userLevel.setLevel(GradeEnum.GRADE_FIVE.getGeade());
        } else if (score >= GradeEnum.GRADE_FOUR.getScore()) {
            userLevel.setLevel(GradeEnum.GRADE_FOUR.getGeade());
        } else if (score >= GradeEnum.GRADE_THREE.getScore()) {
            userLevel.setLevel(GradeEnum.GRADE_THREE.getGeade());
        } else if (score >= GradeEnum.GRADE_TWO.getScore()) {
            userLevel.setLevel(GradeEnum.GRADE_TWO.getGeade());
        } else {
            userLevel.setLevel(GradeEnum.GRADE_ONE.getGeade());
        }
        userLevelMapper.updateById(userLevel);
        return ResultBodyUtil.success(userLevel.getLevel());
    }
}
