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

    @ApiOperation(value = "查询用户所有已发布博客信息")
    @GetMapping("/listUserBlog")
    public ResultBody listUserBlog(@RequestParam("userId") Long userId){
        return iBlogInfoService.listUserBlog(userId);
    }

    @ApiOperation(value = "分页查询用户所有已发布博客信息")
    @GetMapping("/listPageUserBlog")
    public ResultBody listPageUserBlog(@RequestParam("userId") Long userId){
        return iBlogInfoService.listPageUserBlog(userId);
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

    @ApiOperation(value = "分页查询所有逻辑删除博客信息")
    @GetMapping("/findAllDeletedBlog")
    public ResultBody findAllDeletedBlog() {
        return iBlogInfoService.findAllDeletedBlog();
    }

    @ApiOperation(value = "逻辑删除博客信息")
    @PostMapping("/deleteBlogInfoById")
    public ResultBody deleteBlogInfoById(@RequestParam("id") Long id) {
        boolean remove = iBlogInfoService.removeById(id);
        return ResultBodyUtil.success(remove);
    }

    @ApiOperation(value = "回收逻辑删除博客信息")
    @PostMapping("/recoverBlogInfoById")
    public ResultBody recoverBlogInfoById(@RequestParam("id") Long id) {
        return iBlogInfoService.recoverBlogInfoById(id);
    }

    @ApiOperation(value = "彻底删除博客信息")
    @PostMapping("/removeBlogInfoById")
    public ResultBody removeBlogInfoById(@RequestParam("id") Long id) {
        return iBlogInfoService.removeBlogInfoById(id);
    }

    @ApiOperation(value = "点赞/取消点赞")
    @PostMapping("/likeNum")
    public ResultBody likeNum(@RequestParam("id") Long id,@RequestParam("userId") Long userId) {
        return iBlogInfoService.addLikeNum(id , userId);
    }

    @ApiOperation(value = "访问")
    @PostMapping("/viewNum")
    public ResultBody viewNum(@RequestParam("id") Long id) {
        return iBlogInfoService.addViewNum(id);
    }

    @ApiOperation(value = "收藏/取消收藏")
    @PostMapping("/favorites")
    public ResultBody favorites(@RequestParam("blogId") Long blogId,
                                @RequestParam("userId") Long userId,
                                @RequestParam("favoritesId") Long favoritesId) {
        return iBlogInfoService.favorites(blogId, userId, favoritesId);
    }

    @ApiOperation(value = "查询博客和标签信息")
    @GetMapping("/findBlogInfoAndTagsByBlogInfoId/{blogId}")
    public ResultBody findBlogInfoAndTagsByBlogInfoId(@PathVariable("blogId") Long blogId){
        return iBlogInfoService.findBlogInfoAndTagsByBlogInfoId(blogId);
    }

    @ApiOperation(value = "查询访问量最高的10条博客并排序")
    @GetMapping("/listOrderByViewNum")
    public ResultBody listOrderByViewNum() {
        return iBlogInfoService.listOrderByViewNum();
    }
}