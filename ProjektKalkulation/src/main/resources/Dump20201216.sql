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
-- Table structure for table `employee_skills`
--

DROP TABLE IF EXISTS `employee_skills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_skills` (
  `Employee_Id` int NOT NULL,
  `Skill_Id` int NOT NULL,
  PRIMARY KEY (`Employee_Id`,`Skill_Id`),
  KEY `Skill_Id_idx` (`Skill_Id`),
  CONSTRAINT `Employee_Id` FOREIGN KEY (`Employee_Id`) REFERENCES `employees` (`Employee_Id`),
  CONSTRAINT `Skill_Id` FOREIGN KEY (`Skill_Id`) REFERENCES `skills` (`Skill_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_skills`
--

LOCK TABLES `employee_skills` WRITE;
/*!40000 ALTER TABLE `employee_skills` DISABLE KEYS */;
INSERT INTO `employee_skills` VALUES (5,1),(10,1),(1,2),(1,3),(2,3),(9,3),(3,5),(1,6),(5,6),(6,8),(4,9),(7,9),(8,10),(10,10);
/*!40000 ALTER TABLE `employee_skills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `Employee_Id` int NOT NULL AUTO_INCREMENT,
  `First_Name` varchar(50) NOT NULL,
  `Last_Name` varchar(100) NOT NULL,
  `Profile_Picture` varchar(200) DEFAULT NULL,
  `Employee_Number` int NOT NULL,
  `WorkHoursAvailable` double DEFAULT NULL,
  PRIMARY KEY (`Employee_Id`),
  UNIQUE KEY `Employee_Id_UNIQUE` (`Employee_Id`),
  UNIQUE KEY `Employee_Number_UNIQUE` (`Employee_Number`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Søren','Sørensen',NULL,1234,37),(2,'Mike','Jensen',NULL,3411,37),(3,'Sean','Pearsen',NULL,5622,37),(4,'Ole','Henriksen',NULL,7611,37),(5,'Michael','Henningensen',NULL,6533,37),(6,'Ulla','Mogensen',NULL,8766,37),(7,'Sabine','Sleif',NULL,1223,37),(8,'Trine','Poulsen',NULL,4352,37),(9,'Magrethe','Egebo',NULL,3244,37),(10,'Stine','Arresø',NULL,4322,37);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `projects` (
  `Project_Id` int NOT NULL AUTO_INCREMENT,
  `Project_Name` varchar(100) NOT NULL,
  `Project_Description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`Project_Id`),
  UNIQUE KEY `Project_Id_UNIQUE` (`Project_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (12,'Nordea','Lav ny Homebank');
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skills`
--

DROP TABLE IF EXISTS `skills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skills` (
  `Skill_Id` int NOT NULL AUTO_INCREMENT,
  `Skill_Description` varchar(200) NOT NULL,
  PRIMARY KEY (`Skill_Id`),
  UNIQUE KEY `Skill_Id_UNIQUE` (`Skill_Id`),
  KEY `_idx` (`Skill_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skills`
--

LOCK TABLES `skills` WRITE;
/*!40000 ALTER TABLE `skills` DISABLE KEYS */;
INSERT INTO `skills` VALUES (1,'Mac IOS'),(2,'BackEnd'),(3,'FrontEnd'),(4,'Android'),(5,'Linux'),(6,'JUnit Tests'),(7,'CSS'),(8,'HTML'),(9,'Windows'),(10,'ThymeLeaf');
/*!40000 ALTER TABLE `skills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subprojectdependencies`
--

DROP TABLE IF EXISTS `subprojectdependencies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subprojectdependencies` (
  `subProjectDependency_Id` int NOT NULL,
  `subProject_Id` int NOT NULL,
  PRIMARY KEY (`subProjectDependency_Id`,`subProject_Id`),
  KEY `subProject_Id_SPD_idx` (`subProject_Id`),
  CONSTRAINT `subProject_Id_SPD` FOREIGN KEY (`subProject_Id`) REFERENCES `subprojects` (`SubProject_Id`) ON DELETE CASCADE,
  CONSTRAINT `subProjectDependency_Id_SPD` FOREIGN KEY (`subProjectDependency_Id`) REFERENCES `subprojects` (`SubProject_Id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subprojectdependencies`
--

LOCK TABLES `subprojectdependencies` WRITE;
/*!40000 ALTER TABLE `subprojectdependencies` DISABLE KEYS */;
INSERT INTO `subprojectdependencies` VALUES (34,32);
/*!40000 ALTER TABLE `subprojectdependencies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subprojects`
--

DROP TABLE IF EXISTS `subprojects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subprojects` (
  `SubProject_Id` int NOT NULL AUTO_INCREMENT,
  `Project_Id` int NOT NULL,
  `SubProject_Name` varchar(100) NOT NULL,
  `SubProject_Description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`SubProject_Id`),
  UNIQUE KEY `SubProject_Id_UNIQUE` (`SubProject_Id`),
  KEY `Project_Id_idx` (`Project_Id`),
  CONSTRAINT `Project_Id_SP` FOREIGN KEY (`Project_Id`) REFERENCES `projects` (`Project_Id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subprojects`
--

LOCK TABLES `subprojects` WRITE;
/*!40000 ALTER TABLE `subprojects` DISABLE KEYS */;
INSERT INTO `subprojects` VALUES (32,12,'FrontEnd','FE Descrip'),(34,12,'Kundekontakt','KK Descrip'),(35,12,'BackEnd','BE Descrip');
/*!40000 ALTER TABLE `subprojects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subprojectsestimatetworkhours`
--

DROP TABLE IF EXISTS `subprojectsestimatetworkhours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subprojectsestimatetworkhours` (
  `SubProjectEWH_Id` int NOT NULL AUTO_INCREMENT,
  `SubProject_Id` int NOT NULL,
  `EstimatetWorkHours` double NOT NULL,
  PRIMARY KEY (`SubProjectEWH_Id`),
  UNIQUE KEY `SubProjectEWH_Id_UNIQUE` (`SubProjectEWH_Id`),
  KEY `SubProject_Id` (`SubProject_Id`),
  CONSTRAINT `SubProject_Id` FOREIGN KEY (`SubProject_Id`) REFERENCES `subprojects` (`SubProject_Id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subprojectsestimatetworkhours`
--

LOCK TABLES `subprojectsestimatetworkhours` WRITE;
/*!40000 ALTER TABLE `subprojectsestimatetworkhours` DISABLE KEYS */;
INSERT INTO `subprojectsestimatetworkhours` VALUES (7,32,8146),(9,34,4000),(10,35,20);
/*!40000 ALTER TABLE `subprojectsestimatetworkhours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subtaskdependencies`
--

DROP TABLE IF EXISTS `subtaskdependencies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subtaskdependencies` (
  `subtaskdependency_Id` int NOT NULL,
  `subtask_Id` int NOT NULL,
  PRIMARY KEY (`subtaskdependency_Id`,`subtask_Id`),
  KEY `subTask_Id_STD_idx` (`subtask_Id`),
  CONSTRAINT `subTask_Id_STD` FOREIGN KEY (`subtask_Id`) REFERENCES `subtasks` (`SubTask_Id`) ON DELETE CASCADE,
  CONSTRAINT `subTaskDependency_Id_STD` FOREIGN KEY (`subtaskdependency_Id`) REFERENCES `subtasks` (`SubTask_Id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subtaskdependencies`
--

LOCK TABLES `subtaskdependencies` WRITE;
/*!40000 ALTER TABLE `subtaskdependencies` DISABLE KEYS */;
/*!40000 ALTER TABLE `subtaskdependencies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subtaskestimatetworkhours`
--

DROP TABLE IF EXISTS `subtaskestimatetworkhours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subtaskestimatetworkhours` (
  `SubTaskEWH_Id` int NOT NULL AUTO_INCREMENT,
  `Subtask_Id` int NOT NULL,
  `EstimatetWorkHours` double NOT NULL,
  PRIMARY KEY (`SubTaskEWH_Id`),
  UNIQUE KEY `SubTaskEWH_Id_UNIQUE` (`SubTaskEWH_Id`),
  KEY `SubTask_Id_idx` (`Subtask_Id`),
  CONSTRAINT `SubTask_Id` FOREIGN KEY (`Subtask_Id`) REFERENCES `subtasks` (`SubTask_Id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subtaskestimatetworkhours`
--

LOCK TABLES `subtaskestimatetworkhours` WRITE;
/*!40000 ALTER TABLE `subtaskestimatetworkhours` DISABLE KEYS */;
INSERT INTO `subtaskestimatetworkhours` VALUES (9,15,100),(10,16,8000),(11,17,2),(12,18,44),(13,19,4000),(14,20,15);
/*!40000 ALTER TABLE `subtaskestimatetworkhours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subtasks`
--

DROP TABLE IF EXISTS `subtasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subtasks` (
  `SubTask_Id` int NOT NULL AUTO_INCREMENT,
  `Task_Id` int NOT NULL,
  `SubTask_Description` varchar(500) DEFAULT NULL,
  `Project_Id` int NOT NULL,
  `SubTask_Name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`SubTask_Id`),
  UNIQUE KEY `SubTask_Id_UNIQUE` (`SubTask_Id`),
  KEY `Task_Id_idx` (`Task_Id`),
  KEY `Project_Id_ST_idx` (`Project_Id`),
  CONSTRAINT `Project_Id_ST` FOREIGN KEY (`Project_Id`) REFERENCES `projects` (`Project_Id`) ON DELETE CASCADE,
  CONSTRAINT `Task_Id_ST` FOREIGN KEY (`Task_Id`) REFERENCES `tasks` (`Task_Id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subtasks`
--

LOCK TABLES `subtasks` WRITE;
/*!40000 ALTER TABLE `subtasks` DISABLE KEYS */;
INSERT INTO `subtasks` VALUES (15,26,'style topnav Descrip',12,'style topnav'),(16,26,'style footer Descrip',12,'style footer'),(17,27,'T og F Descrip',12,'Topnav og Footer'),(18,27,'Body Descrip',12,'Body'),(19,29,'Descrip Hej',12,'Sig hej til kunden'),(20,29,'Descrip',12,'Giv kunden kaffe');
/*!40000 ALTER TABLE `subtasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taskdependencies`
--

DROP TABLE IF EXISTS `taskdependencies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taskdependencies` (
  `Task_Id` int NOT NULL,
  `TaskDependency_Id` int NOT NULL,
  PRIMARY KEY (`Task_Id`,`TaskDependency_Id`),
  KEY `Task_Dependency_Id_idx` (`TaskDependency_Id`),
  CONSTRAINT `Task_Dependency_Id_TD` FOREIGN KEY (`TaskDependency_Id`) REFERENCES `tasks` (`Task_Id`) ON DELETE CASCADE,
  CONSTRAINT `Task_Id_TD` FOREIGN KEY (`Task_Id`) REFERENCES `tasks` (`Task_Id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taskdependencies`
--

LOCK TABLES `taskdependencies` WRITE;
/*!40000 ALTER TABLE `taskdependencies` DISABLE KEYS */;
/*!40000 ALTER TABLE `taskdependencies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks`
--

DROP TABLE IF EXISTS `tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tasks` (
  `Task_Id` int NOT NULL AUTO_INCREMENT,
  `Project_Id` int NOT NULL,
  `SubProject_Id` int NOT NULL,
  `Task_Name` varchar(50) DEFAULT NULL,
  `Task_Description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`Task_Id`),
  UNIQUE KEY `Task_Id_UNIQUE` (`Task_Id`),
  KEY `SubProject_Id_idx` (`SubProject_Id`),
  KEY `Project_Id_Tasks_idx` (`Project_Id`),
  CONSTRAINT `Project_Id_Tasks` FOREIGN KEY (`Project_Id`) REFERENCES `projects` (`Project_Id`) ON DELETE CASCADE,
  CONSTRAINT `SubProject_Id_Tasks` FOREIGN KEY (`SubProject_Id`) REFERENCES `subprojects` (`SubProject_Id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks`
--

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
INSERT INTO `tasks` VALUES (26,12,32,'Styling','Styling Descrip'),(27,12,32,'Html','Html Descrip'),(29,12,34,'Første møde','Første møde Descrip'),(30,12,35,'Lav Database','Database Descrip');
/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasksestimatetworkhours`
--

DROP TABLE IF EXISTS `tasksestimatetworkhours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tasksestimatetworkhours` (
  `TasksEWH_Id` int NOT NULL AUTO_INCREMENT,
  `Task_Id` int NOT NULL,
  `EstimatetWorkHours` double DEFAULT NULL,
  PRIMARY KEY (`TasksEWH_Id`),
  UNIQUE KEY `Task_Id_UNIQUE` (`Task_Id`),
  UNIQUE KEY `TasksEWH_Id_UNIQUE` (`TasksEWH_Id`),
  CONSTRAINT `Task_Id` FOREIGN KEY (`Task_Id`) REFERENCES `tasks` (`Task_Id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasksestimatetworkhours`
--

LOCK TABLES `tasksestimatetworkhours` WRITE;
/*!40000 ALTER TABLE `tasksestimatetworkhours` DISABLE KEYS */;
INSERT INTO `tasksestimatetworkhours` VALUES (7,26,8100),(8,27,46),(10,29,4000),(11,30,20);
/*!40000 ALTER TABLE `tasksestimatetworkhours` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-16 14:13:59
