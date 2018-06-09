create table user(
user_name varchar(50),
user_id varchar(50),
lost_thing_id int ,
 primary key (lost_thing_id),
 foreign key (lost_thing_id) references lost_thing(lost_thing_id)
)ENGINE=InnoDB;