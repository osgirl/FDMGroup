package com.fdmgroup.observer;

import java.util.ArrayList;
import java.util.List;

public class Loan implements Observable{
	
	private String type;
	private float interest;
	private String bank;
	
	
	List<Observer> observers = new ArrayList<Observer>();

	public void attach(Observer o) {
		observers.add(o);		
	}

	public void detach(Observer o) {
		observers.remove(o);
		
	}

	public void notifyObservers() {
		for(Observer o : observers){
			o.update(interest);
		}
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getInterest() {
		return interest;
	}

	public void setInterest(float interest) {
		this.interest = interest;
		notifyObservers();
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public List<Observer> getObservers() {
		return observers;
	}

	public void setObservers(List<Observer> observers) {
		this.observers = observers;
	}

}
