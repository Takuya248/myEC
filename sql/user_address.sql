use myecdb;

drop table if exists user_address;
create table if not exists user_address(
user_id int,
state varchar(16),
city varchar(16),
street varchar(32),
building varchar(32),
zip_code int,
insert_date datetime
);