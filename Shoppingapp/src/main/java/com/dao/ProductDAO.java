package com.dao;

import java.util.List;

import com.main.shop.model.Product;
import com.shop.exception.BusinessException;

public interface ProductDAO {
	 public List<Product> viewProduct(int productCategory) throws BusinessException;

}
