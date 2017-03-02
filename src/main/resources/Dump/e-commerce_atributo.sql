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
-- Table structure for table `atributo`
--

DROP TABLE IF EXISTS `atributo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atributo` (
  `Id` char(32) NOT NULL,
  `Nome` varchar(45) NOT NULL,
  `Ativo` tinyint(1) NOT NULL,
  `Tipo` char(2) NOT NULL,
  `Unidade` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Atributo_Nome_Unique` (`Nome`,`Tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atributo`
--

LOCK TABLES `atributo` WRITE;
/*!40000 ALTER TABLE `atributo` DISABLE KEYS */;
INSERT INTO `atributo` VALUES ('0cc1d5b3c138446ebb5d991833d94f20','Conexões',1,'TE',NULL),('124ebea32dff4803ab75dd232839b003','Resolução',1,'TE',NULL),('141b1e68f1f940568f33d6ee869a1d6d','Modelo',1,'TE',NULL),('14ec895d83e44d28ad1b1a9c83094ce3','Funções da Câmera',1,'TE',NULL),('1adf6c9bb07d4de3a8dc3a6d55e94e03','Tipo de Teclado',1,'TE',NULL),('1e4f107edc324e9e844a0171760c32e0','Profundidade',1,'TE',NULL),('21ae388f5be949899245bd4cc029d172','Altura',1,'TE',NULL),('32c16385f1c14bac859e8fafc044feda','Tipo de Toque',1,'TE',NULL),('3485f3b070df462296bb95a2f0b07d8d','Item de Homologação',1,'TE','50'),('3504731a8e8644c19cc41d0646d4630a','Câmera Secundária',1,'TE',NULL),('39f394bb3b154d3b89b8654675fe9bf0','Autonomia em Stand-by',1,'TE',NULL),('44f836fd2c264987a1df23d9f5e1394f','Tipo',1,'TE',NULL),('568c42b6ddc349d1937d6c10ac708d34','Resolução de Vídeo',1,'TE',NULL),('596c7a94c2cc422c9efb80ca4b12ff95','Versão',1,'TE',NULL),('5c73e1ba3d01435f85eebbc4cbbfc908','Tamanho da Tela',1,'TE',NULL),('60779ed061e34d009ee0619ad624cb87','Memória Interna',1,'TE',NULL),('62ad0ac31c514faca47b784f40510c42','Teste',1,'TE',NULL),('67970894d4fa49b194c2bd691ec3bbba','Sistema Operacional',1,'TE',NULL),('69921ef379b9476a9711c3d0b23bd08c','Marca',1,'TE',NULL),('760a81525bfe4b7d9134b823211d06fa','Chips',1,'TE',NULL),('7649f6a938074eeb8a721832fc79dbd6','Processador',1,'TE',NULL),('87764a7323314a22b61b86249412cfe1','Largura',1,'TE',NULL),('8fff49b3701c48f893512acb3ae990a2','Tipo de Tela',1,'TE',NULL),('9417018fd3a54f359d7d86abefcbc5d2','Funções Extras',1,'TE',NULL),('94e3dd1f9cba437cb697bb2b8a6e709c','Operadora',1,'TE',NULL),('95d08f90abe94c75bd10ddb83bddb182','Autonomia em Conversação',1,'TE',NULL),('95e6e1ae8a4f4827b8d5001d0e194b97','Plataforma',1,'TE',NULL),('99097154f3de4aebb3a73d64c8ec5b17','Velocidade do Processador',1,'TE',NULL),('b523c1a62a204303b20bc539b07027c9','Cores da Tela',1,'TE',NULL),('b5fcaef893164ae682cb44633983ca72','Mensagens Escritas',1,'TE',NULL),('c8061d952543435f81afbede9549d2c5','Resolução da Câmera',1,'TE',NULL),('ceaa7901a6654509a09918dc9a8a4711','Bateria',1,'TE',NULL),('df71ec9a264144c396e4049252589e62','Formato do Aparelho',1,'TE',NULL),('e0cc7b23018a4e00968f2c5f0843c084','Aplicativos',1,'TE',NULL),('ecd54f181f6e4d0f9e79fbad7d142fbd','Banda',1,'TE',NULL),('fbe2ce18f6a446aeac6cce27de1fe30e','Característica Eco Sustentável',1,'TE',NULL),('fcd2b1693cb9420494140aadd8b831b2','Peso',1,'TE',NULL);
/*!40000 ALTER TABLE `atributo` ENABLE KEYS */;
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
