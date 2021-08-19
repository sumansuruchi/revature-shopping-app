package com.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.dao.ProductDAO;
import com.dao.impl.ProductDAOImpl;
import com.main.ProductCategoryPage;
import com.main.shop.model.Product;
import com.repository.ProductRepository;
import com.shop.exception.BusinessException;

public class ProductService implements ProductRepository  {
	private static Logger log = Logger.getLogger(ProductCategoryPage.class);
	ProductDAO productDAO = new ProductDAOImpl();

	@Override
	public List<Product> viewProduct(int productCategory) throws BusinessException {
		List<Product> products;
		
        products=productDAO.viewProduct(productCategory);
		
        
        return products;
		
		
		
	}



}
