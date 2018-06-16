package com.fdmgroup.command;

public class BuyStockCommand implements Order{

	
	private StockTrade stock;
	
	public BuyStockCommand(StockTrade stock){
		this.stock = stock;
	}
	
	public void execute(){
		stock.buy();
	}
	
}
