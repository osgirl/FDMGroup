package com.fdmgroup.banking;

import java.math.*;
import java.util.List;
import java.util.ArrayList;

/**
 * The Bank Account Class is in charge of keeping track of all the customers within each bank and accounts without an owner.
 * The methods contained are used within the main class to perform desired functionality between BankAccounts and BankCustomers.
 */
public class Bank {
	List<BankCustomer> myCustomer;
	List<BankAccount> accountWithoutCustomer;
	
	/**
	 * Bank Constructor
	 */
	public Bank(){
		super();
		myCustomer = new ArrayList<BankCustomer>();
		accountWithoutCustomer = new ArrayList<BankAccount>();
	}
	
	/**
	 * Creates a Personal Checking Accounts w/ provided parameters values. 
	 * @param name
	 * @param address
	 * @param taxID
	 * @param balance
	 */
	public void createPersonThenChecking(String name, String address, int taxID, BigDecimal balance){
		Person tempPerson = new Person(name, address, taxID);
		myCustomer.add(tempPerson);
		System.out.println(tempPerson);
		PersonalChecking tempChecking = new PersonalChecking(balance, tempPerson.getCustomerID());
		tempPerson.myAcc.add(tempChecking);
		System.out.println(tempChecking);
		System.out.println();
	}
	
	/**
	 * Creates a Personal Savings Accounts w/ provided parameters values. 
	 * @param name
	 * @param address
	 * @param taxID
	 * @param balance
	 */
	public void createPersonThenSaving(String name, String address, int taxID, BigDecimal balance){
		Person tempPerson = new Person(name, address, taxID);
		myCustomer.add(tempPerson);
		System.out.println(tempPerson);
		PersonalSaving tempSaving = new PersonalSaving(balance, tempPerson.getCustomerID());
		tempPerson.myAcc.add(tempSaving);
		System.out.println(tempSaving);
		System.out.println();
	}
	
	/**
	 * Creates a Company Checking Accounts w/ provided parameters values. 
	 * @param name
	 * @param address
	 * @param taxID
	 * @param balance
	 */
	public void createBusinessThenChecking(String name, String address, int taxID, BigDecimal balance){
		Company tempBusiness = new Company(name, address, taxID);
		myCustomer.add(tempBusiness);
		System.out.println(tempBusiness);
		BusinessChecking tempChecking = new BusinessChecking(balance, tempBusiness.getCustomerID());
		tempBusiness.myAcc.add(tempChecking);
		System.out.println(tempChecking);
		System.out.println();
	}
	
	/**
	 * Creates a Business Checking Accounts w/ provided parameters values. 
	 * @param name
	 * @param address
	 * @param taxID
	 * @param balance
	 */
	public void createBusinessThenSaving(String name, String address, int taxID, BigDecimal balance){
		Company tempBusiness = new Company(name, address, taxID);
		myCustomer.add(tempBusiness);
		System.out.println(tempBusiness);
		BusinessSaving tempSaving = new BusinessSaving(balance, tempBusiness.getCustomerID());
		tempBusiness.myAcc.add(tempSaving);
		System.out.println(tempSaving);
		System.out.println();
	}
	
	/**
	 * Creates an Account and populates into ArrayList of accountsWithoutCustomers, then assigns to a customer and removes from accountsWithoutCustomers. 
	 * @param name
	 * @param address
	 * @param taxID
	 * @param balance
	 */
	public void createCheckingThenPerson(String name, String address, int taxID, BigDecimal balance){
		PersonalChecking tempChecking = new PersonalChecking(balance);
		accountWithoutCustomer.add(tempChecking);
		System.out.println(tempChecking);
		Person tempPerson = new Person(name, address, taxID);
		PersonalChecking holder = new PersonalChecking();
		holder = (PersonalChecking) accountWithoutCustomer.get(0);
		holder.setPersonalID(tempPerson.getCustomerID());
		accountWithoutCustomer.remove(0);
		tempPerson.myAcc.add(holder);
		myCustomer.add(tempPerson);
		System.out.println(tempPerson);
		System.out.println(holder);
		System.out.println();
	}
	
	/**
	 * Creates an Account and populates into ArrayList of accountsWithoutCustomers, then assigns to a customer and removes from accountsWithoutCustomers. 
	 * @param name
	 * @param address
	 * @param taxID
	 * @param balance
	 */
	public void createSavingThenPerson(String name, String address, int taxID, BigDecimal balance){
		PersonalSaving tempSaving = new PersonalSaving(balance);
		accountWithoutCustomer.add(tempSaving);
		System.out.println(tempSaving);
		Person tempPerson = new Person(name, address, taxID);
		PersonalSaving holder = new PersonalSaving();
		holder = (PersonalSaving) accountWithoutCustomer.get(0);
		holder.setPersonalID(tempPerson.getCustomerID());
		accountWithoutCustomer.remove(0);
		tempPerson.myAcc.add(holder);
		myCustomer.add(tempPerson);
		System.out.println(tempPerson);
		System.out.println(holder);
		System.out.println();
	}
	
