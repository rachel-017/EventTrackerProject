-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema fighterdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `fighterdb` ;

-- -----------------------------------------------------
-- Schema fighterdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fighterdb` DEFAULT CHARACTER SET utf8 ;
USE `fighterdb` ;

-- -----------------------------------------------------
-- Table `fighter`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fighter` ;

CREATE TABLE IF NOT EXISTS `fighter` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS fighter@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'fighter'@'localhost' IDENTIFIED BY 'fighter';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'fighter'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `fighter`
-- -----------------------------------------------------
START TRANSACTION;
USE `fighterdb`;
INSERT INTO `fighter` (`id`, `name`) VALUES (1, 'Boulder');

COMMIT;

