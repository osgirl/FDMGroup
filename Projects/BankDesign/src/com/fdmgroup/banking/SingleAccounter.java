package com.fdmgroup.banking;

/**
 * SingleAccounter is a Singleton Class for keeping track of Accounting ID's.
 */
public class SingleAccounter {
	private static SingleAccounter instance = null;
	private static int accounter = 995;
	
	/**
	 * Private Constructor; Needed For Singleton Classes
	 */
	private SingleAccounter(){}
	
	/**
	 * Creates if instance is still null.
	 * @return instance
	 */
	public static SingleAccounter getInstance(){
		if (instance == null){
			instance = new SingleAccounter();
		}
		return instance;
	}
	
	/**
	 * Increments Counter and returns new Account ID
	 * @return accounter
	 */
	protected static int getCount(){
		accounter += 5;
		return accounter;
	}
}