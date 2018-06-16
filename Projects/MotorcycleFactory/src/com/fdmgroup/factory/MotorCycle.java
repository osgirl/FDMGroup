package com.fdmgroup.factory;

public interface MotorCycle {
	int price = 50000;
	boolean newUsed = true;
	
	void description();
	int getPrice();
	void setPrice(int newPrice);
	boolean getNew();
	void setNew(boolean newState);
	String toString();
}
