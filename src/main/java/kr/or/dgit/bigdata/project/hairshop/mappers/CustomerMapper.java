package kr.or.dgit.bigdata.project.hairshop.mappers;

import kr.or.dgit.bigdata.project.hairshop.dto.Customer;

public interface CustomerMapper {
	int insertCustomer(Customer customer);
	int updateCustomer(Customer customer);
	int deleteCustomer(int id);
}
