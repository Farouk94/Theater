/*
Navicat MySQL Data Transfer

Source Server         : 172.32.20.71_3306
Source Server Version : 50717
Source Host           : 172.32.20.71:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-01-23 19:47:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_registration
-- ----------------------------
DROP TABLE IF EXISTS `user_registration`;
CREATE TABLE `user_registration` (
  `name` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_registration
-- ----------------------------
INSERT INTO `user_registration` VALUES ('admin', 'admin@gmail.com', 'admin');
INSERT INTO `user_registration` VALUES ('user', 'user@gmail.com', 'user');
SET FOREIGN_KEY_CHECKS=1;
