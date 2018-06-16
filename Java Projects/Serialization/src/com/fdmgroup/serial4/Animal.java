package com.fdmgroup.serial4;

import java.io.Serializable;

/*Note that this version of Animal is serializable.*/

public class Animal  implements Serializable
{
	private String name;
	private transient int age;
	
	Animal(String n, int age)
	{
		name = n;
		this.age = age;
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
	
	public int getAge(){
		return age;
	}
	
}