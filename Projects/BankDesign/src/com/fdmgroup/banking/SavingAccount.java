package com.fdmgroup.banking;

import java.math.BigDecimal;

/**
 * SavingAcc is an ABSTRACT CLASS that describes the functionality/ability of Saving Accounts.
 */
public abstract class SavingAccount extends BankAccount{
	private float interestrate;
	
	/**
	 * SavingAcc Default Constructor
	 */
	protected SavingAccount(){
		super();
		interestrate = 0;
	}
	
	/**
	 * SavingAcc Main Constructor
	 * @param amount
	 */
	protected SavingAccount(BigDecimal amount) {
		super(amount);
		interestrate = 0;
	}
	
	/**
	 * Check to see if there is enough funds to allow withdrawal. 
	 * @param subtractAmt
	 */
	protected void withdraw(BigDecimal subtractAmt){
		if((getAmount().compareTo(subtractAmt) == 1) || (getAmount().compareTo(subtractAmt) == 0)){
			getAmount().subtract(subtractAmt);
		}
	}
	
	/**
	 * @return interestrate
	 */
	protected float getInterestRate(){
		return interestrate;
	}

	/**
	 * @param newRate
	 */
	protected void setInterestRate(float newRate){
		this.interestrate = newRate;
	}
}
