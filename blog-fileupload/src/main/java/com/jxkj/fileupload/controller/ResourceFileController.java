package com.jxkj.fileupload.controller;

import com.jxkj.common.result.ResultBody;
import com.jxkj.fileupload.service.ResourceFileUploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
@RestController
@RequestMapping("/resource")
@Api(tags = "资源相关文件上传")
public class ResourceFileController {

    @Autowired
    private ResourceFileUploadService resourceFileUploadService;

    @ApiOperation(value = "资源上传")
    @PostMapping("/resourceUpload")
    public ResultBody resourceUpload(MultipartFile file) {
        return resourceFileUploadService.resourceUpload(file);
    }
}
