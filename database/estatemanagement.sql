CREATE DATABASE  IF NOT EXISTS `estateadvance` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `estateadvance`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: estateadvance
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `assignmentbuilding`
--

DROP TABLE IF EXISTS `assignmentbuilding`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `assignmentbuilding` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `staffid` bigint(20) NOT NULL,
  `buildingid` bigint(20) NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_building` (`staffid`),
  KEY `fk_building_user` (`buildingid`),
  CONSTRAINT `fk_building_user` FOREIGN KEY (`buildingid`) REFERENCES `building` (`id`),
  CONSTRAINT `fk_user_building` FOREIGN KEY (`staffid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=261 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignmentbuilding`
--

LOCK TABLES `assignmentbuilding` WRITE;
/*!40000 ALTER TABLE `assignmentbuilding` DISABLE KEYS */;
INSERT INTO `assignmentbuilding` VALUES (146,2,2,NULL,NULL,NULL,NULL),(147,3,2,NULL,NULL,NULL,NULL),(148,3,3,NULL,NULL,NULL,NULL),(149,4,3,NULL,NULL,NULL,NULL),(163,3,59,NULL,NULL,NULL,NULL),(164,26,59,NULL,NULL,NULL,NULL),(165,25,59,NULL,NULL,NULL,NULL),(166,13,4,NULL,NULL,NULL,NULL),(167,14,4,NULL,NULL,NULL,NULL),(168,25,53,NULL,NULL,NULL,NULL),(169,14,53,NULL,NULL,NULL,NULL),(170,13,53,NULL,NULL,NULL,NULL),(171,31,1,NULL,NULL,NULL,NULL),(172,16,1,NULL,NULL,NULL,NULL),(173,2,1,NULL,NULL,NULL,NULL),(174,26,72,NULL,NULL,NULL,NULL),(175,14,72,NULL,NULL,NULL,NULL),(176,25,72,NULL,NULL,NULL,NULL),(184,11,71,NULL,NULL,NULL,NULL),(185,13,71,NULL,NULL,NULL,NULL),(186,14,71,NULL,NULL,NULL,NULL),(193,14,143,NULL,NULL,NULL,NULL),(194,32,143,NULL,NULL,NULL,NULL),(195,13,143,NULL,NULL,NULL,NULL),(196,15,143,NULL,NULL,NULL,NULL),(197,19,142,NULL,NULL,NULL,NULL),(198,18,142,NULL,NULL,NULL,NULL),(199,25,142,NULL,NULL,NULL,NULL),(200,21,142,NULL,NULL,NULL,NULL),(201,29,140,NULL,NULL,NULL,NULL),(202,15,140,NULL,NULL,NULL,NULL),(203,16,140,NULL,NULL,NULL,NULL),(204,26,140,NULL,NULL,NULL,NULL),(205,25,140,NULL,NULL,NULL,NULL),(213,19,137,NULL,NULL,NULL,NULL),(214,18,137,NULL,NULL,NULL,NULL),(215,13,137,NULL,NULL,NULL,NULL),(216,14,137,NULL,NULL,NULL,NULL),(217,17,137,NULL,NULL,NULL,NULL),(218,14,136,NULL,NULL,NULL,NULL),(219,16,136,NULL,NULL,NULL,NULL),(220,15,136,NULL,NULL,NULL,NULL),(221,13,136,NULL,NULL,NULL,NULL),(222,25,147,NULL,NULL,NULL,NULL),(223,14,147,NULL,NULL,NULL,NULL),(224,17,147,NULL,NULL,NULL,NULL),(225,16,147,NULL,NULL,NULL,NULL),(226,13,146,NULL,NULL,NULL,NULL),(227,3,146,NULL,NULL,NULL,NULL),(228,15,146,NULL,NULL,NULL,NULL),(229,31,144,NULL,NULL,NULL,NULL),(230,26,144,NULL,NULL,NULL,NULL),(231,22,144,NULL,NULL,NULL,NULL),(232,16,145,NULL,NULL,NULL,NULL),(233,13,145,NULL,NULL,NULL,NULL),(234,11,145,NULL,NULL,NULL,NULL),(239,11,139,NULL,NULL,NULL,NULL),(240,26,139,NULL,NULL,NULL,NULL),(241,24,139,NULL,NULL,NULL,NULL),(242,27,139,NULL,NULL,NULL,NULL),(243,11,138,NULL,NULL,NULL,NULL),(244,15,138,NULL,NULL,NULL,NULL),(245,16,138,NULL,NULL,NULL,NULL),(246,27,138,NULL,NULL,NULL,NULL),(247,29,138,NULL,NULL,NULL,NULL),(254,14,141,NULL,NULL,NULL,NULL),(255,3,141,NULL,NULL,NULL,NULL),(256,11,141,NULL,NULL,NULL,NULL),(257,25,141,NULL,NULL,NULL,NULL),(258,22,141,NULL,NULL,NULL,NULL),(259,27,141,NULL,NULL,NULL,NULL),(260,30,141,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `assignmentbuilding` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assignmentcustomer`
--

