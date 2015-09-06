package com.homework.sixTwo;

/**
 * The following abstract class simulates the structure of Employee and it's subdivisions within the 
 * current social working structure.
 * 
 * @author Luiz Medeiros
 * 
 *
 */
public abstract class Employee 
{

	/**
	 * Below is the constructor of the super class employee, that takes in the name and salary of Employee;
	 * @precondition n && s != null; n == String; s == double;
	 * @param n
	 * @param s
	 */
	public Employee(String n, double s )
	{
		name=n;
		salary=s;
		
	}
	/**
	 * @postcondition both attributes have been defined and the super class structure has been initiated;
	 */
	
	/**
	 * Below is a method that returns the structure string with the provided information of employee;
	 * @return the return info is the structure String with the salary and name of the Employee;
	 * @precondition info is a string;
	 */
	
	
	public String format()
	{
		String info="name: " + name+ "\t" + "salary: "+ salary + "\t\t" + "Total compensation: " + this.compensation();
		return info;
	}
	
	/**
	 * Below is the abstract method compensation which dictates the total amount subclasses from employee will return;
	 * @return a double value with the arithmetic result from salary and any provided or dictate bonus;
	 */
	public abstract double compensation();
	/**
	 * Accessor for the name method;
	 * @return name;
	 */
	
	public String getName()
	{
		return name;
	}
	
	/**
	 * Accessor for the salary;
	 * @return salary
	 */
	public double getSalary()
	{
		return salary;
		
	}
	
	/**
	 * 
	 * Below are the attributes for the template class Employee;
	 */
	private String name;
	private double salary;
}
