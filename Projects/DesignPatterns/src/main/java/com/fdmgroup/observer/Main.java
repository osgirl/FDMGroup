package com.fdmgroup.observer;

public class Main {
	
	public static void main(String[] args){
		Loan loan = new Loan();
		loan.setType("Personal Loan");
		loan.setInterest(17);
		loan.setBank("Lloyds");
		
		Newspaper newspaper = new Newspaper();
		Radio radio = new Radio();
		loan.attach(newspaper);
		loan.attach(radio);
		
		loan.setInterest(15);
	}

}
