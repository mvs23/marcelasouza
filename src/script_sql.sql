CREATE DATABASE RESTAURANTE;
USE RESTAURANTE;

CREATE TABLE `restaurante`.`produtos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cod_produto` INT NOT NULL, 
  `descricao` VARCHAR(100) NOT NULL,
  `tipo` VARCHAR(45),
  `preco` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`));
  
	INSERT INTO PRODUTOS (id, cod_produto, descricao , preco, tipo) VALUES (0, 1, 'Macarrão', 25.00, 'Prato Principal');
    INSERT INTO PRODUTOS (id, cod_produto, descricao , preco, tipo) VALUES (1, 2, 'Abóbora com carne de soja no tacho', 45.50, 'Prato');
	
USE `restaurante` ;

-- -----------------------------------------------------
-- Table `restaurante`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurante`.`usuario` (
  `username` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

insert into usuario values ("adm@adm.br", "admin");
	