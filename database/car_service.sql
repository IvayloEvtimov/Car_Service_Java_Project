-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 04, 2020 at 05:01 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `car_service`
--

-- --------------------------------------------------------

--
-- Table structure for table `car`
--

CREATE TABLE `car` (
  `License_Plate` varchar(50) NOT NULL,
  `Owner` varchar(50) NOT NULL,
  `Model` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `car_brand`
--

CREATE TABLE `car_brand` (
  `Brand_Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `car_model`
--

CREATE TABLE `car_model` (
  `Car_Model` varchar(50) NOT NULL,
  `Car_Brand` varchar(50) NOT NULL,
  `Year_of_Manufacture` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `car_part`
--

CREATE TABLE `car_part` (
  `Part_Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `car_service`
--

CREATE TABLE `car_service` (
  `Service_ID` int(11) NOT NULL,
  `Garage` varchar(50) NOT NULL,
  `Employee` varchar(50) NOT NULL,
  `Client` varchar(50) NOT NULL,
  `Car` varchar(50) NOT NULL,
  `Car_Part` varchar(50) NOT NULL,
  `Needed_Qualification` varchar(50) NOT NULL,
  `Date_Of_Service` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `employment`
--

CREATE TABLE `employment` (
  `Garage` varchar(50) NOT NULL,
  `Employee` varchar(50) NOT NULL,
  `Date_Of_Hire` date NOT NULL,
  `Qualification` varchar(50) NOT NULL,
  `Salary` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `garage`
--

CREATE TABLE `garage` (
  `UIC` varchar(50) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Address` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `PID` varchar(50) NOT NULL,
  `First_Name` varchar(50) NOT NULL,
  `Last_Name` varchar(50) NOT NULL,
  `Date_Of_Brith` date NOT NULL,
  `date_of_birth` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `qualification`
--

CREATE TABLE `qualification` (
  `Qualification_Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `work_brand`
--

CREATE TABLE `work_brand` (
  `Garage` varchar(50) NOT NULL,
  `Brand` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`License_Plate`),
  ADD KEY `car_ibfk_1` (`Owner`),
  ADD KEY `Model` (`Model`);

--
-- Indexes for table `car_brand`
--
ALTER TABLE `car_brand`
  ADD PRIMARY KEY (`Brand_Name`);

--
-- Indexes for table `car_model`
--
ALTER TABLE `car_model`
  ADD PRIMARY KEY (`Car_Brand`,`Car_Model`),
  ADD KEY `Car_Model` (`Car_Model`);

--
-- Indexes for table `car_part`
--
ALTER TABLE `car_part`
  ADD PRIMARY KEY (`Part_Name`);

--
-- Indexes for table `car_service`
--
ALTER TABLE `car_service`
  ADD PRIMARY KEY (`Service_ID`),
  ADD KEY `Car` (`Car`),
  ADD KEY `Car_Part` (`Car_Part`),
  ADD KEY `Client` (`Client`),
  ADD KEY `Employee` (`Employee`),
  ADD KEY `Garage` (`Garage`),
  ADD KEY `Needed_Qualification` (`Needed_Qualification`);

--
-- Indexes for table `employment`
--
ALTER TABLE `employment`
  ADD PRIMARY KEY (`Garage`,`Employee`),
  ADD KEY `Employee` (`Employee`),
  ADD KEY `Qualification` (`Qualification`);

--
-- Indexes for table `garage`
--
ALTER TABLE `garage`
  ADD PRIMARY KEY (`UIC`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`PID`);

--
-- Indexes for table `qualification`
--
ALTER TABLE `qualification`
  ADD PRIMARY KEY (`Qualification_Name`);

--
-- Indexes for table `work_brand`
--
ALTER TABLE `work_brand`
  ADD PRIMARY KEY (`Garage`,`Brand`),
  ADD KEY `Brand` (`Brand`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `car_service`
--
ALTER TABLE `car_service`
  MODIFY `Service_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `car`
--
ALTER TABLE `car`
  ADD CONSTRAINT `car_ibfk_1` FOREIGN KEY (`Owner`) REFERENCES `person` (`PID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `car_ibfk_2` FOREIGN KEY (`Model`) REFERENCES `car_model` (`Car_Model`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `car_model`
--
ALTER TABLE `car_model`
  ADD CONSTRAINT `car_model_ibfk_1` FOREIGN KEY (`Car_Brand`) REFERENCES `car_brand` (`Brand_Name`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `car_service`
--
ALTER TABLE `car_service`
  ADD CONSTRAINT `car_service_ibfk_1` FOREIGN KEY (`Car`) REFERENCES `car` (`License_Plate`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `car_service_ibfk_2` FOREIGN KEY (`Car_Part`) REFERENCES `car_part` (`Part_Name`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `car_service_ibfk_3` FOREIGN KEY (`Client`) REFERENCES `person` (`PID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `car_service_ibfk_4` FOREIGN KEY (`Employee`) REFERENCES `employment` (`Employee`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `car_service_ibfk_5` FOREIGN KEY (`Garage`) REFERENCES `garage` (`UIC`),
  ADD CONSTRAINT `car_service_ibfk_6` FOREIGN KEY (`Needed_Qualification`) REFERENCES `qualification` (`Qualification_Name`);

--
-- Constraints for table `employment`
--
ALTER TABLE `employment`
  ADD CONSTRAINT `employment_ibfk_1` FOREIGN KEY (`Garage`) REFERENCES `garage` (`UIC`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `employment_ibfk_2` FOREIGN KEY (`Employee`) REFERENCES `person` (`PID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `employment_ibfk_3` FOREIGN KEY (`Qualification`) REFERENCES `qualification` (`Qualification_Name`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `work_brand`
--
ALTER TABLE `work_brand`
  ADD CONSTRAINT `work_brand_ibfk_1` FOREIGN KEY (`Garage`) REFERENCES `garage` (`UIC`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `work_brand_ibfk_2` FOREIGN KEY (`Brand`) REFERENCES `car_brand` (`Brand_Name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
