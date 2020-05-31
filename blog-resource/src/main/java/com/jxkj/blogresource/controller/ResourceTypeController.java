package com.jxkj.blogresource.controller;


import com.jxkj.blogresource.entity.ResourceType;
import com.jxkj.blogresource.service.IResourceTypeService;
import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-31
 */
@RestController
@RequestMapping("/resourceType")
@Api(tags = "资源类型模块 接口")
@Slf4j
public class ResourceTypeController {

    @Autowired
    private IResourceTypeService iResourceTypeService;

    @ApiOperation(value = "保存or更新资源类型")
    @PostMapping("/saveOrUpdateResourceType")
    public ResultBody saveOrUpdateResourceType(@RequestBody ResourceType resourceType){
        return iResourceTypeService.saveOrUpdateResourceType(resourceType);
    }

    @ApiOperation(value = "查出所有分类以及子分类，以树形结构组装起来")
    @GetMapping("/listTypeWithTree")
    public ResultBody listTypeWithTree(){
        return iResourceTypeService.listTypeWithTree();
    }

    @ApiOperation(value = "删除资源类型")
    @PostMapping("/deleteResourceType")
    public ResultBody deleteResourceType(@RequestParam Long id){
        iResourceTypeService.removeById(id);
        return ResultBodyUtil.success();
    }
}
