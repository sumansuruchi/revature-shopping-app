package com.repository;

import java.util.List;

import com.main.shop.model.Customer;
import com.shop.exception.BusinessException;

public interface CustomerRepository {
	public int createCustomer(Customer customer) throws BusinessException;
    public int deleteCustomer(int customerId);
    public List<Customer> viewCustomer() throws BusinessException;
    public boolean isValidCustomerUsername(String customerUsername) throws BusinessException;
    public boolean isValidCustomerPassword(String customerPassword) throws BusinessException;

}
