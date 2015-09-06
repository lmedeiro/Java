package com.homework.eight.one;

public class Protractor implements Tool
{
	@Override
	public String getName() {
		
		return name;
	}

	@Override
	public void use() {
		System.out.println("Using"+ getName());
		
	}
	
	public Object clone()
	{
		try
		{
			return super.clone();
		}
		catch(CloneNotSupportedException e)
		{
			e.printStackTrace();
			return null;
		}
		
	}
	
	private final String name= "Protractor";
}
