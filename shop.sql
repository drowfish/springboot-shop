/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80015
Source Host           : 127.0.0.1:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-05-08 22:27:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES ('1', 'admin', 'admin', '123');

-- ----------------------------
-- Table structure for tb_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `goodsId` bigint(20) DEFAULT NULL,
  `goodsDetailId` bigint(20) DEFAULT NULL,
  `orderId` bigint(20) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `createtime` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_comment
-- ----------------------------
INSERT INTO `tb_comment` VALUES ('1', '5', '2', '1', '1', 'dddd', '60', '2019-01-12');
INSERT INTO `tb_comment` VALUES ('2', '5', '7', '8', '5', 'dddd', '80', '2019-04-26');

-- ----------------------------
-- Table structure for tb_goods
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods`;
CREATE TABLE `tb_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `typeId` bigint(20) DEFAULT NULL,
  `img` varchar(150) DEFAULT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `updatetime` varchar(50) DEFAULT NULL,
  `createtime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_goods
-- ----------------------------
INSERT INTO `tb_goods` VALUES ('2', 'KRISBORG', '1', '5b83b214N52f21de9.jpg', '潮流聚惠', '2019-04-27', '2019-01-17');
INSERT INTO `tb_goods` VALUES ('3', 'AK男装', '1', '853c860acf163905.jpg', '夏装上新 即刻型动', '2019-04-20', '2018-01-17');
INSERT INTO `tb_goods` VALUES ('6', '相机', '2', 'c2d2551f1e05c3bb798d5bab6e713f06', '相机', '2019-04-20', '2019-04-20');
INSERT INTO `tb_goods` VALUES ('7', '果汁', '3', '949e249f9eb214efec7e2d5bd9b4dca5', '果汁', '2019-04-20', '2019-04-20');
INSERT INTO `tb_goods` VALUES ('9', '茶杯', '4', 'f119aa9dcf29d7beba1678126f422edf', '杯子', '2019-04-20', '2019-04-20');
INSERT INTO `tb_goods` VALUES ('10', '唐诗', '5', '05b1ebaa0028e6c4e07cf675c98cf830', '唐诗', '2019-04-20', '2019-04-20');
INSERT INTO `tb_goods` VALUES ('11', '电饭煲', '6', 'f792b2159c2248f294067e18a0a59a71', '电饭煲', '2019-04-20', '2019-04-20');
INSERT INTO `tb_goods` VALUES ('12', '女装', '1', 'cea76bc22b31722f8d39927470a7307a', '风衣女装', '2019-04-26', '2019-04-26');
INSERT INTO `tb_goods` VALUES ('13', 'hhhh', '1', '3228787519dac6a84e8325e09d5b9be0', 'aaaa', '2019-04-27', '2019-04-27');

-- ----------------------------
-- Table structure for tb_goodsdetail
-- ----------------------------
DROP TABLE IF EXISTS `tb_goodsdetail`;
CREATE TABLE `tb_goodsdetail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goodsId` bigint(20) DEFAULT NULL,
  `specName` varchar(500) DEFAULT NULL,
  `stockNum` int(11) DEFAULT '0',
  `unitPrice` float DEFAULT NULL,
  `updatetime` varchar(50) DEFAULT NULL,
  `createtime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_goodsdetail
-- ----------------------------
INSERT INTO `tb_goodsdetail` VALUES ('1', '2', 'L', '100', '100', '2019-04-27', '2019-01-20');
INSERT INTO `tb_goodsdetail` VALUES ('2', '2', 'XL', '120', '150', '2019-04-27', '2019-01-20');
INSERT INTO `tb_goodsdetail` VALUES ('3', '3', 'L', '50', '60', '2019-04-20', '2019-01-20');
INSERT INTO `tb_goodsdetail` VALUES ('4', '3', 'XL', '100', '90', '2019-04-20', '2019-01-20');
INSERT INTO `tb_goodsdetail` VALUES ('6', '6', '型号1', '100', '2000', '2019-04-20', '2019-04-20');
INSERT INTO `tb_goodsdetail` VALUES ('7', '6', '型号2', '100', '3000', '2019-04-20', '2019-04-20');
INSERT INTO `tb_goodsdetail` VALUES ('8', '7', '1L', '100', '10', '2019-04-20', '2019-04-20');
INSERT INTO `tb_goodsdetail` VALUES ('9', '7', '2L', '100', '15', '2019-04-20', '2019-04-20');
INSERT INTO `tb_goodsdetail` VALUES ('11', '9', '小杯', '100', '50', '2019-04-20', '2019-04-20');
INSERT INTO `tb_goodsdetail` VALUES ('12', '9', '大杯', '100', '60', '2019-04-20', '2019-04-20');
INSERT INTO `tb_goodsdetail` VALUES ('13', '10', '经典', '100', '60', '2019-04-20', '2019-04-20');
INSERT INTO `tb_goodsdetail` VALUES ('14', '11', '小电饭煲', '100', '400', '2019-04-20', '2019-04-20');
INSERT INTO `tb_goodsdetail` VALUES ('15', '11', '大电饭煲', '100', '600', '2019-04-20', '2019-04-20');
INSERT INTO `tb_goodsdetail` VALUES ('16', '12', 'L', '200', '70', '2019-04-26', '2019-04-26');
INSERT INTO `tb_goodsdetail` VALUES ('17', '12', 'XL', '50', '70', '2019-04-26', '2019-04-26');
INSERT INTO `tb_goodsdetail` VALUES ('18', '2', 'XLL', '100', '120', '2019-04-27', '2019-04-27');
INSERT INTO `tb_goodsdetail` VALUES ('19', '13', '默认', '120', '100', '2019-04-27', '2019-04-27');

