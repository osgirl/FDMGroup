package com.fdmgroup.toystore.exception;

import com.fdmgroup.toystore.Product;

public class ProductRecallException extends OutOfStockException{
	private static final long serialVersionUID = 2L;
	
	public ProductRecallException() {
		super("Product has been recalled!");
	}
	
	public ProductRecallException(Product product) {
		super("Product " + product.getName() + " has been recalled!");
	}
}
