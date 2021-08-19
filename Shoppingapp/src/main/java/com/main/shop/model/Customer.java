package com.main.shop.model;

public class Customer {
	private int customerId;
	private String customerName;
	private String customerUsername;
	private String customerPassword;
	public Customer() {
		
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerUsername() {
		return customerUsername;
	}
	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerUsername="
				+ customerUsername + ", customerPassword=" + customerPassword + "]";
	}
	
	
	
	
	

}
