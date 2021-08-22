package com.dao;

import com.main.shop.model.Product;
import com.shop.exception.BusinessException;

public interface EmployeeDAO {
	public int addProductByEmployee(Product product) throws BusinessException;

}
