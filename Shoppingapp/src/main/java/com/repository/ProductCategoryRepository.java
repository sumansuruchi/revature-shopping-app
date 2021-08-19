package com.repository;

import java.util.List;

import com.main.shop.model.ProductCategory;
import com.shop.exception.BusinessException;

public interface ProductCategoryRepository {
	public List<ProductCategory> viewCategory() throws BusinessException;

}
