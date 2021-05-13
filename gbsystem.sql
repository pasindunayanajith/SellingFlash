-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 24, 2021 at 10:55 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gbsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `buyer`
--

CREATE TABLE `buyer` (
  `buyerID` int(11) NOT NULL,
  `buyerFname` varchar(100) NOT NULL,
  `buyerLname` varchar(100) NOT NULL,
  `buyerGender` varchar(100) NOT NULL,
  `buyerAddress` varchar(100) NOT NULL,
  `buyerPhone` varchar(100) NOT NULL,
  `buyerNic` varchar(100) NOT NULL,
  `buyerBirthday` date NOT NULL,
  `buyerEmail` varchar(100) NOT NULL,
  `buyerPassword` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `buyer`
--

INSERT INTO `buyer` (`buyerID`, `buyerFname`, `buyerLname`, `buyerGender`, `buyerAddress`, `buyerPhone`, `buyerNic`, `buyerBirthday`, `buyerEmail`, `buyerPassword`) VALUES
(1, 'pasindu', 'nayanajith', 'female', '34/A ,lake round,kurunegala', '011-65656555', '199827004122', '1998-03-03', 'pasi@gmail.com', 'pasiya'),
(3, 'Kasal', 'dalshan', 'male', '24/A parakumawatha,kurunegala', '037-2230021', '1911200123', '2021-09-12', 'daloo1@gmail.com', 'das@@s');

-- --------------------------------------------------------

--
-- Table structure for table `fundingbodies`
--

CREATE TABLE `fundingbodies` (
  `fbID` int(11) NOT NULL,
  `fbName` varchar(100) NOT NULL,
  `fbAddress` varchar(100) NOT NULL,
  `fbPhone` varchar(100) NOT NULL,
  `fbEmail` varchar(100) NOT NULL,
  `fbPassword` varchar(100) NOT NULL,
  `fbDescription` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `fundingbodies`
--

INSERT INTO `fundingbodies` (`fbID`, `fbName`, `fbAddress`, `fbPhone`, `fbEmail`, `fbPassword`, `fbDescription`) VALUES
(1, 'Avenra rek', '24/A parakun road,colombo', '090-8908989', 'kjhj@gmail.com', 'jknkjn', 'We need state-of-the-art bank management software'),
(2, 'Xwiz PVT', '24/A avendra,malabe', '099-1283483', 'adnra34@gmail.com', 'asdsds', 'We are Funding IOT for New Researchers');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `paymantID` int(11) NOT NULL,
  `paymentType` varchar(100) NOT NULL,
  `paymentAmount` double NOT NULL,
  `paymentDate` date NOT NULL DEFAULT current_timestamp(),
  `paymentPostaladdress` varchar(100) NOT NULL,
  `paymentPostalcode` varchar(100) NOT NULL,
  `buyerID` int(11) NOT NULL,
  `productID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`paymantID`, `paymentType`, `paymentAmount`, `paymentDate`, `paymentPostaladdress`, `paymentPostalcode`, `buyerID`, `productID`) VALUES
(1, 'Debit Card', 1250, '2021-02-03', '34/A caoassd road,Kurunegala,Sri Lanka', '6000', 2, 1),
(3, 'Debit Card', 4500, '2020-04-15', '34/wdweef/ewfw/colombo/Sri lanka', '9000', 1, 2),
(4, 'Credit card', 4500, '2020-01-31', '23/B nama,das', '8909', 3, 3),
(5, 'Debit', 9500, '2021-04-21', '23/B nama,das', '8909', 3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `productID` int(11) NOT NULL,
  `productName` varchar(100) NOT NULL,
  `productItemcode` varchar(100) NOT NULL,
  `productPrice` double NOT NULL,
  `productStock` varchar(100) NOT NULL,
  `productDescription` varchar(600) NOT NULL,
  `researcherID` int(11) NOT NULL,
  `embledCode1` varchar(450) DEFAULT NULL,
  `embledCode2` varchar(450) DEFAULT NULL,
  `delivertime` varchar(100) NOT NULL,
  `availability` varchar(100) NOT NULL,
  `approval` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`productID`, `productName`, `productItemcode`, `productPrice`, `productStock`, `productDescription`, `researcherID`, `embledCode1`, `embledCode2`, `delivertime`, `availability`, `approval`) VALUES
(1, 'Online Learing System', 'ww1010', 1250, 'Kurunegala', 'It is the best tool for you to continue your education formally', 1, NULL, NULL, 'Within 2 Weeks', 'YES', 'NO'),
(2, 'Electronic Robot', 'ee1200', 1170, 'Colombo', 'Is of very high value. Is a more efficient application', 2, '<frame>href=`paypal.com/itmeee1200/thishi/2` display=`visible`</frame>', '<frame>href=`credit.com/itmeee1200/thishi/2` display=`visible`</frame>', 'Within 9 Weeks', 'NO', 'YES'),
(3, 'High speed Network Cable', 'ss4009', 3500, 'Colombo', 'We believe this is the best way to share your data faster', 2, '<frame>href=`paypal.com/itmeee1200/pasindu/2` display=`visible`</frame>', '<frame>href=`credit.com/itmeee1200/pasindu/2` display=`visible`</frame>', 'Within 5 Weeks', 'YES', 'YES'),
(4, 'system ki', 'sk1200', 350000, 'Colombo', 'These are the best solution for you as they are the latest software that will help you to create any kind of regex online\r\n', 2, NULL, NULL, 'Within  2 Weeks', 'NO', 'NO');

-- --------------------------------------------------------

--
-- Table structure for table `researcher`
--

CREATE TABLE `researcher` (
  `researcherID` int(11) NOT NULL,
  `researcherFname` varchar(100) NOT NULL,
  `researcherLname` varchar(100) NOT NULL,
  `researcherGender` varchar(100) NOT NULL,
  `researcherNic` varchar(100) NOT NULL,
  `researcherPhone` varchar(100) NOT NULL,
  `researcherBirthday` date NOT NULL,
  `researcherEmail` varchar(100) NOT NULL,
  `researcherPassword` varchar(100) NOT NULL,
  `researchDetails` varchar(250) NOT NULL,
  `accountnumber` varchar(100) NOT NULL,
  `bankname` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `researcher`
--

INSERT INTO `researcher` (`researcherID`, `researcherFname`, `researcherLname`, `researcherGender`, `researcherNic`, `researcherPhone`, `researcherBirthday`, `researcherEmail`, `researcherPassword`, `researchDetails`, `accountnumber`, `bankname`) VALUES
(1, 'shani', 'dasanayake', 'Female', '199827002100', '132-7878099', '1996-03-16', 'pasin@gmail.com', 'Shanksd909', 'New Electrical Robat', '351300351311', 'BOC Bank'),
(3, 'sadun', 'dasanayake', 'male', '19998789095', '102-7878999', '1996-03-12', 'sadun@gmail.com', 'adsfswf', 'IOT using New Thingst', '351771351311', 'selan Bank'),
(4, 'kamal', 'sadaru', 'male', '199789654789', '789-49989888', '1997-02-12', 'sadru@gmail.com', 'iuhniunh', 'ionb', '9897987897', 'jknkjnkj'),
(5, 'jkbkjbjk', 'bkjbjkb', 'female', '7898798798700', '987-09090987', '1995-09-21', 'kjbkj333@gmail.com', 'uigiu8', 'uibiubiubuib', '987897897987', 'jhbhjb');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buyer`
--
ALTER TABLE `buyer`
  ADD PRIMARY KEY (`buyerID`),
  ADD UNIQUE KEY `buyerNic` (`buyerNic`),
  ADD UNIQUE KEY `buyerEmail` (`buyerEmail`);

--
-- Indexes for table `fundingbodies`
--
ALTER TABLE `fundingbodies`
  ADD PRIMARY KEY (`fbID`),
  ADD UNIQUE KEY `fbEmail` (`fbEmail`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`paymantID`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`productID`),
  ADD UNIQUE KEY `productItemcode` (`productItemcode`);

--
-- Indexes for table `researcher`
--
ALTER TABLE `researcher`
  ADD PRIMARY KEY (`researcherID`),
  ADD UNIQUE KEY `researcherEmail` (`researcherEmail`),
  ADD UNIQUE KEY `researcherNic` (`researcherNic`),
  ADD UNIQUE KEY `accountnumber` (`accountnumber`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `buyer`
--
ALTER TABLE `buyer`
  MODIFY `buyerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `fundingbodies`
--
ALTER TABLE `fundingbodies`
  MODIFY `fbID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `paymantID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `productID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `researcher`
--
ALTER TABLE `researcher`
  MODIFY `researcherID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
