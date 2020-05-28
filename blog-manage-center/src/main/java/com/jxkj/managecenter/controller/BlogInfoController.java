package com.jxkj.managecenter.controller;


import com.jxkj.common.result.ResultBody;
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
@RequestMapping("blogInfo")
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
    public ResultBody findIssueBlog(@RequestParam("key") String key) {
        return iBlogInfoService.findIssueBlog(key);
    }

    @ApiOperation(value = "保存博客信息")
    @PostMapping("/saveBlogInfo")
    public ResultBody saveBlogInfo(@RequestBody BlogInfo blogInfo,
                                   @RequestParam("tagIds") Long[]  tagIds,
                                   @RequestParam("typeId") Long typeId) {
        return iBlogInfoService.saveBlogInfo(blogInfo, tagIds, typeId);
    }

    @ApiOperation(value = "更新博客信息")
    @PostMapping("/updateBlogInfo")
    public ResultBody updateBlogInfo(@RequestBody BlogInfo blogInfo,
                                     @RequestParam("tagIds") Long[]  tagIds,
                                     @RequestParam("typeId") Long typeId){
        return iBlogInfoService.updateBlogInfo(blogInfo, tagIds, typeId);
    }

    @ApiOperation(value = "分页查询所有已删除博客信息")
    @GetMapping("/findAllDeletedBlog")
    public ResultBody findAllDeletedBlog() {
        return iBlogInfoService.findAllDeletedBlog();
    }

    @ApiOperation(value = "删除博客信息")
    @PostMapping("/deleteBlogInfoById")
    public ResultBody deleteBlogInfoById(@RequestParam("id") Long id) {
        return iBlogInfoService.deleteBlogInfo(id);
    }

    @ApiOperation(value = "回收已删除博客信息")
    @PostMapping("/recoverBlogInfoById")
    public ResultBody recoverBlogInfoById(@RequestParam("id") Long id) {
        return iBlogInfoService.recoverBlogInfoById(id);
    }

    @ApiOperation(value = "彻底删除博客信息")
    @PostMapping("/removeBlogInfoById")
    public ResultBody removeBlogInfoById(@RequestParam("id") Long id) {
        return iBlogInfoService.removeBlogInfoById(id);
    }

    @ApiOperation(value = "点赞")
    @PostMapping("/likeNum")
    public ResultBody likeNum(@RequestParam("id") Long id) {
        return iBlogInfoService.addLikeNum(id);
    }

    @ApiOperation(value = "收藏")
    @PostMapping("/favorites")
    public ResultBody favorites(@RequestParam("blogId") Long blogId,
                                @RequestParam("favoritesId") Long favoritesId,
                                @RequestParam("userId") Long userId) {
        return iBlogInfoService.favorites(blogId, favoritesId, userId);
    }

    @ApiOperation(value = "查询博客和标签信息")
    @GetMapping("/findBlogInfoAndTagsByBlogInfoId/{blogId}")
    public ResultBody findBlogInfoAndTagsByBlogInfoId(@PathVariable("blogId") Long blogId){
        return iBlogInfoService.findBlogInfoAndTagsByBlogInfoId(blogId);
    }
}
