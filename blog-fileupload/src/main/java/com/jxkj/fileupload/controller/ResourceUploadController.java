package com.jxkj.fileupload.controller;

import com.jxkj.common.result.ResultBody;
import com.jxkj.fileupload.form.ResourceUploadForm;
import com.jxkj.fileupload.service.ResourceUploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述: 资源上传
 *
 * @Author GuJunBin
 * @Version 1.0
 */
@RestController
@RequestMapping("/resource")
@Api(tags = "资源上传")
public class ResourceUploadController {

    @Autowired
    private ResourceUploadService resourceUploadService;

    @ApiOperation(value = "资源信息上传")
    @PostMapping("/resourceUpload")
    public ResultBody resourceUpload(ResourceUploadForm resource) {
        return resourceUploadService.resourceUpload(resource);
    }
}
