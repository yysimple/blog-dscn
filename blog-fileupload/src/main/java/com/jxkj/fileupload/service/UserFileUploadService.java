package com.jxkj.fileupload.service;

import com.jxkj.common.result.ResultBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 功能描述：用户相关的文件上传
 *
 * @author wcx
 * @version 1.0
 */
public interface UserFileUploadService {
    /**
     * 功能描述: 用户头像上传
     *
     * @Author wcx
     * @param file
     * @return java.lang.String
     **/
    ResultBody userAvatarUpload(MultipartFile file);
}
