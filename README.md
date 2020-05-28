# blog-dscn

#### 介绍
微服务博客系统

#### 软件架构
以Spring Cloud Alibaba为基本框架，Spring Boot 为单个模块开发的整体微服务架构

### 命名规范
1. 模块名以blog开始
2. pom文件版本以 V1.0.0开始，大改修改前面大版本，新增功能修改中间的版本，
修复bug修改最后的版本（都是在保证以前Api能正常使用的前提下发布的版本号）
3. 包命名，以前groupId + 工程名（不加blog）
4. 启动类，工程名 + Application + 端口号
5. 端口号从项目初始化的那天开始（5180--nacos的端口）递增 如 5190 5200
6. 全部严格遵守驼峰，见名之意（统一使用有道，或者idea插件的翻译）
7. 类名加上模板：
```java
/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
```
8. 方法名加上模板：
```java
/**
     * 功能描述: 
     *
     * @Author wcx
     * @param name
     * @return java.lang.String
     **/
```
9. controller层代码统一使用Swagger的注解进行标注
10. service、dao层代码方法上都需要注解
11. 数据库信息和一些容易变的信息全部使用nacos配置中心管理（使用权限高的bootstrap.yml）
12. 修改代码提交代码前 commit message 写好修改的内容（自己写的模块自便，修改别人模块写上）
13. 注入注解统一使用 @Autowired（爆红无所谓，可在dao层加上java自带的注解）
14. bean的注入统一使用@Bean + @Configuration（一般用于修改Spring的原生配置）


### 工具推荐
阿里巴巴的代码约束规范

### 参与贡献

1.  吴呈兴
2.  余少奇
3.  古俊斌
4.  崔梦辉

### 开发日志

1. 指定Main启动入口,用于jar包上线
```maven
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <!-- 指定该Main Class为全局的唯一入口 -->
                    <mainClass>com.jxkj.managecenter.ManageCenterApplication5220</mainClass>
                    <layout>ZIP</layout>
                </configuration>
                <executions>
                    <execution>
                        <goals>
                            <goal>repackage</goal><!--可以把依赖的包都打包到生成的Jar包中-->
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
```

### 开发BUG

1. 项目不支持**多人运动**,开发测试同一模块要更换接口.要么做好**时间管理**,错开时间测试.