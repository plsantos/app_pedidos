
CREATE SCHEMA IF NOT EXISTS pedidos DEFAULT CHARACTER SET utf8 ;
USE pedidos ;

-- -----------------------------------------------------
-- Table `mydb`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `endereco` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rua` VARCHAR(45) NOT NULL,
  `numero` VARCHAR(45) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `cep` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

drop table cliente; 
-- -----------------------------------------------------
-- Table `mydb`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cliente`(
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(15) NOT NULL,
  `documento` VARCHAR(20) NOT NULL,
  `nome` VARCHAR(80) NOT NULL,
  `endereco_id` INT NOT null,
  PRIMARY KEY (`id`),
   CONSTRAINT FK_Endereco FOREIGN KEY (endereco_id)
    REFERENCES endereco(id));

drop table cliente; 



-- -----------------------------------------------------
-- Table `mydb`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pedido` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` DATETIME NOT NULL,
  `cliente_id` INT NOT NULL,
  `situacao` TINYBLOB NOT NULL,
  PRIMARY KEY (`id`, `cliente_id`),
  INDEX `fk_pedido_cliente1_idx` (`cliente_id` ASC) VISIBLE,
  CONSTRAINT `fk_pedido_cliente1`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

DROP TABLE pedido;

-- -----------------------------------------------------
-- Table `mydb`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `produto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  `valor` DOUBLE(5,2) NOT NULL,
  `status` TINYBLOB NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

drop table produto;
-- -----------------------------------------------------
-- Table `mydb`.`itens_pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itens_pedido` (
  `id` INT NOT null AUTO_INCREMENT,
  `pedido_id` INT NOT NULL,
  `produto_id` INT NOT NULL,
  `quantidade_produto` INT NOT NULL,
  PRIMARY KEY (`id`, `pedido_id`, `produto_id`),
  INDEX `fk_itens_pedido_pedido_idx` (`pedido_id` ASC) VISIBLE,
  INDEX `fk__produto1_idx` (`produto_id` ASC) VISIBLE,
  CONSTRAINT `fk_itens_pedido_pedido`
    FOREIGN KEY (`pedido_id`)
    REFERENCES `pedido` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk__produto1`
    FOREIGN KEY (`produto_id`)
    REFERENCES `produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

DROP TABLE itens_pedido;

desc pedidos;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
