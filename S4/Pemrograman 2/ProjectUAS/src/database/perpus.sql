-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 31, 2022 at 12:07 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perpus`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_anggota`
--

CREATE TABLE `data_anggota` (
  `kode_anggota` varchar(5) NOT NULL,
  `npm` varchar(20) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `jenis_kelamin` varchar(10) NOT NULL,
  `jurusan` varchar(25) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `no_hp` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `data_buku`
--

CREATE TABLE `data_buku` (
  `kode_buku` varchar(5) NOT NULL,
  `judul_buku` varchar(100) NOT NULL,
  `penulis` varchar(100) NOT NULL,
  `tahun_penerbit` int(5) NOT NULL,
  `time_report` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data_buku`
--

INSERT INTO `data_buku` (`kode_buku`, `judul_buku`, `penulis`, `tahun_penerbit`, `time_report`) VALUES
('B0001', 'DASAR ALGORITMA DAN STRUKTUR DATA DENGAN BAHASA JAVA', 'Cipta Ramadhani, S.T.,M.Eng', 2015, '2022-07-31 05:26:18'),
('B0002', 'Pemrograman java untuk programmer', 'R. H. Sianipar', 2015, '2022-07-31 05:26:44'),
('B0003', 'Java : referensi lengkap untuk programer', ' RH. Sianipar', 2019, '2022-07-31 05:27:25'),
('B0004', 'J.A.V.A. : teori, algoritma, dan aplikasi', 'R.H. Sianipar', 2013, '2022-07-31 05:28:03');

-- --------------------------------------------------------

--
-- Table structure for table `data_peminjaman`
--

CREATE TABLE `data_peminjaman` (
  `kode_peminjaman` varchar(5) NOT NULL,
  `tanggal_pinjam` date NOT NULL,
  `tanggal_kembali` date NOT NULL,
  `kode_buku` varchar(5) NOT NULL,
  `kode_anggota` varchar(5) NOT NULL,
  `kode_petugas` varchar(5) NOT NULL,
  `time_report` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `data_pengembalian`
--

CREATE TABLE `data_pengembalian` (
  `kode_pengembalian` varchar(5) NOT NULL,
  `tanggal_kembali` date NOT NULL,
  `denda_perhari` int(11) NOT NULL,
  `total_hari` int(11) NOT NULL,
  `total_denda` int(11) NOT NULL,
  `kode_petugas` varchar(5) NOT NULL,
  `kode_anggota` varchar(5) NOT NULL,
  `kode_buku` varchar(5) NOT NULL,
  `time_report` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `data_petugas`
--

CREATE TABLE `data_petugas` (
  `kode_petugas` varchar(5) NOT NULL,
  `npm` varchar(20) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jenis_kelamin` varchar(20) NOT NULL,
  `no_telp` varchar(15) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data_petugas`
--

INSERT INTO `data_petugas` (`kode_petugas`, `npm`, `nama`, `jenis_kelamin`, `no_telp`, `username`, `password`) VALUES
('P0001', '43A87006200224', 'Ariyansa Yusuf Saputra', 'Pria', '082290000259', 'admin', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_anggota`
--
ALTER TABLE `data_anggota`
  ADD PRIMARY KEY (`kode_anggota`);

--
-- Indexes for table `data_buku`
--
ALTER TABLE `data_buku`
  ADD PRIMARY KEY (`kode_buku`);

--
-- Indexes for table `data_peminjaman`
--
ALTER TABLE `data_peminjaman`
  ADD PRIMARY KEY (`kode_peminjaman`),
  ADD KEY `kode_anggota` (`kode_anggota`),
  ADD KEY `kode_buku` (`kode_buku`),
  ADD KEY `kode_petugas` (`kode_petugas`);

--
-- Indexes for table `data_pengembalian`
--
ALTER TABLE `data_pengembalian`
  ADD PRIMARY KEY (`kode_pengembalian`),
  ADD KEY `kdoe_anggota` (`kode_anggota`),
  ADD KEY `kode_buku` (`kode_buku`),
  ADD KEY `kode_petugas` (`kode_petugas`);

--
-- Indexes for table `data_petugas`
--
ALTER TABLE `data_petugas`
  ADD PRIMARY KEY (`kode_petugas`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `data_peminjaman`
--
ALTER TABLE `data_peminjaman`
  ADD CONSTRAINT `data_peminjaman_ibfk_1` FOREIGN KEY (`kode_anggota`) REFERENCES `data_anggota` (`kode_anggota`),
  ADD CONSTRAINT `data_peminjaman_ibfk_2` FOREIGN KEY (`kode_buku`) REFERENCES `data_buku` (`kode_buku`),
  ADD CONSTRAINT `data_peminjaman_ibfk_3` FOREIGN KEY (`kode_petugas`) REFERENCES `data_petugas` (`kode_petugas`);

--
-- Constraints for table `data_pengembalian`
--
ALTER TABLE `data_pengembalian`
  ADD CONSTRAINT `data_pengembalian_ibfk_1` FOREIGN KEY (`kode_anggota`) REFERENCES `data_anggota` (`kode_anggota`),
  ADD CONSTRAINT `data_pengembalian_ibfk_2` FOREIGN KEY (`kode_buku`) REFERENCES `data_buku` (`kode_buku`),
  ADD CONSTRAINT `data_pengembalian_ibfk_3` FOREIGN KEY (`kode_petugas`) REFERENCES `data_petugas` (`kode_petugas`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
