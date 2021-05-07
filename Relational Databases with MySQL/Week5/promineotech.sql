create database if not exists promineotech;

use promineotech;

drop table if exists vehicles;

create table vehicles (
      vehicle_id int(11) not null,
      make varchar(255) not null,
      model varchar(255) not null,
      year varchar(4) not null,
      primary key(vehicle_id)
);

