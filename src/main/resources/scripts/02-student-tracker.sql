CREATE DATABASE IF NOT EXISTS `student_tracker`;
USE `student_tracker`;

--
-- Table structure for table `student`.
--

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(45) DEFAULT NULL,
    `last_name` VARCHAR(45) DEFAULT NULL,
    `email` VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY(`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = latin1;