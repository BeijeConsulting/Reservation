CREATE DATABASE  IF NOT EXISTS `BeijeReservations` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `BeijeReservations`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: reservation-test.cvzu4xrxvkdz.eu-south-1.rds.amazonaws.com    Database: BeijeReservations
-- ------------------------------------------------------
-- Server version	8.0.23

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `street` varchar(45) NOT NULL,
  `number` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `province` varchar(45) NOT NULL,
  `cap` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `structure_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `company_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_address_building1_idx` (`structure_id`),
  KEY `fk_address_user1_idx` (`user_id`),
  KEY `fk_address_company1_idx` (`company_id`),
  CONSTRAINT `fk_address_building1` FOREIGN KEY (`structure_id`) REFERENCES `structure` (`id`),
  CONSTRAINT `fk_address_company1` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`),
  CONSTRAINT `fk_address_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'via G.Verdi','4','Milano','Milano','20121','Italy','sede operativa',1,NULL,NULL),(2,'via F.Bianchi','12','Como','Como','20332','Italy','sede operativa',2,NULL,NULL),(3,'via M.Rossi','69','Milano','Milano','20121','Italy','sede legale',NULL,NULL,1),(4,'via Franceschini','86','Torino','Torino','30812','Italy','sede operativa',3,NULL,NULL),(5,'via Legale','45','Lodi','Lodi','20871','Italy','sede  legale',NULL,NULL,2),(6,'via Illegale','2','Monza','Monza','21870','Italy','sede operativa',4,NULL,NULL),(7,'via della Fame','8','Genova','Genova','24569','Italy','sede operativa',5,NULL,NULL),(8,'via dei Bergamaschi','18','Bergamo','Bergamo','25089','Italy','sede operativa ',6,NULL,NULL),(9,'via dei Balocchi','20','Padova','Padova','34812','Italy','sede legale',NULL,NULL,3);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authority`
--

DROP TABLE IF EXISTS `authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authority` (
  `id` int NOT NULL,
  `authority_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority`
--

LOCK TABLES `authority` WRITE;
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` VALUES (1,'CUSTOMER'),(2,'HOST'),(3,'ADMIN');
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `id` int NOT NULL AUTO_INCREMENT,
  `business_name` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  `manager_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'Hilton','Albergo','Alfredo Jan'),(2,'Virgin Active','Compagnia di complessi sportivi','Antonio Pompato'),(3,'Il Bisteccone','Catena di bracerie','Francesco Affamato');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice` (
  `id` int NOT NULL AUTO_INCREMENT,
  `reservation_id` int NOT NULL,
  `payment_method` varchar(45) NOT NULL,
  `total` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_invoice_reservation1_idx` (`reservation_id`),
  CONSTRAINT `fk_invoice_reservation1` FOREIGN KEY (`reservation_id`) REFERENCES `reservation` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES (1,1,'Contanti',10),(3,4,'Carta debito/credito',10),(4,5,'Carta debito/credito',200),(5,6,'Carta debito/credito',2000),(6,7,'Carta debito/credito',2000);
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `price`
--

DROP TABLE IF EXISTS `price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `price` (
  `id` int NOT NULL,
  `amount` varchar(45) DEFAULT NULL,
  `service_id` int NOT NULL,
  `price_type_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_price_service1_idx` (`service_id`),
  KEY `fk_price_price_type1_idx` (`price_type_id`),
  CONSTRAINT `fk_price_price_type1` FOREIGN KEY (`price_type_id`) REFERENCES `price_type` (`id`),
  CONSTRAINT `fk_price_service1` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price`
--

