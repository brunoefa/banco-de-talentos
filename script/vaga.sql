CREATE TABLE `bancodetalentos`.`vaga` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(100) NOT NULL,
  `empresa` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `descricao` TEXT NOT NULL,
  `formacao` VARCHAR(100) NOT NULL,
  `cidade` VARCHAR(100) NOT NULL,
  `estado` VARCHAR(100) NOT NULL,
  `remuneracao` DECIMAL NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC));
