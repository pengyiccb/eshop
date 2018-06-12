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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `demo`
--

LOCK TABLES `demo` WRITE;
/*!40000 ALTER TABLE `demo` DISABLE KEYS */;
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
  `keyword` varchar(255) DEFAULT NULL COMMENT '关键字',
  `product_category_id` int(10) unsigned NOT NULL COMMENT '产品的类别',
  `sort_order` tinyint(4) DEFAULT NULL COMMENT '排序',
  `is_on_sale` tinyint(4) DEFAULT NULL COMMENT '是否上架',
  `img_primary_url` varchar(255) DEFAULT NULL COMMENT '主图',
  `img_list_url` varchar(255) DEFAULT NULL COMMENT '图片列表',
  `is_delete` tinyint(4) DEFAULT NULL,
  `vendor_user_id` int(11) DEFAULT NULL COMMENT '商家',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='产品表 SPU\r包含了产品的基本属性。不影响价格。\r如：iphone x 产品';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_shop_product`
--

LOCK TABLES `e_shop_product` WRITE;
/*!40000 ALTER TABLE `e_shop_product` DISABLE KEYS */;
INSERT INTO `e_shop_product` VALUES (1,'title','subtile','brief','content very long',999.99,'衣服',1,0,1,'我是主图1',NULL,NULL,1),(2,'title2','subtile2','brief','content very long',888.99,'衣服',1,1,1,'我是主图2',NULL,NULL,1),(22,'所有的',NULL,'萨芬不会解散加菲猫开始打',NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,1),(23,'啊兄弟',NULL,'嘻嘻嘻嘻',NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,1),(24,'相对',NULL,'谢谢谢',NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `e_shop_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_shop_product_category`
--

DROP TABLE IF EXISTS `e_shop_product_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_shop_product_category` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NOT NULL,
  `name` char(255) COLLATE utf8_bin NOT NULL COMMENT '名字',
  `category_desc` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `sort_order` smallint(6) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='产品分类 可以是类 目 或者 品牌';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_shop_product_category`
--

LOCK TABLES `e_shop_product_category` WRITE;
/*!40000 ALTER TABLE `e_shop_product_category` DISABLE KEYS */;
INSERT INTO `e_shop_product_category` VALUES (1,0,'衣服','衣服',0);
/*!40000 ALTER TABLE `e_shop_product_category` ENABLE KEYS */;
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
  `unit_price` decimal(10,2) NOT NULL COMMENT '单价',
  `cost_price` decimal(10,2) DEFAULT NULL COMMENT '成本价 可为空',
  `stock_amount` int(11) NOT NULL COMMENT '库存',
  `sale_amount` int(11) DEFAULT '0' COMMENT '销售额',
  `stock_sn` int(11) DEFAULT NULL COMMENT '商家自定义编号',
  `attr_option` varchar(255) DEFAULT NULL COMMENT 'sku属性ID串',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='产品SKU（库存单品）。影响价格和库存。\r如：手机内存容量。颜色。\r多个对应一个商品';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_shop_product_sku`
--

LOCK TABLES `e_shop_product_sku` WRITE;
/*!40000 ALTER TABLE `e_shop_product_sku` DISABLE KEYS */;
INSERT INTO `e_shop_product_sku` VALUES (1,1,99.99,10.00,1,0,0,'1|3'),(2,1,88.88,8.00,12,0,0,'1|4'),(3,2,77.88,8.00,12,0,0,'1|4'),(4,2,77.88,8.00,12,0,0,'1|3'),(13,22,111.00,111.00,111,NULL,NULL,'1|3'),(14,22,222.00,222.00,222,NULL,NULL,'1|4'),(15,22,333.00,333.00,333,NULL,NULL,'2|3'),(16,22,444.00,444.00,444,NULL,NULL,'2|4'),(17,22,555.00,555.00,555,NULL,NULL,'9|3'),(18,22,666.00,666.00,666,NULL,NULL,'9|4'),(19,23,111.00,444.00,222,NULL,NULL,'1|3'),(20,24,123.00,123.00,123,NULL,NULL,'1|4');
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
  `product_category_id` int(10) unsigned NOT NULL COMMENT 'sku属性对应的分类',
  `attr_type` varchar(255) NOT NULL COMMENT '属性的类型',
  `attr_content` varchar(255) NOT NULL COMMENT '属性的值',
  `sort_order` int(11) NOT NULL COMMENT '属性的排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='sku 销售属性。影响价格和库存。手机内存容量。颜色。\r多个对应一个商品';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_shop_product_sku_attr`
--

