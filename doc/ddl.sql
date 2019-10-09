CREATE TABLE `learningachievement` (
  `achievementId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `completionDate` date DEFAULT '1900-01-01',
  `achievement` varchar(100) NOT NULL,
  `userId` bigint(20) NOT NULL,
  PRIMARY KEY (`achievementId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8
CREATE TABLE `lengthofstudy` (
  `infoId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `studyDate` date DEFAULT '1900-01-01',
  `studyTime` float(3,1) DEFAULT '0.0',
  `userId` bigint(20) NOT NULL,
  PRIMARY KEY (`infoId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8
CREATE TABLE `user` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `userName` varchar(100) NOT NULL COMMENT '登录名',
  `password` varchar(100) NOT NULL COMMENT '登录密码',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8