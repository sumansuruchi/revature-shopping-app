package com.repository;

import com.main.shop.model.Product;
import com.shop.exception.BusinessException;

public interface ProductSearch {
	public Product searchProductByProductId(int productId) throws BusinessException;

}
