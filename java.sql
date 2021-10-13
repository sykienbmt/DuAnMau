USE [master]
GO
/****** Object:  Database [Java]    Script Date: 10/14/2021 12:14:51 AM ******/
CREATE DATABASE [Java]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Java', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Java.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Java_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Java_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [Java] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Java].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Java] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Java] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Java] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Java] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Java] SET ARITHABORT OFF 
GO
ALTER DATABASE [Java] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Java] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Java] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Java] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Java] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Java] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Java] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Java] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Java] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Java] SET  ENABLE_BROKER 
GO
ALTER DATABASE [Java] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Java] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Java] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Java] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Java] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Java] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Java] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Java] SET RECOVERY FULL 
GO
ALTER DATABASE [Java] SET  MULTI_USER 
GO
ALTER DATABASE [Java] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Java] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Java] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Java] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Java] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Java] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'Java', N'ON'
GO
ALTER DATABASE [Java] SET QUERY_STORE = OFF
GO
USE [Java]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 10/14/2021 12:14:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[idAcc] [int] IDENTITY(1,1) NOT NULL,
	[ten] [nvarchar](50) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[pass] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idAcc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietDichVu]    Script Date: 10/14/2021 12:14:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietDichVu](
	[idHoaDonDichVu] [int] NOT NULL,
	[idDichVu] [int] NOT NULL,
	[soLanSuDung] [varchar](3) NOT NULL,
	[ngaySuDung] [date] NOT NULL,
	[thanhTien] [float] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChucVu]    Script Date: 10/14/2021 12:14:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChucVu](
	[idChucVu] [int] IDENTITY(1,1) NOT NULL,
	[tenChucVu] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idChucVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DichVu]    Script Date: 10/14/2021 12:14:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DichVu](
	[idDichVu] [int] IDENTITY(1,1) NOT NULL,
	[tenDichVu] [nvarchar](100) NOT NULL,
	[gia] [float] NOT NULL,
	[idDonVi] [int] NULL,
	[anhSanPham] [image] NULL,
PRIMARY KEY CLUSTERED 
(
	[idDichVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[donViTinh]    Script Date: 10/14/2021 12:14:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[donViTinh](
	[idDonVi] [int] IDENTITY(1,1) NOT NULL,
	[tenDonVi] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idDonVi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonDichVu]    Script Date: 10/14/2021 12:14:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonDichVu](
	[idHoaDonDichVu] [int] IDENTITY(1,1) NOT NULL,
	[idPhong] [int] NOT NULL,
	[tongTien] [float] NOT NULL,
	[ngayTao] [date] NOT NULL,
	[moTa] [nvarchar](200) NULL,
	[trangThai] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[idHoaDonDichVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 10/14/2021 12:14:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[soCMND] [varchar](12) NOT NULL,
	[tenKhach] [nvarchar](50) NOT NULL,
	[diaChi] [nvarchar](150) NULL,
	[hoChieu] [varchar](15) NULL,
	[soDT] [char](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[soCMND] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiPhong]    Script Date: 10/14/2021 12:14:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiPhong](
	[idLoaiPhong] [int] IDENTITY(1,1) NOT NULL,
	[tenLoaiPhong] [nvarchar](20) NOT NULL,
	[giaGio] [float] NOT NULL,
	[giaNgay] [float] NULL,
	[giaThang] [float] NULL,
	[giaQuy] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[idLoaiPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 10/14/2021 12:14:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[idNhanVien] [int] IDENTITY(1,1) NOT NULL,
	[ten] [nvarchar](50) NOT NULL,
	[email] [varchar](100) NOT NULL,
	[sdt] [varchar](10) NOT NULL,
	[sex] [nvarchar](5) NOT NULL,
	[luong] [float] NOT NULL,
	[idChucVu] [int] NOT NULL,
	[diaChi] [nvarchar](100) NOT NULL,
	[ngaySinh] [date] NOT NULL,
	[ngayVaoLam] [date] NOT NULL,
	[trangThai] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[phieuThuePhong]    Script Date: 10/14/2021 12:14:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[phieuThuePhong](
	[idPhieuThue] [int] IDENTITY(1,1) NOT NULL,
	[idPhong] [int] NOT NULL,
	[soCMND] [varchar](12) NOT NULL,
	[idNhanVien] [int] NOT NULL,
	[soNguoi] [int] NOT NULL,
	[ngayDat] [datetime] NOT NULL,
	[ngayDi] [datetime] NULL,
	[hinhThucThue] [nvarchar](50) NULL,
 CONSTRAINT [PK__phieuThu__27BC5A6976D4E20E] PRIMARY KEY CLUSTERED 
(
	[idPhieuThue] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Phong]    Script Date: 10/14/2021 12:14:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Phong](
	[idPhong] [int] IDENTITY(1,1) NOT NULL,
	[idLoaiPhong] [int] NOT NULL,
	[tenPhong] [nvarchar](10) NOT NULL,
	[soKhachMax] [varchar](2) NOT NULL,
	[ngayDat] [date] NOT NULL,
	[trangThai] [nvarchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Account] ON 

INSERT [dbo].[Account] ([idAcc], [ten], [email], [pass]) VALUES (1, N'Anh', N'a@gmail.com', N'123')
INSERT [dbo].[Account] ([idAcc], [ten], [email], [pass]) VALUES (2, N'admin', N'admin', N'admin')
SET IDENTITY_INSERT [dbo].[Account] OFF
GO
INSERT [dbo].[ChiTietDichVu] ([idHoaDonDichVu], [idDichVu], [soLanSuDung], [ngaySuDung], [thanhTien]) VALUES (1, 1, N'2', CAST(N'2020-12-12' AS Date), 10000)
INSERT [dbo].[ChiTietDichVu] ([idHoaDonDichVu], [idDichVu], [soLanSuDung], [ngaySuDung], [thanhTien]) VALUES (1, 1, N'2', CAST(N'2021-10-11' AS Date), 1000)
INSERT [dbo].[ChiTietDichVu] ([idHoaDonDichVu], [idDichVu], [soLanSuDung], [ngaySuDung], [thanhTien]) VALUES (1, 6, N'5', CAST(N'2021-10-11' AS Date), 50000)
INSERT [dbo].[ChiTietDichVu] ([idHoaDonDichVu], [idDichVu], [soLanSuDung], [ngaySuDung], [thanhTien]) VALUES (4, 1, N'1', CAST(N'2021-10-13' AS Date), 5000)
INSERT [dbo].[ChiTietDichVu] ([idHoaDonDichVu], [idDichVu], [soLanSuDung], [ngaySuDung], [thanhTien]) VALUES (4, 6, N'4', CAST(N'2021-10-13' AS Date), 40000)
INSERT [dbo].[ChiTietDichVu] ([idHoaDonDichVu], [idDichVu], [soLanSuDung], [ngaySuDung], [thanhTien]) VALUES (4, 2, N'1', CAST(N'2021-10-13' AS Date), 2000)
INSERT [dbo].[ChiTietDichVu] ([idHoaDonDichVu], [idDichVu], [soLanSuDung], [ngaySuDung], [thanhTien]) VALUES (4, 6, N'1', CAST(N'2021-10-13' AS Date), 10000)
GO
SET IDENTITY_INSERT [dbo].[ChucVu] ON 

INSERT [dbo].[ChucVu] ([idChucVu], [tenChucVu]) VALUES (1, N'Admin')
INSERT [dbo].[ChucVu] ([idChucVu], [tenChucVu]) VALUES (2, N'Quản lý')
INSERT [dbo].[ChucVu] ([idChucVu], [tenChucVu]) VALUES (3, N'Lễ tân')
INSERT [dbo].[ChucVu] ([idChucVu], [tenChucVu]) VALUES (4, N'Kế toán')
SET IDENTITY_INSERT [dbo].[ChucVu] OFF
GO
SET IDENTITY_INSERT [dbo].[DichVu] ON 

INSERT [dbo].[DichVu] ([idDichVu], [tenDichVu], [gia], [idDonVi], [anhSanPham]) VALUES (1, N'Giặt ủi', 5000, 1, NULL)
INSERT [dbo].[DichVu] ([idDichVu], [tenDichVu], [gia], [idDonVi], [anhSanPham]) VALUES (2, N'Dọn phòng', 2000, 1, NULL)
INSERT [dbo].[DichVu] ([idDichVu], [tenDichVu], [gia], [idDonVi], [anhSanPham]) VALUES (3, N'Buổi sáng', 1000, 1, NULL)
INSERT [dbo].[DichVu] ([idDichVu], [tenDichVu], [gia], [idDonVi], [anhSanPham]) VALUES (4, N'Giặt trưa', 1000, 1, NULL)
INSERT [dbo].[DichVu] ([idDichVu], [tenDichVu], [gia], [idDonVi], [anhSanPham]) VALUES (5, N'Giặt tối', 2000, 1, NULL)
INSERT [dbo].[DichVu] ([idDichVu], [tenDichVu], [gia], [idDonVi], [anhSanPham]) VALUES (6, N'Sting', 10000, 6, NULL)
SET IDENTITY_INSERT [dbo].[DichVu] OFF
GO
SET IDENTITY_INSERT [dbo].[donViTinh] ON 

INSERT [dbo].[donViTinh] ([idDonVi], [tenDonVi]) VALUES (1, N'xuất')
INSERT [dbo].[donViTinh] ([idDonVi], [tenDonVi]) VALUES (2, N'ly')
INSERT [dbo].[donViTinh] ([idDonVi], [tenDonVi]) VALUES (3, N'lon')
INSERT [dbo].[donViTinh] ([idDonVi], [tenDonVi]) VALUES (4, N'hộp')
INSERT [dbo].[donViTinh] ([idDonVi], [tenDonVi]) VALUES (5, N'gói')
INSERT [dbo].[donViTinh] ([idDonVi], [tenDonVi]) VALUES (6, N'chai')
SET IDENTITY_INSERT [dbo].[donViTinh] OFF
GO
SET IDENTITY_INSERT [dbo].[HoaDonDichVu] ON 

INSERT [dbo].[HoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTien], [ngayTao], [moTa], [trangThai]) VALUES (1, 1, 10000, CAST(N'2021-08-08' AS Date), NULL, 0)
INSERT [dbo].[HoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTien], [ngayTao], [moTa], [trangThai]) VALUES (2, 2, 15000, CAST(N'2021-08-08' AS Date), NULL, 0)
INSERT [dbo].[HoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTien], [ngayTao], [moTa], [trangThai]) VALUES (3, 3, 5000, CAST(N'2021-08-08' AS Date), NULL, 0)
INSERT [dbo].[HoaDonDichVu] ([idHoaDonDichVu], [idPhong], [tongTien], [ngayTao], [moTa], [trangThai]) VALUES (4, 3, 0, CAST(N'2021-10-11' AS Date), N'khong', 1)
SET IDENTITY_INSERT [dbo].[HoaDonDichVu] OFF
GO
INSERT [dbo].[KhachHang] ([soCMND], [tenKhach], [diaChi], [hoChieu], [soDT]) VALUES (N'987654321', N'Đông sì ke', N'bmt', NULL, N'0999111111')
GO
SET IDENTITY_INSERT [dbo].[LoaiPhong] ON 

INSERT [dbo].[LoaiPhong] ([idLoaiPhong], [tenLoaiPhong], [giaGio], [giaNgay], [giaThang], [giaQuy]) VALUES (1, N'Phòng Đơn', 60000, 120000, 1500000, 3500000)
INSERT [dbo].[LoaiPhong] ([idLoaiPhong], [tenLoaiPhong], [giaGio], [giaNgay], [giaThang], [giaQuy]) VALUES (2, N'Phòng Đôi', 80000, 150000, 2000000, 4000000)
INSERT [dbo].[LoaiPhong] ([idLoaiPhong], [tenLoaiPhong], [giaGio], [giaNgay], [giaThang], [giaQuy]) VALUES (3, N'Phòng Chung', 90000, 180000, 2200000, 4200000)
INSERT [dbo].[LoaiPhong] ([idLoaiPhong], [tenLoaiPhong], [giaGio], [giaNgay], [giaThang], [giaQuy]) VALUES (4, N'Phòng VIP', 100000, 200000, 2500000, 4500000)
INSERT [dbo].[LoaiPhong] ([idLoaiPhong], [tenLoaiPhong], [giaGio], [giaNgay], [giaThang], [giaQuy]) VALUES (5, N'Phòng President', 200000, 350000, 4000000, 6000000)
SET IDENTITY_INSERT [dbo].[LoaiPhong] OFF
GO
SET IDENTITY_INSERT [dbo].[NhanVien] ON 

INSERT [dbo].[NhanVien] ([idNhanVien], [ten], [email], [sdt], [sex], [luong], [idChucVu], [diaChi], [ngaySinh], [ngayVaoLam], [trangThai]) VALUES (1, N'Anh ăn shit', N'a1111nh@gmail.com', N'0941790507', N'Nữ', 100000, 1, N'campuchia', CAST(N'1997-08-08' AS Date), CAST(N'2020-12-12' AS Date), N'ON')
SET IDENTITY_INSERT [dbo].[NhanVien] OFF
GO
SET IDENTITY_INSERT [dbo].[phieuThuePhong] ON 

INSERT [dbo].[phieuThuePhong] ([idPhieuThue], [idPhong], [soCMND], [idNhanVien], [soNguoi], [ngayDat], [ngayDi], [hinhThucThue]) VALUES (4, 1, N'987654321', 1, 2, CAST(N'2021-01-01T00:00:00.000' AS DateTime), NULL, N'Giờ-60000.0')
INSERT [dbo].[phieuThuePhong] ([idPhieuThue], [idPhong], [soCMND], [idNhanVien], [soNguoi], [ngayDat], [ngayDi], [hinhThucThue]) VALUES (5, 3, N'987654321', 1, 2, CAST(N'2021-01-10T00:00:00.000' AS DateTime), NULL, N'Tháng-4000000.0')
SET IDENTITY_INSERT [dbo].[phieuThuePhong] OFF
GO
SET IDENTITY_INSERT [dbo].[Phong] ON 

INSERT [dbo].[Phong] ([idPhong], [idLoaiPhong], [tenPhong], [soKhachMax], [ngayDat], [trangThai]) VALUES (1, 1, N'Phòng 1', N'2', CAST(N'2020-12-12' AS Date), N'Bảo trì')
INSERT [dbo].[Phong] ([idPhong], [idLoaiPhong], [tenPhong], [soKhachMax], [ngayDat], [trangThai]) VALUES (2, 2, N'Phòng 2', N'5', CAST(N'2020-12-12' AS Date), N'Phòng trống')
INSERT [dbo].[Phong] ([idPhong], [idLoaiPhong], [tenPhong], [soKhachMax], [ngayDat], [trangThai]) VALUES (3, 5, N'Phòng 3', N'2', CAST(N'2020-12-12' AS Date), N'Đang sử dụng')
INSERT [dbo].[Phong] ([idPhong], [idLoaiPhong], [tenPhong], [soKhachMax], [ngayDat], [trangThai]) VALUES (5, 4, N'Phòng 4', N'1', CAST(N'2021-11-11' AS Date), N'Phòng trống')
SET IDENTITY_INSERT [dbo].[Phong] OFF
GO
ALTER TABLE [dbo].[ChiTietDichVu]  WITH CHECK ADD FOREIGN KEY([idDichVu])
REFERENCES [dbo].[DichVu] ([idDichVu])
GO
ALTER TABLE [dbo].[ChiTietDichVu]  WITH CHECK ADD FOREIGN KEY([idHoaDonDichVu])
REFERENCES [dbo].[HoaDonDichVu] ([idHoaDonDichVu])
GO
ALTER TABLE [dbo].[DichVu]  WITH CHECK ADD FOREIGN KEY([idDonVi])
REFERENCES [dbo].[donViTinh] ([idDonVi])
GO
ALTER TABLE [dbo].[HoaDonDichVu]  WITH CHECK ADD FOREIGN KEY([idPhong])
REFERENCES [dbo].[Phong] ([idPhong])
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD FOREIGN KEY([idChucVu])
REFERENCES [dbo].[ChucVu] ([idChucVu])
GO
ALTER TABLE [dbo].[phieuThuePhong]  WITH CHECK ADD  CONSTRAINT [FK__phieuThue__idNha__3C69FB99] FOREIGN KEY([idNhanVien])
REFERENCES [dbo].[NhanVien] ([idNhanVien])
GO
ALTER TABLE [dbo].[phieuThuePhong] CHECK CONSTRAINT [FK__phieuThue__idNha__3C69FB99]
GO
ALTER TABLE [dbo].[phieuThuePhong]  WITH CHECK ADD  CONSTRAINT [FK__phieuThue__idPho__3A81B327] FOREIGN KEY([idPhong])
REFERENCES [dbo].[Phong] ([idPhong])
GO
ALTER TABLE [dbo].[phieuThuePhong] CHECK CONSTRAINT [FK__phieuThue__idPho__3A81B327]
GO
ALTER TABLE [dbo].[phieuThuePhong]  WITH CHECK ADD  CONSTRAINT [FK__phieuThue__soCMN__3B75D760] FOREIGN KEY([soCMND])
REFERENCES [dbo].[KhachHang] ([soCMND])
GO
ALTER TABLE [dbo].[phieuThuePhong] CHECK CONSTRAINT [FK__phieuThue__soCMN__3B75D760]
GO
ALTER TABLE [dbo].[Phong]  WITH CHECK ADD FOREIGN KEY([idLoaiPhong])
REFERENCES [dbo].[LoaiPhong] ([idLoaiPhong])
GO
USE [master]
GO
ALTER DATABASE [Java] SET  READ_WRITE 
GO
