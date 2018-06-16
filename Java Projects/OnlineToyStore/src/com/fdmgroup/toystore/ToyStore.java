package com.fdmgroup.toystore;

import java.util.List;
import java.util.ArrayList;

import com.fdmgroup.toystore.exception.InventoryLowException;
import com.fdmgroup.toystore.exception.OutOfStockException;
import com.fdmgroup.toystore.exception.ProductRecallException;

public class ToyStore{
	private List<Stock> inventory;
	
	public ToyStore(){
		setInventory(new ArrayList<Stock>());
	}
	
	public void addStockToInventory(Stock newStock){
		if(getInventory().isEmpty()){
			getInventory().add(newStock);
		}
		else{
			for(int index = 0; index < getInventory().size(); index++){
				if(getInventory().get(index).getProduct().getName().equals(newStock.getProduct().getName())){
					int result = getInventory().get(index).getStock() + newStock.getStock();
					getInventory().get(index).setStock(result);
				}
			}
			
			int check = 0;
			for(int index = 0; index < getInventory().size(); index++){
				if(!(getInventory().get(index).getProduct().getName().equals(newStock.getProduct().getName()))){
					check++;
					if(check >= getInventory().size()){
						getInventory().add(newStock);
					}
				}
			}
		}
	}
	
	protected void executeOrders(OrderLines orderLines) throws OutOfStockException, ProductRecallException, InventoryLowException{
		if(orderLines != null){
			for(int numberOrder = 0; numberOrder < orderLines.getOrderLines().size(); numberOrder++){
				for(int index = 0; index < getInventory().size(); index++){
					if(orderLines.getOrderLines().get(numberOrder).getProduct().getName() == getInventory().get(index).getProduct().getName()){
						if(getInventory().get(index).getProduct().isRecalled() == true){
							String message = "Product " + getInventory().get(index).getProduct().getName() + " CANNOT BE ORDERED DUE TO RECALL!";
							ToyStoreLogger.log.error(message);
							throw new ProductRecallException();
						}
						else if(getInventory().get(index).getStock() == 0){
							String message = "Product " + getInventory().get(index).getProduct().getName() + " IS OUT OF STOCK; REORDER!";
							ToyStoreLogger.log.error(message);
							throw new OutOfStockException();
						}
						else if(orderLines.getOrderLines().get(numberOrder).getStock() > getInventory().get(index).getStock()){
							String message = "Product " + getInventory().get(index).getProduct().getName() + " COULD NOT BE ORDERED DUE TO LOW STOCK; REORDER!";
							ToyStoreLogger.log.error(message);
							throw new InventoryLowException();
						}
						else{
							int newAmount = getInventory().get(index).getStock() - orderLines.getOrderLines().get(numberOrder).getStock();
							getInventory().get(index).setStock(newAmount);
							String message = "Product " + getInventory().get(index).getProduct().getName() + "(" + orderLines.getOrderLines().get(numberOrder).getStock() + ") Has Been Ordered!";
							ToyStoreLogger.log.trace(message);
						}
					}
				}
			}	
		}
	}

	public List<Stock> getInventory() {
		return inventory;
	}

	public void setInventory(List<Stock> inventory) {
		this.inventory = inventory;
	}
}
