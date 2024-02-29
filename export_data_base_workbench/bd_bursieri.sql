-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: bd
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bursieri`
--

DROP TABLE IF EXISTS `bursieri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bursieri` (
  `codbur` int NOT NULL,
  `nr_matricol` int NOT NULL,
  UNIQUE KEY `nr_matricol_UNIQUE` (`nr_matricol`),
  KEY `codbur_idx` (`codbur`),
  KEY `nr_matricol_idx` (`nr_matricol`),
  CONSTRAINT `codbur` FOREIGN KEY (`codbur`) REFERENCES `tip_bursa` (`codbur`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `nr_matricol` FOREIGN KEY (`nr_matricol`) REFERENCES `elev` (`nr_matricol`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bursieri`
--

LOCK TABLES `bursieri` WRITE;
/*!40000 ALTER TABLE `bursieri` DISABLE KEYS */;
INSERT INTO `bursieri` VALUES (2,1102),(2,1103),(2,1106),(2,1111),(2,1116),(2,1117),(2,1121),(2,1126),(2,1131),(2,1137),(2,1138),(2,1141),(2,1146),(2,1151),(2,1199),(3,1101),(3,1136),(4,1118),(5,1132),(5,1133),(5,1147),(5,1152),(6,1122),(6,1142),(6,1143),(6,2223),(7,1127);
/*!40000 ALTER TABLE `bursieri` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-29 11:47:56
