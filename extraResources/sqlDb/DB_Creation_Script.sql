-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema DLRTM_DB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema DLRTM_DB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `DLRTM_DB` DEFAULT CHARACTER SET utf8 ;
USE `DLRTM_DB` ;

-- -----------------------------------------------------
-- Table `DLRTM_DB`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DLRTM_DB`.`products` (
  `uniqueID` VARCHAR(45) NOT NULL,
  `name` VARCHAR(255) NULL,
  `manufacturer` VARCHAR(255) NULL,
  `countryOfOrigin` VARCHAR(255) NULL,
  `description` VARCHAR(500) NULL,
  `unitPurchasePrice` DOUBLE NOT NULL,
  `unitPrice` DOUBLE NOT NULL,
  `discounts` DOUBLE NULL,
  `adjustments` DOUBLE NULL,
  `credits` DOUBLE NULL,
  `deductions` DOUBLE NULL,
  `specialOffers` VARCHAR(255) NULL,
  `currency` VARCHAR(45) NULL,
  `itemsInStockInt` INT NULL,
  `itemsInStockDecimal` DOUBLE NULL,
  `quantityInStock` DOUBLE NULL,
  `measurementUnit` VARCHAR(45) NULL,
  `needToReorder` INT NULL,
  `specialMentions` VARCHAR(500) NULL,
  `length` DOUBLE NULL,
  `width` DOUBLE NULL,
  `depth` DOUBLE NULL,
  `height` DOUBLE NULL,
  `weight` DOUBLE NULL,
  `sizeMeasurementUnit` VARCHAR(45) NULL,
  `weightMeasurementUnit` VARCHAR(45) NULL,
  PRIMARY KEY (`uniqueID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DLRTM_DB`.`clients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DLRTM_DB`.`clients` (
  `client_id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`client_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DLRTM_DB`.`transactions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DLRTM_DB`.`transactions` (
  `transaction_id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`transaction_id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
