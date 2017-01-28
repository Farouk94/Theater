/*
Navicat MySQL Data Transfer

Source Server         : 172.32.20.71_3306
Source Server Version : 50717
Source Host           : 172.32.20.71:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-01-23 19:46:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for artist_detail
-- ----------------------------
DROP TABLE IF EXISTS `artist_detail`;
CREATE TABLE `artist_detail` (
  `type` varchar(255) NOT NULL COMMENT 'Master table for artists',
  `category` varchar(255) NOT NULL,
  `baseprice` int(11) NOT NULL,
  PRIMARY KEY (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of artist_detail
-- ----------------------------
INSERT INTO `artist_detail` VALUES ('C1', 'NA', '5');
INSERT INTO `artist_detail` VALUES ('C2', 'LANA', '10');
INSERT INTO `artist_detail` VALUES ('C3', 'MNA', '20');
INSERT INTO `artist_detail` VALUES ('C4', 'MIA', '50');
SET FOREIGN_KEY_CHECKS=1;
