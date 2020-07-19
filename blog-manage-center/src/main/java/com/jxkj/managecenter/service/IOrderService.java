package com.jxkj.managecenter.service;

import com.jxkj.managecenter.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 测试分布式锁的订单表 服务类
 * </p>
 *
 * @author wcx
 * @since 2020-07-19
 */
public interface IOrderService extends IService<Order> {
    /**
     * 创建订单
     * @param order
     */
    void create(Order order);
}
