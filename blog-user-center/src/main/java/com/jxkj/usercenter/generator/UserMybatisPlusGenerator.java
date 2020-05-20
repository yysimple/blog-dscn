package com.jxkj.usercenter.generator;

import com.jxkj.common.generator.MybatisPlusGenerator;
import com.jxkj.common.model.GeneratorEntity;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
public class UserMybatisPlusGenerator {
    public static void main(String[] args) {
        GeneratorEntity generatorEntity = new GeneratorEntity();
        generatorEntity.setAuthor("GuJunBin");
        generatorEntity.setParentPackage("com.jxkj.usercenter");
        generatorEntity.setUrl("jdbc:mysql://39.100.24.145:3306/db_blog_center?serverTimezone=UTC&useUnicode=true&useSSL=false&characterEncoding=utf8");
        generatorEntity.setUsername("db_blog_center");
        generatorEntity.setPassword("db_blog_center");
        generatorEntity.setProjectPath("F:\\Micro-service\\blog-dscn\\blog-user-center");
        MybatisPlusGenerator.generator(generatorEntity);

    }
}
