package com.service;

import com.dao.OrederDAO;
import com.dao.impl.OrderDAOImpl;
import com.main.shop.model.Cart;
import com.main.shop.model.Customer;
import com.main.shop.model.Product;
import com.repository.OrderRepository;
import com.shop.exception.BusinessException;

public class OrderService  implements OrderRepository{
	OrederDAO orderDAO = new OrderDAOImpl();


	@Override
	
	    
	    public int addProductToOrder(Product product, Customer customer, Cart cart) throws BusinessException {
	        int isSucessfull;
	        isSucessfull = orderDAO.addProductToOrder(product, customer, cart);
	        return isSucessfull;
	}

}
