use myecdb;

drop table if exists payment_guestuser_info;
create table if not exists payment_guestuser_info(
user_id int,
user_name varchar(32),
mail_address varchar(96),
phone_number varchar(16),
state varchar(16),
city varchar(16),
street varchar(32),
building varchar(64),
zip_code int(8),
insert_date datetime

);