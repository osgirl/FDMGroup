package com.fdmgroup.banking;

import java.util.ArrayList;
import java.util.List;

/**
 * BankCustomer is an ABSTRACT CLASS that contains the general information contained within each Business/Personal use.
 */
public abstract class BankCustomer {
	List<BankAccount> myAcc;
	
	private int customerID;
	private String name;
	private String address;
	private int taxID;
	
	//creates an instance of SingleCusCounter counter which keeps track of the count for Customer ID.
	SingleCuscounter counter = SingleCuscounter.getInstance();
	
	/**
	 * BankAccount Default Constructor
	 */
	protected BankCustomer(){
		super();
		myAcc = new ArrayList<BankAccount>();
	}
	
	/**
	 * BankAccount Constructor
	 * @param name
	 * @param address
	 * @param tax
	 */
	protected BankCustomer(String name, String address, int tax){
		super();
		this.customerID = counter.getCount();
		this.name = name;
		this.address = address;
		this.taxID = tax;
		myAcc = new ArrayList<BankAccount>();
	}

	/**
	 * @return BankCustomer information in a specified format.
	 * @override parent toString()
	 */
	public String toString(){
		return "Customer: " + this.name  +" (" + this.customerID + ") at " + this.address + " (TaxID: " + this.taxID + ") @ " + super.toString();
	}
	
	/**
	 * @return customerID
	 */
	protected int getCustomerID(){
		return customerID;
	}
	
	/**
	 * @return name
	 */
	protected String getName(){
		return name;
	}
	
	/**
	 * @return address
	 */
	protected String getAddress(){
		return address;
	}
	
	/**
	 * @return taxID
	 */
	protected int getTaxID(){
		return taxID;
	}
	
	/**
	 * @param newID
	 */
	protected void setCustomerID(int newID){
		this.customerID = newID;
	}
	
	/**
	 * @param newName
	 */
	protected void setName(String newName){
		this.name = newName;
	}
	
	/**
	 * @param newAddress
	 */
	protected void setAddress(String newAddress){
		this.address = newAddress;
	}
	
	/**
	 * @param newID
	 */
	protected void setTaxID(int newID){
		this.taxID = newID;
	}
}
