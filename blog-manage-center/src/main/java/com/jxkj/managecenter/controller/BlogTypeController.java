package com.jxkj.managecenter.controller;


import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.managecenter.entity.BlogType;
import com.jxkj.managecenter.service.IBlogTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 博客类型表  （例：原创、转载）
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
@RestController
@RequestMapping("blogCenter/blogType")
@Api(tags = "博客类型模块(原创、转载) 接口")
@Slf4j
public class BlogTypeController {

    @Autowired
    private IBlogTypeService iBlogTypeService;

    @ApiOperation(value = "查询所有博客类型")
    @GetMapping("/findAllBlogType")
    public ResultBody findAllBlogType(){
        List<BlogType> blogTypeList = iBlogTypeService.list();
        return ResultBodyUtil.success(blogTypeList);
    }

    @ApiOperation(value = "保存or更新博客类型")
    @PostMapping("/saveOrUpdateBlogType")
    public ResultBody saveOrUpdateBlogType(@RequestBody BlogType blogType){
        iBlogTypeService.saveOrUpdate(blogType);
        return ResultBodyUtil.success();
    }

}
