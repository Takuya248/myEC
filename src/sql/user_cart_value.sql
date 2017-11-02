use myecdb;

drop table if exists user_cart_value;
create table if not exists user_cart_value(
user_id varchar(32) unique,
cart_value1 varchar(12),
cart_value2 varchar(12),
cart_value3 varchar(12),
cart_value4 varchar(12),
cart_value5 varchar(12),
);