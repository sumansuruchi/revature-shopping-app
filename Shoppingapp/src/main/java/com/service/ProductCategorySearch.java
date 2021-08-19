package com.service;
import java.util.List;

import com.dao.ProductSearchDAO;
import com.dao.impl.ProductSearchDAOImpl;
import com.main.shop.model.ProductCategory;
import com.repository.ProductCategoryRepository;
import com.shop.exception.BusinessException;

public class ProductCategorySearch  implements ProductCategoryRepository{
	ProductSearchDAO productSearchDao=new ProductSearchDAOImpl();

	@Override
	public List<ProductCategory> viewCategory() throws BusinessException {
		List<ProductCategory> productCategoriesList=null;
		
		productCategoriesList = productSearchDao.viewCategory();
		
		
	
		return productCategoriesList;
	}

}
