drop database if exists myecdb;
create database if not exists myecdb;

use myECDB;

drop table if exists user_info;
create table if not exists user_info
(id int not null primary key auto_increment,
login_id varchar(32) unique,
login_pass varchar(32),
user_name varchar(50),
phone_number varchar(15),
mail_add varchar(64),
insert_date datetime,
updeted_date datetime);

drop table if exists item_info;
create table if not exists item_info(
id int not null primary key auto_increment,
item_name varchar(30),
item_price int,
item_stock int,
insert_date datetime,
update_date datetime
);

drop table if exists user_buy_info;
create table if not exists user_buy_info(
id int not null primary key auto_increment,
item_transaction_id int,
total_price int,
total_count int,
user_master_id varchar(16),
pay varchar(30),
insert_date datetime,
update_date datetime
);

INSERT INTO user_info(login_id,login_pass,user_name)VALUES("test01","test","testuser");
INSERT INTO item_info(item_name,item_price,item_stock)VALUES("本",500,10);