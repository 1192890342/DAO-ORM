CREATE TABLE members(
	mid 		NUMBER ,
	name 		VARCHAR2(20),
	age 		number,
	birthday 	date,
	salary		number(20),
	note 		varchar2(50),
	photo 		clob,
	constraint pk_mid3 primary key(mid)
);