/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : oauth2

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 23/07/2019 08:35:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for es_member
-- ----------------------------
DROP TABLE IF EXISTS `es_member`;
CREATE TABLE `es_member`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '会员id',
  `member_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `sex` tinyint(1) NULL DEFAULT NULL COMMENT '性别 1男0女',
  `mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `birthday` date NULL DEFAULT NULL COMMENT '出生日',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '注册日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of es_member
-- ----------------------------
INSERT INTO `es_member` VALUES (1, '哈哈', '$2a$10$qj7iEwJdQNGbLWQT3xvZjekLUlArXKkpGzMJSwbViFqNfLdjbc0Qq', '111', 1, '1111', '2018-12-13', '2018-12-13 14:27:38');
INSERT INTO `es_member` VALUES (2, 'android', '$2a$10$qj7iEwJdQNGbLWQT3xvZjekLUlArXKkpGzMJSwbViFqNfLdjbc0Qq', '111', 1, '1111', '2018-12-13', '2018-12-13 14:27:38');

-- ----------------------------
-- Table structure for es_member_role
-- ----------------------------
DROP TABLE IF EXISTS `es_member_role`;
CREATE TABLE `es_member_role`  (
  `id` int(11) NOT NULL COMMENT '主键',
  `member_id` int(11) NULL DEFAULT NULL COMMENT '会员id',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of es_member_role
-- ----------------------------
INSERT INTO `es_member_role` VALUES (1, 1, 1);

-- ----------------------------
-- Table structure for es_permission
-- ----------------------------
DROP TABLE IF EXISTS `es_permission`;
CREATE TABLE `es_permission`  (
  `id` int(11) NOT NULL COMMENT '权限id',
  `method` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '方法类型',
  `zuul_prefix` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网关前缀',
  `service_prefix` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务前缀',
  `uri` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求路径',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `updateTime` datetime(0) NULL DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of es_permission
-- ----------------------------
INSERT INTO `es_permission` VALUES (1, 'GET', '/api', '/auth', 'exit', '2018-12-14 09:45:35', '2018-12-14 09:45:37');
INSERT INTO `es_permission` VALUES (2, 'GET', '/api', '/auth', 'member', '2018-12-17 13:23:25', '2018-12-17 13:23:27');
INSERT INTO `es_permission` VALUES (3, 'GET', '/api', '/product', 'hello', '2018-12-17 13:23:25', '2018-12-17 13:23:25');
INSERT INTO `es_permission` VALUES (4, 'GET', '/api', '/product', 'current', '2018-12-17 13:23:25', '2018-12-17 13:23:25');
INSERT INTO `es_permission` VALUES (5, 'GET', '/api', '/product', 'query', '2018-12-17 13:23:25', '2018-12-17 13:23:25');

-- ----------------------------
-- Table structure for es_role
-- ----------------------------
DROP TABLE IF EXISTS `es_role`;
CREATE TABLE `es_role`  (
  `id` int(11) NOT NULL COMMENT '角色id',
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `valid` tinyint(1) NULL DEFAULT NULL COMMENT '是否有效 1是 0否',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `updateTime` datetime(0) NULL DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of es_role
-- ----------------------------
INSERT INTO `es_role` VALUES (1, 'ROLE_ADMIN', 1, '2018-12-14 09:46:01', '2018-12-14 09:46:03');
INSERT INTO `es_role` VALUES (2, 'ROLE_USER', 1, '2018-12-14 09:46:16', '2018-12-14 09:46:18');

-- ----------------------------
-- Table structure for es_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `es_role_permission`;
CREATE TABLE `es_role_permission`  (
  `id` int(11) NOT NULL COMMENT '主键',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色id',
  `permission_id` int(11) NULL DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of es_role_permission
-- ----------------------------
INSERT INTO `es_role_permission` VALUES (1, 1, 1);
INSERT INTO `es_role_permission` VALUES (2, 1, 2);
INSERT INTO `es_role_permission` VALUES (4, 1, 4);
INSERT INTO `es_role_permission` VALUES (5, 1, 5);

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details`  (
  `client_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `resource_ids` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `client_secret` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `scope` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `authorized_grant_types` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `authorities` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `access_token_validity` int(11) NULL DEFAULT NULL,
  `refresh_token_validity` int(11) NULL DEFAULT NULL,
  `additional_information` varchar(4096) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `autoapprove` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`client_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('android', NULL, '$2a$10$qj7iEwJdQNGbLWQT3xvZjekLUlArXKkpGzMJSwbViFqNfLdjbc0Qq', 'all', 'password,authorization_code,refresh_token', 'http://www.baidu.com', NULL, 3600, 7200, NULL, NULL);
INSERT INTO `oauth_client_details` VALUES ('android1', NULL, 'android1', 'all', 'password,authorization_code,refresh_token', 'http://www.baidu.com', NULL, 3600, 7200, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
