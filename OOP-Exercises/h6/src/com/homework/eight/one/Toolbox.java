package com.homework.eight.one;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Toolbox returns the cloned tools. Thus toobox serves as the creator in this 
 * Prototype pattern. 
 * @author Florida
 *
 */
public interface Toolbox extends Cloneable
{

	/**
	 * This method returns the elements retrieved 
	 */
	
	public ArrayList<Tool> get() throws NoSuchElementException;
	
	public String getName();
	
	/**
	 * Adds a tool to the toolbox.
	 * @param tool
	 * @return boolean that is true if adding was successful, false otherwise;
	 * @precondition assumes that all tools are not null;
	 * 
	 */
	public boolean add(Tool tool);
	
	/**
	 * Tools will be held and added to the array list below;
	 */
	
	public ArrayList<Tool> tools = new ArrayList<Tool>();
	
	/**
	 * Defining the clone function for the subclasses;
	 */
	
	public Object clone();
	
}
