package com.jxkj.blogsystem.generator;

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
        generatorEntity.setAuthor("ysq");
        generatorEntity.setParentPackage("com.jxkj.blogsystem");
        generatorEntity.setUrl("jdbc:mysql://39.100.24.145:3306/db_blog_system?serverTimezone=UTC&useUnicode=true&useSSL=false&characterEncoding=utf8");
        generatorEntity.setUsername("db_blog_system");
        generatorEntity.setPassword("db_blog_system");
        generatorEntity.setProjectPath("D:\\springboot\\blog-dscn\\blog-system");
        MybatisPlusGenerator.generator(generatorEntity);

    }
}
