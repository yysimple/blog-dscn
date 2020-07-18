package com.jxkj.fileupload.util;

import io.minio.MinioClient;
import io.minio.policy.BucketPolicy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.Locale;
import java.util.UUID;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
@Component
public class FileUploadUtil {

    private static String endpoint;

    private static String accessKey;

    private static String secretKey;

    @Value("${minio.endpoint}")
    public void setEndpoint(String endpoint) {
        FileUploadUtil.endpoint = endpoint;
    }

    @Value("${minio.accessKey}")
    public void setAccessKey(String accessKey) {
        FileUploadUtil.accessKey = accessKey;
    }

    @Value("${minio.secretKey}")
    public void setSecretKey(String secretKey) {
        FileUploadUtil.secretKey = secretKey;
    }
    public static String fileUpload(MultipartFile file, String dir) {
        if (file.isEmpty() || file.getSize() == 0) {
            return "文件为空";
        }
        try {
            //连接
            MinioClient minioClient = new MinioClient(endpoint, accessKey, secretKey);
            //是否存在名为“test”的bucket
            if (!minioClient.bucketExists("blog-dscn")) {
                minioClient.makeBucket("blog-dscn");
            }
            String fileName = file.getOriginalFilename();
            String newName = dir + "/" + LocalDate.now().toString() + "/" + UUID.randomUUID().toString().replaceAll("-", "")
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
