package com.jxkj.fileupload.controller;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: blog-dscn
 * @description: 在线预览文件
 * @author: WuChengXing
 * @create: 2020-07-20 16:02
 **/
@RestController
@Api(tags = "在线预览文件")
public class OnlineViewController {

    @Value("${kkFileView.url}")
    private String kkFileViewUrl;

    @PostMapping("/onlineViewFile")
    @ApiOperation(value = "在线预览")
    public ResultBody onlineViewFile(String fileUrl){
        String preview = kkFileViewUrl + "/onlinePreview?url=" + fileUrl;
        return ResultBodyUtil.success(preview);
    }
}
