package com.jxkj.blogresource.feign;

import com.jxkj.common.result.ResultBody;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * 功能描述:
 *
 * @Author GuJunBin
 * @Version 1.0
 */
@Component
@FeignClient(value = "file-upload",fallback = FallbackFactory.Default.class)
public interface ResourceFeignService {

    /**
     * 功能描述: 资源文件上传
     *
     * @author GuJunBin
     * @param file
     * @return com.jxkj.common.result.ResultBody
     */
    @PostMapping("/resource/resourceUpload")
    ResultBody resourceUpload(MultipartFile file);
}
