package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.dao.OrederDAO;
import com.main.shop.model.Cart;
import com.main.shop.model.Customer;
import com.main.shop.model.Product;
import com.shop.dbutil.Mysqlconnection;
import com.shop.exception.BusinessException;

public class OrderDAOImpl implements OrederDAO {
	private static final Logger log = Logger.getLogger(OrderDAOImpl.class);

	@Override
	public int addProductToOrder(Product product, Customer customer, Cart cart)
			throws BusinessException {
		int isSucessfull;
        try(Connection connection = Mysqlconnection.getConnection()) {
            String sql = "INSERT INTO order(orderCustomerId, orderQuantity, orderTotal) VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, customer.getCustomerId());
            
            preparedStatement.setInt(2, cart.getCartQuantity());
            preparedStatement.setDouble(3, cart.getCartTotal());
            

            isSucessfull = preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            log.warn(e);
            throw new BusinessException("Internal error occurred! contact systemAdmin");
        }
        return isSucessfull;
		
	}

}
