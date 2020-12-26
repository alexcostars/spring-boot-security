# Spring Boot + String Security

Initializing MySQL database

```sql
create database testdb;

create table roles (id bigint not null auto_increment, authority varchar(255), primary key (id));
create table users (id bigint not null auto_increment, email varchar(255), name varchar(255), password varchar(255), primary key (id));
create table user_roles (id bigint not null auto_increment, role_id bigint, user_id bigint, primary key (id));


-- dados de exemplo (senha = 123)
insert into users values (1, 'alex@costa.com', 'Alex Costa', '{bcrypt}$2a$10$xajUQA2O6ym7AqBB/LrG2eZ0J0WAh.6FfL2CtDEfOwGMrRAGDAqMq');
insert into roles values (1, "ADMIN");
insert into user_roles VALUES (1, 1, 1);

```
