package com.homework.sevenOne;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Date;
/**
 * This class defines and tests a method that translate Class<?> objects to strings 
 * @author Florida
 *
 */
public class TestUtils 
{
	
	public TestUtils()
	{
		
	}
	
	/**
	 * This method places the information of a given class into a string and outputs this
	 * information;
	 * 
	 * full class name
	 * name of superclass and interfaces implemented
	 * all constructors, with paramter type list and modifiers (public, final, etc.)
	 * all methods...
	 * all fields with parameter type list and modifiers... 
	 * 
	 * @param cl
	 * @return String with the information of a given class 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @precondition cl is not null; Also, the exceptions are defined; 
	 */
	
	public static String explain( Class <?> cl) throws IllegalArgumentException, IllegalAccessException
	{
		
		String info="";
		String fullClName= cl.getName();
		Class <?> nameOfSuper=cl.getSuperclass();
		
		Method []  nameOfMethods= cl.getMethods();
		Field [] nameOfFields=cl.getDeclaredFields();
		//StringBuffer buffer= new StringBuffer();
		/*for (Method f: nameOfMethods)
		{
			if(!Modifier.isStatic(f.getModifiers()))
			{
				f.setAccessible(true);
				buffer.append(f.getName());
				buffer.append("\n");
				//buffer.append(f.getType());
				buffer.append("\n");
				
			}
		}*/
		
		Constructor [] nameOfConstructors=cl.getConstructors();
		
		
		Constructor<?>[] nameOfConstructors2= cl.getConstructors();
		info= "public "+ fullClName + "\n" + "{"+ "\n"+ nameOfConstructors.toString() + "\n " + nameOfMethods	+ "\n"+ nameOfFields + "\n}" ;
		//System.out.println(nameOfConstructors2.getClass());
		//info=buffer.toString();
		return info;
		
	}
	/**
	 * The main method below tests the implementation of the explain method defined in this class. 
	 * @param arg
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @precondition exceptions are defined;
	 */
	public static void main (String [] arg) throws IllegalArgumentException, IllegalAccessException 
	{
		//System.out.println("working;");
		
		TestUtils test= new TestUtils();
		Date today= new Date();
		System.out.println(test.explain(today.getClass()).toString());
		
		//StringBuffer buffer= new StringBuffer();
		
		
	}
	
	//private Class<?> checker;
	
}
