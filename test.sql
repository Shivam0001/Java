-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 25, 2020 at 02:55 PM
-- Server version: 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `custno` int(11) NOT NULL,
  `billno` int(11) NOT NULL,
  `Jan` float DEFAULT NULL,
  `Feb` float DEFAULT NULL,
  `Mar` float DEFAULT NULL,
  `Apr` float DEFAULT NULL,
  `May` float DEFAULT NULL,
  `Jun` float DEFAULT NULL,
  `Jul` float DEFAULT NULL,
  `Aug` float DEFAULT NULL,
  `Sep` float DEFAULT NULL,
  `Oct` float DEFAULT NULL,
  `Nov` float DEFAULT NULL,
  `Dece` float DEFAULT NULL,
  `units` int(11) NOT NULL,
  `feedback` varchar(100) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `billdate` date DEFAULT NULL,
  `subdate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`custno`, `billno`, `Jan`, `Feb`, `Mar`, `Apr`, `May`, `Jun`, `Jul`, `Aug`, `Sep`, `Oct`, `Nov`, `Dece`, `units`, `feedback`, `status`, `billdate`, `subdate`) VALUES
(101, 1, 400, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100, NULL, 'paid', '2018-11-25', '2018-11-25'),
(102, 1, 2000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 500, NULL, 'paid', '2018-11-25', '2018-11-25'),
(103, 2, 0, 400, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100, NULL, 'paid', '2018-12-24', '2018-12-24');

-- --------------------------------------------------------

--
-- Table structure for table `costperunit`
--

CREATE TABLE `costperunit` (
  `cost` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `costperunit`
--

INSERT INTO `costperunit` (`cost`) VALUES
(4);

-- --------------------------------------------------------

--
-- Table structure for table `registeruser`
--

CREATE TABLE `registeruser` (
  `r_id` int(10) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `cust_no` int(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `mobile` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registeruser`
--

INSERT INTO `registeruser` (`r_id`, `username`, `password`, `cust_no`, `name`, `mobile`, `email`, `address`) VALUES
(21, 'shivam', 'jaswal', 103, 'Shivam', '8899775502', 's@gmail.com', 'ddun');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`custno`,`billno`);

--
-- Indexes for table `registeruser`
--
ALTER TABLE `registeruser`
  ADD PRIMARY KEY (`cust_no`),
  ADD UNIQUE KEY `UNIQUE` (`r_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `registeruser`
--
ALTER TABLE `registeruser`
  MODIFY `r_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
