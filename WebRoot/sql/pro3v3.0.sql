/*
Navicat MySQL Data Transfer

Source Server         : my-mysql
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : pro3

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2017-06-16 10:02:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `application`
-- ----------------------------
DROP TABLE IF EXISTS `application`;
CREATE TABLE `application` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `micro` int(11) DEFAULT NULL COMMENT '麦克风',
  `projector` int(11) DEFAULT NULL COMMENT '投影仪',
  `carWord` varchar(255) DEFAULT NULL COMMENT '车证',
  `banner` varchar(255) DEFAULT NULL COMMENT '横幅',
  `tableSign` varchar(255) DEFAULT NULL COMMENT '桌签',
  `tea` int(11) DEFAULT NULL COMMENT '茶水',
  `signTime` datetime DEFAULT NULL COMMENT '签到时间',
  `signLocation` varchar(255) DEFAULT NULL COMMENT '签到地点',
  `dinnerType` int(11) DEFAULT NULL COMMENT '用餐类型',
  `dinneNum` int(11) DEFAULT NULL COMMENT '用餐人数',
  `dinnerRemarks` varchar(255) DEFAULT NULL COMMENT '其他要求（用餐）',
  `roomType` int(11) DEFAULT NULL COMMENT '房间类型',
  `roomNum` int(11) DEFAULT NULL COMMENT '房间数量',
  `roomRemarks` varchar(255) DEFAULT NULL COMMENT '其他要求（房间）',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `fk_dinner` (`dinnerType`),
  KEY `fk_ROOM` (`roomType`),
  CONSTRAINT `fk_dinner` FOREIGN KEY (`dinnerType`) REFERENCES `dinnertype` (`id`),
  CONSTRAINT `fk_ROOM` FOREIGN KEY (`roomType`) REFERENCES `roomtype` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of application
-- ----------------------------

-- ----------------------------
-- Table structure for `dept`
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '部门名称',
  `remarks` varchar(255) NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', 'wseda', 'sad');
INSERT INTO `dept` VALUES ('2', 'sda', 'sad');
INSERT INTO `dept` VALUES ('3', 'sadas', 'sdsa');
INSERT INTO `dept` VALUES ('4', 'dsfswa', 'dsfsd');
INSERT INTO `dept` VALUES ('5', 'sd', 'sds');
INSERT INTO `dept` VALUES ('6', 'dsf', 'dsf');
INSERT INTO `dept` VALUES ('7', '?', '?');
INSERT INTO `dept` VALUES ('8', '?', '?');
INSERT INTO `dept` VALUES ('9', '?', '?');
INSERT INTO `dept` VALUES ('10', '?', '?');

-- ----------------------------
-- Table structure for `dinnertype`
-- ----------------------------
DROP TABLE IF EXISTS `dinnertype`;
CREATE TABLE `dinnertype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '用餐类型',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dinnertype
-- ----------------------------

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '职员',
  `password` varchar(32) NOT NULL COMMENT '用户密码',
  `tel` varchar(255) NOT NULL COMMENT '联系电话',
  `email` varchar(255) NOT NULL COMMENT '邮箱',
  `dept` int(11) DEFAULT NULL COMMENT '所属部门',
  `powerid` int(11) NOT NULL COMMENT '权限外键',
  PRIMARY KEY (`id`),
  KEY `fk_dept` (`dept`),
  KEY `fk_power` (`powerid`),
  CONSTRAINT `fk_dept` FOREIGN KEY (`dept`) REFERENCES `dept` (`id`),
  CONSTRAINT `fk_power` FOREIGN KEY (`powerid`) REFERENCES `power` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------

-- ----------------------------
-- Table structure for `meeting`
-- ----------------------------
DROP TABLE IF EXISTS `meeting`;
CREATE TABLE `meeting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '会议名称',
  `introduce` varchar(255) NOT NULL COMMENT '会议简述',
  `content` varchar(255) DEFAULT NULL COMMENT '会议内容',
  `type` int(11) NOT NULL COMMENT '会议类型（外键）',
  `meetingRoom` varchar(255) NOT NULL COMMENT '会议地点',
  `startTime` datetime NOT NULL COMMENT '开始时间',
  `endTime` datetime NOT NULL COMMENT '结束时间',
  `holder` int(11) NOT NULL COMMENT '主办部门(外键)',
  `recorder` varchar(255) NOT NULL COMMENT '会议记录者',
  `joiner` varchar(255) NOT NULL COMMENT '参会人员',
  `number` int(11) NOT NULL COMMENT '参会人数',
  `check` varchar(255) NOT NULL DEFAULT '否' COMMENT '是否通过审核',
  `checkmess` varchar(255) DEFAULT NULL COMMENT '审核意见',
  `lerader` varchar(255) NOT NULL DEFAULT '否' COMMENT '领导是否参加',
  `medias` varchar(11) NOT NULL DEFAULT '否' COMMENT '多媒体设备',
  `opener` varchar(255) NOT NULL COMMENT '申请人',
  PRIMARY KEY (`id`),
  KEY `fk_meeting` (`type`),
  KEY `fk_holder` (`holder`),
  CONSTRAINT `fk_holder` FOREIGN KEY (`holder`) REFERENCES `dept` (`id`),
  CONSTRAINT `fk_meeting` FOREIGN KEY (`type`) REFERENCES `meetingtype` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of meeting
-- ----------------------------

-- ----------------------------
-- Table structure for `meetingroom`
-- ----------------------------
DROP TABLE IF EXISTS `meetingroom`;
CREATE TABLE `meetingroom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '会议室名称',
  `location` varchar(255) NOT NULL COMMENT '地点',
  `maxNum` int(11) NOT NULL COMMENT '最大可容纳人数',
  `manager` varchar(255) NOT NULL COMMENT '联系人',
  `tel` varchar(255) NOT NULL COMMENT '联系电话',
  `introduce` varchar(255) NOT NULL COMMENT '会议室介绍',
  `blackboard` varchar(11) DEFAULT '否' COMMENT '黑板设备',
  `media` varchar(11) DEFAULT '否' COMMENT '音响设备',
  `nowState` int(11) NOT NULL COMMENT '目前状态',
  `usefulState` int(11) NOT NULL COMMENT '可用状态',
  `remarks` varchar(255) NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `fk_nowstate` (`nowState`),
  KEY `fk_usefulstate` (`usefulState`),
  CONSTRAINT `fk_nowstate` FOREIGN KEY (`nowState`) REFERENCES `state` (`id`),
  CONSTRAINT `fk_usefulstate` FOREIGN KEY (`usefulState`) REFERENCES `state` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of meetingroom
-- ----------------------------

-- ----------------------------
-- Table structure for `meetingtype`
-- ----------------------------
DROP TABLE IF EXISTS `meetingtype`;
CREATE TABLE `meetingtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '会议类型名称',
  `remarks` varchar(255) NOT NULL COMMENT '说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of meetingtype
-- ----------------------------

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '信息id',
  `content` varchar(255) DEFAULT NULL COMMENT '信息内容',
  `meetingId` int(11) DEFAULT '0' COMMENT '会议id',
  `collectionId` int(11) DEFAULT NULL COMMENT '收信人id',
  `sendId` int(11) DEFAULT NULL COMMENT '发信人id',
  `status` int(11) DEFAULT NULL COMMENT '信息状态，1为已读，0为未读',
  PRIMARY KEY (`id`),
  KEY `fk_meetingId` (`meetingId`),
  KEY `fk_collection` (`collectionId`),
  KEY `fk_send` (`sendId`),
  CONSTRAINT `fk_send` FOREIGN KEY (`sendId`) REFERENCES `employee` (`id`),
  CONSTRAINT `fk_collection` FOREIGN KEY (`collectionId`) REFERENCES `employee` (`id`),
  CONSTRAINT `fk_meetingId` FOREIGN KEY (`meetingId`) REFERENCES `meeting` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------

-- ----------------------------
-- Table structure for `power`
-- ----------------------------
DROP TABLE IF EXISTS `power`;
CREATE TABLE `power` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '权限名称',
  `remarks` varchar(255) NOT NULL COMMENT '权限说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power
-- ----------------------------

-- ----------------------------
-- Table structure for `roomtype`
-- ----------------------------
DROP TABLE IF EXISTS `roomtype`;
CREATE TABLE `roomtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '房间类型',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roomtype
-- ----------------------------

-- ----------------------------
-- Table structure for `state`
-- ----------------------------
DROP TABLE IF EXISTS `state`;
CREATE TABLE `state` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `state` varchar(255) NOT NULL COMMENT '状态名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of state
-- ----------------------------
INSERT INTO `state` VALUES ('1', '不可用');
INSERT INTO `state` VALUES ('2', '可用');
INSERT INTO `state` VALUES ('3', '正在使用');
INSERT INTO `state` VALUES ('4', '未使用');
