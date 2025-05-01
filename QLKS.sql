drop database QuanLyKhachSan

create database QuanLyKhachSan
go

use QuanLyKhachSan
go

create table NHANVIEN
(
	maNV varchar(20) primary key,
	tenNV nvarchar(50),
	gioiTinh nvarchar(5),
	soNgayPhep smallint,
	chucVu nvarchar(20),
	ngaySinh datetime,
	ngayVaoLam datetime,
	email varchar(100),
	luong1Ngay int,
	xuLy int
)

create table PHONG
(
	maP varchar(20) primary key,
	tenP nvarchar(20),
	loaiP nvarchar(20),
	giaP int,
	chiTietLoaiP nvarchar(20),
	tinhTrang int,
	hienTrang int,
	xuLy int
)

create table TIENICH
(
	maTI varchar(20) primary key,
	tenTI nvarchar(30),
	soLuong smallint,
	xuLy int
)

create table CHITIETTIENICH
(
	maP varchar(20) foreign key references PHONG(maP),
	maTI varchar(20) foreign key references TIENICH(maTI),
	soLuong int,
	constraint PK_CHITIETTIENICH primary key (maP,maTI)
)

create table KHACHHANG
(
	maKH varchar(20) primary key,
	tenKH nvarchar(50),
	CMND varchar(20),
	gioiTinh nvarchar(5),
	sDT varchar(20),
	queQuan nvarchar(100),
	quocTich nvarchar(100),
	ngaySinh datetime,
	xuLy int,
)

create table DICHVU
(
	maDV varchar(20) primary key,
	tenDV nvarchar(100),
	loaiDV nvarchar(100),
	soLuong int,
	giaDV int,
	hinhAnh nvarchar(500),
	xuLy int
)

create table CHITIETTHUE
(
	maCTT varchar(20) primary key,
	maKH varchar(20) foreign key references KHACHHANG(maKH),
	maNV varchar(20) foreign key references NHANVIEN(maNV),
	ngayLapPhieu datetime,
	tienDatCoc int,
	tinhTrangXuLy int,
	xuLy int
)

create table CHITIETTHUEPHONG
(
	maCTT varchar(20) foreign key references CHITIETTHUE(maCTT),
	maP varchar(20) foreign key references PHONG(maP),
	ngayThue datetime,
	ngayTra datetime,
	ngayCheckOut datetime,
	loaiHinhThue int,
	giaThue int,
	tinhTrang int,
	constraint PK_CHITIETTHUEPHONG primary key (maCTT, maP, ngayThue),
)

create table CHITIETTHUEDICHVU
(
	maCTT varchar(20) foreign key references CHITIETTHUE(maCTT),
	maDV varchar(20) foreign key references DICHVU(maDV),
	ngaySuDung datetime,
	SoLuong int,
	giaDV int,
	constraint PK_CHITIETHUEDICHVU primary key (maCTT, maDV, ngaySuDung)
)

create table HOADON 
(
	maHD varchar(20) primary key,
	maCTT varchar(20) foreign key references CHITIETTHUE(maCTT),
	tienP int,
	tienDV int,
	giamGia int,
	phuThu int,
	tongTien int,
	ngayThanhToan datetime,
	phuongThucThanhToan nvarchar(100),
	xuLy int,
)

create table TAIKHOAN
(
	taiKhoan varchar(20) primary key,
	maNV varchar(20) foreign key references NHANVIEN(maNV),
	matKhau varbinary(512),
	tinhTrang int,
	vaiTro nvarchar(20),
)

create table PHIEUNHAP
(
	maPN varchar(20) primary key,
	maNV varchar(20) foreign key references NHANVIEN(maNV),
	ngayLap datetime,
	tinhTrangXuLy int,
	xuLy int
)

create table CHITIETNHAP
(
	maPN varchar(20) foreign key references PHIEUNHAP,
	maDV varchar(20) foreign key references DICHVU,
	giaDVNhap int ,
	soLuong int,
	constraint PK_CHITIETNHAP primary key (maPN,maDV)
)
---them nhan vien mac dinh
insert into NHANVIEN values ('NV01111230001',N'Trần Văn Bánh',N'Nam',4,N'Quản lý','2005-11-11','2023-11-11','banhbanh@gamil.com',500000,0)
---tai khoan admin, mat khau admin
insert into TAIKHOAN values ('admin',null,0xC7AD44CBAD762A5DA0A452F9E854FDC1E0E7A52A38015F23F3EAB1D80B931DD472634DFAC71CD34EBC35D16AB7FB8A90C81F975113D6C7538DC69DD8DE9077EC,0,'Admin')
---tai khoan quan ly BanhBanh, mat khau 11112005
insert into TAIKHOAN values ('BanhBanh','NV01111230001',0x6EC17753E5FFBE46EDC9F2BF8F836844B8902EA8FA6E88D3AC6A31D9968F0FD13D654819D89314E86EC441BF3C331DA646E4EE12399FA1DDF84C5F5F30DE4203,0,'Manager')



