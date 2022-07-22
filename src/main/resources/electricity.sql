-- MySQL dump 10.13  Distrib 8.0.29, for Linux (x86_64)
--
-- Host: localhost    Database: elec
-- ------------------------------------------------------
-- Server version	8.0.29-0ubuntu0.20.04.3

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
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill` (
  `billid` int NOT NULL,
  `bconntype` varchar(255) DEFAULT NULL,
  `board` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `energy` int NOT NULL,
  `meter` int NOT NULL,
  `metertype` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `id` int DEFAULT NULL,
  PRIMARY KEY (`billid`),
  KEY `FKs338hvflmihyqv5y354s7vpas` (`id`),
  CONSTRAINT `FKs338hvflmihyqv5y354s7vpas` FOREIGN KEY (`id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (30,'domestic','Andhra Pradesh','2022-05-05',15,5643,'2Kw','abc',151.35,'not paid',1),(31,'domestic','Andhra Pradesh','2022-04-15',19,5643,'2Kw','abc',191.71,'not paid',1),(139,'domestic','Andhra Pradesh','2022-01-13',11,5643,'2Kw','abc',110.99,'not paid',1),(143,'domestic','Andhra Pradesh','2022-02-10',19,5741,'2Kw','Harry',191.71,'not paid',2),(146,'domestic','Andhra Pradesh','2022-01-14',11,5741,'2Kw','Harry',110.99,'not paid',2),(151,'domestic','Bihar','2022-03-18',17,2345,'5Kw','shivani',228.64999999999998,'not paid',147),(153,'domestic','Chandigarh','2022-07-15',56,3442,'3Kw','pragya',664.7199999999999,'not paid',149),(155,'domestic','Karnataka','2022-07-22',37,2567,'3Kw','khyati',513.9300000000001,'not paid',150),(156,'domestic','Chandigarh','2022-06-16',15,3442,'3Kw','pragya',178.04999999999998,'not paid',149),(160,'domestic','Karnataka','2022-04-14',19,2567,'3Kw','khyati',263.91,'not paid',150),(161,'domestic','Karnataka','2022-05-19',54,2567,'3Kw','khyati',750.0600000000001,'not paid',150);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consumption`
--

DROP TABLE IF EXISTS `consumption`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consumption` (
  `id` int NOT NULL,
  `energy` int NOT NULL,
  `month` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consumption`
--

LOCK TABLES `consumption` WRITE;
/*!40000 ALTER TABLE `consumption` DISABLE KEYS */;
INSERT INTO `consumption` VALUES (140,82,'january'),(144,34,'febrauary'),(152,17,'march'),(154,93,'july'),(157,15,'june'),(159,34,'april'),(162,54,'may');
/*!40000 ALTER TABLE `consumption` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int NOT NULL,
  `board` varchar(255) DEFAULT NULL,
  `conntype` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `meter` int DEFAULT NULL,
  `metertype` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_7ursluensqnu1rjcur2jlac7k` (`meter`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Andhra Pradesh','domestic','9871234589','abc@mail.com',5643,'2Kw','abc','1234','ROLE_ADMIN'),(2,'Andhra Pradesh','domestic','9871234561','harry@mail.com',5741,'2Kw','Harry','1234','ROLE_USER'),(147,'Bihar','domestic','9871234567','shivani@mail.com',2345,'5Kw','shivani','1234','ROLE_USER'),(148,'Bihar','domestic','9871234567','smith@mail.com',9876,'2Kw','smith','1234','ROLE_USER'),(149,'Chandigarh','domestic','9871234567','pragya@mail.com',3442,'3Kw','pragya','1234','ROLE_USER'),(150,'Karnataka','domestic','9871234567','khyati@mail.com',2567,'3Kw','khyati','1234','ROLE_USER');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (163);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rate`
--

DROP TABLE IF EXISTS `rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rate` (
  `rid` int NOT NULL,
  `board` varchar(255) DEFAULT NULL,
  `conntype` varchar(255) DEFAULT NULL,
  `metertype` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rate`
--

LOCK TABLES `rate` WRITE;
/*!40000 ALTER TABLE `rate` DISABLE KEYS */;
INSERT INTO `rate` VALUES (6,'Andhra Pradesh','domestic','2Kw',10.09),(7,'Bihar','domestic','2Kw',10.13),(8,'Andhra Pradesh','domestic','4Kw',10.16),(9,'Andhra Pradesh','domestic','5Kw',11.16),(10,'Andhra Pradesh','commercial','2Kw',11.07),(25,'Andhra Pradesh','commercial','5Kw',11.17),(26,'Andhra Pradesh','commercial','3Kw',11.98),(44,'Goa','domestic','3Kw',12.11),(89,'Bihar','domestic','5Kw',13.45),(90,'Bihar','domestic','2Kw',12.34),(91,'Andhra Pradesh','commercial','4Kw',12.9),(92,'Karnataka','domestic','3Kw',13.89),(104,'Bihar','domestic','3Kw',11.18),(106,'Arunachal Pradesh','domestic','3Kw',11.11),(108,'Andhra Pradesh','commercial','4Kw',11.13),(109,'Chandigarh','domestic','3Kw',11.87);
/*!40000 ALTER TABLE `rate` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-22 16:24:47
