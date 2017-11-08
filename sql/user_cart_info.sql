use myECDB;

drop table if exists user_cart_info;
create table if not exists user_cart_info(
user_id int,
item_id int,
item_stack int

);
