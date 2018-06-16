package com.fdmgroup.inners.instance;

public class Cave {

	private String caveName;

	public Cave(String caveName) {
		this.caveName = caveName;
	}
	
	public Cave() {

	}

	public void checkCave() {
		Bear bear = new Bear();
		bear.killPerson();
		System.out.println(bear.bearName);
		

	}
	
	public class Bear {
		private String bearName = "Joe";

		public void killPerson() {

	
			System.out.println("Bear killed somebody in " + caveName);
		}

		public String getbearName() {
			return bearName;

		}
	}

}

