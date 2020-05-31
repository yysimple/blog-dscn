package com.jxkj.blogresource.feign;

import com.jxkj.common.result.ResultBody;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * 功能描述: 远程调用 服务用户端
 *
 * @Author GuJunBin
 * @Version 1.0
 */
@Component
@FeignClient(value = "file-upload", fallback = FallbackFactory.Default.class)
public interface BlogFileUploadService {

    /**
     * 功能描述: 博客资源上传
     *
     * @param file
     * @return com.jxkj.common.result.ResultBody
     * @author GuJunBin
     */
    @PostMapping("/blog/blogInfoUpload")
    ResultBody blogInfoUpload(MultipartFile file);
}
