package kr.or.dgit.bigdata.project.hairshop.mappers;

import kr.or.dgit.bigdata.project.hairshop.dto.Customer;

public interface CustomerMapper {
	int insertCustomer(Customer customer);
	int updateCustomer(Customer customer);
	/*void deleteItem(Customer idx);
	void updateItem(Customer item);
	Customer selectByNo(int idx);
	Customer selectByName(Customer name);
	List<Customer> selectByAll();*/
}
