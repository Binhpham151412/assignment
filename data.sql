-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: assignment
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `dich_vu`
--

DROP TABLE IF EXISTS `dich_vu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dich_vu` (
  `maDV` varchar(255) NOT NULL,
  `donGia` varchar(255) DEFAULT NULL,
  `donViTinh` int NOT NULL,
  `tenDV` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`maDV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dich_vu`
--

LOCK TABLES `dich_vu` WRITE;
/*!40000 ALTER TABLE `dich_vu` DISABLE KEYS */;
INSERT INTO `dich_vu` VALUES ('DV001','10000',0,'Mỳ tôm trứng'),('DV002','5000',0,'Sting'),('DV003','30000',0,'COMBO1'),('DV004','1600000',0,'Massage'),('DV005','5000000',0,'COMBO tối thượng'),('DV006','500000',0,'Qua Đêm');
/*!40000 ALTER TABLE `dich_vu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khach_hang`
--

DROP TABLE IF EXISTS `khach_hang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khach_hang` (
  `maKH` varchar(255) NOT NULL,
  `diaChi` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `soDT` varchar(255) DEFAULT NULL,
  `tenKH` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`maKH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khach_hang`
--

LOCK TABLES `khach_hang` WRITE;
/*!40000 ALTER TABLE `khach_hang` DISABLE KEYS */;
INSERT INTO `khach_hang` VALUES ('KH00001','leauge of legens','yasuo@gmail.com','0852115223','Yasuo'),('KH00002','VietNam','yorn@gmail.com','0981221111','Yorn'),('KH00003','Quang Nam','vayne@gmail.com','0986665333','Vayne'),('KH00004','VietNam','zed@gmail.com','0845557112','Zed'),('KH00005','Da Nang','kayn@gmail.com','0321115448','Kayn');
/*!40000 ALTER TABLE `khach_hang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `may`
--

DROP TABLE IF EXISTS `may`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `may` (
  `maMay` varchar(255) NOT NULL,
  `trangThai` int NOT NULL,
  `viTri` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`maMay`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `may`
--

LOCK TABLES `may` WRITE;
/*!40000 ALTER TABLE `may` DISABLE KEYS */;
INSERT INTO `may` VALUES ('M001',1,'001'),('M002',1,'002'),('M003',2,'003'),('M004',0,'S04'),('M005',1,'M05'),('M006',2,'S06'),('M007',1,'M07'),('M008',1,'M08'),('M009',0,'S09'),('M012',2,'S12');
/*!40000 ALTER TABLE `may` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `su_dung_dich_vu`
--

DROP TABLE IF EXISTS `su_dung_dich_vu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `su_dung_dich_vu` (
  `gioSD` time NOT NULL,
  `ngaySD` date NOT NULL,
  `maDV` varchar(255) NOT NULL,
  `maKH` varchar(255) NOT NULL,
  `soLuong` int NOT NULL,
  PRIMARY KEY (`gioSD`,`ngaySD`,`maDV`,`maKH`),
  KEY `FKbn7kl0a7jigr2dr1xaqr52an3` (`maDV`),
  KEY `FKgui507ujp12llfb2tk4l0cr7x` (`maKH`),
  CONSTRAINT `FKbn7kl0a7jigr2dr1xaqr52an3` FOREIGN KEY (`maDV`) REFERENCES `dich_vu` (`maDV`),
  CONSTRAINT `FKgui507ujp12llfb2tk4l0cr7x` FOREIGN KEY (`maKH`) REFERENCES `khach_hang` (`maKH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `su_dung_dich_vu`
--

LOCK TABLES `su_dung_dich_vu` WRITE;
/*!40000 ALTER TABLE `su_dung_dich_vu` DISABLE KEYS */;
INSERT INTO `su_dung_dich_vu` VALUES ('23:47:44','2023-01-10','DV005','KH00003',1),('23:47:52','2023-01-10','DV003','KH00001',2),('23:48:01','2023-01-10','DV006','KH00005',6),('23:48:13','2023-01-10','DV004','KH00004',6);
/*!40000 ALTER TABLE `su_dung_dich_vu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `su_dung_may`
--

DROP TABLE IF EXISTS `su_dung_may`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `su_dung_may` (
  `gioBDSD` time NOT NULL,
  `ngayBDSD` date NOT NULL,
  `maKH` varchar(255) NOT NULL,
  `maMay` varchar(255) NOT NULL,
  `thoiGianSD` int NOT NULL,
  PRIMARY KEY (`gioBDSD`,`ngayBDSD`,`maKH`,`maMay`),
  KEY `FKspxusjr5hs9d0j8s3f7vjbigq` (`maKH`),
  KEY `FKasxuvxycf13vlike3r62exjvk` (`maMay`),
  CONSTRAINT `FKasxuvxycf13vlike3r62exjvk` FOREIGN KEY (`maMay`) REFERENCES `may` (`maMay`),
  CONSTRAINT `FKspxusjr5hs9d0j8s3f7vjbigq` FOREIGN KEY (`maKH`) REFERENCES `khach_hang` (`maKH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `su_dung_may`
--

LOCK TABLES `su_dung_may` WRITE;
/*!40000 ALTER TABLE `su_dung_may` DISABLE KEYS */;
INSERT INTO `su_dung_may` VALUES ('09:20:57','2023-01-11','KH00004','M012',360),('23:44:18','2023-01-10','KH00003','M009',250),('23:44:40','2023-01-10','KH00003','M009',130),('23:44:50','2023-01-10','KH00002','M006',36);
/*!40000 ALTER TABLE `su_dung_may` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-11  9:31:57
