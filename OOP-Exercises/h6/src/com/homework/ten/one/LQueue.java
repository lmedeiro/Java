package com.homework.ten.one;

import java.util.LinkedList;

public class LQueue <E> extends LinkedList<E> implements MyQueue <E> 
{

	public LQueue()
	{
		System.out.println("constructor called");
	}

	@Override
	public E head() {
		// TODO Auto-generated method stub
		
		return peek();
	}

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		return poll();
	}

	@Override
	public void enqueue(E e) {
		// TODO Auto-generated method stub
		add(e);
		
	}
	
	public boolean isEmpty()
	{
		return this.size()==0;
	}
	
	
	
	/**
	 * 
	 * @precondition 
	 * @postcondition 
	 */
	private static final long serialVersionUID = 1L;
}
