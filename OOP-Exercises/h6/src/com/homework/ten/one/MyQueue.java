package com.homework.ten.one;

/**
 * 
 * @author Luiz Medeiros
 *
 * @param <E>
 */
public interface MyQueue <E>
{
	/**
	 *  A method that returns the head of the queue
	 * @precondition 	A queue has been declared. 
	 * @postcondition  Generic element E is correctly returned;
	 * @return	Generic element E;
	 */
	E head();
	
	
	/**
	 * This method removes the first element from the list;
	 * @precondition the list is not empty
	 * @postcondition the first element is correctly removed and the next is passed as head;
	 * @return returns the following element;
	 */
	
	E dequeue();
	
	
	/**
	 * This method adds to the back of the list;
	 * @precondition  the list has been declared and the item is not null;
	 * @postcondition  an extra item is added to the list
	 * @param e element e to be added to the list;
	 */
	void enqueue( E e);
	/**
	 * This method returns the size of the list;
	 * @precondition a list has been declared;
	 * @postcondition an integer containing the size of the list is returned;
	 * @return int containing the number items in the list;
	 */
	int size();
	
	/**
	 * Check if queue is empty;
	 * @precondition  A queue has been declared;
	 * @postcondition 	A boolean of true or false dictating whether queue is empty or not
	 * @return boolean true or false;
	 */
	boolean isEmpty();
	
	

}
