package com.fdmgroup.factory;

public class MotorCycleTester {
	public static void main(String[] args){
		MotorCycleFactory myFactory = new MotorCycleFactory();
	
		MotorCycle model1 = myFactory.getNewMotor("Cruisers");
		model1.description();
		
		MotorCycle model2 = myFactory.getNewMotor("Sportbikes");
		model2.description();
		
		MotorCycle model3 = myFactory.getNewMotor("Touring");
		model3.description();
		
		MotorCycle model4 = myFactory.getNewMotor("Dualsport");
		model4.description();
		
		MotorCycle model5 = myFactory.getNewMotor("Standard");
		model5.description();
	}
}
