package com.fdmgroup.factory;

public class Standard implements MotorCycle{
	int price = 15000;
	boolean newUsed = false;
	
	public void description(){
		System.out.println(this.toString());
		System.out.println("Standard: A combination of different bike's; Cruiser, Sportbikes, Touring and Dual-Sport bikes'. The Mutts of MotorCycles! \n");
	}
	
	public int getPrice(){
		return price;
	}
	
	public void setPrice(int newPrice){
		this.price = newPrice;
	}
	
	public boolean getNew(){
		return newUsed;
	}
	
	public void setNew(boolean newState){
		this.newUsed = newState;
	}
	
	public String toString(){
		if(newUsed == true){
			return "Standard Bike Price: " + price + " (New)";
		}
		else 
			return "Standard Bike Price: " + price + " (Used)";
	}
}
