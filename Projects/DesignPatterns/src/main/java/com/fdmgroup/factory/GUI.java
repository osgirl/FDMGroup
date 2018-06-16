package com.fdmgroup.factory;

import java.util.Scanner;

public class GUI {
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a shape to draw: \n");
		String answer = scanner.nextLine();
		
		Shape shape = ShapeFactory.create(answer);
		shape.draw();
	}

}
