drop database if exists room;
create database room;
use room;
drop table if exists room;
create table room(
	mno int auto_increment primary key,
    mname varchar(10),
	mid varchar(15),
    mpw varchar(20),
    mphone varchar(15)
);

select * from room;

drop table if exists rboard;
create table rboard(
	rno int auto_increment ,  				-- 게시물번호
    rtitle varchar(100), 					-- 게시물제목
    rcontent varchar(1000),					-- 게시물내용
    rscore int,								-- 점수
	rfile varchar(1000),					-- 첨부파일
    rcomment varchar(100),					-- 댓글
    rdate datetime default now(),			-- 작성일
    rview int,								-- 조회수
    mno int, 								-- 회원번호
	constraint rno_pk primary key (rno),
    constraint rmno_fk foreign key (mno) references room(mno) on update cascade
);

select * from rboard;