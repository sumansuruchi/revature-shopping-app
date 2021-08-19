package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.dao.ProductDAO;
import com.main.ProductCategoryPage;
import com.main.shop.model.Product;
import com.main.shop.model.ProductCategory;
import com.shop.dbutil.Mysqlconnection;
import com.shop.exception.BusinessException;

public class ProductDAOImpl  implements  ProductDAO{
	private static Logger log = Logger.getLogger(ProductDAOImpl.class);

	@Override
	public List<Product> viewProduct(int productCategory) throws BusinessException {
		List<Product> productList = new ArrayList<>();
        try(Connection connection = Mysqlconnection.getConnection()) {
            String sql = "SELECT pr.productId, pr.productName, pr.productPrice, pc.productCategoryId, pc.productCategoryName FROM products pr JOIN productcategory pc ON pr.productCategoryId = pc.productCategoryId WHERE pr.productCategoryId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, productCategory);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                ProductCategory productCategoryObj = new ProductCategory();
                product.setProductId(resultSet.getInt("productId"));
                product.setProductName(resultSet.getString("productName"));
                product.setProductPrice(resultSet.getDouble("productPrice"));
                productCategoryObj.setProductCategoryId(resultSet.getInt("productCategoryId"));
                productCategoryObj.setProductCategoryName(resultSet.getString("productCategoryName"));
                product.setProductCategory(productCategoryObj);
                productList.add(product);
            }
        } catch (ClassNotFoundException | SQLException e) {
            log.warn(e);
            throw new BusinessException("Internal error occurred! contact systemAdmin");
        }
        return productList;
		
		
		

		
		
	}

}
