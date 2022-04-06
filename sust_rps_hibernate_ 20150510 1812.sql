-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.39-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema sust_rps
--

CREATE DATABASE IF NOT EXISTS sust_rps;
USE sust_rps;

--
-- Definition of table `course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `offering_dept` int(11) NOT NULL,
  `accepting_dept` int(11) NOT NULL,
  `session` int(11) NOT NULL,
  `semester` int(11) NOT NULL,
  `course_code` varchar(50) NOT NULL,
  `course_title` varchar(50) DEFAULT NULL,
  `credit` double NOT NULL,
  PRIMARY KEY (`course_id`),
  UNIQUE KEY `course_idx` (`offering_dept`,`accepting_dept`,`session`,`semester`,`course_code`),
  KEY `department_course_fk` (`accepting_dept`),
  CONSTRAINT `department_course_fk` FOREIGN KEY (`accepting_dept`) REFERENCES `department` (`id_dept`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `department_course_fk1` FOREIGN KEY (`offering_dept`) REFERENCES `department` (`id_dept`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`course_id`,`offering_dept`,`accepting_dept`,`session`,`semester`,`course_code`,`course_title`,`credit`) VALUES 
 (1,1,2,2011,7,'CSE205','Database theory',2),
 (2,1,2,2011,7,'CSE206','Database Lab',3);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;


--
-- Definition of table `course_registration`
--

DROP TABLE IF EXISTS `course_registration`;
CREATE TABLE `course_registration` (
  `id_course_reg` int(11) NOT NULL AUTO_INCREMENT,
  `id_student` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `is_approved` tinyint(1) NOT NULL,
  `marks` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_course_reg`),
  UNIQUE KEY `course_registration_idx` (`id_student`,`course_id`),
  KEY `course_course_registration_fk` (`course_id`),
  CONSTRAINT `course_course_registration_fk` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `student_course_registration_fk` FOREIGN KEY (`id_student`) REFERENCES `student` (`id_student`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course_registration`
--

/*!40000 ALTER TABLE `course_registration` DISABLE KEYS */;
INSERT INTO `course_registration` (`id_course_reg`,`id_student`,`course_id`,`is_approved`,`marks`) VALUES 
 (1,1,1,1,70),
 (2,2,1,0,0),
 (3,1,2,1,30),
 (4,3,1,1,80),
 (5,2,2,1,85),
 (6,4,1,0,0);
/*!40000 ALTER TABLE `course_registration` ENABLE KEYS */;


--
-- Definition of table `degree`
--

DROP TABLE IF EXISTS `degree`;
CREATE TABLE `degree` (
  `id_degree` int(11) NOT NULL AUTO_INCREMENT,
  `degree_type` varchar(50) NOT NULL,
  `degree_category` varchar(50) NOT NULL,
  `total_semester` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_degree`),
  UNIQUE KEY `degree_idx` (`degree_type`,`degree_category`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `degree`
--

/*!40000 ALTER TABLE `degree` DISABLE KEYS */;
INSERT INTO `degree` (`id_degree`,`degree_type`,`degree_category`,`total_semester`) VALUES 
 (1,'B.Sc','Honors',8),
 (2,'M.Sc','Masters',3),
 (3,'BBA','Honor',8),
 (4,'MBA','Masters',4);
/*!40000 ALTER TABLE `degree` ENABLE KEYS */;


--
-- Definition of table `degree_offered_by_dept`
--

DROP TABLE IF EXISTS `degree_offered_by_dept`;
CREATE TABLE `degree_offered_by_dept` (
  `id_dept_degree` int(11) NOT NULL AUTO_INCREMENT,
  `id_dept` int(11) NOT NULL,
  `id_degree` int(11) NOT NULL,
  PRIMARY KEY (`id_dept_degree`),
  UNIQUE KEY `degree_offerered_by_dept_idx` (`id_dept`,`id_degree`),
  KEY `degree_id_dept_degree_fk` (`id_degree`),
  CONSTRAINT `degree_id_dept_degree_fk` FOREIGN KEY (`id_degree`) REFERENCES `degree` (`id_degree`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `department_id_dept_degree_fk` FOREIGN KEY (`id_dept`) REFERENCES `department` (`id_dept`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `degree_offered_by_dept`
--

/*!40000 ALTER TABLE `degree_offered_by_dept` DISABLE KEYS */;
INSERT INTO `degree_offered_by_dept` (`id_dept_degree`,`id_dept`,`id_degree`) VALUES 
 (1,1,1),
 (2,1,2),
 (3,2,3),
 (4,2,4),
 (5,3,1),
 (6,4,1),
 (7,4,2),
 (8,5,1),
 (9,5,2);
/*!40000 ALTER TABLE `degree_offered_by_dept` ENABLE KEYS */;


--
-- Definition of table `department`
--

DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id_dept` int(11) NOT NULL AUTO_INCREMENT,
  `dept_code` varchar(10) NOT NULL,
  `dept_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_dept`),
  UNIQUE KEY `department_idx` (`dept_code`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` (`id_dept`,`dept_code`,`dept_name`) VALUES 
 (1,'CSE','Computer Science & Engg.'),
 (2,'BAN','Business and Administration'),
 (3,'EEE','Electrical & Electronic Engg'),
 (4,'PHY','Physics'),
 (5,'CEP','Chemical Engg. & Polymer Science');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;


--
-- Definition of table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id_student` int(11) NOT NULL AUTO_INCREMENT,
  `registration_no` int(11) NOT NULL,
  `password` varchar(15) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `session` int(11) NOT NULL,
  `id_dept_degree` int(11) NOT NULL,
  PRIMARY KEY (`id_student`),
  UNIQUE KEY `student_idx` (`registration_no`,`id_dept_degree`),
  KEY `id_dept_degree_student_fk` (`id_dept_degree`),
  CONSTRAINT `id_dept_degree_student_fk` FOREIGN KEY (`id_dept_degree`) REFERENCES `degree_offered_by_dept` (`id_dept_degree`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`id_student`,`registration_no`,`password`,`name`,`session`,`id_dept_degree`) VALUES 
 (1,2011731001,'a','Md. Mohim Ahmed',2011,3),
 (2,2011731002,'b','Abir ul Haque',2011,3),
 (3,2010731001,'c','Farzana Yasmin',2010,3),
 (4,2011331001,'a','Zubair Mahmud',2011,1),
 (5,2010331002,'b','Arup Chakraborty',2010,1);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
