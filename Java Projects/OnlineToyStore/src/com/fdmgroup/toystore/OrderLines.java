package com.fdmgroup.toystore;
 
import java.util.List;
import java.util.ArrayList;

public class OrderLines{
	private int order_id;
	private List<OrderLine> orderLines;
	
	public OrderLines(int orderID){
		super();
		this.order_id = orderID;
		orderLines = new ArrayList<OrderLine>();
	}
	
	public void placeOrders(OrderLine...order){
		for(OrderLine orderline : order){
			orderLines.add(orderline);
		}
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(ArrayList<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public int getOrderID() {
		return order_id;
	}

	public void setOrderID(int orderID) {
		this.order_id = orderID;
	}
}
