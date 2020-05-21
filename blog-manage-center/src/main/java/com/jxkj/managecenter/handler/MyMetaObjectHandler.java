package com.jxkj.managecenter.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Description: 处理字段自动填充，创建时间、更新时间
 * @Author GuJunBin
 * @Version 1.0
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        boolean flag = metaObject.hasSetter("createTime");
        if (flag) {
            // 创建时，更新创建时间和更新时间
            this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
            this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {

        boolean flag = metaObject.hasSetter("updateTime");
        if (flag) {
            // 更新时自动填充
            this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        }
    }

}