LOCK TABLES `price` WRITE;
/*!40000 ALTER TABLE `price` DISABLE KEYS */;
INSERT INTO `price` VALUES (1,'15',1,1),(2,'80',1,2),(3,'300',1,3),(4,'1800',1,4),(5,'10',1,5),(6,'10',1,6),(7,'5',1,7),(8,'3',2,1),(9,'10',2,2),(10,'25',2,3),(11,'200',2,4);
/*!40000 ALTER TABLE `price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `price_type`
--

DROP TABLE IF EXISTS `price_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `price_type` (
  `id` int NOT NULL,
  `type_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price_type`
--

LOCK TABLES `price_type` WRITE;
/*!40000 ALTER TABLE `price_type` DISABLE KEYS */;
INSERT INTO `price_type` VALUES (1,'giornaliero'),(2,'settimanale'),(3,'mensile'),(4,'annuale'),(5,'mattina'),(6,'pomeridiano'),(7,'serale'),(8,'unitario');
/*!40000 ALTER TABLE `price_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `service_id` int NOT NULL,
  `start` datetime NOT NULL,
  `end` datetime NOT NULL,
  `person_number` int DEFAULT NULL,
  `price_type_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_reservation_user1_idx` (`user_id`),
  KEY `fk_reservation_service1_idx` (`service_id`),
  KEY `fk_reservation_price_type1_idx` (`price_type_id`),
  CONSTRAINT `fk_reservation_price_type1` FOREIGN KEY (`price_type_id`) REFERENCES `price_type` (`id`),
  CONSTRAINT `fk_reservation_service1` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`),
  CONSTRAINT `fk_reservation_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (1,1,2,'2021-03-23 09:00:00','2021-03-30 20:00:00',1,2),(4,1,2,'2021-03-24 09:00:00','2021-03-31 20:00:00',1,2),(5,1,2,'2021-03-24 09:00:00','2021-03-31 20:00:00',1,4),(6,1,2,'2021-03-24 09:00:00','2021-03-31 20:00:00',10,4),(7,1,2,'2021-03-24 09:00:00','2021-03-31 20:00:00',10,4);
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service` (
  `id` int NOT NULL AUTO_INCREMENT,
  `open_date` date DEFAULT NULL,
  `close_date` date DEFAULT NULL,
  `open_time` varchar(45) DEFAULT NULL,
  `close_time` varchar(45) DEFAULT NULL,
  `available_places` int NOT NULL,
  `total_places` int NOT NULL,
  `structure_id` int NOT NULL,
  `open` tinyint NOT NULL,
  `service_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_service_structure1_idx` (`structure_id`),
  CONSTRAINT `fk_service_structure1` FOREIGN KEY (`structure_id`) REFERENCES `structure` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (1,NULL,NULL,NULL,NULL,50,50,3,1,'piscina'),(2,NULL,NULL,NULL,NULL,80,80,3,0,'palestra');
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `structure`
--

DROP TABLE IF EXISTS `structure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `structure` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `structure_email` varchar(45) NOT NULL,
  `telephone_number` varchar(20) NOT NULL,
  `company_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_structure_company1_idx` (`company_id`),
  CONSTRAINT `fk_structure_company1` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `structure`
--

LOCK TABLES `structure` WRITE;
/*!40000 ALTER TABLE `structure` DISABLE KEYS */;
INSERT INTO `structure` VALUES (1,'Hilton Hotel Milan','hiltonmilan@hotel.com','0267851234',1),(2,'Hilton Hotel Como Lake','hiltoncomo@hotel.com','0245808992',1),(3,'World of fitenss','worldfitness@virgin.com','0437683010',2),(4,'Dalla padella alla brace','padella@bisteccone.com','0813475583',3),(5,'Borgo Antico','anticoborgo@bisteccone.com','0812333455',3),(6,'Dal Carnefice','carnefice@bisteccone.com','0823455661',3);
/*!40000 ALTER TABLE `structure` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_email` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `codice_fiscale` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `company_id` int DEFAULT NULL,
  `vat_number` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codice_fiscale_UNIQUE` (`codice_fiscale`),
  UNIQUE KEY `email_UNIQUE` (`user_email`),
  KEY `fk_user_company1_idx` (`company_id`),
  CONSTRAINT `fk_user_company1` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'d.persico@live.it','Davide','Persico','DVDPRSCFTTRSS','$2a$10$pNZ5yGUFCp/Jq0UU3Iw76epRvBYcexBv6uXDWHfDox4mMGPXCAcee',NULL,NULL),(2,'f.jan@live.it','Faheem','Jan','FJNCCC','$2a$10$pNZ5yGUFCp/Jq0UU3Iw76epRvBYcexBv6uXDWHfDox4mMGPXCAcee',NULL,NULL),(3,'f.meizzi@live.it','Fausto','Meizzi','FMZZUEJD','$2a$10$pNZ5yGUFCp/Jq0UU3Iw76epRvBYcexBv6uXDWHfDox4mMGPXCAcee',NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_authority`
--

DROP TABLE IF EXISTS `user_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_authority` (
  `user_id` int NOT NULL,
  `authority_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`authority_id`),
  KEY `fk_user_has_role_role1_idx` (`authority_id`),
  KEY `fk_user_has_role_user1_idx` (`user_id`),
  CONSTRAINT `fk_user_has_role_role1` FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`),
  CONSTRAINT `fk_user_has_role_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_authority`
--

LOCK TABLES `user_authority` WRITE;
/*!40000 ALTER TABLE `user_authority` DISABLE KEYS */;
INSERT INTO `user_authority` VALUES (1,1),(2,1),(1,2),(1,3);
/*!40000 ALTER TABLE `user_authority` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-25 12:52:58
