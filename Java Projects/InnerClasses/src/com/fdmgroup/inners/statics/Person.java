package com.fdmgroup.inners.statics;

public class Person {

	private static String owner="Trainee 1";
	
	
	public void drive() {
		Car.drive("some person");
		
	}

	public static class Car {

		public static void drive(String name) {
			System.out.println(name + " is driving "
					+ owner+"'s car");

		}
		
	}

}
