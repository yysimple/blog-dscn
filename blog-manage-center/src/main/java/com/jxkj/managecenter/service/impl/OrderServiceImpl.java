package com.jxkj.managecenter.service.impl;

import com.jxkj.managecenter.entity.Order;
import com.jxkj.managecenter.mapper.OrderMapper;
import com.jxkj.managecenter.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 测试分布式锁的订单表 服务实现类
 * </p>
 *
 * @author wcx
 * @since 2020-07-19
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
