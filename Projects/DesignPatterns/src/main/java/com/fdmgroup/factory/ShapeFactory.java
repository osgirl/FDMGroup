package com.fdmgroup.factory;

public class ShapeFactory {
	
	public static Shape create(String type){
		if(type.equals("triangle")){
			return new Triangle();
		} else if(type.equals("square")){	
			return new Square();
		}
		
		return null;
	}

}
