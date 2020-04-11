USE [master]
GO
CREATE DATABASE [dbMobileStore]
GO
use [dbMobileStore]
go
CREATE TABLE [dbo].[tbAdmin](
	[id] [int] identity(1,1) NOT NULL primary key,
	[username] [nvarchar](255) NULL,
	[pwd] [nvarchar](255) NULL,
	[email] [nvarchar](255) NULL,
	[address] [nvarchar](255) NULL,
	[phone] [nvarchar](255) NULL,
	[level] [int] NULL,
	[urlImage] [nvarchar](255) NULL,
	[fullname] [nvarchar](255) NULL,
)
GO
CREATE TABLE [dbo].[tbUser](
	[id] [int] identity(1,1) NOT NULL primary key,
	[username] [nvarchar](255) NULL,
	[fullname] [nvarchar](255) NULL,
	[pwd] [nvarchar](255) NULL,
	[email] [nvarchar](255) NULL,
	[address] [nvarchar](255) NULL,
	[phone] [nvarchar](255) NULL,
	[urlImage] [nvarchar](255) NULL,
	[activated] [int] NULL,
	[total_money] [nvarchar](255) NULL,
	[lastOrderMoney] [nvarchar](255) NULL
)
GO
CREATE TABLE [dbo].[tbProduct](
	[id] [int] identity(1,1) NOT NULL primary key,
	[sku] [nvarchar](255) NULL,
	[name] [nvarchar](255) NULL,
	[price] [nvarchar](255) NULL,
	[Ghz] [nvarchar](255) NULL,
	[color] [nvarchar](255) NULL,
	[sensor] [nvarchar](255) NULL,
	[cpu] [nvarchar](255) NULL,
	[ram] [nvarchar](255) NULL,
	[storage] [nvarchar](255) NULL,
	[camera_front] [nvarchar](255) NULL,
	[camera_rear] [nvarchar](255) NULL,
	[battery] [nvarchar](255) NULL,
	[display] [nvarchar](255) NULL,
	[sim] [nvarchar](255) NULL,
	[status] [nvarchar](255) NULL,
	[activate] [int] NULL,
	[product_cate_id] [int] NULL,
	[discount_id] [int] NULL,
	[urlImage] [nvarchar](255) NULL,
	[follow] [int] NULL,
)
GO
CREATE TABLE [dbo].[tbCategory](
	[id] [int] identity(1,1) NOT NULL primary key,
	[name] [nvarchar](255) NULL,
	[description] [nvarchar](255) NULL,
)
GO
CREATE TABLE [dbo].[tbDiscount](
	[id] [int] identity(1,1) NOT NULL primary key,
	[value] [nvarchar](255) NULL,
	[name] [nvarchar](255) NULL,
)
GO
CREATE TABLE [dbo].[tbPost](
	[id] [int] identity(1,1) NOT NULL primary key,
	[product_id] [int] NULL references [tbProduct](id),
	[name] [nvarchar](255) NULL,
	[descripton] [nvarchar](2000) NULL,
)
GO
CREATE TABLE [dbo].[tbImage](
	[id] [int] identity(1,1) NOT NULL primary key,
	[url] [nvarchar](255) NULL,
	[product_id] [int] NULL references [tbProduct](id),
)
GO
CREATE TABLE [dbo].[tbToken](
	[id] [int] identity(1,1) NOT NULL primary key,
	[value] [nvarchar](255) NULL,
	[admin_id] [int] NULL references [tbAdmin](id),
)

GO
CREATE TABLE [dbo].[tbOrder](
	[id] [int] identity(1,1) NOT NULL primary key,
	[user_id] [int] NOT NULL references [tbUser](id),
	[product_id] [int] NOT NULL references [tbProduct](id),
	[quantity] [nvarchar](255) NULL,
	[money] [nvarchar](255) NULL,
	[method] [nvarchar](255) NULL,
	[status] [int] NULL,
	[date_create] [datetime] NULL DEFAULT (getdate()),
)
GO
CREATE TABLE [dbo].[tbComment](
	[id] [int] identity(1,1) NOT NULL primary key,
	[product_id] [int] NULL references [tbProduct](id),
	[user_id] [int] NULL references [tbUser](id),
	[content] [nvarchar](2000) NULL,
)
GO
CREATE TABLE [dbo].[tbReview](
	[id] [int] identity(1,1) NOT NULL primary key,
	[product_id] [int] NULL references [tbProduct](id),
	[user_id] [int] NULL references [tbUser](id),
	[content] [nvarchar](2000) NULL,
)
GO
CREATE TABLE [dbo].[tbUserToken](
	[id] [int] identity(1,1) NOT NULL primary key,
	[value] [nvarchar](255) NULL,
	[user_id] [int] NULL references [tbUser](id)
)
GO

