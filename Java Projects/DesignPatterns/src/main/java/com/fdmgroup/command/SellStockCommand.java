package com.fdmgroup.command;

public class SellStockCommand implements Order{

	private StockTrade stock;
	
	public SellStockCommand(StockTrade stock){
		this.stock = stock;
	}
	
	public void execute(){
		stock.sell();
	}
	
}
