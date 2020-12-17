

--
-- Dumping data for table `Employees`
--

LOCK TABLES `Employees` WRITE;
/*!40000 ALTER TABLE `Employees` DISABLE KEYS */;
INSERT INTO `Employees` VALUES (1,'Søren','Sørensen',NULL,1234),(2,'Mike','Jensen',NULL,3411),(3,'Sean','Pearsen',NULL,5622),(4,'Ole','Henriksen',NULL,7611),(5,'Michael','Henningensen',NULL,6533),(6,'Ulla','Mogensen',NULL,8766),(7,'Sabine','Sleif',NULL,1223),(8,'Trine','Poulsen',NULL,4352),(9,'Magrethe','Egebo',NULL,3244),(10,'Stine','Arresø',NULL,4322);
/*!40000 ALTER TABLE `Employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Skills`
--

LOCK TABLES `Skills` WRITE;
/*!40000 ALTER TABLE `Skills` DISABLE KEYS */;
INSERT INTO `Skills` VALUES (1,'Mac IOS'),(2,'BackEnd'),(3,'FrontEnd'),(4,'Android'),(5,'Linux'),(6,'JUnit Tests'),(7,'CSS'),(8,'HTML'),(9,'Windows'),(10,'ThymeLeaf');
/*!40000 ALTER TABLE `Skills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `EmployeeSkills`
--

LOCK TABLES `EmployeeSkills` WRITE;
/*!40000 ALTER TABLE `EmployeeSkills` DISABLE KEYS */;
INSERT INTO `EmployeeSkills` VALUES (5,1),(10,1),(1,2),(1,3),(2,3),(9,3),(3,5),(1,6),(5,6),(6,8),(4,9),(7,9),(8,10),(10,10);
/*!40000 ALTER TABLE `EmployeeSkills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Projects`
--

LOCK TABLES `Projects` WRITE;
/*!40000 ALTER TABLE `Projects` DISABLE KEYS */;
INSERT INTO `Projects` VALUES (12,'Nordea','Lav ny Homebank');
/*!40000 ALTER TABLE `Projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `SubProjects`
--

LOCK TABLES `SubProjects` WRITE;
/*!40000 ALTER TABLE `SubProjects` DISABLE KEYS */;
INSERT INTO `SubProjects` VALUES (32,12,'FrontEnd','FE Descrip'),(34,12,'Kundekontakt','KK Descrip'),(35,12,'BackEnd','BE Descrip');
/*!40000 ALTER TABLE `SubProjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Tasks`
--

LOCK TABLES `Tasks` WRITE;
/*!40000 ALTER TABLE `Tasks` DISABLE KEYS */;
INSERT INTO `Tasks` VALUES (26,12,32,'Styling','Styling Descrip'),(27,12,32,'Html','Html Descrip'),(29,12,34,'Første møde','Første møde Descrip'),(30,12,35,'Lav Database','Database Descrip');
/*!40000 ALTER TABLE `Tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `SubTasks`
--

LOCK TABLES `SubTasks` WRITE;
/*!40000 ALTER TABLE `SubTasks` DISABLE KEYS */;
INSERT INTO `SubTasks` VALUES (15,26,'style topnav Descrip',12,'style topnav'),(16,26,'style footer Descrip',12,'style footer'),(17,27,'T og F Descrip',12,'Topnav og Footer'),(18,27,'Body Descrip',12,'Body'),(19,29,'Descrip Hej',12,'Sig hej til kunden'),(20,29,'Descrip',12,'Giv kunden kaffe');
/*!40000 ALTER TABLE `SubTasks` ENABLE KEYS */;
UNLOCK TABLES;



--
-- Dumping data for table `SubProjectDependencies`
--

LOCK TABLES `SubProjectDependencies` WRITE;
/*!40000 ALTER TABLE `SubProjectDependencies` DISABLE KEYS */;
INSERT INTO `SubProjectDependencies` VALUES (34,32);
/*!40000 ALTER TABLE `SubProjectDependencies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `TaskDependencies`
--

LOCK TABLES `TaskDependencies` WRITE;
/*!40000 ALTER TABLE `TaskDependencies` DISABLE KEYS */;
/*!40000 ALTER TABLE `TaskDependencies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `SubTaskDependencies`
--

LOCK TABLES `SubTaskDependencies` WRITE;
/*!40000 ALTER TABLE `SubTaskDependencies` DISABLE KEYS */;
/*!40000 ALTER TABLE `SubTaskDependencies` ENABLE KEYS */;
UNLOCK TABLES;




--
-- Dumping data for table `SubProjectsEstimatetWorkHours`
--

LOCK TABLES `SubProjectsEstimatetWorkHours` WRITE;
/*!40000 ALTER TABLE `SubProjectsEstimatetWorkHours` DISABLE KEYS */;
INSERT INTO `SubProjectsEstimatetWorkHours` VALUES (7,32,8146),(9,34,4000),(10,35,20);
/*!40000 ALTER TABLE `SubProjectsEstimatetWorkHours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `TasksEstimatetWorkHours`
--

LOCK TABLES `TasksEstimatetWorkHours` WRITE;
/*!40000 ALTER TABLE `TasksEstimatetWorkHours` DISABLE KEYS */;
INSERT INTO `TasksEstimatetWorkHours` VALUES (7,26,8100),(8,27,46),(10,29,4000),(11,30,20);
/*!40000 ALTER TABLE `TasksEstimatetWorkHours` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Dumping data for table `SubTaskEstimatetWorkHours`
--

LOCK TABLES `SubTaskEstimatetWorkHours` WRITE;
/*!40000 ALTER TABLE `SubTaskEstimatetWorkHours` DISABLE KEYS */;
INSERT INTO `SubTaskEstimatetWorkHours` VALUES (9,15,100),(10,16,8000),(11,17,2),(12,18,44),(13,19,4000),(14,20,15);
/*!40000 ALTER TABLE `SubTaskEstimatetWorkHours` ENABLE KEYS */;
UNLOCK TABLES;