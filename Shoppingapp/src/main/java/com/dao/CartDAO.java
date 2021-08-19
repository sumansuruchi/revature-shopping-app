package com.dao;

import java.util.List;

import com.main.shop.model.Cart;
import com.shop.exception.BusinessException;

public interface CartDAO {
	public List<Cart> viewCart() throws BusinessException;
    public int addProductToCart(Cart cart) throws BusinessException;
	

}
