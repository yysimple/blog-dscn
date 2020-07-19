package com.jxkj.other.mapper;

import com.jxkj.other.entity.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * <p>
 * 分布式事务测试表、账号表 Mapper 接口
 * </p>
 *
 * @author wcx
 * @since 2020-07-19
 */
@Repository
public interface AccountMapper extends BaseMapper<Account> {
    /**
     * 减钱
     * @param userId
     * @param money
     */
    void decrease(@Param("userId") Long userId, @Param("money") Integer money);
}
