package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.main.shop.model.Cart;
import com.main.shop.model.Product;
import com.service.CartService;
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
		try(Connection connection = Mysqlconnection.getConnection()) {
            String sql = "INSERT INTO cart(productId, customerId, productQuantity, productTotalPrice)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        } catch (ClassNotFoundException | SQLException e) {
            log.warn(e.getMessage());
            throw new BusinessException("Internal error occurred! contact systemAdmin");
        }
        return 0;
		
		
	}

}