set IDENTITY_INSERT [tbAdmin] on
go
INSERT [dbo].[tbAdmin] ([id], [username], [pwd], [email], [address], [phone], [level], [urlImage], [fullname]) VALUES (1, N'FallenMax', N'15f8182445bac21b05802649a8a698e7', N'fallen.9x@gmail.com', N'Bắc Giang ', N'0386147455', 1, N'/Upload/Admin/avt.jpg', N'Vũ Việt Anh Tuấn ')
INSERT [dbo].[tbAdmin] ([id], [username], [pwd], [email], [address], [phone], [level], [urlImage], [fullname]) VALUES (2, N'FallenMax', N'15f8182445bac21b05802649a8a698e7', N'fallen.9x@gmail.com', N'Bac Giang ', N'0386147455', 1, N'/Upload/Admin/avt.jpg', N'Vũ Việt Anh Tuấn ')
INSERT [dbo].[tbAdmin] ([id], [username], [pwd], [email], [address], [phone], [level], [urlImage], [fullname]) VALUES (3, N'root', N'21232f297a57a5a743894a0e4a801fc3', N'admin@admin.com', N'Hà nội, Việt Nam', N'034 4444 444', 1, N'/Upload/Admin/8db211334a98d285_7acfaf01b411f3cc_23826815225395418143215.jpg', N'Khải Quang Vũ')
go
set IDENTITY_INSERT [tbAdmin] off
go

set IDENTITY_INSERT [tbUser] on
go
INSERT [dbo].[tbUser] ([id], [username], [fullname], [pwd], [email], [address], [phone], [urlImage], [activated], [total_money], [lastOrderMoney]) VALUES (1, N'Cún con', N'Cún Con', N'15f8182445bac21b05802649a8a698e7', N'fallen.9x@gmail.com', N'Bac Giang ', N'0386147455', N'/Upload/Users/06dcebd9f90705c52ddeffd39dd035df.jpg', 1, NULL, NULL)
INSERT [dbo].[tbUser] ([id], [username], [fullname], [pwd], [email], [address], [phone], [urlImage], [activated], [total_money], [lastOrderMoney]) VALUES (2, N'AnhTuan', N'Vũ Việt Anh Tuấn ', N'15f8182445bac21b05802649a8a698e7', N'fallen.9x@gmail.com', N'Bắc Giang ', N'0386147455', N'/Upload/Users/3c2d870755289c9d7565801ee055e558.jpg', 1, NULL, NULL)
INSERT [dbo].[tbUser] ([id], [username], [fullname], [pwd], [email], [address], [phone], [urlImage], [activated], [total_money], [lastOrderMoney]) VALUES (3, N'admin', N'Khánh Ly', N'21232f297a57a5a743894a0e4a801fc3', N'nguoidung1@email.com', N'Hà nội, Việt Nam', N'033 3333 333', N'/Upload/Users/05ddcc8d1620f4b5ef7127c3847985c4.jpg', 1, NULL, NULL)
INSERT [dbo].[tbUser] ([id], [username], [fullname], [pwd], [email], [address], [phone], [urlImage], [activated], [total_money], [lastOrderMoney]) VALUES (4, N'FallenMax', N'Vũ Việt Anh Tuấn ', N'15f8182445bac21b05802649a8a698e7', N'fallen.9x@gmail.com', N'Bắc Giang ', N'0386147455', N'/Upload/Users/1b360dc6d1e366c0d79c8f6525ec0317.png', 1, NULL, NULL)
INSERT [dbo].[tbUser] ([id], [username], [fullname], [pwd], [email], [address], [phone], [urlImage], [activated], [total_money], [lastOrderMoney]) VALUES (5, N'admin2', N'Hunt', N'21232f297a57a5a743894a0e4a801fc3', N'nguoidung2@gmail.com', N'Hà nội, Việt Nam', N'024 2335 444', N'/Upload/Users/e55a8b051f514c4de5f3c27768aadec7.jpg', 1, NULL, NULL)
go
set IDENTITY_INSERT [tbUser] off
go

