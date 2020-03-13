/*
MySQL Data Transfer
Source Host: localhost
Source Database: bbs_system
Target Host: localhost
Target Database: bbs_system
Date: 2020/3/10 10:57:20
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for bbs_category
-- ----------------------------
CREATE TABLE `bbs_category` (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(32) NOT NULL,
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bbs_follow
-- ----------------------------
CREATE TABLE `bbs_follow` (
  `userId` varchar(32) NOT NULL,
  `beUserId` varchar(32) NOT NULL,
  `followDate` datetime DEFAULT NULL,
  PRIMARY KEY (`userId`,`beUserId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bbs_invitation
-- ----------------------------
CREATE TABLE `bbs_invitation` (
  `invitationId` varchar(128) NOT NULL,
  `invitationMessage` varchar(2048) NOT NULL,
  `userId` varchar(32) NOT NULL,
  `plateId` int(11) DEFAULT NULL,
  `categoryId` int(11) DEFAULT NULL,
  `isPass` int(11) DEFAULT '0',
  `isEnable` int(11) DEFAULT '0',
  `isCream` int(11) DEFAULT '0',
  `invitationCreate` datetime DEFAULT NULL,
  `invitationModify` datetime DEFAULT NULL,
  PRIMARY KEY (`invitationId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bbs_invitation_ans
-- ----------------------------
CREATE TABLE `bbs_invitation_ans` (
  `ansId` varchar(128) NOT NULL,
  `ansMessage` varchar(512) NOT NULL,
  `invitationId` varchar(128) NOT NULL,
  `userId` varchar(32) DEFAULT NULL,
  `ansDate` datetime DEFAULT NULL,
  PRIMARY KEY (`ansId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bbs_level
-- ----------------------------
CREATE TABLE `bbs_level` (
  `levelId` int(11) NOT NULL AUTO_INCREMENT,
  `levelMessage` varchar(8) NOT NULL,
  PRIMARY KEY (`levelId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bbs_plate
-- ----------------------------
CREATE TABLE `bbs_plate` (
  `plateId` int(11) NOT NULL AUTO_INCREMENT,
  `plateTitle` varchar(32) NOT NULL,
  `plateMessage` varchar(128) DEFAULT NULL,
  `isEnable` int(11) DEFAULT '0',
  PRIMARY KEY (`plateId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bbs_store
-- ----------------------------
CREATE TABLE `bbs_store` (
  `userId` varchar(32) NOT NULL,
  `invitationId` varchar(128) NOT NULL,
  `storeDate` datetime DEFAULT NULL,
  PRIMARY KEY (`userId`,`invitationId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bbs_system_ans
-- ----------------------------
CREATE TABLE `bbs_system_ans` (
  `id` varchar(128) NOT NULL,
  `systemId` varchar(32) NOT NULL,
  `userId` varchar(32) DEFAULT NULL,
  `message` varchar(255) NOT NULL,
  `isRead` int(11) DEFAULT '0',
  `createDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bbs_user
-- ----------------------------
CREATE TABLE `bbs_user` (
  `userId` varchar(32) NOT NULL,
  `userPsw` varchar(32) NOT NULL,
  `userAlice` varchar(64) NOT NULL,
  `userEmail` varchar(64) NOT NULL,
  `userSex` varchar(1) DEFAULT '男',
  `userPhoto` varchar(128) DEFAULT 'xxx.jpg',
  `userScore` double DEFAULT '0',
  `userLevel` int(11) DEFAULT '1',
  `levelDown` date DEFAULT NULL,
  `userLock` date DEFAULT NULL,
  `userCreateDate` date DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `bbs_level` VALUES ('1', '初级会员');
INSERT INTO `bbs_level` VALUES ('2', '中级会员');
INSERT INTO `bbs_level` VALUES ('3', '高级会员');
INSERT INTO `bbs_level` VALUES ('4', '系统管理员');
INSERT INTO `bbs_user` VALUES ('aaa', '202cb962ac59075b964b07152d234b70', '小六', '221@qq.com', '男', 'xxx.jpg', '0', '1', null, null, '2020-03-10');
INSERT INTO `bbs_user` VALUES ('admin', '21232f297a57a5a743894a0e4a801fc3', '系统管理员', 'xxx@qq.com', '男', 'xxx.jpg', '0', '4', null, null, null);
INSERT INTO `bbs_user` VALUES ('zhangSan', '202cb962ac59075b964b07152d234b70', '小三子', '111@qq.com', '女', 'xxx.jpg', '0', '1', null, null, '2020-03-10');