	/**
	 * Creates an Account and populates into ArrayList of accountsWithoutCustomers, then assigns to a customer and removes from accountsWithoutCustomers. 
	 * @param name
	 * @param address
	 * @param taxID
	 * @param balance
	 */
	public void createCheckingThenBusiness(String name, String address, int taxID, BigDecimal balance){
		BusinessChecking tempChecking = new BusinessChecking(balance);
		accountWithoutCustomer.add(tempChecking);
		System.out.println(tempChecking);
		Company tempCompany = new Company(name, address, taxID);
		BusinessChecking holder = new BusinessChecking();
		holder = (BusinessChecking) accountWithoutCustomer.get(0);
		holder.setBusinessID(tempCompany.getCustomerID());
		accountWithoutCustomer.remove(0);
		tempCompany.myAcc.add(holder);
		myCustomer.add(tempCompany);
		System.out.println(tempCompany);
		System.out.println(holder);
		System.out.println();
	}
	
	/**
	 * Creates an Account and populates into ArrayList of accountsWithoutCustomers, then assigns to a customer and removes from accountsWithoutCustomers. 
	 * @param name
	 * @param address
	 * @param taxID
	 * @param balance
	 */
	public void createSavingThenBusiness(String name, String address, int taxID, BigDecimal balance){
		BusinessSaving tempChecking = new BusinessSaving(balance);
		accountWithoutCustomer.add(tempChecking);
		System.out.println(tempChecking);
		Company tempCompany = new Company(name, address, taxID);
		BusinessSaving holder = new BusinessSaving();
		holder = (BusinessSaving) accountWithoutCustomer.get(0);
		holder.setBusinessID(tempCompany.getCustomerID());
		accountWithoutCustomer.remove(0);
		tempCompany.myAcc.add(holder);
		myCustomer.add(tempCompany);
		System.out.println(tempCompany);
		System.out.println(holder);
		System.out.println();
	}
	
	/**
	 * Adds a Personal Checking Account with a Balance to a particular Customer ID.
	 * @param customerID
	 * @param balance
	 */
	public void addCheckingToCurrentPerson(int customerID, BigDecimal balance){
		PersonalChecking tempChecking = new PersonalChecking(balance);
		for(BankCustomer customerIn : myCustomer){
			if(customerIn.getCustomerID() == customerID){
				tempChecking.setPersonalID(customerID);
				customerIn.myAcc.add(tempChecking);
				System.out.println(customerIn + "\n" +  tempChecking);
			}
		}
		System.out.println();
	}
	
	/**
	 * Adds a Personal Saving Account with a Balance to a particular Customer ID.
	 * @param customerID
	 * @param balance
	 */
	public void addSavingToCurrentPerson(int customerID, BigDecimal balance){
		PersonalSaving tempSaving = new PersonalSaving(balance);
		for(BankCustomer customerIn : myCustomer){
			if(customerIn.getCustomerID() == customerID){
				tempSaving.setPersonalID(customerID);
				customerIn.myAcc.add(tempSaving);
				System.out.println(customerIn + "\n" +  tempSaving);
			}
		}
		System.out.println();
	}

	/**
	 * Adds a Company Checking Account with a Balance to a particular Customer ID.
	 * @param customerID
	 * @param balance
	 */
	public void addCheckingToCurrentBusiness(int customerID, BigDecimal balance){
		BusinessChecking tempChecking = new BusinessChecking(balance);
		for(BankCustomer customerIn : myCustomer){
			if(customerIn.getCustomerID() == customerID){
				tempChecking.setBusinessID(customerID);
				customerIn.myAcc.add(tempChecking);
				System.out.println(customerIn + "\n" + tempChecking);
			}
		}
		System.out.println();
	}
	

	/**
	 * Adds a Company Savings Account with a Balance to a particular Customer ID.
	 * @param customerID
	 * @param balance
	 */
	public void addSavingToCurrentBusiness(int customerID, BigDecimal balance){
		BusinessSaving tempSaving = new BusinessSaving(balance);
		for(BankCustomer customerIn : myCustomer){
			if(customerIn.getCustomerID() == customerID){
				tempSaving.setBusinessID(customerID);
				customerIn.myAcc.add(tempSaving);
				System.out.println(customerIn + "\n" + tempSaving);
			}
		}
		System.out.println();
	}
	
	/**
	 * Removes all customers with the given Customer ID.
	 * @param customerID
	 */
	public void removeAllCustomerByID(int customerID){
		for(int i = 0; i < myCustomer.size(); i++){
			if(myCustomer.get(i).getCustomerID() == customerID){
				myCustomer.remove(i);
			}
		}
		showAllCustomers();
	}
	
