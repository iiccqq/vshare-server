/*
SQLyog  v12.2.6 (64 bit)
MySQL - 5.7.4-m14 : Database - vshare
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`vshare` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `vshare`;

/*Table structure for table `com_file` */

DROP TABLE IF EXISTS `com_file`;

CREATE TABLE `com_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `filename` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `com_file` */

insert  into `com_file`(`id`,`filename`,`path`) values 
(1,'huahua1.jpg',''),
(2,'huahua2.jpg',''),
(3,'huahua3.jpg','');

/*Table structure for table `com_item` */

DROP TABLE IF EXISTS `com_item`;

CREATE TABLE `com_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) DEFAULT NULL,
  `desc` varchar(100) DEFAULT NULL,
  `display` int(11) DEFAULT NULL,
  `displayType` int(11) DEFAULT NULL,
  `iconPath` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `com_item` */

insert  into `com_item`(`id`,`title`,`desc`,`display`,`displayType`,`iconPath`) values 
(1,'花花','蓝色纯种',1,1,'huahuaicon.jpg'),
(2,'瓜瓜','白色',1,1,'huahuaicon.jpg');

/*Table structure for table `com_item_detail` */

DROP TABLE IF EXISTS `com_item_detail`;

CREATE TABLE `com_item_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `itemid` int(11) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `com_item_detail` */

insert  into `com_item_detail`(`id`,`itemid`,`title`,`content`) values 
(1,1,'花花介绍','花花介绍\r\n<StorageFile>1</StorageFile>\r\n玩耍\r\n<StorageFile>2</StorageFile>\r\n吃饭\r\n<StorageFile>3</StorageFile>\r\n睡觉');

/*Table structure for table `rbac_user` */

DROP TABLE IF EXISTS `rbac_user`;

CREATE TABLE `rbac_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `rbac_user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