LOCK TABLES `e_shop_product_sku_attr` WRITE;
/*!40000 ALTER TABLE `e_shop_product_sku_attr` DISABLE KEYS */;
INSERT INTO `e_shop_product_sku_attr` VALUES (1,1,'COLOR','红',0),(2,1,'COLOR','黑',1),(3,1,'SIZE','m',0),(4,1,'SIZE','x',1),(9,1,'COLOR','白色',3),(11,1,'COLOR','111',0),(12,1,'COLOR','222',0),(13,1,'COLOR','333',0),(14,1,'COLOR','444',0),(15,1,'COLOR','555',0),(16,1,'COLOR','666',0);
/*!40000 ALTER TABLE `e_shop_product_sku_attr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_account`
--

DROP TABLE IF EXISTS `user_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_account` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
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
  `default_addr_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_account`
--

LOCK TABLES `user_account` WRITE;
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
INSERT INTO `user_account` VALUES (5,NULL,NULL,'test','$2a$10$9TBnSUPfsTg6anyDF5DI2OtFSDky9u9fZntSXkM/nWQe8gGCgyU6K','2018-06-09 11:16:38',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,NULL,1,'oUeJY5P0SfCNrJnlLtYTJiKm57yM','$2a$10$e9AKQm3Hygi5o78JWXrAeOufCSTYtI.K72A9mdxHvRtJHUE6Hajfa','2018-06-11 10:15:09',NULL,1,'Yang','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKcq5xY5euQmIBBzlGuwUJibxFHFNia83YXwianUprszUmDOoxZYEMq4IRNdicgDmpyUtkZpmkr86QkGA/132','wxdda83d03c2d1521c','oUeJY5P0SfCNrJnlLtYTJiKm57yM',NULL,NULL),(7,NULL,1,'oUeJY5KR0bECG54dDD0trBqgzkDo','$2a$10$8XkOelVXt922cdBTEzIuaOmYLKawrr9ilqpQ49uCGbYxrey5W15rK','2018-06-11 17:13:13',NULL,1,'机车王小二','https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqxPKde5h68XULD7URQm4g2p9xlDTlMJhV4BNJeeboInKhqvqB475fiaJoYlsLF9y8M6jXddmKRG5g/132','wxdda83d03c2d1521c','oUeJY5KR0bECG54dDD0trBqgzkDo','oJ6K-1eZqk8pv1Lvae7zfd-MaVfw',NULL);
/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_addr`
--

DROP TABLE IF EXISTS `user_addr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_addr` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
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
  `id` int(10) unsigned NOT NULL COMMENT '主键',
  `product_sku_id` int(11) NOT NULL COMMENT '产品单品id',
  `user_account` int(11) NOT NULL COMMENT '用户id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `count` int(11) NOT NULL,
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
-- Table structure for table `user_order`
--

DROP TABLE IF EXISTS `user_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_order` (
  `id` int(10) unsigned NOT NULL COMMENT '主键',
  `roder_sn` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '订单号',
  `status` int(11) NOT NULL COMMENT '订单状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `product_sku_id` int(11) NOT NULL COMMENT '单品id',
  `freight` decimal(10,2) NOT NULL COMMENT '运费',
  `count` int(11) NOT NULL COMMENT '数量',
  `addr_id` int(11) DEFAULT NULL COMMENT '地址id',
  `real_money` decimal(10,2) NOT NULL COMMENT '实际价格',
  `express_sn` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '快递单号',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `user_account` int(11) NOT NULL COMMENT '用户账号',
  `wechar_orderid` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '微信订单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_order`
--

LOCK TABLES `user_order` WRITE;
/*!40000 ALTER TABLE `user_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
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
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `type` smallint(5) NOT NULL,
  `name` varchar(200) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendor_category`
--

LOCK TABLES `vendor_category` WRITE;
/*!40000 ALTER TABLE `vendor_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendor_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendor_user`
--

DROP TABLE IF EXISTS `vendor_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendor_user` (
  `id` int(10) unsigned NOT NULL,
  `category_type` smallint(5) NOT NULL,
  `app_id` varchar(200) COLLATE utf8_bin NOT NULL DEFAULT '',
  `name` varchar(200) COLLATE utf8_bin NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `address` varchar(500) COLLATE utf8_bin NOT NULL,
  `phone` varchar(21) COLLATE utf8_bin NOT NULL,
  `logo_url` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `custom_phone` varchar(21) COLLATE utf8_bin DEFAULT NULL,
  `card_id` varchar(20) COLLATE utf8_bin NOT NULL,
  `business_registration_no` varchar(20) COLLATE utf8_bin NOT NULL,
  `status` tinyint(1) NOT NULL,
  `app_secret` varchar(200) COLLATE utf8_bin NOT NULL,
  `nick_name` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendor_user`
--

LOCK TABLES `vendor_user` WRITE;
/*!40000 ALTER TABLE `vendor_user` DISABLE KEYS */;
INSERT INTO `vendor_user` VALUES (1,0,'wxdda83d03c2d1521c','','2018-06-09 02:41:48','','',NULL,NULL,'','',0,'fad3978bb8d6aed7a341feb506b5f6e5','');
/*!40000 ALTER TABLE `vendor_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendor_user_config`
--

DROP TABLE IF EXISTS `vendor_user_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendor_user_config` (
  `id` int(10) unsigned NOT NULL COMMENT '主键',
  `vendor_id` int(11) NOT NULL COMMENT '商户id',
  `config_key` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '配置key值',
  `config_value` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '配置value值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendor_user_config`
--

LOCK TABLES `vendor_user_config` WRITE;
/*!40000 ALTER TABLE `vendor_user_config` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendor_user_config` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-12 16:16:50
