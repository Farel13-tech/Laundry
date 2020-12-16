-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 16, 2020 at 04:07 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `laundry`
--

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `Tanggal` date NOT NULL,
  `Kode_Pelanggan` varchar(50) NOT NULL,
  `Nama_pelanggan` varchar(50) NOT NULL,
  `No_Telp` varchar(50) NOT NULL,
  `Alamat` text NOT NULL,
  `Berat_Pakaian` int(11) NOT NULL,
  `Harga` int(11) NOT NULL,
  `Total_Bayar` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`Tanggal`, `Kode_Pelanggan`, `Nama_pelanggan`, `No_Telp`, `Alamat`, `Berat_Pakaian`, `Harga`, `Total_Bayar`) VALUES
('2020-12-16', 'Guy', 'P002', '0895800482178', 'Jl Sutan Raja', 4, 6000, 12000),
('2020-12-16', 'P001', 'Farel', '1233122112121', 'Jl. Andi Mangerangi', 4, 6000, 24000),
('2020-12-16', 'Sakti', 'P002', '8958', 'Jl Sutan Raja', 1, 6000, 6000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`Kode_Pelanggan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
