package com.fdmgroup.command;

import java.util.LinkedList;
import java.util.Queue;

public class Agent {
	
	String DAY_OF_WEEK = "Sunday";
	
	Queue<Order> orders = new LinkedList<Order>();
	
	public void placeOrder(Order o){
		if(DAY_OF_WEEK.equals("Sunday")){
			orders.add(o);
		} else {
			o.execute();
		}
	}
	
	
	

}
