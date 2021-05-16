/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : localhost:3306
 Source Schema         : staffingSystem

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 16/05/2021 21:12:34
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for consumer
-- ----------------------------
DROP TABLE IF EXISTS `consumer`;
CREATE TABLE `consumer`
(
    `userid`   int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
    `username` varchar(255) NOT NULL COMMENT '用户名',
    `password` varchar(255) NOT NULL COMMENT '用户密码',
    PRIMARY KEY (`userid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of consumer
-- ----------------------------
BEGIN;
INSERT INTO `consumer`
VALUES (2, 'adminadmin', '12345');
INSERT INTO `consumer`
VALUES (21, 'admin', 'admin');
INSERT INTO `consumer`
VALUES (23, '12345', '12345');
INSERT INTO `consumer`
VALUES (24, 'root', 'root');
INSERT INTO `consumer`
VALUES (25, 'admin', 'a');
INSERT INTO `consumer`
VALUES (26, '123456', '111');
INSERT INTO `consumer`
VALUES (27, 'admin', '0987');
INSERT INTO `consumer`
VALUES (51, '12', '2');
INSERT INTO `consumer`
VALUES (57, 'Brian', 'Ainibubian2188?');
INSERT INTO `consumer`
VALUES (58, 'admin', 'Ainibubian2188!');
INSERT INTO `consumer`
VALUES (59, 'admin', 'Ainibubian2188!');
INSERT INTO `consumer`
VALUES (60, 'admin', 'Ainibubian2188!');
INSERT INTO `consumer`
VALUES (61, 'admin', 'Ainibubian2!');
INSERT INTO `consumer`
VALUES (62, 'admin', 'Ainibubian1!');
INSERT INTO `consumer`
VALUES (63, 'admin', 'Ainibubian2188!');
INSERT INTO `consumer`
VALUES (64, 'admin', 'Ainibubian2188!');
INSERT INTO `consumer`
VALUES (65, 'admin', 'Aini2188!');
INSERT INTO `consumer`
VALUES (66, 'admin', 'Aini2188!');
INSERT INTO `consumer`
VALUES (67, 'admin', 'Ainibubian2188!');
INSERT INTO `consumer`
VALUES (68, 'admin', 'Ainibubian2188!');
INSERT INTO `consumer`
VALUES (69, 'admin', 'Ainibubian2188!');
INSERT INTO `consumer`
VALUES (70, 'admin', '11');
INSERT INTO `consumer`
VALUES (71, '123456', '1');
INSERT INTO `consumer`
VALUES (72, 'admin', '1');
INSERT INTO `consumer`
VALUES (73, '123456', '121');
INSERT INTO `consumer`
VALUES (74, '1', '1');
INSERT INTO `consumer`
VALUES (75, '12311', '11');
INSERT INTO `consumer`
VALUES (76, '12', '12');
INSERT INTO `consumer`
VALUES (77, '1', '1');
INSERT INTO `consumer`
VALUES (79, ' ', '1');
COMMIT;

-- ----------------------------
-- Table structure for departments
-- ----------------------------
DROP TABLE IF EXISTS `departments`;
CREATE TABLE `departments`
(
    `id`              int(5) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `department_name` text NOT NULL COMMENT '部门',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of departments
-- ----------------------------
BEGIN;
INSERT INTO `departments`
VALUES (102, '考勤部1000');
INSERT INTO `departments`
VALUES (103, '实践部');
INSERT INTO `departments`
VALUES (104, '教育部');
INSERT INTO `departments`
VALUES (119, '天才部');
COMMIT;

-- ----------------------------
-- Table structure for employees
-- ----------------------------
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees`
(
    `id`         int(5) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `staff_name` varchar(255) NOT NULL COMMENT '姓名',
    `email`      varchar(255) NOT NULL COMMENT '邮箱',
    `gender`     varchar(255) NOT NULL COMMENT '性别',
    `department` int(10) NOT NULL COMMENT '部门',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=140 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employees
-- ----------------------------
BEGIN;
INSERT INTO `employees`
VALUES (104, '小七', '12123131@qq.com', '1', 104);
INSERT INTO `employees`
VALUES (106, '张三', 's@a.com', '1', 104);
INSERT INTO `employees`
VALUES (121, '张三', '1580359334@qq.com', '1', 102);
INSERT INTO `employees`
VALUES (122, '张三', '1580359334@qq.com', '1', 103);
INSERT INTO `employees`
VALUES (124, '133333', '123@qq.c', '1', 104);
INSERT INTO `employees`
VALUES (125, '张三', '1580359334@qq.com', '1', 103);
INSERT INTO `employees`
VALUES (126, '张三', '1111@qq.com', '1', 103);
INSERT INTO `employees`
VALUES (128, '张三', '1111@qq.com', '0', 102);
INSERT INTO `employees`
VALUES (129, '小七', '12123131@qq.com', '1', 103);
INSERT INTO `employees`
VALUES (130, '张三', '1580359334@qq.com', '1', 104);
INSERT INTO `employees`
VALUES (132, 'a', '1111@qq.com', '1', 119);
INSERT INTO `employees`
VALUES (133, '张三', '1580359334@qq.com', '1', 103);
INSERT INTO `employees`
VALUES (134, '张三', '1580359334@qq.com', '0', 104);
INSERT INTO `employees`
VALUES (135, '张三', '1580359334@qq.com', '1', 102);
INSERT INTO `employees`
VALUES (137, 'a', 'a@b.com', '1', 102);
INSERT INTO `employees`
VALUES (138, '张三', '1580359334@qq.com', '0', 119);
INSERT INTO `employees`
VALUES (139, '张三', '1580359334@qq.com', '1', 102);
COMMIT;

SET
FOREIGN_KEY_CHECKS = 1;
