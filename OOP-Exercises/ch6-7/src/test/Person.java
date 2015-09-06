package test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Person implements Serializable 
{
	public Person()
	{
		
	}
	
	public Person(String name, String age)
	{
		this.name=name;
		this.age=age;
	}
	
	
	public String name;
	public String age;
}
