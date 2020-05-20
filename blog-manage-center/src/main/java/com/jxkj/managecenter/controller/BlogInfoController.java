package com.jxkj.managecenter.controller;


import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.managecenter.entity.BlogInfo;
import com.jxkj.managecenter.service.BlogInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 博客基本信息表 前端控制器
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
@RestController
@RequestMapping("/blogInfo")
@Api(tags = "博客信息模块 接口")
@Slf4j
public class BlogInfoController {

    @Autowired
    private BlogInfoService blogInfoService;

    @ApiOperation(value = "查询所有博客信息")
    @GetMapping("/findAllBlogInfo")
    public ResultBody findAllBlogInfo(){
        List<BlogInfo> blogInfoList = blogInfoService.list();
        return ResultBodyUtil.success(blogInfoList);
    }

    @ApiOperation(value = "保存博客信息")
    @PostMapping("/saveBlogInfo")
    public ResultBody saveBlogInfo(BlogInfo blogInfo){
        blogInfoService.save(blogInfo);
        return ResultBodyUtil.success();
    }

    @ApiOperation(value = "更改博客信息")
    @PostMapping("/updateBlogInfo")
    public ResultBody updateBlogInfo(BlogInfo blogInfo){
        blogInfoService.updateById(blogInfo);
        return ResultBodyUtil.success();
    }

    @ApiOperation(value = "删除博客信息")
    @PostMapping("/deleteBlogInfo")
    public ResultBody deleteBlogInfo(BlogInfo blogInfo){
        blogInfoService.updateById(blogInfo);
        return ResultBodyUtil.success();
    }

}
