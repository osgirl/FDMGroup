package com.fdmgroup.observer;

public class Radio implements Observer {

	public void update(float interest) {
		System.out.println("Radio broadcasting the new interest rate of " + interest);
		
	}

}
