package com.jxkj.other.service;

import com.jxkj.other.entity.Account;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.models.auth.In;

import java.math.BigDecimal;

/**
 * <p>
 * 分布式事务测试表、账号表 服务类
 * </p>
 *
 * @author wcx
 * @since 2020-07-19
 */
public interface IAccountService extends IService<Account> {

    /**
     * 减账户的钱
     * @param userId
     * @param money
     * @return
     */
    void decrease(Long userId, Integer money);
}
