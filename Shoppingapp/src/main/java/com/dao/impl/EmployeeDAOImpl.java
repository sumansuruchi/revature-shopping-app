package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.dao.EmployeeDAO;
import com.main.ProductCategoryPage;
import com.main.shop.model.Product;
import com.shop.dbutil.Mysqlconnection;
import com.shop.exception.BusinessException;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static Logger log = Logger.getLogger(EmployeeDAOImpl.class);

	@Override
	public int addProductByEmployee(Product product) throws BusinessException {
		int isSuccessfull=0;
		try(Connection connection = Mysqlconnection.getConnection()) {
            String sql = "INSERT INTO products(productName,productPrice,productCategoryId) VALUES(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setDouble(2, product.getProductPrice());
            
            preparedStatement.setInt(3, product.getProductCategory().getProductCategoryId());

            isSuccessfull = preparedStatement.executeUpdate();
            if (isSuccessfull != 1) {
                throw new BusinessException(" insertion failed! Check your query and try again!!!");
            }

        } catch (ClassNotFoundException | SQLException e) {
            log.warn(e.getMessage());
            throw new BusinessException("Internal error occurred contact ");
        }
        return isSuccessfull;
    }


	

}
