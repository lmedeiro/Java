
package com.homework.sixTwo;

public class CEO extends Employee
{
	/**
	 *  Below is the implementation of the CEO component within the Employee Structure;
	 *  
	 * @param n
	 * @param s
	 */
	public CEO(String n, double s)
	{
		super(n,s);
	}
	@Override
	public double compensation()
	{
		
		double goldenParachute=1.00;
		double compensation= super.getSalary()+ bonus+ goldenParachute;
		return compensation;
	}
	
	private final double bonus= 10000.00;
	
}
