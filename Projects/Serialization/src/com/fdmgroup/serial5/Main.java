/* Demo 5 - Demonstrates what happens when superclass is not serializable but
 * subclass is.  Then subclass will be deserialized and returned to the state it
 * was in prior to serialization. But any variables it inherits from the nonserializable
 * superclass, will be reinitialized just as if you were making a new object. 
 * I.E. The constructor will run for the nonserializable superclass.
 * But it's important to remember that the JVM will only run the default constructor
 * for the superclass - so you must HAVE one.
*/

package com.fdmgroup.serial5;

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
		
		System.out.println("Pre-serialized Animal m1 has name: ["+m1.getName()
				+"] land is: "+m1.isLand());	
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
			+"] land is: "+m2.isLand());				
	}
}
