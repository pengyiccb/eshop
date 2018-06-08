-- MySQL dump 10.13  Distrib 5.7.22, for osx10.12 (x86_64)
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
  `title` varchar(64) NOT NULL COMMENT '±ÍÃ‚',
  `subtitle` varchar(64) DEFAULT NULL COMMENT '∏±±ÍÃ‚',
  `brief` varchar(255) DEFAULT NULL COMMENT '≤˙∆∑ºÚ ˆ',
  `content_desc` text COMMENT 'œÍ«È',
  `price_underline` decimal(10,2) DEFAULT NULL COMMENT 'ªÆœﬂº€∏Ò  –≥°º€',
  `keyword` varchar(255) DEFAULT NULL COMMENT 'πÿº¸◊÷',
  `product_category_id` int(10) unsigned NOT NULL COMMENT '≤˙∆∑µƒ¿‡±',
  `sort_order` tinyint(4) NOT NULL COMMENT '≈≈–Ú',
  `is_on_sale` tinyint(4) NOT NULL COMMENT ' «∑Ò…œº‹',
  `img_primary_url` varchar(255) DEFAULT NULL COMMENT '÷˜Õº',
  `img_list_url` varchar(255) DEFAULT NULL COMMENT 'Õº∆¨¡–±Ì',
  `is_delete` tinyint(4) DEFAULT NULL,
  `vendor_user_id` int(11) DEFAULT NULL COMMENT '…Ãº“',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='≤˙∆∑±Ì SPU\n∞¸∫¨¡À≤˙∆∑µƒª˘±æ Ù–‘°£≤ª”∞œÏº€∏Ò°£\n»Á£∫iphone x ≤˙∆∑';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_shop_product`
--

LOCK TABLES `e_shop_product` WRITE;
/*!40000 ALTER TABLE `e_shop_product` DISABLE KEYS */;
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
  `name` char(255) COLLATE utf8_bin NOT NULL COMMENT '√˚◊÷',
  `category_desc` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '√Ë ˆ',
  `sort_order` smallint(6) DEFAULT NULL COMMENT '≈≈–Ú',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='≤˙∆∑∑÷¿‡ ø…“‘ «¿‡ ƒø ªÚ’ﬂ ∆∑≈∆';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_shop_product_category`
--

LOCK TABLES `e_shop_product_category` WRITE;
/*!40000 ALTER TABLE `e_shop_product_category` DISABLE KEYS */;
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
  `product_id` int(10) unsigned DEFAULT NULL COMMENT ' Ù”⁄ƒƒ∏ˆ≤˙∆∑',
  `unit_price` decimal(10,2) DEFAULT NULL COMMENT 'µ•º€',
  `cost_price` decimal(10,2) NOT NULL COMMENT '≥…±æº€ ø…Œ™ø’',
  `stock_amount` int(11) NOT NULL COMMENT 'ø‚¥Ê',
  `sale_amount` int(11) NOT NULL COMMENT 'œ˙ €∂Ó',
  `stock_sn` int(11) NOT NULL COMMENT '…Ãº“◊‘∂®“Â±‡∫≈',
  `attr_option` varchar(255) DEFAULT NULL COMMENT 'sku Ù–‘ID¥Æ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='≤˙∆∑SKU£®ø‚¥Êµ•∆∑£©°£”∞œÏº€∏Ò∫Õø‚¥Ê°£\n»Á£∫ ÷ª˙ƒ⁄¥Ê»›¡ø°£—’…´°£\n∂‡∏ˆ∂‘”¶“ª∏ˆ…Ã∆∑';
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
  `id` int(10) unsigned NOT NULL COMMENT 'sku Ù–‘id',
  `product_category_id` int(10) unsigned NOT NULL COMMENT 'sku Ù–‘∂‘”¶µƒ∑÷¿‡',
  `attr_type` varchar(255) NOT NULL COMMENT ' Ù–‘µƒ¿‡–Õ',
  `attr_content` varchar(255) NOT NULL COMMENT ' Ù–‘µƒ÷µ',
  `sort_order` int(11) NOT NULL COMMENT ' Ù–‘µƒ≈≈–Ú',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='sku œ˙ € Ù–‘°£”∞œÏº€∏Ò∫Õø‚¥Ê°£ ÷ª˙ƒ⁄¥Ê»›¡ø°£—’…´°£\n∂‡∏ˆ∂‘”¶“ª∏ˆ…Ã∆∑';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_shop_product_sku_attr`
--

LOCK TABLES `e_shop_product_sku_attr` WRITE;
/*!40000 ALTER TABLE `e_shop_product_sku_attr` DISABLE KEYS */;
/*!40000 ALTER TABLE `e_shop_product_sku_attr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `toggery_goods`
--