-- CREATE TABLE NHANVIEN (
--     maNV VARCHAR(20) PRIMARY KEY,
--     tenNV VARCHAR(50),
--     gioiTinh VARCHAR(5),
--     soNgayPhep SMALLINT,
--     chucVu VARCHAR(20),
--     ngaySinh DATETIME,
--     ngayVaoLam DATETIME,
--     email VARCHAR(100),
--     luong1Ngay INT,
--     xuLy INT
-- );

-- CREATE TABLE PHONG (
--     maP VARCHAR(20) PRIMARY KEY,
--     tenP VARCHAR(20),
--     loaiP VARCHAR(20),
--     giaP INT,
--     chiTietLoaiP VARCHAR(20),
--     tinhTrang INT,
--     hienTrang INT,
--     xuLy INT
-- );

-- CREATE TABLE TIENICH (
--     maTI VARCHAR(20) PRIMARY KEY,
--     tenTI VARCHAR(30),
--     soLuong SMALLINT,
--     xuLy INT
-- );

-- CREATE TABLE CHITIETTIENICH (
--     maP VARCHAR(20),
--     maTI VARCHAR(20),
--     soLuong INT,
--     PRIMARY KEY (maP, maTI),
--     FOREIGN KEY (maP) REFERENCES PHONG(maP),
--     FOREIGN KEY (maTI) REFERENCES TIENICH(maTI)
-- );

-- CREATE TABLE KHACHHANG (
--     maKH VARCHAR(20) PRIMARY KEY,
--     tenKH VARCHAR(50),
--     CMND VARCHAR(20),
--     gioiTinh VARCHAR(5),
--     sDT VARCHAR(20),
--     queQuan VARCHAR(100),
--     quocTich VARCHAR(100),
--     ngaySinh DATETIME,
--     xuLy INT
-- );

-- CREATE TABLE DICHVU (
--     maDV VARCHAR(20) PRIMARY KEY,
--     tenDV VARCHAR(100),
--     loaiDV VARCHAR(100),
--     soLuong INT,
--     giaDV INT,
--     hinhAnh VARCHAR(500),
--     xuLy INT
-- );

-- CREATE TABLE CHITIETTHUE (
--     maCTT VARCHAR(20) PRIMARY KEY,
--     maKH VARCHAR(20),
--     maNV VARCHAR(20),
--     ngayLapPhieu DATETIME,
--     tienDatCoc INT,
--     tinhTrangXuLy INT,
--     xuLy INT,
--     FOREIGN KEY (maKH) REFERENCES KHACHHANG(maKH),
--     FOREIGN KEY (maNV) REFERENCES NHANVIEN(maNV)
-- );

-- CREATE TABLE CHITIETTHUEPHONG (
--     maCTT VARCHAR(20),
--     maP VARCHAR(20),
--     ngayThue DATETIME,
--     ngayTra DATETIME,
--     ngayCheckOut DATETIME,
--     loaiHinhThue INT,
--     giaThue INT,
--     tinhTrang INT,
--     PRIMARY KEY (maCTT, maP, ngayThue),
--     FOREIGN KEY (maCTT) REFERENCES CHITIETTHUE(maCTT),
--     FOREIGN KEY (maP) REFERENCES PHONG(maP)
-- );

-- CREATE TABLE CHITIETTHUEDICHVU (
--     maCTT VARCHAR(20),
--     maDV VARCHAR(20),
--     ngaySuDung DATETIME,
--     SoLuong INT,
--     giaDV INT,
--     PRIMARY KEY (maCTT, maDV, ngaySuDung),
--     FOREIGN KEY (maCTT) REFERENCES CHITIETTHUE(maCTT),
--     FOREIGN KEY (maDV) REFERENCES DICHVU(maDV)
-- );

-- CREATE TABLE HOADON (
--     maHD VARCHAR(20) PRIMARY KEY,
--     maCTT VARCHAR(20),
--     tienP INT,
--     tienDV INT,
--     giamGia INT,
--     phuThu INT,
--     tongTien INT,
--     ngayThanhToan DATETIME,
--     phuongThucThanhToan VARCHAR(100),
--     xuLy INT,
--     FOREIGN KEY (maCTT) REFERENCES CHITIETTHUE(maCTT)
-- );

-- CREATE TABLE TAIKHOAN (
--     taiKhoan VARCHAR(20) PRIMARY KEY,
--     maNV VARCHAR(20),
--     matKhau VARBINARY(512),
--     tinhTrang INT,
--     vaiTro VARCHAR(20),
--     FOREIGN KEY (maNV) REFERENCES NHANVIEN(maNV)
-- );

-- CREATE TABLE PHIEUNHAP (
--     maPN VARCHAR(20) PRIMARY KEY,
--     maNV VARCHAR(20),
--     ngayLap DATETIME,
--     tinhTrangXuLy INT,
--     xuLy INT,
--     FOREIGN KEY (maNV) REFERENCES NHANVIEN(maNV)
-- );

-- CREATE TABLE CHITIETNHAP (
--     maPN VARCHAR(20),
--     maDV VARCHAR(20),
--     giaDVNhap INT,
--     soLuong INT,
--     PRIMARY KEY (maPN, maDV),
--     FOREIGN KEY (maPN) REFERENCES PHIEUNHAP(maPN),
--     FOREIGN KEY (maDV) REFERENCES DICHVU(maDV)
-- );
