CREATE DATABASE IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `employee`.
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(45) DEFAULT NULL,
    `last_name` VARCHAR(45) DEFAULT NULL,
    `email` VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY(`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = latin1;

--
-- Data for table `employee`
--

INSERT INTO `employee` VALUES
(1, "Leslie", "Andrews", "leslie@outlook.com"),
(2, "Emma", "Baumgarten", "emma@outlook.com"),
(3, "Avani", "Gupta", "avani@outlook.com"),
(4, "Yuri", "Petrov", "yuri@outlook.com"),
(5, "Juan", "Vega", "juan@outlook.com")