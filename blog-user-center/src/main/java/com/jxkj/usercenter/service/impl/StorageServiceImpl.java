package com.jxkj.usercenter.service.impl;

import com.jxkj.usercenter.entity.Storage;
import com.jxkj.usercenter.mapper.StorageMapper;
import com.jxkj.usercenter.service.IStorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 测试分布式锁的库存表 服务实现类
 * </p>
 *
 * @author wcx
 * @since 2020-07-19
 */
@Service
@Slf4j
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements IStorageService {

    @Autowired
    private StorageMapper storageMapper;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("---------> storage-service 减库存开始");
        storageMapper.decrease(productId, count);
        log.info("---------> storage-service 减库存结束");
    }
}
