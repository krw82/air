CREATE table airplane_ticket(
	 SEAT number,--좌석
	 ticket_number varchar2(50),--예약번호
	 check_in varchar2(50),--체크인 여부
	 flying_number varchar2(50)-- 스케쥴넘버
	 member_number varchar2(50) -- 회원넘버
);

insert into  airplane_ticket values (11,'2011-111-11','T','1','01');

CREATE table airplane_member(
	id varchar2(50),--아이디
	password varchar2(50), --비번
	address varchar2(50), --주소
	phone_number varchar2(50),--핸드폰 번호
	email varchar2(50),--이메일
	member_number number--회원넘버
);
insert into airplane_member values('21b','1234','dong','01050061482','dnjscjf0323@naver.com',1);

CREATE table airplane(
	airplane varchar2(50),--비행기
	Start_date Date,--출발일
	end_date Date, --도착일
	 STOPOVER varchar2(50), --경유지
	 Start_point varchar2(50), --출발지
	 END_point varchar2(50),--	도착지
	 flying_number varchar2(50),-- 스케쥴넘버
	 price NUMBER --가격
);
insert into airplane_member values('testair',2021-01-01,2021-02-02,'서울','인천','평양','1',10000);
-- 좌석은 11-49 까지




