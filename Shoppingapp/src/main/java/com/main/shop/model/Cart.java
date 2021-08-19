package com.main.shop.model;

public class Cart {
	private Customer customer;
	private Product product;
	private int cartQuantity;
	private double cartTotal;
	
	public Cart() {
		
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCartQuantity() {
		return cartQuantity;
	}

	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}

	public double getCartTotal() {
		return cartTotal;
	}

	public void setCartTotal(double cartTotal) {
		this.cartTotal = cartTotal;
	}

	@Override
	public String toString() {
		return "Cart [customer=" + customer + ", product=" + product + ", cartQuantity=" + cartQuantity + ", cartTotal="
				+ cartTotal + "]";
	}
	
	

}
