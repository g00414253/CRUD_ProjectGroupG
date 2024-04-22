CREATE DATABASE  IF NOT EXISTS `exercisedata` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `exercisedata`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: exercisedata
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `bodypart`
--

DROP TABLE IF EXISTS `bodypart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bodypart` (
  `BodyPartID` int NOT NULL AUTO_INCREMENT,
  `BodyPartName` varchar(15) NOT NULL,
  PRIMARY KEY (`BodyPartID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bodypart`
--

LOCK TABLES `bodypart` WRITE;
/*!40000 ALTER TABLE `bodypart` DISABLE KEYS */;
INSERT INTO `bodypart` VALUES (1,'Chest'),(2,'Back'),(3,'Shoulders'),(4,'Biceps'),(5,'Triceps'),(6,'Legs'),(7,'Core');
/*!40000 ALTER TABLE `bodypart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercise`
--

DROP TABLE IF EXISTS `exercise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercise` (
  `ExerciseID` int NOT NULL AUTO_INCREMENT,
  `ExerciseName` varchar(50) NOT NULL,
  `Description` text,
  `CategoryID` int DEFAULT NULL,
  PRIMARY KEY (`ExerciseID`),
  KEY `CategoryID` (`CategoryID`),
  CONSTRAINT `exercise_ibfk_1` FOREIGN KEY (`CategoryID`) REFERENCES `exercisecategories` (`CategoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise`
--

LOCK TABLES `exercise` WRITE;
/*!40000 ALTER TABLE `exercise` DISABLE KEYS */;
INSERT INTO `exercise` VALUES (1,'Bench Press','Flat Barbbell press',1),(2,'Incline Dumbbell Press','Dumbbell press on an incline bench',1),(3,'Chest Flies','Chest Flies using 2 cables',1),(4,'Pull-ups','Pull ups on a bar',1),(5,'Cable Rows','Rows using a cable machine',1),(6,'Bicep Curls','Alternate curls using Dumbbells',1),(7,'Tricep Pushdowns','Tricep extension using a rope attachment and a cable',1),(8,'Shoulder Press','Pressing dumbbells on a vertical bench',1),(9,'Squats','Squating with a barbbell in a rack',1),(10,'Calve Raise','Calve raise with a barbbell on back',1),(11,'Running','Running eitheir on a treadmill or a track',2),(12,'Rowing','Rowing on a machine',2),(13,'Deadlift','Lift a barbell from the ground to a standing position',1),(14,'Romanian Deadlift','Similar to the conventional deadlift, but with straighter legs and more emphasis on the hamstrings',1),(15,'Bent Over Row','Row a barbell or dumbbells towards your torso with a bent over position',1),(16,'Lat Pulldown','Pull down a bar attached to a weight stack towards your chest',1),(17,'Arnold Press','Press dumbbells overhead while rotating palms',1),(18,'Lateral Raise','Lift dumbbells to the side until arms are parallel to the ground',1),(19,'Hammer Curl','Curl dumbbells while keeping palms facing each other',1),(20,'Skull Crushers','Extend elbows while holding a barbell or dumbbells over your head',1),(21,'Squat','Lower hips towards the ground while keeping torso upright and knees behind toes',1),(22,'Leg Press','Press against a weighted platform with legs',1),(23,'Running','Running on a treadmill or outdoors',2),(24,'Cycling','Riding a stationary or outdoor bicycle',2),(25,'Jump Rope','Skipping rope continuously',2),(26,'Swimming','Swimming laps in a pool',2),(27,'Boxing','Performing punches and combinations on a heavy bag or pads',2),(28,'Hiking','Walking or trekking on natural terrain',2),(29,'Rowing Machine','Using a rowing machine for cardio and strength',2),(30,'Elliptical Trainer','Using an elliptical machine for low-impact cardio',2),(31,'Jumping Jacks','Performing a calisthenics exercise involving jumping and spreading legs and arms',2);
/*!40000 ALTER TABLE `exercise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercisebodyparts`
--

DROP TABLE IF EXISTS `exercisebodyparts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercisebodyparts` (
  `ExerciseID` int NOT NULL,
  `BodyPartID` int NOT NULL,
  PRIMARY KEY (`ExerciseID`,`BodyPartID`),
  KEY `BodyPartID` (`BodyPartID`),
  CONSTRAINT `exercisebodyparts_ibfk_1` FOREIGN KEY (`ExerciseID`) REFERENCES `exercise` (`ExerciseID`),
  CONSTRAINT `exercisebodyparts_ibfk_2` FOREIGN KEY (`BodyPartID`) REFERENCES `bodypart` (`BodyPartID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercisebodyparts`
--

LOCK TABLES `exercisebodyparts` WRITE;
/*!40000 ALTER TABLE `exercisebodyparts` DISABLE KEYS */;
INSERT INTO `exercisebodyparts` VALUES (1,1),(2,1),(3,1),(4,2),(5,2),(12,2),(13,2),(14,2),(15,2),(16,2),(8,3),(17,3),(18,3),(6,4),(19,4),(7,5),(20,5),(9,6),(10,6),(11,6),(21,6),(22,6),(23,7),(24,7),(25,7),(26,7),(27,7),(28,7),(29,7),(30,7),(31,7);
/*!40000 ALTER TABLE `exercisebodyparts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercisecategories`
--

DROP TABLE IF EXISTS `exercisecategories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercisecategories` (
  `CategoryID` int NOT NULL AUTO_INCREMENT,
  `CategoryName` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`CategoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercisecategories`
--

LOCK TABLES `exercisecategories` WRITE;
/*!40000 ALTER TABLE `exercisecategories` DISABLE KEYS */;
INSERT INTO `exercisecategories` VALUES (1,'Strength Training'),(2,'Cardio');
/*!40000 ALTER TABLE `exercisecategories` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-19 19:17:41
