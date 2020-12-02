-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: alphasolutions
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
-- Table structure for table `employee_skills`
--

DROP TABLE IF EXISTS `Employee_Skills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Employee_Skills` (
  `Employee_Id` int NOT NULL,
  `Skill_Id` int NOT NULL,
  PRIMARY KEY (`Employee_Id`,`Skill_Id`),
  KEY `Skill_Id_idx` (`Skill_Id`),
  CONSTRAINT `Employee_Id` FOREIGN KEY (`Employee_Id`) REFERENCES `Employees` (`Employee_Id`),
  CONSTRAINT `Skill_Id` FOREIGN KEY (`Skill_Id`) REFERENCES `Skills` (`Skill_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_skills`
--

LOCK TABLES `Employee_Skills` WRITE;
/*!40000 ALTER TABLE `Employee_Skills` DISABLE KEYS */;
/*!40000 ALTER TABLE `Employee_Skills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `Employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Employees` (
  `Employee_Id` int NOT NULL AUTO_INCREMENT,
  `First_Name` varchar(50) NOT NULL,
  `Last_Name` varchar(100) NOT NULL,
  `Profile_Picture` varchar(200) DEFAULT NULL,
  `Employee_Number` int NOT NULL,
  PRIMARY KEY (`Employee_Id`),
  UNIQUE KEY `Employee_Id_UNIQUE` (`Employee_Id`),
  UNIQUE KEY `Employee_Number_UNIQUE` (`Employee_Number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `Employees` WRITE;
/*!40000 ALTER TABLE `Employees` DISABLE KEYS */;
/*!40000 ALTER TABLE `Employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projectparcipitants`
--

DROP TABLE IF EXISTS `ProjectParcipitants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ProjectParcipitants` (
  `Project_Id` int NOT NULL,
  `Employee_Id` int NOT NULL,
  `Role` varchar(100) NOT NULL,
  PRIMARY KEY (`Project_Id`,`Employee_Id`,`Role`),
  KEY `Employee_Id_idx` (`Employee_Id`),
  CONSTRAINT `Employee_Id_PP` FOREIGN KEY (`Employee_Id`) REFERENCES `Employees` (`Employee_Id`),
  CONSTRAINT `Project_Id` FOREIGN KEY (`Project_Id`) REFERENCES `Projects` (`Project_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projectparcipitants`
--

LOCK TABLES `ProjectParcipitants` WRITE;
/*!40000 ALTER TABLE `ProjectParcipitants` DISABLE KEYS */;
/*!40000 ALTER TABLE `ProjectParcipitants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projects`
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `Projects` WRITE;
/*!40000 ALTER TABLE `Projects` DISABLE KEYS */;
INSERT INTO `Projects` VALUES (7,'Alpha Solution','Skal lave kalkulationsværktøj');
/*!40000 ALTER TABLE `Projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skills`
--

DROP TABLE IF EXISTS `Skills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Skills` (
  `Skill_Id` int NOT NULL AUTO_INCREMENT,
  `Skill_Description` varchar(200) NOT NULL,
  PRIMARY KEY (`Skill_Id`),
  UNIQUE KEY `Skill_Id_UNIQUE` (`Skill_Id`),
  KEY `_idx` (`Skill_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skills`
--

LOCK TABLES `Skills` WRITE;
/*!40000 ALTER TABLE `Skills` DISABLE KEYS */;
/*!40000 ALTER TABLE `Skills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subprojects`
--

DROP TABLE IF EXISTS `Subprojects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Subprojects` (
  `SubProject_Id` int NOT NULL AUTO_INCREMENT,
  `Project_Id` int NOT NULL,
  `SubProject_Name` varchar(100) NOT NULL,
  `SubProject_Description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`SubProject_Id`),
  UNIQUE KEY `SubProject_Id_UNIQUE` (`SubProject_Id`),
  KEY `Project_Id_idx` (`Project_Id`),
  CONSTRAINT `Project_Id_SP` FOREIGN KEY (`Project_Id`) REFERENCES `projects` (`Project_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subprojects`
--

LOCK TABLES `Subprojects` WRITE;
/*!40000 ALTER TABLE `Subprojects` DISABLE KEYS */;
INSERT INTO `Subprojects` VALUES (22,7,'Loginshit','lav loginshit');
/*!40000 ALTER TABLE `Subprojects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subprojectsestimatetworkhours`
--

DROP TABLE IF EXISTS `SubprojectsEstimatetWorkHours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SubprojectsEstimatetWorkHours` (
  `SubProjectEWH_Id` int NOT NULL,
  `SubProject_Id` int NOT NULL,
  `EstimatetWorkHours` double NOT NULL,
  PRIMARY KEY (`SubProjectEWH_Id`),
  UNIQUE KEY `SubProject_Id_UNIQUE` (`SubProject_Id`),
  UNIQUE KEY `SubProjectEWH_Id_UNIQUE` (`SubProjectEWH_Id`),
  CONSTRAINT `SubProject_Id` FOREIGN KEY (`SubProject_Id`) REFERENCES `Subprojects` (`SubProject_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subprojectsestimatetworkhours`
--

LOCK TABLES `SubprojectsEstimatetWorkHours` WRITE;
/*!40000 ALTER TABLE `SubprojectsEstimatetWorkHours` DISABLE KEYS */;
/*!40000 ALTER TABLE `SubprojectsEstimatetWorkHours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subtaskestimatetworkhours`
--

DROP TABLE IF EXISTS `SubtaskEstimatetWorkHours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SubtaskEstimatetWorkHours` (
  `SubTaskEWH_Id` int NOT NULL AUTO_INCREMENT,
  `Subtask_Id` int NOT NULL,
  `EstimatetWorkHours` double NOT NULL,
  PRIMARY KEY (`SubTaskEWH_Id`),
  UNIQUE KEY `SubTaskEWH_Id_UNIQUE` (`SubTaskEWH_Id`),
  KEY `SubTask_Id_idx` (`Subtask_Id`),
  CONSTRAINT `SubTask_Id` FOREIGN KEY (`Subtask_Id`) REFERENCES `Subtasks` (`SubTask_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subtaskestimatetworkhours`
--

LOCK TABLES `SubtaskEstimatetWorkHours` WRITE;
/*!40000 ALTER TABLE `SubtaskEstimatetWorkHours` DISABLE KEYS */;
/*!40000 ALTER TABLE `SubtaskEstimatetWorkHours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subtasks`
--

DROP TABLE IF EXISTS `Subtasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Subtasks` (
  `SubTask_Id` int NOT NULL AUTO_INCREMENT,
  `Task_Id` int NOT NULL,
  `SubTask_Description` varchar(500) DEFAULT NULL,
  `Project_Id` int NOT NULL,
  PRIMARY KEY (`SubTask_Id`),
  UNIQUE KEY `SubTask_Id_UNIQUE` (`SubTask_Id`),
  KEY `Task_Id_idx` (`Task_Id`),
  KEY `Project_Id_ST_idx` (`Project_Id`),
  CONSTRAINT `Project_Id_ST` FOREIGN KEY (`Project_Id`) REFERENCES `Projects` (`Project_Id`),
  CONSTRAINT `Task_Id_ST` FOREIGN KEY (`Task_Id`) REFERENCES `Tasks` (`Task_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subtasks`
--

LOCK TABLES `Subtasks` WRITE;
/*!40000 ALTER TABLE `Subtasks` DISABLE KEYS */;
INSERT INTO `Subtasks` VALUES (4,8,'LOGIIIIIIIIIIIIIIIIN WOOOOOOOOOOOOOO KOM NUUUUUUUUUUUUU',7);
/*!40000 ALTER TABLE `Subtasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks`
--

DROP TABLE IF EXISTS `Tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Tasks` (
  `Task_Id` int NOT NULL AUTO_INCREMENT,
  `Project_Id` int NOT NULL,
  `SubProject_Id` int NOT NULL,
  `Task_Name` varchar(50) DEFAULT NULL,
  `Task_Description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`Task_Id`),
  UNIQUE KEY `Task_Id_UNIQUE` (`Task_Id`),
  KEY `SubProject_Id_idx` (`SubProject_Id`),
  KEY `Project_Id_Tasks_idx` (`Project_Id`),
  CONSTRAINT `Project_Id_Tasks` FOREIGN KEY (`Project_Id`) REFERENCES `Projects` (`Project_Id`),
  CONSTRAINT `SubProject_Id_Tasks` FOREIGN KEY (`SubProject_Id`) REFERENCES `SubProjects` (`SubProject_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks`
--

LOCK TABLES `Tasks` WRITE;
/*!40000 ALTER TABLE `Tasks` DISABLE KEYS */;
INSERT INTO `Tasks` VALUES (8,7,22,'mere loginshit','alt for meget loginshit');
/*!40000 ALTER TABLE `Tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasksestimatetworkhours`
--

DROP TABLE IF EXISTS `TasksEstimatetWorkHours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TasksEstimatetWorkHours` (
  `TasksEWH_Id` int NOT NULL AUTO_INCREMENT,
  `Task_Id` int NOT NULL,
  `EstimatetWorkHours` double DEFAULT NULL,
  PRIMARY KEY (`TasksEWH_Id`),
  UNIQUE KEY `Task_Id_UNIQUE` (`Task_Id`),
  UNIQUE KEY `TasksEWH_Id_UNIQUE` (`TasksEWH_Id`),
  CONSTRAINT `Task_Id` FOREIGN KEY (`Task_Id`) REFERENCES `Tasks` (`Task_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasksestimatetworkhours`
--

LOCK TABLES `TasksEstimatetWorkHours` WRITE;
/*!40000 ALTER TABLE `TasksEstimatetWorkHours` DISABLE KEYS */;
/*!40000 ALTER TABLE `TasksEstimatetWorkHours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasktakers`
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
-- Dumping data for table `tasktakers`
--

LOCK TABLES `TaskTakers` WRITE;
/*!40000 ALTER TABLE `TaskTakers` DISABLqE KEYS */;
/*!40000 ALTER TABLE `TaskTakers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'alphasolutions'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-01 16:30:52
