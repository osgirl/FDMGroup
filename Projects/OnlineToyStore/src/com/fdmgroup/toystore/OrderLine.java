package com.fdmgroup.toystore;

import java.math.BigDecimal;

public class OrderLine{
	private int orderline_id;
	private Product product;
	private int stock;
	private BigDecimal totalPrice;
	
	public OrderLine(int orderline_id, Product product, int stock){
		super();
		
		this.orderline_id = orderline_id;
		this.product = product;
		this.stock = stock;
		this.setTotalPrice(product.getPrice().multiply(new BigDecimal(stock)));
	}
	
	public int getOrderline_id() {
		return orderline_id;
	}

	public void setOrderline_id(int orderline_id) {
		this.orderline_id = orderline_id;
	}
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product){
		this.product = product;
	}

	public int getStock(){
		return stock;
	}

	public void setStock(int stock){
		this.stock = stock;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
}
