package com.jxkj.managecenter.mapper;

import com.jxkj.managecenter.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 测试分布式锁的订单表 Mapper 接口
 * </p>
 *
 * @author wcx
 * @since 2020-07-19
 */
@Repository
public interface OrderMapper extends BaseMapper<Order> {
    /**
     * 创建订单
     * @param order
     */
    void create(Order order);

    /**
     * 修改订单状态
     * @param userId
     * @param status
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
