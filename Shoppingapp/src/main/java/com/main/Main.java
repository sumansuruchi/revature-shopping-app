package com.main;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.customer.dao.CustomerDao;
import com.customer.dao.impl.Customerdaoimpl;
import com.main.shop.model.Customer;
import com.main.shop.model.EmployeeLogin;
import com.main.shop.model.ProductCategory;
import com.repository.EmployeeRepository;
import com.repository.ProductCategoryRepository;
import com.service.EmployeeService;
import com.service.ProductCategorySearch;
import com.shop.exception.BusinessException;

public class Main {
	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		ProductCategoryRepository productCategoryRepository = new ProductCategorySearch();
		ProductCategoryPage productCategoryPage = new ProductCategoryPage();
		CustomerDao customerDao = new Customerdaoimpl();
		EmployeeLoginPage employeeLoginPage = new EmployeeLoginPage();
		EmployeeRepository employeeRepository = new EmployeeService();
		OrderPage orderPage = new OrderPage();
		Scanner scanner = new Scanner(System.in);
		log.info("Welcome to My Shopping app ");
		int ch = 0;
		do {
			log.info("Welcome to Main Menu ");
			log.info("1)Login as customer ");
			log.info("2)Login as Employee ");
			log.info("3)Register as customer ");
			log.info("4)exit ");
			log.info("5)Please enter your choice(1-4)");

			try {
				ch = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
			}
			switch (ch) {
			case 1:
				log.info("login as a customer");
				try {
					Customer customer = new Customer();
					log.info("Enter Customer username ");
					String customerUsername = scanner.nextLine();

					if (customerDao.isUserAlreadyExist(customerUsername)) {
						customer.setCustomerUsername(customerUsername);
						log.info("Enter password");
						String customerPassword = scanner.nextLine();
						if (customerDao.isPasswaordAlreadyExist(customerPassword)) {
							customer.setCustomerPassword(customerPassword);
						}
					}
					log.info("login sucessfull welcome  " + customerUsername);
					log.info("what you wanna do");
					int option = 0;
					do {

						log.info("1) All Category ");
						log.info("2) My order");
						log.info("3) My Cart ");
						log.info("4) Logout");
						log.info(" Please enter your choice(1-4)");

						try {
							option = Integer.parseInt(scanner.nextLine());
						} catch (NumberFormatException e) {
						}
						switch (option) {
						case 1:
							log.info(" All category ");

							List<ProductCategory> productCategoryList = productCategoryRepository.viewCategory();
							for (ProductCategory productCategory : productCategoryList) {
								log.info(productCategory.getProductCategoryId()+") " +productCategory.getProductCategoryName());
								
							}
							log.info("Enter your choice ");
							
							int productCategoryOption = Integer.parseInt(scanner.nextLine());

							productCategoryPage.productCategoryList(productCategoryOption);

							break;
						case 2:
							log.info("My order");
							
							
							
						
							
							break;
						case 3:
							log.info("Nice to meet you");
							break;
						case 4:
							log.info("logout");
							break;
						default:
							log.warn("Invalid choice... Choice should be only number between 1-4 only ");
							break;
						}
					} while (option != 4);

				} catch (BusinessException e) {
					log.warn(e.getMessage());
					log.info("\nReturning to Main Menu...");

				}

				break;
			case 2:
				log.info("Login as Employee");
				EmployeeLogin employee=new EmployeeLogin();
				log.info("Enter Employee UserName");
				String employeeUserName=scanner.nextLine();
				try {
					if(employeeRepository.isEmployeeAlreadyExist(employeeUserName))
					{
						employee.setEmployeeUserName(employeeUserName);
					}
					log.info("EnterPassword");
					String employeePassword = scanner.nextLine();
					if(employeeRepository.isPasswaordAlreadyExist(employeePassword))
					{
						employee.setEmployeePassword(employeePassword);
					}
					log.info("Enter your choice ");
					log.info("1) Add product ");
					log.info("2) Delete product");
					log.info("3) update customer status ");
					log.info("4) Logout");
					log.info(" Please enter your choice(1-4)");
					
					int employeeOption = Integer.parseInt(scanner.nextLine());
					employeeLoginPage.EmployeeOperation(employeeOption);
					
					
				} catch (BusinessException e1) {
					
					log.info(e1.getMessage());
				}
				
				break;
			case 3:
				log.info("Register Customer");
				try {
					Customer customer = new Customer();
					log.info("Enter Customer Details ");

					log.info("Enter Customer Name ");
					String customerName = scanner.nextLine();
					customer.setCustomerName(customerName);

					log.info("Enter Customer username ");
					String customerUsername = scanner.nextLine();
					if (!customerDao.isUserAlreadyExist(customerUsername) && customerUsername.matches("[a-z]{6,20}")) {

						customer.setCustomerUsername(customerUsername);

						log.info("Enter Customer password ");
						String customerPassword = scanner.nextLine();
						if (customerPassword.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()]).{8,20}$")) {
							customer.setCustomerPassword(customerPassword);
							int p = customerDao.registerCustomer(customer);
							if (p == 1) {
								log.info("Customer regestier successfully!!!");
								log.info("\nReturning to Main Menu...");
							}

						}
					}

				} catch (BusinessException e) {
					log.warn(e.getMessage());
					log.info("\nReturning to Main Menu...");
				}

				break;
			case 4:
				log.info("Nice to meet you");
				break;
			default:
				log.warn("Invalid choice... Choice should be only number between 1-4 only ");
				break;

			}

		} while (ch != 4);

	}

}
