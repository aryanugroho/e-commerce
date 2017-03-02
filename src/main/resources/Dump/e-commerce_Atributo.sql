CREATE DATABASE  IF NOT EXISTS `e-commerce` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `e-commerce`;
-- MySQL dump 10.13  Distrib 5.5.54, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: e-commerce
-- ------------------------------------------------------
-- Server version	5.5.54-0+deb8u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Atributo`
--

DROP TABLE IF EXISTS `Atributo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Atributo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `valores` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=370 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Atributo`
--

LOCK TABLES `Atributo` WRITE;
/*!40000 ALTER TABLE `Atributo` DISABLE KEYS */;
INSERT INTO `Atributo` VALUES (333,'Altura',''),(334,'Aplicativos',''),(335,'Autonomia em Conversação',''),(336,'Autonomia em Stand-by',''),(337,'Banda',''),(338,'Bateria',''),(339,'Câmera Secundária',''),(340,'Característica Eco Sustentável',''),(341,'Chips',''),(342,'Conexões',''),(343,'Cores da Tela',''),(344,'Formato do Aparelho',''),(345,'Funções da Câmera',''),(346,'Funções Extras',''),(347,'Item de Homologação',''),(348,'Largura',''),(349,'Marca',''),(350,'Memória Interna',''),(351,'Mensagens Escritas',''),(352,'Modelo',''),(353,'Operadora',''),(354,'Peso',''),(355,'Plataforma',''),(356,'Processador',''),(357,'Profundidade',''),(358,'Resolução',''),(359,'Resolução da Câmera',''),(360,'Resolução de Vídeo',''),(361,'Sistema Operacional',''),(362,'Tamanho da Tela',''),(363,'Teste',''),(364,'Tipo',''),(365,'Tipo de Teclado',''),(366,'Tipo de Tela',''),(367,'Tipo de Toque',''),(368,'Velocidade do Processador',''),(369,'Versão','');
/*!40000 ALTER TABLE `Atributo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-02 17:43:53
