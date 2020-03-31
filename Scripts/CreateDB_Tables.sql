-- MySQL Script generated by MySQL Workbench
-- Wed Mar 25 11:16:47 2020
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
DROP SCHEMA IF EXISTS `capstone2020` ;

-- -----------------------------------------------------
-- Schema capstone2020
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `capstone2020` DEFAULT CHARACTER SET utf8mb4 ;
USE `capstone2020` ;

-- -----------------------------------------------------
-- Table `capstone2020`.`category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `capstone2020`.`category` ;

CREATE TABLE IF NOT EXISTS `capstone2020`.`category` (
  `categoryID` INT(11) NOT NULL AUTO_INCREMENT,
  `categoryName` VARCHAR(30) NOT NULL,
  `menuID` INT(11) NOT NULL,
  PRIMARY KEY (`categoryID`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COMMENT = 'Meal category';


-- -----------------------------------------------------
-- Table `capstone2020`.`item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `capstone2020`.`item` ;

CREATE TABLE IF NOT EXISTS `capstone2020`.`item` (
  `itemID` INT(11) NOT NULL AUTO_INCREMENT,
  `itemName` VARCHAR(255) NOT NULL,
  `itemPrice` DECIMAL(10,2) NULL DEFAULT NULL,
  `itemDesc` VARCHAR(255) NULL DEFAULT NULL,
  `categoryID` INT(11) NOT NULL,
  `photoLocalDirectory` VARCHAR(255) NULL DEFAULT NULL,
  `photoCloudDirectory` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`itemID`),
  INDEX `fk_item_category_idx` (`categoryID` ASC) ,
  CONSTRAINT `fk_item_category`
    FOREIGN KEY (`categoryID`)
    REFERENCES `capstone2020`.`category` (`categoryID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COMMENT = 'Meal items';


-- -----------------------------------------------------
-- Table `capstone2020`.`staff`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `capstone2020`.`staff` ;

CREATE TABLE IF NOT EXISTS `capstone2020`.`staff` (
  `sID` INT(11) NOT NULL AUTO_INCREMENT,
  `pin` VARBINARY(4) NOT NULL DEFAULT 0000,
  `isActive` VARCHAR(1) NOT NULL DEFAULT 'T',
  `fName` VARCHAR(45) NULL,
  `lName` VARCHAR(45) NULL,
  `contactNum` VARCHAR(10),
  `jobName` VARCHAR(45) NULL,
  PRIMARY KEY (`sID`),
  UNIQUE INDEX `sID_UNIQUE` (`sID` ASC) )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `capstone2020`.`table`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `capstone2020`.`table` ;

CREATE TABLE IF NOT EXISTS `capstone2020`.`table` (
  `tableID` INT(11) NOT NULL,
  `startTime` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `endTime` DATETIME NULL DEFAULT NULL,
  `tableStatus` INT(11) NOT NULL DEFAULT '0',
  `staff_sID` INT(11) NOT NULL,
  PRIMARY KEY (`tableID`, `startTime`),
  INDEX `fk_table_staff1_idx` (`staff_sID` ASC) ,
  CONSTRAINT `fk_table_staff1`
    FOREIGN KEY (`staff_sID`)
    REFERENCES `capstone2020`.`staff` (`sID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `capstone2020`.`order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `capstone2020`.`order` ;

CREATE TABLE IF NOT EXISTS `capstone2020`.`order` (
  `orderID` INT(11) NOT NULL AUTO_INCREMENT,
  `timeStamp` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `orderItemQty` INT(11) NOT NULL COMMENT 'order list',
  `orderAmount` DOUBLE NOT NULL,
  `orderStatus` INT(11) NOT NULL DEFAULT '0',
  `item_itemID` INT(11) NOT NULL,
  `table_tableID` INT(11) NOT NULL,
  `table_startTime` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`orderID`, `timeStamp`),
  INDEX `fk_order_item1_idx` (`item_itemID` ASC) ,
  INDEX `fk_order_table1_idx` (`table_tableID` ASC, `table_startTime` ASC) ,
  CONSTRAINT `fk_order_item1`
    FOREIGN KEY (`item_itemID`)
    REFERENCES `capstone2020`.`item` (`itemID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_table1`
    FOREIGN KEY (`table_tableID` , `table_startTime`)
    REFERENCES `capstone2020`.`table` (`tableID` , `startTime`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `capstone2020`.`survey`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `capstone2020`.`survey` ;

CREATE TABLE IF NOT EXISTS `capstone2020`.`survey` (
  `surveyID` INT(11) NOT NULL AUTO_INCREMENT,
  `surveyA1` DECIMAL(2,1) NULL DEFAULT NULL,
  `surveyA2` DECIMAL(2,1) NULL DEFAULT NULL,
  `surveyA3` DECIMAL(2,1) NULL DEFAULT NULL,
  `surveyA4` DECIMAL(2,1) NULL DEFAULT NULL,
  `surveyA5` DECIMAL(2,1) NULL DEFAULT NULL,
  `surveyA6` DECIMAL(2,1) NULL DEFAULT NULL,
  `surveyA7` DECIMAL(2,1) NULL DEFAULT NULL,
  `table_tableID` INT(11) NOT NULL,
  `table_startTime` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`surveyID`),
  INDEX `fk_survey_table1_idx` (`table_tableID` ASC, `table_startTime` ASC) ,
  CONSTRAINT `fk_survey_table1`
    FOREIGN KEY (`table_tableID` , `table_startTime`)
    REFERENCES `capstone2020`.`table` (`tableID` , `startTime`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `capstone2020`.`surveyquestions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `capstone2020`.`surveyquestions` ;

CREATE TABLE IF NOT EXISTS `capstone2020`.`surveyquestions` (
  `surveyQuestionID` INT(11) NOT NULL,
  `surveysurveyQuestion` VARCHAR(255) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
