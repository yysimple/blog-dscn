package com.jxkj.managecenter.feign;

import com.jxkj.common.result.ResultBody;
import com.jxkj.managecenter.config.OpenFeignServiceConfig;
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
@FeignClient(value = "user-center", configuration = OpenFeignServiceConfig.class, fallback = FallbackFactory.Default.class)
public interface UserInfoFeignService {

    /**
     * 功能描述: 查询用户信息
     * 
     * @author GuJunBin
     * @param id 
     * @return com.jxkj.common.result.ResultBody
     */
    @GetMapping("/user-info/selectById")
    ResultBody selectById(@RequestParam("id") Long id);

    /**
     * 功能描述: 关联用户及其详细信息
     *
     * @Author wcx
     * @param userId
     * @return com.jxkj.common.result.ResultBody
     **/
    @GetMapping("/user/selectUserInfoById")
    ResultBody selectUserInfoById(@RequestParam("userId") Long userId);
}
