package com.main;

import org.apache.log4j.Logger;

import com.main.shop.model.Cart;
import com.main.shop.model.Customer;
import com.main.shop.model.Product;
import com.repository.CartRepository;
import com.repository.ProductSearch;
import com.service.CartService;
import com.service.ProductSearchService;
import com.shop.exception.BusinessException;

public class CartPage {
	private static Logger log = Logger.getLogger(CartPage.class);
	CartRepository cartRepository = new CartService();
	ProductSearch productSearch= new ProductSearchService();
	OrderPage orderPage = new OrderPage();
	

	public void addProductToCard(int productQuantity, int productId)  {
		int isuccessfull=0;
		try {
		Cart cart = new Cart();
		Product product =new Product();
		Customer customer = new Customer();
		
		product=productSearch.searchProductByProductId(productId);
		
		cart.setCartQuantity(productQuantity);
		cart.setProduct(product);
		cart.setCustomer(customer);
		isuccessfull=cartRepository.addProductToCart(cart);
		if(isuccessfull==1) {
			log.info("Sucessfull  " +product.getProductName() + " "+cart.getCartQuantity());
		}
		log.info("order");
		orderPage.addOrder(product, customer, cart);
		
		}catch (BusinessException e) {
			// TODO: handle exception
			log.warn(e.getMessage());
			
		}
	}
	
		
		
		
	
	

	
}
