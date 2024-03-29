/*
 Navicat Premium Data Transfer

 Source Server         : 清风
 Source Server Type    : MySQL
 Source Server Version : 80034
 Source Host           : localhost:3306
 Source Schema         : qf_ini

 Target Server Type    : MySQL
 Target Server Version : 80034
 File Encoding         : 65001

 Date: 02/02/2024 21:11:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '字典类型编码',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '字典项名称',
  `value` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '字典项值',
  `sort` int NULL DEFAULT 0 COMMENT '排序',
  `status` tinyint NULL DEFAULT 0 COMMENT '状态(1:正常;0:禁用)',
  `defaulted` tinyint NULL DEFAULT 0 COMMENT '是否默认(1:是;0:否)',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '备注',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'ADMIN' COMMENT '创建者',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'ADMIN' COMMENT '更新者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '字典数据表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES (5, 'gender', '男', '1', 0, 1, 0, '', '2024-01-18 00:41:29', '2024-01-18 00:41:29', 'ADMIN', 'ADMIN');
INSERT INTO `sys_dict` VALUES (6, 'gender', '女', '2', 0, 1, 0, '', '2024-01-18 00:41:35', '2024-01-18 00:41:35', 'ADMIN', 'ADMIN');
INSERT INTO `sys_dict` VALUES (10, 'status', '禁用', '0', 0, 1, 0, NULL, '2024-01-26 17:01:44', '2024-01-26 17:01:44', 'ADMIN', 'ADMIN');
INSERT INTO `sys_dict` VALUES (11, 'status', '开启', '1', 0, 1, 0, NULL, '2024-01-26 17:09:30', '2024-01-26 17:09:30', 'ADMIN', 'ADMIN');

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键 ',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '类型名称',
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '类型编码',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '状态(0:正常;1:禁用)',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'ADMIN' COMMENT '创建者',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'ADMIN' COMMENT '更新者',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `type_code`(`code` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '字典类型表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES (1, '性别', 'gender', 1, '性别', '2024-01-05 21:49:18', '2024-01-05 21:49:26', 'ADMIN', 'ADMIN');
INSERT INTO `sys_dict_type` VALUES (9, '状态', 'status', 1, '11', '2024-01-26 17:26:47', '2024-01-26 17:26:47', 'ADMIN', 'ADMIN');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `parent_id` bigint NOT NULL COMMENT '父菜单ID',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '菜单名称',
  `path` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '路由路径(浏览器地址栏路径)',
  `component` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '组件路径(vue页面完整路径，省略.vue后缀)',
  `visible` tinyint(1) NOT NULL DEFAULT 1 COMMENT '显示状态(1-显示;0-隐藏)',
  `icon` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '菜单图标',
  `sort` int NULL DEFAULT 0 COMMENT '排序',
  `redirect` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '跳转路径',
  `type` tinyint(1) NOT NULL COMMENT '菜单类型(1:目录 2:菜单 3:外链)',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'ADMIN' COMMENT '创建者',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'ADMIN' COMMENT '更新者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000006 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜单管理' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '系统管理', '/system', 'Layout', 1, 'system', 1, '/system/user', 1, '系统管理目录', '2023-12-12 20:49:43', '2023-12-12 20:49:43', 'ADMIN', 'ADMIN');
INSERT INTO `sys_menu` VALUES (2, 0, '系统监控', '/monitor', 'Layout', 1, 'monitor', 2, '/monitor/online', 1, '系统监控目录', '2023-12-12 20:49:43', '2023-12-12 20:49:43', 'ADMIN', 'ADMIN');
INSERT INTO `sys_menu` VALUES (3, 0, '文章管理', '/article', 'Layout', 1, 'article', 3, '/article/list', 1, '文章管理目录', '2023-12-12 20:49:43', '2023-12-12 20:49:43', 'ADMIN', 'ADMIN');
INSERT INTO `sys_menu` VALUES (4, 0, '日志管理', '/notice', 'Layout', 1, 'log', 4, '/log/operlog', 1, '日志管理目录', '2023-12-12 20:49:43', '2023-12-12 20:49:43', 'ADMIN', 'ADMIN');
INSERT INTO `sys_menu` VALUES (5, 0, '测试图标', '/test', 'Layout', 1, 'test', 5, NULL, 1, '测试', '2024-01-10 11:46:44', '2024-01-10 11:46:44', 'ADMIN', 'ADMIN');
INSERT INTO `sys_menu` VALUES (6, 0, '测试11111', '', NULL, 1, '', 0, NULL, 2, NULL, '2024-01-23 09:19:08', '2024-01-23 09:19:08', 'ADMIN', 'ADMIN');
INSERT INTO `sys_menu` VALUES (101, 1, '用户管理', '/system/user', 'system/user/index', 1, 'user', 1, NULL, 2, '用户管理菜单', '2023-12-12 20:49:43', '2023-12-12 20:49:43', 'ADMIN', 'ADMIN');
INSERT INTO `sys_menu` VALUES (102, 1, '角色管理', '/system/role', 'system/role/index', 1, 'role', 2, NULL, 2, '角色管理菜单', '2023-12-12 20:49:43', '2023-12-12 20:49:43', 'ADMIN', 'ADMIN');
INSERT INTO `sys_menu` VALUES (103, 1, '菜单管理', '/system/menu', 'system/menu/index', 1, 'menu', 3, NULL, 2, '菜单管理菜单', '2023-12-12 20:49:43', '2023-12-12 20:49:43', 'ADMIN', 'ADMIN');
INSERT INTO `sys_menu` VALUES (104, 1, '字典管理', '/system/dict', 'system/dict/index', 1, 'dict', 4, NULL, 2, '字典管理菜单', '2023-12-12 20:49:43', '2023-12-12 20:49:43', 'ADMIN', 'ADMIN');
INSERT INTO `sys_menu` VALUES (105, 1, '通知公告', '/system/notice', 'system/notice/index', 1, 'message', 5, NULL, 2, '通知公告菜单', '2023-12-12 20:49:43', '2023-12-12 20:49:43', 'ADMIN', 'ADMIN');
INSERT INTO `sys_menu` VALUES (106, 2, '在线用户', '/monitor/online', 'monitor/online/index', 1, 'online', 1, NULL, 2, '在线用户菜单', '2023-12-12 20:49:43', '2023-12-12 20:49:43', 'ADMIN', 'ADMIN');
INSERT INTO `sys_menu` VALUES (107, 2, '数据监控', '/monitor/druid', 'monitor/druid/index', 1, 'druid', 2, NULL, 2, '数据监控菜单', '2023-12-12 20:49:43', '2023-12-12 20:49:43', 'ADMIN', 'ADMIN');
INSERT INTO `sys_menu` VALUES (108, 2, '服务监控', '/monitor/server', 'monitor/server/index', 1, 'server', 3, NULL, 2, '服务监控菜单', '2023-12-12 20:49:43', '2023-12-12 20:49:43', 'ADMIN', 'ADMIN');
INSERT INTO `sys_menu` VALUES (109, 2, '缓存监控', '/monitor/cache', 'monitor/cache/server/index', 1, 'redis', 4, NULL, 2, '缓存监控菜单', '2023-12-12 20:49:43', '2023-12-12 20:49:43', 'ADMIN', 'ADMIN');
INSERT INTO `sys_menu` VALUES (110, 2, '缓存列表', '/monitor/cacheList', 'monitor/cache/list/index', 1, 'redis-list', 5, NULL, 2, '缓存列表菜单', '2023-12-12 20:49:43', '2023-12-12 20:49:43', 'ADMIN', 'ADMIN');
INSERT INTO `sys_menu` VALUES (111, 3, '文章列表', '/article/articleList', 'article/list/index', 1, 'article-list', 1, NULL, 2, '文章列表菜单', '2023-12-12 20:49:43', '2023-12-12 20:49:43', 'ADMIN', 'ADMIN');
INSERT INTO `sys_menu` VALUES (112, 3, '发布文章', '/article/addArticle', 'article/index', 1, 'add-article', 2, NULL, 2, '发布文章菜单', '2023-12-12 20:49:43', '2023-12-12 20:49:43', 'ADMIN', 'ADMIN');
INSERT INTO `sys_menu` VALUES (113, 3, '标签管理', '/article/tag', 'article/tag/index', 1, 'tag', 3, NULL, 2, '标签管理菜单', '2023-12-12 20:49:43', '2023-12-12 20:49:43', 'ADMIN', 'ADMIN');
INSERT INTO `sys_menu` VALUES (114, 3, '分类管理', '/article/category', 'article/category/index', 1, 'category', 4, NULL, 2, '分类管理菜单', '2023-12-12 20:49:43', '2023-12-12 20:49:43', 'ADMIN', 'ADMIN');
INSERT INTO `sys_menu` VALUES (115, 4, '操作日志', '/monitor/operlog', 'monitor/log/operlog', 1, 'form', 1, NULL, 2, '操作日志菜单', '2023-12-12 20:49:43', '2023-12-12 20:49:43', 'ADMIN', 'ADMIN');
INSERT INTO `sys_menu` VALUES (116, 4, '登录日志', '/monitor/logininfor', 'monitor/log/logininfor', 1, 'logininfor', 2, NULL, 2, '登录日志菜单', '2023-12-12 20:49:43', '2023-12-12 20:49:43', 'ADMIN', 'ADMIN');
INSERT INTO `sys_menu` VALUES (117, 5, '测试', '/test/2', 'test/2/index', 1, '', 1, NULL, 2, NULL, '2024-01-10 11:48:58', '2024-01-10 11:48:58', 'ADMIN', 'ADMIN');
INSERT INTO `sys_menu` VALUES (118, 5, '测试1', '/test/3', 'test/3/index', 1, '', 2, NULL, 2, NULL, '2024-01-22 15:19:24', '2024-01-22 15:19:24', 'ADMIN', 'ADMIN');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限名称',
  `menu_id` int NULL DEFAULT NULL COMMENT '菜单模块ID',
  `url_perm` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'URL权限标识',
  `btn_perm` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '按钮权限标识',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'ADMIN' COMMENT '创建者',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'ADMIN' COMMENT '更新者',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id`(`id` ASC, `name` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1013 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '权限表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1001, '查看用户', 101, 'GET:/api/v1/users/*', 'sys:user:list', '2023-12-12 20:39:35', '2023-12-12 20:39:35', 'ADMIN', 'ADMIN');
INSERT INTO `sys_permission` VALUES (1002, '编辑用户', 101, 'PUT:/api/v1/users/*', 'sys:user:edit', '2023-12-12 20:39:35', '2023-12-12 20:39:35', 'ADMIN', 'ADMIN');
INSERT INTO `sys_permission` VALUES (1003, '新增用户', 101, 'POST:/api/v1/users/*', 'sys:user:add', '2023-12-12 20:39:35', '2023-12-12 20:39:35', 'ADMIN', 'ADMIN');
INSERT INTO `sys_permission` VALUES (1004, '删除用户', 101, 'DELETE:/api/v1/users/*', 'sys:user:delete', '2023-12-12 20:39:35', '2023-12-12 20:39:35', 'ADMIN', 'ADMIN');
INSERT INTO `sys_permission` VALUES (1005, '查看角色', 102, 'GET:/api/v1/roles/*', 'sys:role:list', '2023-12-12 20:39:35', '2023-12-12 20:39:35', 'ADMIN', 'ADMIN');
INSERT INTO `sys_permission` VALUES (1006, '编辑角色', 102, 'PUT:/api/v1/roles/*', 'sys:role:edit', '2023-12-12 20:39:35', '2023-12-12 20:39:35', 'ADMIN', 'ADMIN');
INSERT INTO `sys_permission` VALUES (1007, '新增角色', 102, 'POST:/api/v1/roles/*', 'sys:role:add', '2023-12-12 20:39:35', '2023-12-12 20:39:35', 'ADMIN', 'ADMIN');
INSERT INTO `sys_permission` VALUES (1008, '删除角色', 102, 'DELETE:/api/v1/roles/*', 'sys:role:delete', '2023-12-12 20:39:35', '2023-12-12 20:39:35', 'ADMIN', 'ADMIN');
INSERT INTO `sys_permission` VALUES (1009, '查看菜单', 103, 'GET:/api/v1/menus/*', 'sys:menu:list', '2023-12-12 20:39:35', '2023-12-12 20:39:35', 'ADMIN', 'ADMIN');
INSERT INTO `sys_permission` VALUES (1010, '编辑菜单', 103, 'PUT:/api/v1/menus/*', 'sys:menu:edit', '2023-12-12 20:39:35', '2023-12-12 20:39:35', 'ADMIN', 'ADMIN');
INSERT INTO `sys_permission` VALUES (1011, '新增菜单', 103, 'POST:/api/v1/menus/*', 'sys:menu:add', '2023-12-12 20:39:35', '2023-12-12 20:39:35', 'ADMIN', 'ADMIN');
INSERT INTO `sys_permission` VALUES (1012, '删除菜单', 103, 'DELETE:/api/v1/menus/*', 'sys:menu:delete', '2023-12-12 20:39:35', '2023-12-12 20:39:35', 'ADMIN', 'ADMIN');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '角色名称',
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色编码',
  `sort` int NULL DEFAULT NULL COMMENT '显示顺序',
  `status` tinyint(1) NULL DEFAULT 1 COMMENT '角色状态(0-正常；1-停用)',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除标识(0-未删除；1-已删除)',
  `remark` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'ADMIN' COMMENT '创建者',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'ADMIN' COMMENT '更新者',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', 'ROOT', 1, 0, 0, '我是超级管理员，拥有所有权限1', '2023-12-12 17:32:41', '2023-12-12 17:32:41', 'ADMIN', 'ADMIN');
INSERT INTO `sys_role` VALUES (2, '系统管理员', 'ADMIN', 2, 1, 0, '系统管理员', '2023-12-12 17:32:41', '2023-12-12 17:32:41', 'ADMIN', 'ADMIN');
INSERT INTO `sys_role` VALUES (3, '测试管理员', 'TEST', 3, 1, 0, '测试管理员', '2023-12-12 17:32:41', '2023-12-12 17:32:41', 'ADMIN', 'ADMIN');
INSERT INTO `sys_role` VALUES (4, '访问游客', 'GUEST', 4, 0, 0, '访问游客', '2023-12-12 17:32:41', '2023-12-12 17:32:41', 'ADMIN', 'ADMIN');
INSERT INTO `sys_role` VALUES (5, '游客1', 'TTT', NULL, 0, 0, '不知道', '2024-01-17 00:30:41', '2024-01-17 00:30:41', 'ADMIN', 'ADMIN');
INSERT INTO `sys_role` VALUES (6, '123', 'code', NULL, 1, 0, '12222', '2024-01-18 21:56:30', '2024-01-18 21:56:30', 'ADMIN', 'ADMIN');
INSERT INTO `sys_role` VALUES (8, '游客1222222', 'TTT2', NULL, 1, 0, '不2知道22', '2024-01-18 21:57:00', '2024-01-18 21:57:00', 'ADMIN', 'ADMIN');
INSERT INTO `sys_role` VALUES (9, '1231', '123', NULL, 1, 0, '123123', '2024-01-18 22:28:11', '2024-01-18 22:28:11', 'ADMIN', 'ADMIN');
INSERT INTO `sys_role` VALUES (10, '1111', '1111', NULL, 1, 0, '1111', '2024-01-19 11:33:16', '2024-01-19 11:33:16', 'ADMIN', 'ADMIN');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_id` bigint NOT NULL COMMENT '角色ID',
  `menu_id` bigint NOT NULL COMMENT '菜单ID'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色和菜单关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (2, 1);
INSERT INTO `sys_role_menu` VALUES (2, 2);
INSERT INTO `sys_role_menu` VALUES (2, 3);
INSERT INTO `sys_role_menu` VALUES (2, 4);
INSERT INTO `sys_role_menu` VALUES (2, 5);
INSERT INTO `sys_role_menu` VALUES (2, 101);
INSERT INTO `sys_role_menu` VALUES (2, 102);
INSERT INTO `sys_role_menu` VALUES (2, 103);
INSERT INTO `sys_role_menu` VALUES (2, 104);
INSERT INTO `sys_role_menu` VALUES (2, 105);
INSERT INTO `sys_role_menu` VALUES (2, 106);
INSERT INTO `sys_role_menu` VALUES (2, 107);
INSERT INTO `sys_role_menu` VALUES (2, 108);
INSERT INTO `sys_role_menu` VALUES (2, 109);
INSERT INTO `sys_role_menu` VALUES (2, 110);
INSERT INTO `sys_role_menu` VALUES (2, 111);
INSERT INTO `sys_role_menu` VALUES (2, 112);
INSERT INTO `sys_role_menu` VALUES (2, 113);
INSERT INTO `sys_role_menu` VALUES (2, 114);
INSERT INTO `sys_role_menu` VALUES (2, 115);
INSERT INTO `sys_role_menu` VALUES (2, 116);
INSERT INTO `sys_role_menu` VALUES (2, 117);
INSERT INTO `sys_role_menu` VALUES (2, 118);
INSERT INTO `sys_role_menu` VALUES (1, 1);
INSERT INTO `sys_role_menu` VALUES (1, 101);
INSERT INTO `sys_role_menu` VALUES (1, 103);
INSERT INTO `sys_role_menu` VALUES (1, 6);
INSERT INTO `sys_role_menu` VALUES (5, 3);
INSERT INTO `sys_role_menu` VALUES (5, 111);
INSERT INTO `sys_role_menu` VALUES (5, 112);
INSERT INTO `sys_role_menu` VALUES (5, 113);
INSERT INTO `sys_role_menu` VALUES (5, 114);
INSERT INTO `sys_role_menu` VALUES (5, 115);
INSERT INTO `sys_role_menu` VALUES (5, 5);
INSERT INTO `sys_role_menu` VALUES (5, 117);
INSERT INTO `sys_role_menu` VALUES (5, 118);

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `role_id` bigint NOT NULL COMMENT '角色ID',
  `permission_id` bigint NOT NULL COMMENT '访问权限ID'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色权限关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES (2, 1001);
INSERT INTO `sys_role_permission` VALUES (2, 1002);
INSERT INTO `sys_role_permission` VALUES (2, 1003);
INSERT INTO `sys_role_permission` VALUES (2, 1004);
INSERT INTO `sys_role_permission` VALUES (2, 1005);
INSERT INTO `sys_role_permission` VALUES (2, 1006);
INSERT INTO `sys_role_permission` VALUES (2, 1007);
INSERT INTO `sys_role_permission` VALUES (2, 1008);
INSERT INTO `sys_role_permission` VALUES (2, 1009);
INSERT INTO `sys_role_permission` VALUES (2, 1010);
INSERT INTO `sys_role_permission` VALUES (2, 1011);
INSERT INTO `sys_role_permission` VALUES (2, 1012);
INSERT INTO `sys_role_permission` VALUES (1, 1001);
INSERT INTO `sys_role_permission` VALUES (1, 1002);
INSERT INTO `sys_role_permission` VALUES (1, 1009);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '昵称',
  `gender` tinyint(1) NULL DEFAULT 1 COMMENT '性别((1:男;2:女))',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '用户头像',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系方式',
  `status` tinyint(1) NULL DEFAULT 1 COMMENT '用户状态((1:正常;0:禁用))',
  `email` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除标识(0:未删除;1:已删除)',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '个人简介',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'ADMIN' COMMENT '创建者',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'ADMIN' COMMENT '更新者',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `login_name`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'root', '清风', 2, '$2a$10$Sj5IxDJWQnQdkmQNvr5KX.rotdyk5MUn6/ybnoU4.wQ2cza.e3k1e', 'https://picss.sunbangyan.cn/2023/12/15/e3c02fef8b8cb3541703a57ab7f9cd84.jpeg\r\n', '15592660011', 1, '123@qq.com', 0, '行动是治愈恐惧的良药，而犹豫、拖延将不断滋养恐惧。', '2023-12-12 17:36:41', '2023-12-12 17:36:41', 'ADMIN', 'ADMIN');
INSERT INTO `sys_user` VALUES (2, 'admin', '忙里偷闲的sin', 1, '$2a$10$Sj5IxDJWQnQdkmQNvr5KX.rotdyk5MUn6/ybnoU4.wQ2cza.e3k1e', 'https://picdl.sunbangyan.cn/2023/12/15/a6fa9f80a1378643f59bffad03c6a018.jpeg\r\n', '1559211****', 1, '123@qq.com', 0, '有些人的存在就是为了提醒我们，不要成为那样的人。', '2023-12-12 17:40:01', '2023-12-12 17:40:01', 'ADMIN', 'ADMIN');
INSERT INTO `sys_user` VALUES (32, 'qf123456', 'qftest123', 5, '$2a$10$Sj5IxDJWQnQdkmQNvr5KX.rotdyk5MUn6/ybnoU4.wQ2cza.e3k1e', 'https://picss.sunbangyan.cn/2023/12/15/e3c02fef8b8cb3541703a57ab7f9cd84.jpeg\r\n', '15500110012', 0, '123@qq.com', 1, '', '2024-01-18 16:06:15', '2024-01-18 16:06:15', 'ADMIN', 'ADMIN');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `role_id` bigint NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户和角色关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (2, 2);
INSERT INTO `sys_user_role` VALUES (3, 3);
INSERT INTO `sys_user_role` VALUES (4, 4);
INSERT INTO `sys_user_role` VALUES (6, 2);
INSERT INTO `sys_user_role` VALUES (28, 1);
INSERT INTO `sys_user_role` VALUES (32, 6);

SET FOREIGN_KEY_CHECKS = 1;
