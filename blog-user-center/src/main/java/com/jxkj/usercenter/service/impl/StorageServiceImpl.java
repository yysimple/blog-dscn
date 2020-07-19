package com.jxkj.usercenter.service.impl;

import com.jxkj.usercenter.entity.Storage;
import com.jxkj.usercenter.mapper.StorageMapper;
import com.jxkj.usercenter.service.IStorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 测试分布式锁的库存表 服务实现类
 * </p>
 *
 * @author wcx
 * @since 2020-07-19
 */
@Service
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements IStorageService {

}
