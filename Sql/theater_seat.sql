/*
Navicat MySQL Data Transfer

Source Server         : 172.32.20.71_3306
Source Server Version : 50717
Source Host           : 172.32.20.71:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-01-23 19:47:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for theater_seat
-- ----------------------------
DROP TABLE IF EXISTS `theater_seat`;
CREATE TABLE `theater_seat` (
  `seatNumber` varchar(255) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`seatNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of theater_seat
-- ----------------------------
INSERT INTO `theater_seat` VALUES ('A1', 'Booked');
INSERT INTO `theater_seat` VALUES ('A10', 'Available');
INSERT INTO `theater_seat` VALUES ('A11', 'Available');
INSERT INTO `theater_seat` VALUES ('A12', 'Available');
INSERT INTO `theater_seat` VALUES ('A13', 'Available');
INSERT INTO `theater_seat` VALUES ('A14', 'Available');
INSERT INTO `theater_seat` VALUES ('A15', 'Available');
INSERT INTO `theater_seat` VALUES ('A2', 'Booked');
INSERT INTO `theater_seat` VALUES ('A3', 'Booked');
INSERT INTO `theater_seat` VALUES ('A4', 'Booked');
INSERT INTO `theater_seat` VALUES ('A5', 'Booked');
INSERT INTO `theater_seat` VALUES ('A6', 'Available');
INSERT INTO `theater_seat` VALUES ('A7', 'Available');
INSERT INTO `theater_seat` VALUES ('A8', 'Available');
INSERT INTO `theater_seat` VALUES ('A9', 'Available');
INSERT INTO `theater_seat` VALUES ('B1', 'Available');
INSERT INTO `theater_seat` VALUES ('B10', 'Available');
INSERT INTO `theater_seat` VALUES ('B11', 'Available');
INSERT INTO `theater_seat` VALUES ('B12', 'Available');
INSERT INTO `theater_seat` VALUES ('B13', 'Available');
INSERT INTO `theater_seat` VALUES ('B14', 'Available');
INSERT INTO `theater_seat` VALUES ('B15', 'Booked');
INSERT INTO `theater_seat` VALUES ('B2', 'Available');
INSERT INTO `theater_seat` VALUES ('B3', 'Available');
INSERT INTO `theater_seat` VALUES ('B4', 'Available');
INSERT INTO `theater_seat` VALUES ('B5', 'Available');
INSERT INTO `theater_seat` VALUES ('B6', 'Available');
INSERT INTO `theater_seat` VALUES ('B7', 'Available');
INSERT INTO `theater_seat` VALUES ('B8', 'Available');
INSERT INTO `theater_seat` VALUES ('B9', 'Available');
SET FOREIGN_KEY_CHECKS=1;
