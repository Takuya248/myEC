use myecdb;

drop table if exists order_list;
create table if not exists order_list(
user_id int,
order_id int,
item_id int,
item_count int,
select_payment varchar(12),
insert_date datetime
);