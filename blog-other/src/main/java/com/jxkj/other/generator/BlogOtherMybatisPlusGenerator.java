package com.jxkj.other.generator;

import com.jxkj.common.generator.MybatisPlusGenerator;
import com.jxkj.common.model.GeneratorEntity;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
public class BlogOtherMybatisPlusGenerator {
    public static void main(String[] args) {
        GeneratorEntity generatorEntity = new GeneratorEntity();
        generatorEntity.setAuthor("wcx");
        generatorEntity.setParentPackage("com.jxkj.other");
        generatorEntity.setUrl("jdbc:mysql://192.168.109.135:3306/db_blog_other?serverTimezone=UTC&useUnicode=true&useSSL=false&characterEncoding=utf8");
        generatorEntity.setUsername("db_blog_other");
        generatorEntity.setPassword("db_blog_other");
        generatorEntity.setProjectPath("F:\\Micro-service\\blog-dscn\\blog-other");
        String[] tables = {"t_account"};
        generatorEntity.setTableNames(tables);
        generatorEntity.setOpenSwagger(true);
        MybatisPlusGenerator.generator(generatorEntity);

    }
}
