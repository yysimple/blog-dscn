-- MySQL dump 10.13  Distrib 8.0.16, for Linux (x86_64)
--
-- Host: localhost    Database: db_blog_resource
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
-- Table structure for table `t_resource`
--

DROP TABLE IF EXISTS `t_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_resource` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '资源 ID',
  `file_url` varchar(150) DEFAULT NULL COMMENT '资源文件路径',
  `resource_name` varchar(45) DEFAULT NULL COMMENT '资源名',
  `type_id` bigint(11) DEFAULT NULL COMMENT '所属分类ID',
  `integral` int(11) DEFAULT NULL COMMENT '所需积分',
  `tag` varchar(45) DEFAULT NULL COMMENT '资源标签',
  `message` varchar(255) DEFAULT NULL COMMENT '资源描述',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` int(1) NOT NULL DEFAULT '0' COMMENT '删除状态，0-未删除，1-已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_resource`
--

LOCK TABLES `t_resource` WRITE;
/*!40000 ALTER TABLE `t_resource` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_resource_type`
--

DROP TABLE IF EXISTS `t_resource_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_resource_type` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '类型ID',
  `type_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '资源类型名',
  `parent_id` bigint(11) DEFAULT NULL COMMENT '父分类ID',
  `type_level` int(11) DEFAULT NULL COMMENT '层级',
  `delete_status` int(1) NOT NULL DEFAULT '0' COMMENT '删除状态，0-未删除，1-已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_resource_type`
--

LOCK TABLES `t_resource_type` WRITE;
/*!40000 ALTER TABLE `t_resource_type` DISABLE KEYS */;
INSERT INTO `t_resource_type` VALUES (1,'安全技术',0,1,0),(2,'储存',0,1,0),(3,'操作系统',0,1,0),(4,'网络安全',1,2,0),(5,'网络攻防',1,2,0),(6,'系统安全',1,2,0),(7,'Dell',2,2,0),(8,'EMC',2,2,0),(9,'HP',2,2,0),(10,'DOS',3,2,0),(11,'Linux',3,2,0),(12,'MacOS',3,2,0);
/*!40000 ALTER TABLE `t_resource_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-18  8:15:57
