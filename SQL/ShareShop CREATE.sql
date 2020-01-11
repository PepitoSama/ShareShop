DROP TABLE IF EXISTS `UserGroup`;
DROP TABLE IF EXISTS `MessageSent`;
DROP TABLE IF EXISTS `UserDebt`;
DROP TABLE IF EXISTS `PricedProductList`;
DROP TABLE IF EXISTS `QuantifiedProductList`;
DROP TABLE IF EXISTS `DatedProduct`;
DROP TABLE IF EXISTS `FavorisProductList`;
DROP TABLE IF EXISTS `HistoryProductList`;
DROP TABLE IF EXISTS `GroupList`;
DROP TABLE IF EXISTS `InventoryProductList`;
DROP TABLE IF EXISTS `Stats`;
DROP TABLE IF EXISTS `Product`;
DROP TABLE IF EXISTS `User`;
DROP TABLE IF EXISTS `Group`;
DROP TABLE IF EXISTS `Image`;



-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Client :  localhost:3306
-- Généré le :  Sam 11 Janvier 2020 à 17:07
-- Version du serveur :  5.7.28-0ubuntu0.18.04.4
-- Version de PHP :  7.2.24-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `ShareShop`
--
CREATE DATABASE IF NOT EXISTS `ShareShop` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `ShareShop`;

-- --------------------------------------------------------

