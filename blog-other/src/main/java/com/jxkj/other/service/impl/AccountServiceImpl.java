package com.jxkj.other.service.impl;

import com.jxkj.other.entity.Account;
import com.jxkj.other.mapper.AccountMapper;
import com.jxkj.other.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 分布式事务测试表、账号表 服务实现类
 * </p>
 *
 * @author wcx
 * @since 2020-07-19
 */
@Service
@Slf4j
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public void decrease(Long userId, Integer money) {
        log.info("---------> account-service 开始减金额");
        accountMapper.decrease(userId, money);
        log.info("---------> account-service 减金额结束");
    }
}
