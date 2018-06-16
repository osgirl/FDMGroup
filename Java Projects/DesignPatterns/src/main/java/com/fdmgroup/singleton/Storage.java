package com.fdmgroup.singleton;

import java.util.ArrayList;
import java.util.List;

public class Storage {
	
	List<String> names = new ArrayList<String>();
	
	static Storage storage;
	
	private Storage(){	
	}
	
	public static Storage getInstance(){
		if(storage==null){
			storage = new Storage();
		}
		return storage;
	}
	

	public void add(String name){
		names.add(name);
	}
	
	public List<String> getNames(){
		return names;
	}
	
}
