package com.jxkj.managecenter.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.managecenter.entity.BlogInfo;
import com.jxkj.managecenter.service.IBlogInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 博客基本信息表 前端控制器
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
@RestController
@RequestMapping("blogCenter/blogInfo")
@Api(tags = "博客信息模块 接口")
@Slf4j
public class BlogInfoController {

    @Autowired
    private IBlogInfoService iBlogInfoService;

    private QueryWrapper<BlogInfo> queryWrapper = new QueryWrapper<>();
    IPage<BlogInfo> page = new Page(1, 10);

    @ApiOperation(value = "分页查询所有已发布博客信息")
    @GetMapping("/findAllIssueBlog")
    public ResultBody findAllIssueBlog() {
        queryWrapper.eq("blog_status", 1);
        IPage<BlogInfo> blogInfoIPage = iBlogInfoService.page(page, queryWrapper);
        log.info("总页数： " + blogInfoIPage.getTotal());
        log.info("总记录数： " + blogInfoIPage.getPages());
        log.info("返回信息： " + blogInfoIPage.getRecords());
        return ResultBodyUtil.success(blogInfoIPage);
    }

    @ApiOperation(value = "根据标题和文章内容模糊查询发布博客信息")
    @GetMapping("/findIssueBlog")
    public ResultBody findIssueBlog(String key) {
        queryWrapper.eq("blog_status", 1).like("title", key).or().like("content", key);
        IPage<BlogInfo> blogInfoIPage = iBlogInfoService.page(page, queryWrapper);
        return ResultBodyUtil.success(blogInfoIPage);
    }

    @ApiOperation(value = "保存or更新博客信息")
    @PostMapping("/saveOrUpdateBlogInfo")
    public ResultBody saveOrUpdateBlogInfo(@RequestBody BlogInfo blogInfo) {
        iBlogInfoService.saveOrUpdate(blogInfo);
        return ResultBodyUtil.success();
    }
    @ApiOperation(value = "逻辑删除博客信息")
    @PostMapping("/deleteBlogInfoById")
    public ResultBody deleteBlogInfoById(Long id) {
        iBlogInfoService.updateDelStatusById(id);
        return ResultBodyUtil.success();
    }

    @ApiOperation(value = "点赞")
    @PostMapping("/likeNum")
    public ResultBody likeNum(Long id) {
        BlogInfo blogInfo = iBlogInfoService.getById(id);
        blogInfo.setLikeNum(blogInfo.getLikeNum() + 1);
        iBlogInfoService.updateById(blogInfo);
        return ResultBodyUtil.success();
    }

}
