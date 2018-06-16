package com.fdmgroup.factoryMethod;

public class SquareFactory implements ShapeFactory {

	public Shape create() {
		return new Square();
	}

}
