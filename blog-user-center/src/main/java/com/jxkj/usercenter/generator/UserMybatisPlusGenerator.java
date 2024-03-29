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
        generatorEntity.setAuthor("wcx");
        generatorEntity.setParentPackage("com.jxkj.usercenter");
        generatorEntity.setUrl("jdbc:mysql://192.168.109.135:3306/db_user_center?serverTimezone=UTC&useUnicode=true&useSSL=false&characterEncoding=utf8");
        generatorEntity.setUsername("db_user_center");
        generatorEntity.setPassword("db_user_center");
        generatorEntity.setProjectPath("F:\\Micro-service\\blog-dscn\\blog-user-center");
        String[] tables = {"t_storage"};
        generatorEntity.setTableNames(tables);
        generatorEntity.setOpenSwagger(true);
        MybatisPlusGenerator.generator(generatorEntity);

    }
}
