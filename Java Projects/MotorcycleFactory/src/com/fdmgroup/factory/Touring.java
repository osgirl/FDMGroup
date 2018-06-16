package com.fdmgroup.factory;

public class Touring implements MotorCycle{
	int price = 10000;
	boolean newUsed = false;
	
	public void description(){
		System.out.println(this.toString());
		System.out.println("Touring: Touring motorcycles come in a wide range of shapes and sizes, but their purpose is always the same: long-distance travel. \n");
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
			return "Touring Bikes Price: " + price + " (New)";
		}
		else 
			return "Touring Bikes Price: " + price + " (Used)";
	}
}
