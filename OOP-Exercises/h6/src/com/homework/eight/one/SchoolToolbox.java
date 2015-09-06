package com.homework.eight.one;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * The following class implements Toolbox. 
 * Please refer to the contracts in Toolbox. 
 * All contracts are defined there. All methods are defined here. 
 * @author Luiz Medeiros
 * 
 *
 */
public class SchoolToolbox implements Toolbox
{
	/**
	 * Here we have the default Constructor for the toolbox
	 */
	public SchoolToolbox()
	{
		
	}
	@Override
	public ArrayList<Tool> get() throws NoSuchElementException 
	{
		
		return tools;
	}

	@Override
	public String getName() {
		
		Iterator< Tool> it= tools.iterator();
		String names= "";
		
		while (it.hasNext())
		{
			
			names+= it.next().getName()+ "\t";
			
			
		}
		
		return names;
	}

	@SuppressWarnings("finally")
	@Override
	public boolean add(Tool tool) {
				
		try 
		{
			tools.add(tool);
			
			return true;
		}
		catch( Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			return false;
		}
		
			
		
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
	
	
}
