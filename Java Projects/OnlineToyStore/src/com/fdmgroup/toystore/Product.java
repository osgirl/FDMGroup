package com.fdmgroup.toystore;

import java.math.BigDecimal;

public class Product{
	private int toy_id;
	private String name;
	private String desc;
	private BigDecimal price;
	private boolean recalled;
	
	public Product(){}
	
	public Product(int toy_id, String name, String desc, double price, int recalled){
		super();
		BigDecimal value = new BigDecimal(price);
		
		this.toy_id = toy_id;
		this.name = name;
		this.desc = desc;
		this.price = value.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		if(recalled == 1){
			this.recalled = true;
		}
		else
			this.recalled = false;
	}
	
	public Product(int toy_id, String name, String desc, double price){
		super();
		BigDecimal value = new BigDecimal(price);
		
		this.toy_id = toy_id;
		this.name = name;
		this.desc = desc;
		this.price = value.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		this.recalled = false;
	}
	
	public int getToy_id() {
		return toy_id;
	}

	public void setToy_id(int toy_id) {
		this.toy_id = toy_id;
	}
	public String getName(){
		return name;
	}

	protected void setName(String name){
		this.name = name;
	}

	public String getDesc(){
		return desc;
	}

	protected void setDesc(String desc){
		this.desc = desc;
	}

	public BigDecimal getPrice(){
		return price;
	}

	protected void setPrice(BigDecimal price){
		this.price = price;
	}

	public boolean isRecalled(){
		return recalled;
	}

	protected void setRecalled(boolean recalled){
		this.recalled = recalled;
	}
}
