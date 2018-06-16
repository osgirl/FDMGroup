package com.fdmgroup.toystore.exception;

import com.fdmgroup.toystore.Product;

public class InventoryLowException extends OutOfStockException{
	private static final long serialVersionUID = 3L;

	public InventoryLowException() {
		super("Product is unavailable due to low inventory!");
	}
	
	public InventoryLowException(Product product) {
		super("Product " + product.getName() + " is unavailable due to low inventory!");
	}
}
