package com.jxkj.managecenter.feign;

import com.jxkj.common.result.ResultBody;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 功能描述: 远程调用 服务用户端
 *
 * @Author GuJunBin
 * @Version 1.0
 */
@Component
@FeignClient(value = "user-center",fallback = FallbackFactory.Default.class)
public interface UserInfoService {

    /**
     * 功能描述: 查询用户信息
     * 
     * @author GuJunBin
     * @param id 
     * @return com.jxkj.common.result.ResultBody
     */
    @GetMapping("/user-info/selectById")
    ResultBody selectById(@RequestParam("id") Long id);
}
