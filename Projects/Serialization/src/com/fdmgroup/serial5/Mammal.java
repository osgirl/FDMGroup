package com.fdmgroup.serial5;

import java.io.Serializable;

public class Mammal extends Animal implements Serializable
{
	private boolean land;
	private boolean sea;
	
	Mammal(boolean l, boolean s, String n)
	{
		/*see that even though I seem to call the super constructor,
		 * during deserialization, it actually uses the default super constructor.
		 * If I were to take away the default constructor, I would get an 
		 * InvalidClassException*/
		super(n); 
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
