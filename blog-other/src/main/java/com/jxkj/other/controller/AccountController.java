package com.jxkj.other.controller;


import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.other.service.IAccountService;
import org.apache.ibatis.annotations.Param;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * <p>
 * 分布式事务测试表、账号表 前端控制器
 * </p>
 *
 * @author wcx
 * @since 2020-07-19
 */
@RestController
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @PostMapping("/account/decrease")
    public ResultBody decrease(@RequestParam("userId") Long userId, @RequestParam("money") Integer money){
        accountService.decrease(userId, money);
        return ResultBodyUtil.success("减扣金额成功！");
    }
}
