package com.fdmgroup.collection;

import java.util.ArrayList;

public class StringArrayList{
	public static void main(String[] args){
		ArrayList<String> stringList = new ArrayList<String>();
		
		stringList.add("Hello");
		stringList.add("World!");
		
		System.out.println("The Size Of arrayListString is currently: " + stringList.size() + ".\n");
		
		for(int index = (stringList.size() - 1); index >= 0; index--){
			System.out.println("The String value at index " + index + " is " + stringList.get(index));
		}
		
		System.out.println();
		System.out.print("When replacing 'World!' with 'world...' at a specified index, ");
		System.out.print("the size before add with index: " + stringList.size());
		stringList.add(1, "world...");
		System.out.println(" changes to " + stringList.size() + ".\n");
		
		stringList.remove(1);
		System.out.println("Size of arrayListString after remove index 1 (world...): " + stringList.size() + ".\n");
		
		System.out.println("Result for 'world...': " + stringList.indexOf("world...") + ": When not found!");
		System.out.println("Result for 'World!': " + stringList.indexOf("World!") + ": Actual index when found!");
		System.out.println("Result for 'Hello': " + stringList.indexOf("Hello") + ": Actual index when found!\n");
		
		System.out.println("Test Contains Object Hello: " + stringList.contains("Hello") + ".");
		System.out.println("Test Contains Object world...: " + stringList.contains("world...") + ".\n");
	}
}
