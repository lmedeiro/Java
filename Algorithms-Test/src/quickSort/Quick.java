package quickSort;
/**
 * This Class implements the quickSort algorithm and checks 
 * it's RT properties. 
 * @author Luiz Medeiros
 *
 */
public class Quick 
{
	/**
	 * This is the constructor for Quick
	 */
	public Quick()
	{
		
	}
	/**
	 * This is the main recursive function that takes care of the 
	 * initial recursive calling of the sorting functionality.
	 * In other words, it takes care of the conquering.
	 * @precondition 
	 * @postcondition 
	 * @param A array containing the data
	 * @param p index of the array
	 * @param r last item of the array.
	 */
	public void quickSort(int [] A, int p, int r)
	{
		if(p<r)
		{
			int q= partition(A,p,r);
			quickSort(A,p,q-1);
			quickSort(A,q+1,r);
			
		}
		data=A.clone();
	}
	
	/**
	 * This function takes care of the partitioning of the array.
	 * In other words, it serves as the *Divide function of the 
	 * for the algorithms.
	 * @precondition 
	 * @postcondition 
	 * @param A
	 * @param p
	 * @param r
	 * @return
	 */
	public int partition( int [] A, int p, int r)
	{
		int z=A[r];
		
		int i=p-1;
		
		for (int j=p;j<=r-1;j++)
		{
			if(A[j]<=z)
			{
				i=i+1;
				A=swap(A,i,j);
			}
		}
		A=swap(A,i+1,r);
		return i+1;
	}
	
//	public void sort(int [] a)
//	{
//		if(a==null || a.length==0)
//			return;
//		this.data=a;
//		x= data.length;
//		quickSort(0,x-1);
//		
//	}
	/**
	 * Does the swaping in the array A between a[i] and a[j].
	 * @precondition 
	 * @postcondition 
	 * @param A
	 * @param i
	 * @param j
	 * @return Array A;
	 */
	public int []  swap(int [] A, int i, int j)
	{
		int t= A[i];
		A[i]=A[j];
		A[j]=t;
		
		return A;
	}
	
	public int [] getData()
	{
		return data;
	}
	
	/**
	 * This function will be used to test the sorting functionality.
	 * @precondition 
	 * @postcondition 
	 * @param arg0
	 */
	public static void main (String [] arg0)
	{
		
		System.out.println("WOrking");
	}
	
	
	
	private int[] data;
	//private int x;
}
