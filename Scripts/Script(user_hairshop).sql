
select b.bNo, b.bDate, h.hName, h.hPrice, e.eName, (h.hPrice*(1-e.eDiscount)) as resultPrice  
from hairshop.biz b left outer join hairshop.hairinfo h on b.hNo = h.hNo
left outer join hairshop.event e on b.eNo = e.eNo; -- 헤어주문검색 테이블

select b.bNo, b.bDate, c.cName, h.hName, e.eName, (h.hPrice*(1-e.eDiscount)) as resultPrice  
from hairshop.biz b left outer join hairshop.hairinfo h on b.hNo = h.hNo
left outer join hairshop.customer c on b.cNo = c.cNo
left outer join hairshop.event e on b.eNo = e.eNo; -- 월별 연도별 테이블

select
from 