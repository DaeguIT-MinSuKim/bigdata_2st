
select b.bNo, b.bDate, h.hName, h.hPrice, e.eName, (h.hPrice*(1-e.eDiscount)) as resultPrice  
from hairshop.biz b left outer join hairshop.hairinfo h on b.hNo = h.hNo
left outer join hairshop.event e on b.eNo = e.eNo; -- 헤어주문검색 테이블

select b.bNo, b.bDate, c.cName, h.hName, e.eName, (h.hPrice*(1-e.eDiscount)) as resultPrice  
from hairshop.biz b left outer join hairshop.hairinfo h on b.hNo = h.hNo
left outer join hairshop.customer c on b.cNo = c.cNo
left outer join hairshop.event e on b.eNo = e.eNo; -- 월별 연도별 테이블

select (select count(*) from hairshop.customer tc where tc.cDel = false) as '총고객수',
count(b.bNo) as '총영업수',
sum(h.hPrice*(1-e.eDiscount)) as '총금액'
from hairshop.biz b left outer join hairshop.hairinfo h on b.hNo = h.hNo
left outer join hairshop.customer c on b.cNo = c.cNo
left outer join hairshop.event e on b.eNo = e.eNo;

select h.hName as '스타일', count(b.hNo) as '주문 건수'
from hairshop.biz b, hairshop.hairInfo h
where b.hNo = h.hNo
group by b.hNo; -- 헤어스타일별 주문수 카운트

