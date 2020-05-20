package com.jxkj.managecenter.controller;


import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.managecenter.entity.BlogInfo;
import com.jxkj.managecenter.service.IBlogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/blog-info")
public class BlogInfoController {

    @Autowired
    private IBlogInfoService blogInfoService;

    @GetMapping("/findAllBlogInfo")
    public ResultBody findAllBlogInfo(){
        List<BlogInfo> blogInfoList = blogInfoService.list();
        return ResultBodyUtil.success(blogInfoList);
    }


}
