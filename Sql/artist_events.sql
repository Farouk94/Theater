/*
Navicat MySQL Data Transfer

Source Server         : 172.32.20.71_3306
Source Server Version : 50717
Source Host           : 172.32.20.71:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-01-23 19:46:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for artist_events
-- ----------------------------
DROP TABLE IF EXISTS `artist_events`;
CREATE TABLE `artist_events` (
  `artistId` int(11) NOT NULL,
  `eventname` varchar(255) NOT NULL,
  `eventId` int(11) NOT NULL,
  PRIMARY KEY (`eventId`),
  KEY `FK77BF91117A905FBB` (`artistId`),
  CONSTRAINT `FK77BF91117A905FBB` FOREIGN KEY (`artistId`) REFERENCES `artist` (`artistId`),
  CONSTRAINT `artistId` FOREIGN KEY (`artistId`) REFERENCES `artist` (`artistId`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of artist_events
-- ----------------------------
INSERT INTO `artist_events` VALUES ('1', 'Artenium', '1');
INSERT INTO `artist_events` VALUES ('2', 'MusiMagic', '2');
INSERT INTO `artist_events` VALUES ('3', 'ArtGallery', '3');
INSERT INTO `artist_events` VALUES ('4', 'MagicFlower', '4');
SET FOREIGN_KEY_CHECKS=1;
