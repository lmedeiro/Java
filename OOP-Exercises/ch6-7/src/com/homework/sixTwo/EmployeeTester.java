package com.homework.sixTwo;

public class EmployeeTester {

	/**
	 * This is the Tester Class for the Employee Template Pattern implementation;
	 * @param arg
	 */
	public static void main (String [] arg)
	{
		System.out.println(" working" );
		Employee manager= new Manager("Manager" , 50000);
		Employee engineer= new Engineer("Engineer", 75000);
		Employee ceo= new CEO(" CEO" , 100000);
		
		System.out.println(manager.format()+ " \n" + engineer.format()+ "\n" + ceo.format());
		
	}
}
