package com.jxkj.fileupload.util;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
@Component
public class FileUploadUtil {
    public static String url;

    public static String port;

    @Value("${minio.url}")
    public void setUrl(String url) {
        FileUploadUtil.url = url;
    }

    @Value("${minio.port}")
    public void setPort(String port) {
        FileUploadUtil.port = port;
    }

    public static String fileUpload(MultipartFile file, String dir) {
        if (file.isEmpty() || file.getSize() == 0) {
            return "文件为空";
        }
        try {
            //连接
            MinioClient minioClient = new MinioClient(url + port, "minioadmin", "minioadmin");
            //是否存在名为“test”的bucket
            if (!minioClient.bucketExists("blog-dscn")) {
                minioClient.makeBucket("blog-dscn");
            }
            String fileName = file.getOriginalFilename();
            String newName = dir + "/" + UUID.randomUUID().toString().replaceAll("-", "")
                    + "-dscn-" + fileName;
            //新的名称，pic会是bucket下的文件夹
            //获取file的inputStream
            InputStream inputStream = file.getInputStream();
            // 上传
            minioClient.putObject("blog-dscn", newName, inputStream, "application/octet-stream");
            inputStream.close();
            //文件访问路径
            String url = minioClient.getObjectUrl("blog-dscn", newName);
            return url;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "上传失败";
    }
}
