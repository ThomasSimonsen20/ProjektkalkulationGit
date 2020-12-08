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
INSERT INTO `employees` VALUES (1,'Søren','Sørensen',NULL,1234,NULL),(2,'Mike','Jensen',NULL,3411,NULL),(3,'Sean','Pearsen',NULL,5622,NULL),(4,'Ole','Henriksen',NULL,7611,NULL),(5,'Michael','Henningensen',NULL,6533,NULL),(6,'Ulla','Mogensen',NULL,8766,NULL),(7,'Sabine','Sleif',NULL,1223,NULL),(8,'Trine','Poulsen',NULL,4352,NULL),(9,'Magrethe','Egebo',NULL,3244,NULL),(10,'Stine','Arresø',NULL,4322,NULL);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projectparcipitants`
--

DROP TABLE IF EXISTS `projectparcipitants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `projectparcipitants` (
  `Project_Id` int NOT NULL,
  `Employee_Id` int NOT NULL,
  `Role` varchar(100) NOT NULL,
  `ProjectEstimatetWorkHours` double DEFAULT NULL,
  PRIMARY KEY (`Project_Id`,`Employee_Id`,`Role`),
  KEY `Employee_Id_idx` (`Employee_Id`),
  CONSTRAINT `Employee_Id_ProPar` FOREIGN KEY (`Employee_Id`) REFERENCES `employees` (`Employee_Id`),
  CONSTRAINT `Project_Id_PP` FOREIGN KEY (`Project_Id`) REFERENCES `projects` (`Project_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projectparcipitants`
--

LOCK TABLES `projectparcipitants` WRITE;
/*!40000 ALTER TABLE `projectparcipitants` DISABLE KEYS */;
/*!40000 ALTER TABLE `projectparcipitants` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (7,'Alpha Solution','Skal lave kalkulationsværktøj'),(8,'Project 2','Project 2 descrip'),(9,'Project 3','Project 3 descrip');
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
  CONSTRAINT `Project_Id_SP` FOREIGN KEY (`Project_Id`) REFERENCES `projects` (`Project_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subprojects`
--

LOCK TABLES `subprojects` WRITE;
/*!40000 ALTER TABLE `subprojects` DISABLE KEYS */;
INSERT INTO `subprojects` VALUES (22,7,'Loginshit','lav loginshit'),(23,8,'SubProject 2','SubProject 2 Descrip'),(24,9,'SubProject 3','SubProject 3 Descrip');
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
  CONSTRAINT `SubProject_Id` FOREIGN KEY (`SubProject_Id`) REFERENCES `subprojects` (`SubProject_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subprojectsestimatetworkhours`
--

LOCK TABLES `subprojectsestimatetworkhours` WRITE;
/*!40000 ALTER TABLE `subprojectsestimatetworkhours` DISABLE KEYS */;
INSERT INTO `subprojectsestimatetworkhours` VALUES (1,22,12),(2,22,11),(3,22,222),(4,22,65);
/*!40000 ALTER TABLE `subprojectsestimatetworkhours` ENABLE KEYS */;
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
  CONSTRAINT `SubTask_Id` FOREIGN KEY (`Subtask_Id`) REFERENCES `subtasks` (`SubTask_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subtaskestimatetworkhours`
--

LOCK TABLES `subtaskestimatetworkhours` WRITE;
/*!40000 ALTER TABLE `subtaskestimatetworkhours` DISABLE KEYS */;
INSERT INTO `subtaskestimatetworkhours` VALUES (1,8,0),(2,9,0);
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
  PRIMARY KEY (`SubTask_Id`),
  UNIQUE KEY `SubTask_Id_UNIQUE` (`SubTask_Id`),
  KEY `Task_Id_idx` (`Task_Id`),
  KEY `Project_Id_ST_idx` (`Project_Id`),
  CONSTRAINT `Project_Id_ST` FOREIGN KEY (`Project_Id`) REFERENCES `projects` (`Project_Id`),
  CONSTRAINT `Task_Id_ST` FOREIGN KEY (`Task_Id`) REFERENCES `tasks` (`Task_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subtasks`
--

LOCK TABLES `subtasks` WRITE;
/*!40000 ALTER TABLE `subtasks` DISABLE KEYS */;
INSERT INTO `subtasks` VALUES (4,8,'LOGIIIIIIIIIIIIIIIIN WOOOOOOOOOOOOOO KOM NUUUUUUUUUUUUU',7),(5,9,'Subtask 2 Description',8),(6,10,'Subtask 3 Description',9),(7,10,'Subtask 3a Description',9),(8,8,'SubSUbSUB',7),(9,8,'Nyny subtask',7);
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
  CONSTRAINT `Task_Dependency_Id_TD` FOREIGN KEY (`TaskDependency_Id`) REFERENCES `tasks` (`Task_Id`),
  CONSTRAINT `Task_Id_TD` FOREIGN KEY (`Task_Id`) REFERENCES `tasks` (`Task_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taskdependencies`
--

LOCK TABLES `taskdependencies` WRITE;
/*!40000 ALTER TABLE `taskdependencies` DISABLE KEYS */;
INSERT INTO `taskdependencies` VALUES (8,17),(20,17),(8,18),(8,20);
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
  CONSTRAINT `Project_Id_Tasks` FOREIGN KEY (`Project_Id`) REFERENCES `projects` (`Project_Id`),
  CONSTRAINT `SubProject_Id_Tasks` FOREIGN KEY (`SubProject_Id`) REFERENCES `subprojects` (`SubProject_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks`
--

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
INSERT INTO `tasks` VALUES (8,7,22,'mere loginshit','alt for meget loginshit'),(9,8,23,'Task 2','Task 2 Descrip'),(10,9,24,'Task 3','Task 3 Descrip'),(17,7,22,'Rediger HP','Gør det flot'),(18,7,22,'Udfyld CSS','Blå farver'),(19,7,22,'Tøm Skraldespand','Sæt ny pose i bagefter'),(20,7,22,'Ny Task','Dette er en helt ny Task'),(21,7,22,'siadte task','jeg lavede en slåfejl i SIDSTE');
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
  CONSTRAINT `Task_Id` FOREIGN KEY (`Task_Id`) REFERENCES `tasks` (`Task_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasksestimatetworkhours`
--

LOCK TABLES `tasksestimatetworkhours` WRITE;
/*!40000 ALTER TABLE `tasksestimatetworkhours` DISABLE KEYS */;
/*!40000 ALTER TABLE `tasksestimatetworkhours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasktakers`
--

DROP TABLE IF EXISTS `tasktakers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tasktakers` (
  `Task_Id` int NOT NULL,
  `Employee_Id` int NOT NULL,
  PRIMARY KEY (`Employee_Id`,`Task_Id`),
  KEY `Task_Id_idx` (`Task_Id`),
  CONSTRAINT `Employee_Id_FK` FOREIGN KEY (`Employee_Id`) REFERENCES `employees` (`Employee_Id`),
  CONSTRAINT `Task_Id_FK` FOREIGN KEY (`Task_Id`) REFERENCES `tasks` (`Task_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasktakers`
--

LOCK TABLES `tasktakers` WRITE;
/*!40000 ALTER TABLE `tasktakers` DISABLE KEYS */;
/*!40000 ALTER TABLE `tasktakers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-08 14:15:55
