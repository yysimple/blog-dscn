package com.jxkj.managecenter.feign;

import com.jxkj.common.result.ResultBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 功能描述: 远程调用 服务用户端
 *
 * @Author GuJunBin
 * @Version 1.0
 */
@Component
@FeignClient("USER-CENTER")
public interface UserInfoService {

    @GetMapping("/user-info/selectById")
    ResultBody selectById(Long id);
}
