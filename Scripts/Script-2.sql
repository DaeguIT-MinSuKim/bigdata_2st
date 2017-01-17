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

insert into hairshop.biz values
(1,'2000-05-10','15:00:00',1,5,3),
(2,'2000-05-11','11:15:00',3,2,2),
(3,'2001-05-12','04:00:00',2,1,3),
(4,'2001-05-14','05:10:00',4,7,2),
(5,'2001-05-14','09:30:00',2,4,4);

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
