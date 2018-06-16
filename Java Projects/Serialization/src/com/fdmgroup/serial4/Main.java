/* Demo 4 - Demonstrates what happens when we serialize an object with a
 * serializable superclass.  Then subclass will be deserialized and returned to the state it
 * was in prior to serialization. 
*/

package com.fdmgroup.serial4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main
{
	public static void main(String[] args)
	{
		//create mammal to serialize
		Mammal m1 = new Mammal(true,false,"Horse");
		System.out.println("Pre-serialized Animal a2 has name: ["+m1.getName()
				+"] land is: "+m1.isLand()+" age in: "+m1.getAge());	
		Mammal m2 = null;	
			
		try
		{
			//serialize object
			FileOutputStream fs = new FileOutputStream("animals.txt"); //give file name
			ObjectOutputStream os = new ObjectOutputStream(fs); //make objectoutputstream using your fileoutputstream			
			os.writeObject(m1);		
			os.close(); //always close stream when finished
					
			//deserialize object		
			FileInputStream fis = new FileInputStream("animals.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			m2 = (Mammal) ois.readObject(); //it returns object, so you must cast it
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
				
		System.out.println("De-serialized Animal a2 has name: ["+m2.getName()
			+"] land is: "+m2.isLand()+" age in: "+m2.getAge());				
	}
}
