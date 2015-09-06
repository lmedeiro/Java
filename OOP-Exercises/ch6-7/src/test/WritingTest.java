package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WritingTest 
{

	public WritingTest()
	{
		
		
	}
	
	public static void writeSomeOne()
	{
		Person pablo= new Person("Pablo",""+ 23);
		
		String fileName= "serializable.dat";
		try
		{
			
			ObjectOutputStream os= new ObjectOutputStream(new FileOutputStream(fileName));
			
			os.writeObject(pablo);
			
			System.out.println("Writing");
			os.close();
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch( IOException e)
		{
			e.printStackTrace();
		}
		//ObjectOutputStream os= new ObjectOutputStream(new FileOutputStream(fileName));
		
		System.out.println("done writing");
	}
	
	
	public static void writeString(String message)
	{
		String object= message;
		String fileName= "string0.dat";
		try
		{
			
			ObjectOutputStream os= new ObjectOutputStream(new FileOutputStream(fileName));
			ObjectOutputStream osAppend= new ObjectOutputStream( new FileOutputStream(fileName));
			os.writeObject(object);
			
			
			System.out.println("Writing");
			os.close();
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch( IOException e)
		{
			e.printStackTrace();
		}
		//ObjectOutputStream os= new ObjectOutputStream(new FileOutputStream(fileName));
		
		System.out.println("done writing");
	}
	
	public static void readingString()
	{
		String fileName="string0.dat";
		String message= new String("");
		try 
		{
			ObjectInputStream is=  new ObjectInputStream(new FileInputStream(fileName));
			System.out.println("begun reading");
			message= (String) is.readObject(); 
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		System.out.println("finished reading");
		
		System.out.println(message);
	}
	
	
	public static void main (String [] arg)
	{
		
		System.out.println("workign");
		//writeSomeOne();
		writeString("Hello There! ");
		readingString();
		writeString("another String");
		readingString();
	}
}
