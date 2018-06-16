package com.fdmgroup.banking;

import java.math.*;

/**
 * BankAccount is an ABSTRACT CLASS that contains the general information contained within each Banking/Checking Accounts regardless of Business/Personal use.
 */
public abstract class BankAccount {
	private final int accIDNum;
	private BigDecimal balance;
	
	SingleAccounter counter = SingleAccounter.getInstance();
	
	/**
	 * BankAccount Default Constructor
	 */
	protected BankAccount(){
		super();
		this.accIDNum = 0;
		this.balance = BigDecimal.ZERO;
	}
	
	/**
	 * BankAccount Main Constructor
	 * @param amount
	 */
	protected BankAccount(BigDecimal amount){
		super();
		this.accIDNum = counter.getCount();
		this.balance = amount;
	}

	/**
	 * Adds a vale of BigDecimal Type to BigDecimal Variable balance. 
	 * @param (BigDecimal addAmt)
	 */
	protected void deposit(BigDecimal addAmt){
		this.balance = this.balance.add(addAmt);
	}
	
	/**
	 * Subtracts a value of BigDecimal Type to BigDecimal Variable balance.
	 * @param (BigDecimal subtractAmt)
	 */
	protected void withdraw(BigDecimal subtractAmt){
		this.balance = this.balance.subtract(subtractAmt);
	}
	
	/**
	 * Overwrites/Replaces the value of BigDecimal Variable balance with BigDecimal value newAmt.
	 * @param (BigDecimal newAmt)
	 */
	protected void correction(BigDecimal newAmt){
		this.balance = newAmt;
	}
	
	/**
	 * Overwrites the Object Class toString method to the specifications below.
	 * @return A String which specifies the Account ID, Balance and Object.toString().
	 */
	public String toString(){
		return "ACC ID: " + accIDNum + " HAS A BALANCE OF " + balance + " @ " + super.toString();
	}
	
	/**
	 * @return Account ID Number (Primitive Type: int)
	 */
	protected int getAccID(){
		return accIDNum;
	}
	
	/**
	 * @return Balance On Account (Primitive Type: BigDecimal)
	 */
	protected BigDecimal getAmount(){
		return balance;
	}
	
	/**
	 * Like correction(BigDecimal newAmt), Overwrites/Replaces the value of balance with newAmt.
	 * @param (BigDecimal newAmt)
	 */
	protected void setAmt(BigDecimal newAmt){
		this.balance = newAmt;
	}
}
