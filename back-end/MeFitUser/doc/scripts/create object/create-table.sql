drop table if exists user;

drop table if exists user_type;

create table user (id bigint not null auto_increment, login varchar(255), name varchar(255), password varchar(255), status integer, user_type_id bigint, primary key (id)) engine=InnoDB;

create table user_type (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;

alter table user add constraint FKlrk9xrdps0emd6d5rx5x3ib6h foreign key (user_type_id) references user_type (id);