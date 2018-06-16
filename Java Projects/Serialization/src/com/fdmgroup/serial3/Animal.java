package com.fdmgroup.serial3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Animal implements Serializable
{
	private static final long serialVersionUID = -531630671112125842L;
	private String name;
	private transient Home home;
	
	Animal(String n, Home h)
	{
		name = n;
		home = h;
	}

	private void writeObject(ObjectOutputStream os)
	{
		try
		{
			os.defaultWriteObject();		//request JVM to do normal serialization process
			os.writeInt(home.getNumber()); //then, manually write the int that we will  
		}								   //need to recreate the Home object
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private void readObject(ObjectInputStream is)
	{
		try
		{
			is.defaultReadObject();		//do the normal deserialization process
			home = new Home(is.readInt());  //then, manually read the int that we 
		}								//will need to recreate the Home Object.  
		catch(IOException e)				//Then make a new home object
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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