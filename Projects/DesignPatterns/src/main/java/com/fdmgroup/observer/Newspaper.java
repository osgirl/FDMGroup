package com.fdmgroup.observer;

public class Newspaper implements Observer{

	public void update(float interest) {
		System.out.println("Newspaper printing the new interest rate of " + interest);
	}

}
