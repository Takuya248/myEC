use myecdb;

drop table if exists confirmed_cart;
create table if not exists confirmed_cart(
user_id int,
cart_id int,
item_id int,
item_count int,
insert_date datetime
);