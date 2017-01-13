package kr.or.dgit.bigdata.project.hairshop.mappers;

import java.util.List;
import java.util.Map;

import kr.or.dgit.bigdata.project.hairshop.dto.Customer;

public interface CustomerMapper {
	int insertCustomer(Customer customer);
	int updateCustomer(Customer customer);
	int deleteCustomer(Customer customer);
	List<Customer> searchCustomerByName(Map<String, Object> map);// 이름 검색이긴 하지만 map의 키값만 교체하면 번호나 휴대폰 등 다른 변수로도 검색 가능
	Customer searchCustomerByNo(int cNo);
	List<Customer> selectByAll();
	List<Customer> searchCustomerByNoForJoin(Map<String, Object> map);
}