DROP TABLE IF EXISTS `assignmentcustomer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `assignmentcustomer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `staffid` bigint(20) NOT NULL,
  `customerid` bigint(20) NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_customer` (`staffid`),
  KEY `fk_customer_user` (`customerid`),
  CONSTRAINT `fk_customer_user` FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`),
  CONSTRAINT `fk_user_customer` FOREIGN KEY (`staffid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=148 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignmentcustomer`
--

LOCK TABLES `assignmentcustomer` WRITE;
/*!40000 ALTER TABLE `assignmentcustomer` DISABLE KEYS */;
INSERT INTO `assignmentcustomer` VALUES (81,3,52,NULL,NULL,NULL,NULL),(82,4,52,NULL,NULL,NULL,NULL),(84,25,55,NULL,NULL,NULL,NULL),(85,26,55,NULL,NULL,NULL,NULL),(88,26,56,NULL,NULL,NULL,NULL),(89,11,56,NULL,NULL,NULL,NULL),(90,29,56,NULL,NULL,NULL,NULL),(91,25,53,NULL,NULL,NULL,NULL),(92,2,53,NULL,NULL,NULL,NULL),(93,2,51,NULL,NULL,NULL,NULL),(94,29,51,NULL,NULL,NULL,NULL),(95,3,51,NULL,NULL,NULL,NULL),(96,16,50,NULL,NULL,NULL,NULL),(97,3,50,NULL,NULL,NULL,NULL),(98,29,50,NULL,NULL,NULL,NULL),(104,26,59,NULL,NULL,NULL,NULL),(105,16,59,NULL,NULL,NULL,NULL),(106,30,59,NULL,NULL,NULL,NULL),(107,30,60,NULL,NULL,NULL,NULL),(108,16,60,NULL,NULL,NULL,NULL),(109,26,60,NULL,NULL,NULL,NULL),(131,26,62,NULL,NULL,NULL,NULL),(132,27,62,NULL,NULL,NULL,NULL),(133,25,62,NULL,NULL,NULL,NULL),(134,17,63,NULL,NULL,NULL,NULL),(135,15,63,NULL,NULL,NULL,NULL),(136,19,63,NULL,NULL,NULL,NULL),(137,14,63,NULL,NULL,NULL,NULL),(138,13,65,NULL,NULL,NULL,NULL),(139,15,65,NULL,NULL,NULL,NULL),(140,14,65,NULL,NULL,NULL,NULL),(141,13,66,NULL,NULL,NULL,NULL),(142,15,66,NULL,NULL,NULL,NULL),(143,18,66,NULL,NULL,NULL,NULL),(144,18,64,NULL,NULL,NULL,NULL),(145,22,64,NULL,NULL,NULL,NULL),(146,25,64,NULL,NULL,NULL,NULL),(147,19,64,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `assignmentcustomer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `building`
--

DROP TABLE IF EXISTS `building`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `building` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `street` varchar(255) DEFAULT NULL,
  `ward` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `structure` varchar(255) DEFAULT NULL,
  `numberofbasement` int(11) DEFAULT NULL,
  `floorarea` int(11) DEFAULT NULL,
  `managername` varchar(45) NOT NULL,
  `managerphone` varchar(45) NOT NULL,
  `direction` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `rentcost` int(11) DEFAULT NULL,
  `rentcostdescription` text,
  `servicefee` varchar(255) DEFAULT NULL,
  `carfee` varchar(255) DEFAULT NULL,
  `motofee` varchar(255) DEFAULT NULL,
  `overtimefee` varchar(255) DEFAULT NULL,
  `waterfee` varchar(255) DEFAULT NULL,
  `electricityfee` varchar(255) DEFAULT NULL,
  `deposit` varchar(255) DEFAULT NULL,
  `payment` varchar(255) DEFAULT NULL,
  `renttime` varchar(255) DEFAULT NULL,
  `decorationtime` varchar(255) DEFAULT NULL,
  `brokeragefee` decimal(13,2) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `linkofbuilding` varchar(255) DEFAULT NULL,
  `map` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `building`
--

LOCK TABLES `building` WRITE;
/*!40000 ALTER TABLE `building` DISABLE KEYS */;
INSERT INTO `building` VALUES (1,'Nam Giao Building Tower','59 phan xích long','Phường 2','QUAN_5','',2,500,'Khánh Linh','0234568244','Nam','2',20,NULL,'400','500','200','300',NULL,'500','20','40','5 năm',NULL,20.00,'NOI_THAT,TANG_TRET',NULL,NULL,NULL,NULL,NULL,'2022-08-03 17:29:54',NULL,'phiyen91'),(2,'ACM Tower','96 cao thắng','Phường 4','QUAN_3','',2,650,'Quốc Bảo','0234568322','Đông','1',18,NULL,'300','200','100','200',NULL,'500','20','40','10 năm',NULL,NULL,'TANG_TRET,NGUYEN_CAN',NULL,NULL,NULL,NULL,NULL,'2022-06-22 21:28:15',NULL,'nguyenvana'),(3,'Alpha 2 Building Tower','153 nguyễn đình chiểu','Phường 6','QUAN_1','',1,200,'Nguyễn Văn A','0234568254','Nam','3',20,NULL,'300','200','200','300',NULL,'500','20','40','5 năm',NULL,10.00,'TANG_TRET,NGUYEN_CAN',NULL,NULL,NULL,NULL,NULL,'2022-06-22 21:31:24',NULL,'nguyenvana'),(4,'IDD 1 Building','111 Lý Chính Thắng','Phường 7','QUAN_4','',1,200,'Quốc Bảo','0234568322','Đông','2',12,NULL,'300','500','200','300',NULL,'500','20','40','5 năm',NULL,20.00,'NOI_THAT',NULL,NULL,NULL,NULL,NULL,'2022-07-20 11:06:16',NULL,'phiyen91'),(53,'Nguyễn Đặng Khánh Linh','20 hoàng hoa thám','11','QUAN_7','',2,340,'Khánh Linh','0234568244','Tây Nam','1',14,NULL,'','','','',NULL,'','','','',NULL,NULL,'TANG_TRET,NGUYEN_CAN',NULL,NULL,NULL,NULL,NULL,'2022-08-03 22:53:08',NULL,'thuyhoa95'),(59,'Grab Tower','150 Nguyễn Thị Định','Phường 3','QUAN_7','',2,400,'Khánh Linh','0234568244','Tây','2',25,NULL,'','','','',NULL,'','','','',NULL,NULL,'TANG_TRET,NGUYEN_CAN',NULL,NULL,NULL,NULL,NULL,'2022-07-18 22:45:17',NULL,'quocbao00'),(71,'VinTower 2','65 Lê Văn Việt','Phường 3','QUAN_BINH_THANH','300x500',1,450,'Quốc Bảo','0234568322','Bắc','2',30,NULL,'500','500','200','100',NULL,'600','60','40','5 năm',NULL,10.00,'TANG_TRET,NGUYEN_CAN',NULL,NULL,NULL,NULL,NULL,'2022-08-03 08:39:25',NULL,'phiyen91'),(72,'Nam Giao Building Tower 2','77 Phan Văn Lưu','Phường 8','QUAN_BINH_THANH','400x500',2,400,'Phi Yến','0234568333','Nam','2',20,NULL,'300','400','200','300',NULL,'200','10','20','10 năm',NULL,20.00,'NOI_THAT,TANG_TRET',NULL,NULL,NULL,NULL,'2022-08-02 20:41:05','2022-08-02 20:46:16','phiyen91','phiyen91'),(134,'Bình Minh','210 Lê Duẩn','Phường 3','QUAN_1','300x600',3,400,'Phi Yến','0234568333','Tây Bắc','1',50,NULL,'300','700','300','300',NULL,'700','50','80','5 năm',NULL,20.00,'TANG_TRET',NULL,NULL,NULL,NULL,'2022-08-03 11:19:23','2022-08-03 11:19:23','phiyen91','phiyen91'),(135,'Hoàng Anh Gia Lai 2','123 Ngô Quyền','Phường 8','QUAN_6','300x500',3,500,'Phi Yến','0234568333','Nam','2',20,NULL,'400','200','200','300',NULL,'500','30','20','10 năm',NULL,30.00,'NGUYEN_CAN',NULL,NULL,NULL,NULL,'2022-08-03 11:20:48','2022-08-03 11:20:48','phiyen91','phiyen91'),(136,'Điện Máy Xanh','35 Nguyễn Thị Đinh','Phường 9','QUAN_6','200x300',1,300,'Quốc Bảo','0234568322','Đông','1',30,NULL,'','200','','',NULL,'600','','40','5 năm',NULL,NULL,'TANG_TRET',NULL,NULL,NULL,NULL,'2022-08-03 11:22:39','2022-08-03 13:03:08','phiyen91','phiyen91'),(137,'Thế giới di động','140 Quang Trung','','QUAN_5','200x300',3,NULL,'Phi Yến','0234568333','Bắc','2',20,NULL,'','500','','',NULL,'','30','','',NULL,NULL,'',NULL,NULL,NULL,NULL,'2022-08-03 11:23:42','2022-08-03 13:03:02','phiyen91','phiyen91'),(138,'Yamaha 2','115 Văn Bi','','','200x300',1,NULL,'Phi Yến','0234568333','Bắc','3',30,NULL,'300','','300','',NULL,'','','20','',NULL,NULL,'TANG_TRET,NGUYEN_CAN',NULL,NULL,NULL,NULL,'2022-08-03 11:26:02','2022-08-03 21:34:17','phiyen91','khanhlinh94'),(139,'Nam Giao 2','18 Nguyễn Thị Minh Khai','','QUAN_TAN_BINH','350x250',2,500,'Nguyễn Văn A','0234568321','Bắc','2',30,NULL,'','','','',NULL,'','','','',NULL,20.00,'',NULL,NULL,NULL,NULL,'2022-08-03 11:27:05','2022-08-03 21:34:09','phiyen91','khanhlinh94'),(140,'Nam Giao 3','120 Quang Trung','','QUAN_5','400x370',1,500,'Nguyễn Văn A','0234568321','Tây','3',20,NULL,'','','','200',NULL,'','','50','',NULL,20.00,'',NULL,NULL,NULL,NULL,NULL,'2022-08-03 13:04:49',NULL,'phiyen91'),(141,'VinTower','60 Văn Bi','phường 11','QUAN_12','320x250',3,300,'Khánh Linh','0234568244','Nam','1',40,NULL,'','','300','',NULL,'','','40','',NULL,NULL,'NGUYEN_CAN',NULL,NULL,NULL,NULL,NULL,'2022-08-03 22:22:41',NULL,'khanhlinh94'),(142,'Yamaha','30 Ngô Quyền','phường 3','QUAN_1','350x410',2,NULL,'Quốc Bảo','0234568322','Đông','1',50,NULL,'','','','200',NULL,'','','','',NULL,NULL,'TANG_TRET',NULL,NULL,NULL,NULL,NULL,'2022-08-03 13:04:14',NULL,'phiyen91'),(143,'Petro','130 Nguyễn Thị Minh Khai','phường 5','QUAN_4','250x450',1,NULL,'Phi Yến','0234568333','Đông','2',30,NULL,'','','','',NULL,'600','','40','',NULL,20.00,'NGUYEN_CAN',NULL,NULL,NULL,NULL,'2022-08-03 11:31:17','2022-08-03 13:02:17','phiyen91','phiyen91'),(144,'Hoàng Anh Gia Lai','265 Lê Văn Việt','phường 2','QUAN_BINH_THANH','400x500',2,NULL,'Khánh Linh','0234568244','Tây','1',50,NULL,'400','','','300',NULL,'500','30','','',NULL,20.00,'NOI_THAT,TANG_TRET',NULL,NULL,NULL,NULL,'2022-08-03 16:34:19','2022-08-03 17:31:06','phiyen91','phiyen91'),(145,'Petro','112 Lê Duẩn','Phường 6','QUAN_12','200x300',2,300,'Nguyễn Văn A','0234568321','Nam','1',40,NULL,'','','','',NULL,'','','','',NULL,20.00,'NOI_THAT,TANG_TRET',NULL,NULL,NULL,NULL,'2022-08-03 16:35:42','2022-08-03 17:31:13','phiyen91','phiyen91'),(146,'Lanmark 81','58 Điện Biên Phủ','phường 7','QUAN_TAN_BINH','200x300',1,500,'Quốc Bảo','0234568322','Tây','3',20,NULL,'300','200','200','200',NULL,'','','40','',NULL,20.00,'NOI_THAT,TANG_TRET',NULL,NULL,NULL,NULL,'2022-08-03 16:37:02','2022-08-03 17:30:52','phiyen91','phiyen91'),(147,'Thế giới di động','184 Cao Thắng','phường 2','QUAN_1','400x500',2,NULL,'Phi Yến','0234568333','Đông','2',30,NULL,'','500','','300',NULL,'','30','40','5 năm',NULL,20.00,'TANG_TRET',NULL,NULL,NULL,NULL,'2022-08-03 16:39:00','2022-08-03 17:30:41','phiyen91','phiyen91');
/*!40000 ALTER TABLE `building` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `demand` varchar(255) DEFAULT NULL,
  `companyname` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (50,'Hoa Vinh','0234568756','hoa@gmail.com','300,400,600','Hoa Vinh','trung tam tp',NULL,'2022-07-20 15:23:50',NULL,'phiyen91'),(51,'Hoai Thu','0234568753','hoai@gmail.com','300, 400','HT','Q2','2022-06-22 12:39:12','2022-07-20 15:23:40','nguyenvana','phiyen91'),(52,'Thuy Vy','0234568752','Thuy@gmail.com','500','TV','Q2, Q3','2022-06-22 12:39:42','2022-06-22 12:41:45','nguyenvana','nguyenvana'),(53,'Nam Cao','0395890390','NamC@gmail.com','500 m2','Nam Cao Entertaiment','Q1, Q2',NULL,'2022-07-20 15:23:34',NULL,'phiyen91'),(55,'Bùi Hùng','0321548687','HungMock@gmail.com','400','MockUniverse','Khách hàng mới','2022-07-18 22:46:39','2022-07-18 22:46:57','quocbao00','quocbao00'),(56,'Hoàng Diệu','0254321546','DieuDieu@vn.com','400','HoangDieu','Qua môi giới','2022-07-18 22:50:17','2022-07-20 15:23:23','quocbao00','phiyen91'),(59,'Hoang Nham','0704343423','pu89@gmail.com','400','hyosung','Q2, Q3','2022-07-31 17:17:34','2022-08-02 20:51:12','phiyen91','phiyen91'),(60,'Thanh Nhàn','0704913023','thanhnhan@edu.com','500 m2','Prime Cookie','start up','2022-08-02 20:49:31','2022-08-02 20:51:18','phiyen91','phiyen91'),(62,'Thái Úy','0704913091','0704913091','400','Thành Phát','Q1, Q2','2022-08-03 20:52:28','2022-08-03 22:23:23','khanhlinh94','khanhlinh94'),(63,'Ngô Hồng Hạnh','0704913233','newstore@app.com','400','New App Store','Q1, Q2','2022-08-03 20:53:50','2022-08-03 22:23:36','khanhlinh94','khanhlinh94'),(64,'Bùi Gia Huy','0704913211','iphonelock@app.com','450','Táo Mỹ','Q1, Q3','2022-08-03 20:55:06','2022-08-03 22:24:06','khanhlinh94','khanhlinh94'),(65,'Hồ Văn Cường','0704912211','vietstudio@app.com','450','Việt Studio','Q2','2022-08-03 20:55:40','2022-08-03 22:23:45','khanhlinh94','khanhlinh94'),(66,'Ngô Mỹ Trinh','0702212211','trinh@lawyer.com','350','Lawyer Miền Nam','Q5','2022-08-03 20:57:49','2022-08-03 22:23:55','khanhlinh94','khanhlinh94');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rentarea`
--

DROP TABLE IF EXISTS `rentarea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rentarea` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `value` int(11) DEFAULT NULL,
  `buildingid` bigint(20) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rentarea_building` (`buildingid`),
  CONSTRAINT `rentarea_building` FOREIGN KEY (`buildingid`) REFERENCES `building` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rentarea`
--

LOCK TABLES `rentarea` WRITE;
/*!40000 ALTER TABLE `rentarea` DISABLE KEYS */;
INSERT INTO `rentarea` VALUES (113,200,2,'2022-06-22 21:28:15','2022-06-22 21:28:15','nguyenvana','nguyenvana'),(114,300,2,'2022-06-22 21:28:15','2022-06-22 21:28:15','nguyenvana','nguyenvana'),(115,400,2,'2022-06-22 21:28:15','2022-06-22 21:28:15','nguyenvana','nguyenvana'),(118,200,59,'2022-06-22 21:30:28','2022-06-22 21:30:28','nguyenvana','nguyenvana'),(119,500,59,'2022-06-22 21:30:28','2022-06-22 21:30:28','nguyenvana','nguyenvana'),(120,300,3,'2022-06-22 21:31:24','2022-06-22 21:31:24','nguyenvana','nguyenvana'),(121,400,3,'2022-06-22 21:31:24','2022-06-22 21:31:24','nguyenvana','nguyenvana'),(122,500,3,'2022-06-22 21:31:24','2022-06-22 21:31:24','nguyenvana','nguyenvana'),(123,100,4,'2022-06-22 21:32:13','2022-06-22 21:32:13','nguyenvana','nguyenvana'),(124,400,4,'2022-06-22 21:32:13','2022-06-22 21:32:13','nguyenvana','nguyenvana'),(125,300,4,'2022-06-22 21:32:13','2022-06-22 21:32:13','nguyenvana','nguyenvana'),(135,500,72,'2022-08-02 20:41:05','2022-08-02 20:41:05','phiyen91','phiyen91'),(141,350,71,'2022-08-03 08:39:14','2022-08-03 08:39:14','phiyen91','phiyen91'),(142,450,71,'2022-08-03 08:39:14','2022-08-03 08:39:14','phiyen91','phiyen91'),(143,400,134,'2022-08-03 11:19:23','2022-08-03 11:19:23','phiyen91','phiyen91'),(144,200,135,'2022-08-03 11:20:48','2022-08-03 11:20:48','phiyen91','phiyen91'),(145,500,135,'2022-08-03 11:20:48','2022-08-03 11:20:48','phiyen91','phiyen91'),(146,350,136,'2022-08-03 11:22:39','2022-08-03 11:22:39','phiyen91','phiyen91'),(147,450,136,'2022-08-03 11:22:39','2022-08-03 11:22:39','phiyen91','phiyen91'),(148,400,143,'2022-08-03 11:31:17','2022-08-03 11:31:17','phiyen91','phiyen91'),(149,200,144,'2022-08-03 16:34:19','2022-08-03 16:34:19','phiyen91','phiyen91'),(150,500,144,'2022-08-03 16:34:19','2022-08-03 16:34:19','phiyen91','phiyen91'),(151,500,145,'2022-08-03 16:35:42','2022-08-03 16:35:42','phiyen91','phiyen91'),(152,200,146,'2022-08-03 16:37:02','2022-08-03 16:37:02','phiyen91','phiyen91'),(153,300,146,'2022-08-03 16:37:02','2022-08-03 16:37:02','phiyen91','phiyen91'),(154,400,147,'2022-08-03 16:39:00','2022-08-03 16:39:00','phiyen91','phiyen91'),(155,100,1,'2022-08-03 17:29:53','2022-08-03 17:29:53','phiyen91','phiyen91'),(156,200,1,'2022-08-03 17:29:54','2022-08-03 17:29:54','phiyen91','phiyen91');
/*!40000 ALTER TABLE `rentarea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Quản lý','manager',NULL,NULL,NULL,NULL),(2,'Nhân viên','staff',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `transaction` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `note` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `customerid` bigint(20) NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_customer_transaction` (`customerid`),
  CONSTRAINT `fk_customer_transaction` FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (73,'Cafe với kh','QUA_TRINH_CSKH',50,'2022-06-22 12:40:25','2022-06-22 12:40:25','nguyenvana','nguyenvana'),(74,'4 sao','DANH_GIA_CUA_KH',50,'2022-06-22 12:40:44','2022-06-22 12:40:44','nguyenvana','nguyenvana'),(75,'Xem tại Q1','DAN_DI_XEM',53,'2022-06-24 14:24:33','2022-06-24 14:24:33','nguyenvana','nguyenvana'),(76,'Xem tại Q2','DAN_DI_XEM',53,'2022-06-24 14:24:50','2022-06-24 14:24:50','nguyenvana','nguyenvana'),(77,'4 sao','DANH_GIA_CUA_KH',53,'2022-06-24 14:25:10','2022-06-24 14:25:10','nguyenvana','nguyenvana'),(78,'Dẫn đi đăng kí','QUA_TRINH_CSKH',50,'2022-07-07 15:55:13','2022-07-07 15:55:13','nguyenvanb','nguyenvanb'),(79,'Dẫn đi xem tại Q1','QUA_TRINH_CSKH',56,'2022-07-18 22:51:56','2022-07-18 22:51:56','quocbao00','quocbao00'),(80,'4 sao','DANH_GIA_CUA_KH',56,'2022-07-18 22:52:12','2022-07-18 22:52:12','quocbao00','quocbao00'),(84,'Đi xem tại Quận 7','DAN_DI_XEM',59,'2022-08-02 20:54:19','2022-08-02 20:54:19','phiyen91','phiyen91'),(85,'Chỉ dẫn các địa điểm trung tâm ','QUA_TRINH_CSKH',59,'2022-08-02 20:56:20','2022-08-02 20:56:20','phiyen91','phiyen91');
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactiontype`
--

DROP TABLE IF EXISTS `transactiontype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `transactiontype` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `code` varchar(45) NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactiontype`
--

LOCK TABLES `transactiontype` WRITE;
/*!40000 ALTER TABLE `transactiontype` DISABLE KEYS */;
INSERT INTO `transactiontype` VALUES (1,'Quá trình cskh','cskh',NULL,NULL,NULL,NULL),(2,'Dẫn đi xem','review',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `transactiontype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'nguyenvana','$2a$10$h4MhaFbK0IDZTHh4aqv.be6CwyNOjSNYUD98Y3bFjb7v/wjtFq2cu','nguyen van a',NULL,NULL,1,NULL,'2022-07-08 09:14:05',NULL,'nguyenvana'),(2,'nguyenvanb','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','Nguyễn Văn B',NULL,NULL,1,NULL,'2022-07-10 16:31:18',NULL,'quocbao00'),(3,'nguyenvanc','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyen van c',NULL,NULL,1,NULL,'2022-06-10 09:22:22',NULL,'nguyenvana'),(4,'nguyenvand','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyen van d',NULL,NULL,0,NULL,'2022-07-18 22:54:03',NULL,'quocbao00'),(10,'thunguyen','$2a$10$AxzK0SMWqx85/gFsfoOigumcy940/QgfSRNPlvHyzv8/i9Ixlgyp2','nguyen thi thu',NULL,NULL,0,'2022-07-08 09:15:08','2022-07-08 17:10:47','nguyenvanb','quocbao00'),(11,'thanhhuyen99','$2a$10$XjRR6RZ8FgEFIL2pW.wqwe6yb3eWWjDOLjSLHbwoYLPnqYm8zPUTy','Trần Thanh Huyền',NULL,NULL,1,NULL,'2022-07-08 12:26:16',NULL,'nguyenvana'),(12,'quocbao00','$2a$10$ucI5oT3wsghCYgn7mgIKSeR1naWFkbkLXgXBPYG/Dir8R6amglZC6','Ngô Quốc Bảo',NULL,NULL,1,'2022-07-08 12:27:23','2022-07-10 17:40:33','nguyenvana','quocbao00'),(13,'thaihoa97','$2a$10$TlYm4FMWpBuEXqNtUWX9r.QvVh0zIKA.tulSN9gq3WO1OAD1GSYGu','Hoàng Thanh Thái Hòa',NULL,NULL,1,NULL,'2022-08-03 22:26:34',NULL,'khanhlinh94'),(14,'thuyhoa95','$2a$10$Uce1bTxkYILY3WbrQrSiceM.AuVwBixxePyp0XqxF34uoo7JxJtYu','Trần Thúy Hoa',NULL,NULL,1,'2022-07-08 12:29:54','2022-07-08 12:29:54','quocbao00','quocbao00'),(15,'cattuong11','$2a$10$oJafHOzC3SYhoASC4Zk1nusyDmyZLohCh/JGQEiv19k7wbHZh7Mf.','Vũ Cát Tường',NULL,NULL,1,'2022-07-08 12:32:01','2022-07-08 17:10:47','quocbao00','quocbao00'),(16,'nguyenvu96','$2a$10$UE/TJ2PBeURq4mknl2doeu7SrWB9EPxTJi9iXPAiwZSCls3poaFgq','Nguyễn Vi Vũ',NULL,NULL,1,NULL,'2022-08-02 20:57:03',NULL,'phiyen91'),(17,'thanhcong92','$2a$10$DEGJqhGPcUMxqWAGduuHrOpM5ysbAn07p8c2rp627K0XSNXLCH6sy','Thái Thành Công',NULL,NULL,1,'2022-07-08 12:34:22','2022-07-10 17:17:44','quocbao00','quocbao00'),(18,'tuelam94','$2a$10$hFHK/uDSaYTwZtyP3bZQiuR6inN96Sh5IB3gpzef/s2uUz.TdYeOG','Đỗ Thành Tuệ Lâm',NULL,NULL,1,'2022-07-08 12:35:34','2022-07-10 17:20:15','quocbao00','quocbao00'),(19,'hoangnam93','$2a$10$/V/ShfTTtsEND87r1lnFOOPXdtVKY0EdVjezhgpwxss1V7OFPWgo6','Trần Hoàng Nam',NULL,NULL,1,'2022-07-09 20:49:59','2022-07-10 17:27:41','quocbao00','quocbao00'),(21,'thanhthao99','$2a$10$B8Z.SkbaLDjTSFneVZrM/uTFR8DKdET23MlEiFm2L9sjE2L1bqpzC','Võ Thanh Thảo',NULL,NULL,1,'2022-07-09 20:52:30','2022-07-10 15:59:51','quocbao00','anonymousUser'),(22,'giabao99','$2a$10$De3oRoxqybb19SzhhKHze.lGqwvvjRWZjG0AatjmNI6gF2ABeUf1S','Ngô Gia Bảo',NULL,NULL,1,'2022-07-10 12:28:36','2022-07-10 15:59:51','quocbao00','anonymousUser'),(23,'khanhlinh94','$2a$10$J1wprGCA8lRQcmnGnJ3ZEOVKIgerSnCU2ZFo4VehnX6uIgGABsTqa','Đỗ Khánh Linh',NULL,NULL,1,'2022-07-10 17:29:17','2022-08-03 22:28:16','quocbao00','khanhlinh94'),(24,'huyhoang93','$2a$10$Z.JgjZty4bUPCz2qZXG0eOmBozFjw.hOWThxAVJC4RnjQrLvyEaPC','Huy Hoàng',NULL,NULL,1,'2022-07-10 17:30:05','2022-07-10 17:31:54','khanhlinh94','khanhlinh94'),(25,'phinhung94','$2a$10$SGHnbIPWViCOTakzs3JvMOPQrAfJow6aeNgsGn/4ngQ/neYbjgjuK','Hứa Phi Nhung',NULL,NULL,1,NULL,'2022-07-21 12:20:19',NULL,'phiyen91'),(26,'hoangyen95','$2a$10$R231JRpZwOknqtm4mVJ8zOef5HVlsbCJlbNua/wbno.0Y9u2p6wo6','Hoàng Yến',NULL,NULL,1,NULL,'2022-08-03 08:56:10',NULL,'phiyen91'),(27,'laibang98','$2a$10$AxM5iDRVX7f20f6PFKAGXeoQYy8B012kGcoA.DXY3B87AwOl8YMaS','Lai Bâng',NULL,NULL,1,'2022-07-10 17:31:14','2022-07-10 17:31:54','khanhlinh94','khanhlinh94'),(28,'phiyen91','$2a$10$jBznWw0orHxa8yj5lp9JaeGAOCAFM28SOcK7y2fGq/JzFlbMGQhMm','Võ Phi Yến',NULL,NULL,1,'2022-07-18 22:53:25','2022-07-19 22:28:28','quocbao00','phiyen91'),(29,'thanhthanh','$2a$10$tCzBTCjRdjA1cGZ6/rtAXe.pPknoWowaHfJNfpRVVYTbCYPNqMaye','Trương Thanh Thanh',NULL,NULL,1,'2022-07-19 21:06:21','2022-07-19 21:06:21','phiyen91','phiyen91'),(30,'hangnga93','$2a$10$MZWTQNwfeeAL4gPXTKhaT.G/Ol6LN8z3LPffMHmchHaz./obdILC6','Đỗ Thị Hằng Nga',NULL,NULL,1,NULL,'2022-07-21 12:18:22',NULL,'phiyen91'),(31,'thanhtruc95','$2a$10$D8vZnEhhRNTxQ4H7xZOwBusbuQwcBTxp02YmeEnriP8OVChiT/.iW','Dương Thanh Trúc',NULL,NULL,1,NULL,'2022-07-21 12:22:36',NULL,'phiyen91'),(32,'thuthao22','$2a$10$AZSWt/mq4Y7VqtJ4luVdfOK0TN1uOGht8XDg5OS67kkSOqbYRA48G','Thái Thị Thu Thảo',NULL,NULL,1,'2022-07-31 17:18:55','2022-07-31 17:18:55','phiyen91','phiyen91'),(33,'tt','$2a$10$LGqxCr4wtmkp.GTUMm9tHuS1obfMfBP8Tn4yhrkkb004nkNwbi29O','tttt',NULL,NULL,0,'2022-08-03 22:25:36','2022-08-03 22:25:50','khanhlinh94','khanhlinh94');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleid` bigint(20) NOT NULL,
  `userid` bigint(20) NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_role` (`userid`),
  KEY `fk_role_user` (`roleid`),
  CONSTRAINT `fk_role_user` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`),
  CONSTRAINT `fk_user_role` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (3,2,3,NULL,NULL,NULL,NULL),(4,2,4,NULL,NULL,NULL,NULL),(5,1,1,NULL,NULL,NULL,NULL),(6,2,10,NULL,NULL,NULL,NULL),(8,2,11,NULL,NULL,NULL,NULL),(9,1,12,NULL,NULL,NULL,NULL),(11,2,14,NULL,NULL,NULL,NULL),(12,2,15,NULL,NULL,NULL,NULL),(14,2,17,NULL,NULL,NULL,NULL),(15,2,18,NULL,NULL,NULL,NULL),(16,2,19,NULL,NULL,NULL,NULL),(17,2,21,NULL,NULL,NULL,NULL),(18,2,22,NULL,NULL,NULL,NULL),(19,2,2,NULL,NULL,NULL,NULL),(20,1,23,NULL,NULL,NULL,NULL),(21,2,24,NULL,NULL,NULL,NULL),(24,2,27,NULL,NULL,NULL,NULL),(26,1,28,NULL,NULL,NULL,NULL),(27,2,29,NULL,NULL,NULL,NULL),(34,2,30,NULL,NULL,NULL,NULL),(36,2,25,NULL,NULL,NULL,NULL),(38,2,31,NULL,NULL,NULL,NULL),(39,2,16,NULL,NULL,NULL,NULL),(41,2,26,NULL,NULL,NULL,NULL),(42,2,32,NULL,NULL,NULL,NULL),(43,2,33,NULL,NULL,NULL,NULL),(44,2,13,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-03 23:05:12
