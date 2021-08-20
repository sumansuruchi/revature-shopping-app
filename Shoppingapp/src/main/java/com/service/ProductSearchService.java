package com.service;

import com.dao.ProductSearchDAO;
import com.dao.impl.ProductSearchDAOImpl;
import com.main.shop.model.Product;
import com.repository.ProductSearch;
import com.shop.exception.BusinessException;

public class ProductSearchService implements ProductSearch {
	ProductSearchDAO productDAO = new ProductSearchDAOImpl();

	@Override
	public Product searchProductByProductId(int productId) throws BusinessException {
		Product product=null;
		product=productDAO.searchProductByProductId(productId);
		return product;
	}

}
