package com.jxkj.managecenter.controller;


import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.common.result.ResultTypeEnum;
import com.jxkj.managecenter.entity.BlogTag;
import com.jxkj.managecenter.service.IBlogTagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 博客标签表 (例：spring、springboot)
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
@RestController
@RequestMapping("blogCenter/blogTag")
@Api(tags = "博客标签模块 接口")
@Slf4j
public class BlogTagController {

    @Autowired
    private IBlogTagService iBlogTagService;

    @ApiOperation(value = "查询所有博客标签")
    @GetMapping("/findAllBlogTag")
    public ResultBody findAllBlogTag(){
        List<BlogTag> list = iBlogTagService.list();
        return ResultBodyUtil.success(list);
    }

    @ApiOperation("新增or更新博客所属类别")
    @PostMapping("/saveOrUpdateBlogTag")
    public ResultBody saveOrUpdateBlogTag(@RequestBody BlogTag blogTag){
        Boolean existTagName = iBlogTagService.existTagName(blogTag);
        if (!existTagName){
            iBlogTagService.saveOrUpdate(blogTag);
            return ResultBodyUtil.success();
        }else {
            return ResultBodyUtil.error(
                    ResultTypeEnum.ALREADY_EXIST.getCode(),
                    ResultTypeEnum.ALREADY_EXIST.getMsg());
        }
    }

    @ApiOperation("根据id删除博客所属类别")
    @PostMapping("/deleteBlogTag")
    public ResultBody deleteBlogTag(Long id){
        iBlogTagService.removeById(id);
        return ResultBodyUtil.success();
    }
}
