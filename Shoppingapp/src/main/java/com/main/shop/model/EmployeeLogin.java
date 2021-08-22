package com.main.shop.model;

public class EmployeeLogin {
	private String employeeUserName;
	private String employeePassword;
	public EmployeeLogin() {
		
	}
	public String getEmployeeUserName() {
		return employeeUserName;
	}
	public void setEmployeeUserName(String employeeUserName) {
		this.employeeUserName = employeeUserName;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	@Override
	public String toString() {
		return "EmployeeLogin [employeeUserName=" + employeeUserName + ", employeePassword=" + employeePassword + "]";
	}
	
	

}
