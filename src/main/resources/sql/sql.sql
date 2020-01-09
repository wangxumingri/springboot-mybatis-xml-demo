# 创建医院表
CREATE TABLE `bl_hospital` (
  `oid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '医院名称',
  `status` varchar(8) DEFAULT NULL COMMENT '状态',
  `code` varchar(20) DEFAULT NULL COMMENT '编码',
  `createdOn` datetime DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8

# 创建用户表
CREATE TABLE `bl_user` (
  `oid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `cardNumber` varchar(50) DEFAULT NULL COMMENT '证件号',
  `birthDay` date DEFAULT NULL COMMENT '生日',
  `gender` int(1) DEFAULT NULL COMMENT '性别，1男0女',
  `mobile` varchar(12) DEFAULT NULL COMMENT '手机号',
  `openId` varchar(50) DEFAULT NULL COMMENT '微信openId',
  `createdOn` datetime DEFAULT NULL COMMENT '创建时间',
  `updatedOn` datetime DEFAULT NULL COMMENT '更新时间',
  `age` int(4) DEFAULT NULL COMMENT '年龄',
  `hospitalCode` varchar(20) DEFAULT NULL COMMENT '医院code',
  PRIMARY KEY (`oid`),
  KEY `index_hospitalCode` (`hospitalCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

# 创建流程表
CREATE TABLE `bl_user_workflow` (
  `oid` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL COMMENT '人员Id',
  `status` varchar(10) DEFAULT NULL COMMENT '状态',
  `createdOn` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '流程开启时间',
  `closedOn` datetime DEFAULT NULL COMMENT '流程关闭时间',
  `hospitalCode` varchar(20) DEFAULT NULL COMMENT '医院code',
  `deviceOuterNumber` varchar(64) DEFAULT NULL COMMENT '激活流程用的手机号',
  `type` varchar(16) DEFAULT NULL COMMENT '流程类型',
  `parentId` bigint(20) DEFAULT NULL,
  `stateFlag` tinyint(1) DEFAULT NULL,
  `activateSource` varchar(32) DEFAULT NULL COMMENT '开启来源',
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


