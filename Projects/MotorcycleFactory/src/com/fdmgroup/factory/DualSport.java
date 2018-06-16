package com.fdmgroup.factory;

public class DualSport implements MotorCycle{
	int price = 45000;
	boolean newUsed = true;
	
	public void description(){
		System.out.println(this.toString());
		System.out.println("Dual-Sport: Commonly known as dirt-bikes and more than likely illegal to ride on common public roads. For natural or/and extreme terrain riders! \n");
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
			return "Dual-sport Bikes Price: " + price + " (New)";
		}
		else 
			return "Dual-sport Bikes Price: " + price + " (Used)";
	}
}