-- ----------------------------
-- Table structure for tb_message
-- ----------------------------
DROP TABLE IF EXISTS `tb_message`;
CREATE TABLE `tb_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `goodsId` bigint(20) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `state` int(11) DEFAULT '0',
  `createtime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_message
-- ----------------------------
INSERT INTO `tb_message` VALUES ('1', '5', '2', '嘀嘀嘀', '1', '2019-01-11 15:55:30');
INSERT INTO `tb_message` VALUES ('2', '5', '2', '11', '1', '2019-04-26 10:58:35');
INSERT INTO `tb_message` VALUES ('3', '5', '2', '11', '1', '2019-04-26 11:28:12');
INSERT INTO `tb_message` VALUES ('4', '5', '2', '2222', '1', '2019-04-26 11:31:39');
INSERT INTO `tb_message` VALUES ('5', '5', '2', '333', '0', '2019-04-26 11:31:44');
INSERT INTO `tb_message` VALUES ('6', '5', '2', 'tttt', '0', '2019-04-26 11:32:04');
INSERT INTO `tb_message` VALUES ('7', '5', '2', '8888', '0', '2019-04-26 11:32:09');
INSERT INTO `tb_message` VALUES ('8', '6', '3', '1111', '0', '2019-04-26 13:23:46');
INSERT INTO `tb_message` VALUES ('9', '5', '6', '1111', '0', '2019-04-26 22:37:39');
INSERT INTO `tb_message` VALUES ('10', '5', '3', '2222', '1', '2019-04-27 12:48:32');
INSERT INTO `tb_message` VALUES ('11', '5', '3', '2222', '0', '2019-04-27 13:26:24');

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `goodsDetailId` bigint(20) DEFAULT NULL,
  `goodsNum` int(11) DEFAULT NULL,
  `amount` float DEFAULT NULL,
  `state` int(11) DEFAULT '0',
  `updatetime` varchar(50) DEFAULT NULL,
  `createtime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
INSERT INTO `tb_order` VALUES ('1', '5', '3', '1', '60', '3', '2019-04-26', '2019-04-26');
INSERT INTO `tb_order` VALUES ('5', '5', '8', '1', '10', '3', '2019-04-26', '2019-04-26');
INSERT INTO `tb_order` VALUES ('6', '5', '14', '1', '400', '3', '2019-04-26', '2019-04-26');
INSERT INTO `tb_order` VALUES ('7', '5', '11', '1', '50', '2', '2019-04-26', '2019-04-26');
INSERT INTO `tb_order` VALUES ('9', '5', '6', '1', '2000', '3', '2019-04-26', '2019-04-26');
INSERT INTO `tb_order` VALUES ('10', '5', '13', '1', '60', '2', '2019-04-26', '2019-04-26');
INSERT INTO `tb_order` VALUES ('11', '5', '6', '1', '2000', '2', '2019-04-26', '2019-04-26');
INSERT INTO `tb_order` VALUES ('12', '5', '8', '1', '10', '2', '2019-04-26', '2019-04-26');
INSERT INTO `tb_order` VALUES ('13', '5', '1', '1', '100', '2', '2019-04-27', '2019-04-26');
INSERT INTO `tb_order` VALUES ('14', '5', '16', '1', '70', '2', '2019-04-26', '2019-04-26');
INSERT INTO `tb_order` VALUES ('15', '5', '6', '1', '2000', '0', '2019-04-26', '2019-04-26');
INSERT INTO `tb_order` VALUES ('16', '5', '6', '1', '2000', '1', '2019-04-26', '2019-04-26');
INSERT INTO `tb_order` VALUES ('17', '5', '3', '1', '60', '0', '2019-04-27', '2019-04-27');
INSERT INTO `tb_order` VALUES ('18', '5', '3', '1', '60', '1', '2019-04-27', '2019-04-27');

-- ----------------------------
-- Table structure for tb_reply
-- ----------------------------
DROP TABLE IF EXISTS `tb_reply`;
CREATE TABLE `tb_reply` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `messageId` bigint(20) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `createtime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_reply
-- ----------------------------
INSERT INTO `tb_reply` VALUES ('1', '1', 'dddd', '2019-01-11 15:56:50');
INSERT INTO `tb_reply` VALUES ('2', '2', '555', '2019-04-26');
INSERT INTO `tb_reply` VALUES ('3', '3', '6666', '2019-04-26');
INSERT INTO `tb_reply` VALUES ('4', '4', 'hehehe', '2019-04-26');
INSERT INTO `tb_reply` VALUES ('5', '10', '3333', '2019-04-27');

-- ----------------------------
-- Table structure for tb_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_type`;
CREATE TABLE `tb_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_type
-- ----------------------------
INSERT INTO `tb_type` VALUES ('1', '时尚服饰');
INSERT INTO `tb_type` VALUES ('2', '数码产品');
INSERT INTO `tb_type` VALUES ('3', '食品饮料');
INSERT INTO `tb_type` VALUES ('4', '日常用品');
INSERT INTO `tb_type` VALUES ('5', '小说书刊');
INSERT INTO `tb_type` VALUES ('6', '家用电器');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `nickname` varchar(100) DEFAULT NULL,
  `sex` int(11) NOT NULL DEFAULT '0' COMMENT '0:保密 1:男 2:女',
  `recipient` varchar(255) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `headimg` varchar(100) DEFAULT NULL,
  `updatetime` varchar(50) DEFAULT NULL,
  `createtime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('5', '11@qq.com', '22', 'userOne', '0', '张三', '深圳市', '18774526398', 'head.jpg', '2019-04-26', '2019-04-18');
INSERT INTO `tb_user` VALUES ('6', '22@qq.com', '11', 'user2', '0', '李四', '深圳市', '13211111111', 'head.jpg', '2019-04-18', '2019-04-18');
