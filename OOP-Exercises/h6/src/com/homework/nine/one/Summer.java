package com.homework.nine.one;
/**
 * This class computes the sum of number from 1 to n in parallel
 * using multiple concurrent threads.
 * 
 * @author Luiz Medeiros
 *
 */
public class Summer 
{

	public Summer()
	{
		
	}
	
	public Summer (int n, int k)
	{
		this.n=n;
		this.k=k;
		
	}
	
	/**
	 * This function calculates the sum from
	 * 1 to n into k intervals, in k threads.
	 * @precondition n > k; n != null; k != null; 
	 * @postcondition  sum is returned that complies with the summation formula sum= n*(n+1)/2;
	 * @param n
	 * @param k
	 * @return	integer with result;
	 * @throws InterruptedException 
	 */
	
	
	public int sum() throws InterruptedException
	{
		/**
		 * initiate variables to be used in the calculation
		 * 
		 */
		int r=0,ki=1; // i is an adder and r is the remainder;
		
		
		
		r=n%k;
		int i= (ki-1)*n/k;
		int end= ki*n/k;
		int interval= (int) Math.floor((double)(end - i));
		
		System.out.println("In Summer:sum(); \n k="+ k+" n= "+ n+ " interval= "+ interval);
		
		
		
		/**
		 * get the amount of threads to form;
		 * Create all the threads;
		 *  Run (Start) the threads;
		 */
		
		Process[] process= new Process[k];
		for (int j=0;j<k;j++)
		{
			i=(ki-1)*n/k;
			//end= ki*n/k;
			interval= (int) Math.floor((double)(end - i));
			process[j]=new Process(i,end,interval);
			process[j].start();
			try
			{
				//process[j].sleep((long) (Math.random()*500));
				process[j].join();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println("printing inside the function that makes the threads");
			System.out.println("ki: "+ ki);
			ki++;
			
		}
		
			
		
		
		/**
		 * The following procedure makes sure that the threads are dead before adding them 
		 * to the result;
		 * It loops around looking for the threads that are done.
		 */
		
		
		
		
		return result;
	}
	
	
	private class Process extends Thread
	{
		public Process(int start,int end,int inter)
		{
			this.start=start;
			this.inter=inter;
			this.end=end;
			
			System.out.println("Constructor in Process called successfully");
			
		}
		
		public int getResult()
		{
			return result;
		}
		/**
		 * Below we are defining the working method that makes the calculations;
		 * This method relies on n and k being defined correctly
		 * @precondition n and k well defined; Interval calculated
		 * @postcondition The result of the calculation of the current thread was successfully outputted.
		 * @return result of the calculation;
		 */
		
		public synchronized int  summing()
		{
			int j=0;
			while (j<inter)
			{
				result+=start;
				System.out.println("checker: "+ checker+ "\t Start: "+start);
				start++;
				j++;
				
			}
			return result;
			
		}
		@Override
		public void run() 
		{
			
			
			summing();
			System.out.println("checker at run: "+ checker);
			
			
			checker++;
			
			
		}
		
		private int inter,start,end;

		

		
	}
	
	

	/**
	 * Here the variables are declared. With checker you may see the different threads running;
	 */
	private int k,n;
	public static int checker=0;
	private static  int result=0;
	private static boolean flag=false;
	
	
	
	
}
