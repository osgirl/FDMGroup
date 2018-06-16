package com.fdmgroup.factory;

public class Cruisers implements MotorCycle{
	int price = 2500;
	boolean newUsed = false;
	
	public void description(){
		System.out.println(this.toString());
		System.out.println("Cruisers: These bikes have lower seat heights and a more laid-back riding position. They often have large engines (though not always), but are not made for racing or super-high performance situations. \n");
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
			return "Cruiser Bike Price: " + price + " (New)";
		}
		else 
			return "Cruiser Bike Price: " + price + " (Used)";
	}
}
