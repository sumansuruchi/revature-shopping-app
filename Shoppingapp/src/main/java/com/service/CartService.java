package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.main.ProductCategoryPage;
import com.main.shop.model.Cart;
import com.main.shop.model.Product;
import com.repository.CartRepository;
import com.shop.dbutil.Mysqlconnection;
import com.shop.exception.BusinessException;

public class CartService implements CartRepository {
	private static Logger log = Logger.getLogger(CartService.class);

	@Override
	public List<Cart> viewCart() throws BusinessException {
		List<Cart> cartList=null ;
		
        
        return cartList;
		
		
		

	}

	@Override
	public int addProductToCart(Cart cart) {
		int sucessful=0;
		return sucessful;
	}

}
