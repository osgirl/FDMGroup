package com.fdmgroup.factory;

public class Sportbikes implements MotorCycle{
	int price = 40000;
	boolean newUsed = true;
	
	public void description(){
		System.out.println(this.toString());
		System.out.println("SportBikes: Better Known As 'Crotch Rockets', these bikes are finely tuned for high performance. TAKES TIME TO LEARN! \n");
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
			return "SportBikes Price: " + price + " (New)";
		}
		else 
			return "SportBikes Price: " + price + " (Used)";
	}
}
