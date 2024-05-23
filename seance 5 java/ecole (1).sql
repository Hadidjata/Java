-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 07 juin 2023 à 12:04
-- Version du serveur : 10.4.28-MariaDB
-- Version de PHP : 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `ecole`
--

-- --------------------------------------------------------

--
-- Structure de la table `televe`
--

CREATE TABLE `televe` (
  `prenom` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `televe`
--

INSERT INTO `televe` (`prenom`, `nom`, `id`) VALUES
('fabio', 'cartolano', 1),
('quentin', 'durand', 2);

-- --------------------------------------------------------

--
-- Structure de la table `tnot`
--

CREATE TABLE `tnot` (
  `id` int(50) NOT NULL,
  `matiere` enum('maths','anglais','physique','informatique') NOT NULL,
  `valeur` int(50) NOT NULL,
  `eleveid` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `televe`
--
ALTER TABLE `televe`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- Index pour la table `tnot`
--
ALTER TABLE `tnot`
  ADD PRIMARY KEY (`id`),
  ADD KEY `eleveid` (`eleveid`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `televe`
--
ALTER TABLE `televe`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `tnot`
--
ALTER TABLE `tnot`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `tnot`
--
ALTER TABLE `tnot`
  ADD CONSTRAINT `tnot_ibfk_1` FOREIGN KEY (`eleveid`) REFERENCES `televe` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
