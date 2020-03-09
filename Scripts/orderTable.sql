-- MySQL Script generated by MySQL Workbench
-- Fri Mar  6 20:10:03 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema capstone2020
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema capstone2020
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `capstone2020` DEFAULT CHARACTER SET utf8 ;
USE `capstone2020` ;

-- -----------------------------------------------------
-- Table `capstone2020`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `capstone2020`.`category` (
  `categoryID` INT(11) NOT NULL AUTO_INCREMENT,
  `categoryName` VARCHAR(30) NOT NULL,
  `menuID` INT(11) NOT NULL,
  PRIMARY KEY (`categoryID`),
  UNIQUE INDEX `categoryName` (`categoryName` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8
COMMENT = 'Meal category';


-- -----------------------------------------------------
-- Table `capstone2020`.`item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `capstone2020`.`item` (
  `itemID` INT(11) NOT NULL AUTO_INCREMENT,
  `itemName` VARCHAR(255) NOT NULL,
  `itemPrice` DECIMAL(10,2) NULL DEFAULT NULL,
  `itemDesc` VARCHAR(255) NULL DEFAULT NULL,
  `categoryID` INT(11) NOT NULL,
  `photoLocalDirectory` VARCHAR(255) NULL DEFAULT NULL,
  `photoCloudDirectory` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`itemID`),
  UNIQUE INDEX `itemName` (`itemName` ASC) ,
  INDEX `item_fk` (`categoryID` ASC) ,
  CONSTRAINT `item_fk`
    FOREIGN KEY (`categoryID`)
    REFERENCES `capstone2020`.`category` (`categoryID`))
ENGINE = InnoDB
AUTO_INCREMENT = 56
DEFAULT CHARACTER SET = utf8
COMMENT = 'Meal items';


-- -----------------------------------------------------
-- Table `capstone2020`.`help`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `capstone2020`.`help` (
  `helpID` INT NOT NULL,
  `helpStatusID` INT NOT NULL,
  `tableID` INT NOT NULL,
  PRIMARY KEY (`helpID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `capstone2020`.`bill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `capstone2020`.`bill` (
  `billID` INT NOT NULL AUTO_INCREMENT,
  `totalAmount` DECIMAL(10,2) NOT NULL,
  `tableID` INT NOT NULL,
  PRIMARY KEY (`billID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `capstone2020`.`survey`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `capstone2020`.`survey` (
  `surveyID` INT NOT NULL AUTO_INCREMENT,
  `surveyA1` DECIMAL(2,1) NULL,
  `surveyA2` DECIMAL(2,1) NULL,
  `surveyA3` DECIMAL(2,1) NULL,
  `surveyA4` DECIMAL(2,1) NULL,
  `surveyA5` DECIMAL(2,1) NULL,
  `surveyA6` DECIMAL(2,1) NULL,
  `surveyA7` DECIMAL(2,1) NULL,
  `surveyA8` DECIMAL(2,1) NULL,
  PRIMARY KEY (`surveyID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `capstone2020`.`tables`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `capstone2020`.`tables` (
  `tableID` INT NOT NULL AUTO_INCREMENT,
  `startTime` DATETIME(6) NOT NULL,
  `endTime` DATETIME(6) NOT NULL,
  `tableNo` INT NOT NULL,
  `help_helpID` INT NOT NULL,
  `bill_billID` INT NOT NULL,
  `survey_surveyID` INT NOT NULL,
  PRIMARY KEY (`tableID`, `help_helpID`, `bill_billID`, `survey_surveyID`),
  INDEX `fk_tables_help1_idx` (`help_helpID` ASC) ,
  INDEX `fk_tables_bill1_idx` (`bill_billID` ASC) ,
  INDEX `fk_tables_survey1_idx` (`survey_surveyID` ASC) ,
  CONSTRAINT `fk_tables_help1`
    FOREIGN KEY (`help_helpID`)
    REFERENCES `capstone2020`.`help` (`helpID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tables_bill1`
    FOREIGN KEY (`bill_billID`)
    REFERENCES `capstone2020`.`bill` (`billID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tables_survey1`
    FOREIGN KEY (`survey_surveyID`)
    REFERENCES `capstone2020`.`survey` (`surveyID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `capstone2020`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `capstone2020`.`order` (
  `orderID` INT NOT NULL AUTO_INCREMENT,
  `orderDate` DATETIME(6) NOT NULL,
  `tableNo` INT NOT NULL,
  `orderAmount` DECIMAL NOT NULL,
  `tables_tableID` INT NOT NULL,
  PRIMARY KEY (`orderID`, `tables_tableID`),
  INDEX `fk_order_tables1_idx` (`tables_tableID` ASC) ,
  CONSTRAINT `fk_order_tables1`
    FOREIGN KEY (`tables_tableID`)
    REFERENCES `capstone2020`.`tables` (`tableID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `capstone2020`.`orderItem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `capstone2020`.`orderItem` (
  `itemID` INT NOT NULL,
  `orderID` INT NOT NULL,
  `orderedItemQty` INT NOT NULL,
  PRIMARY KEY (`itemID`, `orderID`),
  INDEX `fk_item_has_order_order1_idx` (`orderID` ASC) ,
  INDEX `fk_item_has_order_item1_idx` (`itemID` ASC) ,
  CONSTRAINT `fk_item_has_order_item1`
    FOREIGN KEY (`itemID`)
    REFERENCES `capstone2020`.`item` (`itemID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_has_order_order1`
    FOREIGN KEY (`orderID`)
    REFERENCES `capstone2020`.`order` (`orderID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `capstone2020`.`orderStatus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `capstone2020`.`orderStatus` (
  `dorderStatusID` INT NOT NULL,
  `orderStatusName` VARCHAR(30) NULL,
  `itemID` INT NULL,
  `orderItem_itemID` INT NOT NULL,
  `orderItem_orderID` INT NOT NULL,
  PRIMARY KEY (`dorderStatusID`),
  INDEX `fk_orderStatus_orderItem1_idx` (`orderItem_itemID` ASC, `orderItem_orderID` ASC) ,
  CONSTRAINT `fk_orderStatus_orderItem1`
    FOREIGN KEY (`orderItem_itemID` , `orderItem_orderID`)
    REFERENCES `capstone2020`.`orderItem` (`itemID` , `orderID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `capstone2020`.`helpStatus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `capstone2020`.`helpStatus` (
  `helpStatusID` INT NOT NULL,
  `helpStatusName` VARCHAR(45) NOT NULL,
  `help_helpID` INT NOT NULL,
  PRIMARY KEY (`helpStatusID`, `help_helpID`),
  INDEX `fk_helpStatus_help1_idx` (`help_helpID` ASC) ,
  CONSTRAINT `fk_helpStatus_help1`
    FOREIGN KEY (`help_helpID`)
    REFERENCES `capstone2020`.`help` (`helpID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;