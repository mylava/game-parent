/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost
 Source Database       : game_platform

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : utf-8

 Date: 05/12/2019 22:26:31 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `ox_player`
-- ----------------------------
DROP TABLE IF EXISTS `ox_player`;
CREATE TABLE `ox_player` (
  `id` varchar(32) NOT NULL COMMENT '主键ID',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `email` varchar(255) DEFAULT NULL COMMENT '邮件',
  `gender` varchar(255) DEFAULT NULL COMMENT '性别',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `user_type` varchar(255) DEFAULT NULL COMMENT '用户类型',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号',
  `headimg` varchar(512) DEFAULT NULL COMMENT '头像',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `balance` bigint(32) DEFAULT NULL COMMENT '账户余额',
  `sign` varchar(100) DEFAULT NULL COMMENT '个性签名',
  `invite_Code` varchar(16) DEFAULT NULL COMMENT '邀请码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  `memo` varchar(255) DEFAULT NULL COMMENT '备注',
  `deactivetime` datetime DEFAULT NULL COMMENT '离线时间',
  `openid` varchar(100) DEFAULT NULL COMMENT '第三方ID',
  `disabled` tinyint(4) DEFAULT NULL COMMENT '账号被禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
