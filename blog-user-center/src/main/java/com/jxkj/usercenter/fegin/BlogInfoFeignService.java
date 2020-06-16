package com.jxkj.usercenter.fegin;

import com.jxkj.common.result.ResultBody;
import com.jxkj.usercenter.form.BlogInfoForm;
import feign.hystrix.FallbackFactory;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ysq
 * @description
 * @date 2020/6/4
 */
@Component
@FeignClient(value = "blog-center", fallback = FallbackFactory.Default.class)
public interface BlogInfoFeignService {

    @ApiOperation(value = "保存博客信息")
    @PostMapping("/blogInfo/saveBlogInfo")
    ResultBody saveBlogInfo(@RequestBody BlogInfoForm blogInfoForm,
                            @RequestParam("tagIds") Long[] tagIds,
                            @RequestParam("typeId") Long typeId);

    /**
     * 功能描述: 保存博客信息
     *
     * @param blogInfoForm
     * @param categoryNames
     * @param tagNames
     * @param typeId
     * @return com.jxkj.common.result.ResultBody
     * @Author wcx
     **/
    @PostMapping("/blogInfo/saveBlogInfoByTagNames")
    ResultBody saveBlogInfoByTagNames(@RequestBody BlogInfoForm blogInfoForm,
                                      @RequestParam("categoryNames") String[] categoryNames,
                                      @RequestParam("tagNames") String[] tagNames,
                                      @RequestParam("typeId") Long typeId);

    @ApiOperation(value = "逻辑删除博客信息")
    @PostMapping("/blogInfo/deleteBlogInfoById")
    ResultBody deleteBlogInfoById(@RequestParam("id") Long id);

}
