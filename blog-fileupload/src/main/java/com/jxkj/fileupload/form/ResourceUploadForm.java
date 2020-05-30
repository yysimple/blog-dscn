package com.jxkj.fileupload.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 功能描述: 资源上传表单
 *
 * @Author GuJunBin
 * @Version 1.0
 */
@Data
@ApiModel(value = "资源上传表单")
public class ResourceUploadForm {

    @ApiModelProperty(value = "资源文件")
    private MultipartFile file;

    @ApiModelProperty(value = "资源名")
    private String resourceName;

    @ApiModelProperty(value = "所属分类")
    private String type;

    @ApiModelProperty(value = "所需积分")
    private Integer integral;

    @ApiModelProperty(value = "资源标签")
    private List<String> tags;

    @ApiModelProperty(value = "资源描述")
    private String massage;
}
