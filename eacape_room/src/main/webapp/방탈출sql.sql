create database room;
use room;
drop table if exists misroom;
create table misroom(
   mno int auto_increment primary key,
    mname varchar(10),
   mid varchar(15),
    mpw varchar(20),
    mphone varchar(15)
);

select * from misroom;

insert into misroom(mname,mid,mpw,mphone) values ('고은시','rhdmstl2222','rhdmstl2222','010-9023-2204');

select * from misroom where mname = '고은시' and mphone= '010-9023-2204';

select * from misroom where mid = 'rhdmstl0422' and mphone= '010-9023-2204';