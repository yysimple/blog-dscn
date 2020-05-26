package com.jxkj.managecenter.controller;


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

    @ApiOperation(value = "分页查询所有已发布博客信息")
    @GetMapping("/findAllIssueBlog")
    public ResultBody findAllIssueBlog() {
        return iBlogInfoService.pagingQuery();
    }

    @ApiOperation(value = "根据标题和文章内容模糊查询发布博客信息")
    @GetMapping("/findIssueBlog")
    public ResultBody findIssueBlog(String key) {
        return iBlogInfoService.findIssueBlog(key);
    }

    @ApiOperation(value = "保存博客信息")
    @PostMapping("/saveBlogInfo")
    public ResultBody saveBlogInfo(@RequestBody BlogInfo blogInfo,Long[]  tagIds,Long typeId) {
        return iBlogInfoService.saveBlogInfo(blogInfo, tagIds, typeId);
    }

    @ApiOperation(value = "更新博客信息")
    @PostMapping("/updateBlogInfo")
    public ResultBody updateBlogInfo(@RequestBody BlogInfo blogInfo,Long[] tagIds,Long typeId){
        return iBlogInfoService.updateBlogInfo(blogInfo, tagIds, typeId);
    }

    @ApiOperation(value = "删除博客信息")
    @PostMapping("/deleteBlogInfoById")
    public ResultBody deleteBlogInfoById(Long id) {
        iBlogInfoService.deleteBlogInfo(id);
        return ResultBodyUtil.success();
    }

    @ApiOperation(value = "点赞")
    @PostMapping("/likeNum")
    public ResultBody likeNum(Long id) {
        return iBlogInfoService.addLikeNum(id);
    }

    @ApiOperation(value = "收藏")
    @PostMapping("/favorites")
    public ResultBody favorites(Long blogId, Long favoritesId, Long userId) {
        return iBlogInfoService.favorites(blogId, favoritesId, userId);
    }
}
