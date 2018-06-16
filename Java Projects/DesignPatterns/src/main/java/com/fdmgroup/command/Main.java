package com.fdmgroup.command;

public class Main {
	
	public static void main(String[] args){
		StockTrade stock = new StockTrade();
		StockTrade stock2 = new StockTrade();
		
		BuyStockCommand bsc = new BuyStockCommand(stock);
		SellStockCommand ssc = new SellStockCommand(stock2);
		
		Agent agent = new Agent();
		agent.placeOrder(bsc);
		agent.placeOrder(ssc);
	}

}
