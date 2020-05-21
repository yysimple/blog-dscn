package com.jxkj.fileupload.service;

import com.jxkj.common.result.ResultBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 功能描述：用于博客信息的文件上传
 *
 * @author wcx
 * @version 1.0
 */
public interface BlogFileUploadService {
    
    /**
     * 功能描述: 博客中的图片上传
     *
     * @Author wcx
     * @param file
     * @return java.lang.String
     **/
     ResultBody blogInfoUpload(MultipartFile file);
}
