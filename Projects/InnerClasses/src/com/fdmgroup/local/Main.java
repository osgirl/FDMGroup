package com.fdmgroup.local;

public class Main {

	public Main() {
	}

	public static void main(String[] args) {
		Lake lake = new Lake();
		Person person=new Person("Erik");
		lake.goFishing(person);

	}

}
