/* Demo 3 - We've seen that if an instance variable's class is not serializable,
 * we will get a NotSerializableException. We can get around this by making it 
 * serializable.  However, if we don't have access to the class, what can we do?
 * Answer: 
 *   Step 1: We can make the instance variable transient.
 *           But now we have a NullPointerException because Home was never deserialized.
 *	 Step 2: In our Animal class we implement two extra methods:
 *				private void readObject(ObjectInputStream is) and
 *				private void writeObject(ObjectOutputStream is)
 *           In these methods we request to do the normal (de)serialization process,
 *           but then also some extra stuff for the transient variable. 
*/

package com.fdmgroup.serial3;

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
		Animal a1 = new Animal("Frog",new Home(5));
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
				
		System.out.println("De-serialized Animal a2 has name: "+a2.getName()
				+" and house number is: "+a2.getHome().getNumber());
	}
}
