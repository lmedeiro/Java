package com.homework.ten.one;

public class QueueTest 
{

	public static void main(String [] arg)
	{
		MyQueue queue= new LQueue();
		String[] n= new String[5];
		for (int i=0; i<5; i++)
		{
			n[i]=new String(""+i);
			queue.enqueue(n[i]);
			
		}
		System.out.println("head "+ queue.head());
		System.out.println(queue.dequeue());
		System.out.println("head "+ queue.head());
		
		
		
		
	}
}
