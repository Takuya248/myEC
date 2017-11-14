use myecdb;

drop table if exists user_info;
create table if not exists user_info(
user_id int not null primary key auto_increment,
login_id varchar(32) unique,
login_pass varchar(32),
user_name varchar(32),
phone_number varchar(32),
mail_add varchar(32),
address varchar(32),
insert_date datetime,
updeted_date datetime
);




INSERT INTO user_info(login_id,login_pass,user_name)VALUES('testid','testpass','testuser');
