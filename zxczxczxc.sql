create database Java

use Java
go

create table LoaiPhong (
	idLoaiPhong int identity primary key,
	tenLoaiPhong nvarchar(20) not null,
	giaPhong float not null
)


create table Phong (
	idPhong int identity primary key,
	idLoaiPhong int not null foreign key references LoaiPhong,
	tenPhong nvarchar(10) not null,
	soKhachMax varchar(2) not null,
	ngayDat date not null,
	trangThai nvarchar(20) not null
)

create table HoaDonDichVu (
	idHoaDonDichVu int identity primary key,
	idPhong int not null foreign key references Phong,
	tongTien float not null,
	ngayTao date not null,
	moTa nvarchar(200)
)

create table DichVu (
	idDichVu int identity primary key,
	tenDichVu nvarchar(100) not null,
	gia float not null
)
alter table DichVu 
add idDonVi int foreign key references donViTinh

create table ChiTietDichVu (
	idHoaDonDichVu int not null foreign key references HoaDonDichVu,
	idDichVu int not null foreign key references DichVu,
	soLanSuDung varchar(3) not null,
	ngaySuDung date not null,
	thanhTien float not null
)

insert into ChiTietDichVu values (1,1,2,'12-12-2020',10000)
insert into chiTietDichVu values (1,6,5,getDate(),(select gia from DichVu where idDichVu=6)*5)

create table Account (
	idAcc int identity primary key,
	ten nvarchar(50) not null,
	email varchar(50) not null,
	pass varchar(50) not null
)

create table ChucVu (
	idChucVu int identity primary key,
	tenChucVu nvarchar(100) not null
)

create table NhanVien (
	idNhanVien int identity not null primary key,
	ten nvarchar(50) not null,
	email varchar(100) not null,
	sdt varchar(10) not null,
	sex nvarchar(5) not null,
	luong float not null,
	idChucVu int not null foreign key references ChucVu,
	diaChi nvarchar(100) not null,
	ngaySinh date not null,
	ngayVaoLam date not null,
	trangThai varchar(50) not null
)




create table KhachHang(
	soCMND varchar(12) not null primary key,
	tenKhach nvarchar(50) not null,
	diaChi nvarchar(150) null,
	hoChieu varchar(15) null,
	soDT char(10) not null,
)


create table phieuThuePhong(
	idPhieuThue int identity primary key,
	idPhong	int not null foreign key references phong,
	soCMND varchar(12) not null foreign key references KhachHang,
	idNhanVien int not null foreign key references NhanVien,
	soNguoi int not null,
	ngayDat datetime not null,
	ngayDi datetime
)

create table donViTinh (
	idDonVi int identity primary key,
	tenDonVi nvarchar(50) not null
)

insert into donViTinh values (N'lần')
insert into donViTinh values (N'xuất')
insert into donViTinh values (N'ly')
insert into donViTinh values (N'lon')
insert into donViTinh values (N'hộp')
insert into donViTinh values (N'gói')
insert into donViTinh values (N'chai')

insert into KhachHang values ('987654321',N'Nhung',N'BMT',null,'0941790556')
insert into KhachHang values ('012345678',N'Nam',N'BMT',null,'0941790506')

insert into phieuThuePhong values (3,'987654321',1,3,'2020-12-12',null)
insert into phieuThuePhong values (3,'012345678',2,5,'2020-12-12',null)


insert into LoaiPhong values (N'Phòng Đơn',1000)
insert into LoaiPhong values (N'Phòng Đôi',3000)
insert into LoaiPhong values (N'Phòng Chung',4000)
insert into LoaiPhong values (N'Phòng VIP',5000)

insert into Phong values (1,N'Phòng 1',2,'12-12-2020',N'Đang sử dụng')
insert into Phong values (1,N'Phòng 2',5,'12-12-2020',N'Đang sử dụng')
insert into Phong values (1,N'Phòng 3',2,'12-12-2020',N'Đang sử dụng')

insert into HoaDonDichVu values (1,'10000','08-08-2021',null)
insert into HoaDonDichVu values (2,'15000','08-08-2021',null)
insert into HoaDonDichVu values (3,'5000','08-08-2021',null)

insert into DichVu values (N'Giặt ủi',5000,7)
insert into DichVu values (N'Dọn phòng',2000,7)
insert into DichVu values (N'Buổi sáng',1000,7)
insert into DichVu values (N'Giặt trưa',1000,7)
insert into DichVu values (N'Giặt tối',2000,7)

insert into ChiTietDichVu values (1,1,2,N'lần','12-12-2020',10000)

insert into Account values (N'Anh','a@gmail.com','123')
insert into Account values (N'Huye','admin','123')

insert into ChucVu values (N'Admin')
insert into ChucVu values (N'Quản lý')
insert into ChucVu values (N'Lễ tân')
insert into ChucVu values (N'Kế toán')

insert into NhanVien values (N'Anh','anh@gmail.com','0941790508',N'Nam',100000,1,N'VN','08-08-1997','12-12-2020','ON')
insert into NhanVien values (N'Kien','kien@gmail.com','0941790508',N'Nam',100000,1,N'VN','08-08-1997','12-12-2020','ON')


select idNhanVien,ten,email,sdt,sex,CAST(Luong as decimal(15,0)) as Luong,b.tenChucVu,diaChi,CONVERT(nvarchar,NgaySinh,105) as ngaySinh,
CONVERT(nvarchar,NgayVaoLam,105)as ngayVaoLam,trangThai from NhanVien a join ChucVu b on a.idChucVu = b.idChucVu

select a.idPhong,b.tenLoaiPhong,a.tenPhong,a.soKhachMax,a.ngayDat,a.trangThai from Phong a join LoaiPhong b on a.idLoaiPhong = b.idLoaiPhong

select * from Phong

select a.tenDichVu,d.tenPhong,a.gia,b.ngaySuDung from DichVu a join ChiTietDichVu b on a.idDichVu = b.idDichVu 
join HoaDonDichVu c on b.idHoaDonDichVu = c.idHoaDonDichVu join Phong d on d.idPhong = c.idPhong


select idPhieuThue,ngayDat,ngayDi,ptp.soCMND,kh.diaChi,hoChieu,soDT,tenKhach,ten tenNv,soNguoi from phieuThuePhong ptp join KhachHang kh on kh.soCMND=ptp.soCMND join NhanVien nv on nv.idNhanVien=ptp.idNhanVien where idPhong=1

select idDichVu,tenDichVu,tenDonVi,gia from DichVu a join donViTinh b on a.idDonVi = b.idDonVi

select * from ChiTietDichVu


insert into HoaDonDichVu values (3,0,getDate(),'khong')

select idHoaDonDichVu from hoaDonDichVu where idPhong =3 and trangthai=1

select idDichVu,tenDichVu,tenDonVi,gia from DichVu a join DanhMuc b on a.idDanhMuc = b.idDanhMuc join donViTinh c on c.idDonVi = a.idDonVi
select idDichVu,tenDichVu,tenDonVi,gia from DichVu a join DanhMuc b on a.idDanhMuc = b.idDanhMuc join donViTinh c on c.idDonVi = a.idDonVi where b.idDanhMuc =2
select idDichVu,tenDichVu,tenDonVi,gia from DichVu a join DanhMuc b on a.idDanhMuc = b.idDanhMuc join donViTinh c on c.idDonVi = a.idDonVi where tenDichVu like N'%D%'
