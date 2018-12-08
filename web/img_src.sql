/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2018-12-08 15:42:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `img_src`
-- ----------------------------
DROP TABLE IF EXISTS `img_src`;
CREATE TABLE `img_src` (
  `id` int(25) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `src` varchar(100) DEFAULT NULL COMMENT '路径',
  `username` varchar(255) DEFAULT NULL,
  `date` varchar(25) DEFAULT NULL,
  `ip` varchar(30) DEFAULT NULL,
  `size` float(22,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=224 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of img_src
-- ----------------------------
INSERT INTO `img_src` VALUES ('3', '百度照片', 'image/20181025143624.jpg', '李弟文', '2018-10-25 14:36:24', null, null);
INSERT INTO `img_src` VALUES ('4', '我爱你', 'image/20181025143641.jpg', '李弟文', '2018-10-25 14:36:41', null, null);
INSERT INTO `img_src` VALUES ('5', '你是谁', 'image/20181025143656.jpg', '李弟文', '2018-10-25 14:36:56', null, null);
INSERT INTO `img_src` VALUES ('6', 'admins', 'image/20181025143709.jpg', '李弟文', '2018-10-25 14:37:09', null, null);
INSERT INTO `img_src` VALUES ('8', '河水', 'image/20181025143738.jpg', '李弟文', '2018-10-25 14:37:38', null, null);
INSERT INTO `img_src` VALUES ('9', '山', 'image/20181025143750.jpg', '李弟文', '2018-10-25 14:37:50', null, null);
INSERT INTO `img_src` VALUES ('10', '自由照片', 'image/20181025144016.jpg', '李弟文', '2018-10-25 14:40:16', null, null);
INSERT INTO `img_src` VALUES ('65', '我爱罗', 'image/20181025144606.jpg', '李弟文', '2018-10-25 14:46:06', null, null);
INSERT INTO `img_src` VALUES ('66', '我爱罗个性照', 'image/20181025144759.jpg', '李弟文', '2018-10-25 14:47:59', null, null);
INSERT INTO `img_src` VALUES ('67', 'admin', 'image/20181025145057.jpg', '李弟文', '2018-10-25 14:50:57', null, null);
INSERT INTO `img_src` VALUES ('68', '1601030050', 'image/20181025145413.jpg', '许三多', '2018-10-25 14:54:13', null, null);
INSERT INTO `img_src` VALUES ('69', 'admin', 'image/20181025145711.jpg', 'java', '2018-10-25 14:57:11', null, null);
INSERT INTO `img_src` VALUES ('70', 'admin', 'image/20181025183625.jpg', '许三多', '2018-10-25 18:36:25', null, null);
INSERT INTO `img_src` VALUES ('71', '奔跑的骏马', 'image/20181025184144.jpg', '许三多', '2018-10-25 18:41:45', null, null);
INSERT INTO `img_src` VALUES ('72', '草原', 'image/20181025184352.jpg', '许三多', '2018-10-25 18:43:52', null, null);
INSERT INTO `img_src` VALUES ('73', '李弟文', 'image/20181025185122.jpg', '许三多', '2018-10-25 18:51:22', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('74', '123456', 'image/20181025185329.jpg', '许三多', '2018-10-25 18:53:29', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('75', 'admin', 'image/20181025185553.jpg', '许三多', '2018-10-25 18:55:54', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('76', '山水照', 'image/20181025185800.jpg', '许三多', '2018-10-25 18:58:00', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('77', '1601030050', 'image/20181025185811.jpg', '许三多', '2018-10-25 18:58:11', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('78', '黄小气', 'image/20181025191917.jpg', '许三多', '2018-10-25 19:19:17', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('79', '小李子的', 'image/20181025192304.jpg', '许三多', '2018-10-25 19:23:05', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('83', '山水照', 'image/20181025194757.jpg', '许三多', '2018-10-25 19:47:57', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('84', '李弟文', 'image/20181025200025.jpg', '许三多', '2018-10-25 20:00:25', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('85', 'admin', 'image/20181025203839.jpg', '许三多', '2018-10-25 20:38:39', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('86', '都是', 'image/20181025204029.jpg', 'desdasw', '2018-10-25 20:40:29', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('87', 'fdd', 'image/20181025204305.jpg', 'desdasw', '2018-10-25 20:43:06', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('88', 'java企业级开发', 'image/20181025211753.jpg', '李弟文', '2018-10-25 21:17:53', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('89', '动态图', 'image/20181025214008.gif', '李弟文', '2018-10-25 21:41:01', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('90', 'admin', 'image/20181025214056.gif', '李弟文', '2018-10-25 21:41:50', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('91', 'admin', 'image/20181025214144.gif', '李弟文', '2018-10-25 21:42:15', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('92', '传到', 'image/20181025220301.jpg', 'desdasw', '2018-10-25 22:03:01', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('93', 'admin', 'image/20181026123431.jpg', '李弟文', '2018-10-26 12:34:31', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('94', 'admin', 'image/20181026160710.jpg', 'lidiwen5', '2018-10-26 16:07:11', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('95', '李弟文', 'image/20181026160848.jpg', 'lidiwen5', '2018-10-26 16:08:48', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('98', 'admin', 'image/20181026165743.jpg', 'lidiwen5', '2018-10-26 16:57:43', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('103', 'admin', 'image/20181026205210.jpg', 'lidiwen5', '2018-10-26 20:52:10', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('104', 'admin', 'image/20181026205327.jpg', 'lidiwen5', '2018-10-26 20:53:27', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('106', '1632029393@qq.com', 'image/20181026211404.gif', '黄晓琪', '2018-10-26 21:14:38', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('107', '1632029393@qq.com', 'image/20181026211404.gif', '黄晓琪', '2018-10-26 21:14:38', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('108', 'frfr', 'image/20181026211448.jpg', '黄晓琪', '2018-10-26 21:14:48', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('109', 'frfr', 'image/20181026211448.jpg', '黄晓琪', '2018-10-26 21:14:48', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('110', 'admin', 'image/20181026211716.jpg', 'lidiwen5', '2018-10-26 21:17:42', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('111', 'cdcd', 'image/20181026212143.jpg', 'lidiwen5', '2018-10-26 21:22:06', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('112', 'xsxs', 'image/20181026212314.jpg', 'lidiwen5', '2018-10-26 21:23:37', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('114', 'admin', 'image/20181026212901.jpg', 'lidiwen5', '2018-10-26 21:29:02', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('115', 'admin', 'image/20181026212914.jpg', 'lidiwen5', '2018-10-26 21:29:37', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('116', 'admin', 'image/20181026213008.gif', 'lidiwen5', '2018-10-26 21:30:37', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('117', 'admin', 'image/20181026213827.gif', 'lidiwen5', '2018-10-26 21:38:58', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('118', 'admin', 'image/20181026213844.gif', 'lidiwen5', '2018-10-26 21:39:15', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('119', 'admin', 'image/20181026214010.jpg', 'lidiwen5', '2018-10-26 21:40:33', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('121', 'admin', 'image/20181026221210.jpg', 'lidiwen5', '2018-10-26 22:12:19', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('124', 'admin', 'image/20181026221617.jpg', 'lidiwen5', '2018-10-26 22:16:17', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('128', '1632029393@qq.com', 'image/20181027120104.jpg', '李弟文', '2018-10-27 12:01:05', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('130', 'admin', 'image/20181027121031.jpg', 'lidiwen5', '2018-10-27 12:10:31', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('131', 'admin', 'image/20181027121551.jpg', 'lidiwen5', '2018-10-27 12:15:51', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('135', '1632029393@qq.com', 'image/20181027140900.jpg', '李弟文', '2018-10-27 14:09:01', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('136', '1632029393@qq.com', 'image/20181027140900.jpg', '李弟文', '2018-10-27 14:09:01', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('137', '1632029393@qq.com', 'image/1632029393@qq.com20181027141430.jpg', 'lidiwen5', '2018-10-27 14:14:30', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('138', '1632029393@qq.com', 'image/1632029393@qq.com20181027141430.jpg', 'lidiwen5', '2018-10-27 14:14:30', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('140', '李弟文cdfc才当曹斗才的方法大V发vv', 'image/20181027191646.jpg', 'lidiwen5', '2018-10-27 19:16:46', '0:0:0:0:0:0:0:1', null);
INSERT INTO `img_src` VALUES ('141', 'admin', 'image/20181029072806.jpg', 'admin', '2018-10-29 07:28:06', '0:0:0:0:0:0:0:1', '18.00');
INSERT INTO `img_src` VALUES ('142', '小李子的', 'image/20181029072908.jpg', 'admin', '2018-10-29 07:29:09', '0:0:0:0:0:0:0:1', '24.00');
INSERT INTO `img_src` VALUES ('143', 'admin', 'image/20181029073003.jpg', 'admin', '2018-10-29 07:30:03', '0:0:0:0:0:0:0:1', '43.00');
INSERT INTO `img_src` VALUES ('144', 'ggdfgg', 'image/20181029081535.jpg', 'lidiwen5', '2018-10-29 08:15:36', '0:0:0:0:0:0:0:1', '19.00');
INSERT INTO `img_src` VALUES ('145', 'ggdfgg', 'image/20181029081536.jpg', 'lidiwen5', '2018-10-29 08:15:36', '0:0:0:0:0:0:0:1', '19.00');
INSERT INTO `img_src` VALUES ('146', 'ggdfgg', 'image/20181029081536.jpg', 'lidiwen5', '2018-10-29 08:15:37', '0:0:0:0:0:0:0:1', '19.00');
INSERT INTO `img_src` VALUES ('147', 'ggdfgg', 'image/20181029081537.jpg', 'lidiwen5', '2018-10-29 08:15:37', '0:0:0:0:0:0:0:1', '19.00');
INSERT INTO `img_src` VALUES ('148', 'ggdfgg', 'image/20181029081537.jpg', 'lidiwen5', '2018-10-29 08:15:37', '0:0:0:0:0:0:0:1', '19.00');
INSERT INTO `img_src` VALUES ('150', 'ggdfgg', 'image/20181029081537.jpg', 'lidiwen5', '2018-10-29 08:15:37', '0:0:0:0:0:0:0:1', '19.00');
INSERT INTO `img_src` VALUES ('151', 'dfggdg', 'image/20181029081608.jpg', 'lidiwen5', '2018-10-29 08:16:09', '0:0:0:0:0:0:0:1', '16.00');
INSERT INTO `img_src` VALUES ('152', 'admin', 'image/20181029081844.jpg', 'lidiwen5', '2018-10-29 08:18:44', '0:0:0:0:0:0:0:1', '29.00');
INSERT INTO `img_src` VALUES ('153', 'gfg', 'image/20181029081928.jpg', 'lidiwen5', '2018-10-29 08:19:28', '0:0:0:0:0:0:0:1', '14.00');
INSERT INTO `img_src` VALUES ('154', 'admin', 'image/20181029082156.jpg', 'lidiwen5', '2018-10-29 08:21:56', '0:0:0:0:0:0:0:1', '6.00');
INSERT INTO `img_src` VALUES ('155', 'admin', 'image/20181029082219.jpg', 'lidiwen5', '2018-10-29 08:22:20', '0:0:0:0:0:0:0:1', '16.00');
INSERT INTO `img_src` VALUES ('156', 'admin', 'image/20181029083917.jpg', 'lidiwen5', '2018-10-29 08:39:18', '0:0:0:0:0:0:0:1', '51.00');
INSERT INTO `img_src` VALUES ('157', 'cddc', 'image/20181029103208.jpg', 'lidiwen5', '2018-10-29 10:32:08', '0:0:0:0:0:0:0:1', '24.00');
INSERT INTO `img_src` VALUES ('158', 'admin', 'image/20181029103224.jpg', 'lidiwen5', '2018-10-29 10:32:24', '0:0:0:0:0:0:0:1', '38.00');
INSERT INTO `img_src` VALUES ('159', 'cdcd ', 'image/20181029103734.jpg', 'lidiwen5', '2018-10-29 10:37:34', '0:0:0:0:0:0:0:1', '16.00');
INSERT INTO `img_src` VALUES ('160', 'cddccd', 'image/20181029105402.jpg', 'admin', '2018-10-29 10:54:02', '0:0:0:0:0:0:0:1', '16.00');
INSERT INTO `img_src` VALUES ('161', 'admin', 'image/20181029111557.jpg', 'lidiwen5', '2018-10-29 11:15:57', '0:0:0:0:0:0:0:1', '27.00');
INSERT INTO `img_src` VALUES ('163', 'admin', 'image/20181029112337.jpg', 'lidiwen5', '2018-10-29 11:23:37', '0:0:0:0:0:0:0:1', '16.00');
INSERT INTO `img_src` VALUES ('164', 'cdcd', 'image/20181029173407.jpg', 'lidiwen5', '2018-10-29 17:34:09', '0:0:0:0:0:0:0:1', '255.00');
INSERT INTO `img_src` VALUES ('167', '测试临时缓存', 'image/20181030101541.jpg', 'lidiwen5', '2018-10-30 10:15:41', '0:0:0:0:0:0:0:1', '36.00');
INSERT INTO `img_src` VALUES ('174', 'cdcdcd', 'image/20181030130006.jpg', 'admin', '2018-10-30 13:00:06', '0:0:0:0:0:0:0:1', '16.00');
INSERT INTO `img_src` VALUES ('175', '1601030050', 'image/20181030130458.jpg', 'admin', '2018-10-30 13:04:58', '0:0:0:0:0:0:0:1', '16.00');
INSERT INTO `img_src` VALUES ('180', '飞机', 'image/20181030131322.jpg', 'admin', '2018-10-30 13:13:22', '0:0:0:0:0:0:0:1', '14.00');
INSERT INTO `img_src` VALUES ('181', 'admin', 'image/20181030213951.jpg', 'lidiwen5', '2018-10-30 21:39:51', '0:0:0:0:0:0:0:1', '11.00');
INSERT INTO `img_src` VALUES ('182', 'admin', 'image/20181030223201.jpg', 'lidiwen5', '2018-10-30 22:32:01', '0:0:0:0:0:0:0:1', '18.00');
INSERT INTO `img_src` VALUES ('183', 'admin', 'image/20181031140352.jpg', 'lidiwen5', '2018-10-31 14:03:52', '0:0:0:0:0:0:0:1', '11.00');
INSERT INTO `img_src` VALUES ('198', '批量上传', 'image/201811091311480701.jpg', 'admin', '2018-11-09 13:11:48', '0:0:0:0:0:0:0:1', '23.00');
INSERT INTO `img_src` VALUES ('199', '批量上传', 'image/201811091311480702.jpg', 'admin', '2018-11-09 13:11:48', '0:0:0:0:0:0:0:1', '52.00');
INSERT INTO `img_src` VALUES ('200', '批量上传', 'image/201811091554110714.jpg', 'admin', '2018-11-09 15:54:11', '0:0:0:0:0:0:0:1', '53.00');
INSERT INTO `img_src` VALUES ('201', '批量上传', 'image/201811091554110715.gif', 'admin', '2018-11-09 15:54:11', '0:0:0:0:0:0:0:1', '39.00');
INSERT INTO `img_src` VALUES ('202', '批量上传', 'image/201811091554110713.jpg', 'admin', '2018-11-09 15:54:11', '0:0:0:0:0:0:0:1', '23.00');
INSERT INTO `img_src` VALUES ('203', '批量上传', 'image/201811091554120564.jpg', 'admin', '2018-11-09 15:54:12', '0:0:0:0:0:0:0:1', '17.00');
INSERT INTO `img_src` VALUES ('204', '批量上传', 'image/201811091554120585.jpg', 'admin', '2018-11-09 15:54:12', '0:0:0:0:0:0:0:1', '27.00');
INSERT INTO `img_src` VALUES ('205', '批量上传', 'image/201811091554120609.jpg', 'admin', '2018-11-09 15:54:12', '0:0:0:0:0:0:0:1', '12.00');
INSERT INTO `img_src` VALUES ('206', '批量上传', 'image/201811091605030637.jpg', 'admin', '2018-11-09 16:05:03', '0:0:0:0:0:0:0:1', '3.00');
INSERT INTO `img_src` VALUES ('207', '批量上传', 'image/201811091605030646.jpg', 'admin', '2018-11-09 16:05:03', '0:0:0:0:0:0:0:1', '6.00');
INSERT INTO `img_src` VALUES ('208', '批量上传', 'image/201811091605030666.jpg', 'admin', '2018-11-09 16:05:03', '0:0:0:0:0:0:0:1', '53.00');
INSERT INTO `img_src` VALUES ('209', '批量上传', 'image/36b4b21f1fa84a239e9b07a1d4409c97.jpg', 'admin', '2018-11-12 15:29:50', '0:0:0:0:0:0:0:1', '21.00');
INSERT INTO `img_src` VALUES ('210', '批量上传', 'image/99252fb01998468885c79796b52c4c0c.jpg', 'admin', '2018-11-12 15:29:50', '0:0:0:0:0:0:0:1', '72.00');
INSERT INTO `img_src` VALUES ('211', '批量上传', 'image/6fa0c95156254b21b057467f839b4b9c.jpg', 'admin', '2018-11-12 15:29:50', '0:0:0:0:0:0:0:1', '23.00');
INSERT INTO `img_src` VALUES ('212', '批量上传', 'image/a5349409724b4acd8bfd6e218cbcc0f7.jpg', 'admin', '2018-11-12 15:29:51', '0:0:0:0:0:0:0:1', '22.00');
INSERT INTO `img_src` VALUES ('213', '批量上传', 'image/6ac2a8b3cf9b42b79a73b8920f282f3e.jpg', 'admin', '2018-11-12 15:29:51', '0:0:0:0:0:0:0:1', '17.00');
INSERT INTO `img_src` VALUES ('214', '批量上传', 'image/9aae326fcd1744d7aa8ec44afa16c8ef.jpg', 'admin', '2018-11-12 15:29:51', '0:0:0:0:0:0:0:1', '15.00');
INSERT INTO `img_src` VALUES ('215', '批量上传', 'image/f4563bea5f544b4c8a20912e268cd4d8.jpg', 'admin', '2018-11-12 15:29:51', '0:0:0:0:0:0:0:1', '30.00');
INSERT INTO `img_src` VALUES ('216', '批量上传', 'image/b664dbbf4efa41689dc72897ce14726b.jpg', 'admin', '2018-11-12 15:29:51', '0:0:0:0:0:0:0:1', '34.00');
INSERT INTO `img_src` VALUES ('217', '批量上传', 'image/6d79be082b214b34bd6339eb44c16f62.jpg', 'admin', '2018-11-12 15:29:51', '0:0:0:0:0:0:0:1', '24.00');
INSERT INTO `img_src` VALUES ('218', '批量上传', 'image/af05121ff51a40639aed0ccdd3c1f810.jpg', 'admin', '2018-11-12 15:29:51', '0:0:0:0:0:0:0:1', '46.00');
INSERT INTO `img_src` VALUES ('219', '批量上传', 'image/a7791990dba9453691c6630923ad4d44.jpg', 'admin', '2018-11-12 15:29:51', '0:0:0:0:0:0:0:1', '27.00');
INSERT INTO `img_src` VALUES ('220', '批量上传', 'image/d70f785227974df58a5de30907cacdfb.jpg', 'admin', '2018-11-12 15:29:51', '0:0:0:0:0:0:0:1', '16.00');
INSERT INTO `img_src` VALUES ('223', '<script>', 'image/20181204102636.jpg', 'admin', '2018-12-04 10:26:36', '0:0:0:0:0:0:0:1', '11.00');
