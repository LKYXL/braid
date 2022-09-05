SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for billinfo
-- ----------------------------
DROP TABLE IF EXISTS `billinfo`;
CREATE TABLE `billinfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sname` varchar(255) DEFAULT NULL COMMENT '供应商名称',
  `dname` varchar(255) DEFAULT NULL COMMENT '零部件名称',
  `count` int(10) DEFAULT NULL COMMENT '零部件数量',
  `total` float(20,2) DEFAULT NULL COMMENT '总金额',
  `buytime` datetime DEFAULT NULL COMMENT '进货时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='账单信息';

-- ----------------------------
-- Records of billinfo
-- ----------------------------
INSERT INTO `billinfo` VALUES ('1', '库卡集团', '库卡机器人', '100', '2250.00', '2022-05-31 16:00:00');

-- ----------------------------
-- Table structure for owninfo
-- ----------------------------
DROP TABLE IF EXISTS `owninfo`;
CREATE TABLE `owninfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dname` varchar(255) DEFAULT NULL COMMENT '零部件名称',
  `type` varchar(255) DEFAULT NULL COMMENT '出库/入库',
  `count` int(10) DEFAULT NULL COMMENT '数量',
  `operator` varchar(255) DEFAULT NULL COMMENT '操作人',
  `createtime` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='出入库';

-- ----------------------------
-- Records of owninfo
-- ----------------------------
INSERT INTO `owninfo` VALUES ('1', 'Estun机器人', '出库', '2', '汪', '2022-06-23 03:47:01');
INSERT INTO `owninfo` VALUES ('2', 'KUKA机器人', '入库', '20', '陈', '2022-06-23 03:49:52');

-- ----------------------------
-- Table structure for partsinfo
-- ----------------------------
DROP TABLE IF EXISTS `partsinfo`;
CREATE TABLE `partsinfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `supplier` varchar(255) DEFAULT NULL COMMENT '供应商',
  `producetime` date DEFAULT NULL COMMENT '生产时间',
  `warranty` varchar(255) DEFAULT NULL COMMENT '寿命',
  `number` varchar(255) DEFAULT NULL COMMENT '零部件编码',
  `price` float(20,2) DEFAULT NULL COMMENT '价格',
  `stock` int(10) DEFAULT NULL COMMENT '库存',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='零部件信息';

-- ----------------------------
-- Records of partsinfo
-- ----------------------------
INSERT INTO `partsinfo` VALUES ('1', 'KUKA机器人', '库卡集团', '2021-01-24', '24', '1001', '22.50', '50');
INSERT INTO `partsinfo` VALUES ('5', 'Estun机器人', 'ESTUN', '2022-06-19', '24', '20220623', '19.99', '100');

-- ----------------------------
-- Table structure for problem
-- ----------------------------
DROP TABLE IF EXISTS `problem`;
CREATE TABLE `problem` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dname` varchar(255) DEFAULT NULL COMMENT '问题零部件名称',
  `dcount` int(10) DEFAULT NULL COMMENT '问题零部件数量',
  `dprice` float(20,2) DEFAULT NULL COMMENT '零部件单价',
  `reason` varchar(1000) DEFAULT NULL COMMENT '问题原因',
  `createtime` datetime DEFAULT NULL COMMENT '出问题时的操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='问题零部件';

-- ----------------------------
-- Records of problem
-- ----------------------------
INSERT INTO `problem` VALUES ('1', 'ESTUN机器人', '2', '19.99', '机器人小臂损坏', '2022-06-23 05:05:56');

-- ----------------------------
-- Table structure for returngoods
-- ----------------------------
DROP TABLE IF EXISTS `returngoods`;
CREATE TABLE `returngoods` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dname` varchar(255) DEFAULT NULL COMMENT '退货零部件名称',
  `count` int(10) DEFAULT NULL COMMENT '数量',
  `reason` varchar(1000) DEFAULT NULL COMMENT '退货原因',
  `total` float(20,2) DEFAULT NULL COMMENT '退货总金额',
  `operatetime` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='收到退货';

-- ----------------------------
-- Records of returngoods
-- ----------------------------
INSERT INTO `returngoods` VALUES ('1', '携砂器', '1', '底座不平', '5.00', '2022-06-24 16:00:00');

-- ----------------------------
-- Table structure for returnsupplier
-- ----------------------------
DROP TABLE IF EXISTS `returnsupplier`;
CREATE TABLE `returnsupplier` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dname` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `dcount` int(10) DEFAULT NULL COMMENT '数量',
  `sname` varchar(255) DEFAULT NULL COMMENT '供应商名称（退给谁）',
  `buytime` datetime DEFAULT NULL COMMENT '进货时间',
  `reason` varchar(1000) DEFAULT NULL COMMENT '退货原因',
  `createtime` datetime DEFAULT NULL COMMENT '退货时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='退货给供应商';

-- ----------------------------
-- Records of returnsupplier
-- ----------------------------
INSERT INTO `returnsupplier` VALUES ('1', 'Estun机器人', '5', 'ESTUN', '2022-06-08 16:00:00', '寿命到了', '2022-06-24 16:00:00');

-- ----------------------------
-- Table structure for saleinfo
-- ----------------------------
DROP TABLE IF EXISTS `saleinfo`;
CREATE TABLE `saleinfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dname` varchar(255) DEFAULT NULL COMMENT '零部件名称',
  `dnumber` varchar(255) DEFAULT NULL COMMENT '零部件编号',
  `count` int(10) DEFAULT NULL COMMENT '数量',
  `total` float(20,2) DEFAULT NULL COMMENT '金额',
  `operator` varchar(255) DEFAULT NULL COMMENT '操作人',
  `operatetime` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='销售记录';

-- ----------------------------
-- Records of saleinfo
-- ----------------------------
INSERT INTO `saleinfo` VALUES ('1', 'KUKA机器人', '1001', '2', '45.00', '乔', '2022-06-14 16:00:00');

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '供应商名称',
  `content` varchar(1000) DEFAULT NULL COMMENT '供应商描述',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='供应商';

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES ('1', 'KUKA集团', '库卡集团是全球机器人及自动化生产设备和解决方案的供应商之一。', '2018-01-17 11:42:39');
INSERT INTO `supplier` VALUES ('8', 'ESTUN集团', '埃斯顿机器人为国产智能工业机器人“四小龙”之一。', '2022-06-21 08:25:15');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'username', 'password');
