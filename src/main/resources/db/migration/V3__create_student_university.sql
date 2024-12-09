create table student_university (
    id serial primary key ,
    idnp_student varchar(13) not null ,
    id_university int not null ,
    foreign key (idnp_student) references student(idnp),
    foreign key (id_university) references university(id)
);