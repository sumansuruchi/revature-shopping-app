package com.repository;

import com.main.shop.model.Product;
import com.shop.exception.BusinessException;

public interface EmployeeRepository {
	boolean isEmployeeAlreadyExist(String employeeUserName) throws BusinessException;
	boolean isPasswaordAlreadyExist(String  employeePassword) throws BusinessException;
	public int addProductByEmployee(Product product) throws BusinessException;
	
	

}
