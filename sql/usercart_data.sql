use myecdb;

drop table if exists usercart_data;
create table if not exists usercart_data(
user_id int,
cart_data BLOB

);