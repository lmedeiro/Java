package com.homework.eight.one;
/**
 * This is the Tool interface which serves to creates subclasses of Tool that define 
 * their functions;
 * @author Luiz Medeiros
 *
 */
public interface Tool extends Cloneable
{

	/**
	 * This method is to return the name of the particular tool in question
	 * 
	 * @return String name of tool 
	 * @precondition the string returned is not null and has properly defined by the 
	 * Subclass;
	 */
	public String getName();
	
	/**
	 * returns the use of the tool ;
	 * @precondition also requires the name and function to be properly defined.
	 */
	
	public void use();
	
	
}
