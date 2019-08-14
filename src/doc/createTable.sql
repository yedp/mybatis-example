CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(30) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(64) NOT NULL DEFAULT '' COMMENT '密码',
  `salt` varchar(6) NOT NULL DEFAULT '' COMMENT '密码盐',
  `nickname` varchar(30) NOT NULL DEFAULT '' COMMENT '用户昵称',
  `real_name` varchar(30) NOT NULL DEFAULT '' COMMENT '真实姓名',
  `phone` varchar(20) NOT NULL DEFAULT '' COMMENT '手机号',
  `email` varchar(50) NOT NULL DEFAULT '' COMMENT '邮箱',
  `add_time` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '添加时间',
  `last_login_time` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '添加时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除:0-不删除；1-删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  KEY `phone` (`phone`),
  KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

