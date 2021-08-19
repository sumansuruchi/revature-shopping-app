package com.main;

import java.util.List;

import org.apache.log4j.Logger;

import com.main.shop.model.Cart;
import com.main.shop.model.Customer;
import com.main.shop.model.Product;
import com.repository.CartRepository;
import com.service.CartService;
import com.shop.exception.BusinessException;

public class CartPage {
	private static Logger log = Logger.getLogger(CartPage.class);
	CartRepository cartRepository=new CartService();
	public void addProductToCard(int productQuantity, int productId) {
        try {
			List<Cart> cartList = cartRepository.viewCart();
			
		} catch (BusinessException e) {
			
			e.printStackTrace();
		}
        Product product ;
        
        log.info("My Cart");
        
        

}
}
