CREATE OR REPLACE VIEW hairshop.view_biz
AS select b.bNo, b.bDate,b.bTime,c.cNo,c.cName, c.cDel, 
		h.hNo, h.hName, h.hPrice, e.eNo, e.eName, e.eDiscount, year(bDate) as `year` from hairshop.biz b 
		left outer join hairshop.customer c on b.cNo = c.cNo
		left outer join hairshop.hairinfo h on b.hNo = h.hNo 
		left outer join hairshop.event e on b.eNo = e.eNo
;

grant select, insert, update, delete on hairshop.* to 'user_hairshop' identified by 'rootroot';