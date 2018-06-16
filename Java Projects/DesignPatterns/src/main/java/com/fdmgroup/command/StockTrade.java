package com.fdmgroup.command;

public class StockTrade {
	
	private String company;
	private int amount;
	
	public void buy(){
		System.out.println("Bought stock in " + company);
	}
	
	public void sell(){
		System.out.println("Sold stock in " + company);
	}
	
	
	
	
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	


}
