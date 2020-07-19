package com.jxkj.usercenter.service;

import com.jxkj.usercenter.entity.Storage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 测试分布式锁的库存表 服务类
 * </p>
 *
 * @author wcx
 * @since 2020-07-19
 */
public interface IStorageService extends IService<Storage> {
    /**
     * 减库存
     * @param productId
     * @param count
     */
    void decrease(Long productId, Integer count);

}
