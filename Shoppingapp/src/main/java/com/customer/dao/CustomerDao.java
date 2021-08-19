package com.customer.dao;

import com.main.shop.model.Customer;
import com.shop.exception.BusinessException;

public interface CustomerDao {
	int registerCustomer(Customer customer)throws BusinessException;
	boolean isUserAlreadyExist(String customerUserame) throws BusinessException;
	boolean isPasswaordAlreadyExist(String  customerPassword) throws BusinessException;
	   
	
	
	
	
	
	

}