	/**
	 * Displays a list of all the customers within ArrayList myCustomer.
	 */
	public void showAllCustomers(){
		System.out.println("========= ALL CUSTOMERS =========");
		for(BankCustomer customer : myCustomer){
			System.out.println(customer);
		}
		System.out.println();
	}
	
	/**
	 * Displays a list of accounts underneath the specified Customer ID.
	 * @param customerID
	 */
	public void showAllCustomerAccounts(int customerID){
		System.out.println("========= ALL ACCOUNTS WITH CUSTOMER ID " + customerID + " =========");
		for(BankCustomer customerACC : myCustomer){
			if(customerACC.getCustomerID() == customerID ){
				for(BankAccount customerAccount : customerACC.myAcc){
					System.out.println(customerAccount);
				}
			}
		}
		System.out.println();
	}
	
	/**
	 * Removes a particular account underneath the given Customer ID.
	 * @param customerID
	 * @param accountID
	 */
	public void deleteAccFromCustomer(int customerID, int accountID){
		for(BankCustomer chkCus : myCustomer){
			if(chkCus.getCustomerID() == customerID){
				for(int i = 0; i < chkCus.myAcc.size(); i++){
					if(chkCus.myAcc.get(i).getAccID() == accountID){
						chkCus.myAcc.remove(i);
					}
				}
			}
		}
		showAllCustomerAccounts(customerID);
	}
	
	/**
	 * Withdraws the given amount from an account underneath a specific Customer ID.
	 * @param customerID
	 * @param accountID
	 * @param balance
	 */
	public void withdrawing(int customerID, int accountID ,BigDecimal balance){
		for(BankCustomer cCus : myCustomer){
			if(cCus.getCustomerID() == customerID){
				for(BankAccount aCus : cCus.myAcc){
					if(aCus.getAccID() == accountID){
						System.out.println("Old amount on " + accountID + ": " + aCus.getAmount());
						aCus.withdraw(balance);
						System.out.println("New amount on " + accountID + ": " + aCus.getAmount());
					}
				}
			}
		}
		System.out.println();
	}
	
	/**
	 * Deposits the given amount from an account underneath a specific Customer ID.
	 * @param customerID
	 * @param accountID
	 * @param balance
	 */
	public void depositing(int customerID, int accountID ,BigDecimal balance){
		for(BankCustomer cCus : myCustomer){
			if(cCus.getCustomerID() == customerID){
				for(BankAccount aCus : cCus.myAcc){
					if(aCus.getAccID() == accountID){
						System.out.println("Old amount on " + accountID + ": " + aCus.getAmount());
						aCus.deposit(balance);
						System.out.println("New amount on " + accountID + ": " + aCus.getAmount());
					}
				}
			}
		}
		System.out.println();
	}
	
	/**
	 * Correcting the balance at an account underneath a specific Customer ID.
	 * @param customerID
	 * @param accountID
	 * @param balance
	 */
	public void correcting(int customerID, int accountID ,BigDecimal balance){
		for(BankCustomer cCus : myCustomer){
			if(cCus.getCustomerID() == customerID){
				for(BankAccount aCus : cCus.myAcc){
					if(aCus.getAccID() == accountID){
						System.out.println("Old amount on " + accountID + ": " + aCus.getAmount());
						aCus.correction(balance);
						System.out.println("New amount on " + accountID + ": " + aCus.getAmount());
					}
				}
			}
		}
		System.out.println();
	}
	
	/**
	 * Resets the balance of all accounts underneath a specific Customer ID to BigDecimal ZERO; Personal Only.
	 * @param customerID
	 */
	public void customerResetBalance(int customerID){
		for(BankCustomer getResetCustomer : myCustomer){
			if((getResetCustomer.getCustomerID() == customerID) && (getResetCustomer instanceof Person)){
				for(BankAccount setResetCustomer : getResetCustomer.myAcc){
					setResetCustomer.setAmt(BigDecimal.ZERO);
					System.out.println("ACC with ID " + setResetCustomer.getAccID() + " updated balance is " + setResetCustomer.getAmount());
				}
			}
		}
		System.out.println();
	}
	
	/**
	 * Adds an particular amount to all accounts underneath a specific Customer ID; Business Only.
	 * @param customerID
	 * @param balance
	 */
	public void payday(int customerID, BigDecimal balance){
		for(BankCustomer boss : myCustomer){
			if((boss.getCustomerID() == customerID) && (boss instanceof Company)){
				for(BankAccount paylist : boss.myAcc){
					paylist.deposit(balance);
					System.out.println(balance + " was added to all Accounts under Customer ID of " + customerID + ".");
				}
			}
		}
		System.out.println();
	}
}//end main
