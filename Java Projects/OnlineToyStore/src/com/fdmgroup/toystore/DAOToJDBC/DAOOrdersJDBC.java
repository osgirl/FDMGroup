package com.fdmgroup.toystore.DAOToJDBC;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fdmgroup.toystore.Product;
import com.fdmgroup.toystore.OrderLine;
import com.fdmgroup.toystore.OrderLines;
import com.fdmgroup.toystore.ToyStoreLogger;

public class DAOOrdersJDBC implements DAO<OrderLines>{

	String url, username, password;
	Connection connection;
	
	public DAOOrdersJDBC(){
		url="jdbc:oracle:thin:@localhost:1521:XE";
		username="trainee1";
		password="!QAZSE4";
	}

	@Override
	public void create(OrderLines orderlines) {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			connection = DriverManager.getConnection(url,username,password);
			
			String query1 = "INSERT INTO orderline (ORDERLINE_ID,ORDER_ID,TOY_ID,ORDER_NUMBER,ORDER_PRICE) " + "VALUES (?,?,?,?,?)";
			String query2 = "INSERT INTO orders (ORDER_ID,ORDERLINE_ID) " + "VALUES (?,?)";
			for(int index = 0; index < orderlines.getOrderLines().size(); index++){
				BigDecimal orderlinePrice = orderlines.getOrderLines().get(index).getProduct().getPrice().multiply(new BigDecimal(orderlines.getOrderLines().get(index).getStock()));
				PreparedStatement statement1 = connection.prepareStatement(query1);
				statement1.setInt(1, orderlines.getOrderLines().get(index).getOrderline_id());
				statement1.setInt(2, orderlines.getOrderID());
				statement1.setInt(3, orderlines.getOrderLines().get(index).getProduct().getToy_id());
				statement1.setInt(4, orderlines.getOrderLines().get(index).getStock());
				statement1.setDouble(5, orderlinePrice.doubleValue());
				statement1.executeUpdate();
				
				PreparedStatement statement2 = connection.prepareStatement(query2);
				statement2.setInt(1, orderlines.getOrderID());
				statement2.setInt(2, orderlines.getOrderLines().get(index).getOrderline_id());
				statement2.executeUpdate();
			}
			ToyStoreLogger.log.trace("Your Orders with ID '" + orderlines.getOrderID() + "' Have Been Added!\n");
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
	public OrderLines read(int id) {
		OrderLines tempOrderLines = null;
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			connection = DriverManager.getConnection(url,username,password);
			Statement statement1 = connection.createStatement();
		    ResultSet rs = statement1.executeQuery("SELECT * FROM orderline WHERE order_id=" + id);
		    tempOrderLines = new OrderLines(id);
		    while(rs.next()){
		    	Connection connection2 = DriverManager.getConnection(url,username,password);
		    	Statement statement2 = connection2.createStatement();
		    	ResultSet rs2 = statement2.executeQuery("SELECT * FROM toys WHERE toy_id=" + id);
		    	while(rs2.next()){
		    		Product tempProduct = new Product(rs2.getInt("toy_id"),rs2.getString("toy_name"),rs2.getString("toy_desc"),rs2.getDouble("toy_price"));
		    		OrderLine tempOrderLine = new OrderLine(rs.getInt("orderline_id"),tempProduct,rs.getInt("order_number"));
		    		tempOrderLines.placeOrders(tempOrderLine);
		    		ToyStoreLogger.log.trace("Order Was Read: " + rs.getInt("orderline_id") + " " +
		    				tempProduct.getName() + "(id: " + tempProduct.getToy_id() + ") " + tempProduct.getDesc());
		    	}
		    }
		    ToyStoreLogger.log.trace("Orders with ID '" + id + "' have been read.\n");
		    return tempOrderLines;
		} catch (SQLException e) {
			ToyStoreLogger.log.trace("An error has occurred: " + e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				ToyStoreLogger.log.error("Could not close the connection. " + e);
			}
		}
		return tempOrderLines;
	}

	@Override
	public void update(OrderLines orderlines) {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			connection = DriverManager.getConnection(url,username,password);
			Statement statement = connection.createStatement();
			for(int index = 0; index < orderlines.getOrderLines().size(); index++){
				String query = "UPDATE orderline SET TOY_ID=" + orderlines.getOrderLines().get(index).getProduct().getToy_id() + 
						", ORDER_NUMBER=" + orderlines.getOrderLines().get(index).getStock() + 
						", ORDER_PRICE=" + orderlines.getOrderLines().get(index).getTotalPrice().doubleValue() + 
						" WHERE ORDERLINE_ID=" + orderlines.getOrderLines().get(index).getOrderline_id() + 
						" AND ORDER_ID=" + orderlines.getOrderID();
				statement.executeUpdate(query);
			}
	        ToyStoreLogger.log.trace("Your Orders with ID '" + orderlines.getOrderID() + "' Have Been Updated!\n");
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
	public void delete(OrderLines orderlines) {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			connection = DriverManager.getConnection(url,username,password);
			Statement statement = connection.createStatement();
			Statement statement2 = connection.createStatement();
			for(int index = 0; index < orderlines.getOrderLines().size(); index++){
				String query2 = "DELETE FROM orders WHERE orderline_id=" + orderlines.getOrderLines().get(index).getOrderline_id() + 
						" AND order_id=" + orderlines.getOrderID();
				statement2.executeUpdate(query2);
				
				String query1 = "DELETE FROM orderline WHERE orderline_id=" + orderlines.getOrderLines().get(index).getOrderline_id() + 
						" AND order_id=" + orderlines.getOrderID();
				statement.executeUpdate(query1);
			}
			ToyStoreLogger.log.trace("Your Orders with ID '" + orderlines.getOrderID() + "' Have Been Deleted!\n");
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
