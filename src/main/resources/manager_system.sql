/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50067
Source Host           : localhost:3306
Source Database       : mingda_new

Target Server Type    : MYSQL
Target Server Version : 50067
File Encoding         : 65001

Date: 2015-10-15 15:51:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `news`
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` tinyint(11) NOT NULL auto_increment,
  `title` varchar(255) default NULL COMMENT '标题',
  `content` text COMMENT '内容',
  `author` varchar(10) default NULL COMMENT '作者',
  `createTime` date default NULL COMMENT '创建日期',
  `orderNo` int(11) default NULL COMMENT '排序',
  `newsType` int(11) default NULL COMMENT '分类',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('35', '2', '2', null, null, null, '2');

-- ----------------------------
-- Table structure for `resource`
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '资源id',
  `resource_url` varchar(255) NOT NULL COMMENT '资源名称(这里大部分是url规则)',
  `resource_name` varchar(255) default NULL COMMENT '权限名称',
  `code` varchar(255) default NULL COMMENT '资源代码',
  `status` varchar(255) NOT NULL COMMENT '状态1-正常 2-禁用',
  `parent_id` bigint(20) default NULL COMMENT '资源父ID,层级关系',
  `discription` varchar(255) default NULL COMMENT '描述',
  PRIMARY KEY  (`id`),
  KEY `parent_id_fk` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='资源表';

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('1', '/admin', 'admin操作', 'perms:admin', '1', '0', null);

-- ----------------------------
-- Table structure for `resource_role`
-- ----------------------------
DROP TABLE IF EXISTS `resource_role`;
CREATE TABLE `resource_role` (
  `resource_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`role_id`,`resource_id`),
  KEY `resource_id_fk` (`resource_id`),
  CONSTRAINT `resource_id_fk` FOREIGN KEY (`resource_id`) REFERENCES `resource` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源角色对应表';

-- ----------------------------
-- Records of resource_role
-- ----------------------------
INSERT INTO `resource_role` VALUES ('1', '1');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '角色id',
  `role_name` varchar(255) NOT NULL COMMENT '角色名称',
  `status` varchar(255) default NULL COMMENT '状态1-正常 2-禁用',
  `discription` varchar(255) default NULL COMMENT '角色功能描述',
  `code` varchar(255) default NULL COMMENT '角色标识',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin', '1', 'admin权限', 'role:admin');
INSERT INTO `role` VALUES ('2', 'manager', '1', 'manager权限', 'role:manager');
INSERT INTO `role` VALUES ('3', 'normal', '1', 'normal权限', 'role:normal');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '用户ID',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '用户密码 （加密后的）',
  `salt` varchar(255) NOT NULL COMMENT '用于密码加密的盐',
  `status` varchar(255) NOT NULL COMMENT '1-正常  2-锁定禁用',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'eb90a5da055846ee24ed96c44005abc749bc4bd6', '8admin', '1');
INSERT INTO `user` VALUES ('2', 'tmh', 'f15c02f4a9044d9e45dfbd0e2c78d7d1488c0a0b', '1tmh', '2');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`user_id`,`role_id`),
  KEY `role_id_fk` (`role_id`),
  CONSTRAINT `role_id_fk` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关系表';

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1');
INSERT INTO `user_role` VALUES ('2', '2');
