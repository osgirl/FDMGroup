package com.fdmgroup.serial5;

import java.io.Serializable;

/* Note that this version of Animal is NOT serializable. 
 * It is also the superclass of Mammal, which IS serializable.*/

public class Animal // implements Serializable
{
	private String name;
	
	
	Animal(String n)
	{
		name = n;
	}

	Animal()
	{
		name = "unassigned";
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
}