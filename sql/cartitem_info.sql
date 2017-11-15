use myecdb;

drop table if exists cartitem_info;
create table if not exists cartitem_info(
user_id int not null,
item_id int,
item_count int,
update_date datetime
);

INSERT INTO cartitem_info(user_id,item_id,item_count)VALUE(1,1,2),(1,2,5),(2,1,2);