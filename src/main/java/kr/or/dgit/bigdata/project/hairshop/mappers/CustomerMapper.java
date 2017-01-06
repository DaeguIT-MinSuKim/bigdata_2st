package kr.or.dgit.bigdata.project.hairshop.mappers;

import java.util.List;
import java.util.Map;

import kr.or.dgit.bigdata.project.hairshop.dto.Customer;

public interface CustomerMapper {
	int insertCustomer(Customer customer);
	int updateCustomer(Customer customer);
	int deleteCustomer(int id);
	List<Customer> searchCustomerByName(Map<String, Object> map);
}