set IDENTITY_INSERT [tbProduct] on
go
INSERT [dbo].[tbProduct] ([id], [sku], [name], [price], [Ghz], [color], [sensor], [cpu], [ram], [storage], [camera_front], [camera_rear], [battery], [display], [sim], [status], [activate], [product_cate_id], [discount_id], [urlImage], [follow]) VALUES (1, N'SP0001', N'IPHONEX', N'19.490.000', N'4G', N'Đỏ', N'NFC, OTG', N'Apple A12 Bionic 6 nhân', N'3 GB', N'64 GB', N'7 MP', N'12 MP', N'2942 mAh', N'828 x 1792 Pixels', N'nanoSim', N'Còn Hàng', 1, 8, NULL, N'/Upload/SingleProduct/4ec3fc04c73b84b61ab9e4341a364975.jpg', 54)
INSERT [dbo].[tbProduct] ([id], [sku], [name], [price], [Ghz], [color], [sensor], [cpu], [ram], [storage], [camera_front], [camera_rear], [battery], [display], [sim], [status], [activate], [product_cate_id], [discount_id], [urlImage], [follow]) VALUES (2, N'SP0001', N'IPHONEX', N'19.490.000', N'4G', N'Đỏ', N'NFC, OTG', N'Apple A12 Bionic 6 nhân', N'3 GB', N'64 GB', N'7 MP', N'12 MP', N'2942 mAh', N'828 x 1792 Pixels', N'nanoSim', N'Còn Hàng', 1, 8, NULL, N'/Upload/SingleProduct/4ec3fc04c73b84b61ab9e4341a364975.jpg', 54)
INSERT [dbo].[tbProduct] ([id], [sku], [name], [price], [Ghz], [color], [sensor], [cpu], [ram], [storage], [camera_front], [camera_rear], [battery], [display], [sim], [status], [activate], [product_cate_id], [discount_id], [urlImage], [follow]) VALUES (3, N'SP0002', N'IPHONEXS Max', N'20.000.000', N'Hỗ trợ 4G', N'Đỏ', N'NFC, OTG', N'Apple A12 Bionic 6 nhân', N'3 GB', N'64 GB', N'7 MP', N'12 MP', N'2942 mAh', N'828 x 1792 Pixels', N'nanoSim', N'Còn Hàng', 0, 8, NULL, N'/Upload/SingleProduct/8bdd29b6ef9cfe5d4639c09717d2cc5d.jpg', 34)
INSERT [dbo].[tbProduct] ([id], [sku], [name], [price], [Ghz], [color], [sensor], [cpu], [ram], [storage], [camera_front], [camera_rear], [battery], [display], [sim], [status], [activate], [product_cate_id], [discount_id], [urlImage], [follow]) VALUES (4, N'SP0003', N'Sam Sung A6', N'4.190.000', N'Hỗ trợ 4G', N'Đỏ', N'NFC, OTG', N'Exynos 7870 8 nhân 64-bit', N'3 GB', N'64 GB', N'16 MP', N'16 MP', N'3000 mAh', N'uper AMOLED, 5.6", HD+', N'2 Nano SIM', N'Còn Hàng', 0, 1, NULL, N'/Upload/SingleProduct/59e8961cc938cd509893316f4a7d8b19.jpg', 35)
INSERT [dbo].[tbProduct] ([id], [sku], [name], [price], [Ghz], [color], [sensor], [cpu], [ram], [storage], [camera_front], [camera_rear], [battery], [display], [sim], [status], [activate], [product_cate_id], [discount_id], [urlImage], [follow]) VALUES (5, N'SP0004', N'Sam Sung A6+', N'5.490.000', N'Hỗ trợ 4G', N'Đỏ', N'NFC, OTG', N'Qualcomm Snapdragon 450 8 nhân 64-bit', N'4 GB', N'32 GB', N'24 MP', N'16 MP và 5 MP (2 camera)', N'3500 mAh', N'Super AMOLED, 6", Full HD+', N'2 Nano SIM', N'Còn Hàng', 1, 1, NULL, N'/Upload/SingleProduct/8377b01c0586cce7d1e6218eb3548869.png', 26)
INSERT [dbo].[tbProduct] ([id], [sku], [name], [price], [Ghz], [color], [sensor], [cpu], [ram], [storage], [camera_front], [camera_rear], [battery], [display], [sim], [status], [activate], [product_cate_id], [discount_id], [urlImage], [follow]) VALUES (6, N'SP0005', N'Sam Sung A7', N'6.190.000', N'Hỗ trợ 4G', N'Đỏ', N'NFC, OTG', N'Exynos 7885 8 nhân 64-bit', N'4 GB', N'64 GB', N'24 MP', N'24 MP, 8 MP và 5 MP (3 camera)', N'3300', N'Super AMOLED, 6.0", Full HD+', N'2 Nano SIM', N'Còn Hàng', 1, 1, NULL, N'/Upload/SingleProduct/8acc50c69c41fd6553b7149d524c8a14.png', 51)
INSERT [dbo].[tbProduct] ([id], [sku], [name], [price], [Ghz], [color], [sensor], [cpu], [ram], [storage], [camera_front], [camera_rear], [battery], [display], [sim], [status], [activate], [product_cate_id], [discount_id], [urlImage], [follow]) VALUES (7, N'SP0006', N'Sam Sung A8 Star', N'8.290.000', N'Hỗ trợ 4G', N'Vàng', N'NFC, OTG', N'Qualcomm Snapdragon 660 8 nhân', N'4 GB', N'64 GB', N'24 MP', N'24 MP và 16 MP (2 camera)', N'3700 mAh, có sạc nhanh', N'Super AMOLED, 6.3", Full HD+', N'2 Nano SIM,', N'Còn Hàng', 1, 1, NULL, N'/Upload/SingleProduct/2c4a291407e3a127b3990bfee3a75a59.png', 11)
INSERT [dbo].[tbProduct] ([id], [sku], [name], [price], [Ghz], [color], [sensor], [cpu], [ram], [storage], [camera_front], [camera_rear], [battery], [display], [sim], [status], [activate], [product_cate_id], [discount_id], [urlImage], [follow]) VALUES (8, N'SP0007', N'XIAOMI Mi8', N'12.990.000', N'Hỗ trợ 4G', N'Đen, Trắng, Vàng, Xanh', N'NFC, OTG', N'Snapdragon 845 8 nhân', N'6 GB', N'64 GB', N'20 MP', N'2 camera 12 MP', N'3400 mAh', N'Full HD+ (1080 x 2248 Pixels)', N'2 Nano SIM', N'Còn Hàng', 1, 11, NULL, N'/Upload/SingleProduct/43fc803f0120f214a684e995752a852c.jpg', 7)
INSERT [dbo].[tbProduct] ([id], [sku], [name], [price], [Ghz], [color], [sensor], [cpu], [ram], [storage], [camera_front], [camera_rear], [battery], [display], [sim], [status], [activate], [product_cate_id], [discount_id], [urlImage], [follow]) VALUES (9, N'SP0008', N'OPPO R17 Pro', N'15.990.000', N'Hỗ trợ 4G', N'Đen, Trắng, Vàng, Xanh', N'NFC, OTG', N'Snapdragon 710 8 nhân 64-bit', N'8 GB', N'128 GB', N'25 MP', N'20 MP, 12 MP và TOF 3D (3 camera)', N'3700 mAh, có sạc nhanh', N'AMOLED, 6.4", Full HD+', N'2 Nano SIM', N'Còn Hàng', 1, 2, NULL, N'/Upload/SingleProduct/c93aa8b12375abdd6cee8f77264892a6.png', 14)
INSERT [dbo].[tbProduct] ([id], [sku], [name], [price], [Ghz], [color], [sensor], [cpu], [ram], [storage], [camera_front], [camera_rear], [battery], [display], [sim], [status], [activate], [product_cate_id], [discount_id], [urlImage], [follow]) VALUES (10, N'SP0009', N'OPPO Find X', N'19.990.000', N'Hỗ trợ 4G', N'Đen, Trắng, Vàng, Xanh', N'NFC, OTG', N'Snapdragon 845 8 nhân', N'8 GB', N'256 GB', N'25 MP', N'20 MP và 16 MP (2 camera)', N'3730 mAh', N'AMOLED, 6.42", Full HD+', N'2 Nano SIM', N'Còn Hàng', 1, 2, NULL, N'/Upload/SingleProduct/13687cbc2ce9c92316fbc4d2aee5b1ce.jpg', 31)
INSERT [dbo].[tbProduct] ([id], [sku], [name], [price], [Ghz], [color], [sensor], [cpu], [ram], [storage], [camera_front], [camera_rear], [battery], [display], [sim], [status], [activate], [product_cate_id], [discount_id], [urlImage], [follow]) VALUES (11, N'SP0010', N'HUAWAI Y9', N'4.990.000', N'Hỗ trợ 4G', N'Đen, Trắng, Vàng, Xanh', N'NFC, OTG', N'HiSilicon Kirin 710', N'4 GB', N'64 GB', N'16 MP và 2 MP (2 camera)', N'16 MP và 2 MP (2 camera)', N'2000 mAh', N'LTPS LCD, 6.5", Full HD+', N'2 Nano SIM', N'Còn Hàng', 1, 5, NULL, N'/Upload/SingleProduct/4c69b9347eb89cac2245e260bb9835e7.png', 32)
INSERT [dbo].[tbProduct] ([id], [sku], [name], [price], [Ghz], [color], [sensor], [cpu], [ram], [storage], [camera_front], [camera_rear], [battery], [display], [sim], [status], [activate], [product_cate_id], [discount_id], [urlImage], [follow]) VALUES (12, N'SP0011', N'HUAWAI Mate20 PRo', N'21.990.000', N'Hỗ trợ 4G', N'Đen, Trắng, Vàng, Xanh', N'NFC, OTG', N'Hisilicon Kirin 980 8 nhân 64-bit', N'6 GB', N'128 GB', N'24 MP', N'40 MP, 20 MP và 8 MP (3 camera)', N'4200 mAh', N'OLED, 6.39", Quad HD+ (2K+)', N'2 SIM Nano (SIM 2 chung khe thẻ nhớ)', N'Còn Hàng', 1, 5, NULL, N'/Upload/SingleProduct/f93d0c9440e9833342154b38683dc8f9.png', 6)
INSERT [dbo].[tbProduct] ([id], [sku], [name], [price], [Ghz], [color], [sensor], [cpu], [ram], [storage], [camera_front], [camera_rear], [battery], [display], [sim], [status], [activate], [product_cate_id], [discount_id], [urlImage], [follow]) VALUES (13, N'SP0012', N'HONOR 10', N'9.990.000', N'Hỗ trợ 4G', N'Đen, Trắng, Vàng, Xanh', N'NFC, OTG', N'Hisilicon Kirin 970 , 8 nhân, 4 nhân 2.4 GHz Cortex-A73 & 4 nhân 1.8 GHz ', N'4 GB', N'128 GB', N'24 MP', N'24 MP và 16 MP', N'3400 mAh', N'5.84", 1080 x 2280 pixels', N'Nano SIM, 2 Sim', N'Còn Hàng', 1, 6, NULL, N'/Upload/SingleProduct/027b6247f712eac84d9fc73d7fb85aec.jpg', 12)
INSERT [dbo].[tbProduct] ([id], [sku], [name], [price], [Ghz], [color], [sensor], [cpu], [ram], [storage], [camera_front], [camera_rear], [battery], [display], [sim], [status], [activate], [product_cate_id], [discount_id], [urlImage], [follow]) VALUES (14, N'SP0013', N'HONOR 10 Lite', N'5.290.000', N'Hỗ trợ 4G', N'Đen, Trắng, Vàng, Xanh', N'NFC, OTG', N'Hisilicon Kirin 710, 8, 4 x 2.2 GHz & 4 x 1.7 GHz', N'3 GB', N'64 GB', N'24.0 MP', N'13.0 MP + 2.0 MP', N'3400 mAh', N'6.21 inches, 1080 x 2340 Pixels', N'2 SIM Nano (SIM 2 chung khe thẻ nhớ)', N'Còn Hàng', 1, 6, NULL, N'/Upload/SingleProduct/d55a0a8e70387956ad1043f29c2a3624.jpg', 10)
INSERT [dbo].[tbProduct] ([id], [sku], [name], [price], [Ghz], [color], [sensor], [cpu], [ram], [storage], [camera_front], [camera_rear], [battery], [display], [sim], [status], [activate], [product_cate_id], [discount_id], [urlImage], [follow]) VALUES (15, N'SP0014', N'Wow Phone', N'7800000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 18, NULL, N'/Upload/SingleProduct/7efafda1445b6c109438cb7a511f8e08.jpg', 4)
go
set IDENTITY_INSERT [tbProduct] off
go

set IDENTITY_INSERT [tbCategory] on
go
INSERT [dbo].[tbCategory] ([id], [name], [description]) VALUES (1, N'SAM SUNG', NULL)
INSERT [dbo].[tbCategory] ([id], [name], [description]) VALUES (2, N'OPPO', NULL)
INSERT [dbo].[tbCategory] ([id], [name], [description]) VALUES (3, N'MOBIISTAR', NULL)
INSERT [dbo].[tbCategory] ([id], [name], [description]) VALUES (4, N'MOBELL', NULL)
INSERT [dbo].[tbCategory] ([id], [name], [description]) VALUES (5, N'HUAWAI', NULL)
INSERT [dbo].[tbCategory] ([id], [name], [description]) VALUES (6, N'HONOR', NULL)
INSERT [dbo].[tbCategory] ([id], [name], [description]) VALUES (7, N'BPHONE', NULL)
INSERT [dbo].[tbCategory] ([id], [name], [description]) VALUES (8, N'IPHONE', NULL)
INSERT [dbo].[tbCategory] ([id], [name], [description]) VALUES (9, N'NOKIA', NULL)
INSERT [dbo].[tbCategory] ([id], [name], [description]) VALUES (10, N'VSMART', NULL)
INSERT [dbo].[tbCategory] ([id], [name], [description]) VALUES (11, N'XIAOMI', NULL)
INSERT [dbo].[tbCategory] ([id], [name], [description]) VALUES (12, N'Siêu điện thoại', NULL)
INSERT [dbo].[tbCategory] ([id], [name], [description]) VALUES (13, N'Bét điện thoại', NULL)
INSERT [dbo].[tbCategory] ([id], [name], [description]) VALUES (14, N'Siêu ngầu điện thoại', NULL)
INSERT [dbo].[tbCategory] ([id], [name], [description]) VALUES (15, N'BIBI PHONE', N'Một sản phẩm đỉnh cao đến từ chúng tôi')
INSERT [dbo].[tbCategory] ([id], [name], [description]) VALUES (16, N'LALA PHONE', NULL)
INSERT [dbo].[tbCategory] ([id], [name], [description]) VALUES (17, N'Éc Éc Iphone', N'Đây là một sản phẩm đến từ nhà cung cấp hàng đầu Cổ Nhuế')
INSERT [dbo].[tbCategory] ([id], [name], [description]) VALUES (18, N'Đâu phải điện thoại đâu', N'Một sản phẩm sáng tạo từ sự ngẫu hứng')
go
set IDENTITY_INSERT [tbCategory] off
go

set IDENTITY_INSERT [tbDiscount] on
go
INSERT [dbo].[tbDiscount] ([id], [value], [name]) VALUES (1, N'18', N'IPHONEX')
INSERT [dbo].[tbDiscount] ([id], [value], [name]) VALUES (2, N'3', N'Éc Éc Iphone')
go
set IDENTITY_INSERT [tbDiscount] off
go

set IDENTITY_INSERT [tbOrder] on
go
INSERT [dbo].[tbOrder] ([id], [user_id], [product_id], [quantity], [money], [method], [status], [date_create]) VALUES (1, 5, 1, N'2', N'19490000', N'COD', 1, CAST(N'2019-01-02 00:00:00.000' AS DateTime))
INSERT [dbo].[tbOrder] ([id], [user_id], [product_id], [quantity], [money], [method], [status], [date_create]) VALUES (2, 5, 7, N'1', N'8290000', N'COD', 0, CAST(N'2019-10-22 19:56:36.000' AS DateTime))
INSERT [dbo].[tbOrder] ([id], [user_id], [product_id], [quantity], [money], [method], [status], [date_create]) VALUES (3, 5, 15, N'2', N'7800000', N'COD', 0, CAST(N'2019-10-23 00:00:45.000' AS DateTime))
INSERT [dbo].[tbOrder] ([id], [user_id], [product_id], [quantity], [money], [method], [status], [date_create]) VALUES (4, 1, 5, N'1', N'5490000', N'COD', 1, CAST(N'2019-11-15 09:30:53.000' AS DateTime))
INSERT [dbo].[tbOrder] ([id], [user_id], [product_id], [quantity], [money], [method], [status], [date_create]) VALUES (5, 2, 7, N'1', N'8290000', N'COD', 0, CAST(N'2019-11-15 09:45:55.000' AS DateTime))
INSERT [dbo].[tbOrder] ([id], [user_id], [product_id], [quantity], [money], [method], [status], [date_create]) VALUES (6, 3, 15, N'3', N'7800000', N'COD', 1, CAST(N'2019-11-20 16:25:42.000' AS DateTime))
INSERT [dbo].[tbOrder] ([id], [user_id], [product_id], [quantity], [money], [method], [status], [date_create]) VALUES (7, 2, 6, N'3', N'6190000', N'COD', 1, CAST(N'2019-11-20 16:25:42.000' AS DateTime))
INSERT [dbo].[tbOrder] ([id], [user_id], [product_id], [quantity], [money], [method], [status], [date_create]) VALUES (8, 1, 7, N'1', N'8290000', N'COD', 1, CAST(N'2019-11-20 16:25:42.000' AS DateTime))
INSERT [dbo].[tbOrder] ([id], [user_id], [product_id], [quantity], [money], [method], [status], [date_create]) VALUES (9, 4, 15, N'2', N'7800000', N'COD', 1, CAST(N'2019-11-20 16:25:42.000' AS DateTime))
INSERT [dbo].[tbOrder] ([id], [user_id], [product_id], [quantity], [money], [method], [status], [date_create]) VALUES (10, 5, 15, N'2', N'7800000', N'COD', 0, CAST(N'2019-10-23 00:00:45.000' AS DateTime))
INSERT [dbo].[tbOrder] ([id], [user_id], [product_id], [quantity], [money], [method], [status], [date_create]) VALUES (11, 4, 13, N'1', N'9990000', N'COD', 1, CAST(N'2019-11-20 16:25:42.000' AS DateTime))
INSERT [dbo].[tbOrder] ([id], [user_id], [product_id], [quantity], [money], [method], [status], [date_create]) VALUES (12, 5, 9, N'2', N'15990000', N'COD', 1, CAST(N'2019-11-20 16:25:42.000' AS DateTime))
go
set IDENTITY_INSERT [tbOrder] off
go

set IDENTITY_INSERT [tbImage] on
go
INSERT [dbo].[tbImage] ([id], [url], [product_id]) VALUES (1, N'/Upload/Products/4ec3fc04c73b84b61ab9e4341a364975.jpg', 1)
INSERT [dbo].[tbImage] ([id], [url], [product_id]) VALUES (2, N'/Upload/Products/8bdd29b6ef9cfe5d4639c09717d2cc5d.jpg', 1)
INSERT [dbo].[tbImage] ([id], [url], [product_id]) VALUES (3, N'/Upload/Products/4ec3fc04c73b84b61ab9e4341a364975.jpg', 1)
INSERT [dbo].[tbImage] ([id], [url], [product_id]) VALUES (4, N'/Upload/Products/8bdd29b6ef9cfe5d4639c09717d2cc5d.jpg', 1)
INSERT [dbo].[tbImage] ([id], [url], [product_id]) VALUES (5, N'/Upload/Products/8c581916dfa8923d22ce24b316413a8d.jpg', 1)
INSERT [dbo].[tbImage] ([id], [url], [product_id]) VALUES (6, N'/Upload/Products/bdc148320885648dd91b0d510a787c7b.jpg', 1)
INSERT [dbo].[tbImage] ([id], [url], [product_id]) VALUES (7, N'/Upload/Products/a473fce4ea0fdccd9db68da03f3ab69b.jpg', 1)
INSERT [dbo].[tbImage] ([id], [url], [product_id]) VALUES (8, N'/Upload/Products/506873be34bcfc3e305df08d06243285.png', 9)
INSERT [dbo].[tbImage] ([id], [url], [product_id]) VALUES (9, N'/Upload/Products/c4ba11f89a82886689fc09f8fa58833c.jpg', 9)
INSERT [dbo].[tbImage] ([id], [url], [product_id]) VALUES (10, N'/Upload/Products/c266e751e543ba6525b2a3a1a15d1176.jpg', 15)
go
set IDENTITY_INSERT [tbImage] off
go

USE [master]
GO
