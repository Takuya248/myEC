use myecdb;

drop table if exists item_info;
create table if not exists item_info(
id int not null primary key auto_increment,
category_id enum("rod","reel","lure"),
item_name varchar(32),
item_price varchar(8),
item_stock varchar(8),
insert_date datetime,
update_date datetime
);

insert into item_info(
category_id,item_name,item_price,item_stock
)value(
"rod","安いロッド","5000","20"
),(
"rod","並みのロッド","10000","9"
),(
"rod","高いロッド","20000","5"
);