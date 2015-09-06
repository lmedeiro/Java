package heapSortAlgorithm;

/**
 * This algorithm works to produce a sorted array from a random input
 * array. 
 * It is fair to note that in order to produce a program that 
 * matches exactly the algorithm in Java, it was necessary to use static 
 * functions. This takes away some of the functionality of the OOP
 * ideals. An implementation through C/C++ would include pointers and specific
 * memory allocation. All of which would partially facilitate and/or 
 * differentiate this task. 
 * @author Luiz Medeiros
 *
 */


public class Heap 
{
	/**
	 * Sets the parent of index i;
	 * @precondition 
	 * @postcondition 
	 * @param i
	 */
	public static int parent(int i)
	{
		p=(int)((double)i/2);
		System.out.println("p: "+ p);
		
		return p;
		
	}
	/**
	 * 
	 * @precondition 
	 * @postcondition 
	 * @param i
	 * @return
	 */
	public static int left(int i)
	{
		l= 2* i;
				
		return l;
	}
	/**
	 * Set the right index of the leaf of the current item. 
	 * @precondition 
	 * @postcondition 
	 * @param i
	 * @return
	 */
	public static int right(int i)
	{
		r=2*i+1;
		return r;
		
	}
	
	/**
	 * We use this function to do the exchanges necessary for the 
	 * arrays. For example, when the values of largest index is not equal
	 * to the values of the current index in the heap structure, 
	 * we swap the values of the two. 
	 * @precondition 
	 * @postcondition 
	 * @param x
	 * @param y
	 */
	public static void swap(int x, int y)
	{
		int dummy= a[x];
		a[x]=a[y];
		a[y]=dummy;
		
	}
	
	/**
	 * Here we are calling to build the max Heap.
	 * This function will call maxHeapify on the array that is 
	 * inputted to the parameter list.
	 * @precondition 
	 * @postcondition 
	 * @param a
	 */
	public static void buildMaxHeap(int [] a)
	{
		N=a.length-1;
		for (int i=N/2;i>=0;i--)
		{
			maxHeapify(a,i);
		}
	}
	
	/**
	 * This is the function which is maximizing the heap structure.
	 * It arranges the heap array in max order.
	 * @precondition 
	 * @postcondition 
	 * @param a
	 * @param i
	 */
	public static void maxHeapify(int [] a, int i)
	{
		
		left(i);right(i);
		if(l<=N && a[l] >a[i])
		{
			largest=l;
		}
		else 
		{
			largest=i;
		}
		if(r<=N && a[r] > a[largest])
		{
			largest=r;
		}
		if(largest!=i)
		{
			swap(i,largest);
			maxHeapify(a,largest);
		}
		
	}
	
	public static void heapSort( int [] array)
	{
		a= array;
		buildMaxHeap(a);
		
		for (int i=N;i>0;i--)
		{
			swap(0,i);
			N=N-1;
			maxHeapify(a,0);
			
		}
		
	}
	
	/**
	 * This main function is the driver of this program. It is used
	 * to test and debug.
	 * @precondition 
	 * @postcondition 
	 * @param arg0
	 */
	public static void main (String [] arg0)
	{
		System.out.println("working");
		int [][] test= new int[5][1000];
		for(int m=0;m<5;m++)
		{
			for(int j=0;j<1000;j++)
			{
				test[m][j]=(int)(Math.random()*1000);
			}
			
		}
		long start= 0;
		//long RT=0;
		//i=0;j=0;
		int x=0;
		int i1=0;
		//int n=100;
		int z=0;
		long [] RT= new long [50];
		for(int i11=0;i11<5;i11++)
		{
			for(int n=100;n<=1000;n=n+100)
			{
				int [] testB= new int[n];
				x=0;
				while(x<n-1)
				{
					testB[x]=test[i11][x];
					//System.out.println(testB[x]);
					x++;
				}
				start=System.nanoTime();
				heapSort(testB);
				RT[z]=System.nanoTime()-start;
				System.out.println("\nRT"+ "["+ i11+ "]"+"["+ x+ "]"+ ": "+ RT[z] + " nanoseconds\n");
				for(int i2=0;i2<testB.length;i2++){
		            System.out.print(testB[i2] + " ");
		        }


				System.out.println("z: "+ z);
				z++;
			}
		}
		z=0;
		System.out.println("\n");
		while (z<50)
		{
			System.out.print(RT[z]+ " ");
	        
			z++;
		}
		
//		int t=11/2;
//		System.out.println("t: "+ t);
		
	}
	/**
	 * Variable definitions
	 */
	private static int [] a;
	private static int N;
	private static int p,r,l,largest;
	}
	
	

