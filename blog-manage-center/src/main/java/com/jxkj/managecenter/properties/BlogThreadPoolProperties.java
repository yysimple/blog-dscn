package com.jxkj.managecenter.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 项目: blog-dscn
 * <p>
 * 功能描述: 线程池的一些配置
 *
 * @author: WuChengXing
 * @create: 2020-07-23 14:26
 **/
@Data
@ConfigurationProperties(prefix = "thread.pool")
@Component
public class BlogThreadPoolProperties {
    /**
     * 核心线程数
     */
    private Integer corePoolSize;

    /**
     * 最大线程数
     */
    private Integer maximumPoolSize;

    /**
     * 等待线程的存活时间
     */
    private Long keepAliveTime;

    /**
     * 队列中可等待线程数
     */
    private Integer queueSize;
}
