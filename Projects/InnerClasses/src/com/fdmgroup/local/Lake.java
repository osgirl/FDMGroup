package com.fdmgroup.local;

public class Lake {
	private String size = "5 miles";
	
	public Lake() {

	}

	public void goFishing(Person p) {
		final Person person = p;
		
		System.out.println(person + " is fishing");

		class Fish {
			public void fight(Person p) {
				System.out.println("Fish is fighting " + person
						+ " in a lake that is " + size + " wide");
			}
		}
		
		class Goldfish extends Fish{
			@Override
			public void fight(Person p){
				System.out.println("Flushed down the toilet");
			}
		}
		

		Fish fish = new Fish();

		fish.fight(person);
		
		Fish goldfish = new Goldfish();
		goldfish.fight(person);
	

	}

	}

