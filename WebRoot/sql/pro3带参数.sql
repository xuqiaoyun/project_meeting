/*
Navicat MySQL Data Transfer

Source Server         : hyn
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : pro3

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2017-06-16 07:36:55
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '会计部门', 'sad');
INSERT INTO `dept` VALUES ('2', '技术部门', 'sad');
INSERT INTO `dept` VALUES ('3', '市场部门', 'sdsa');
INSERT INTO `dept` VALUES ('4', '后勤部门', 'dsfsd');
INSERT INTO `dept` VALUES ('5', '秘书部门', 'sds');
INSERT INTO `dept` VALUES ('6', '策划部门', 'dsf');

-- ----------------------------
-- Table structure for `dinnertype`
-- ----------------------------
DROP TABLE IF EXISTS `dinnertype`;
CREATE TABLE `dinnertype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '用餐类型',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dinnertype
-- ----------------------------
INSERT INTO `dinnertype` VALUES ('1', '一荤一素', null);
INSERT INTO `dinnertype` VALUES ('2', '一荤两素', null);
INSERT INTO `dinnertype` VALUES ('3', '两荤两素', null);
INSERT INTO `dinnertype` VALUES ('4', '鸡腿套餐', null);

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
  `meetingRoom` int(11) NOT NULL COMMENT '会议地点',
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
  `applicationId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_meeting` (`type`),
  KEY `fk_holder` (`holder`),
  KEY `applicationId` (`applicationId`),
  KEY `meetingRoom` (`meetingRoom`),
  CONSTRAINT `meeting_ibfk_2` FOREIGN KEY (`meetingRoom`) REFERENCES `meetingroom` (`id`),
  CONSTRAINT `fk_holder` FOREIGN KEY (`holder`) REFERENCES `dept` (`id`),
  CONSTRAINT `fk_meeting` FOREIGN KEY (`type`) REFERENCES `meetingtype` (`id`),
  CONSTRAINT `meeting_ibfk_1` FOREIGN KEY (`applicationId`) REFERENCES `application` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of meeting
-- ----------------------------
INSERT INTO `meeting` VALUES ('1', '周日例会', '安排下间断十一', null, '1', '2', '2017-06-19 20:46:02', '2017-06-15 20:46:07', '1', '黄亚楠', '收到货，撒娇的骄傲，萨达，大大，萨达，硕大的', '9', '否', null, '否', '否', '黄雁南', null);
INSERT INTO `meeting` VALUES ('2', '下次会议', '你猜猜看', null, '2', '3', '2017-06-15 20:47:56', '2017-06-15 20:47:59', '3', '萨克京东卡', '萨达，撒打算，萨达', '3', '是', 'OK', '是', '否', '萨达', null);
INSERT INTO `meeting` VALUES ('3', '，没看撒娇', '精神抖擞', null, '1', '2', '2017-06-13 20:48:57', '2017-06-28 20:49:00', '2', '看到你发送', '上岛咖啡那是', '8', '是', '好好地', '是', '是', '卡萨丁', null);
INSERT INTO `meeting` VALUES ('4', 'asjd', 'sakds', 'ksdjf', '2', '4', '2017-06-15 20:49:20', '2017-06-15 20:49:24', '4', 'sdsfs ', 'dsadsad', '2', '否', null, '否', '否', 'sdfs', null);
INSERT INTO `meeting` VALUES ('5', 'sads', 'dgdf', 'fds', '1', '1', '2017-06-06 20:49:58', '2017-06-15 20:50:02', '2', 'dsfdds', 'dbgfgn', '5', '否', null, '否', '否', 'gmj', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of meetingroom
-- ----------------------------
INSERT INTO `meetingroom` VALUES ('1', '1-101', '中软', '20', '黄雁南', '1893421', '挺好的', '是', '否', '1', '1', 'sdn');
INSERT INTO `meetingroom` VALUES ('2', '1-102', '中软', '20', '黄雁南', '213123', 'good', '否', '是', '1', '1', '独守空房');
INSERT INTO `meetingroom` VALUES ('3', '1-103', '中软', '30', '黄雁南', '324329', 'nice', '是', '是', '2', '1', '萨达');
INSERT INTO `meetingroom` VALUES ('4', '2-101', '中软', '30', '黄雁南', '214210', 'prettygood', '是', '是', '1', '1', '奥斯卡打脸萨');

-- ----------------------------
-- Table structure for `meetingtype`
-- ----------------------------
DROP TABLE IF EXISTS `meetingtype`;
CREATE TABLE `meetingtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '会议类型名称',
  `remarks` varchar(255) NOT NULL COMMENT '说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of meetingtype
-- ----------------------------
INSERT INTO `meetingtype` VALUES ('1', '内部会议', '需填写会务表');
INSERT INTO `meetingtype` VALUES ('2', '外部会议', '无需填写会务表');

-- ----------------------------
-- Table structure for `power`
-- ----------------------------
DROP TABLE IF EXISTS `power`;
CREATE TABLE `power` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '权限名称',
  `remarks` varchar(255) NOT NULL COMMENT '权限说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power
-- ----------------------------
INSERT INTO `power` VALUES ('1', '普通用户', '仅可以查看会议安排');
INSERT INTO `power` VALUES ('2', '审核者', '审核议题');
INSERT INTO `power` VALUES ('3', '会议管理员', '会议管理');

-- ----------------------------
-- Table structure for `roomtype`
-- ----------------------------
DROP TABLE IF EXISTS `roomtype`;
CREATE TABLE `roomtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '房间类型',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roomtype
-- ----------------------------
INSERT INTO `roomtype` VALUES ('1', '单人间', '1');
INSERT INTO `roomtype` VALUES ('2', '双人间', '2');
INSERT INTO `roomtype` VALUES ('3', '总统套房', '5');

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
