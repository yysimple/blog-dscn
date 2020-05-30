package com.jxkj.fileupload.service;

import com.jxkj.common.result.ResultBody;
import com.jxkj.fileupload.form.ResourceUploadForm;

/**
 * 功能描述: 用户资源上传
 *
 * @Author GuJunBin
 * @Version 1.0
 */
public interface ResourceUploadService {

    /**
     * 功能描述: 资源上传
     *
     * @author GuJunBin
	 * @param resource
     * @return com.jxkj.common.result.ResultBody
     */
    ResultBody resourceUpload(ResourceUploadForm resource);
}
