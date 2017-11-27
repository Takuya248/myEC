use myecdb;

drop table if exists user_info;
create table if not exists user_info(
user_id int not null primary key auto_increment,
login_id varchar(32) unique,
login_pass varchar(32),
user_name varchar(32),
mail_add varchar(32),
phone_number varchar(32),
state varchar(16),
city varchar(16),
street varchar(32),
building varchar(64),
zip_code int(8),
insert_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
update_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
address_regi_flag bit(1) not null default b'0'
);




INSERT INTO user_info(login_id,login_pass,user_name)VALUES('testid','testpass','testuser');
