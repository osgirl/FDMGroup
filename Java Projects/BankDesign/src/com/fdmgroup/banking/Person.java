package com.fdmgroup.banking;

import java.math.*;

public class Person extends BankCustomer{
	
	/**
	 *	Person Default Constructor
	 */
	protected Person(){
		super();
	}
	
	/**
	 * Person Main Constructor
	 * @param name
	 * @param address
	 * @param tax
	 */
	protected Person(String name, String address, int tax) {
		super(name, address, tax);
	}
	
	/**
	 * Resets all the balances to BigDecimal.ZERO
	 */
	public void resetBalance(){
		int len = myAcc.size();
		if (len > 0){
			for (int i = 0; i < len; i++){
				myAcc.get(i).correction(BigDecimal.ZERO);
			}//end for loop
		}//end if length of myAccount ArrayList is greater than zero
	}
	
	/**
	 * Displays all the accounts owned by the given Person.
	 */
	public void printAccounts(){
		int len = myAcc.size();
		if (len > 0){
			for (int i = 0; i < len; i++){
				myAcc.get(i).toString();
			}//end for loop
		}//end if length of myAccount ArrayList is greater than zero
	}
}
