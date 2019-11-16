-- MySQL dump 10.13  Distrib 8.0.15, for macos10.14 (x86_64)
--
-- Host: localhost    Database: DLRTM_DB
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `clients` (
  `clientID` varchar(45) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `homePhone` varchar(45) DEFAULT NULL,
  `businessPhone` varchar(45) DEFAULT NULL,
  `alternatePhone` varchar(45) DEFAULT NULL,
  `mobilePhone` varchar(45) DEFAULT NULL,
  `primaryContactPhone` varchar(45) DEFAULT NULL,
  `primaryEmail` varchar(255) DEFAULT NULL,
  `alternateEmail` varchar(255) DEFAULT NULL,
  `billingAddress` varchar(255) DEFAULT NULL,
  `shippingAddress` varchar(255) DEFAULT NULL,
  `alternateAddress` varchar(255) DEFAULT NULL,
  `deliveryAddress` varchar(255) DEFAULT NULL,
  `clientUrgency` float DEFAULT NULL,
  `clientValue` float DEFAULT NULL,
  `clientStatus` varchar(255) DEFAULT NULL,
  `clientSpecialMentions` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`clientID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES ('0001','Jason Smith','555-888-6767','555-888-6767','555-888-6767','555-888-6767','555-888-6767','jason.smith@gmail.com','jason.smith@gmail.com','1421 E 23rd St, Chicago, IL, 60615','1421 E 23rd St, Chicago, IL, 60615','1421 E 23rd St, Chicago, IL, 60615','1421 E 23rd St, Chicago, IL, 60615',5,5,NULL,'good customer'),('0002','Jake Wyler','555-888-6767','555-888-6767','555-888-6767','555-888-6767','555-888-6767','jason.smith@gmail.com','jason.smith@gmail.com','1421 E 23rd St, Chicago, IL, 60615','1421 E 23rd St, Chicago, IL, 60615','1421 E 23rd St, Chicago, IL, 60615','1421 E 23rd St, Chicago, IL, 60615',5,5,NULL,'bad customer'),('0003','Betty Boop','555-888-6767','555-888-6767','555-888-6767','555-888-6767','555-888-6767','jason.smith@gmail.com','jason.smith@gmail.com','1421 E 23rd St, Chicago, IL, 60615','1421 E 23rd St, Chicago, IL, 60615','1421 E 23rd St, Chicago, IL, 60615','1421 E 23rd St, Chicago, IL, 60615',5,5,NULL,'good customer'),('0004','Will Smith','555-888-6767','555-888-6767','555-888-6767','555-888-6767','555-888-6767','jason.smith@gmail.com','jason.smith@gmail.com','1421 E 23rd St, Chicago, IL, 60615','1421 E 23rd St, Chicago, IL, 60615','1421 E 23rd St, Chicago, IL, 60615','1421 E 23rd St, Chicago, IL, 60615',5,5,NULL,'bad customer'),('0005','Jason Lee','555-888-6767','555-888-6767','555-888-6767','555-888-6767','555-888-6767','jason.smith@gmail.com','jason.smith@gmail.com','1421 E 23rd St, Chicago, IL, 60615','1421 E 23rd St, Chicago, IL, 60615','1421 E 23rd St, Chicago, IL, 60615','1421 E 23rd St, Chicago, IL, 60615',5,5,NULL,'bad customer'),('0006','Mike Oldfield','555-888-6767','555-888-6767','555-888-6767','555-888-6767','555-888-6767','jason.smith@gmail.com','jason.smith@gmail.com','1421 E 23rd St, Chicago, IL, 60615','1421 E 23rd St, Chicago, IL, 60615','1421 E 23rd St, Chicago, IL, 60615','1421 E 23rd St, Chicago, IL, 60615',5,5,NULL,'good customer');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymentCards`
--

DROP TABLE IF EXISTS `paymentCards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `paymentCards` (
  `cardID` int(11) NOT NULL AUTO_INCREMENT,
  `cardNumber` varchar(45) DEFAULT NULL,
  `nameOnCard` varchar(255) DEFAULT NULL,
  `cardExpirationDate` varchar(45) DEFAULT NULL,
  `CVC` varchar(10) DEFAULT NULL,
  `clientID` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cardID`),
  KEY `clientID` (`clientID`),
  CONSTRAINT `paymentcards_ibfk_1` FOREIGN KEY (`clientID`) REFERENCES `clients` (`clientID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymentCards`
--

LOCK TABLES `paymentCards` WRITE;
/*!40000 ALTER TABLE `paymentCards` DISABLE KEYS */;
INSERT INTO `paymentCards` VALUES (1,'1234 4321 5678 0987','Jason Smith','10/14/20','665','0001'),(2,'1234 4321 5678 0987','Jake Wyler','10/14/20','665','0002'),(3,'1234 4321 5678 0987','Betty Boop','10/14/20','665','0003'),(4,'1234 4321 5678 0987','Will Smith','10/14/20','665','0004'),(5,'1234 4321 5678 0987','Jason Lee','10/14/20','665','0005'),(6,'1234 4321 5678 0987','Mike Oldfield','10/14/20','665','0006');
/*!40000 ALTER TABLE `paymentCards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `products` (
  `productID` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(50) DEFAULT NULL,
  `manufacturer` char(50) DEFAULT NULL,
  `country` char(50) DEFAULT NULL,
  `description` char(150) DEFAULT NULL,
  `unitPrice` float DEFAULT NULL,
  `discounts` float DEFAULT NULL,
  `specialOffers` char(50) DEFAULT NULL,
  `itemsInStockInt` int(11) DEFAULT NULL,
  `specialMentions` char(150) DEFAULT NULL,
  PRIMARY KEY (`productID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Blender','Phillips','Netherlands','food blender',20,NULL,'Free Bread Knife',100,'Pending recalls'),(2,'Mixer','Sony','Japan','food mixer',47.8,NULL,'10% off blades',180,'best in class'),(3,'Grinder','Sanyo','South Korea','coffee grinder',33,NULL,'free CD player',60,'new model'),(4,'Coffee Maker','JVC','Germany','coffee maker',22,NULL,'5 year warranty',10,'buyer\'s favorite'),(5,'Coffee Shaker','Sunny','China','coffee flaker',13,NULL,'nada',666,'flyer\'s delite'),(6,'XRay Machine','IBM','USA','XRAY machine',2,NULL,'yoyoy',0,'\"5 year warranty\"heavy duty');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `transactions` (
  `transactionID` int(11) NOT NULL AUTO_INCREMENT,
  `clientRef` varchar(255) DEFAULT NULL,
  `productIDs` char(255) DEFAULT NULL,
  `transactionStatus` varchar(255) DEFAULT NULL,
  `transactionSpecialMentions` varchar(255) DEFAULT NULL,
  `transactionDate` date DEFAULT NULL,
  PRIMARY KEY (`transactionID`),
  KEY `clientRef` (`clientRef`),
  CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`clientRef`) REFERENCES `clients` (`clientID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES (1,'0004','2','done','got a mixer','2019-11-16');
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-16 10:24:59
