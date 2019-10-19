-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  sam. 19 oct. 2019 à 10:58
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `fixit`
--

-- --------------------------------------------------------

--
-- Structure de la table `ad`
--

DROP TABLE IF EXISTS `ad`;
CREATE TABLE IF NOT EXISTS `ad` (
  `Id_ad` int(11) NOT NULL,
  `Id_provider` int(11) NOT NULL,
  `ad_name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `availability` datetime NOT NULL,
  `description` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  `published _at` timestamp NOT NULL,
  `image` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  KEY `provider_id_fk2` (`Id_provider`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `Id_admin` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`Id_admin`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `ask_service`
--

DROP TABLE IF EXISTS `ask_service`;
CREATE TABLE IF NOT EXISTS `ask_service` (
  `Id_ask_service` int(11) NOT NULL AUTO_INCREMENT,
  `Id_service` int(11) NOT NULL,
  `date` date NOT NULL,
  `duration` int(11) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `Id_client` int(11) NOT NULL,
  `Id_status` int(11) NOT NULL,
  PRIMARY KEY (`Id_ask_service`),
  KEY `service_id_fk` (`Id_service`),
  KEY `client_id_fk` (`Id_client`),
  KEY `status_id_fk` (`Id_status`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `Id_category` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `description` int(11) NOT NULL,
  PRIMARY KEY (`Id_category`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `Id_client` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone` int(11) NOT NULL,
  `mail` varchar(255) NOT NULL,
  `fidelity_pt` int(11) DEFAULT NULL,
  `image` text,
  PRIMARY KEY (`Id_client`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`Id_client`, `username`, `password`, `first_name`, `last_name`, `address`, `phone`, `mail`, `fidelity_pt`, `image`) VALUES
(2, 'aymenbm', 'qsdf', 'ay', 'bn', 'ariana', 0, '***@***.**', NULL, NULL),
(3, 'aymen', 'aze', 'aymbm', 'ben', 'ar', 123456789, 'aym@esprit.tn', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `comment`
--

DROP TABLE IF EXISTS `comment`;
CREATE TABLE IF NOT EXISTS `comment` (
  `Id_comment` int(11) NOT NULL AUTO_INCREMENT,
  `Id_client` int(11) NOT NULL,
  `description` text COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`Id_comment`),
  KEY `client_id_fk3` (`Id_client`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `c_claim`
--

DROP TABLE IF EXISTS `c_claim`;
CREATE TABLE IF NOT EXISTS `c_claim` (
  `Id_claimC` int(11) NOT NULL AUTO_INCREMENT,
  `Id_client` int(11) NOT NULL,
  `description` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`Id_claimC`),
  KEY `client_id_fk2` (`Id_client`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `provider`
--

DROP TABLE IF EXISTS `provider`;
CREATE TABLE IF NOT EXISTS `provider` (
  `Id_provider` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) NOT NULL,
  `password` varchar(30) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone` int(11) NOT NULL,
  `mail` varchar(255) NOT NULL,
  `rating` float DEFAULT NULL,
  `image` text,
  `like_nb` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id_provider`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `provider`
--

INSERT INTO `provider` (`Id_provider`, `username`, `password`, `first_name`, `last_name`, `address`, `phone`, `mail`, `rating`, `image`, `like_nb`) VALUES
(1, 'aymenbm', 'azerty', 'aymen', 'ben mehrez', 'ariana', 20843310, 'aymen.benmehrez@esprit.tn', NULL, NULL, NULL),
(2, 'aymenbm2', 'azerty', 'aymen', 'ben mehrez', 'ariana', 20843310, 'aymen.benmehrez@esprit.tn', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `provider_category`
--

DROP TABLE IF EXISTS `provider_category`;
CREATE TABLE IF NOT EXISTS `provider_category` (
  `Id_provider_category` int(11) NOT NULL AUTO_INCREMENT,
  `Id_provider` int(11) NOT NULL,
  `Id_category` int(11) NOT NULL,
  PRIMARY KEY (`Id_provider_category`),
  KEY `category_id_fk` (`Id_category`),
  KEY `provider_id_fk` (`Id_provider`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `p_claim`
--

DROP TABLE IF EXISTS `p_claim`;
CREATE TABLE IF NOT EXISTS `p_claim` (
  `Id_claimP` int(11) NOT NULL AUTO_INCREMENT,
  `Id_provider` int(11) NOT NULL,
  `description` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`Id_claimP`),
  KEY `provider_id_fk3` (`Id_provider`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `service`
--

DROP TABLE IF EXISTS `service`;
CREATE TABLE IF NOT EXISTS `service` (
  `Id_service` int(11) NOT NULL AUTO_INCREMENT,
  `Id_category` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`Id_service`),
  KEY `category_id_fk2` (`Id_category`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `service_status`
--

DROP TABLE IF EXISTS `service_status`;
CREATE TABLE IF NOT EXISTS `service_status` (
  `Id_status` int(11) NOT NULL AUTO_INCREMENT,
  `not_confirmed` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `confirmed` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `canceled` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `completed` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`Id_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `ad`
--
ALTER TABLE `ad`
  ADD CONSTRAINT `provider_id_fk2` FOREIGN KEY (`Id_provider`) REFERENCES `provider` (`Id_provider`);

--
-- Contraintes pour la table `ask_service`
--
ALTER TABLE `ask_service`
  ADD CONSTRAINT `client_id_fk` FOREIGN KEY (`Id_client`) REFERENCES `client` (`Id_client`),
  ADD CONSTRAINT `service_id_fk` FOREIGN KEY (`Id_service`) REFERENCES `service` (`Id_service`),
  ADD CONSTRAINT `status_id_fk` FOREIGN KEY (`Id_status`) REFERENCES `service_status` (`Id_status`);

--
-- Contraintes pour la table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `client_id_fk3` FOREIGN KEY (`Id_client`) REFERENCES `client` (`Id_client`);

--
-- Contraintes pour la table `c_claim`
--
ALTER TABLE `c_claim`
  ADD CONSTRAINT `client_id_fk2` FOREIGN KEY (`Id_client`) REFERENCES `client` (`Id_client`);

--
-- Contraintes pour la table `provider_category`
--
ALTER TABLE `provider_category`
  ADD CONSTRAINT `category_id_fk` FOREIGN KEY (`Id_category`) REFERENCES `category` (`Id_category`),
  ADD CONSTRAINT `provider_id_fk` FOREIGN KEY (`Id_provider`) REFERENCES `provider` (`Id_provider`);

--
-- Contraintes pour la table `p_claim`
--
ALTER TABLE `p_claim`
  ADD CONSTRAINT `provider_id_fk3` FOREIGN KEY (`Id_provider`) REFERENCES `provider` (`Id_provider`);

--
-- Contraintes pour la table `service`
--
ALTER TABLE `service`
  ADD CONSTRAINT `category_id_fk2` FOREIGN KEY (`Id_category`) REFERENCES `category` (`Id_category`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
