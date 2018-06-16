package com.fdmgroup.banking;

/**
 * SingleCuscounter is a Singleton Class for keeping track of Customer ID's.
 */
public class SingleCuscounter {
	private static SingleCuscounter instance = null;
	private static int accounter = 1999993;
	
	/**
	 * Private Constructor; Needed For Singleton Classes
	 */
	private SingleCuscounter(){}
	
	/**
	 * Creates if instance is still null.
	 * @return instance
	 */
	public static SingleCuscounter getInstance(){
		if (instance == null){
			instance = new SingleCuscounter();
		}
		return instance;
	}
	
	/**
	 * Increments Counter and returns new Account ID
	 * @return accounter
	 */
	protected static int getCount(){
		accounter += 7;
		return accounter;
	}
}