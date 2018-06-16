package com.fdmgroup.serial4;

import java.io.Serializable;

public class Mammal extends Animal implements Serializable
{
	private boolean land;
	private boolean sea;
	
	Mammal(boolean l, boolean s, String n)
	{
		super(n,4); 
		land = l; 
		sea = s;
	}
	
	public boolean isLand()
	{
		return land;
	}

	public void setLand(boolean land)
	{
		this.land = land;
	}

	public boolean isSea()
	{
		return sea;
	}

	public void setSea(boolean sea)
	{
		this.sea = sea;
	}

	
	
	
}
