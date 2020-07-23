package com.jxkj.managecenter.controller;

import com.jxkj.common.result.ResultBody;
import com.jxkj.managecenter.service.BlogIndexService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: blog-dscn
 * @description: 使用异步编排的方式返回首页信息，增加首页吞吐量
 * @author: WuChengXing
 * @create: 2020-07-23 10:03
 **/
@RestController
@RequestMapping("/index")
@Api(tags = "返回blog首页需要的数据")
public class BlogIndexController {

    @Autowired
    private BlogIndexService blogIndexService;

    @GetMapping("/getIndexDetails")
    @ApiOperation(value = "返回blog首页需要的数据")
    public ResultBody getIndexDetails(Long userId, Long blogTagId) {
        return blogIndexService.getIndexDetails(userId, blogTagId);
    }

    @GetMapping("/getIndexDetailsByCompletable")
    @ApiOperation(value = "返回blog首页需要的数据==通过异步编排的方式")
    public ResultBody getIndexDetailsByCompletable(Long userId, Long blogTagId) {
        return blogIndexService.getIndexDetailsByCompletable(userId, blogTagId);
    }
}
