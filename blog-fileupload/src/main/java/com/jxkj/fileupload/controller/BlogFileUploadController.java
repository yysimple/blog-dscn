package com.jxkj.fileupload.controller;

import com.jxkj.common.result.ResultBody;
import com.jxkj.fileupload.service.BlogFileUploadService;
import com.jxkj.fileupload.service.UserFileUploadService;
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
@RequestMapping("/blog")
@Api(tags = "博客相关文件上传")
public class BlogFileUploadController {

    @Autowired
    private BlogFileUploadService blogFileUploadService;

    @ApiOperation(value = "博客信息图片上传")
    @PostMapping("/blogInfoUpload")
    public ResultBody blogInfoUpload(MultipartFile file) {
        return blogFileUploadService.blogInfoUpload(file);
    }
}
