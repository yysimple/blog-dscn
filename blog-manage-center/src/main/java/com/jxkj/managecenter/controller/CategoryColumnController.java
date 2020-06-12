package com.jxkj.managecenter.controller;

import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.managecenter.entity.CategoryColumn;
import com.jxkj.managecenter.service.ICategoryColumnService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 分类专栏(TCategoryColumn)表控制层
 *
 * @author makejava
 * @since 2020-06-12 23:14:37
 */
@RestController
@RequestMapping("categoryColumn")
@Api(tags = "分类专栏")
public class CategoryColumnController {

    @Autowired
    private ICategoryColumnService iCategoryColumnService;

    @GetMapping("/findAllCategoryColumn")
    @ApiOperation(value = "获取所有的分类专栏")
    public ResultBody findAllCategoryColumn(){
        List<CategoryColumn> categoryColumns = iCategoryColumnService.list();
        return ResultBodyUtil.success(categoryColumns);
    }
}