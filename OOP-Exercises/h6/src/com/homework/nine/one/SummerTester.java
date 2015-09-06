package com.homework.nine.one;

/**
 * This is a tester class for the class Summer;
 * @author Luiz Medeiros
 *
 */


public class SummerTester 
{

	public SummerTester()
	{
		
	}
	
	public void chill() throws InterruptedException
	{
		this.wait();
	}
	
	public static void main(String [] arg) throws InterruptedException
	{
		System.out.println("working");
		
		int nnn=20,kkk=7;
		int interval= (int) Math.floor((double)(nnn/kkk));
		System.out.println(""+interval+ "\n"+ nnn/kkk);
		
		Summer sum= new Summer(nnn,kkk);
		
		int resul=  sum.sum();
		
		System.out.println("result: "+resul);
		int expected= nnn*(nnn+1)/2;
		System.out.println("expected: "+ expected);
		
		
		
		
	}
}
