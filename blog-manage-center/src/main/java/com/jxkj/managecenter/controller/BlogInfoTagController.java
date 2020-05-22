package com.jxkj.managecenter.controller;


import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.managecenter.entity.BlogTag;
import com.jxkj.managecenter.service.IBlogTagService;
import com.jxkj.managecenter.service.IBlogInfoTagService;
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
@RequestMapping("blogCenter/blogInfoTag")
@Api(tags = "博客信息关联标签模块 接口")
@Slf4j
public class BlogInfoTagController {

    @Autowired
    private IBlogInfoTagService iBlogInfoTagService;

    @Autowired
    private IBlogTagService iBlogTagService;

    @Autowired
    private IBlogInfoService iBlogInfoService;

    public ResultBody saveBlogInfoTag(BlogTag blogTag){
        return ResultBodyUtil.success();
    }
}
