package com.fdmgroup.serial2;

import java.io.Serializable;

public class Home // implements Serializable
{
	private static final long	serialVersionUID	= 1L;
	
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
