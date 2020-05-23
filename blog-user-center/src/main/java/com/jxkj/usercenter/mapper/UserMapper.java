package com.jxkj.usercenter.mapper;

import com.jxkj.usercenter.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
}
