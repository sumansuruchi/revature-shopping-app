package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.dao.ProductSearchDAO;
import com.main.shop.model.Product;
import com.main.shop.model.ProductCategory;
import com.shop.dbutil.Mysqlconnection;
import com.shop.exception.BusinessException;

public class ProductSearchDAOImpl  implements ProductSearchDAO{
	private static Logger log = Logger.getLogger(ProductSearchDAOImpl.class);
	@Override
	public List<ProductCategory> viewCategory() throws BusinessException {
		List<ProductCategory> productCategoriesList = new ArrayList();
		try(Connection connection = Mysqlconnection.getConnection()){
			String sql="select productCategoryId,productCategoryName from productCategory";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				ProductCategory productCategory = new ProductCategory();
				productCategory.setProductCategoryId(resultSet.getInt("productCategoryId"));
				productCategory.setProductCategoryName(resultSet.getString("productCategoryName"));
				
				productCategoriesList.add(productCategory);
			}
			
			
		} catch (ClassNotFoundException  |SQLException e) {
			// TODO Auto-generated catch block
		log.warn(e.getMessage());
		throw new BusinessException("internal error occur please contact");
		} 
		
		
		
		return productCategoriesList;
	}
	
	    @Override
	    public Product searchProductByProductId(int productId) throws BusinessException {
	        Product product = new Product();
	        try(Connection connection = Mysqlconnection.getConnection()) {
	            String sql = "SELECT pr.productId, pr.productName, pr.productPrice, pc.productCategoryId, pc.productCategoryName FROM shopping_app.products pr JOIN shopping_app.productcategory pc ON pr.productCategoryId = pc.productCategoryId WHERE pr.productId =?;";
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setInt(1, productId);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            if (resultSet.next()) {
	                ProductCategory productCategoryObj = new ProductCategory();
	                product.setProductId(resultSet.getInt("productId"));
	                product.setProductName(resultSet.getString("productName"));
	                product.setProductPrice(resultSet.getDouble("productPrice"));
	                productCategoryObj.setProductCategoryId(resultSet.getInt("productCategoryId"));
	                productCategoryObj.setProductCategoryName(resultSet.getString("productCategoryName"));
	                product.setProductCategory(productCategoryObj);
	            }
	        } catch (ClassNotFoundException | SQLException e) {
	            log.warn(e);
	            throw new BusinessException("Internal error occurred! contact systemAdmin");
	        }
	        return product;
	    

		
	}
	

}
