-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 26. Jan 2022 um 16:17
-- Server-Version: 10.4.22-MariaDB
-- PHP-Version: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `vehicles`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `person`
--

CREATE TABLE `person` (
  `id` bigint(20) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `prename` varchar(255) NOT NULL,
  `hair_colour` varchar(255) NOT NULL,
  `size` double NOT NULL,
  `address` varchar(255) NOT NULL,
  `house_number` int(11) NOT NULL,
  `plz` int(11) NOT NULL,
  `place` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `person`
--

INSERT INTO `person` (`id`, `lastname`, `prename`, `hair_colour`, `size`, `address`, `house_number`, `plz`, `place`) VALUES
(3, 'Lysser', 'Simon', 'Brown', 1.8, 'Sonnenbühlstrasse', 2, 8305, 'Dietlikon'),
(4, 'Meier', 'Yanic', 'Brown', 1.8, 'Mühlenweg', 42, 8050, 'Zürich'),
(5, 'sadgdgf', 'dhdhdh', 'fdgfgj', 1.3, 'dshdhdh', 44, 3456, 'dagdfg'),
(6, 'skgjkksg', 'skldksglkfg', 'sklsdfkgksfg', 1.4, 'sdlkkfsdg', 33, 3456, 'ksdiifd'),
(7, 'skgjkksg', 'skldksglkfg', 'sklsdfkgksfg', 1.4, 'sdlkkfsdg', 33, 1000, 'ksdiifd');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `vehicle`
--

CREATE TABLE `vehicle` (
  `id` bigint(20) NOT NULL,
  `person_id` bigint(20) NOT NULL,
  `colour` varchar(255) NOT NULL,
  `seats` int(11) NOT NULL,
  `doors` int(11) NOT NULL,
  `plate` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `vehicle`
--

INSERT INTO `vehicle` (`id`, `person_id`, `colour`, `seats`, `doors`, `plate`) VALUES
(3, 3, 'Black', 5, 5, 'ZH123456');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `vehicle`
--
ALTER TABLE `vehicle`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_vehicle_person` (`person_id`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `person`
--
ALTER TABLE `person`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT für Tabelle `vehicle`
--
ALTER TABLE `vehicle`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `vehicle`
--
ALTER TABLE `vehicle`
  ADD CONSTRAINT `fk_vehicle_person` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
