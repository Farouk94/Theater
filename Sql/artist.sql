/*
Navicat MySQL Data Transfer

Source Server         : 172.32.20.71_3306
Source Server Version : 50717
Source Host           : 172.32.20.71:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-01-23 19:45:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for artist
-- ----------------------------
DROP TABLE IF EXISTS `artist`;
CREATE TABLE `artist` (
  `artistType` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `SIN` varchar(255) NOT NULL,
  `artistId` int(11) NOT NULL,
  PRIMARY KEY (`artistId`),
  KEY `FK7567CB67772AA9CB` (`artistType`),
  CONSTRAINT `FK7567CB67772AA9CB` FOREIGN KEY (`artistType`) REFERENCES `artist_detail` (`type`),
  CONSTRAINT `artistType` FOREIGN KEY (`artistType`) REFERENCES `artist_detail` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of artist
-- ----------------------------
INSERT INTO `artist` VALUES ('C1', 'Henri', '123456789', '1');
INSERT INTO `artist` VALUES ('C2', 'Georges', '123456798', '2');
INSERT INTO `artist` VALUES ('C3', 'Antoine', '123459876', '3');
INSERT INTO `artist` VALUES ('C4', 'Jean', '123456456', '4');
SET FOREIGN_KEY_CHECKS=1;
