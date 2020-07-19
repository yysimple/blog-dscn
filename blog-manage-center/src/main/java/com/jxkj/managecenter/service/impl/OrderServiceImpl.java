package com.jxkj.managecenter.service.impl;

import com.jxkj.managecenter.entity.Order;
import com.jxkj.managecenter.feign.AccountFeignService;
import com.jxkj.managecenter.feign.StorageFeignService;
import com.jxkj.managecenter.mapper.OrderMapper;
import com.jxkj.managecenter.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 * 测试分布式锁的订单表 服务实现类
 * </p>
 *
 * @author wcx
 * @since 2020-07-19
 */
@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Resource
    private OrderMapper orderMapper;

    @Autowired
    private StorageFeignService storageFeignService;

    @Autowired
    private AccountFeignService accountFeignService;

    @Override
    @GlobalTransactional(name = "dscn-seata-create", rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("---------> 开始创建订单");
        orderMapper.create(order);

        log.info("---------> 订单微服务开始调用库存，做数量减");
        storageFeignService.decrease(order.getProductId(), order.getCount());
        log.info("---------> 订单微服务开始调用库存，做数量减扣 end....");

        log.info("---------> 订单微服务开始调用账户，做money减");
        accountFeignService.decrease(order.getUserId(), order.getMoney());
        log.info("---------> 订单微服务开始调用账户，做money减 end....");

        log.info("---------> 修改订单状态开始");
        orderMapper.update(order.getUserId(), 0);
        log.info("---------> 修改订单状态结束");

        log.info("---------> 完成订单");
    }
}
