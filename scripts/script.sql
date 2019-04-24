CREATE DATABASE vulnerableApp CHARACTER SET utf8mb4;
USE vulnerableApp;

CREATE USER 'root'@'localhost' IDENTIFIED BY '';
GRANT ALL PRIVILEGES ON `vulnerableApp`.* TO 'root'@'localhost' WITH GRANT OPTION;

CREATE TABLE `USERS` (
  `id` VARCHAR(100) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `lastname` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`)
);