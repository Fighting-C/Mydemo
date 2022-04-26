/*
Navicat MySQL Data Transfer

Source Server         : LocalDataBase
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : demo1

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2022-04-26 12:32:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for production
-- ----------------------------
DROP TABLE IF EXISTS `production`;
CREATE TABLE `production` (
  `Pro_Id` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `Pro_Name` varchar(64) DEFAULT NULL,
  `Pro_Type` varchar(64) DEFAULT NULL,
  `Pro_Manage` int(64) DEFAULT '1000' COMMENT '当前管理资产',
  `Pro_BeTime` datetime DEFAULT NULL COMMENT '当前募集时间',
  `Pro_EndTime` datetime DEFAULT NULL COMMENT '募集结束时间',
  `Pro_LastTime` datetime DEFAULT NULL COMMENT '上次分红时间',
  `Pro_status` varchar(32) DEFAULT '运营中',
  `Pro_cang` int(32) DEFAULT NULL,
  `Pro_nowGet` decimal(32,2) DEFAULT '0.00',
  `Pro_monGet` decimal(32,2) DEFAULT '0.00',
  PRIMARY KEY (`Pro_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of production
-- ----------------------------
INSERT INTO `production` VALUES ('1', '产品1', '证券', '1000', '2022-04-02 11:19:50', '2022-04-03 11:19:56', '2022-04-04 11:20:00', '运营中', '80', '2.30', '0.00');
INSERT INTO `production` VALUES ('2', '产品2', '股票', '2000', '2022-04-05 11:20:28', '2022-04-13 11:20:32', '2022-04-21 14:30:02', '已结算', '70', '3.30', '0.00');
INSERT INTO `production` VALUES ('3', '产品3', '股票', '3000', '2022-03-30 12:23:39', '2022-04-20 12:23:41', '2022-04-06 12:23:45', '运营中', '80', '-2.00', '0.00');
INSERT INTO `production` VALUES ('4', '产品4', '基金', '1000', '2022-04-05 12:24:18', '2022-04-06 12:24:21', '2022-04-21 13:56:19', '已结算', '90', '3.80', '0.00');
INSERT INTO `production` VALUES ('6', '产品8', '公募', '1000', '2021-12-06 00:00:00', '2021-12-15 00:00:00', '2022-04-21 14:30:04', '运营中', '80', '-3.00', '0.00');
INSERT INTO `production` VALUES ('14', '产品10', '私募', '100000', '2021-12-06 00:00:00', '2021-12-08 00:00:00', null, '运营中', '80', '-9.00', '0.00');

-- ----------------------------
-- Table structure for shares
-- ----------------------------
DROP TABLE IF EXISTS `shares`;
CREATE TABLE `shares` (
  `share_id` int(16) NOT NULL AUTO_INCREMENT,
  `share_name` varchar(16) DEFAULT NULL,
  `share_price` decimal(10,2) DEFAULT NULL,
  `share_number` int(32) DEFAULT NULL,
  `share_type` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`share_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shares
-- ----------------------------
INSERT INTO `shares` VALUES ('1', '新力金融', '7.50', '600318', '多元金融');
INSERT INTO `shares` VALUES ('2', '筑博设计', '25.05', '300564', '工程咨询服务');
INSERT INTO `shares` VALUES ('3', '智动力', '10.05', '300686', '消费电子');
INSERT INTO `shares` VALUES ('4', '天地源', '4.80', '600665', '房地产开发');
INSERT INTO `shares` VALUES ('5', '退市拉夏', '0.69', '603157', '纺织服务');
INSERT INTO `shares` VALUES ('6', '国发股份', '0.69', '600538', '农药兽药');
INSERT INTO `shares` VALUES ('7', 'XD东尼电', '25.71', '603595', '消费电子');

-- ----------------------------
-- Table structure for share_index
-- ----------------------------
DROP TABLE IF EXISTS `share_index`;
CREATE TABLE `share_index` (
  `Index_id` int(16) NOT NULL AUTO_INCREMENT,
  `Pro_id` int(16) NOT NULL,
  `share_id` int(16) NOT NULL,
  `share_name` varchar(255) DEFAULT NULL,
  `share_price` decimal(10,2) DEFAULT NULL,
  `share_type` varchar(255) DEFAULT NULL,
  `share_number` int(32) DEFAULT NULL,
  `share_manage` int(32) DEFAULT '0',
  PRIMARY KEY (`Index_id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of share_index
-- ----------------------------
INSERT INTO `share_index` VALUES ('20', '6', '1', '股票1', '2.00', '汽车', '11', '0');
INSERT INTO `share_index` VALUES ('21', '4', '1', '股票1', '2.00', '汽车', '11', '0');
INSERT INTO `share_index` VALUES ('22', '4', '2', '股票2', '2.00', '飞机', '22', '0');
INSERT INTO `share_index` VALUES ('23', '4', '1', '股票1', '2.00', '汽车', '11', '0');
INSERT INTO `share_index` VALUES ('24', '4', '1', '股票1', '2.00', '汽车', '11', '0');
INSERT INTO `share_index` VALUES ('25', '4', '2', '股票2', '2.00', '飞机', '22', '0');
INSERT INTO `share_index` VALUES ('26', '4', '1', '股票1', '2.00', '汽车', '11', '0');
INSERT INTO `share_index` VALUES ('33', '2', '1', '股票1', '2.00', '汽车', '11', '1');
INSERT INTO `share_index` VALUES ('34', '2', '1', '股票1', '2.00', '汽车', '11', '11');
INSERT INTO `share_index` VALUES ('41', '1', '1', '新力金融', '7.50', '多元金融', '600318', '100');
INSERT INTO `share_index` VALUES ('44', '3', '5', '退市拉夏', '0.69', '纺织服务', '603157', '0');
INSERT INTO `share_index` VALUES ('46', '14', '1', '新力金融', '7.50', '多元金融', '600318', '100');

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `task_id` int(16) NOT NULL AUTO_INCREMENT,
  `pro_id` int(16) NOT NULL,
  `fromUser_id` int(11) NOT NULL,
  `task_type` varchar(16) DEFAULT NULL,
  `task_time` datetime DEFAULT NULL,
  `task_statu` varchar(16) DEFAULT NULL,
  `toUser_type` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES ('1', '1', '2', '分红', '2022-04-19 16:58:27', '未通过', 'approver');
INSERT INTO `task` VALUES ('2', '2', '3', '结算', '2022-04-12 10:58:55', '未通过', 'approver');
INSERT INTO `task` VALUES ('5', '5', '2', '分红', '2022-03-29 14:37:45', '未通过', 'approver');
INSERT INTO `task` VALUES ('21', '2', '2', '分红', '2022-04-21 13:57:09', '已通过', 'approver');
INSERT INTO `task` VALUES ('22', '2', '2', '结算', '2022-04-21 13:57:35', '已通过', 'approver');
INSERT INTO `task` VALUES ('23', '5', '2', '结算', '2022-04-21 14:28:37', '已通过', 'approver');
INSERT INTO `task` VALUES ('24', '6', '25', '分红', '2022-04-21 14:29:58', '已通过', 'approver');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `User_Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `User_Type` varchar(64) DEFAULT NULL COMMENT '用户角色',
  `User_Number` varchar(64) NOT NULL,
  `User_password` varchar(64) NOT NULL,
  `avatar` varchar(128) DEFAULT 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',
  `User_time` datetime DEFAULT NULL,
  PRIMARY KEY (`User_Id`,`User_Number`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='头像';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', 'admin', 'admin', 'D99F7D2E0E54C0EE1186D549BAA767B4', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', '2022-04-07 15:18:46');
INSERT INTO `user` VALUES ('3', 'editor', 'editor', 'D99F7D2E0E54C0EE1186D549BAA767B4', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', '2022-04-02 15:18:50');
INSERT INTO `user` VALUES ('25', 'approver', 'approver', 'D99F7D2E0E54C0EE1186D549BAA767B4', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', '2022-04-14 22:45:28');

-- ----------------------------
-- Table structure for user_index
-- ----------------------------
DROP TABLE IF EXISTS `user_index`;
CREATE TABLE `user_index` (
  `User_id` int(10) NOT NULL,
  `User_Type` varchar(64) DEFAULT NULL,
  `User_Index` int(8) NOT NULL DEFAULT '0' COMMENT '用户权限标识',
  PRIMARY KEY (`User_Index`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_index
-- ----------------------------
INSERT INTO `user_index` VALUES ('2', '1', '1');
INSERT INTO `user_index` VALUES ('3', '2', '2');
