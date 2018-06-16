package com.fdmgroup.toystore.DAOToJDBC;

import com.fdmgroup.toystore.Product;
import com.fdmgroup.toystore.Stock;
import com.fdmgroup.toystore.OrderLine;
import com.fdmgroup.toystore.OrderLines;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOTest {
	public static void main(String[] args){
		// TEST JDBC FOR TOYS
		DAOToysJDBC testToysJDBC = new DAOToysJDBC();
		
		Product tempProduct1 = new Product(10,"Barbie","Male Version",11.99);
		Stock tempStock1 = new Stock(tempProduct1,15);
		testToysJDBC.create(tempStock1);
		
		testToysJDBC.read(10);
		
		Product tempProduct2 = new Product(10,"Barbie","Male Version",22.99);
		Stock tempStock2 = new Stock(tempProduct2,15);
		testToysJDBC.update(tempStock2);
		
		testToysJDBC.delete(tempStock2);
		
		// TEST JDBC FOR ORDERS
		DAOOrdersJDBC testOrdersJDBC = new DAOOrdersJDBC();
		
		Product tempProduct4 = new Product(1,"Buzz Lightyear","Infinity And Beyond",19.99);
		Product tempProduct5 = new Product(2,"Sheriff Woody","Howdy Partner",19.99);
		OrderLine tempOrderline1 = new OrderLine(1,tempProduct4,10);
		OrderLine tempOrderline2 = new OrderLine(2,tempProduct5,8);
		OrderLines tempOrderlines1 = new OrderLines(1);
		tempOrderlines1.placeOrders(tempOrderline1, tempOrderline2);
		testOrdersJDBC.create(tempOrderlines1);
		
		testOrdersJDBC.read(1);
		
		Product tempProduct6 = new Product(1,"Buzz Lightyear","Infinity And Beyond",15.99);
		Product tempProduct7 = new Product(2,"Sheriff Woody","Howdy Partner",13.99);
		OrderLine tempOrderline3 = new OrderLine(1,tempProduct6,20);
		OrderLine tempOrderline4 = new OrderLine(2,tempProduct7,16);
		OrderLines tempOrderlines2 = new OrderLines(1);
		tempOrderlines2.placeOrders(tempOrderline3, tempOrderline4);
		testOrdersJDBC.update(tempOrderlines2);
	
		OrderLines tempOrderlines3 = new OrderLines(1);
		tempOrderlines3.placeOrders(tempOrderline3);
		testOrdersJDBC.delete(tempOrderlines2);
		
		// TEST JPA FOR TOYS
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("DAOToysJPA"); 
		DAOToysJPA testToysJPA = new DAOToysJPA(emf);
				
		Product tempProduct3 = new Product(11,"Dora Explorer","Child Version", 13.99);
		Stock tempStock3 = new Stock(tempProduct3,25);
		testToysJPA.create(tempStock3);		
	}
}
