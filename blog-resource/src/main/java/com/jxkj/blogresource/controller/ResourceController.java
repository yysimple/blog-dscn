package com.jxkj.blogresource.controller;


import com.jxkj.blogresource.entity.Resource;
import com.jxkj.blogresource.service.IResourceService;
import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-31
 */
@RestController
@RequestMapping("/resource")
@Api(tags = "资源模块 接口")
@Slf4j
public class ResourceController {

    @Autowired
    private IResourceService iResourceService;

    @ApiOperation(value = "提交资源")
    @PostMapping("/saveResource")
    public ResultBody saveResource(@RequestBody Resource resource) {
        //TODO 文件传入
        iResourceService.save(resource);
        return ResultBodyUtil.success();
    }

}
