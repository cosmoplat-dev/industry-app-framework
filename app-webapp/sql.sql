CREATE TABLE `register_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `machine_number` varchar(255) DEFAULT NULL COMMENT '设备号',
  `machine_ip` varchar(255) DEFAULT NULL COMMENT '设备ip',
  `machine_mark` varchar(255) DEFAULT NULL COMMENT '设备标记',
  `reg_time` datetime DEFAULT NULL COMMENT '注册时间',
  `author` varchar(255) DEFAULT NULL COMMENT '操作者',
  `status` int(2) DEFAULT NULL COMMENT '设备状态（1正常，0已注销，2禁用）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `user_info` (
  `id` bigint(20) NOT NULL,
  `user_id` varchar(255) DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `user_pass` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `user_phone` varchar(255) DEFAULT NULL COMMENT '用户手机号',
  `user_email` varchar(255) DEFAULT NULL COMMENT '用户邮箱',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `is_del` varchar(255) DEFAULT NULL COMMENT '是否删除',
  `status` varchar(255) DEFAULT NULL COMMENT '用户状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

