
select b.bNo, b.bDate, h.hName, h.hPrice, e.eName, (h.hPrice*(1-e.eDiscount)) as resultPrice  
from hairshop.biz b left outer join hairshop.hairinfo h on b.hNo = h.hNo
left outer join hairshop.event e on b.eNo = e.eNo order by b.bNo desc; -- 헤어주문검색 테이블

select b.bNo, b.bDate, c.cName, h.hName, e.eName, (h.hPrice*(1-e.eDiscount)) as resultPrice  
from hairshop.biz b left outer join hairshop.hairinfo h on b.hNo = h.hNo
left outer join hairshop.customer c on b.cNo = c.cNo
left outer join hairshop.event e on b.eNo = e.eNo order by b.bNo desc; -- 월별 연도별 테이블

select (select count(*) from hairshop.customer tc where tc.cDel = false) as totalCustomer,
count(b.bNo) as totalBiz,
sum(h.hPrice*(1-e.eDiscount)) as totalMoney
from hairshop.biz b left outer join hairshop.hairinfo h on b.hNo = h.hNo
left outer join hairshop.customer c on b.cNo = c.cNo
left outer join hairshop.event e on b.eNo = e.eNo; -- 헤어 현황

select h.hName as hairStyle, count(b.hNo) as sumOrder
from hairshop.biz b, hairshop.hairInfo h
where b.hNo = h.hNo
group by b.hNo; -- 그래프용 헤어스타일별 주문수 카운트

select b.bNo, b.bDate, h.hName, h.hPrice, e.eName, (h.hPrice*(1-e.eDiscount)) as resultPrice from hairshop.biz b 
left outer join hairshop.hairinfo h on b.hNo = h.hNo left outer join hairshop.event e on b.eNo = e.eNo 
where b.bDate >= '2001-01-01' and b.bDate <= '2001-12-12' order by bNo desc; -- 날짜 검색 테이블

