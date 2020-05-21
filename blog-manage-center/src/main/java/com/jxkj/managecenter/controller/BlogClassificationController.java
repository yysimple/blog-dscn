package com.jxkj.managecenter.controller;


import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.managecenter.entity.BlogClassification;
import com.jxkj.managecenter.service.IBlogClassificationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 博客所属类别表 (例：spring、springboot)
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
@RestController
@RequestMapping("blogCenter/blogClassification")
@Api(tags = "博客所属类别模块 接口")
@Slf4j
public class BlogClassificationController {

    @Autowired
    private IBlogClassificationService iBlogClassificationService;

    @ApiOperation(value = "查询所有博客类别")
    @GetMapping("/findAllBlogClassification")
    public ResultBody findAllBlogClassification(){
        List<BlogClassification> list = iBlogClassificationService.list();
        return ResultBodyUtil.success(list);
    }

}
