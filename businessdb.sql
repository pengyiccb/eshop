-- MySQL dump 10.13  Distrib 5.7.22, for osx10.13 (x86_64)
--
-- Host: localhost    Database: businessdb
-- ------------------------------------------------------
-- Server version	5.7.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `businessdb`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `businessdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `businessdb`;

--
-- Table structure for table `demo`
--

DROP TABLE IF EXISTS `demo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `demo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `money` float(255,0) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `demo`
--

LOCK TABLES `demo` WRITE;
/*!40000 ALTER TABLE `demo` DISABLE KEYS */;
INSERT INTO `demo` VALUES (1,'aa',1,'2018-05-29 16:22:47'),(2,'bbbcc',2,'2018-05-28 16:23:01');
/*!40000 ALTER TABLE `demo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_category`
--

DROP TABLE IF EXISTS `system_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_category` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `type` smallint(5) NOT NULL,
  `name` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_category`
--

LOCK TABLES `system_category` WRITE;
/*!40000 ALTER TABLE `system_category` DISABLE KEYS */;
INSERT INTO `system_category` VALUES (1,1,'服装');
/*!40000 ALTER TABLE `system_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_user`
--

DROP TABLE IF EXISTS `system_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_user` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `category_type` smallint(5) NOT NULL,
  `program_uid` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `address` varchar(500) NOT NULL,
  `phone` varchar(21) NOT NULL,
  `logo_url` varchar(200) DEFAULT NULL,
  `custom_phone` varchar(21) DEFAULT NULL,
  `card_id` varchar(20) NOT NULL,
  `business_registration_no` varchar(20) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `app_secret` varchar(200) NOT NULL,
  `nick_name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_user`
--

LOCK TABLES `system_user` WRITE;
/*!40000 ALTER TABLE `system_user` DISABLE KEYS */;
INSERT INTO `system_user` VALUES (1,1,'wxdda83d03c2d1521c','张三小店','2018-05-31 09:03:27','江西省南昌市万达广场3A写字楼','15579166875',NULL,NULL,'360124198900000000','130100600095237',0,'fad3978bb8d6aed7a341feb506b5f6e5','张三');
/*!40000 ALTER TABLE `system_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `toggery_goods`
--

DROP TABLE IF EXISTS `toggery_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `toggery_goods` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `system_user_id` mediumint(8) NOT NULL,
  `name` varchar(50) NOT NULL,
  `count` mediumint(8) NOT NULL,
  `toggery_kinds_id` mediumint(8) NOT NULL,
  `market_price` decimal(10,2) NOT NULL,
  `discount_price` decimal(10,2) NOT NULL,
  `freight` decimal(10,2) NOT NULL,
  `title` varchar(255) NOT NULL,
  `click_count` int(10) NOT NULL DEFAULT '0',
  `weight` decimal(10,3) NOT NULL,
  `promote_start_date` int(11) NOT NULL,
  `promote_end_date` int(11) NOT NULL,
  `keywords` varchar(255) NOT NULL,
  `goods_brief` varchar(255) DEFAULT NULL,
  `goods_desc` text,
  `goods_sn` varchar(60) NOT NULL,
  `is_new` tinyint(1) NOT NULL,
  `is_hot` tinyint(1) NOT NULL,
  `add_time` int(11) NOT NULL,
  `update_time` int(11) NOT NULL,
  `can_use_coupon` tinyint(1) NOT NULL,
  `goods_thumb` varchar(255) NOT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `toggery_goods`
--

LOCK TABLES `toggery_goods` WRITE;
/*!40000 ALTER TABLE `toggery_goods` DISABLE KEYS */;
INSERT INTO `toggery_goods` VALUES (1,1,'商品1',100,4,200.00,200.00,10.00,'最新商品1',0,0.010,-1,-1,'服装,商品1','商品1简介','商品1详情','商品1序列号',1,1,0,0,0,'http://p913k4x4g.bkt.clouddn.com/product1.jpg',0),(2,1,'商品2',990,4,3000.00,3000.00,10.00,'最新商品2',0,2.000,-1,-1,'服装,商品2','商品2简介','商品2详情','商品2序列号',1,1,0,0,0,'http://p913k4x4g.bkt.clouddn.com/product2.jpg',0),(3,1,'商品3',1000,4,10000.00,10000.00,10.00,'最新商品3',0,20.250,-1,-1,'服装,商品3','商品3简介','商品3详情','商品3序列号',1,1,0,0,0,'http://p913k4x4g.bkt.clouddn.com/product3.jpg',0),(4,1,'商品4',55,4,360.00,360.00,10.00,'最新商品4',0,25.250,-1,-1,'服装,商品4','商品4简介','商品4详情','商品4序列号',1,1,0,0,0,'http://p913k4x4g.bkt.clouddn.com/product4.jpg',0),(5,1,'商品5',18888,4,780.00,780.00,10.00,'最新商品5',0,33.000,-1,-1,'服装,商品5','商品5简介','商品5详情','商品5序列号',1,1,0,0,0,'http://p913k4x4g.bkt.clouddn.com/product5.jpg',0);
/*!40000 ALTER TABLE `toggery_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `toggery_goods_kinds`
--

DROP TABLE IF EXISTS `toggery_goods_kinds`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `toggery_goods_kinds` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `kinds_id` mediumint(8) NOT NULL,
  `name` varchar(50) NOT NULL,
  `category_type` smallint(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `toggery_goods_kinds`
--

LOCK TABLES `toggery_goods_kinds` WRITE;
/*!40000 ALTER TABLE `toggery_goods_kinds` DISABLE KEYS */;
INSERT INTO `toggery_goods_kinds` VALUES (1,1,'上衣',1),(2,2,'裤子',1),(3,3,'鞋子',1),(4,4,'其他',1);
/*!40000 ALTER TABLE `toggery_goods_kinds` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_account`
--

DROP TABLE IF EXISTS `user_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_account` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `phone` varchar(21) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '0',
  `password` varchar(100) DEFAULT NULL,
  `role_id` mediumint(8) DEFAULT NULL,
  `sex` tinyint(1) NOT NULL,
  `nick_name` varchar(1024) DEFAULT NULL,
  `head_url` varchar(200) NOT NULL,
  `app_id` varchar(200) NOT NULL,
  `open_id` varchar(200) NOT NULL,
  `union_id` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_account`
--

LOCK TABLES `user_account` WRITE;
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
INSERT INTO `user_account` VALUES (1,NULL,1,NULL,NULL,1,'机车王小二','https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqxPKde5h68XULD7URQm4g2p9xlDTlMJhV4BNJeeboInKhqvqB475fiaJoYlsLF9y8M6jXddmKRG5g/132','wxdda83d03c2d1521c','oUeJY5KR0bECG54dDD0trBqgzkDo','oJ6K-1eZqk8pv1Lvae7zfd-MaVfw'),(2,NULL,1,NULL,NULL,1,'Yang','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKcq5xY5euQmIBBzlGuwUJibxFHFNia83YXwianUprszUmDOoxZYEMq4IRNdicgDmpyUtkZpmkr86QkGA/132','wxdda83d03c2d1521c','oUeJY5P0SfCNrJnlLtYTJiKm57yM',NULL);
/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_addr`
--

DROP TABLE IF EXISTS `user_addr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_addr` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `user_account` mediumint(8) NOT NULL,
  `name` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `areaaddr` varchar(50) NOT NULL,
  `addr_desc` varchar(255) NOT NULL,
  `area_code` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_addr`
--

LOCK TABLES `user_addr` WRITE;
/*!40000 ALTER TABLE `user_addr` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_addr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_cart`
--

DROP TABLE IF EXISTS `user_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_cart` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `kinds_id` mediumint(8) NOT NULL,
  `title` varchar(255) NOT NULL,
  `user_account` mediumint(8) NOT NULL,
  `create_time` int(11) NOT NULL,
  `market_price` decimal(10,2) NOT NULL,
  `discount_price` decimal(10,2) NOT NULL,
  `goods_thumb` varchar(255) NOT NULL,
  `goods_color` varchar(20) DEFAULT NULL,
  `goods_size` decimal(10,2) DEFAULT NULL,
  `count` mediumint(8) NOT NULL,
  `is_new` tinyint(1) NOT NULL,
  `is_hot` tinyint(1) NOT NULL,
  `good_id` mediumint(8) NOT NULL,
  `system_type` mediumint(8) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_cart`
--

LOCK TABLES `user_cart` WRITE;
/*!40000 ALTER TABLE `user_cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` mediumint(8) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-01 16:29:44
