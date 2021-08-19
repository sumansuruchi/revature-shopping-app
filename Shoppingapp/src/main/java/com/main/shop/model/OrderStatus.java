package com.main.shop.model;

public class OrderStatus {
	private int statusId;
    private String statusSts;
	public OrderStatus() {
		
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getStatusSts() {
		return statusSts;
	}
	public void setStatusSts(String statusSts) {
		this.statusSts = statusSts;
	}
	@Override
	public String toString() {
		return "OrderStatus [statusId=" + statusId + ", statusSts=" + statusSts + "]";
	}
	
    


}
