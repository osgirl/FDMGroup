package observerPattern;

import java.util.*;

public class Guest implements Observer{
	int temp_id ;
	Random myGen = new Random();
	
	public Guest(){
		super();
		temp_id = myGen.nextInt(1000);
	}
	
	public void notification(){
		System.out.println("You've got updates; bout time you signed upn no?");
	}
}
