CREATE TABLE `bl_hospital` (
  `oid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '医院名称',
  `status` varchar(8) DEFAULT NULL COMMENT '状态',
  `code` varchar(20) DEFAULT NULL COMMENT '编码',
  `createdOn` datetime DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8