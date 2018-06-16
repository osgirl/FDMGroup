package com.fdmgroup.inners.instance;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Cave cave = new Cave("Bear Cave");
		cave.checkCave();
		
		Cave.Bear bear = new Cave().new Bear();
//		
		Cave.Bear bear2 = cave.new Bear();
		


		
		

	}

}
