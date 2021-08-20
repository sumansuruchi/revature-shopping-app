package com.dao;

import java.util.List;

import com.main.shop.model.Product;
import com.main.shop.model.ProductCategory;
import com.shop.exception.BusinessException;

public interface ProductSearchDAO {
	public List<ProductCategory> viewCategory() throws BusinessException;
	public Product searchProductByProductId(int productId) throws BusinessException;
	

}
