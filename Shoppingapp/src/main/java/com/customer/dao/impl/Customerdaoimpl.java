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
			String sql = "insert into  customer(customerName,customerUsername,customerPassword) values (?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getCustomerName());
			preparedStatement.setString(2, customer.getCustomerUsername());
			preparedStatement.setString(3, customer.getCustomerPassword());

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
	public boolean isUserAlreadyExist(String customerUsername) throws BusinessException {
		try(Connection connection=Mysqlconnection.getConnection()){
			String sql="select  customerUsername from  customer where customerUsername=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,customerUsername);
			
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
	public boolean isPasswaordAlreadyExist(String customerPassword) throws BusinessException {
		try(Connection connection=Mysqlconnection.getConnection()){
			String sql="select customerPassword from customer where customerPassword=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,customerPassword);
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
