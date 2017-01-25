-- 미용실
DROP SCHEMA IF EXISTS hairshop;

-- 미용실
CREATE SCHEMA hairshop;

-- 고객
CREATE TABLE hairshop.customer (
	cNo     INTEGER     NOT NULL COMMENT '고객번호', -- 고객번호
	cName   VARCHAR(20) NULL     COMMENT '고객명', -- 고객명
	cDob    DATE        NULL     COMMENT '생년월일', -- 생년월일
	cDoJoin DATE        NULL     COMMENT '가입일자', -- 가입일자
	cPhone  VARCHAR(15) NOT NULL COMMENT '폰번호', -- 폰번호
	cDel    BOOLEAN     NULL     COMMENT '탈퇴여부' -- 탈퇴여부
)
COMMENT '고객';

-- 고객
ALTER TABLE hairshop.customer
	ADD CONSTRAINT PK_customer -- 고객 기본키
		PRIMARY KEY (
			cNo -- 고객번호
		);

ALTER TABLE hairshop.customer
	MODIFY COLUMN cNo INTEGER NOT NULL AUTO_INCREMENT COMMENT '고객번호';

-- 이벤트
CREATE TABLE hairshop.event (
	eNo       INTEGER     NOT NULL COMMENT '이벤트번호', -- 이벤트번호
	eName     VARCHAR(20) NULL     COMMENT '이벤트명', -- 이벤트명
	eDiscount DOUBLE      NULL     COMMENT '할인율' -- 할인율
)
COMMENT '이벤트';

-- 이벤트
ALTER TABLE hairshop.event
	ADD CONSTRAINT PK_event -- 이벤트 기본키
		PRIMARY KEY (
			eNo -- 이벤트번호
		);

ALTER TABLE hairshop.event
	MODIFY COLUMN eNo INTEGER NOT NULL AUTO_INCREMENT COMMENT '이벤트번호';

-- 헤어정보 
CREATE TABLE hairshop.hairinfo (
	hNo    INTEGER     NOT NULL COMMENT '헤어번호', -- 헤어번호
	hName  VARCHAR(20) NULL     COMMENT '헤어명', -- 헤어명
	hPrice INTEGER     NULL     COMMENT '단가' -- 단가
)
COMMENT '헤어정보 ';

-- 헤어정보 
ALTER TABLE hairshop.hairinfo
	ADD CONSTRAINT PK_hairinfo -- 헤어정보  기본키
		PRIMARY KEY (
			hNo -- 헤어번호
		);

ALTER TABLE hairshop.hairinfo
	MODIFY COLUMN hNo INTEGER NOT NULL AUTO_INCREMENT COMMENT '헤어번호';

-- 영업
CREATE TABLE hairshop.biz (
	bNo   INTEGER NOT NULL COMMENT '영업번호', -- 영업번호
	bDate DATE    NULL     COMMENT '영업일자', -- 영업일자
	bTime TIME    NULL     COMMENT '방문시간', -- 방문시간
	cNo   INTEGER NULL     COMMENT '고객번호', -- 고객번호
	hNo   INTEGER NULL     COMMENT '헤어번호', -- 헤어번호
	eNo   INTEGER NULL     COMMENT '이벤트번호' -- 이벤트번호
)
COMMENT '영업';

-- 영업
ALTER TABLE hairshop.biz
	ADD CONSTRAINT PK_biz -- 영업 기본키
		PRIMARY KEY (
			bNo -- 영업번호
		);

ALTER TABLE hairshop.biz
	MODIFY COLUMN bNo INTEGER NOT NULL AUTO_INCREMENT COMMENT '영업번호';

-- 영업
ALTER TABLE hairshop.biz
	ADD CONSTRAINT FK_customer_TO_biz -- 고객 -> 영업
		FOREIGN KEY (
			cNo -- 고객번호
		)
		REFERENCES hairshop.customer ( -- 고객
			cNo -- 고객번호
		);

-- 영업
ALTER TABLE hairshop.biz
	ADD CONSTRAINT FK_hairinfo_TO_biz -- 헤어정보  -> 영업
		FOREIGN KEY (
			hNo -- 헤어번호
		)
		REFERENCES hairshop.hairinfo ( -- 헤어정보 
			hNo -- 헤어번호
		);

-- 영업
ALTER TABLE hairshop.biz
	ADD CONSTRAINT FK_event_TO_biz -- 이벤트 -> 영업
		FOREIGN KEY (
			eNo -- 이벤트번호
		)
		REFERENCES hairshop.event ( -- 이벤트
			eNo -- 이벤트번호
		);
-- insert 시작
		
insert into hairshop.customer values
(1, '고연정','1990-02-20','2001-05-10','010-123-1234',false),
(2, '김연지','1992-09-09','2000-03-02','010-456-4567',false),
(3, '이나라','1987-06-09','2001-08-08','010-789-7890',false),
(4, '최순호','1990-10-11','2001-08-02','010-147-1472',false);

