package com.jxkj.managecenter.controller;


import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.managecenter.entity.BlogTag;
import com.jxkj.managecenter.mapper.BlogTagMapper;
import com.jxkj.managecenter.service.IBlogTagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 博客标签表 (例：spring、springboot)
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
@RestController
@RequestMapping("blogTag")
@Api(tags = "博客标签模块 接口")
@Slf4j
public class BlogTagController {

    @Autowired
    private IBlogTagService iBlogTagService;

    @Autowired
    private BlogTagMapper blogTagMapper;

    @ApiOperation(value = "查询所有博客标签")
    @GetMapping("/findAllBlogTag")
    public ResultBody findAllBlogTag() {
        return ResultBodyUtil.success(iBlogTagService.list());
    }

    @ApiOperation("新增or更新博客标签")
    @PostMapping("/saveOrUpdateBlogTag")
    public ResultBody saveOrUpdateBlogTag(@RequestBody BlogTag blogTag) {
        return iBlogTagService.saveOrUpdateBlogTag(blogTag);
    }

    @ApiOperation("根据id删除博客标签")
    @PostMapping("/deleteBlogTag")
    public ResultBody deleteBlogTag(@RequestParam("id") Long id) {
        return iBlogTagService.deleteById(id);
    }

    @ApiOperation(value = "根据标签id查询所有的博客")
    @GetMapping("/findAllBlogByTagId")
    public ResultBody findAllBlogByTagId(Long tagId) {
        BlogTag allBlogByTagId = blogTagMapper.findAllBlogByTagId(tagId);
        return ResultBodyUtil.success(allBlogByTagId);
    }

    @ApiOperation(value = "根据标签id查询访问量最高的前几条博客")
    @GetMapping("/findPVTopNBlogByTagId")
    public ResultBody findPVTopNBlogByTagId(Long tagId, Integer number) {
        return iBlogTagService.findPVTopNBlogByTagId(tagId, number);
    }

    @GetMapping("/findBlogTagNyName")
    @ApiOperation(value = "根据标签名查询对应的标签")
    public ResultBody findBlogTagNyName(String tagName){
        return iBlogTagService.findBlogTagNyName(tagName);
    }

}
