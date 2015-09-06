package com.homework.nine.one;

class Runner extends Thread
{
	
	public void run()
	{
		// do something funky
		
		
		try
		{
			sleep(100);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
			System.out.println("We are at the catch statement");
		}
	}
	
}




public class Test 
{

	
	public static void main (String [] arg)
	{
		System.out.println("working");
	}
}
