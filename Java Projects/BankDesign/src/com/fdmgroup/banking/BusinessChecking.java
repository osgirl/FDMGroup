package com.fdmgroup.banking;

import java.math.BigDecimal;

/**
 * The BusinessChecking Class specifies the functionality/ability for Checking Accounts owned by Businesses.
 */
public class BusinessChecking extends CheckingAccount{
	private int companyID; 
	private boolean isChecking;
	private boolean isPersonal;
	
	/**
	 * Default Constructor
	 */
	protected BusinessChecking(){
		super();
		this.isChecking = true;
		this.isPersonal = false;
	}
	
	/**
	 * Single Parameter Constructor; account without an owner.
	 * @param amount
	 */
	protected BusinessChecking(BigDecimal amount) {
		super(amount);
		this.isChecking = true;
		this.isPersonal = false;
	}
	
	/**
	 * Two Parameter Constructor; account with an owner.
	 * @param amount
	 * @param companyID
	 */
	protected BusinessChecking(BigDecimal amount, int companyID) {
		super(amount);
		this.companyID = companyID;
		this.isChecking = true;
		this.isPersonal = false;
	}
	
	/**
	 * @override parent toString() method.
	 */
	public String toString(){
		return "BC ACC ID: " + super.getAccID() + " HAS A BALANCE OF " + super.getAmount() + ", owned by " + this.companyID;
	}
	
	/**
	 * @return companyID
	 */
	public int getCompanyID(){
		return companyID;
	}
	
	/**
	 * @return isChecking
	 */
	public boolean getTypeAccount(){
		return isChecking;  //true
	}
	
	/**
	 * @return isPersonal
	 */
	public boolean getTypePersonal(){
		return isPersonal;  //false
	}
	
	/**
	 * @param newID
	 */
	public void setBusinessID(int newID){
		this.companyID = newID;
	}
	
	/**
	 * @param newTF
	 */
	public void setTypeAccount(boolean newTF){
		this.isChecking = newTF;
	}

	/**
	 * @param newTF
	 */
	public void setTypePersonal(boolean newTF){
		this.isPersonal = newTF;
	}
}
