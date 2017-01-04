package kr.or.dgit.bigdata.project.hairshop.mapper;

import java.util.List;
import kr.or.dgit.bigdata.project.hairshop.dto.Customer;

public interface CustomerMapper {
	void insertItem(Customer item);
	void deleteItem(Customer idx);
	void updateItem(Customer item);
	Customer selectByNo(int idx);
	List<Customer> selectByName(Customer name);// 이름으로 검색했을 때 여러명이 나올 수 가 있어서 List 형식으로 변경했어요. - 유진
	List<Customer> selectByAll();
}
