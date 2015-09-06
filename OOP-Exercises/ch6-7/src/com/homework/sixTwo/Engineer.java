
package com.homework.sixTwo;

public class Engineer extends Employee
{
	
	/**
	 * Below is the Engineer Implementation of within the Employee Structure. 
	 * @param n
	 * @param s
	 */
	public Engineer(String n, double s)
	{
		super(n,s);
	}
	@Override
	public double compensation()
	{
		
		double compensation=super.getSalary()+stockOptions;
		return compensation;
	}
	
	
	private final double stockOptions=25000.0;
	
}
