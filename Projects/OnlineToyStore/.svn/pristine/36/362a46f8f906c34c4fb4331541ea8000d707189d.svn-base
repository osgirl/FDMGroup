package com.fdmgroup.toystore.exception;

import com.fdmgroup.toystore.Product;

public class OutOfStockException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public OutOfStockException() {
		super("Product is out of stock!");
	}
	
	public OutOfStockException(String message) {
		super(message);
	}
	
	public OutOfStockException(Product product) {
		super("Product " + product.getName() + " is out of stock!");
	}
}
