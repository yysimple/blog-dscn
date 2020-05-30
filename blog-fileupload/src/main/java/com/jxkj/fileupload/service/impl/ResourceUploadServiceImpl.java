package com.jxkj.fileupload.service.impl;

import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.common.result.ResultTypeEnum;
import com.jxkj.fileupload.form.ResourceUploadForm;
import com.jxkj.fileupload.service.BlogFileUploadService;
import com.jxkj.fileupload.service.ResourceUploadService;
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
    private BlogFileUploadService blogFileUploadService;

    @Override
    public ResultBody resourceUpload(ResourceUploadForm resource) {
        blogFileUploadService.blogInfoUpload(resource.getFile());
        System.out.println(resource.getTags());
        if (resource.getTags().size() > 5) {
            return ResultBodyUtil.error(ResultTypeEnum.TAG_LIMIT.getCode(),ResultTypeEnum.TAG_LIMIT.getMsg());
        }
        return ResultBodyUtil.success(resource);
    }
}
