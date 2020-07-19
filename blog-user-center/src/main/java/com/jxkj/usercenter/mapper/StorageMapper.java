package com.jxkj.usercenter.mapper;

import com.jxkj.usercenter.entity.Storage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 测试分布式锁的库存表 Mapper 接口
 * </p>
 *
 * @author wcx
 * @since 2020-07-19
 */
@Repository
public interface StorageMapper extends BaseMapper<Storage> {
    /**
     * 数据库存在null字段（a）的时候，在执行更新操作的时候，使用 a = a + 1这个操作时是不会往a这个字段里面添加结果的
     * 减库存
     * @param productId
     * @param count
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
