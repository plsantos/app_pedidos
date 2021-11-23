-- MySQL Script generated by MySQL Workbench
-- Tue Nov 23 16:13:19 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema pedidos
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pedidos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pedidos` DEFAULT CHARACTER SET utf8 ;
USE `pedidos` ;

-- -----------------------------------------------------
-- Table `pedidos`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pedidos`.`produto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  `valor` DOUBLE(5,2) NOT NULL,
  `status` TINYBLOB NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pedidos`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pedidos`.`endereco` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rua` VARCHAR(45) NOT NULL,
  `numero` VARCHAR(45) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `cep` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pedidos`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pedidos`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(15) NOT NULL,
  `documento` VARCHAR(20) NOT NULL,
  `nome` VARCHAR(80) NOT NULL,
  `endereco_id` INT NOT NULL,
  PRIMARY KEY (`id`, `endereco_id`),
  INDEX `fk_cliente_endereco1_idx` (`endereco_id` ASC) VISIBLE,
  CONSTRAINT `fk_cliente_endereco1`
    FOREIGN KEY (`endereco_id`)
    REFERENCES `pedidos`.`endereco` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pedidos`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pedidos`.`pedido` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` DATETIME NOT NULL,
  `cliente_id` INT NOT NULL,
  `situacao` TINYBLOB NOT NULL,
  `valor_total` DOUBLE NOT NULL,
  PRIMARY KEY (`id`, `cliente_id`),
  INDEX `fk_pedido_cliente1_idx` (`cliente_id` ASC) VISIBLE,
  CONSTRAINT `fk_pedido_cliente1`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `pedidos`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pedidos`.`itens_pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pedidos`.`itens_pedido` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `produto_id` INT NOT NULL,
  `quantidade_produto` INT NOT NULL,
  `pedido_id` INT NOT NULL,
  `valor_total` DOUBLE NOT NULL,
  PRIMARY KEY (`id`, `produto_id`, `pedido_id`),
  INDEX `fk__produto1_idx` (`produto_id` ASC) VISIBLE,
  INDEX `fk_itens_pedido_pedido1_idx` (`pedido_id` ASC) VISIBLE,
  CONSTRAINT `fk__produto1`
    FOREIGN KEY (`produto_id`)
    REFERENCES `pedidos`.`produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_itens_pedido_pedido1`
    FOREIGN KEY (`pedido_id`)
    REFERENCES `pedidos`.`pedido` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
