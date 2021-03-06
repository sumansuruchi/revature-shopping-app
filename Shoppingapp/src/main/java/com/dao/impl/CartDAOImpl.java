package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.dao.CartDAO;
import com.main.shop.model.Cart;
import com.main.shop.model.Product;
import com.shop.dbutil.Mysqlconnection;
import com.shop.exception.BusinessException;

public class CartDAOImpl  implements CartDAO{
	private static Logger log = Logger.getLogger(CartDAO.class);

	@Override
	public List<Cart> viewCart() throws BusinessException {
		List<Cart> cartList = new ArrayList<>();
        try(Connection connection = Mysqlconnection.getConnection()) {
            String sql = "SELECT cartId, cartProductID, cartCustomerId FORM cart";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Cart cart = new Cart();
                Product product = new Product();
                product.setProductId(resultSet.getInt(""));

            }
        } catch (ClassNotFoundException | SQLException e) {
            log.warn(e.getMessage());
            throw new BusinessException("Internal error occurred!");
        }
        return null;
		
		
	}

	@Override
	public int addProductToCart(Cart cart) throws BusinessException {
		int isuscessful=0;
		try(Connection connection = Mysqlconnection.getConnection()) {
            String sql = "INSERT INTO shopping_app.cart(cartProductId,cartQuantity, cartTotal) VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,cart.getProduct().getProductId());
            preparedStatement.setInt(2,cart.getCartQuantity());
            preparedStatement.setDouble(3,cart.getCartTotal());
             
            isuscessful=preparedStatement.executeUpdate();
            
            
        } catch (ClassNotFoundException | SQLException e) {
            log.warn(e.getMessage());
            
        }
        return isuscessful;
		
		
	}

}
