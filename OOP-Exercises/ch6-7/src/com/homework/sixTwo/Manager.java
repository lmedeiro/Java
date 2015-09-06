package com.homework.sixTwo;

public class Manager extends Employee
{
	/**
	 * The following class simulates the Manager component within the Employee worker Structure;
	 * 
	 * @param n attributes for the name
	 * @param s attributes for the salary
	 */
	public Manager(String n, double s)
	{
		super(n,s);
	}
	/**
	 * Below is the implementation of the compensation method from the superclass Employee;
	 * Manager bonus is 5000.00;
	 * it returns the total between salary and bonus;
	 * @precondition all variables are double and not null;
	 */
	@Override
	public double compensation()
	{
		
		double total=super.getSalary()+bonus;
		return total;
	}
	
	
	private final double bonus= 5000.00;
	
}