DROP TABLE IF EXISTS `toggery_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `toggery_goods` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
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
INSERT INTO `toggery_goods` VALUES (1,1,'ÂïÜÂìÅ1',100,4,200.00,200.00,10.00,'ÊúÄÊñ∞ÂïÜÂìÅ1',0,0.010,-1,-1,'ÊúçË£Ö,ÂïÜÂìÅ1','ÂïÜÂìÅ1ÁÆÄ‰ªã','ÂïÜÂìÅ1ËØ¶ÊÉÖ','ÂïÜÂìÅ1Â∫èÂàóÂè∑',1,1,0,0,0,'http://p9l3k4x4g.bkt.clouddn.com/product1.jpg',0),(2,1,'ÂïÜÂìÅ2',990,4,3000.00,3000.00,10.00,'ÊúÄÊñ∞ÂïÜÂìÅ2',0,2.000,-1,-1,'ÊúçË£Ö,ÂïÜÂìÅ2','ÂïÜÂìÅ2ÁÆÄ‰ªã','ÂïÜÂìÅ2ËØ¶ÊÉÖ','ÂïÜÂìÅ2Â∫èÂàóÂè∑',1,1,0,0,0,'http://p9l3k4x4g.bkt.clouddn.com/product1.jpg',0),(3,1,'ÂïÜÂìÅ3',1000,4,10000.00,10000.00,10.00,'ÊúÄÊñ∞ÂïÜÂìÅ3',0,20.250,-1,-1,'ÊúçË£Ö,ÂïÜÂìÅ3','ÂïÜÂìÅ3ÁÆÄ‰ªã','ÂïÜÂìÅ3ËØ¶ÊÉÖ','ÂïÜÂìÅ3Â∫èÂàóÂè∑',1,1,0,0,0,'http://p9l3k4x4g.bkt.clouddn.com/product1.jpg',0),(4,1,'ÂïÜÂìÅ4',55,4,360.00,360.00,10.00,'ÊúÄÊñ∞ÂïÜÂìÅ4',0,25.250,-1,-1,'ÊúçË£Ö,ÂïÜÂìÅ4','ÂïÜÂìÅ4ÁÆÄ‰ªã','ÂïÜÂìÅ4ËØ¶ÊÉÖ','ÂïÜÂìÅ4Â∫èÂàóÂè∑',1,1,0,0,0,'http://p9l3k4x4g.bkt.clouddn.com/product1.jpg',0),(5,1,'ÂïÜÂìÅ5',18888,4,780.00,780.00,10.00,'ÊúÄÊñ∞ÂïÜÂìÅ5',0,33.000,-1,-1,'ÊúçË£Ö,ÂïÜÂìÅ5','ÂïÜÂìÅ5ÁÆÄ‰ªã','ÂïÜÂìÅ5ËØ¶ÊÉÖ','ÂïÜÂìÅ5Â∫èÂàóÂè∑',1,1,0,0,0,'http://p9l3k4x4g.bkt.clouddn.com/product1.jpg',0);
/*!40000 ALTER TABLE `toggery_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `toggery_goods_kinds`
--

