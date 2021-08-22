package com.service;

import com.dao.EmployeeDAO;
import com.dao.impl.EmployeeDAOImpl;
import com.main.shop.model.Product;
import com.repository.EmployeeRepository;
import com.shop.exception.BusinessException;

public class EmployeeService  implements EmployeeRepository{
	EmployeeDAO employeeDAO = new EmployeeDAOImpl();

	@Override
	public boolean isEmployeeAlreadyExist(String employeeUserName) throws BusinessException {
		
		return employeeUserName.equals("Admin");
	}

	@Override
	public boolean isPasswaordAlreadyExist(String employeePassword) throws BusinessException {
		
		return employeePassword.equals("Admin@123");
	}

	@Override
	public int addProductByEmployee(Product product) throws BusinessException {
		int isSuccesfull = 0;
        isSuccesfull = employeeDAO.addProductByEmployee(product);

        return isSuccesfull;
		
		
	}

}
