package com.fdmgroup.toystore;

import java.math.BigDecimal;
import javax.persistence.*;

@Entity
@Table(name="toys")
public class Stock{
	@Transient
	private Product product;
	@Id
	@Column (name="toy_id")
	private int productID;

	@Column (name="toy_name")
	private String productName;
	@Column (name="toy_desc")
	private String productDesc;
	@Column (name="toy_price")
	private BigDecimal productPrice;
	@Column (name="is_recalled")
	private boolean productRecalled;
	@Column (name="toy_stock")
	private int stock;

	public Stock(){
		this.product = new Product();
	}
	
	public Stock(Product product, int stock){
		super();
		this.product = product;
		this.stock = stock;
		this.productID = this.product.getToy_id();
		this.setProductName(this.product.getName());
		this.setProductDesc(this.product.getDesc());
		this.setProductPrice(this.product.getPrice());
		this.setProductRecalled(this.product.isRecalled());
	}

	public String toString(){
		return product.getToy_id() + " | " + product.getName() + "(" + String.valueOf(stock) + "), " + product.getPrice() + " each."; 
	}
	
	public int getStock(){
		return stock;
	}

	protected void setStock(int stock){
		this.stock = stock;
	}

	public Product getProduct(){
		return product;
	}

	protected void setProduct(Product product){
		this.product = product;
	}
	

	protected int getProductID() {
		return productID;
	}

	protected void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public boolean isProductRecalled() {
		return productRecalled;
	}

	public void setProductRecalled(boolean productRecalled) {
		this.productRecalled = productRecalled;
	}
}
