package com.fdmgroup.serial1;

import java.io.Serializable;

public class Animal implements Serializable{
	private static final long serialVersionUID = -531630671112125842L;
	private String name;
	
	Animal(String n){
		name = n;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}
}
