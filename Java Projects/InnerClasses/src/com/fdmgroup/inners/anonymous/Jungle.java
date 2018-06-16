package com.fdmgroup.inners.anonymous;

public class Jungle {

	public Jungle() {

	}

	public static void main(String[] args) {

		Animal wildAnimal = new Animal() {
			@Override
			public void eat() {

				System.out.println("Wild Animal is eating ");
				sleep();

			}

			public void sleep() {
				System.out.println("Animal is sleeping");
			}

		};

		Barker otherAnimal = new Barker() {
			public void bark() {
				System.out.println("Animal barks");
			}

		};

		wildAnimal.eat();

		otherAnimal.bark();

	}

}



