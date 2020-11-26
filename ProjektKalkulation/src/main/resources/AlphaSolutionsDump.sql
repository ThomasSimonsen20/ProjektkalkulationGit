 -- MySQL dump 10.13  Distrib 8.0.21, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: AlphaSolutions
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `Employees`
--

DROP TABLE IF EXISTS `Employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Employees` (
  `Employee_Id` int NOT NULL AUTO_INCREMENT,
  `First_Name` varchar(50) NOT NULL,
  `Last_Name` varchar(100) NOT NULL,
  `Profile_Picture` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`Employee_Id`),
  UNIQUE KEY `Employee_Id_UNIQUE` (`Employee_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Employees`
--

LOCK TABLES `Employees` WRITE;
/*!40000 ALTER TABLE `Employees` DISABLE KEYS */;
/*!40000 ALTER TABLE `Employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ProjectParcipitants`
--

DROP TABLE IF EXISTS `ProjectParcipitants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ProjectParcipitants` (
  `Project_Id` int NOT NULL,
  `Employee_Id` int NOT NULL,
  `Role` varchar(100) NOT NULL,
  PRIMARY KEY (`Project_Id`,`Employee_Id`,`Role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ProjectParcipitants`
--

LOCK TABLES `ProjectParcipitants` WRITE;
/*!40000 ALTER TABLE `ProjectParcipitants` DISABLE KEYS */;
/*!40000 ALTER TABLE `ProjectParcipitants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Projects`
--

DROP TABLE IF EXISTS `Projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Projects` (
  `Project_Id` int NOT NULL AUTO_INCREMENT,
  `Project_Name` varchar(100) NOT NULL,
  `Project_Description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`Project_Id`),
  UNIQUE KEY `Project_Id_UNIQUE` (`Project_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Projects`
--

LOCK TABLES `Projects` WRITE;
/*!40000 ALTER TABLE `Projects` DISABLE KEYS */;
/*!40000 ALTER TABLE `Projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Skills`
--

DROP TABLE IF EXISTS `Skills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Skills` (
  `Employee_Id` int NOT NULL,
  `Skill` varchar(100) NOT NULL,
  KEY `_idx` (`Employee_Id`),
  CONSTRAINT `Employee_Id` FOREIGN KEY (`Employee_Id`) REFERENCES `Employees` (`Employee_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Skills`
--

LOCK TABLES `Skills` WRITE;
/*!40000 ALTER TABLE `Skills` DISABLE KEYS */;
/*!40000 ALTER TABLE `Skills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SubProjects`
--

DROP TABLE IF EXISTS `SubProjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SubProjects` (
  `SubProject_Id` int NOT NULL AUTO_INCREMENT,
  `Project_Id` int NOT NULL,
  `SubProject_Name` varchar(100) NOT NULL,
  `SubProject_Description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`SubProject_Id`),
  UNIQUE KEY `SubProject_Id_UNIQUE` (`SubProject_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SubProjects`
--

LOCK TABLES `SubProjects` WRITE;
/*!40000 ALTER TABLE `SubProjects` DISABLE KEYS */;
/*!40000 ALTER TABLE `SubProjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SubProjectsEstimatetWorkHours`
--

DROP TABLE IF EXISTS `SubProjectsEstimatetWorkHours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SubProjectsEstimatetWorkHours` (
  `SubProject_Id` int NOT NULL,
  `EstimatetWorkHours` double NOT NULL,
  UNIQUE KEY `SubProject_Id_UNIQUE` (`SubProject_Id`),
  CONSTRAINT `SubProject_Id` FOREIGN KEY (`SubProject_Id`) REFERENCES `SubProjects` (`SubProject_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SubProjectsEstimatetWorkHours`
--

LOCK TABLES `SubProjectsEstimatetWorkHours` WRITE;
/*!40000 ALTER TABLE `SubProjectsEstimatetWorkHours` DISABLE KEYS */;
/*!40000 ALTER TABLE `SubProjectsEstimatetWorkHours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SubTaskEstimatetWorkHours`
--

DROP TABLE IF EXISTS `SubTaskEstimatetWorkHours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SubTaskEstimatetWorkHours` (
  `Subtask_Id` int NOT NULL,
  `EstimatetWorkHours` double NOT NULL,
  KEY `SubTask_Id_idx` (`Subtask_Id`),
  CONSTRAINT `SubTask_Id` FOREIGN KEY (`Subtask_Id`) REFERENCES `SubTasks` (`SubTask_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SubTaskEstimatetWorkHours`
--

LOCK TABLES `SubTaskEstimatetWorkHours` WRITE;
/*!40000 ALTER TABLE `SubTaskEstimatetWorkHours` DISABLE KEYS */;
/*!40000 ALTER TABLE `SubTaskEstimatetWorkHours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SubTasks`
--

DROP TABLE IF EXISTS `SubTasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SubTasks` (
  `SubTask_Id` int NOT NULL AUTO_INCREMENT,
  `Task_Id` int NOT NULL,
  `SubTask_Description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`SubTask_Id`),
  UNIQUE KEY `SubTask_Id_UNIQUE` (`SubTask_Id`),
  KEY `Task_Id_idx` (`Task_Id`),
  CONSTRAINT `Task_Id_FKSub` FOREIGN KEY (`Task_Id`) REFERENCES `Tasks` (`Task_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SubTasks`
--

LOCK TABLES `SubTasks` WRITE;
/*!40000 ALTER TABLE `SubTasks` DISABLE KEYS */;
/*!40000 ALTER TABLE `SubTasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tasks`
--

DROP TABLE IF EXISTS `Tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Tasks` (
  `Task_Id` int NOT NULL AUTO_INCREMENT,
  `SubProject_Id` int NOT NULL,
  `Task_Description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`Task_Id`),
  UNIQUE KEY `Task_Id_UNIQUE` (`Task_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tasks`
--

LOCK TABLES `Tasks` WRITE;
/*!40000 ALTER TABLE `Tasks` DISABLE KEYS */;
/*!40000 ALTER TABLE `Tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TasksEstimatetWorkHours`
--

DROP TABLE IF EXISTS `TasksEstimatetWorkHours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TasksEstimatetWorkHours` (
  `Task_Id` int NOT NULL,
  `EstimatetWorkHours` varchar(45) DEFAULT NULL,
  UNIQUE KEY `Task_Id_UNIQUE` (`Task_Id`),
  CONSTRAINT `Task_Id` FOREIGN KEY (`Task_Id`) REFERENCES `Tasks` (`Task_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TasksEstimatetWorkHours`
--

LOCK TABLES `TasksEstimatetWorkHours` WRITE;
/*!40000 ALTER TABLE `TasksEstimatetWorkHours` DISABLE KEYS */;
/*!40000 ALTER TABLE `TasksEstimatetWorkHours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TaskTakers`
--

DROP TABLE IF EXISTS `TaskTakers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TaskTakers` (
  `Task_Id` int NOT NULL,
  `Employee_Id` int NOT NULL,
  PRIMARY KEY (`Employee_Id`,`Task_Id`),
  KEY `Task_Id_idx` (`Task_Id`),
  CONSTRAINT `Employee_Id_FK` FOREIGN KEY (`Employee_Id`) REFERENCES `Employees` (`Employee_Id`),
  CONSTRAINT `Task_Id_FK` FOREIGN KEY (`Task_Id`) REFERENCES `Tasks` (`Task_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TaskTakers`
--

LOCK TABLES `TaskTakers` WRITE;
/*!40000 ALTER TABLE `TaskTakers` DISABLE KEYS */;
/*!40000 ALTER TABLE `TaskTakers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-26 21:06:36
