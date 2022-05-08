-- Drop the tables if they exist

DROP TABLE IF EXISTS OrderTransaction;
DROP TABLE IF EXISTS SupplyTransaction;
DROP TABLE IF EXISTS Supplier;
DROP TABLE IF EXISTS OrderDishes;
DROP TABLE IF EXISTS FoodOrder;
DROP TABLE IF EXISTS Dish;
DROP TABLE IF EXISTS Employee;
DROP TABLE IF EXISTS Account cascade;


--creating the tables--
create table Account(
	accountId serial primary key, 
	accountEmail varchar(50) unique not null,
	accountPass varchar(50) not null,
	accountLastName varchar(50) not null,
	accountFirstName varchar(50) not null,
	accountAddress varchar(140),
	accountPhone char(13),
	accountAUIer boolean not null
);


create table Employee(
	employeeCIN varchar(8) primary key,
	employeeFname varchar(50) not null,
	employeeLname varchar(50) not null,
	employeePosition varchar(30) not null,
	employeePhone char(10), 
	employeeHoursWorked int	
);

create table FoodOrder(
	orderId serial primary key,
	orderType varchar(30) not null, 
	orderDate date not null,
	orderTime time not null,
	orderPhone char(10),
	orderTotalPrice decimal(8,2) not null,
	orderDiscountRate decimal(3,2) not null,
	employeeCIN varchar(8), 
	accountId int,
	constraint confirms foreign key (employeeCIN) references employee(employeeCIN) 
	on update cascade on delete set null,
	constraint may_start foreign key (accountId) references account(accountId) on update cascade
	on delete set null
);

create table Dish(
	dishId int primary key,
	dishName varchar(50) not null,
	dishType varchar(30),
	dishPrice decimal(5,2) not null,
	dishPopularity int not null default 0
);

create table orderDishes(
	orderId serial not null,
	dishId int not null,
	orderQuantity int not null, 
	orderSubTotal decimal(8,2) not null default 0,
	primary key(orderId, dishId),
	constraint has foreign key (orderId) references FoodOrder(orderId) on update cascade
	on delete set null,
	constraint is_in foreign key (dishId) references Dish(dishId) on update cascade 
	on delete set null
);

CREATE TABLE OrderTransaction(
	OrderID serial PRIMARY KEY,
	OrderTransTime time NOT NULL,
	OrderTransDate date NOT NULL,
	CONSTRAINT generates FOREIGN KEY (orderID) REFERENCES FoodOrder(orderID) on update cascade
	on delete set null
);

CREATE TABLE Supplier(
	SupplierID int PRIMARY KEY,
	SupplierName varchar(10) NOT NULL,
	SupplierContact varchar(20) NOT NULL,
	SupplierPhone char(10)
);


CREATE TABLE SupplyTransaction(
	SupplyTransID int PRIMARY KEY,
	SupplyTransDesc varchar(50),
	SupplyTransDate date NOT NULL,
	SupplyTransTime time NOT NULL,
	SupplyTrans_TotalPrice float NOT NULL,
	SupplierID int NOT NULL,
	CONSTRAINT refers_to FOREIGN KEY (SupplierID) REFERENCES Supplier(SupplierID) on update cascade
	on delete set null
);


