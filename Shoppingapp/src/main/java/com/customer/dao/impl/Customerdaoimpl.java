package com.customer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.customer.dao.CustomerDao;
import com.main.shop.model.Customer;
import com.shop.dbutil.Mysqlconnection;
import com.shop.exception.BusinessException;

public class Customerdaoimpl implements CustomerDao {
	 private static Logger log = Logger.getLogger(Customerdaoimpl.class);

	@Override
	public int registerCustomer(Customer customer) throws BusinessException {
		int successful;
		try (Connection connection = Mysqlconnection.getConnection()) {
			String sql = "insert into  customer(ct_username,ct_password) values (?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getCt_username());
			preparedStatement.setString(2, customer.getCt_password());

			successful = preparedStatement.executeUpdate();
			if (successful != 1) {
				throw new BusinessException("Customer- insertion failed! Check your query and try again!!!");
			}

		} catch (ClassNotFoundException | SQLException e) {

			// throw new BusinessException("Internal error occurred contact ");
			throw new BusinessException(e.getMessage());
		}
		return successful;
	}

	@Override
	public boolean isUserAlreadyExist(String ct_username) throws BusinessException {
		try(Connection connection=Mysqlconnection.getConnection()){
			String sql="select ct_username from customer where ct_username=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,ct_username);
			
			ResultSet resultset=preparedStatement.executeQuery();
			if(resultset.next()) {
				return true;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			log.warn(e);
		}
		
		
		
		return false;
	}

	@Override
	public boolean isPasswaordAlreadyExist(String ct_password) throws BusinessException {
		try(Connection connection=Mysqlconnection.getConnection()){
			String sql="select ct_password from customer where ct_password=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,ct_password);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			log.warn(e);
		}
	
		return false;
	}

}
