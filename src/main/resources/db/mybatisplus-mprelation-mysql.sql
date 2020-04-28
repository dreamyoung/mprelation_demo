/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : mybatisplus

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2020-04-29 04:33:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `child`
-- ----------------------------
DROP TABLE IF EXISTS `child`;
CREATE TABLE `child` (
  `child_id` bigint(20) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `lao_han_id` bigint(20) NOT NULL,
  `lao_ma_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of child
-- ----------------------------
INSERT INTO `child` VALUES ('1', '小小明', '1', '1');
INSERT INTO `child` VALUES ('2', '小小王', '2', '2');
INSERT INTO `child` VALUES ('3', '旺仔', '2', '1');
INSERT INTO `child` VALUES ('4', '小馒头', '2', '1');
INSERT INTO `child` VALUES ('5', '大礼包', '1', '2');

-- ----------------------------
-- Table structure for `company`
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `company_id` bigint(20) NOT NULL,
  `name` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('1', '百度');
INSERT INTO `company` VALUES ('2', '小米');

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` bigint(20) NOT NULL,
  `name` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '语文');
INSERT INTO `course` VALUES ('2', '英语');
INSERT INTO `course` VALUES ('3', '化学');
INSERT INTO `course` VALUES ('4', '物理');
INSERT INTO `course` VALUES ('5', '数学');

-- ----------------------------
-- Table structure for `man`
-- ----------------------------
DROP TABLE IF EXISTS `man`;
CREATE TABLE `man` (
  `man_id` bigint(20) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `lao_po_id` bigint(20) DEFAULT '0',
  `company_id` bigint(20) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of man
-- ----------------------------
INSERT INTO `man` VALUES ('1', 'mysql-程序猿小明', '1', '1');
INSERT INTO `man` VALUES ('2', 'mysql-隔壁老王', '1', '1');
INSERT INTO `man` VALUES ('11', 'man-11', null, '2');
INSERT INTO `man` VALUES ('12', 'man-11', null, null);
INSERT INTO `man` VALUES ('13', 'man-11', '1', null);

-- ----------------------------
-- Table structure for `student_course`
-- ----------------------------
DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course` (
  `id` bigint(20) NOT NULL,
  `student_id` bigint(20) NOT NULL,
  `course_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_course
-- ----------------------------
INSERT INTO `student_course` VALUES ('1', '1', '1');
INSERT INTO `student_course` VALUES ('2', '1', '2');
INSERT INTO `student_course` VALUES ('3', '1', '3');
INSERT INTO `student_course` VALUES ('4', '2', '2');
INSERT INTO `student_course` VALUES ('5', '2', '3');
INSERT INTO `student_course` VALUES ('6', '3', '1');

-- ----------------------------
-- Table structure for `student_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `student_teacher`;
CREATE TABLE `student_teacher` (
  `id` bigint(8) NOT NULL,
  `student_id` bigint(8) DEFAULT NULL,
  `teacher_id` bigint(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_teacher
-- ----------------------------
INSERT INTO `student_teacher` VALUES ('1', '1', '1');
INSERT INTO `student_teacher` VALUES ('2', '1', '2');
INSERT INTO `student_teacher` VALUES ('3', '2', '3');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacher_id` bigint(8) NOT NULL,
  `name` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', 'tearcher-1');
INSERT INTO `teacher` VALUES ('2', 'tearcher-2');
INSERT INTO `teacher` VALUES ('3', 'tearcher-3');

-- ----------------------------
-- Table structure for `tel`
-- ----------------------------
DROP TABLE IF EXISTS `tel`;
CREATE TABLE `tel` (
  `id` bigint(20) NOT NULL,
  `tel` varchar(30) DEFAULT NULL,
  `man_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tel
-- ----------------------------
INSERT INTO `tel` VALUES ('1', '139xxxxxx', '1');
INSERT INTO `tel` VALUES ('2', '137xxxxxx', '1');
INSERT INTO `tel` VALUES ('3', '158xxxxxx', '2');
INSERT INTO `tel` VALUES ('4', '159xxxxxx', '1');

-- ----------------------------
-- Table structure for `woman`
-- ----------------------------
DROP TABLE IF EXISTS `woman`;
CREATE TABLE `woman` (
  `woman_id` bigint(20) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `lao_gong_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of woman
-- ----------------------------
INSERT INTO `woman` VALUES ('1', '程序猿小明老婆', '1');
INSERT INTO `woman` VALUES ('2', '隔壁老王老婆', '2');
