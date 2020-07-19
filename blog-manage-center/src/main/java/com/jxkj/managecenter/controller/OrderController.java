package com.jxkj.managecenter.controller;


import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.managecenter.entity.Order;
import com.jxkj.managecenter.feign.AccountFeignService;
import com.jxkj.managecenter.feign.StorageFeignService;
import com.jxkj.managecenter.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 测试分布式锁的订单表 前端控制器
 * </p>
 *
 * @author wcx
 * @since 2020-07-19
 */
@RestController
public class OrderController {

    @Resource
    private IOrderService orderService;

    @PostMapping("/order/create")
    public ResultBody create(Order order){
        orderService.create(order);
        return ResultBodyUtil.success("订单创建成功");
    }


}
