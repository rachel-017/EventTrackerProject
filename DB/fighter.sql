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
-- Table `head`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `head` ;

CREATE TABLE IF NOT EXISTS `head` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `head_type` VARCHAR(2000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `torso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `torso` ;

CREATE TABLE IF NOT EXISTS `torso` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `torso_type` VARCHAR(2000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `legs`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `legs` ;

CREATE TABLE IF NOT EXISTS `legs` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `legs_type` VARCHAR(2000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fighter`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fighter` ;

CREATE TABLE IF NOT EXISTS `fighter` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `strength` INT NULL,
  `speed` INT NULL,
  `intelligence` INT NULL,
  `health` INT NULL,
  `head_id` INT NOT NULL,
  `torso_id` INT NOT NULL,
  `legs_id` INT NOT NULL,
  PRIMARY KEY (`id`, `head_id`, `torso_id`, `legs_id`),
  INDEX `fk_fighter_head_idx` (`head_id` ASC),
  INDEX `fk_fighter_torso1_idx` (`torso_id` ASC),
  INDEX `fk_fighter_legs1_idx` (`legs_id` ASC),
  CONSTRAINT `fk_fighter_head`
    FOREIGN KEY (`head_id`)
    REFERENCES `head` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_fighter_torso1`
    FOREIGN KEY (`torso_id`)
    REFERENCES `torso` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_fighter_legs1`
    FOREIGN KEY (`legs_id`)
    REFERENCES `legs` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
-- Data for table `head`
-- -----------------------------------------------------
START TRANSACTION;
USE `fighterdb`;
INSERT INTO `head` (`id`, `head_type`) VALUES (1, 'lion');
INSERT INTO `head` (`id`, `head_type`) VALUES (2, 'eagle');
INSERT INTO `head` (`id`, `head_type`) VALUES (3, 'wolf');
INSERT INTO `head` (`id`, `head_type`) VALUES (4, 'bear');
INSERT INTO `head` (`id`, `head_type`) VALUES (5, 'octopus');

COMMIT;


-- -----------------------------------------------------
-- Data for table `torso`
-- -----------------------------------------------------
START TRANSACTION;
USE `fighterdb`;
INSERT INTO `torso` (`id`, `torso_type`) VALUES (1, 'lion');
INSERT INTO `torso` (`id`, `torso_type`) VALUES (2, 'eagle');
INSERT INTO `torso` (`id`, `torso_type`) VALUES (3, 'wolf');
INSERT INTO `torso` (`id`, `torso_type`) VALUES (4, 'bear');
INSERT INTO `torso` (`id`, `torso_type`) VALUES (5, 'octopus');

COMMIT;


-- -----------------------------------------------------
-- Data for table `legs`
-- -----------------------------------------------------
START TRANSACTION;
USE `fighterdb`;
INSERT INTO `legs` (`id`, `legs_type`) VALUES (1, 'lion');
INSERT INTO `legs` (`id`, `legs_type`) VALUES (2, 'eagle');
INSERT INTO `legs` (`id`, `legs_type`) VALUES (3, 'wolf');
INSERT INTO `legs` (`id`, `legs_type`) VALUES (4, 'bear');
INSERT INTO `legs` (`id`, `legs_type`) VALUES (5, 'octopus');

COMMIT;


-- -----------------------------------------------------
-- Data for table `fighter`
-- -----------------------------------------------------
START TRANSACTION;
USE `fighterdb`;
INSERT INTO `fighter` (`id`, `name`, `strength`, `speed`, `intelligence`, `health`, `head_id`, `torso_id`, `legs_id`) VALUES (1, 'Boulder', 78, 34, 49, 100, 4, 1, 4);
INSERT INTO `fighter` (`id`, `name`, `strength`, `speed`, `intelligence`, `health`, `head_id`, `torso_id`, `legs_id`) VALUES (2, 'Lightning', 32, 80, 52, 100, 1, 2, 3);
INSERT INTO `fighter` (`id`, `name`, `strength`, `speed`, `intelligence`, `health`, `head_id`, `torso_id`, `legs_id`) VALUES (3, 'Firefly', 30, 53, 81, 100, 2, 4, 2);
INSERT INTO `fighter` (`id`, `name`, `strength`, `speed`, `intelligence`, `health`, `head_id`, `torso_id`, `legs_id`) VALUES (4, 'Anvil', 85, 55, 52, 150, 4, 3, 1);
INSERT INTO `fighter` (`id`, `name`, `strength`, `speed`, `intelligence`, `health`, `head_id`, `torso_id`, `legs_id`) VALUES (5, 'Siren', 64, 89, 55, 200, 3, 5, 4);
INSERT INTO `fighter` (`id`, `name`, `strength`, `speed`, `intelligence`, `health`, `head_id`, `torso_id`, `legs_id`) VALUES (6, 'Kraken', 85, 50, 90, 500, 5, 2, 5);

COMMIT;

