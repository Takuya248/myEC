use myECDB;

drop table if exists user_cart_info;
create table if not exists user_cart_info(
user_id varchar(32),
item_id int not null
);
