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
-- Table structure for table `elev`
--

DROP TABLE IF EXISTS `elev`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `elev` (
  `nr_matricol` int NOT NULL,
  `CNP` varchar(13) NOT NULL,
  `nume` varchar(45) NOT NULL,
  `prenume` varchar(45) NOT NULL,
  `nr_telefon` varchar(10) DEFAULT NULL,
  `adresa` varchar(45) NOT NULL,
  `medie` decimal(5,2) NOT NULL,
  `acte_adi` varchar(100) NOT NULL,
  `codclasa` int NOT NULL,
  PRIMARY KEY (`nr_matricol`),
  KEY `codclasa_idx` (`codclasa`),
  CONSTRAINT `codclasa` FOREIGN KEY (`codclasa`) REFERENCES `clasa` (`codclasa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elev`
--

LOCK TABLES `elev` WRITE;
/*!40000 ALTER TABLE `elev` DISABLE KEYS */;
INSERT INTO `elev` VALUES (1101,'5221214017732','Anton','Marius ','0712244982','Str Grivitei nr 4 BlocP4 ap 3',9.20,'CI,CN,DIPOLIMP',110),(1102,'5210417178026','Marcu','Ion','0722344990','Str Maria nr 2 Blocl A2 ap 44',9.56,'CI,CN,FM',110),(1103,'6210425178871','Paeaschiv','Elena','0789223185','Str Henri nr 4 Bloc C4 ap 3',9.88,'CI,CN,FM',110),(1104,'6210709175429','Neculai','Ana','0988223445','Str Matei nr 9 Bloc W4 ap 32',8.92,'CI,CN',110),(1105,'5210725177641','Pantele','Ronaldo','0999222441','Str Alga nr 9 Bloc P4 ap 98',6.77,'CI,CN',110),(1106,'5210725175216','Anela','Andrei','0992345990','Str Alga nr 9 Bloc P4 ap 99',9.69,'CI,CN,FM',120),(1107,'5210707179365','Akena','Ugal','0998234559','Str Busuioc nr 3 Bloc L4 ap 8',7.90,'CI,CN',120),(1108,'6210707177312','Porumb','Aneta','0924882881','Str Busuioc nr 3 Bloc L4 ap 12',5.66,'CI,CN',120),(1109,'6210707178250','Salin','Viorica','0234889221','Str Busuioc nr 3 Bloc L4 ap 13',8.98,'CI,CN',120),(1110,'6210715178121','Sandaleni','Ionela','0742336778','Str Busuioc nr 3 Bloc L4 ap 19',9.47,'CI,CN',120),(1111,'5211008175323','Buhoino','Alex','0721667223','Str Arbore nr 92 Bloc H2 ap 20',9.88,'CI,CN,FM',130),(1112,'5211008175501','Agon','Mirandi','0799652134','Str Arbore nr 92 Bloc H2 ap 21',7.23,'CI,CN',130),(1113,'6211021176329','Geano','Antonia','0766552551','Str Busuioc nr 3 Bloc L4 ap 17',7.99,'CI,CN',130),(1114,'6211021177515','Vintilo','Pebela','0789221331','Str Amaterasu nr 69 Bloc S4 ap 99',6.66,'CI,CN',130),(1115,'6211023179911','Poseidon ','Angelina','0799667553','Str Amaterasu nr 69 Bloc S4 ap 120',7.77,'CI,CN',130),(1116,'6211216178467','Dinero','Anabela','0788664321','Str Enel nr 33 Bloc L44 ap 122',9.51,'CI,CN,FM',140),(1117,'5211216178094','Analog','Marius','0788990220','Str Enel nr 4 Bloc L24 ap 56\n',9.88,'CI,CN,FM',140),(1118,'5211216177991','Nistor','Abel','0788221884','Str Busuioc nr 23 Bloc T4 ap 12\n',7.99,'CI,CN,AD',140),(1119,'6211201178169','Anabel','Ana','0755662662','Str Ancora nr 22 Bloc LI99 ap 76',7.79,'CI,CN',140),(1120,'6211217178558','Ancora','Minodora','0799233677','Str Ancora nr 323 Bloc PI ap 55\n',9.30,'CI,CN',140),(1121,'6011206178450','Lukoil','Lucia','0722889221','Str Busuioc nr 3 Bloc L4 ap 19',9.88,'CI,CN,FM',150),(1122,'6011215176564','Ionade','Erica','0788990457','Str Busuioc nr 3 Bloc L4 ap 30',9.00,'CI,CN,ANAF',150),(1123,'5011215175632','Palade','Nicu','0754771889','Str Maraton nr 23 Bloc A22 ap 23',9.20,'CI,CN',150),(1124,'5011215175173','Galato','Jean','0755667885','Str Kula nr 3 Bloc L4 ap 12',8.43,'CI,CN',150),(1125,'5011206177190','Olina','Matei','0722887667','Str Martie  nr 6  Bloc M6 ap 66\n',6.99,'CI,CN',150),(1126,'5011116178223','Anakin','Skywalker','0799000990','Str Stea nr 99  Bloc DE6 ap 99\n',9.89,'CI,CN,FM',160),(1127,'6011122177164','Anatolie','Patricia','0755288990','Str Inima nr 3 Bloc L4 ap 12\n',8.77,'CI,CN,ACH',160),(1128,'5011122175507','Popice','Alex','0788661224','Str Bowling nr 9  Bloc P4 ap 44\n',7.53,'CI,CN',160),(1129,'6010615178801','Sancez','Julia','0788221442','Str Nasture nr 23 Bloc N4 ap 45\n',6.88,'CI,CN',160),(1130,'6010615176330','Divin','Maria','0725255255','Str Sfant nr 25 Bloc C6 ap 1\n',9.00,'CI,CN',160),(1131,'6011006176871','Mandora','Madalina','0776221551','Str Cuza nr 5 Bloc L4 ap 28\n',9.62,'CI,CN,FM',170),(1132,'5011018176918','Eremia','Tudor','0777889001','Str Busuioc nr 3 Bloc L4 ap 12',8.88,'CI,CN,AF,DE',170),(1133,'5011019175871','Arenda','Mitica','0778221882','Str Bus nr 3 Bloc L4 ap 12\n',8.89,'CI,CN,AF,DE',170),(1134,'6011019177893','Uite','Anais','0766543213','Str Olimp nr 23 Bloc O4 ap 45\n',9.24,'CI,CN',170),(1135,'6010510178580','Floare','Carmen','0777666222','Str Ancora nr 3 Bloc L4 ap 12',9.24,'CI,CN',170),(1136,'6010228177227','Vorca','Ina','0772113221','Str Berei nr 1  Bloc 5L ap 66\n',10.00,'CI,CN,DIPOLIMP',180),(1137,'5010217175514','Marca','Ion','0776221666','Str Apa nr 3 Bloc L4 ap 12\n',9.88,'CI,CN,FM',180),(1138,'6010223175641','Aka','Kalash','0747756756','Str Arma nr 47 Bloc L30 ap 1\n',9.77,'CI,CN,FM',180),(1139,'6010223177426','Durea','Maria','0772277888','Str Busuioc nr 3 Bloc L4 ap 88\n',5.00,'CI,CN',180),(1140,'5010815177856','Ducu','Beleaua','0722772772','Str Mare Belea nr 69 Bloc B4 ap 67\n',6.66,'CI,CN',180),(1141,'6011222177803','Andrei','AnaMaria','0722445667','Str Busuioc nr 3 Bloc L4 ap 12\n',9.89,'CI,CN,FM',190),(1142,'6011223179359','Popa','Camelia','0772667889','Str Anetei nr 3 Bloc P4 ap 12\n',7.00,'CI,CN,ANAF',190),(1143,'5011223176626','Albertini','Nicolas','0778998778','Str Alba nr 32 Bloc H4 ap 12\n',6.82,'CI,CN,ANAF',190),(1144,'6011223175521','Iordan','Mara','0772662664','Str Busuioc nr 3 Bloc M4 ap 12\n',8.99,'CI,CN',190),(1145,'6011227175459','Ignat','Lucia','0772221229','Str Cort nr 2 Bloc Y4 ap 12\n',9.00,'CI,CN',190),(1146,'6011222179313','Prodan','Maia','0776987221','Str Palmier nr 3 Bloc L4 ap 12\n',9.88,'CI,CN,FM',200),(1147,'5011222179522','Anita','Andrei','0772112772','Str Pui nr 3 Bloc L4 ap 55\n',8.00,'CI,CN,AF,DE',200),(1148,'5011222179215','Ritu','Florin','0778221229','Str Busuioc nr 7 BlocL O4 ap 52\n',9.00,'CI,CN',200),(1149,'6011222175420','Palade','Ernesta','0755443221','Str Pufului nr 3 Bloc L4 ap 12\n',8.00,'CI,CN',200),(1150,'5011222179442','Nelu','Cortea','0778223445','Str Pantof nr 43 Bloc L8 ap 12\n',9.20,'CI,CN',200),(1151,'6011222179786','Paliu','Maria','0733445667','Str Bis nr 39 Bloc N4 ap 22\n',9.88,'CI,CN,FM',210),(1152,'6010420176351','Marta','Teona','0772421998','Str Busuioc nr 3 Bloc L4 ap 76\n',9.00,'CI,CN,AF,DE',210),(1153,'5010420177706','Timis','Paul','0786775665','Str Busuioc nr 3 Bloc L4 ap 77\n',9.22,'CI,CN',210),(1154,'5010422178666','Albu','Anto','0722114222','Str Busuioc nr 3 Bloc L4 ap 88\n',8.88,'CI,CN',210),(1155,'5010424175623','Negru','Dan','0772772882','Str Revelion nr31  Bloc A4 ap 1\n',9.42,'CI,CN',210),(1166,'5221216017754','Matol','Ghenea','0722445995','strada Otel nr 12 Bl j5',8.22,'CI,CN',190),(1199,'5221216017759','Gama','Alfa','0788990990','str Henri nr 8, bl J6 ap 22',9.88,'CI,CN,FM',190),(2222,'5221216017755','Matol','Giani','0722445996','strada Otel nr 12 Bl j5',9.23,'CI,CN',190),(2223,'5221216017756','Ionut','Gramar','075224225','Str Copiilor nr 22',9.22,'CI,CN,ANAF',200);
/*!40000 ALTER TABLE `elev` ENABLE KEYS */;
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
