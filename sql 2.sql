CREATE table ticket(
	 Start_point varchar2(50), --출발지
	 STOPOVER varchar2(50), --경유지
	 DESTINATION varchar2(50),--	도착지
	 Start_date Date,--출발일
	 end_date Date, --도착일
	 PEOPLE_NUMBER NUMBER, --인원수
	 airplane varchar2(50), --비행기
	 SEAT varchar2(50),--좌석
	 ticket_number varchar2(50),--예약번호
	 check_in varchar2(50)--체크인 여부
);

CREATE table airplane_member(
	id varchar2(50),--아이디
	password varchar2(50), --비번
	address varchar2(50), --주소
	phone_number varchar2(50),--핸드폰 번호
	email varchar2(50),--이메일
	member_number varchar2(50)--회원넘버



);