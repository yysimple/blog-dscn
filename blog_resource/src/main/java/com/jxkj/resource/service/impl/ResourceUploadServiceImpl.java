package com.jxkj.resource.service.impl;

import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.resource.form.ResourceUploadForm;
import com.jxkj.resource.service.ResourceUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 功能描述:
 *
 * @Author GuJunBin
 * @Version 1.0
 */
@Service
public class ResourceUploadServiceImpl implements ResourceUploadService {

    @Autowired
    //private BlogFileUploadService blogFileUploadService;

    @Override
    public ResultBody resourceUpload(ResourceUploadForm resource) {
        //blogFileUploadService.blogInfoUpload(resource.getFile());
        System.out.println(resource.getTags());
        return ResultBodyUtil.success(resource);
    }
}
