package com.jxkj.managecenter.feign;

import com.jxkj.common.result.ResultBody;
import com.jxkj.managecenter.config.OpenFeignServiceConfig;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program:blog-dscn
 * @author: wcx
 * @Time: 2020/7/19  14:22
 */
@FeignClient(value = "user-center", configuration = OpenFeignServiceConfig.class, fallback = FallbackFactory.Default.class)
public interface StorageFeignService {
    /**
     * 减库存
     * @param productId
     * @param count
     * @return
     */
    @PostMapping("/storage/decrease")
    ResultBody decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
