select count(bNo), sum(h.hPrice*(1-e.eDiscount)) 
from hairshop.biz b left outer join hairshop.hairinfo h on b.hNo = h.hNo 
left outer join hairshop.event e  on e.eNo = b.eNo
where b.bDate >= '2001-04-01' and b.bDate < '2001-06-01';

insert into hairshop.biz values
(6,'2001-12-10','15:00:00',1,5,3),
(7,'2001-12-31','15:00:00',1,6,2);

select year(bDate) , month(bDate) from biz;
select * from biz; 

-- viewTable 생성 구문 변경 되었습니다. 유진
CREATE OR REPLACE VIEW hairshop.view_biz
AS select b.bNo, b.bDate,b.bTime,c.cNo,c.cName, c.cDel, 
		h.hNo, h.hName, h.hPrice, e.eNo, e.eName, e.eDiscount, year(bDate) as `year` from hairshop.biz b 
		left outer join hairshop.customer c on b.cNo = c.cNo
		left outer join hairshop.hairinfo h on b.hNo = h.hNo 
		left outer join hairshop.event e on b.eNo = e.eNo
;

select distinct year(bDate) from view_biz;

select * from view_biz where year(bDate)=2001 and month(bDate) = 5;

select * from view_biz where year(bDate)=2001;

select count(bNo) as cnt, sum(hPrice*(1-eDiscount)) as sum from view_biz;


insert into hairshop.biz values
(8,'2001-12-10','15:00:00',1,5,3);