--
-- Structure de la table `DatedProduct`
--
CREATE TABLE IF NOT EXISTS `DatedProduct` (
  `idDatedProduct` int(10) NOT NULL,
  `idProduct` int(10) NOT NULL,
  `quantity` int(5) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`idDatedProduct`),
  KEY `fk_DatedProduct_product` (`idProduct`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `FavorisProductList`
--
CREATE TABLE IF NOT EXISTS `FavorisProductList` (
  `idGroup` int(10) NOT NULL,
  `idProduct` int(10) NOT NULL,
  PRIMARY KEY (`idGroup`,`idProduct`),
  KEY `Fk_prod` (`idProduct`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `Group`
--
CREATE TABLE IF NOT EXISTS `Group` (
  `idGroup` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  PRIMARY KEY (`idGroup`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `GroupList`
--
CREATE TABLE IF NOT EXISTS `GroupList` (
  `idGroupList` int(10) NOT NULL AUTO_INCREMENT,
  `idGroup` int(10) NOT NULL,
  `name` varchar(2048) NOT NULL,
  `date` date NOT NULL,
  `type` char(1) NOT NULL,
  PRIMARY KEY (`idGroupList`),
  KEY `FK_GroupList_idGroup` (`idGroup`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;



-- --------------------------------------------------------

--
-- Structure de la table `HistoryProductList`
--


CREATE TABLE IF NOT EXISTS `HistoryProductList` (
  `idHistoryProductList` int(10) NOT NULL,
  `idGroup` int(10) NOT NULL,
  PRIMARY KEY (`idHistoryProductList`),
  KEY `FK_HistoryProductList_idGroup` (`idGroup`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `Image`
--
CREATE TABLE IF NOT EXISTS `Image` (
  `idImage` int(10) NOT NULL,
  `image` blob NOT NULL,
  PRIMARY KEY (`idImage`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Structure de la table `InventoryProductList`
--
CREATE TABLE IF NOT EXISTS `InventoryProductList` (
  `idInventoryProductList` int(10) NOT NULL,
  `idGroup` int(10) NOT NULL,
  PRIMARY KEY (`idInventoryProductList`),
  KEY `FK_InventoryProductList_idGroup` (`idGroup`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `MessageSent`
--
CREATE TABLE IF NOT EXISTS `MessageSent` (
  `idMessage` int(10) NOT NULL AUTO_INCREMENT,
  `idUser` int(10) NOT NULL,
  `idGroup` int(10) NOT NULL,
  `text` varchar(2048) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`idMessage`),
  KEY `MessageSent_idGroup` (`idGroup`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Structure de la table `PricedProductList`
--
CREATE TABLE IF NOT EXISTS `PricedProductList` (
  `idGroupList` int(10) NOT NULL,
  `idProduct` int(10) NOT NULL,
  `price` float NOT NULL,
  `quantity` int(10) NOT NULL,
  PRIMARY KEY (`idGroupList`,`idProduct`),
  KEY `Fk_PricedProductList_product` (`idProduct`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `Product`
--
CREATE TABLE IF NOT EXISTS `Product` (
  `idProduct` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `idImage` int(10) DEFAULT NULL,
  `description` varchar(128) DEFAULT NULL,
  `barcode` varchar(13) DEFAULT NULL,
  `idFather` int(10) DEFAULT NULL,
  `estimatedPrice` float DEFAULT NULL,
  `idGroup` int(10) DEFAULT NULL,
  PRIMARY KEY (`idProduct`),
  KEY `FK_idImage` (`idImage`),
  KEY `FK_idGroup` (`idGroup`),
  KEY `FK_idFather` (`idFather`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `QuantifiedProductList`
--
CREATE TABLE IF NOT EXISTS `QuantifiedProductList` (
  `idGroupList` int(10) NOT NULL,
  `idProduct` int(10) NOT NULL,
  `quantity` int(10) NOT NULL,
  PRIMARY KEY (`idGroupList`,`idProduct`),
  KEY `idProduct` (`idProduct`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `Stats`
--
CREATE TABLE IF NOT EXISTS `Stats` (
  `idUser` int(10) NOT NULL,
  `date` date NOT NULL,
  `amount` float NOT NULL,
  KEY `fk_user` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `User`
--
CREATE TABLE IF NOT EXISTS `User` (
  `idUser` int(10) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(16) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `email` varchar(254) NOT NULL,
  `birthdate` date NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE KEY `nickname` (`nickname`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `UserDebt`
--
CREATE TABLE IF NOT EXISTS `UserDebt` (
  `idDebt` int(10) NOT NULL AUTO_INCREMENT,
  `amount` float NOT NULL,
  `idFrom` int(10) NOT NULL,
  `idTo` int(10) NOT NULL,
  PRIMARY KEY (`idDebt`),
  KEY `FK_idFrom` (`idFrom`),
  KEY `FK_idTo` (`idTo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `UserGroup`
--
CREATE TABLE IF NOT EXISTS `UserGroup` (
  `idUser` int(10) NOT NULL,
  `idGroup` int(10) NOT NULL,
  PRIMARY KEY (`idUser`,`idGroup`),
  KEY `UserGroup_ibfk_2` (`idGroup`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `DatedProduct`
--
ALTER TABLE `DatedProduct`
  ADD CONSTRAINT `fk_DatedProduct_product` FOREIGN KEY (`idProduct`) REFERENCES `Product` (`idProduct`);

--
-- Contraintes pour la table `FavorisProductList`
--
ALTER TABLE `FavorisProductList`
  ADD CONSTRAINT `FavorisProductList_ibfk_1` FOREIGN KEY (`idGroup`) REFERENCES `Product` (`idProduct`),
  ADD CONSTRAINT `Fk_group` FOREIGN KEY (`idGroup`) REFERENCES `GroupList` (`idGroupList`);

--
-- Contraintes pour la table `GroupList`
--
ALTER TABLE `GroupList`
  ADD CONSTRAINT `FK_GroupList_idGroup` FOREIGN KEY (`idGroup`) REFERENCES `Group` (`idGroup`);

--
-- Contraintes pour la table `HistoryProductList`
--
ALTER TABLE `HistoryProductList`
  ADD CONSTRAINT `FK_HistoryProductList_idGroup` FOREIGN KEY (`idGroup`) REFERENCES `Group` (`idGroup`);

--
-- Contraintes pour la table `MessageSent`
--
ALTER TABLE `MessageSent`
  ADD CONSTRAINT `MessageSent_idGroup` FOREIGN KEY (`idGroup`) REFERENCES `Group` (`idGroup`),
  ADD CONSTRAINT `MessageSent_idUser` FOREIGN KEY (`idUser`) REFERENCES `User` (`idUser`);

--
-- Contraintes pour la table `PricedProductList`
--
ALTER TABLE `PricedProductList`
  ADD CONSTRAINT `FK_Group_Priced_Product_Group` FOREIGN KEY (`idGroupList`) REFERENCES `GroupList` (`idGroupList`),
  ADD CONSTRAINT `Fk_PricedProductList_product` FOREIGN KEY (`idProduct`) REFERENCES `Product` (`idProduct`);

--
-- Contraintes pour la table `Product`
--
ALTER TABLE `Product`
  ADD CONSTRAINT `FK_idGroup` FOREIGN KEY (`idGroup`) REFERENCES `Group` (`idGroup`),
  ADD CONSTRAINT `FK_idImage` FOREIGN KEY (`idImage`) REFERENCES `Image` (`idImage`);

--
-- Contraintes pour la table `QuantifiedProductList`
--
ALTER TABLE `QuantifiedProductList`
  ADD CONSTRAINT `QuantifiedProductList_ibfk_1` FOREIGN KEY (`idProduct`) REFERENCES `Product` (`idProduct`),
  ADD CONSTRAINT `QuantifiedProductList_ibfk_2` FOREIGN KEY (`idGroupList`) REFERENCES `GroupList` (`idGroupList`);

--
-- Contraintes pour la table `Stats`
--
ALTER TABLE `Stats`
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`idUser`) REFERENCES `User` (`idUser`);

--
-- Contraintes pour la table `UserDebt`
--
ALTER TABLE `UserDebt`
  ADD CONSTRAINT `FK_idFrom` FOREIGN KEY (`idFrom`) REFERENCES `User` (`idUser`),
  ADD CONSTRAINT `FK_idTo` FOREIGN KEY (`idTo`) REFERENCES `User` (`idUser`);

--
-- Contraintes pour la table `UserGroup`
--
ALTER TABLE `UserGroup`
  ADD CONSTRAINT `UserGroup_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `User` (`idUser`),
  ADD CONSTRAINT `UserGroup_ibfk_2` FOREIGN KEY (`idGroup`) REFERENCES `Group` (`idGroup`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
