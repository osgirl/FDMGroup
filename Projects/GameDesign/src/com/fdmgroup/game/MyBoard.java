package com.fdmgroup.game;
import com.fdmgroup.serialization.game.Board;
import java.io.FileOutputStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class MyBoard extends Board implements Serializable{
	private static final long serialVersionUID = -8218744603908422715L;
	static Random myGenerator = new Random();
	List<Wizard> wizhold = new ArrayList<Wizard>();
	
	public static void main(String[] args){
		Wizard harrypotter = new Wizard(100, "Harry Potter", 30, 30, "Fire", "Poison");
		Wizard voldemort = new Wizard(125, "Voldemort", 35, 5, "Poison", "Fire");
		
		while(harrypotter.isAlive() && voldemort.isAlive()){
			doBattle(harrypotter, voldemort);
			
			int disconnectChance = myGenerator.nextInt(50) + 1;
			if(disconnectChance <= 10){
				try{
					FileOutputStream fos = new FileOutputStream("SavedGame.txt");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(harrypotter);
					oos.writeObject(voldemort);
					oos.close();
					
					FileInputStream fis = new FileInputStream("SavedGame.txt");
					ObjectInputStream ois = new ObjectInputStream(fis);
					harrypotter = (Wizard)ois.readObject();
					voldemort = (Wizard)ois.readObject();
					ois.close();
					
					System.out.println("An attempt to disconnect has been caught... your game has been auto saved!");
				}catch(IOException e)
				{
					e.printStackTrace();
				} 
				catch (ClassNotFoundException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		if(harrypotter.isAlive() == false){
			System.out.println("Voldemort Has Won! (That's now what happens in the book... LIES!)");
		}
		else 
			System.out.println("Harry Potter Wins... 10 Points to Gryffindor!");
	}
	
	protected static void doBattle(Wizard wizard1, Wizard wizard2){
		int turn = myGenerator.nextInt(50) + 1;
		if((turn % 2) == 0){
			wizard1.attack(wizard2);
		}
		else{
			wizard2.attack(wizard1);
		}
	}
}
