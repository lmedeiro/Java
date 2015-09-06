package test;

import java.awt.Rectangle;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * This package and class serve as testing platforms for ch 6 and 7;
 * @author L7
 *
 */
public class Test 
{

	
	
	public static void main (String [] arg ) throws Exception, IOException
	{
		/**
		 * The tests below are exploring hashing a String s;
		 * The strategy is to multiply 31 times the previous h, further adding the current ascii decimal value for the character at 
		 * analysis. 
		 */
		System.out.println("working");
	/*	String s="hello";
		System.out.println(s.charAt(0)*1);
		System.out.println(s.length());
		int h=0;
		for (int i=0;i<s.length();i++)
		{
			h=31 * h + s.charAt(i);
			System.out.println(i+ "\t" + h);
		}*/
		
		/**
		 * Serialization;
		 */
		
		/*String [] n= new String [2];
		n[0]="zeroth";
		n[1]="one";
		ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream("stringTest.dat") );
				out.writeObject(n);
				out.close();*/
		
		//Object e= new Rectangle();
		//Class c= e.getClass();
		//System.out.println(c.getCanonicalName());
		int a[]= {1,2,3,4};
		int b[]= {4,3,2,1};
		Object aa=a,bb=b;
		int c[]= (int[]) a.clone();
		
		
		System.out.println(aa.equals(bb)); // checking for object equality 
		System.out.println(Integer.toHexString(96)); // parsing from int to hex
		System.out.println(Integer.parseInt("fa",16)); // parsing from hex to int
		System.out.println(a.hashCode());
		System.out.println(Integer.toHexString(a.hashCode())); 	// grabbing the hashed memory address of the object and tranlating it to hex 
		System.out.println(c.hashCode());
		System.out.println(c.equals(a));
		System.out.println(c[0]);
		
		Object check= a.getClass();
		System.out.println("blah");
		
		
		for(People p: People.values())
		{
			System.out.println(""+ p + "\t"+ p.getNote());
			
		}
		People pp= People.valueOf("Bad");
		System.out.println(pp.getNote());
		
		
		//Iterator<People> pi= 
		
		ArrayList<String> list= new ArrayList<String>();
		ArrayList list2= new ArrayList();
		
		list2.add(1);list2.add(2);list2.add(3);
		Iterator i2= list2.iterator();
		
		while (i2.hasNext())
		{
			System.out.println(""+i2.next());
		}
		
		/**
		 * Testing Serializable 
		 */
		/*Person jon= new Person("Jon",""+ 44);
		
		String fileName= "serializable.dat";
		try
		{
			
			ObjectOutputStream os= new ObjectOutputStream(new FileOutputStream(fileName));
			
			os.writeObject(jon);
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
		
		System.out.println("done writing");*/
		/**
		 *  Heavy exception handling ! 
		 */
		/*Person jony= new Person();
		try 
		{
			ObjectInputStream is=  new ObjectInputStream(new FileInputStream(fileName));
			System.out.println("begun reading");
			jony= (Person) is.readObject(); 
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
		
		System.out.println(jony.name+ "\t"+ jony.age);
		checkingForJony();*/
		
		//People check= new People();
		checkingForJony();
	}
	
	public static void checkingForJony()
	{
		String fileName="serializable.dat";
		Person jony= new Person();
		try 
		{
			ObjectInputStream is=  new ObjectInputStream(new FileInputStream(fileName));
			System.out.println("begun reading");
			jony= (Person) is.readObject(); 
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
		
		System.out.println(jony.name+ "\t"+ jony.age);
	}
	
	
	
}
