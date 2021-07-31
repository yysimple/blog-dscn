-- MySQL dump 10.13  Distrib 8.0.16, for Linux (x86_64)
--
-- Host: localhost    Database: db_blog_center
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_blog_favorites_user`
--

DROP TABLE IF EXISTS `t_blog_favorites_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_blog_favorites_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) DEFAULT NULL COMMENT '用户id',
  `blog_id` bigint(11) DEFAULT NULL COMMENT '博客id',
  `favorites_id` bigint(11) DEFAULT NULL COMMENT '收藏夹ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1269545651566309378 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_blog_favorites_user`
--

LOCK TABLES `t_blog_favorites_user` WRITE;
/*!40000 ALTER TABLE `t_blog_favorites_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_blog_favorites_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_blog_info`
--

DROP TABLE IF EXISTS `t_blog_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_blog_info` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '博客id',
  `title` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '博客标题',
  `content` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '博客内容',
  `page_view_num` int(11) NOT NULL DEFAULT '0' COMMENT '博客浏览数',
  `like_num` int(11) NOT NULL DEFAULT '0' COMMENT '点赞数',
  `blog_link_url` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '博客链接',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` int(1) NOT NULL DEFAULT '0' COMMENT '删除状态，0-未删除，1-已删除',
  `t_user_id` bigint(11) DEFAULT NULL COMMENT '用户id',
  `blog_status` int(1) NOT NULL DEFAULT '0' COMMENT '博客状态，0为草稿，1为发布',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8 COMMENT='博客基本信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_blog_info`
--

LOCK TABLES `t_blog_info` WRITE;
/*!40000 ALTER TABLE `t_blog_info` DISABLE KEYS */;
INSERT INTO `t_blog_info` VALUES (50,'测试50','Canal is a high performance data synchronization system based on MySQL binary log. Canal is widely used in Alibaba group (including https://www.taobao.com) to provide reliable low latency incremental data pipeline.\r\n\r\nCanal Server is capable of parsing MySQL binlog and subscribe to the data change, while Canal Client can be implemented to broadcast the change to anywhere, e.g. database and Apache Kafka.\r\n\r\nIt has following features:\r\n\r\nSupport all platforms.\r\nSupport fine-grained system monitoring, powered by Prometheus.\r\nSupport parsing and subscription to MySQL binlog by different ways, e.g. by GTID.\r\nSupport high performance, real-time data synchronization. (See more at Performance)\r\nBoth Canal Server and Canal Client support HA/Scalability, powered by Apache ZooKeeper\r\nDocker Supports.\r\nBackgrounds\r\nIn the early days, Alibaba B2B Company needed to syncrhonize servers\' data between the United States and Hangzhou, China. Previous database synchronization machenism was based on the trigger to obtain incremental updates. Starting from 2010, Alibaba Group began to use dataset binary log to get the incremental updates and synchronize data across servers, which gave birth to our incremental subscription & consumption service (available now in Alibaba Cloud) and started a new era.\r\n\r\nHow it works\r\nMySQL Master-Slave Replication Implementation',65,87,NULL,'2020-06-15 08:00:26','2020-06-24 11:33:54',0,18,0),(51,'测试51','奥术大师大所多撒大所多',21,443,NULL,'2020-06-15 08:02:28','2020-06-28 03:56:12',0,18,2),(52,'测试52','奥术大师大所多撒大所多',21,325,NULL,'2020-06-15 08:25:56','2020-06-28 02:43:09',0,18,1),(53,'测试53','我没有点击保存 不知道可以执行成功不',23,21,NULL,'2020-06-15 08:53:08','2020-06-28 03:56:12',0,18,2),(54,'测试5555','',44,2,NULL,'2020-06-15 09:15:24','2020-06-19 09:19:37',0,18,0),(55,'lol','## 二级标题\nxzXzxzxZXzx',44,4,NULL,'2020-06-15 09:36:20','2020-06-28 02:43:09',0,18,1),(56,'而我却二全完','而我却二全完而我却二',212,33,NULL,'2020-06-15 13:12:27','2020-06-28 03:56:12',0,18,1),(57,'而我却二王企鹅为2','威锋网氛围氛围氛围氛围',4,4,NULL,'2020-06-15 15:30:10','2020-06-28 03:56:12',0,18,1),(58,'今天真是个好日子aaaaa','今天多云转晴，局部地区可能会有小雨，希望各位在路上注意安全，我们马上就要离开我们所爱的学校了，真的是太遗憾了，还有很多事情没有做完，还有很多东西也没有做完，就感觉几年的时间过得真的是太快了，都没来得及！！！今天多云转晴，局部地区可能会有小雨，希望各位在路上注意安全，我们马上就要离开我们所爱的学校了，真的是太遗憾了，还有很多事情没有做完，还有很多东西也没有做完，就感觉几年的时间过得真的是太快了，都没来得及！！！今天多云转晴，局部地区可能会有小雨，希望各位在路上注意安全，我们马上就要离开我们所爱的学校了，真的是太遗憾了，还有很多事情没有做完，还有很多东西也没有做完，就感觉几年的时间过得真的是太快了，都没来得及！！！今天多云转晴，局部地区可能会有小雨，希望各位在路上注意安全，我们马上就要离开我们所爱的学校了，真的是太遗憾了，还有很多事情没有做完，还有很多东西也没有做完，就感觉几年的时间过得真的是太快了，都没来得及！！！',5,43,NULL,'2020-06-16 15:24:47','2020-06-28 02:43:09',0,18,1),(63,'你好啊-hh','## 今天正好\n今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！今天真是个好日子啊！！\n![企业.jpg](http://39.100.24.145:9000/blog-dscn/blog/blog-info/681e3ba007a248b2947f5615f8314f9b-dscn-%E4%BC%81%E4%B8%9A.jpg)',56,6,NULL,'2020-06-17 10:37:29','2020-06-28 03:56:12',0,18,1),(64,'测试又来了','# 开始测试\n准备一下测试环境比如：\n在 CSS2 中添加圆角棘手。我们不得不在每个角落使用不同的图像。\n在 CSS3 中，很容易创建圆角。\n在 CSS3 中 border-radius 属性被用于创建圆角：\n这是圆角边框！\n有了 CSS3 的 border-image 属性，你可以使用图像创建一个边框：\nborder-image 属性允许你指定一个图片作为边框！ 用于创建上文边框的原始图像：\n在 div 中使用图片创建边框:\n## 进行学习\nJavaScript 是互联网上最流行的脚本语言，这门语言可用于 HTML 和 web，更可广泛用于服务器、PC、笔记本电脑、平板电脑和智能手机等设备。\nJavaScript 是脚本语言\nJavaScript 是一种轻量级的编程语言。\nJavaScript 是可插入 HTML 页面的编程代码。\nJavaScript 插入 HTML 页面后，可由所有的现代浏览器执行。\nJavaScript 很容易学习',0,0,NULL,'2020-06-19 16:10:00','2020-06-28 03:56:12',0,18,1),(65,'继续测试','Canal is a high performance data synchronization system based on MySQL binary log. Canal is widely used in Alibaba group (including https://www.taobao.com) to provide reliable low latency incremental data pipeline.\n\nCanal Server is capable of parsing MySQL binlog and subscribe to the data change, while Canal Client can be implemented to broadcast the change to anywhere, e.g. database and Apache Kafka.\n\nIt has following features:\n\nSupport all platforms.\nSupport fine-grained system monitoring, powered by Prometheus.\nSupport parsing and subscription to MySQL binlog by different ways, e.g. by GTID.\nSupport high performance, real-time data synchronization. (See more at Performance)\nBoth Canal Server and Canal Client support HA/Scalability, powered by Apache ZooKeeper\nDocker Supports.\nBackgrounds\nIn the early days, Alibaba B2B Company needed to syncrhonize servers\' data between the United States and Hangzhou, China. Previous database synchronization machenism was based on the trigger to obtain incremental updates. Starting from 2010, Alibaba Group began to use dataset binary log to get the incremental updates and synchronize data across servers, which gave birth to our incremental subscription & consumption service (available now in Alibaba Cloud) and started a new era.\n\nHow it works\nMySQL Master-Slave Replication Implementation',0,0,NULL,'2020-06-19 16:19:06','2020-06-28 02:43:09',0,18,1),(66,'继续测试侧测试','Canal is a high performance data synchronization system based on MySQL binary log. Canal is widely used in Alibaba group (including https://www.taobao.com) to provide reliable low latency incremental data pipeline.\n\nCanal Server is capable of parsing MySQL binlog and subscribe to the data change, while Canal Client can be implemented to broadcast the change to anywhere, e.g. database and Apache Kafka.\n\nIt has following features:\n\nSupport all platforms.\nSupport fine-grained system monitoring, powered by Prometheus.\nSupport parsing and subscription to MySQL binlog by different ways, e.g. by GTID.\nSupport high performance, real-time data synchronization. (See more at Performance)\nBoth Canal Server and Canal Client support HA/Scalability, powered by Apache ZooKeeper\nDocker Supports.\nBackgrounds\nIn the early days, Alibaba B2B Company needed to syncrhonize servers\' data between the United States and Hangzhou, China. Previous database synchronization machenism was based on the trigger to obtain incremental updates. Starting from 2010, Alibaba Group began to use dataset binary log to get the incremental updates and synchronize data across servers, which gave birth to our incremental subscription & consumption service (available now in Alibaba Cloud) and started a new era.\n\nHow it works\nMySQL Master-Slave Replication Implementation',0,0,NULL,'2020-06-19 16:20:08','2020-06-28 03:56:13',0,18,1),(67,'测试积分增加','## 测试\n积分是否会进行增加',0,0,NULL,'2020-06-20 11:37:46','2020-06-28 02:43:09',0,18,2),(68,'来来来来，spring','![image.png](http://39.100.24.145:9000/blog-dscn/blog/blog-info/0eb144ca6b8f4703879207a5d070f47f-dscn-image.png)\nSpring Boot Documentation\nBack to index\n1. About the Documentation\n2. Getting Help\n3. First Steps\n4. Working with Spring Boot\n5. Learning about Spring Boot Features\n6. Moving to Production\n7. Advanced Topics\nThis section provides a brief overview of Spring Boot reference documentation. It serves as a map for the rest of the document.\n\n1. About the Documentation\nThe Spring Boot reference guide is available as:\n\nMulti-page HTML\n\nSingle page HTML\n\nPDF\n\nThe latest copy is available at docs.spring.io/spring-boot/docs/current/reference/.\n\nCopies of this document may be made for your own use and for distribution to others, provided that you do not charge any fee for such copies and further provided that each copy contains this Copyright Notice, whether distributed in print or electronically.\n\n2. Getting Help\nIf you have trouble with Spring Boot, we would like to help.\n\nTry the How-to documents. They provide solutions to the most common questions.\n\nLearn the Spring basics. Spring Boot builds on many other Spring projects. Check the spring.io web-site for a wealth of reference documentation. If you are starting out with Spring, try one of the guides.\n\nAsk a question. We monitor stackoverflow.com for questions tagged with spring-boot.\n\nReport bugs with Spring Boot at github.com/spring-projects/spring-boot/issues.\n\nAll of Spring Boot is open source, including the documentation. If you find problems with the docs or if you want to improve them, please get involved.\n3. First Steps\nIf you are getting started with Spring Boot or \'Spring\' in general, start with the following topics:\n\nFrom scratch: Overview | Requirements | Installation\n\nTutorial: Part 1 | Part 2\n\nRunning your example: Part 1 | Part 2\n\n4. Working with Spring Boot\nReady to actually start using Spring Boot? We have you covered:\n\nBuild systems: Maven | Gradle | Ant | Starters\n\nBest practices: Code Structure | @Configuration | @EnableAutoConfiguration | Beans and Dependency Injection\n\nRunning your code: IDE | Packaged | Maven | Gradle\n\nPackaging your app: Production jars\n\nSpring Boot CLI: Using the CLI\n\n5. Learning about Spring Boot Features\nNeed more details about Spring Boot’s core features? The following content is for you:\n\nCore Features: SpringApplication | External Configuration | Profiles | Logging\n\nWeb Applications: MVC | Embedded Containers\n\nWorking with data: SQL | NO-SQL\n\nMessaging: Overview | JMS\n\nTesting: Overview | Boot Applications | Utils\n\nExtending: Auto-configuration | @Conditions\n\n6. Moving to Production\nWhen you are ready to push your Spring Boot application to production, we have some tricks that you might like:\n\nManagement endpoints: Overview\n\nConnection options: HTTP | J\n',0,0,NULL,'2020-06-21 15:59:48','2020-06-28 03:56:13',0,18,1),(69,'我是新用户，在来测试一下','# 我是一级标题\n我是来测试的，看看功能怎么样！！！\n## 我是二级标题\n```java\n<!--<a-breadcrumb style=\"margin: 16px 0\">\n       <a-breadcrumb-item>Home</a-breadcrumb-item>\n       <a-breadcrumb-item>List</a-breadcrumb-item>\n       <a-breadcrumb-item>App</a-breadcrumb-item>\n    </a-breadcrumb>-->\n```\n从实现上来说，MySQL Server 是多线程结构，包括后台线程和客户服务线程。多线程可以有效利用服务器资源，提高数据库的并发性能。在Mysql中，控制并发连接和线程的主要参数包括 max_connections、back_log、thread_cache_size、table_open_cahce。\n采用max_connections 控制允许连接到MySQL数据库的最大数量，默认值是 151。如果状态变量 connection_errors_max_connections 不为零，并且一直增长，则说明不断有连接请求因数据库连接数已达到允许最大值而失败，这是可以考虑增大max_connections 的值。\nMysql 最大可支持的连接数，取决于很多因素，包括给定操作系统平台的线程库的质量、内存大小、每个连接的负荷、CPU的处理速度，期望的响应时间等。在Linux 平台下，性能好的服务器，支持 500-1000 个连接不是难事，需要根据服务器性能进行评估设定。\n### 我是三级标题\n（3）InnoDB 的行锁的模式\nInnoDB 实现了以下两种类型的行锁。\n\n共享锁（S）：又称为读锁，简称S锁，共享锁就是多个事务对于同一数据可以共享一把锁，都能访问到数据，但是只能读不能修改。\n排他锁（X）：又称为写锁，简称X锁，排他锁就是不能与其他锁并存，如一个事务获取了一个数据行的排他锁，其他事务就不能再获取该行的其他锁，包括共享锁和排他锁，但是获取排他锁的事务是可以对数据就行读取和修改。\n对于UPDATE、DELETE和INSERT语句，InnoDB会自动给涉及数据集加排他锁（X)；\n对于普通SELECT语句，InnoDB不会加任何锁；\n\n可以通过以下语句显示给记录集加共享锁或排他锁 。\n\n',0,1,NULL,'2020-06-22 13:55:49','2020-06-28 03:56:12',0,25,1),(70,'测试一下','# 哈哈\n## 今天心情好\n的沙发和DAU返回的尽快发货萨芬哈实际开发has两极分化的框架发货撒尽快发货大姐夫辣的了发哈的接口发了哈代理费丰厚的萨拉九分裤时代峰峻康拉德发哈杜绝浪费哈加快递费哈加快递费had健康法had科技发货的房价看哈的房间爱刘德华',0,0,NULL,'2020-06-23 03:50:15','2020-06-28 03:56:12',0,25,1),(71,'Vue学习','Vue (读音 /vjuː/，类似于 view) 是一套用于构建用户界面的渐进式框架。与其它大型框架不同的是，Vue 被设计为可以自底向上逐层应用。Vue 的核心库只关注视图层，不仅易于上手，还便于与第三方库或既有项目整合。另一方面，当与现代化的工具链以及各种支持类库结合使用时，Vue 也完全能够为复杂的单页应用提供驱动。\n\n如果你想在深入学习 Vue 之前对它有更多了解，我们制作了一个视频，带您了解其核心概念和一个示例工程。\n\n如果你已经是有经验的前端开发者，想知道 Vue 与其它库/框架有哪些区别，请查看对比其它框架。\n\n起步\n观看本节视频讲解\n官方指南假设你已了解关于 HTML、CSS 和 JavaScript 的中级知识。如果你刚开始学习前端开发，将框架作为你的第一步可能不是最好的主意——掌握好基础知识再来吧！之前有其它框架的使用经验会有帮助，但这不是必需的。\n\n安装\n\n尝试 Vue.js 最简单的方法是使用 Hello World 例子。你可以在浏览器新标签页中打开它，跟着例子学习一些基础用法。或者你也可以创建一个 .html 文件，然后通过如下方式引入 Vue：\n\n<!-- 开发环境版本，包含了有帮助的命令行警告 -->\n<script src=\"https://cdn.jsdelivr.net/npm/vue/dist/vue.js\"></script>\n或者：\n\n<!-- 生产环境版本，优化了尺寸和速度 -->\n<script src=\"https://cdn.jsdelivr.net/npm/vue\"></script>\n安装教程给出了更多安装 Vue 的方式。请注意我们不推荐新手直接使用 vue-cli，尤其是在你还不熟悉基于 Node.js 的构建工具时。\n\n如果你喜欢交互式的东西，你也可以查阅这个 Scrimba 上的系列教程，它揉合了录屏和代码试验田，并允许你随时暂停和播放。\n\n声明式渲染\n观看本节视频讲解\nVue.js 的核心是一个允许采用简洁的模板语法来声明式地将数据渲染进 DOM 的系统：\n\n<div id=\"app\">\n  {{ message }}\n</div>\nvar app = new Vue({\n  el: \'#app\',\n  data: {\n    message: \'Hello Vue!\'\n  }\n})\n我们已经成功创建了第一个 Vue 应用！看起来这跟渲染一个字符串模板非常类似，但是 Vue 在背后做了大量工作。现在数据和 DOM 已经被建立了关联，所有东西都是响应式的。我们要怎么确认呢？打开你的浏览器的 JavaScript 控制台 (就在这个页面打开)，并修改 app.message 的值，你将看到上例相应地更新。\n\n注意我们不再和 HTML 直接交互了。一个 Vue 应用会将其挂载到一个 DOM 元素上 (对于这个例子是 #app) 然后对其进行完全控制。那个 HTML 是我们的入口，但其余都会发生在新创建的 Vue 实例内部。\n\n除了文本插值，我们还可以像这样来绑定元素 attribute：\n\n<div id=\"app-2\">\n  <span v-bind:title=\"message\">\n    鼠标悬停几秒钟查看此处动态绑定的提示信息！\n  </span>\n</div>\nvar app2 = new Vue({\n  el: \'#app-2\',\n  data: {\n    message: \'页面加载于 \' + new Date().toLocaleString()\n  }\n})\n这里我们遇到了一点新东西。你看到的 v-bind attribute 被称为指令。指令带有前缀 v-，以表示它们是 Vue 提供的特殊 attribute。可能你已经猜到了，它们会在渲染的 DOM 上应用特殊的响应式行为。在这里，该指令的意思是：“将这个元素节点的 title attribute 和 Vue 实例的 message property 保持一致”。\n\n如果你再次打开浏览器的 JavaScript 控制台，输入 app2.message = \'新消息\'，就会再一次看到这个绑定了 title attribute 的 HTML 已经进行了更新。\n\n条件与循环',0,0,NULL,'2020-06-28 08:14:01','2020-06-28 08:18:07',0,18,1),(72,'测试一哈子Vue','为了让用户和你的应用进行交互，我们可以用 v-on 指令添加一个事件监听器，通过它调用在 Vue 实例中定义的方法：\n\n<div id=\"app-5\">\n  <p>{{ message }}</p>\n  <button v-on:click=\"reverseMessage\">反转消息</button>\n</div>\nvar app5 = new Vue({\n  el: \'#app-5\',\n  data: {\n    message: \'Hello Vue.js!\'\n  },\n  methods: {\n    reverseMessage: function () {\n      this.message = this.message.split(\'\').reverse().join(\'\')\n    }\n  }\n})\n\n注意在 reverseMessage 方法中，我们更新了应用的状态，但没有触碰 DOM——所有的 DOM 操作都由 Vue 来处理，你编写的代码只需要关注逻辑层面即可。\n\nVue 还提供了 v-model 指令，它能轻松实现表单输入和应用状态之间的双向绑定。\n\n<div id=\"app-6\">\n  <p>{{ message }}</p>\n  <input v-model=\"message\">\n</div>\nvar app6 = new Vue({\n  el: \'#app-6\',\n  data: {\n    message: \'Hello Vue!\'\n  }\n})\n\nHello Vue!\n组件化应用构建\n观看本节视频讲解\n组件系统是 Vue 的另一个重要概念，因为它是一种抽象，允许我们使用小型、独立和通常可复用的组件构建大型应用。仔细想想，几乎任意类型的应用界面都可以抽象为一个组件树：\n\nComponent Tree\n\n在 Vue 里，一个组件本质上是一个拥有预定义选项的一个 Vue 实例。在 Vue 中注册组件很简单：\n\n// 定义名为 todo-item 的新组件\nVue.component(\'todo-item\', {\n  template: \'<li>这是个待办项</li>\'\n})\n\nvar app = new Vue(...)\n现在你可以用它构建另一个组件模板：\n\n<ol>\n  <!-- 创建一个 todo-item 组件的实例 -->\n  <todo-item></todo-item>\n</ol>\n但是这样会为每个待办项渲染同样的文本，这看',0,0,NULL,'2020-06-28 08:25:06','2020-06-28 08:26:19',0,18,1),(73,'11111111111111','aaaaaaaaaaaa',0,0,NULL,'2020-07-10 08:23:27','2020-07-10 08:23:27',0,18,1),(74,'11111111111111','aaaaaaaaaaaa',0,0,NULL,'2020-07-10 08:23:28','2020-07-10 08:23:28',0,18,1);
/*!40000 ALTER TABLE `t_blog_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_blog_info_category`
--

DROP TABLE IF EXISTS `t_blog_info_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_blog_info_category` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `t_blog_info_id` bigint(11) DEFAULT NULL,
  `t_category_column_id` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_blog_info_category`
--

LOCK TABLES `t_blog_info_category` WRITE;
/*!40000 ALTER TABLE `t_blog_info_category` DISABLE KEYS */;
INSERT INTO `t_blog_info_category` VALUES (1,58,2),(2,57,1),(3,56,1),(4,55,1),(9,63,10),(10,64,11),(11,65,1),(12,66,1),(13,67,1),(14,68,2),(15,69,10),(16,70,1),(17,50,1),(18,51,2),(19,53,3),(20,54,4),(21,59,5),(22,60,2),(23,61,3),(24,62,4),(25,71,12),(26,72,12),(27,73,3),(28,73,3),(29,73,3),(30,73,3),(31,73,3),(32,73,3),(33,73,3),(34,73,3),(35,74,3),(36,74,3),(37,74,3),(38,74,3),(39,74,3),(40,74,3),(41,74,3),(42,74,3);
/*!40000 ALTER TABLE `t_blog_info_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_blog_info_favorites`
--

DROP TABLE IF EXISTS `t_blog_info_favorites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_blog_info_favorites` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `blog_id` bigint(11) DEFAULT NULL,
  `favorites_id` bigint(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='博客收藏夹关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_blog_info_favorites`
--

LOCK TABLES `t_blog_info_favorites` WRITE;
/*!40000 ALTER TABLE `t_blog_info_favorites` DISABLE KEYS */;
INSERT INTO `t_blog_info_favorites` VALUES (1,63,27,'2020-06-20 13:48:01','2020-06-20 13:48:03'),(2,8,27,'2020-06-20 13:49:09','2020-06-20 13:49:10'),(3,11,28,'2020-06-20 13:49:17','2020-06-20 13:49:19'),(4,63,21,'2020-06-21 02:39:37','2020-06-21 02:39:39');
/*!40000 ALTER TABLE `t_blog_info_favorites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_blog_info_tag`
--

DROP TABLE IF EXISTS `t_blog_info_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_blog_info_tag` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `t_blog_info_id` bigint(11) NOT NULL COMMENT '博客id',
  `t_blog_tag_id` bigint(11) DEFAULT NULL COMMENT '博客分类id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8 COMMENT='博客信息和分类关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_blog_info_tag`
--

LOCK TABLES `t_blog_info_tag` WRITE;
/*!40000 ALTER TABLE `t_blog_info_tag` DISABLE KEYS */;
INSERT INTO `t_blog_info_tag` VALUES (56,50,2),(57,51,2),(58,52,2),(59,53,1),(60,54,2),(61,55,3),(62,56,2),(63,57,2),(64,58,3),(65,59,2),(69,63,2),(70,64,8),(71,65,2),(72,66,2),(73,67,2),(74,68,3),(75,69,2),(76,70,2),(77,71,5),(78,72,5),(79,73,2),(80,73,3),(81,73,8),(82,73,4),(83,73,4),(84,73,4),(85,73,4),(86,73,4),(87,73,4),(88,73,4),(89,73,4),(90,73,4),(91,73,4),(92,73,4),(93,73,4),(94,74,2),(95,74,3),(96,74,8),(97,74,4),(98,74,4),(99,74,4),(100,74,4),(101,74,4),(102,74,4),(103,74,4),(104,74,4),(105,74,4),(106,74,4),(107,74,4),(108,74,4);
/*!40000 ALTER TABLE `t_blog_info_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_blog_info_type`
--

DROP TABLE IF EXISTS `t_blog_info_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_blog_info_type` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `t_blog_info_id` bigint(11) DEFAULT NULL,
  `t_blog_type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_blog_info_type`
--

LOCK TABLES `t_blog_info_type` WRITE;
/*!40000 ALTER TABLE `t_blog_info_type` DISABLE KEYS */;
INSERT INTO `t_blog_info_type` VALUES (1,55,1),(2,56,1),(3,57,1),(5,50,1),(6,51,1),(7,52,1),(8,53,1),(9,54,1),(10,58,1),(15,63,1),(19,64,1),(20,65,1),(21,66,1),(22,67,1),(23,68,1),(24,69,1),(25,70,1),(26,59,1),(27,60,1),(28,61,1),(29,62,1),(30,71,1),(31,72,2),(32,73,2),(33,74,2);
/*!40000 ALTER TABLE `t_blog_info_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_blog_like_user`
--

DROP TABLE IF EXISTS `t_blog_like_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_blog_like_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `blog_id` bigint(11) DEFAULT NULL COMMENT '博客ID',
  `user_id` bigint(11) DEFAULT NULL COMMENT '用户ID',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `delete_status` int(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1269091257683140630 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_blog_like_user`
--

LOCK TABLES `t_blog_like_user` WRITE;
/*!40000 ALTER TABLE `t_blog_like_user` DISABLE KEYS */;
INSERT INTO `t_blog_like_user` VALUES (1269091257683140611,63,17,'2020-06-19 15:30:46','2020-06-19 15:30:48',1),(1269091257683140612,63,18,'2020-06-19 15:30:47','2020-06-19 15:30:49',1),(1269091257683140613,63,20,'2020-06-19 15:30:50','2020-06-19 15:30:50',1),(1269091257683140614,63,21,'2020-06-19 15:30:51','2020-06-19 15:30:52',1),(1269091257683140615,69,18,'2020-06-24 14:34:33','2020-06-24 14:34:33',1),(1269091257683140628,53,25,'2020-06-24 15:56:33','2020-06-24 15:56:33',1),(1269091257683140629,72,25,'2020-06-28 08:26:06','2020-06-28 08:26:06',1);
/*!40000 ALTER TABLE `t_blog_like_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_blog_tag`
--

DROP TABLE IF EXISTS `t_blog_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_blog_tag` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '标签名',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `delete_status` int(1) DEFAULT '0' COMMENT '删除状态，0为真实删除，1为假删',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='博客所属类别表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_blog_tag`
--

LOCK TABLES `t_blog_tag` WRITE;
/*!40000 ALTER TABLE `t_blog_tag` DISABLE KEYS */;
INSERT INTO `t_blog_tag` VALUES (1,'推荐','2020-05-22 08:06:03','2020-05-27 19:46:07',0),(2,'动态','2020-05-22 08:13:48','2020-05-27 19:48:17',0),(3,'SpringBoot','2020-05-22 08:16:32','2020-05-22 08:46:06',0),(4,'SpringCloud','2020-05-22 20:02:35','2020-05-22 20:02:35',0),(5,'Vue','2020-05-22 22:38:39','2020-05-22 22:39:51',0),(6,'mysql','2020-06-13 15:40:15','2020-06-13 15:40:15',0),(7,'Go','2020-06-13 16:05:09','2020-06-13 16:05:09',0),(8,'JavaScript','2020-06-19 16:10:01','2020-06-19 16:10:01',0);
/*!40000 ALTER TABLE `t_blog_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_blog_type`
--

DROP TABLE IF EXISTS `t_blog_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_blog_type` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '博客类型',
  `status` int(1) NOT NULL DEFAULT '0',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `delete_status` int(1) NOT NULL DEFAULT '0' COMMENT '删除状态，0为真实删除，1为假删',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='博客类型表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_blog_type`
--

LOCK TABLES `t_blog_type` WRITE;
/*!40000 ALTER TABLE `t_blog_type` DISABLE KEYS */;
INSERT INTO `t_blog_type` VALUES (1,'原创',0,'2020-05-21 18:46:07','2020-05-21 18:46:07',0),(2,'转载',0,'2020-05-22 07:48:30','2020-05-22 07:48:30',0),(3,'翻译',0,'2020-06-13 15:23:40','2020-06-13 15:23:42',0);
/*!40000 ALTER TABLE `t_blog_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_category_column`
--

DROP TABLE IF EXISTS `t_category_column`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_category_column` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(55) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `delete_status` int(11) DEFAULT '0',
  `t_user_id` bigint(11) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='分类专栏';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_category_column`
--

LOCK TABLES `t_category_column` WRITE;
/*!40000 ALTER TABLE `t_category_column` DISABLE KEYS */;
INSERT INTO `t_category_column` VALUES (1,'java','2020-06-12 15:26:34','2020-06-12 15:26:36',0,18,NULL),(2,'Spring','2020-06-12 15:27:07','2020-06-12 15:27:08',0,18,NULL),(3,'mysql','2020-06-12 15:27:26','2020-06-12 15:27:28',0,18,NULL),(4,'redis','2020-06-12 15:27:41','2020-06-12 15:27:42',0,18,NULL),(5,'docker','2020-06-12 15:27:59','2020-06-12 15:28:01',0,18,NULL),(10,'生活','2020-06-17 02:37:30','2020-06-17 02:37:30',0,18,NULL),(11,'JavaScript','2020-06-19 16:10:01','2020-06-19 16:10:01',0,18,NULL),(12,'Vue','2020-06-28 08:14:01','2020-06-28 08:14:01',0,18,NULL);
/*!40000 ALTER TABLE `t_category_column` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_comment`
--

DROP TABLE IF EXISTS `t_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_comment` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '评论内容',
  `t_blog_info_id` bigint(11) DEFAULT NULL COMMENT '关联博客id',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `delete_status` int(1) NOT NULL DEFAULT '0' COMMENT '删除状态，0为真实删除，1为假删',
  `comment_user_id` bigint(11) DEFAULT NULL COMMENT '该条评论对应的用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_comment`
--

LOCK TABLES `t_comment` WRITE;
/*!40000 ALTER TABLE `t_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_favorites`
--

DROP TABLE IF EXISTS `t_favorites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_favorites` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `favorites_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收藏夹名称',
  `followers` int(11) NOT NULL DEFAULT '0' COMMENT '收藏夹关注数',
  `show_status` int(1) NOT NULL DEFAULT '0' COMMENT '收藏夹的状态，0为公开，1为私密',
  `description` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `delete_status` int(1) NOT NULL DEFAULT '0' COMMENT '删除状态，0-未删除，1-已删除',
  `t_user_id` bigint(11) DEFAULT NULL COMMENT '收藏夹对应的用户id',
  `picture` varchar(255) DEFAULT NULL COMMENT '收藏夹图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='收藏夹表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_favorites`
--

LOCK TABLES `t_favorites` WRITE;
/*!40000 ALTER TABLE `t_favorites` DISABLE KEYS */;
INSERT INTO `t_favorites` VALUES (1,'Spring',0,0,'string','2020-05-21 11:20:24','2020-05-22 04:08:30',1,1,NULL),(2,'SpringDate JPA',0,0,'string','2020-05-21 11:20:36','2020-05-21 19:45:50',0,1,NULL),(3,'Spring MVC',0,0,NULL,'2020-05-21 11:20:40','2020-05-21 11:20:40',0,1,NULL),(4,'Spring Boot',0,0,NULL,'2020-05-21 04:52:25','2020-05-21 04:52:25',0,1,NULL),(5,'Spring Cloud',0,0,NULL,'2020-05-21 04:53:29','2020-05-21 04:53:29',0,1,NULL),(6,'Spring Cloud Alibaba',0,0,NULL,'2020-05-21 13:07:00','2020-05-21 13:07:00',0,1,NULL),(7,'JavaScript',0,0,NULL,'2020-05-21 05:21:47','2020-05-21 05:21:47',0,1,NULL),(8,'Vue',0,0,NULL,'2020-05-21 05:22:09','2020-05-21 05:22:09',0,1,NULL),(9,'PHP',0,0,NULL,'2020-05-21 05:22:22','2020-05-21 05:22:22',0,1,NULL),(10,'GO',0,0,NULL,'2020-05-21 13:35:29','2020-05-21 13:35:29',0,1,NULL),(11,'Spring',0,0,NULL,'2020-05-21 05:47:29','2020-05-21 05:47:29',0,2,NULL),(12,'SpringDate JPA',0,0,NULL,'2020-05-21 05:47:43','2020-05-21 05:47:43',0,2,NULL),(13,'Spring MVC',0,0,NULL,'2020-05-21 05:48:06','2020-05-21 05:48:06',0,2,NULL),(14,'Spring Boot',0,0,NULL,'2020-05-21 05:48:23','2020-05-21 05:48:23',0,2,NULL),(15,'Spring Cloud',0,0,NULL,'2020-05-21 13:49:20','2020-05-21 13:49:20',0,2,NULL),(16,'Spring Cloud Alibaba',0,0,NULL,'2020-05-21 05:53:23','2020-05-21 05:53:23',0,2,NULL),(17,'JavaScript',0,0,NULL,'2020-05-21 05:53:42','2020-05-21 05:53:42',0,2,NULL),(18,'Vue',0,0,NULL,'2020-05-21 13:56:18','2020-05-21 13:56:18',0,2,NULL),(19,'PHP',0,0,NULL,'2020-05-21 05:58:40','2020-05-21 05:58:40',0,2,NULL),(20,'GO',1,1,'demoData','2020-05-21 06:05:19','2020-05-21 06:05:19',0,2,NULL),(21,'Spring',1,1,'demoData','2020-05-21 06:05:21','2020-05-21 06:05:21',0,3,NULL),(22,'SpringDate JPA',0,0,NULL,'2020-05-21 06:11:36','2020-05-21 06:11:36',0,3,NULL),(23,'Spring MVC',0,0,'string','2020-05-21 06:34:20','2020-05-21 06:34:20',0,3,NULL),(24,'Spring Boot',0,0,'string','2020-05-21 14:34:59','2020-05-21 14:34:59',0,3,NULL),(25,'Spring Cloud',0,0,'string','2020-05-22 04:08:58','2020-05-22 04:08:58',0,3,NULL),(26,'Spring Cloud Alibaba',0,0,'string','2020-05-22 08:17:24','2020-05-22 08:17:24',0,3,NULL),(27,'spring',0,0,'18号用户的','2020-06-20 13:23:04','2020-06-20 13:23:06',0,18,NULL),(28,'兴趣',0,0,'还是18','2020-06-20 13:24:41','2020-06-20 13:23:40',0,18,NULL);
/*!40000 ALTER TABLE `t_favorites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_reply`
--

DROP TABLE IF EXISTS `t_reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_reply` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '回复内容',
  `reply_type` varchar(25) NOT NULL COMMENT '回复类型，区分是回复评论，还是回复的回复(comment,reply)',
  `t_comment_id` bigint(11) DEFAULT NULL COMMENT '评论的id',
  `t_reply_id` bigint(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `delete_status` int(1) DEFAULT '0' COMMENT '删除状态，0为真实删除，1为假删',
  `reply_user_id` bigint(11) DEFAULT NULL COMMENT '该条评论的回复用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='回复表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_reply`
--

LOCK TABLES `t_reply` WRITE;
/*!40000 ALTER TABLE `t_reply` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `undo_log`
--

DROP TABLE IF EXISTS `undo_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) NOT NULL,
  `context` varchar(128) NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  `ext` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `undo_log`
--

LOCK TABLES `undo_log` WRITE;
/*!40000 ALTER TABLE `undo_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `undo_log` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-18  8:16:16
