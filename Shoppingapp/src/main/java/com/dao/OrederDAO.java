package com.dao;

import com.main.shop.model.Cart;
import com.main.shop.model.Customer;
import com.main.shop.model.Product;
import com.shop.exception.BusinessException;

public interface OrederDAO {
	
	 public int addProductToOrder(Product product, Customer customer, Cart cart) throws BusinessException;
	

}
