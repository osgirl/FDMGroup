package com.fdmgroup.observer;

public interface Observable {
	
	public void attach(Observer o);
	public void detach(Observer o);
	public void notifyObservers();

}
