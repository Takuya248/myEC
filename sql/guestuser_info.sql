use myecdb;

drop table if exists guestuser_info;
create table if not exists guestuser_info(
guestuser_id int primary key auto_increment,
user_name varchar(32),
mail_address varchar(96),
phone_number varchar(16),
state varchar(16),
city varchar(16),
street varchar(32),
building varchar(64),
zip_code int(8)

);