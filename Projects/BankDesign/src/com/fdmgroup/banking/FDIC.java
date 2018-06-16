package com.fdmgroup.banking;

import java.math.*;

/**
 * FDIC is the Main Class which tests the Bank Design Project. 
 */
public class FDIC {
	/**
	 * Executes the dummy objects and tests methods found within the Bank Class.
	 * @param args
	 */
	public static void main(String[] args){
		//Create a new Bank
		Bank citibank = new Bank();
		
		//Create dummy data for testing w/ creation methods
		citibank.createPersonThenChecking("Johnny Sun", "32 Hollings Drive", 26819, BigDecimalCreator(10000));
		citibank.createPersonThenSaving("Steven Phillips", "55 Brooklyn Road", 10001, BigDecimalCreator(324646));
		citibank.createBusinessThenChecking("Brandon Harper", "2 Maine Street", 26819, BigDecimalCreator(767586));
		citibank.createBusinessThenSaving("Tommy Lee", "48 Mainland Street", 10001, BigDecimalCreator(967867));
		citibank.createCheckingThenPerson("Lovelace Ada", "873 Darling Avenue", 26819, BigDecimalCreator(8664545));
		citibank.createSavingThenPerson("Sarah Williams Jr.", "464 Lake Bonnet", 10001, BigDecimalCreator(546564));
		citibank.createCheckingThenBusiness("Elaine Livingston", "123 Jameson Road", 26819, BigDecimalCreator(546456));
		citibank.createSavingThenBusiness("Holiday Hollway", "55 Holiday Drive", 10001, BigDecimalCreator(564564));
		
		//Test methods found in Bank Class
		citibank.addCheckingToCurrentPerson(2000000, BigDecimalCreator(1000000));
		citibank.withdrawing(2000000, 1000, BigDecimalCreator(1000));
		citibank.showAllCustomers();
		citibank.showAllCustomerAccounts(2000000);
		citibank.deleteAccFromCustomer(2000000, 1000);
		citibank.removeAllCustomerByID(2000000);
		citibank.customerResetBalance(2000007);  //should work; execute and output
		citibank.customerResetBalance(20000014); //should not work; execute but not output due to being a business
		citibank.depositing(2000007, 1005, BigDecimalCreator(54321));
		citibank.correcting(2000007, 1005, BigDecimalCreator(324646));
		citibank.payday(2000014, BigDecimalCreator(2000));
	}
	
	/**
	 * @param newNum as an Integer Primitive Type
	 * @return the value passed via parameter as a BigDecimal Type
	 */
	public static BigDecimal BigDecimalCreator(int newNum){
		BigDecimal result = new BigDecimal(newNum);
		return result;
	}
}
