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
-- Table structure for table `e_shop_product`
--

DROP TABLE IF EXISTS `e_shop_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_shop_product` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(64) NOT NULL COMMENT '标题',
  `subtitle` varchar(64) DEFAULT NULL COMMENT '副标题',
  `brief` varchar(255) DEFAULT NULL COMMENT '产品简述',
  `content_desc` text COMMENT '详情',
  `price_underline` decimal(10,2) DEFAULT NULL COMMENT '划线价格 市场价',
  `sale_amount` int(11) NOT NULL COMMENT '销售额',
  `keyword` varchar(255) DEFAULT NULL COMMENT '关键字',
  `product_catagory_id` int(10) unsigned NOT NULL COMMENT '产品的类别',
  `sort_order` tinyint(4) NOT NULL COMMENT '排序',
  `is_on_sale` tinyint(4) NOT NULL COMMENT '是否上架',
  `img_primary_url` varchar(255) DEFAULT NULL COMMENT '主图',
  `img_list_url` varchar(255) DEFAULT NULL COMMENT '图片列表',
  `is_delete` tinyint(4) DEFAULT NULL,
  `vendor_user_id` int(11) DEFAULT NULL COMMENT '商家id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_shop_product`
--

LOCK TABLES `e_shop_product` WRITE;
/*!40000 ALTER TABLE `e_shop_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_shop_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_shop_product_catagory`
--

DROP TABLE IF EXISTS `e_shop_product_catagory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_shop_product_catagory` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NOT NULL,
  `name` char(255) NOT NULL COMMENT '名字',
  `catagory_desc` varchar(255) DEFAULT NULL COMMENT '描述',
  `sort_order` smallint(6) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品分类 可以是类 目 或者 品牌';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_shop_product_catagory`
--

LOCK TABLES `e_shop_product_catagory` WRITE;
/*!40000 ALTER TABLE `e_shop_product_catagory` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_shop_product_catagory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_shop_product_sku`
--

DROP TABLE IF EXISTS `e_shop_product_sku`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_shop_product_sku` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `product_id` int(10) unsigned DEFAULT NULL COMMENT '属于哪个产品',
  `unit_price` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `cost_price` decimal(10,2) NOT NULL COMMENT '成本价 可为空',
  `stock_amount` int(11) DEFAULT NULL COMMENT '库存',
  `stock_sn` int(11) NOT NULL COMMENT '商家自定义编号',
  `attr_option` varchar(255) DEFAULT NULL COMMENT 'sku属性ID串',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品SKU（库存单品）。影响价格和库存。\r如：手机内存容量。颜色。\r多个对应一个商品';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_shop_product_sku`
--

LOCK TABLES `e_shop_product_sku` WRITE;
/*!40000 ALTER TABLE `e_shop_product_sku` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_shop_product_sku` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_shop_product_sku_attr`
--

DROP TABLE IF EXISTS `e_shop_product_sku_attr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_shop_product_sku_attr` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'sku属性id',
  `product_catagory_id` int(10) unsigned NOT NULL COMMENT '属性对应的单品',
  `attr_type` varchar(255) NOT NULL COMMENT '属性的类型',
  `attr_content` varchar(255) NOT NULL COMMENT '属性的值',
  `sort_order` int(11) NOT NULL COMMENT '属性的排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='sku 销售属性。影响价格和库存。手机内存容量。颜色。\r多个对应一个商品';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_shop_product_sku_attr`
--

LOCK TABLES `e_shop_product_sku_attr` WRITE;
/*!40000 ALTER TABLE `e_shop_product_sku_attr` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_shop_product_sku_attr` ENABLE KEYS */;
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
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `last_reset_password_time` datetime DEFAULT NULL,
  `role_id` mediumint(8) DEFAULT NULL,
  `sex` tinyint(1) DEFAULT NULL,
  `nick_name` varchar(1024) DEFAULT NULL,
  `head_url` varchar(200) DEFAULT '',
  `app_id` varchar(200) DEFAULT '',
  `open_id` varchar(200) DEFAULT '',
  `union_id` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_account`
--

LOCK TABLES `user_account` WRITE;
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
INSERT INTO `user_account` VALUES (3,NULL,NULL,'wangkun','$2a$10$1aRFT.OVSzJ8FoNu6mIZK.cjOlH39JP8fyGIebQhvJADhbjrGYw56','2018-06-04 14:33:41',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,NULL,1,'oUeJY5KR0bECG54dDD0trBqgzkDo','$2a$10$OG4r8nfEXwRK/Q8v/e2Y6.HRRv..OoHRV1uEdrkjlvqJsCHCgnlfi','2018-06-04 18:08:52',NULL,1,'机车王小二','https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqxPKde5h68XULD7URQm4g2p9xlDTlMJhV4BNJeeboInKhqvqB475fiaJoYlsLF9y8M6jXddmKRG5g/132','wxdda83d03c2d1521c','oUeJY5KR0bECG54dDD0trBqgzkDo','oJ6K-1eZqk8pv1Lvae7zfd-MaVfw'),(5,NULL,1,'oUeJY5P0SfCNrJnlLtYTJiKm57yM','$2a$10$atYIChH0bWET1QbKwA8bce3VD2NyfIF3mahrZSV8qZKX4//DU6Dgy','2018-06-05 16:52:59',NULL,1,'Yang','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKcq5xY5euQmIBBzlGuwUJibxFHFNia83YXwianUprszUmDOoxZYEMq4IRNdicgDmpyUtkZpmkr86QkGA/132','wxdda83d03c2d1521c','oUeJY5P0SfCNrJnlLtYTJiKm57yM',NULL);
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

--
-- Table structure for table `vendor_category`
--

DROP TABLE IF EXISTS `vendor_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendor_category` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `type` smallint(5) NOT NULL,
  `name` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendor_category`
--

LOCK TABLES `vendor_category` WRITE;
/*!40000 ALTER TABLE `vendor_category` DISABLE KEYS */;
INSERT INTO `vendor_category` VALUES (1,1,'服装');
/*!40000 ALTER TABLE `vendor_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendor_user`
--

DROP TABLE IF EXISTS `vendor_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendor_user` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `category_type` smallint(5) NOT NULL,
  `app_id` varchar(200) NOT NULL DEFAULT '',
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
-- Dumping data for table `vendor_user`
--

LOCK TABLES `vendor_user` WRITE;
/*!40000 ALTER TABLE `vendor_user` DISABLE KEYS */;
INSERT INTO `vendor_user` VALUES (1,1,'wxdda83d03c2d1521c','张三小店','2018-05-31 09:03:27','江西省南昌市万达广场3A写字楼','15579166875',NULL,NULL,'360124198900000000','130100600095237',0,'fad3978bb8d6aed7a341feb506b5f6e5','张三');
/*!40000 ALTER TABLE `vendor_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-07 15:15:37
