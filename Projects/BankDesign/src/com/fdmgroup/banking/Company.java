package com.fdmgroup.banking;

import java.math.*;

/**
 * The Company Class specifies the functionality/ability for Businesses/Companies.
 */
public class Company extends BankCustomer{
	
	/**
	 * Company Default Constructor
	 */
	protected Company(){
		super();
	}
	
	/**
	 * Company Main Constructor
	 * @param name
	 * @param address
	 * @param tax
	 */
	protected Company(String name, String address, int tax) {
		super(name, address, tax);
	}
	
	/**
	 * Adds the given amount to all accounts owned by the given company.
	 * @param addAmt
	 */
	public void addAll(BigDecimal addAmt){
		int len = myAcc.size();
		if (len > 0){
			for (int i = 0; i < len; i++){
				myAcc.get(i).deposit(addAmt);
			}
		}
	}
	
	/**
	 * Displays all accounts owned by the given company.
	 */
	public void printAccounts(){
		int len = myAcc.size();
		if (len > 0){
			for (int i = 0; i < len; i++){
				myAcc.get(i).toString();
			}
		}
	}
}
