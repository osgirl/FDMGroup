package com.fdmgroup.banking;

import java.math.BigDecimal;

/**
 * PersonalSaving Class specifies the functionality/ability for Saving Accounts owned by Businesses.
 */
public class PersonalSaving extends SavingAccount{
	private int personalID; 
	private boolean isChecking;
	private boolean isPersonal;
	
	/**
	 * PersonalSaving Default Constructor
	 */
	protected PersonalSaving(){
		super();
		this.isChecking = false;
		this.isPersonal = true;	
	}
	
	/**
	 * PersonalSaving Single Constructor
	 * @param amount
	 */
	protected PersonalSaving(BigDecimal amount) {
		super(amount);
		this.isChecking = false;
		this.isPersonal = true;	
	}
	
	/**
	 * PersonalSaving Double Constructor
	 * @param amount
	 * @param personalID
	 */
	protected PersonalSaving(BigDecimal amount, int personalID) {
		super(amount);
		this.personalID = personalID;
		this.isChecking = false;
		this.isPersonal = true;	
	}

	/**
	 * @override parent toString()
	 */
	public String toString(){
		return "PS ACC ID: " + super.getAccID() + " HAS A BALANCE OF " + super.getAmount() + ", owned by " + this.personalID;
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
		return isChecking;  //false
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
