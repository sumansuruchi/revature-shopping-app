package com.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.main.shop.model.Product;
import com.main.shop.model.ProductCategory;
import com.repository.EmployeeRepository;
import com.service.EmployeeService;
import com.shop.exception.BusinessException;

public class EmployeeLoginPage {
	private static Logger log = Logger.getLogger(EmployeeLoginPage.class);
	Scanner scanner = new Scanner(System.in);
	EmployeeRepository employeeRepository = new EmployeeService();

	public void EmployeeOperation(int employeeOption) {

		switch (employeeOption) {
		case 1:
			log.info("Add product to ProductList");

			Product product = new Product();
			log.info("Enter product Detail One by One");
			log.info("Enter ProductName");
			product.setProductName(scanner.nextLine());
			log.info("Enter Product Price");
			product.setProductPrice(Double.parseDouble(scanner.nextLine()));
			ProductCategory productCategory = new ProductCategory();
			int categoryMenuOption;
			log.info(" Enter Product Category");
			log.info("1)Electronics");
			log.info("2)mobile");
			log.info("3)Grocery");
			log.info("4)Furniture");
			categoryMenuOption = Integer.parseInt(scanner.nextLine());

			switch (categoryMenuOption) {
			case 1:
				productCategory.setProductCategoryId(1);
				productCategory.setProductCategoryName("Electronics");
				break;
			case 2:
				productCategory.setProductCategoryId(2);
				productCategory.setProductCategoryName("Mobiles");
				break;
			case 3:
				productCategory.setProductCategoryId(1);
				productCategory.setProductCategoryName("Grocery");
				break;
			case 4:
				productCategory.setProductCategoryId(1);
				productCategory.setProductCategoryName("Furniture");
				break;
			default:
				log.info("Not valid choice");
				break;
			}

			product.setProductCategory(productCategory);
			int isSucessfull;
			try {
				isSucessfull = employeeRepository.addProductByEmployee(product);
				if (isSucessfull == 1) {
	                log.info("Added  successfully!!!");
	            }

			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
			break;
		case 2:
			log.info("B");
			break;
		case 3:
			log.info("C");
			break;
		case 4:
			log.info("D");
			break;

		default:
			log.info("Not Valid Choice");
		}

	}

}