DROP TABLE IF EXISTS `toggery_goods_kinds`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `toggery_goods_kinds` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
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
INSERT INTO `toggery_goods_kinds` VALUES (1,1,'‰∏äË°£',1),(2,2,'Ë£§Â≠ê',1),(3,3,'ÈûãÂ≠ê',1),(4,4,'ÂÖ∂‰ªñ',1);
/*!40000 ALTER TABLE `toggery_goods_kinds` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_account`
--

LOCK TABLES `user_account` WRITE;
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
INSERT INTO `user_account` VALUES (3,NULL,NULL,'wangkun','$2a$10$1aRFT.OVSzJ8FoNu6mIZK.cjOlH39JP8fyGIebQhvJADhbjrGYw56','2018-06-04 14:33:41',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,NULL,1,'oUeJY5KR0bECG54dDD0trBqgzkDo','$2a$10$OG4r8nfEXwRK/Q8v/e2Y6.HRRv..OoHRV1uEdrkjlvqJsCHCgnlfi','2018-06-04 18:08:52',NULL,1,'Êú∫ËΩ¶ÁéãÂ∞è‰∫å','https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqxPKde5h68XULD7URQm4g2p9xlDTlMJhV4BNJeeboInKhqvqB475fiaJoYlsLF9y8M6jXddmKRG5g/132','wxdda83d03c2d1521c','oUeJY5KR0bECG54dDD0trBqgzkDo','oJ6K-1eZqk8pv1Lvae7zfd-MaVfw',NULL),(5,NULL,1,'oUeJY5P0SfCNrJnlLtYTJiKm57yM','$2a$10$atYIChH0bWET1QbKwA8bce3VD2NyfIF3mahrZSV8qZKX4//DU6Dgy','2018-06-05 16:52:59',NULL,1,'Yang','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKcq5xY5euQmIBBzlGuwUJibxFHFNia83YXwianUprszUmDOoxZYEMq4IRNdicgDmpyUtkZpmkr86QkGA/132','wxdda83d03c2d1521c','oUeJY5P0SfCNrJnlLtYTJiKm57yM',NULL,NULL);
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
  `id` int(10) unsigned NOT NULL COMMENT '÷˜º¸',
  `product_sku_id` int(11) NOT NULL COMMENT '≤˙∆∑µ•∆∑id',
  `user_account` int(11) NOT NULL COMMENT '”√ªßid',
  `create_time` datetime NOT NULL COMMENT '¥¥Ω® ±º‰',
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
  `id` int(10) unsigned NOT NULL COMMENT '÷˜º¸',
  `roder_sn` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '∂©µ•∫≈',
  `status` int(11) NOT NULL COMMENT '∂©µ•◊¥Ã¨',
  `create_time` datetime NOT NULL COMMENT '¥¥Ω® ±º‰',
  `product_sku_id` int(11) NOT NULL COMMENT 'µ•∆∑id',
  `freight` decimal(10,2) NOT NULL COMMENT '‘À∑—',
  `count` int(11) NOT NULL COMMENT ' ˝¡ø',
  `addr_id` int(11) DEFAULT NULL COMMENT 'µÿ÷∑id',
  `real_money` decimal(10,2) NOT NULL COMMENT ' µº º€∏Ò',
  `express_sn` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'øÏµ›µ•∫≈',
  `update_time` datetime NOT NULL COMMENT '∏¸–¬ ±º‰',
  `user_account` int(11) NOT NULL COMMENT '”√ªß’À∫≈',
  `wechar_orderid` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT 'Œ¢–≈∂©µ•id',
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendor_category`
--

LOCK TABLES `vendor_category` WRITE;
/*!40000 ALTER TABLE `vendor_category` DISABLE KEYS */;
INSERT INTO `vendor_category` VALUES (1,1,'ÊúçË£Ö');
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
INSERT INTO `vendor_user` VALUES (1,1,'wxdda83d03c2d1521c','Âº†‰∏âÂ∞èÂ∫ó','2018-05-31 09:03:27','Ê±üË•øÁúÅÂçóÊòåÂ∏Ç‰∏áËææÂπøÂú∫3AÂÜôÂ≠óÊ•º','15579166875',NULL,NULL,'360124198900000000','130100600095237',0,'fad3978bb8d6aed7a341feb506b5f6e5','Âº†‰∏â');
/*!40000 ALTER TABLE `vendor_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendor_user_config`
--

DROP TABLE IF EXISTS `vendor_user_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendor_user_config` (
  `id` int(10) unsigned NOT NULL COMMENT '÷˜º¸',
  `vendor_id` int(11) NOT NULL COMMENT '…Ãªßid',
  `config_key` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '≈‰÷√key÷µ',
  `config_value` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '≈‰÷√value÷µ',
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

-- Dump completed on 2018-06-08 15:24:02
