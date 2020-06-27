package com.jxkj.usercenter.service.impl;

import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.common.result.ResultTypeEnum;
import com.jxkj.usercenter.entity.UserInfo;
import com.jxkj.usercenter.mapper.UserInfoMapper;
import com.jxkj.usercenter.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxkj.usercenter.util.DateFormatConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public ResultBody selectById(Long id) {
        if (null == id){
            return ResultBodyUtil.error(ResultTypeEnum.PARAM_NOT_EMPTY.getCode(),ResultTypeEnum.PARAM_NOT_EMPTY.getMsg());
        }
        UserInfo userInfo = userInfoMapper.selectById(id);
        if (null == userInfo){
            return ResultBodyUtil.error(ResultTypeEnum.USER_NOT_EXIST.getCode(),ResultTypeEnum.USER_NOT_EXIST.getMsg());
        }
        return ResultBodyUtil.success(userInfo);
    }

    @Override
    public ResultBody saveMessage(UserInfo userInfo) {
        int insert = userInfoMapper.insert(userInfo);
        return ResultBodyUtil.success(insert);

    }

    @Override
    public ResultBody updateUserInfo(UserInfo userInfo) {
        int i = userInfoMapper.updateById(userInfo);
        return ResultBodyUtil.success(i);
    }
}
