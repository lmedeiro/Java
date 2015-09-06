package test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public enum People 
{
	Bad("Go to Jail"),
	Good("Stay in Society"),
	Quiet("Don't speak much");
	
	
	People(String note)
	{
		this.note=note;
		
		
	}
	
	public String getNote()
	{
		return note;
		
	}
	
	
	
	private String note;
	
	
}
