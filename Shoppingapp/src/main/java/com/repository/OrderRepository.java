package com.repository;

import com.main.shop.model.Cart;
import com.main.shop.model.Customer;
import com.main.shop.model.Product;
import com.shop.exception.BusinessException;

public interface OrderRepository {
	public int addProductToOrder(Product product, Customer customer, Cart cart) throws BusinessException;

}
