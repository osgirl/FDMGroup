/* Demo 2 - Serialization of an object whose instance variables are themselves
 * references to objects.  See the difference when the instance variables are/aren't 
 * serializable.
 * 
 * See that if Home is not serializable you get a NonSerializableException*/
package com.fdmgroup.serial2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main
{
	public static void main(String[] args)
	{
		//create animal to serialize
		Animal a1 = new Animal("Lion",new Home(5));
		Animal a2 = null;	
			
		try
		{
			//serialize object
			FileOutputStream fs = new FileOutputStream("animals.txt"); //give file name
			ObjectOutputStream os = new ObjectOutputStream(fs); //make objectoutputstream using your fileoutputstream			
			os.writeObject(a1);		
			os.close(); //always close stream when finished
					
			//deserialize object		
			FileInputStream fis = new FileInputStream("animals.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			a2 = (Animal) ois.readObject(); //it returns object, so you must cast it
			ois.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		System.out.println("De-serialized Animal a2 has name: "+
						a2.getName()
				+" and house number is: "+
						a2.getHome().getNumber());
	}
}
