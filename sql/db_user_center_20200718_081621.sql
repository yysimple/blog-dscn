-- MySQL dump 10.13  Distrib 8.0.16, for Linux (x86_64)
--
-- Host: localhost    Database: db_user_center
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
-- Table structure for table `t_industry`
--

DROP TABLE IF EXISTS `t_industry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_industry` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `industry_no` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '行业编号',
  `industry_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '行业名称',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` int(1) DEFAULT '0' COMMENT '删除状态，0为真实删除，1为假删',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='行业表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_industry`
--

LOCK TABLES `t_industry` WRITE;
/*!40000 ALTER TABLE `t_industry` DISABLE KEYS */;
INSERT INTO `t_industry` VALUES (1,'202005001','高级工程师','2020-06-26 13:47:55','2020-06-26 13:47:57',0),(2,'202005002','中级工程师','2020-06-26 13:48:14','2020-06-26 13:48:16',0),(3,'202005003','初级工程师','2020-06-26 13:48:34','2020-06-26 13:48:37',0),(4,'202005004','架构师','2020-06-26 13:48:51','2020-06-26 13:48:53',0),(5,'202005005','前端工程师','2020-06-26 13:49:22','2020-06-26 13:49:23',0),(6,'202005006','UI','2020-06-26 13:50:48','2020-06-26 13:50:49',0),(7,'202005007','全栈工程师','2020-06-26 13:51:05','2020-06-26 13:51:08',0),(8,'202005008','数据库工程师','2020-06-26 13:51:54','2020-06-26 13:51:55',0),(9,'202005009','运维','2020-06-26 13:52:14','2020-06-26 13:52:17',0),(10,'202005010','项目经理','2020-06-26 13:52:42','2020-06-26 13:52:44',0);
/*!40000 ALTER TABLE `t_industry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role`
--

DROP TABLE IF EXISTS `t_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_role` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色名称',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` int(1) DEFAULT '0' COMMENT '删除状态，0为真实删除，1为假删',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role`
--

LOCK TABLES `t_role` WRITE;
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` VALUES (1,'ROLE_ADMIN','2020-05-23 01:57:25','2020-05-23 01:57:26',1),(2,'ROLE_USER','2020-05-23 01:57:38','2020-05-23 01:57:39',1);
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL COMMENT '用户名',
  `password` varchar(45) NOT NULL COMMENT '密码',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `delete_status` int(1) NOT NULL DEFAULT '0' COMMENT '删除状态，0为真实删除，1为假删',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (17,'string1','string1','2020-05-27 01:56:31','2020-05-27 01:56:31',0),(18,'ysq','123456','2020-06-11 07:47:42','2020-06-11 07:47:44',0),(19,'admin','123456','2020-06-11 07:48:15','2020-06-11 07:48:17',0),(20,'gjb','123456','2020-06-20 04:42:02','2020-06-20 04:42:02',0),(21,'gtl','123456','2020-06-20 11:17:26','2020-06-20 11:17:26',0),(22,'twlz','123456','2020-06-20 11:22:14','2020-06-20 11:22:14',0),(23,'kb','123456','2020-06-20 11:25:15','2020-06-20 11:25:15',0),(24,'zms','123456','2020-06-20 11:26:13','2020-06-20 11:26:13',0),(25,'wcx','123456','2020-06-22 11:14:57','2020-06-22 11:14:57',0);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_fans`
--

DROP TABLE IF EXISTS `t_user_fans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_user_fans` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) DEFAULT NULL,
  `fan_id` bigint(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户粉丝表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_fans`
--

LOCK TABLES `t_user_fans` WRITE;
/*!40000 ALTER TABLE `t_user_fans` DISABLE KEYS */;
INSERT INTO `t_user_fans` VALUES (1,18,22,'2020-06-20 14:04:17','2020-06-20 14:04:19',1),(2,18,17,'2020-06-20 14:04:29','2020-06-20 14:04:28',1),(3,18,25,'2020-06-25 03:50:43','2020-06-28 08:26:55',0),(4,18,18,'2020-06-28 07:56:56','2020-07-10 08:21:56',1);
/*!40000 ALTER TABLE `t_user_fans` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_info`
--

DROP TABLE IF EXISTS `t_user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_user_info` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `real_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '真实姓名',
  `nickname` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '昵称',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `address` varchar(45) DEFAULT NULL COMMENT '地址',
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `phone_number` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号',
  `gender` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别',
  `position` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '职位',
  `company` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '公司',
  `education` varchar(10) DEFAULT NULL COMMENT '学历',
  `industry` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '行业',
  `start_working_time` date DEFAULT NULL COMMENT '开始工作时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '个人简介',
  `t_user_id` bigint(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` int(1) DEFAULT '0' COMMENT '删除状态，0为真实删除，1为假删',
  `avatar_url` varchar(255) DEFAULT NULL,
  `school` varchar(55) DEFAULT NULL COMMENT '学校',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='用户详细信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_info`
--

LOCK TABLES `t_user_info` WRITE;
/*!40000 ALTER TABLE `t_user_info` DISABLE KEYS */;
INSERT INTO `t_user_info` VALUES (3,'string','string','2020-05-27','string','string','string','男','string','string','string','string','2020-05-27','string',17,'2020-05-27 01:56:32','2020-06-26 11:05:48',0,'http://39.100.24.145:9000/blog-dscn/user/user-info/605a6a7d702e406cb056f67f7b3c95d5-ysq.jpg',NULL),(4,'yushaoqi','qier','2020-06-11','江西南昌江西科技学院','1449998887@qq.com','18379472311','男','高级工程师','阿里','本科','软件开发','2020-06-11','大牛',18,'2020-06-11 16:21:07','2020-06-28 07:58:08',0,'http://39.100.24.145:9000/blog-dscn/user/user-info/2a6e8d838fa34f289ffae0edc0edaca8-dscn-login-bg1.jpg',NULL),(5,NULL,NULL,NULL,'123456',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,20,'2020-06-20 04:42:03','2020-06-24 11:24:51',0,'http://39.100.24.145:9000/blog-dscn/user/user-info/605a6a7d702e406cb056f67f7b3c95d5-ysq.jpg',NULL),(6,NULL,'ggg',NULL,NULL,NULL,'15932966658',NULL,NULL,NULL,NULL,NULL,NULL,NULL,21,'2020-06-20 11:17:27','2020-06-24 11:24:51',0,'http://39.100.24.145:9000/blog-dscn/user/user-info/605a6a7d702e406cb056f67f7b3c95d5-ysq.jpg',NULL),(7,NULL,'ttt',NULL,NULL,NULL,'15932966659',NULL,NULL,NULL,NULL,NULL,NULL,NULL,22,'2020-06-20 11:22:15','2020-06-24 11:24:51',0,'http://39.100.24.145:9000/blog-dscn/user/user-info/605a6a7d702e406cb056f67f7b3c95d5-ysq.jpg',NULL),(8,NULL,'kkk',NULL,NULL,NULL,'15932966657',NULL,NULL,NULL,NULL,NULL,NULL,NULL,23,'2020-06-20 11:25:16','2020-06-24 11:24:50',0,'http://39.100.24.145:9000/blog-dscn/user/user-info/605a6a7d702e406cb056f67f7b3c95d5-ysq.jpg',NULL),(9,NULL,'zzz',NULL,NULL,NULL,'15932966653',NULL,NULL,NULL,NULL,NULL,NULL,NULL,24,'2020-06-20 11:26:13','2020-06-24 11:24:51',0,'http://39.100.24.145:9000/blog-dscn/user/user-info/605a6a7d702e406cb056f67f7b3c95d5-ysq.jpg',NULL),(10,'wcx','yysimple','1997-04-12','江西科技学院','12131331@qq.com','15932966658','男','高级工程师','阿里','本科','架构师','2019-06-20','热爱敲代码',25,'2020-06-22 11:14:58','2020-06-27 15:24:07',0,'http://39.100.24.145:9000/blog-dscn/user/user-info/b652137b7fc04387b3309578b0873820-dscn-login-bg2.jpg','江西科技学院');
/*!40000 ALTER TABLE `t_user_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_level`
--

DROP TABLE IF EXISTS `t_user_level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_user_level` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `level` int(3) NOT NULL DEFAULT '1' COMMENT '级别',
  `score` int(11) NOT NULL DEFAULT '0' COMMENT '积分数',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` int(1) NOT NULL DEFAULT '0' COMMENT '删除状态，0为隐藏，1为显示',
  `t_user_id` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='用户等级表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_level`
--

LOCK TABLES `t_user_level` WRITE;
/*!40000 ALTER TABLE `t_user_level` DISABLE KEYS */;
INSERT INTO `t_user_level` VALUES (2,1,40,'2020-05-27 02:43:58','2020-05-27 03:12:30',0,17),(3,1,36,'2020-06-20 04:30:44','2020-07-13 03:43:22',0,18),(4,1,0,'2020-06-20 04:42:44','2020-07-04 14:19:45',0,20),(5,1,0,'2020-06-20 11:17:27','2020-06-20 11:17:27',0,21),(6,1,0,'2020-06-20 11:22:15','2020-06-20 11:22:15',0,22),(7,1,0,'2020-06-20 11:25:16','2020-06-20 11:25:16',0,23),(8,1,0,'2020-06-20 11:26:13','2020-06-20 11:26:13',0,24),(9,1,20,'2020-06-22 11:14:58','2020-07-11 03:18:36',0,25);
/*!40000 ALTER TABLE `t_user_level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_role`
--

DROP TABLE IF EXISTS `t_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_user_role` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `t_user_id` bigint(11) NOT NULL COMMENT '用户id',
  `t_role_id` bigint(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='用户角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_role`
--

LOCK TABLES `t_user_role` WRITE;
/*!40000 ALTER TABLE `t_user_role` DISABLE KEYS */;
INSERT INTO `t_user_role` VALUES (1,17,2),(2,18,2),(3,19,1),(4,20,2),(5,21,2),(6,22,2),(7,23,2),(8,24,2),(9,25,2);
/*!40000 ALTER TABLE `t_user_role` ENABLE KEYS */;
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

-- Dump completed on 2020-07-18  8:16:21
