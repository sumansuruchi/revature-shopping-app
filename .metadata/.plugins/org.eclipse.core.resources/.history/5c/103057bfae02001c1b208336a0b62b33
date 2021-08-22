package com.main;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.main.shop.model.Product;
import com.repository.ProductRepository;
import com.service.ProductService;
import com.shop.exception.BusinessException;

public class ProductCategoryPage {
	private static Logger log = Logger.getLogger(ProductCategoryPage.class);
	ProductRepository productCategoryRepository = new ProductService();
	
	CartPage cartPage = new CartPage();

	Scanner scanner = new Scanner(System.in);

	public void productCategoryList(int productCategoryOption) {

		do{
		
		switch (productCategoryOption)

		{
		case 1:
			log.info("Electronics");

			int electronicsProductId = 0;
			try {
				List<Product> productList = productCategoryRepository.viewProduct(1);
				if (productList != null) {
					for (Product product : productList) {
						log.info(" " + product.getProductId() + ". " + product.getProductName());
					}
				}
				log.info("Enter your choice...");
				 electronicsProductId = Integer.parseInt(scanner.nextLine());
				 log.info("enter your quantity");
				 int electronicProductQuantity =Integer.parseInt(scanner.nextLine());
				cartPage.addProductToCard(electronicProductQuantity,  electronicsProductId);
			} catch (BusinessException | NumberFormatException e) {
				log.warn(e.getMessage());
			}
			
			

			break;
		case 2:
			log.info("Mobile");
			int mobileProductId = 0;
			try {
				List<Product> productList = productCategoryRepository.viewProduct(2);
				if (productList != null) {
					for (Product product : productList) {
						log.info(" " + product.getProductId() + ". " + product.getProductName());
					}
				}
				log.info("Enter your choice...");
				 mobileProductId = Integer.parseInt(scanner.nextLine());
				 log.info("enter your quantity");
				 int mobileProductQuantity =Integer.parseInt(scanner.nextLine());
				cartPage.addProductToCard(mobileProductQuantity,  mobileProductId);

				

			} catch (BusinessException | NumberFormatException e) {
				log.warn(e.getMessage());
			}

			break;
		case 3:
			log.info("Grocery");
			int groceryProductId = 0;
			try {
				List<Product> productList = productCategoryRepository.viewProduct(3);
				if (productList != null) {
					for (Product product : productList) {
						log.info(" " + product.getProductId() + ". " + product.getProductName());
					}
				}
				log.info("Enter your choice...");
				 groceryProductId = Integer.parseInt(scanner.nextLine());
				 log.info("enter your quantity");
				 int groceryProductQuantity =Integer.parseInt(scanner.nextLine());
				cartPage.addProductToCard(groceryProductQuantity,  groceryProductId);
				

			} catch (BusinessException | NumberFormatException e) {
				log.warn(e.getMessage());
			}
			break;
		case 4:
			log.info("Furniture");
			int furnitureProductId = 0;
			try {
				List<Product> productList = productCategoryRepository.viewProduct(4);
				if (productList != null) {
					for (Product product : productList) {
						log.info(" " + product.getProductId() + ". " + product.getProductName());
					}
				}
				log.info("Enter your choice...");
				 furnitureProductId = Integer.parseInt(scanner.nextLine());
				 log.info("enter your quantity");
				 int furnitureProductQuantity =Integer.parseInt(scanner.nextLine());
				cartPage.addProductToCard(furnitureProductQuantity,  furnitureProductId);
				

			} catch (BusinessException | NumberFormatException e) {
				log.warn(e.getMessage());
			}
			break;
		default:

			log.info("Not valid choice");

		}
		}while(productCategoryOption!=4);

	}

}
