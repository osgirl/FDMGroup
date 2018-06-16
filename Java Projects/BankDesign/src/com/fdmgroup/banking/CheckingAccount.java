package com.fdmgroup.banking;

import java.math.BigDecimal;

/**
 * CheckingAcc is an ABSTRACT CLASS that describes the functionality/ability of Checking Accounts.
 */
public abstract class CheckingAccount extends BankAccount{
	private int firstcheck;
	
	/**
	 * CheckingAcc Default Constructor
	 */
	protected CheckingAccount(){
		super();
		this.firstcheck = 101;
	}
	
	/**
	 * CheckingAcc Main Constructor
	 * @param amount
	 */
	protected CheckingAccount(BigDecimal amount) {
		super(amount);
		this.firstcheck = 101;
	}

	/**
	 * Returns the next expected check number.
	 * @return nextcheck
	 */
	protected int nextCheck(){
		int nextcheck = firstcheck + 1;
		return nextcheck;
	}
		
	/**
	 * @return firstcheck
	 */
	protected int getCheck(){
		return firstcheck;
	}
	
	/**
	 * @param newCheck
	 */
	protected void setCheck(int newCheck){
		this.firstcheck = newCheck;
	}
}
