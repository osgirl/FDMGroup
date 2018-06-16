package com.fdmgroup.banking;

import java.math.BigDecimal;

/**
 * PersonalChecking Class specifies the functionality/ability for Checking Accounts owned by Businesses.
 */
public class PersonalChecking extends CheckingAccount{
	private int personalID; 
	private boolean isChecking;
	private boolean isPersonal;
	
	/**
	 * PersonalChecking Default Constructor
	 */
	protected PersonalChecking(){
		super();
		this.isChecking = false;
		this.isPersonal = true;	
	}
	
	/**
	 * Personal Checking Single Constructor
	 * @param amount
	 */
	protected PersonalChecking(BigDecimal amount) {
		super(amount);
		this.isChecking = true;
		this.isPersonal = true;	
	}
	
	/**
	 * PersonalChecking Main Constructor
	 * @param amount
	 * @param personalID
	 */
	protected PersonalChecking(BigDecimal amount, int personalID) {
		super(amount);
		this.personalID = personalID;
		this.isChecking = true;
		this.isPersonal = true;	
	}
	
	/**
	 * @override parent toString()
	 */
	public String toString(){
		return "PC ACC ID: " + super.getAccID() + " HAS A BALANCE OF " + super.getAmount() + ", owned by " + this.personalID;
	}
	
	/**
	 * @return personalID
	 */
	public int getPersonalID(){
		return personalID;
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
		return isPersonal;  //true
	}
	
	/**
	 * @param newID
	 */
	public void setPersonalID(int newID){
		this.personalID = newID;
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
