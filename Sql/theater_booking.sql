/*
Navicat MySQL Data Transfer

Source Server         : 172.32.20.71_3306
Source Server Version : 50717
Source Host           : 172.32.20.71:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-01-23 19:47:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for theater_booking
-- ----------------------------
DROP TABLE IF EXISTS `theater_booking`;
CREATE TABLE `theater_booking` (
  `booking_id` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `event_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`booking_id`),
  KEY `FKED06062B8F29E1E1` (`event_id`),
  CONSTRAINT `FKED06062B8F29E1E1` FOREIGN KEY (`event_id`) REFERENCES `artist_events` (`eventId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of theater_booking
-- ----------------------------
SET FOREIGN_KEY_CHECKS=1;
