-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-04-2023 a las 15:45:53
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tp3`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pronostico`
--

CREATE TABLE `pronostico` (
  `id` int(11) NOT NULL,
  `persona` varchar(40) NOT NULL,
  `equipo_local` varchar(40) NOT NULL,
  `equipo_visitante` varchar(40) NOT NULL,
  `resultado` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `pronostico`
--

INSERT INTO `pronostico` (`id`, `persona`, `equipo_local`, `equipo_visitante`, `resultado`) VALUES
(1, 'Clara', 'Qatar', 'Ecuador', 'l'),
(2, 'Clara', 'England', 'Iran', 'e'),
(3, 'Clara', 'Senegal', 'Netherlands', 'l'),
(4, 'Clara', 'USA', 'Wales', 'e'),
(5, 'Clara', 'Argentina', 'Saudi Arabia', 'e'),
(6, 'Clara', 'Denmark', 'Tunisia', 'v'),
(7, 'Clara', 'Mexico', 'Poland', 'l'),
(8, 'Clara', 'France', 'Australia', 'v'),
(9, 'Clara', 'Morocco', 'Croatia', 'l'),
(10, 'Clara', 'Germany', 'Japan', 'v'),
(11, 'Clara', 'Spain', 'Costa Rica', 'v'),
(12, 'Clara', 'Belgium', 'Canada', 'v'),
(13, 'Clara', 'Switzerland', 'Cameroon', 'e'),
(14, 'Clara', 'Uruguay', 'Korea Republic', 'l'),
(15, 'Clara', 'Portugal', 'Ghana', 'l'),
(16, 'Clara', 'Brazil', 'Serbia', 'v'),
(17, 'Clara', 'Wales', 'Iran', 'e'),
(18, 'Juana', 'Qatar', 'Ecuador', 'e'),
(19, 'Juana', 'England', 'Iran', 'v'),
(20, 'Juana', 'Senegal', 'Netherlands', 'e'),
(21, 'Juana', 'USA', 'Wales', 'v'),
(22, 'Juana', 'Argentina', 'Saudi Arabia', 'v'),
(23, 'Juana', 'Denmark', 'Tunisia', 'l'),
(24, 'Juana', 'Mexico', 'Poland', 'e'),
(25, 'Juana', 'France', 'Australia', 'l'),
(26, 'Juana', 'Morocco', 'Croatia', 'e'),
(27, 'Juana', 'Germany', 'Japan', 'l'),
(28, 'Juana', 'Spain', 'Costa Rica', 'l'),
(29, 'Juana', 'Belgium', 'Canada', 'l'),
(30, 'Juana', 'Switzerland', 'Cameroon', 'v'),
(31, 'Juana', 'Uruguay', 'Korea Republic', 'e'),
(32, 'Juana', 'Portugal', 'Ghana', 'e'),
(33, 'Juana', 'Brazil', 'Serbia', 'l'),
(34, 'Juana', 'Wales', 'Iran', 'v'),
(35, 'Ana', 'Qatar', 'Ecuador', 'v'),
(36, 'Ana', 'England', 'Iran', 'l'),
(37, 'Ana', 'Senegal', 'Netherlands', 'v'),
(38, 'Ana', 'USA', 'Wales', 'e'),
(39, 'Ana', 'Argentina', 'Saudi Arabia', 'l'),
(40, 'Ana', 'Denmark', 'Tunisia', 'e'),
(41, 'Ana', 'Mexico', 'Poland', 'v'),
(42, 'Ana', 'France', 'Australia', 'e'),
(43, 'Ana', 'Morocco', 'Croatia', 'v'),
(44, 'Ana', 'Germany', 'Japan', 'e'),
(45, 'Ana', 'Spain', 'Costa Rica', 'e'),
(46, 'Ana', 'Belgium', 'Canada', 'e'),
(47, 'Ana', 'Switzerland', 'Cameroon', 'l'),
(48, 'Ana', 'Uruguay', 'Korea Republic', 'v'),
(49, 'Ana', 'Portugal', 'Ghana', 'v'),
(50, 'Ana', 'Brazil', 'Serbia', 'e'),
(51, 'Ana', 'Wales', 'Iran', 'l'),
(52, 'Diana', 'Qatar', 'Ecuador', 'e'),
(53, 'Diana', 'England', 'Iran', 'e'),
(54, 'Diana', 'Senegal', 'Netherlands', 'e'),
(55, 'Diana', 'USA', 'Wales', 'e'),
(56, 'Diana', 'Argentina', 'Saudi Arabia', 'e'),
(57, 'Diana', 'Denmark', 'Tunisia', 'e'),
(58, 'Diana', 'Mexico', 'Poland', 'e'),
(59, 'Diana', 'France', 'Australia', 'e'),
(60, 'Diana', 'Morocco', 'Croatia', 'e'),
(61, 'Diana', 'Germany', 'Japan', 'v'),
(62, 'Diana', 'Spain', 'Costa Rica', 'l'),
(63, 'Diana', 'Belgium', 'Canada', 'l'),
(64, 'Diana', 'Switzerland', 'Cameroon', 'l'),
(65, 'Diana', 'Uruguay', 'Korea Republic', 'e'),
(66, 'Diana', 'Portugal', 'Ghana', 'l'),
(67, 'Diana', 'Brazil', 'Serbia', 'l'),
(68, 'Diana', 'Wales', 'Iran', 'v');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `pronostico`
--
ALTER TABLE `pronostico`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `pronostico`
--
ALTER TABLE `pronostico`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=69;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
