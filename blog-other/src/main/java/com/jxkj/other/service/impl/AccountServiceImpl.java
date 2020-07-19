package com.jxkj.other.service.impl;

import com.jxkj.other.entity.Account;
import com.jxkj.other.mapper.AccountMapper;
import com.jxkj.other.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 分布式事务测试表、账号表 服务实现类
 * </p>
 *
 * @author wcx
 * @since 2020-07-19
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

}
