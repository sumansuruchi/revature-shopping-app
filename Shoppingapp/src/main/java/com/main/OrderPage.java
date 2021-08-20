package com.main;

import org.apache.log4j.Logger;

import com.main.shop.model.Cart;
import com.main.shop.model.Customer;
import com.main.shop.model.Order;
import com.main.shop.model.Product;
import com.repository.OrderRepository;
import com.service.OrderService;
import com.shop.exception.BusinessException;

public class OrderPage {
	private static final Logger log = Logger.getLogger(CartPage.class);
	OrderRepository orderRepository = new OrderService();
	public void addOrder(Product product, Customer customer, Cart cart, int orderStatus) {
        int isSucessfull;
        Order order = new Order();
        try {
            isSucessfull = orderRepository.addProductToOrder(product, customer, cart, orderStatus);
            if (isSucessfull == 1) {
                log.info("Your order information.");
                
                log.info(" Order ID : " +order.getOrderId());
               
                log.info("| Name : " +product.getProductName());
                log.info("| Category : " +product.getProductCategory().getProductCategoryName());
                log.info("| Quantity: "+cart.getCartQuantity());
                log.info("| Total Price : " +cart.getCartTotal());
                
                log.info("See you soon");
            
            }
        } catch (BusinessException e) {
            log.warn(e.getMessage());
        }
    }

}
