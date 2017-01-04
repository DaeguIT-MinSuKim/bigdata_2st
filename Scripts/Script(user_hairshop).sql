-- �̿��
DROP SCHEMA IF EXISTS hairshop;

-- �̿��
CREATE SCHEMA hairshop;

-- ��
CREATE TABLE hairshop.customer (
	cNo     INTEGER     NOT NULL COMMENT '����ȣ', -- ����ȣ
	cName   VARCHAR(20) NULL     COMMENT '����', -- ����
	cDob    DATE        NULL     COMMENT '�������', -- �������
	cDoJoin DATE        NULL     COMMENT '��������', -- ��������
	cPhone  VARCHAR(15) NOT NULL COMMENT '����ȣ' -- ����ȣ
)
COMMENT '��';

-- ��
ALTER TABLE hairshop.customer
	ADD CONSTRAINT PK_customer -- �� �⺻Ű
		PRIMARY KEY (
			cNo -- ����ȣ
		);

ALTER TABLE hairshop.customer
	MODIFY COLUMN cNo INTEGER NOT NULL AUTO_INCREMENT COMMENT '����ȣ';

-- �̺�Ʈ
CREATE TABLE hairshop.event (
	eNo       INTEGER     NOT NULL COMMENT '�̺�Ʈ��ȣ', -- �̺�Ʈ��ȣ
	eName     VARCHAR(20) NULL     COMMENT '�̺�Ʈ��', -- �̺�Ʈ��
	eDiscount DOUBLE      NULL     COMMENT '������' -- ������
)
COMMENT '�̺�Ʈ';

-- �̺�Ʈ
ALTER TABLE hairshop.event
	ADD CONSTRAINT PK_event -- �̺�Ʈ �⺻Ű
		PRIMARY KEY (
			eNo -- �̺�Ʈ��ȣ
		);

ALTER TABLE hairshop.event
	MODIFY COLUMN eNo INTEGER NOT NULL AUTO_INCREMENT COMMENT '�̺�Ʈ��ȣ';

-- ������� 
CREATE TABLE hairshop.hairinfo (
	hNo    INTEGER     NOT NULL COMMENT '����ȣ', -- ����ȣ
	hName  VARCHAR(20) NULL     COMMENT '����', -- ����
	hPrice INTEGER     NULL     COMMENT '�ܰ�' -- �ܰ�
)
COMMENT '������� ';

-- ������� 
ALTER TABLE hairshop.hairinfo
	ADD CONSTRAINT PK_hairinfo -- �������  �⺻Ű
		PRIMARY KEY (
			hNo -- ����ȣ
		);

ALTER TABLE hairshop.hairinfo
	MODIFY COLUMN hNo INTEGER NOT NULL AUTO_INCREMENT COMMENT '����ȣ';

-- ����
CREATE TABLE hairshop.market (
	mNo   INTEGER NOT NULL COMMENT '������ȣ', -- ������ȣ
	mDate DATE    NULL     COMMENT '��������', -- ��������
	mTime DATE    NULL     COMMENT '�湮�ð�', -- �湮�ð�
	cNo   INTEGER NULL     COMMENT '����ȣ', -- ����ȣ
	hNo   INTEGER NULL     COMMENT '����ȣ', -- ����ȣ
	eNo   INTEGER NULL     COMMENT '�̺�Ʈ��ȣ' -- �̺�Ʈ��ȣ
)
COMMENT '����';

-- ����
ALTER TABLE hairshop.market
	ADD CONSTRAINT PK_market -- ���� �⺻Ű
		PRIMARY KEY (
			mNo -- ������ȣ
		);

ALTER TABLE hairshop.market
	MODIFY COLUMN mNo INTEGER NOT NULL AUTO_INCREMENT COMMENT '������ȣ';

-- ����
ALTER TABLE hairshop.market
	ADD CONSTRAINT FK_customer_TO_market -- �� -> ����
		FOREIGN KEY (
			cNo -- ����ȣ
		)
		REFERENCES hairshop.customer ( -- ��
			cNo -- ����ȣ
		);

-- ����
ALTER TABLE hairshop.market
	ADD CONSTRAINT FK_hairinfo_TO_market -- �������  -> ����
		FOREIGN KEY (
			hNo -- ����ȣ
		)
		REFERENCES hairshop.hairinfo ( -- ������� 
			hNo -- ����ȣ
		);

-- ����
ALTER TABLE hairshop.market
	ADD CONSTRAINT FK_event_TO_market -- �̺�Ʈ -> ����
		FOREIGN KEY (
			eNo -- �̺�Ʈ��ȣ
		)
		REFERENCES hairshop.event ( -- �̺�Ʈ
			eNo -- �̺�Ʈ��ȣ
		);
		
		
-- DB 생성
		
		
select cNo, cName, cDob, cDoJoin, cPhone from customer;