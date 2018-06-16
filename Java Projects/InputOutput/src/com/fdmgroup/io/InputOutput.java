package com.fdmgroup.io;

import java.io.FileNotFoundException;
import java.io.IOException;

public class InputOutput{
	public static void main(String[] args)throws IOException, FileNotFoundException{
		Admin yuechen = new Admin();
		System.out.println(yuechen.countCharacter());
		yuechen.addUsers();
		yuechen.createUsers();
		
		for(int index = 0; index < yuechen.userList.size(); index++){
			int tempCounter = index + 1;
			System.out.println("(" + tempCounter +") " + yuechen.userList.get(index).toString());
		}
	}
}