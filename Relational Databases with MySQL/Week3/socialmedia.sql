create database if not exists socialmedia;

use socialmedia;

drop table if exists comments;
drop table if exists posts;
drop table if exists users;

create table users (
      user_id int(11) not null auto_increment,
      username varchar(20) not null,
      email varchar(255) not null,
      passwd varchar(16) not null,
      primary key(user_id)
);

create table posts (
    post_id int(11) not null auto_increment,
    user_id int(11) not null,
    content varchar(255) not null,
    created_date timestamp not null,
    primary key(post_id),
    foreign key(user_id) references users(user_id)
);

create table comments (
    comment_id int(11) not null auto_increment,
    user_id int(11) not null,
    post_id int(11) not null,
    content varchar(255) not null,
    created_date timestamp not null,
    primary key(comment_id),
    foreign key(user_id) references users(user_id),
    foreign key(post_id) references posts(post_id)
);
