package com.fdmgroup.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin{
	Scanner myScan;
	List<Users> userList;
	
	public Admin(){
		myScan = new Scanner(System.in);
		userList = new ArrayList<Users>();
	}
	
	public int countCharacter() throws IOException, FileNotFoundException{
		int charCount = 0;
		
		System.out.print("Enter a filename (No-Spaces): ");
		String filename = myScan.next();
		filename = filename + ".txt";
		
		System.out.print("Character Check: ");
		char character = myScan.next().charAt(0);
		
		BufferedReader br = null;
		try{
			String tempLine;
			StringBuilder entireFile = new StringBuilder();
			br = new BufferedReader(new FileReader(new File(filename)));
			while((tempLine = br.readLine()) != null){
				entireFile.append(tempLine);
			}
			for(int index = 0; index < entireFile.length(); index++){
				if(entireFile.charAt(index) == character){
					charCount++;
				}
			}
		}catch(FileNotFoundException w){
			w.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		return charCount;
	}
	
	public void addUsers() throws IOException{
		int numberOfUsers = 0;
		System.out.print("How many users will you be adding? ");
		if(myScan.hasNextInt()){
			numberOfUsers = myScan.nextInt();
		
			System.out.println("Remember to not include the character ','; otherwise it will not be added to the UserList!");
		
			PrintWriter out = null;
			try{
				out = new PrintWriter("UserList.txt", "UTF-8");
				for(int index = 0; index < numberOfUsers; index++){
					int userNumber = index + 1;
					System.out.println("\nUser " + userNumber + " Information");
					System.out.print("Enter First Name: ");
					String firstName = myScan.next();
					System.out.print("Enter Last Name: ");
					String lastName = myScan.next();
					System.out.print("Enter Address: ");
					String address = myScan.next();
					System.out.print("Enter E-mail: ");
					String email = myScan.next();

					String userInfo = firstName + "," + lastName + "," + address + "," + email;
					if((firstName.indexOf(',') == -1) && (lastName.indexOf(',') == -1) && (address.indexOf(',') == -1) && (email.indexOf(',') == -1)){
						out.println(userInfo);
					}
				}
			}catch(FileNotFoundException w){
				w.printStackTrace();
			}finally{
				out.close();
			}
		}
		else
			System.out.println("Invalid Entry, Not A Number!");
	}
	
	public void createUsers() throws IOException{
		BufferedReader br = null;
		try{
			String tempLine;
			br = new BufferedReader(new FileReader(new File("UserList.txt")));
			while((tempLine = br.readLine()) != null){
				String values[] = tempLine.split(",");
				Users tempUsers = new Users(values[0], values[1], values[2], values[3]);
				userList.add(tempUsers);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
