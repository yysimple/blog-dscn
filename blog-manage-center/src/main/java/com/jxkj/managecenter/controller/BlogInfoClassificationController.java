package com.jxkj.managecenter.controller;


import com.jxkj.managecenter.service.IBlogClassificationService;
import com.jxkj.managecenter.service.IBlogInfoService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 博客信息和分类关联表 前端控制器
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
@RestController
@RequestMapping("blogCenter/blogInfoClassification")
@Api(tags = "博客信息关联分类模块 接口")
@Slf4j
public class BlogInfoClassificationController {

    @Autowired
    private IBlogInfoService iBlogInfoService;

    @Autowired
    private IBlogClassificationService iBlogClassificationService;
}
