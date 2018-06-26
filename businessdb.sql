/*
 Navicat Premium Data Transfer

 Source Server         : mysql555
 Source Server Type    : MySQL
 Source Server Version : 50712
 Source Host           : localhost:3306
 Source Schema         : businessdb

 Target Server Type    : MySQL
 Target Server Version : 50712
 File Encoding         : 65001

 Date: 25/06/2018 10:26:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for demo
-- ----------------------------
DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `money` float(255, 0) DEFAULT NULL,
  `create_time` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for e_shop_marketing
-- ----------------------------
DROP TABLE IF EXISTS `e_shop_marketing`;
CREATE TABLE `e_shop_marketing`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动名称',
  `tag` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动标签：限时折扣，满减送等',
  `begin_time` datetime(0) DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime(0) DEFAULT NULL COMMENT '结束时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '营销主表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of e_shop_marketing
-- ----------------------------
INSERT INTO `e_shop_marketing` VALUES (1, '活动1', '限制折扣', '2018-01-01 00:00:00', '2018-12-01 00:00:00');

-- ----------------------------
-- Table structure for e_shop_marketing_detail
-- ----------------------------
DROP TABLE IF EXISTS `e_shop_marketing_detail`;
CREATE TABLE `e_shop_marketing_detail`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `marketing_id` int(10) UNSIGNED NOT NULL COMMENT '主表ID',
  `strategy` tinyint(4) NOT NULL COMMENT '促销策略',
  `parameter` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '促销参数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '营销详情表 多个' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of e_shop_marketing_detail
-- ----------------------------
INSERT INTO `e_shop_marketing_detail` VALUES (1, 1, 0, '0.9');

-- ----------------------------
-- Table structure for e_shop_marketing_product_relation
-- ----------------------------
DROP TABLE IF EXISTS `e_shop_marketing_product_relation`;
CREATE TABLE `e_shop_marketing_product_relation`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `marketing_detail_id` int(10) UNSIGNED NOT NULL COMMENT '营销活动详情ID',
  `product_id` int(10) UNSIGNED NOT NULL COMMENT '商品ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '营销和商品关系表 多对多' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of e_shop_marketing_product_relation
-- ----------------------------
INSERT INTO `e_shop_marketing_product_relation` VALUES (1, 1, 1);

-- ----------------------------
-- Table structure for e_shop_payment
-- ----------------------------
DROP TABLE IF EXISTS `e_shop_payment`;
CREATE TABLE `e_shop_payment`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_order_id` int(10) UNSIGNED NOT NULL COMMENT '对应的订单id',
  `payment_status` tinyint(4) NOT NULL COMMENT '状态 0表示成功 1表示等待支付',
  `user_id` int(10) UNSIGNED NOT NULL COMMENT '用户ID',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `fee` int(11) NOT NULL COMMENT '金额(分为单位)',
  `channel_id` tinyint(4) NOT NULL COMMENT '支付渠道ID。',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '支付模块' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for e_shop_product
-- ----------------------------
DROP TABLE IF EXISTS `e_shop_product`;
CREATE TABLE `e_shop_product`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `subtitle` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '副标题',
  `brief` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '产品简述',
  `content_desc` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '详情',
  `price_underline` decimal(10, 2) DEFAULT NULL COMMENT '划线价格 市场价',
  `keyword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '关键字',
  `product_category_id` int(10) UNSIGNED NOT NULL COMMENT '产品的类别',
  `sort_order` tinyint(4) DEFAULT NULL COMMENT '排序',
  `is_on_sale` tinyint(4) DEFAULT NULL COMMENT '是否上架',
  `img_primary_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '主图',
  `img_list_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图片列表',
  `is_delete` tinyint(4) DEFAULT NULL,
  `vendor_user_id` int(11) DEFAULT NULL COMMENT '商家',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品表 SPU\r包含了产品的基本属性。不影响价格。\r如：iphone x 产品' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of e_shop_product
-- ----------------------------
INSERT INTO `e_shop_product` VALUES (1, '英爵伦 2018夏季新款 男士纯色短袖T恤 男装体恤上衣简约潮牌衣服', '95%棉 打底柔软舒适 外穿简约时尚', ' 纯电商(只在线上销售)', ' 纯电商(只在线上销售)', 55.00, '男装', 1, 1, 1, 'https://img.alicdn.com/imgextra/i1/1860270913/TB1Zs5JwQCWBuNjy0FaXXXUlXXa_!!0-item_pic.jpg_430x430q90.jpg', 'https://img.alicdn.com/imgextra/i2/134363478/TB2LT82r7SWBuNjSszdXXbeSpXa-134363478.jpg', 1, 1);
INSERT INTO `e_shop_product` VALUES (2, '男士短袖t恤2018夏季新款男生翻领潮流男装polo衫半袖夏装上衣服', '外穿简约时尚', ' 纯电商(只在线上销售)', ' 纯电商(只在线上销售)', 66.00, '男装', 1, 2, 1, 'https://img.alicdn.com/imgextra/i2/1589942160/TB2uD6voTXYBeNkHFrdXXciuVXa_!!1589942160.jpg', 'https://img.alicdn.com/imgextra/i3/1589942160/TB2NBJqimcqBKNjSZFgXXX_kXXa_!!1589942160.jpg', 1, 1);
INSERT INTO `e_shop_product` VALUES (3, '美特斯邦威短袖t恤男潮流2018夏季新款条纹海军风印花上衣服韩版', '字母印花 经典圆领', '2018年夏季', 'Meters Bonwe/美特斯邦威', 77.00, '男装', 1, 3, 1, 'https://metersbonwe.tmall.com/shop/view_shop.htm?spm=a220o.1000855.w5003-17193593444.1.792556d99GSKFN&mytmenu=mdianpu&utkn=g%2Cypamzwglxgyo5tp6xhm3ppon7c26u1528127082222&user_number_id=134363478&scm=1028.1.2.20001&scene=taobao_shop', 'https://img.alicdn.com/imgextra/i2/134363478/TB2LT82r7SWBuNjSszdXXbeSpXa-134363478.jpg', 1, 1);
INSERT INTO `e_shop_product` VALUES (4, '美特斯邦威短袖衬衫男2018夏季新款基础衬衣休闲纯色纯棉牛津纺', '立领设计 字母印花口袋', '2018年夏季', 'Meters Bonwe/美特斯邦威', 88.88, '男装', 1, 4, 1, 'https://img.alicdn.com/imgextra/i2/134363478/TB2oeG2r21TBuNjy0FjXXajyXXa-134363478.jpg', 'https://img.alicdn.com/imgextra/i3/134363478/TB2ZWJKrYSYBuNjSspiXXXNzpXa-134363478.jpg', 1, 1);
INSERT INTO `e_shop_product` VALUES (5, '美特斯邦威短袖衬衫男装2018夏季新款纯棉chic原宿港风格子衬衫', '经典格纹 斜纹口袋', '2018年秋季', 'Meters Bonwe/美特斯邦威', 99.99, '男装', 1, 5, 1, 'https://img.alicdn.com/imgextra/i2/134363478/TB2b97GiyOYBuNjSsD4XXbSkFXa-134363478.jpg', 'https://img.alicdn.com/imgextra/i2/134363478/TB2b97GiyOYBuNjSsD4XXbSkFXa-134363478.jpg', 1, 1);
INSERT INTO `e_shop_product` VALUES (6, '美特斯邦威情侣短袖t恤女百搭纯色纯棉打底衫上衣韩2018夏装新款', '纯色T恤 舒适圆领', '2018年夏季', 'Meters Bonwe/美特斯邦威', 111.10, '女装', 2, 6, 1, 'https://img.alicdn.com/imgextra/i2/134363478/TB2_zkOmnXYBeNkHFrdXXciuVXa-134363478.jpg', 'https://img.alicdn.com/imgextra/i1/134363478/TB2gUX1uUR1BeNjy0FmXXb0wVXa-134363478.jpg', 1, 1);
INSERT INTO `e_shop_product` VALUES (7, '美特斯邦威短袖t恤女士2018夏装新款气质圆领拼接半袖体恤韩版潮', '爱心刺绣 蕾丝袖口', '2018年夏季', 'Meters Bonwe/美特斯邦威', 122.21, '女装', 2, 7, 1, 'https://img.alicdn.com/imgextra/i1/134363478/TB2lWbxcQZmBKNjSZPiXXXFNVXa-134363478.jpg', 'https://img.alicdn.com/imgextra/i1/134363478/TB2gUX1uUR1BeNjy0FmXXb0wVXa-134363478.jpg', 1, 1);
INSERT INTO `e_shop_product` VALUES (8, 'aui欧洲站2018夏季新款欧美时尚欧货潮女装气质名媛收腰连衣裙女', '气质名媛时尚收腰版型', '中长裙', '欧美风格', 133.32, '女装', 2, 8, 1, 'https://img.alicdn.com/imgextra/i2/3027255178/TB29tNAlv5TBuNjSspmXXaDRVXa_!!3027255178.jpg', 'https://img.alicdn.com/imgextra/i4/3027255178/TB25zMWlXuWBuNjSszbXXcS7FXa_!!3027255178.jpg', 1, 1);
INSERT INTO `e_shop_product` VALUES (9, '2018夏季新款欧美时尚重工刺绣花连衣裙气质蕾丝修身显瘦A字裙女', '女巫定制时装 蕾丝修身显瘦A字裙', '中长裙', '欧美风格', 144.43, '女装', 2, 9, 1, 'https://img.alicdn.com/imgextra/i2/2243781651/TB2kCkerv9TBuNjy1zbXXXpepXa_!!2243781651.jpg', 'https://img.alicdn.com/imgextra/i4/2243781651/TB2yiPZaBcXBuNjt_XoXXXIwFXa_!!2243781651.jpg', 1, 1);
INSERT INTO `e_shop_product` VALUES (10, '伊莲娜欧货品牌女装2018夏季新款a字优雅气质真丝连衣裙女士丝绸', '透气清凉亲肤触感 轻松随意无拘束飘逸舒适', '复古', '无袖', 155.54, '女装', 2, 10, 1, 'https://img.alicdn.com/imgextra/i3/741251318/TB26_MLifuSBuNkHFqDXXXfhVXa_!!741251318.jpg', 'https://img.alicdn.com/imgextra/i1/741251318/TB23yFZfDCWBKNjSZFtXXaC3FXa_!!741251318.jpg', 1, 1);

-- ----------------------------
-- Table structure for e_shop_product_category
-- ----------------------------
DROP TABLE IF EXISTS `e_shop_product_category`;
CREATE TABLE `e_shop_product_category`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NOT NULL,
  `name` char(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '名字',
  `category_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `sort_order` smallint(6) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '产品分类 可以是类 目 或者 品牌' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of e_shop_product_category
-- ----------------------------
INSERT INTO `e_shop_product_category` VALUES (1, 0, '衣服', '衣服', 0);

-- ----------------------------
-- Table structure for e_shop_product_sku
-- ----------------------------
DROP TABLE IF EXISTS `e_shop_product_sku`;
CREATE TABLE `e_shop_product_sku`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `product_id` int(10) UNSIGNED DEFAULT NULL COMMENT '属于哪个产品',
  `unit_price` decimal(10, 2) NOT NULL COMMENT '单价',
  `cost_price` decimal(10, 2) DEFAULT NULL COMMENT '成本价 可为空',
  `stock_amount` int(11) NOT NULL COMMENT '库存',
  `sale_amount` int(11) DEFAULT 0 COMMENT '销售额',
  `stock_barcode` int(11) DEFAULT NULL COMMENT '商家自定义编号',
  `attr_option` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'sku属性ID串',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品SKU（库存单品）。影响价格和库存。\r如：手机内存容量。颜色。\r多个对应一个商品' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of e_shop_product_sku
-- ----------------------------
INSERT INTO `e_shop_product_sku` VALUES (1, 1, 55.00, 10.00, 999, 10, 0, '2|6');
INSERT INTO `e_shop_product_sku` VALUES (2, 1, 66.00, 20.00, 888, 100, 0, '3|7');
INSERT INTO `e_shop_product_sku` VALUES (3, 3, 77.00, 30.00, 777, 200, 0, '2|6');
INSERT INTO `e_shop_product_sku` VALUES (4, 4, 88.88, 40.00, 666, 300, 0, '2|6');
INSERT INTO `e_shop_product_sku` VALUES (5, 5, 99.99, 50.00, 555, 400, 0, '2|6');
INSERT INTO `e_shop_product_sku` VALUES (6, 6, 111.10, 60.00, 444, 500, 0, '2|6');
INSERT INTO `e_shop_product_sku` VALUES (7, 7, 122.21, 70.00, 333, 600, 0, '2|6');
INSERT INTO `e_shop_product_sku` VALUES (8, 8, 133.32, 80.00, 222, 700, 0, '2|6');
INSERT INTO `e_shop_product_sku` VALUES (9, 9, 144.43, 90.00, 111, 800, 0, '2|6');
INSERT INTO `e_shop_product_sku` VALUES (10, 10, 155.54, 100.00, 777, 900, 0, '2|6');

-- ----------------------------
-- Table structure for e_shop_product_sku_attr
-- ----------------------------
DROP TABLE IF EXISTS `e_shop_product_sku_attr`;
CREATE TABLE `e_shop_product_sku_attr`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'sku属性id',
  `parent_id` int(11) NOT NULL COMMENT '属性的父级ID',
  `user_id` int(10) UNSIGNED NOT NULL COMMENT '属性对应的用户',
  `attr_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '属性的值',
  `sort_order` int(11) NOT NULL COMMENT '属性的排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'sku 销售属性。影响价格和库存。手机内存容量。颜色。\r多个对应一个商品' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of e_shop_product_sku_attr
-- ----------------------------
INSERT INTO `e_shop_product_sku_attr` VALUES (1, 0, 1, '颜色', 0);
INSERT INTO `e_shop_product_sku_attr` VALUES (2, 1, 1, '红色', 0);
INSERT INTO `e_shop_product_sku_attr` VALUES (3, 1, 1, '蓝色', 0);
INSERT INTO `e_shop_product_sku_attr` VALUES (4, 1, 1, '白色', 0);
INSERT INTO `e_shop_product_sku_attr` VALUES (5, 0, 1, '尺码', 0);
INSERT INTO `e_shop_product_sku_attr` VALUES (6, 5, 0, 'M', 0);
INSERT INTO `e_shop_product_sku_attr` VALUES (7, 5, 0, 'L', 0);
INSERT INTO `e_shop_product_sku_attr` VALUES (8, 5, 0, 'S', 0);
INSERT INTO `e_shop_product_sku_attr` VALUES (9, 0, 1, 'a', 0);
INSERT INTO `e_shop_product_sku_attr` VALUES (10, 0, 1, 'a', 0);
INSERT INTO `e_shop_product_sku_attr` VALUES (11, 0, 1, 'a', 0);
INSERT INTO `e_shop_product_sku_attr` VALUES (12, 0, 1, 'a', 0);
INSERT INTO `e_shop_product_sku_attr` VALUES (13, 0, 1, 'a', 0);
INSERT INTO `e_shop_product_sku_attr` VALUES (14, 0, 1, 'a', 0);
INSERT INTO `e_shop_product_sku_attr` VALUES (15, 0, 1, 'a', 0);
INSERT INTO `e_shop_product_sku_attr` VALUES (16, 0, 1, 'a', 0);

-- ----------------------------
-- Table structure for e_shop_product_stock
-- ----------------------------
DROP TABLE IF EXISTS `e_shop_product_stock`;
CREATE TABLE `e_shop_product_stock`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `product_skuid` int(10) UNSIGNED DEFAULT NULL COMMENT '属于哪个产品',
  `stock_amount` int(11) NOT NULL COMMENT '库存',
  `stock_barcode` int(11) NOT NULL COMMENT '商家自定义编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for e_shop_role
-- ----------------------------
DROP TABLE IF EXISTS `e_shop_role`;
CREATE TABLE `e_shop_role`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色的显示名字',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新者',
  `permission_str` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限字符串',
  `del_flag` tinyint(4) NOT NULL COMMENT '删除标记 0：正常， 1：删除',
<<<<<<< HEAD
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_shop_role`
--

LOCK TABLES `e_shop_role` WRITE;
/*!40000 ALTER TABLE `e_shop_role` DISABLE KEYS */;
INSERT INTO `e_shop_role` VALUES (1,'商户','商家',NULL,NULL,NULL,NULL,0),(2,'消费者','消费者',NULL,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `e_shop_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_shop_role_permission`
--

DROP TABLE IF EXISTS `e_shop_role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_shop_role_permission` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `parent_id` int(10) unsigned NOT NULL COMMENT '父级ID',
  `title` varchar(64) NOT NULL COMMENT '菜单名字',
  `icon` varchar(255) NOT NULL COMMENT '菜单图片',
  `description` varchar(255) NOT NULL COMMENT '菜单描述',
  `url` varchar(255) DEFAULT NULL COMMENT '菜单链接',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `sort_order` tinyint(4) DEFAULT NULL COMMENT '排序',
  `del_flag` tinyint(4) NOT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='用户资源（菜单）表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_shop_role_permission`
--

LOCK TABLES `e_shop_role_permission` WRITE;
/*!40000 ALTER TABLE `e_shop_role_permission` DISABLE KEYS */;
INSERT INTO `e_shop_role_permission` VALUES (1,0,'系统管理','icon','desc','url',NULL,NULL,NULL,NULL,NULL,0),(2,1,'菜单配置','icon','desc','url',NULL,NULL,NULL,NULL,NULL,0),(3,0,'用户管理','icon','desc','url',NULL,NULL,NULL,NULL,NULL,0),(4,3,'角色配置','icon','desc','url',NULL,NULL,NULL,NULL,NULL,0),(5,3,'用户配置','icon','desc','url',NULL,NULL,NULL,NULL,NULL,0),(10,3,'离散数学','icon','离散数学历史小说','lssx',NULL,NULL,NULL,NULL,NULL,0),(11,3,'嘻嘻嘻嘻','icon','嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻','xxxx',NULL,NULL,NULL,NULL,NULL,0),(12,3,'大家好','icon','多个地方','safvcsafcv',NULL,NULL,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `e_shop_role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_shop_role_permission_relation`
--

DROP TABLE IF EXISTS `e_shop_role_permission_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_shop_role_permission_relation` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int(10) unsigned NOT NULL COMMENT '营销活动详情ID',
  `permission_id` int(10) unsigned NOT NULL COMMENT '商品ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色和菜单 关系表 多对多';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_shop_role_permission_relation`
--

LOCK TABLES `e_shop_role_permission_relation` WRITE;
/*!40000 ALTER TABLE `e_shop_role_permission_relation` DISABLE KEYS */;
INSERT INTO `e_shop_role_permission_relation` VALUES (1,1,1),(2,1,2);
/*!40000 ALTER TABLE `e_shop_role_permission_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_shop_user`
--

=======
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of e_shop_role
-- ----------------------------
INSERT INTO `e_shop_role` VALUES (1, '超级管理员', NULL, NULL, NULL, 'ADMMIN', 0);
INSERT INTO `e_shop_role` VALUES (2, '商家', NULL, NULL, NULL, 'VENDOR', 0);
INSERT INTO `e_shop_role` VALUES (3, '消费者', NULL, NULL, NULL, 'CONSUMER', 0);

-- ----------------------------
-- Table structure for e_shop_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `e_shop_role_menu`;
CREATE TABLE `e_shop_role_menu`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `parent_id` int(10) UNSIGNED NOT NULL COMMENT '父级ID',
  `title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名字',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单图片',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单描述',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单链接',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新者',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新者',
  `sort_order` tinyint(4) DEFAULT NULL COMMENT '排序',
  `del_flag` tinyint(4) NOT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户资源（菜单）表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of e_shop_role_menu
-- ----------------------------
INSERT INTO `e_shop_role_menu` VALUES (1, 0, '系统', '系统', '系统', '系统', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `e_shop_role_menu` VALUES (2, 1, '菜单配置', '菜单配置', '菜单配置', '菜单配置', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `e_shop_role_menu` VALUES (3, 0, '用户和角色', '用户和角色', '用户和角色', '用户和角色', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `e_shop_role_menu` VALUES (4, 3, '角色设置', '角色设置', '角色设置', '角色设置', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `e_shop_role_menu` VALUES (5, 3, '用户设置', '用户设置', '用户设置', '用户设置', NULL, NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for e_shop_role_menu_relation
-- ----------------------------
DROP TABLE IF EXISTS `e_shop_role_menu_relation`;
CREATE TABLE `e_shop_role_menu_relation`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `role_id` int(10) UNSIGNED NOT NULL COMMENT '营销活动详情ID',
  `menu_id` int(10) UNSIGNED NOT NULL COMMENT '商品ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色和菜单 关系表 多对多' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of e_shop_role_menu_relation
-- ----------------------------
INSERT INTO `e_shop_role_menu_relation` VALUES (1, 1, 1);
INSERT INTO `e_shop_role_menu_relation` VALUES (2, 1, 2);
INSERT INTO `e_shop_role_menu_relation` VALUES (3, 1, 3);
INSERT INTO `e_shop_role_menu_relation` VALUES (4, 1, 4);
INSERT INTO `e_shop_role_menu_relation` VALUES (5, 1, 5);
INSERT INTO `e_shop_role_menu_relation` VALUES (6, 2, 1);
INSERT INTO `e_shop_role_menu_relation` VALUES (7, 2, 2);

-- ----------------------------
-- Table structure for e_shop_user
-- ----------------------------
>>>>>>> b8eb4e1a07c9d8809e2aa88fdb5aa0131ac46284
DROP TABLE IF EXISTS `e_shop_user`;
CREATE TABLE `e_shop_user`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `role_id` int(10) UNSIGNED NOT NULL COMMENT '角色ID',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
  `status` tinyint(4) NOT NULL COMMENT '状态 0：可用',
  `user_type` tinyint(4) DEFAULT NULL COMMENT '用户类型（管理员， 普通用户）',
  `login_ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登录地址',
  `login_date` datetime(0) DEFAULT NULL COMMENT '登录时间',
  `title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '前端展示名字',
  `telphone` varchar(21) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话',
  `mobile_phone` varchar(21) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号',
  `gender` tinyint(4) DEFAULT NULL COMMENT '性别',
  `avatar_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像地址',
  `wx_nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '微信昵称',
  `wx_mini_app_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '微信用户使用的小程序ID',
  `wx_open_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '微信openid',
  `wx_union_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '微信uuid',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `last_reset_password_time` datetime(0) DEFAULT NULL COMMENT '最后修改密码时间',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电子邮件',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of e_shop_user
-- ----------------------------
INSERT INTO `e_shop_user` VALUES (1, 1, 'admin', '$2a$10$kjaBIAnT8CF74aB4NCTdseoSmvOigmYeRoMkVQGoW3LTaQkIhSBO.', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for e_shop_user_address
-- ----------------------------
DROP TABLE IF EXISTS `e_shop_user_address`;
CREATE TABLE `e_shop_user_address`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(10) UNSIGNED NOT NULL COMMENT '用户id',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收件人',
  `mobile_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `area_addr1` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '区域地址1 省',
  `area_addr2` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '区域地址2 市',
  `area_addr3` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '区域地址3 区县',
  `addr_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '详细地址',
  `area_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '区域码',
  `is_default` tinyint(4) NOT NULL COMMENT '默认地址 0:否  1:是',
  `telphone` varchar(21) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话号码',
  `post_code` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮编',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_account
-- ----------------------------
DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `phone` varchar(21) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` tinyint(1) DEFAULT 0,
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `last_reset_password_time` datetime(0) DEFAULT NULL,
  `role_id` mediumint(8) DEFAULT NULL,
  `sex` tinyint(1) DEFAULT NULL,
  `nick_name` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `head_url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `app_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `open_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `union_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `default_addr_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_account
-- ----------------------------
INSERT INTO `user_account` VALUES (1, NULL, NULL, 'test', '$2a$10$9TBnSUPfsTg6anyDF5DI2OtFSDky9u9fZntSXkM/nWQe8gGCgyU6K', '2018-06-09 11:16:38', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_account` VALUES (6, NULL, 1, 'oUeJY5P0SfCNrJnlLtYTJiKm57yM', '$2a$10$e9AKQm3Hygi5o78JWXrAeOufCSTYtI.K72A9mdxHvRtJHUE6Hajfa', '2018-06-11 10:15:09', NULL, 1, 'Yang', 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKcq5xY5euQmIBBzlGuwUJibxFHFNia83YXwianUprszUmDOoxZYEMq4IRNdicgDmpyUtkZpmkr86QkGA/132', 'wxdda83d03c2d1521c', 'oUeJY5P0SfCNrJnlLtYTJiKm57yM', NULL, NULL);
INSERT INTO `user_account` VALUES (7, NULL, 1, 'oUeJY5KR0bECG54dDD0trBqgzkDo', '$2a$10$8XkOelVXt922cdBTEzIuaOmYLKawrr9ilqpQ49uCGbYxrey5W15rK', '2018-06-11 17:13:13', NULL, 1, '机车王小二', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqxPKde5h68XULD7URQm4g2p9xlDTlMJhV4BNJeeboInKhqvqB475fiaJoYlsLF9y8M6jXddmKRG5g/132', 'wxdda83d03c2d1521c', 'oUeJY5KR0bECG54dDD0trBqgzkDo', 'oJ6K-1eZqk8pv1Lvae7zfd-MaVfw', NULL);

-- ----------------------------
-- Table structure for user_addr
-- ----------------------------
DROP TABLE IF EXISTS `user_addr`;
CREATE TABLE `user_addr`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_account` mediumint(8) NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `areaaddr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `addr_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `area_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_cart
-- ----------------------------
DROP TABLE IF EXISTS `user_cart`;
CREATE TABLE `user_cart`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_sku_id` int(11) NOT NULL COMMENT '产品单品id',
  `user_account` int(11) NOT NULL COMMENT '用户id',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `count` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_cart
-- ----------------------------
INSERT INTO `user_cart` VALUES (1, 1, 7, '2018-06-20 09:59:30', 1);
INSERT INTO `user_cart` VALUES (2, 1, 7, '2018-06-20 10:08:09', 1);
INSERT INTO `user_cart` VALUES (3, 1, 7, '2018-06-20 11:11:20', 1);

-- ----------------------------
-- Table structure for user_order
-- ----------------------------
DROP TABLE IF EXISTS `user_order`;
CREATE TABLE `user_order`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `roder_sn` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '订单号',
  `status` int(11) NOT NULL COMMENT '订单状态',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `product_sku_id` int(11) NOT NULL COMMENT '单品id',
  `freight` decimal(10, 2) NOT NULL COMMENT '运费',
  `count` int(11) NOT NULL COMMENT '数量',
  `addr_id` int(11) DEFAULT NULL COMMENT '地址id',
  `real_money` decimal(10, 2) NOT NULL COMMENT '实际价格',
  `express_sn` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '快递单号',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  `user_account` int(11) NOT NULL COMMENT '用户账号',
  `wechar_orderid` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '微信订单id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `role_id` mediumint(8) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for vendor_category
-- ----------------------------
DROP TABLE IF EXISTS `vendor_category`;
CREATE TABLE `vendor_category`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `type` smallint(5) NOT NULL,
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for vendor_user
-- ----------------------------
DROP TABLE IF EXISTS `vendor_user`;
CREATE TABLE `vendor_user`  (
  `id` int(10) UNSIGNED NOT NULL,
  `category_type` smallint(5) NOT NULL,
  `app_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `create_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `address` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `phone` varchar(21) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `logo_url` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `custom_phone` varchar(21) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `card_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `business_registration_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `status` tinyint(1) NOT NULL,
  `app_secret` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `nick_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vendor_user
-- ----------------------------
INSERT INTO `vendor_user` VALUES (1, 0, 'wxdda83d03c2d1521c', '', '2018-06-09 10:41:48', '', '', NULL, NULL, '', '', 0, 'fad3978bb8d6aed7a341feb506b5f6e5', '');

-- ----------------------------
-- Table structure for vendor_user_config
-- ----------------------------
DROP TABLE IF EXISTS `vendor_user_config`;
CREATE TABLE `vendor_user_config`  (
  `id` int(10) UNSIGNED NOT NULL COMMENT '主键',
  `vendor_id` int(11) NOT NULL COMMENT '商户id',
<<<<<<< HEAD
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

-- Dump completed on 2018-06-25 17:07:50
=======
  `config_key` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '配置key值',
  `config_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '配置value值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
>>>>>>> b8eb4e1a07c9d8809e2aa88fdb5aa0131ac46284
