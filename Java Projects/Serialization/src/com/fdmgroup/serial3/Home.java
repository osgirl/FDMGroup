package com.fdmgroup.serial3;

import java.io.Serializable;

public class Home //implements Serializable
{
	private int number;
	
	Home(int n)
	{
		number = n;
	}
	
	public int getNumber()
	{
		return number;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}
	
	
}
