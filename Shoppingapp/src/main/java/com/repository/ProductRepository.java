package com.repository;

import java.util.List;

import com.main.shop.model.Product;
import com.shop.exception.BusinessException;

public interface ProductRepository {
	 public List<Product> viewProduct(int productCategory) throws BusinessException;

}
