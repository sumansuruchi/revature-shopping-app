package com.customer.dao;

import com.main.shop.model.Customer;
import com.shop.exception.BusinessException;

public interface CustomerDao {
	int registerCustomer(Customer customer)throws BusinessException;
	boolean isUserAlreadyExist(String ct_username) throws BusinessException;
	boolean isPasswaordAlreadyExist(String  ct_password) throws BusinessException;
	
	
	
	
	
	

}
