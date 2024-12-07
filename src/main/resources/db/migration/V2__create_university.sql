create table student (
     idnp varchar(13) primary key ,
     first_name varchar(30) not null ,
     last_name varchar(30) not null ,
     email varchar(50) unique ,
     gender char not null ,
     age int not null
);