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
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='产品表 SPU\r包含了产品的基本属性。不影响价格。\r如：iphone x 产品';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_shop_product`
--

LOCK TABLES `e_shop_product` WRITE;
/*!40000 ALTER TABLE `e_shop_product` DISABLE KEYS */;
INSERT INTO `e_shop_product` VALUES (1,'英爵伦 2018夏季新款 男士纯色短袖T恤 男装体恤上衣简约潮牌衣服','95%棉 打底柔软舒适 外穿简约时尚',' 纯电商(只在线上销售)',' 纯电商(只在线上销售)',55.00,'男装',1,1,1,'https://img.alicdn.com/imgextra/i1/1860270913/TB1Zs5JwQCWBuNjy0FaXXXUlXXa_!!0-item_pic.jpg_430x430q90.jpg','https://img.alicdn.com/imgextra/i2/134363478/TB2LT82r7SWBuNjSszdXXbeSpXa-134363478.jpg',1,1),(2,'男士短袖t恤2018夏季新款男生翻领潮流男装polo衫半袖夏装上衣服','外穿简约时尚',' 纯电商(只在线上销售)',' 纯电商(只在线上销售)',66.00,'男装',1,2,1,'https://img.alicdn.com/imgextra/i2/1589942160/TB2uD6voTXYBeNkHFrdXXciuVXa_!!1589942160.jpg','https://img.alicdn.com/imgextra/i3/1589942160/TB2NBJqimcqBKNjSZFgXXX_kXXa_!!1589942160.jpg',1,1),(3,'美特斯邦威短袖t恤男潮流2018夏季新款条纹海军风印花上衣服韩版','字母印花 经典圆领','2018年夏季','Meters Bonwe/美特斯邦威',77.00,'男装',1,3,1,'https://metersbonwe.tmall.com/shop/view_shop.htm?spm=a220o.1000855.w5003-17193593444.1.792556d99GSKFN&mytmenu=mdianpu&utkn=g%2Cypamzwglxgyo5tp6xhm3ppon7c26u1528127082222&user_number_id=134363478&scm=1028.1.2.20001&scene=taobao_shop','https://img.alicdn.com/imgextra/i2/134363478/TB2LT82r7SWBuNjSszdXXbeSpXa-134363478.jpg',1,1),(4,'美特斯邦威短袖衬衫男2018夏季新款基础衬衣休闲纯色纯棉牛津纺','立领设计 字母印花口袋','2018年夏季','Meters Bonwe/美特斯邦威',88.88,'男装',1,4,1,'https://img.alicdn.com/imgextra/i2/134363478/TB2oeG2r21TBuNjy0FjXXajyXXa-134363478.jpg','https://img.alicdn.com/imgextra/i3/134363478/TB2ZWJKrYSYBuNjSspiXXXNzpXa-134363478.jpg',1,1),(5,'美特斯邦威短袖衬衫男装2018夏季新款纯棉chic原宿港风格子衬衫','经典格纹 斜纹口袋','2018年秋季','Meters Bonwe/美特斯邦威',99.99,'男装',1,5,1,'https://img.alicdn.com/imgextra/i2/134363478/TB2b97GiyOYBuNjSsD4XXbSkFXa-134363478.jpg','https://img.alicdn.com/imgextra/i2/134363478/TB2b97GiyOYBuNjSsD4XXbSkFXa-134363478.jpg',1,1),(6,'美特斯邦威情侣短袖t恤女百搭纯色纯棉打底衫上衣韩2018夏装新款','纯色T恤 舒适圆领','2018年夏季','Meters Bonwe/美特斯邦威',111.10,'女装',2,6,1,'https://img.alicdn.com/imgextra/i2/134363478/TB2_zkOmnXYBeNkHFrdXXciuVXa-134363478.jpg','https://img.alicdn.com/imgextra/i1/134363478/TB2gUX1uUR1BeNjy0FmXXb0wVXa-134363478.jpg',1,1),(7,'美特斯邦威短袖t恤女士2018夏装新款气质圆领拼接半袖体恤韩版潮','爱心刺绣 蕾丝袖口','2018年夏季','Meters Bonwe/美特斯邦威',122.21,'女装',2,7,1,'https://img.alicdn.com/imgextra/i1/134363478/TB2lWbxcQZmBKNjSZPiXXXFNVXa-134363478.jpg','https://img.alicdn.com/imgextra/i1/134363478/TB2gUX1uUR1BeNjy0FmXXb0wVXa-134363478.jpg',1,1),(8,'aui欧洲站2018夏季新款欧美时尚欧货潮女装气质名媛收腰连衣裙女','气质名媛时尚收腰版型','中长裙','欧美风格',133.32,'女装',2,8,1,'https://img.alicdn.com/imgextra/i2/3027255178/TB29tNAlv5TBuNjSspmXXaDRVXa_!!3027255178.jpg','https://img.alicdn.com/imgextra/i4/3027255178/TB25zMWlXuWBuNjSszbXXcS7FXa_!!3027255178.jpg',1,1),(9,'2018夏季新款欧美时尚重工刺绣花连衣裙气质蕾丝修身显瘦A字裙女','女巫定制时装 蕾丝修身显瘦A字裙','中长裙','欧美风格',144.43,'女装',2,9,1,'https://img.alicdn.com/imgextra/i2/2243781651/TB2kCkerv9TBuNjy1zbXXXpepXa_!!2243781651.jpg','https://img.alicdn.com/imgextra/i4/2243781651/TB2yiPZaBcXBuNjt_XoXXXIwFXa_!!2243781651.jpg',1,1),(10,'伊莲娜欧货品牌女装2018夏季新款a字优雅气质真丝连衣裙女士丝绸','透气清凉亲肤触感 轻松随意无拘束飘逸舒适','复古','无袖',155.54,'女装',2,10,1,'https://img.alicdn.com/imgextra/i3/741251318/TB26_MLifuSBuNkHFqDXXXfhVXa_!!741251318.jpg','https://img.alicdn.com/imgextra/i1/741251318/TB23yFZfDCWBKNjSZFtXXaC3FXa_!!741251318.jpg',1,1);
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
INSERT INTO `e_shop_product_sku` VALUES (1,1,55.00,10.00,999,10,0,'1|2'),(2,2,66.00,20.00,888,100,0,'1|2'),(3,3,77.00,30.00,777,200,0,'1|2'),(4,4,88.88,40.00,666,300,0,'1|2'),(5,5,99.99,50.00,555,400,0,'1|2'),(6,6,111.10,60.00,444,500,0,'1|2'),(7,7,122.21,70.00,333,600,0,'1|2'),(8,8,133.32,80.00,222,700,0,'1|2'),(9,9,144.43,90.00,111,800,0,'1|2'),(10,10,155.54,100.00,777,900,0,'1|2');
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
INSERT INTO `e_shop_product_sku_attr` VALUES (1,1,'COLOR','红',0),(2,1,'COLOR','黑',1),(3,1,'SIZE','m',0),(4,1,'SIZE','x',1);
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
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
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
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
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

-- Dump completed on 2018-06-13 10:48:22
