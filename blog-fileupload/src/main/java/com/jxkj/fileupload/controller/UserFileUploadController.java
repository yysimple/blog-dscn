package com.jxkj.fileupload.controller;

import com.jxkj.common.result.ResultBody;
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
@RequestMapping("/user")
@Api(tags = "用户相关文件上传")
public class UserFileUploadController {

    @Autowired
    private UserFileUploadService userFileUploadService;

    @ApiOperation(value = "用户头像上传")
    @PostMapping("/userAvatarUpload")
    public ResultBody userAvatarUpload(MultipartFile file){
        return userFileUploadService.userAvatarUpload(file);
    }
}
