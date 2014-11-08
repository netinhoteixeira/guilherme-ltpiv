-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema reclame
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema reclame
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `reclame` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `reclame` ;

-- -----------------------------------------------------
-- Table `reclame`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reclame`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `Login` VARCHAR(45) NULL,
  `Senha` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `reclame`.`Empresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reclame`.`Empresa` (
  `idEmpresa` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NULL,
  `Tipo` VARCHAR(45) NULL,
  PRIMARY KEY (`idEmpresa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `reclame`.`Reclamacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reclame`.`Reclamacao` (
  `idReclamacao` INT NOT NULL AUTO_INCREMENT,
  `idUsuario` INT NOT NULL,
  `idEmpresa` INT NOT NULL,
  `Assunto` VARCHAR(45) NULL,
  `Texto` VARCHAR(250) NULL,
  PRIMARY KEY (`idReclamacao`, `idUsuario`, `idEmpresa`),
  INDEX `fk_Reclamacao_Usuario_idx` (`idUsuario` ASC),
  INDEX `fk_Reclamacao_Empresa_idx` (`idEmpresa` ASC),
  CONSTRAINT `fk_Reclamacao_Usuario`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `reclame`.`Usuario` (`idUsuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Reclamacao_Empresa`
    FOREIGN KEY (`idEmpresa`)
    REFERENCES `reclame`.`Empresa` (`idEmpresa`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
