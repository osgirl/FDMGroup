package com.fdmgroup.factoryMethod;

import java.util.Scanner;

public class GUI {
	
	public static void main(String[] args){		
		ShapeFactory factory = new SquareFactory();
		factory.create();		
		Shape shape = factory.create();
		shape.draw();
	}

}
