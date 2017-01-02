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
	cPhone  VARCHAR(15) NOT NULL COMMENT '폰번호' -- 폰번호
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
CREATE TABLE hairshop.market (
	mNo   INTEGER NOT NULL COMMENT '영업번호', -- 영업번호
	mDate DATE    NULL     COMMENT '영업일자', -- 영업일자
	mTime DATE    NULL     COMMENT '방문시간', -- 방문시간
	cNo   INTEGER NULL     COMMENT '고객번호', -- 고객번호
	hNo   INTEGER NULL     COMMENT '헤어번호', -- 헤어번호
	eNo   INTEGER NULL     COMMENT '이벤트번호' -- 이벤트번호
)
COMMENT '영업';

-- 영업
ALTER TABLE hairshop.market
	ADD CONSTRAINT PK_market -- 영업 기본키
		PRIMARY KEY (
			mNo -- 영업번호
		);

ALTER TABLE hairshop.market
	MODIFY COLUMN mNo INTEGER NOT NULL AUTO_INCREMENT COMMENT '영업번호';

-- 영업
ALTER TABLE hairshop.market
	ADD CONSTRAINT FK_customer_TO_market -- 고객 -> 영업
		FOREIGN KEY (
			cNo -- 고객번호
		)
		REFERENCES hairshop.customer ( -- 고객
			cNo -- 고객번호
		);

-- 영업
ALTER TABLE hairshop.market
	ADD CONSTRAINT FK_hairinfo_TO_market -- 헤어정보  -> 영업
		FOREIGN KEY (
			hNo -- 헤어번호
		)
		REFERENCES hairshop.hairinfo ( -- 헤어정보 
			hNo -- 헤어번호
		);

-- 영업
ALTER TABLE hairshop.market
	ADD CONSTRAINT FK_event_TO_market -- 이벤트 -> 영업
		FOREIGN KEY (
			eNo -- 이벤트번호
		)
		REFERENCES hairshop.event ( -- 이벤트
			eNo -- 이벤트번호
		);
		
-- exerd 포워딩 생성 클립보드