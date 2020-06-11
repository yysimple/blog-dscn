package com.jxkj.usercenter.mapper;

import com.jxkj.usercenter.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxkj.usercenter.form.UserInfoForm;
import com.jxkj.usercenter.vo.UserInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-20
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 用户注册
     *
     * @param user
     */
    void userRegister(User user);

    /**
     * 功能描述: 通过用户id查询其详细信息（帮少奇加的）
     *
     * @Author ysq
     * @param userId
     * @return com.jxkj.usercenter.vo.UserInfoVo
     **/
    User selectUserInfoById(Long userId);
}
