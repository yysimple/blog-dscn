package com.jxkj.fileupload.service.impl;

import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.common.result.ResultTypeEnum;
import com.jxkj.fileupload.constant.FileConstant;
import com.jxkj.fileupload.service.UserFileUploadService;
import com.jxkj.fileupload.util.FileUploadUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
@Service
public class UserFileUploadServiceImpl implements UserFileUploadService {

    @Override
    public ResultBody userAvatarUpload(MultipartFile file) {
        if (file.getSize() > FileConstant.FILE_SIZE) {
            return ResultBodyUtil.error(ResultTypeEnum.FILE_TOO_LARGE.getCode(),
                    ResultTypeEnum.FILE_TOO_LARGE.getMsg());
        }
        String url = FileUploadUtil.fileUpload(file, "user/user-info");
        return ResultBodyUtil.success(url);
    }
}

