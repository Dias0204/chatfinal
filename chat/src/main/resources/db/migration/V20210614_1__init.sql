drop table if exists auth;
create table auth(
    id serial,
    login varchar(255),
    password varchar(255),
    token varchar(255) ,
    user_id bigint
);

drop table if exists users;
create table users(
    id serial,
    name varchar(255)
);

drop table if exists chat;
create table chat(
    id serial,
    name varchar(255)
);

drop table if exists message;
create table message(
    id serial,
    user_id bigint,
    chat_id bigint,
    text varchar(255)
);