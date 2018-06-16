package com.fdmgroup.toystore.DAOToJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fdmgroup.toystore.Product;
import com.fdmgroup.toystore.Stock;
import com.fdmgroup.toystore.ToyStoreLogger;

public class DAOToysJDBC implements DAO<Stock>{
	String url, username, password;
	Connection connection;
	
	public DAOToysJDBC(){
		url="jdbc:oracle:thin:@localhost:1521:XE";
		username="trainee1";
		password="!QAZSE4";
	}
	
	@Override
	public void create(Stock stock) {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			connection = DriverManager.getConnection(url,username,password);
			String query = "INSERT INTO toys (toy_id,toy_name,toy_desc,toy_price,toy_stock,is_recalled) " + "VALUES (?,?,?,?,?,?)";
			
			double doublePrice = stock.getProduct().getPrice().doubleValue();
			
			PreparedStatement statement = connection.prepareStatement(query);
	        statement.setInt(1, stock.getProduct().getToy_id());
	        statement.setString(2, stock.getProduct().getName());
	        statement.setString(3, stock.getProduct().getDesc());
	        statement.setDouble(4, doublePrice);
	        statement.setInt(5, stock.getStock());
	        if(stock.getProduct().isRecalled() == true){
	        	statement.setInt(6, 1);
	        }else
	        	statement.setInt(6, 0);
	        
	        statement.executeUpdate();
	        ToyStoreLogger.log.trace("You Product Has Been Added!");
		} catch (SQLException e) {
			ToyStoreLogger.log.trace("An error has occurred: " + e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				ToyStoreLogger.log.error("Could not close the connection. " + e);
			}
		}
	}
	
	@Override
	public Stock read(int id) {
		Stock tempStock = null;
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			connection = DriverManager.getConnection(url,username,password);
			Statement statement = connection.createStatement();
		    ResultSet rs = statement.executeQuery("SELECT * FROM toys");
		    while(rs.next()) {
		    	if(rs.getInt("toy_id") == id){
		    		Product tempProduct = new Product(rs.getInt("toy_id"),
			    			rs.getString("toy_name"),rs.getString("toy_desc"),
			    			rs.getDouble("toy_price"),rs.getInt("is_recalled"));
			    	tempStock = new Stock(tempProduct, rs.getInt("toy_stock"));
			    	
			    	ToyStoreLogger.log.trace("Product Was Read: " + rs.getInt("toy_id") + " " + 
			    			rs.getString("toy_name") + " " + rs.getString("toy_desc") + " " + 
			    			rs.getDouble("toy_price") + " " + rs.getInt("is_recalled") + "\n");
			    	return tempStock;
		    	}
		    }
		} catch (SQLException e) {
			ToyStoreLogger.log.trace("An error has occurred: " + e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				ToyStoreLogger.log.error("Could not close the connection. " + e);
			}
		}
		return tempStock;
	}
	
	@Override
	public void update(Stock stock) {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			connection = DriverManager.getConnection(url,username,password);
			Statement statement = connection.createStatement();
			
			double doublePrice = stock.getProduct().getPrice().doubleValue();
			int recalled = 0;
			if(stock.getProduct().isRecalled() == true){
	        	recalled = 1;
	        }
			
			String query = "UPDATE toys SET TOY_NAME='" + stock.getProduct().getName() + 
					"', TOY_DESC='" + stock.getProduct().getDesc() + "',TOY_PRICE=" + doublePrice +
					", TOY_STOCK=" + stock.getStock() + ", IS_RECALLED=" + recalled + 
					" WHERE TOY_ID=" + stock.getProduct().getToy_id();
			statement.executeUpdate(query);
			
	        ToyStoreLogger.log.trace("You Product Has Been Updated!");
		} catch (SQLException e) {
			ToyStoreLogger.log.trace("An error has occurred: " + e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				ToyStoreLogger.log.error("Could not close the connection. " + e);
			}
		}
	}

	@Override
	public void delete(Stock stock) {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			connection = DriverManager.getConnection(url,username,password);
			String query = "DELETE FROM toys WHERE toy_id=" + stock.getProduct().getToy_id();
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
	        ToyStoreLogger.log.trace("You Product Has Been Deleted!");
		} catch (SQLException e) {
			ToyStoreLogger.log.trace("An error has occurred: " + e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				ToyStoreLogger.log.error("Could not close the connection. " + e);
			}
		}
	}
}
