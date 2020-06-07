package com.jxkj.fileupload.service;

import com.jxkj.common.result.ResultBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
public interface ResourceFileUploadService {

    /**
     * 功能描述: 资源上传
     *
     * @Author wcx
     * @param file
     * @return java.lang.String
     **/
    ResultBody resourceUpload(MultipartFile file);
}
