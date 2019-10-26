-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  sam. 26 oct. 2019 à 11:26
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
-- Base de données :  `fixit3`
--

-- --------------------------------------------------------

--
-- Structure de la table `ad`
--

DROP TABLE IF EXISTS `ad`;
CREATE TABLE IF NOT EXISTS `ad` (
  `ad_id` int(11) NOT NULL,
  `provider_id` int(11) NOT NULL,
  `ad_name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `availability` datetime NOT NULL,
  `description` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  `published _at` timestamp NOT NULL,
  `image` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `Nb_Likes` int(11) NOT NULL,
  KEY `provider_id_fk2` (`provider_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `ask_service`
--

DROP TABLE IF EXISTS `ask_service`;
CREATE TABLE IF NOT EXISTS `ask_service` (
  `ask_service_id` int(11) NOT NULL AUTO_INCREMENT,
  `service_id` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `duration` varchar(20) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `client_id` int(11) NOT NULL,
  `isconfirmed` tinyint(1) NOT NULL DEFAULT '0',
  `isnotconfirmed` tinyint(1) NOT NULL DEFAULT '1',
  `iscanceled` tinyint(1) NOT NULL DEFAULT '0',
  `isfinished` tinyint(1) NOT NULL DEFAULT '0',
  `started_at` varchar(30) NOT NULL,
  PRIMARY KEY (`ask_service_id`),
  KEY `service_id_fk` (`service_id`),
  KEY `client_id_fk` (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ask_service`
--

INSERT INTO `ask_service` (`ask_service_id`, `service_id`, `date`, `duration`, `description`, `client_id`, `isconfirmed`, `isnotconfirmed`, `iscanceled`, `isfinished`, `started_at`) VALUES
(21, 21, '2019-10-23', '3h et demi', 'test edit', 3, 0, 1, 0, 0, '09:00 GMT'),
(22, 21, '2019-10-09', 'aze', 'test', 3, 0, 1, 0, 0, '08:00 GMT');

-- --------------------------------------------------------

--
-- Structure de la table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `category`
--

INSERT INTO `category` (`category_id`, `name`, `description`) VALUES
(10, 'gardening', ''),
(20, 'Plumbing', ''),
(30, 'electricity', '');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `client_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone` int(11) NOT NULL,
  `mail` varchar(255) NOT NULL,
  `fidelity_pt` int(11) DEFAULT NULL,
  `image` text,
  PRIMARY KEY (`client_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`client_id`, `username`, `password`, `first_name`, `last_name`, `address`, `phone`, `mail`, `fidelity_pt`, `image`) VALUES
(2, 'aymenbm', 'qsdf', 'ay', 'bn', 'ariana', 0, '***@***.**', NULL, NULL),
(3, 'aymen', 'aze', 'aymbm', 'ben', 'ar', 123456789, 'aym@esprit.tn', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `comment`
--

DROP TABLE IF EXISTS `comment`;
CREATE TABLE IF NOT EXISTS `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) NOT NULL,
  `ad_id` int(11) NOT NULL,
  `description` text COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `client_id_fk3` (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `c_claim`
--

DROP TABLE IF EXISTS `c_claim`;
CREATE TABLE IF NOT EXISTS `c_claim` (
  `claim_id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) NOT NULL,
  `description` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`claim_id`),
  KEY `client_id_fk2` (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `c_claim`
--

INSERT INTO `c_claim` (`claim_id`, `client_id`, `description`) VALUES
(1, 3, 'help !!'),
(2, 3, 'my jobber never came !');

-- --------------------------------------------------------

--
-- Structure de la table `provider`
--

DROP TABLE IF EXISTS `provider`;
CREATE TABLE IF NOT EXISTS `provider` (
  `provider_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) NOT NULL,
  `password` varchar(30) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone` int(11) NOT NULL,
  `mail` varchar(255) NOT NULL,
  `rating` float DEFAULT NULL,
  `image` text,
  PRIMARY KEY (`provider_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `provider`
--

INSERT INTO `provider` (`provider_id`, `username`, `password`, `first_name`, `last_name`, `address`, `phone`, `mail`, `rating`, `image`) VALUES
(1, 'aymenbm', 'azerty', 'aymen', 'ben mehrez', 'ariana', 20843310, 'aymen.benmehrez@esprit.tn', NULL, NULL),
(2, 'aymenbm2', 'azerty', 'aymen', 'ben mehrez', 'ariana', 20843310, 'aymen.benmehrez@esprit.tn', NULL, NULL),
(3, 'rihabbm', 'abcd2067458', 'rihab', 'ben mansour', 'bizerte', 22222222, 'benmansourrihab7@gmail.com', 5, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `provider_category`
--

DROP TABLE IF EXISTS `provider_category`;
CREATE TABLE IF NOT EXISTS `provider_category` (
  `provider_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `provider_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  PRIMARY KEY (`provider_category_id`),
  KEY `category_id_fk` (`category_id`),
  KEY `provider_id_fk` (`provider_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `p_claim`
--

DROP TABLE IF EXISTS `p_claim`;
CREATE TABLE IF NOT EXISTS `p_claim` (
  `p_claim_id` int(11) NOT NULL AUTO_INCREMENT,
  `provider_id` int(11) NOT NULL,
  `description` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`p_claim_id`),
  KEY `provider_id_fk3` (`provider_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `p_claim`
--

INSERT INTO `p_claim` (`p_claim_id`, `provider_id`, `description`) VALUES
(1, 2, 'i never got payed for my services '),
(2, 1, 'he gave me a wrong address');

-- --------------------------------------------------------

--
-- Structure de la table `service`
--

DROP TABLE IF EXISTS `service`;
CREATE TABLE IF NOT EXISTS `service` (
  `service_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`service_id`),
  KEY `category_id_fk2` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1236 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `service`
--

INSERT INTO `service` (`service_id`, `category_id`, `name`) VALUES
(11, 10, 'cut a tree'),
(12, 10, 'storing wood'),
(21, 20, 'change a faucet'),
(22, 20, 'water leak repair'),
(31, 30, 'electrical outlet installation'),
(32, 30, 'change a light bulb');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `ad`
--
ALTER TABLE `ad`
  ADD CONSTRAINT `provider_id_fk2` FOREIGN KEY (`provider_id`) REFERENCES `provider` (`provider_id`);

--
-- Contraintes pour la table `ask_service`
--
ALTER TABLE `ask_service`
  ADD CONSTRAINT `client_id_fk` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`),
  ADD CONSTRAINT `service_id_fk` FOREIGN KEY (`service_id`) REFERENCES `service` (`service_id`);

--
-- Contraintes pour la table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `client_id_fk3` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`);

--
-- Contraintes pour la table `c_claim`
--
ALTER TABLE `c_claim`
  ADD CONSTRAINT `client_id_fk2` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`);

--
-- Contraintes pour la table `provider_category`
--
ALTER TABLE `provider_category`
  ADD CONSTRAINT `category_id_fk` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`),
  ADD CONSTRAINT `provider_id_fk` FOREIGN KEY (`provider_id`) REFERENCES `provider` (`provider_id`);

--
-- Contraintes pour la table `p_claim`
--
ALTER TABLE `p_claim`
  ADD CONSTRAINT `provider_id_fk3` FOREIGN KEY (`provider_id`) REFERENCES `provider` (`provider_id`);

--
-- Contraintes pour la table `service`
--
ALTER TABLE `service`
  ADD CONSTRAINT `category_id_fk2` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