insert into hairshop.customer(cName, cDob, cDoJoin, cPhone, cDel) values 
('김일수', '1987-6-5', '2002-2-20','010-1111-1111', false),
('박이수', '1985-7-9', '2003-6-20','010-2345-1234', false),
('김삼순', '1990-1-6', '2004-5-08','010-3456-1284', false),
('이사수', '1995-3-1', '2005-6-28','010-4567-9874', false),
('최오수', '1978-5-3', '2006-4-10','010-8514-8452', false),
('허일수', '2000-3-5', '2007-1-01','010-6589-1254', false),
('나상수', '1989-8-25', '2008-5-30','010-8521-9852', false),
('오달수', '1987-3-25', '2010-7-01','010-6523-7854', false),
('김일수', '1988-9-29', '2014-7-14','010-6512-8945', false);


insert into hairshop.event values 
(1, '기획' ,0.5),(2, '생일' ,0.3),(3, '일반' ,0.0),(4, '조조' ,0.2);

insert into hairshop.hairinfo values (1,'커트',15000),
(2,'드라이',12000),
(3,'샴푸',5000),
(4,'펌',38500),
(5,'매직',95000),
(6,'트리트먼트',35000),
(7,'앰플',18000),
(8,'기타',16000);

insert into hairshop.biz(bDate,bTime,cNo,hNo,eNo) values
('2013-05-10','15:00:00',5,8,3),
('2013-05-11','11:15:00',6,7,2),
('2013-06-12','04:00:00',7,6,3),
('2013-06-14','05:10:00',3,5,2),
('2014-12-14','09:30:00',4,4,4),
('2014-05-10','15:00:00',1,3,3),
('2014-05-11','11:15:00',4,2,2),
('2014-06-12','04:00:00',12,1,3),
('2014-12-14','05:10:00',13,7,2),
('2015-12-14','09:30:00',11,4,4),
('2015-05-10','15:00:00',13,5,3),
('2015-05-11','11:15:00',7,2,2),
('2015-05-12','04:00:00',8,1,3),
('2015-06-14','05:10:00',9,3,2),
('2016-12-14','09:30:00',11,4,4),
('2016-01-10','15:00:00',10,8,3),
('2016-01-11','11:15:00',8,6,2),
('2016-01-12','04:00:00',3,3,3),
('2016-03-14','05:10:00',2,7,2),
('2016-04-14','09:30:00',9,1,4),
('2016-05-10','15:00:00',13,5,3),
('2016-05-11','11:15:00',12,3,2),
('2016-06-11','11:15:00',11,2,2),
('2016-06-12','04:00:00',2,1,3),
('2016-06-14','05:10:00',5,7,2),
('2016-06-14','09:30:00',7,4,4),
('2016-06-10','15:00:00',1,5,3),
('2016-06-11','11:15:00',4,7,2),
('2016-07-12','04:00:00',5,1,3),
('2016-07-14','05:10:00',4,7,2),
('2016-12-14','05:10:00',2,7,2),
('2017-01-14','09:30:00',12,2,4);



CREATE OR REPLACE VIEW hairshop.view_biz
AS select b.bNo, b.bDate,b.bTime,c.cNo,c.cName, c.cDel, 
		h.hNo, h.hName, h.hPrice, e.eNo, e.eName, e.eDiscount, year(bDate) as `year` from hairshop.biz b 
		left outer join hairshop.customer c on b.cNo = c.cNo
		left outer join hairshop.hairinfo h on b.hNo = h.hNo 
		left outer join hairshop.event e on b.eNo = e.eNo;

-- 관리자 모드 계정
CREATE TABLE hairshop.manager (
	mNo   INTEGER NOT NULL COMMENT '관리자 번호', 
	mName	VARCHAR(20) NULL COMMENT '관리자 아이디', 
	mPassword   VARCHAR(20) NULL COMMENT '관리자 비밀번호' 
)
COMMENT '관리자 계정';

-- 관리자
ALTER TABLE hairshop.manager
	ADD CONSTRAINT PK_manager -- 관리자 기본키
		PRIMARY KEY (
			mNo -- 관리자 번호
		);
ALTER TABLE hairshop.manager
	MODIFY COLUMN mNo INTEGER NOT NULL AUTO_INCREMENT COMMENT '관리자 번호';

insert into hairshop.manager values 
(1, 'bigdata' ,'rootroot');


select * from hairshop.view_biz where year(bDate) = 2000 and month(bDate)=5; -- 영업일자가 2000년, 5월인 실적 조회
select * from hairshop.view_biz where year(bDate) = 2000 and month(bDate)=6; -- 영업일자가 2000년, 6월인 실적 조회(실제 데이터 없음)

select * from hairshop.view_biz;
select * from hairshop.customer;
select * from hairshop.event;

