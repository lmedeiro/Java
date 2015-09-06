package com.homework.eight.one;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * The following class is the Tester for the whole Pattern implementation of 
 * Prototype;
 * @author Luiz Medeiros
 * 
 *
 */
public class ToolTest 
{
	
	public static void main (String [] arg)
	{
		System.out.println("working");
		Tool[] tools= {new Paper(),new Eraser(), new Pencil(), new Protractor(), new Ruler()};
		Toolbox box= new SchoolToolbox();
		int i=0;
		Paper paper= new Paper();
		while (i<tools.length)
		{
			box.add(tools[i]);
			i++;
		}
		/**
		 * Here we output the names of all the tools in the box. 
		 */
		System.out.println(box.getName());
		
		Toolbox newBox= (SchoolToolbox)box.clone();
		
		Tool[] paperSet= {(Paper) paper.clone(), (Paper)paper.clone(),(Paper) paper.clone()};
		
		i=0;
		while (i<paperSet.length)
		{
			newBox.add(paperSet[i]);
			i++;
		}
		
		System.out.println(newBox.getName());
		
		Iterator<Tool> it= newBox.get().iterator();
		
		/**
		 * Here we are showing the use function;
		 */
		while (it.hasNext())
		{
			
			it.next().use();
		}
		
		
		
	}
	
	

	
	
	

	
}
