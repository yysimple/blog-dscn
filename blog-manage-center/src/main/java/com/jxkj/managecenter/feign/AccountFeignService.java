package com.jxkj.managecenter.feign;

import com.jxkj.common.result.ResultBody;
import com.jxkj.managecenter.config.OpenFeignServiceConfig;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @program:blog-dscn
 * @author: wcx
 * @Time: 2020/7/19  14:17
 */
@FeignClient(value = "blog-other", fallback = FallbackFactory.Default.class)
public interface AccountFeignService {

    /**
     * 减账户的钱
     * @param userId
     * @param money
     * @return
     */
    @PostMapping("/account/decrease")
    ResultBody decrease(@RequestParam("userId") Long userId, @RequestParam("money") Integer money);
}
