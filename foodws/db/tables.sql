create table FB_POINTS
(
	POINTID bigint GENERATED ALWAYS AS IDENTITY,
	POINTBRIEF varchar(150),
	POINTNAME varchar(255),
	POINTADDRESS varchar(255),
	POINTLOGO text,
	EMAIL varchar(150),
	COORDINATES varchar(150)
);

create table FB_CATEGORIES
(
	CTGRID bigint GENERATED ALWAYS AS IDENTITY,
	POINTID bigint,
	CTGRBRIEF varchar(150),
	CTGRNAME varchar(255),
	CTGRLOGO text,
	DESCRIPTION varchar(255)
);

create table FB_PRODUCTS
(
	PRDID bigint GENERATED ALWAYS AS IDENTITY,
	CTGRID bigint,
	PRDBRIEF varchar(150),
	PRDNAME varchar(255),
	PRDLOGO text,
	DESCRIPTION varchar(255),
	COST numeric(38,2),
	POINTID bigint
);

create table FB_ORDER
(
	ORDERID bigint GENERATED ALWAYS AS IDENTITY,
	ORDERDATE date,
	CLIENTPHONE varchar(20),
	CLIENTNAME varchar(255),
	POINTID bigint,
	TOTALCOST numeric(38,2),
	ORDERSTATE varchar(50),
	USERID bigint
);

create table FB_ORDERSATTRIBUTE
(
	ORDERATTRIBUTEID bigint GENERATED ALWAYS AS IDENTITY,
	ORDERID bigint,
	PRODUCTID bigint,
	PRODUCTNAME varchar(255),
	PRCOST numeric(38,2),
	CNT int
);

create table FB_CLIENTS
(
    CLIENTID bigint GENERATED ALWAYS AS IDENTITY,
    CLIENTNAME varchar(150),
    CLIENTPHONE varchar(20),
    DEVICEID varchar(255)
);

create table FB_USERS
(
    USERID bigint GENERATED ALWAYS AS IDENTITY,
    USERPHONE varchar(20),
    USERNAME varchar(150),
    DEVICEID varchar(255)
);

create table FB_CODES
(
    CLIENTPHONE varchar(20),
    CODE varchar(10),
    COUNTS numeric(10)
);
