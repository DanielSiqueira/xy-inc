# Projeto XY-INC
Teste Desenvolvedor2 Daniel Siqueira


Tecnologias utilizadas
Spring boot,Hibernate,Jpa, Angular, Java, javascript, bootstrap, html
IDE: Eclipse
Banco: Mysql

________________________________________________________________________
Instruções para executar o projeto

Pré requisito: 
Java8
Maven
Mysql 
 Usuario: root
 Senha:root

1 - clone o projeto
https://github.com/DanielSiqueira/xy-inc.git

2 - Execute os scripts no Mysql
CREATE DATABASE `dbtestezup`;
USE `dbtestezup`;
CREATE TABLE `tb_poi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `coordenada_X` int(11) NOT NULL,
  `coordenada_Y` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

3 - Execute o comando dentro da pasta do projeto "projeto-poi"
mvn clean package & java -jar target/xy-inc.jar

3- Acesse o endereço abaixo
http://localhost:8080/

Exemplos de teste Http:
Cadastrar POI (POST)
Insira na Url: http://localhost:8080/poi
insira no header para: Content-Type: application/json
Insira no corpo o objeto JSON: {"nome":"Supermercado","coordenadaX":23,"coordenadaY":6}

Buscar Todos POIs (GET)
http://localhost:8080/poi
insira no header para: Content-Type: application/json


Buscar POIs por proximidade: Distancia= 10 Metros e Coordenadas X=20, Y=10 (GET)
http://localhost:8080/poi/proximos?d=10&x=20&y=10
insira no header para: Content-Type: application/json






