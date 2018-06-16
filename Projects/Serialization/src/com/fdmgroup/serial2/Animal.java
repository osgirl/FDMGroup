package com.fdmgroup.serial2;

import java.io.Serializable;

public class Animal implements Serializable
{
	private static final long serialVersionUID = -531630671112125842L;
	private String name;
	private Home home;
	
	Animal(String n, Home h)
	{
		name = n;
		home = h;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Home getHome()
	{
		return home;
	}

	public void setHome(Home home)
	{
		this.home = home;
	}
	
	
	
	
}