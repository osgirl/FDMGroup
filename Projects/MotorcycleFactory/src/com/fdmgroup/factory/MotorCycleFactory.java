package com.fdmgroup.factory;

public class MotorCycleFactory {
	public MotorCycle getNewMotor(String motorType){
		if(motorType == null){
			return null;
		}
		
		if(motorType.equalsIgnoreCase("CRUISERS")){
			return new Cruisers();
		}
		else if(motorType.equalsIgnoreCase("SPORTBIKES")){
			return new Sportbikes();
		}
		else if(motorType.equalsIgnoreCase("TOURING")){
			return new Touring();
		}
		else if(motorType.equalsIgnoreCase("DUALSPORT")){
			return new DualSport();
		}
		else if(motorType.equalsIgnoreCase("STANDARD")){
			return new Standard();
		}
		return null;
	}
}