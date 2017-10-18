drop database if exists myecdb;
create database if not exists myecdb;

use myECDB;

drop table if exists user_info;
create table if not exists user_info
(id int not null primary key auto_increment,
login_id varchar(32) unique,
login_pass varchar(32),
user_name varchar(50),
insert_date datetime,
updeted_date datetime);

INSERT INTO user_info(login_id,login_pass,user_name)VALUES("test01","test01","test");