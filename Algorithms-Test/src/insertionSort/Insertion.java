package insertionSort;

/**
 * This class implements the Insertion Sort algorithm.
 * @author Luiz Medeiros
 *
 */
public class Insertion 
{
	
	
	public void insertionSort(int [] A)
	{
		int j=1,i=0;
		int key=0;
		for (;j<=A.length-1;j++)
		{
			key=A[j];
			i=j-1;
			while(i>=0 && A[i]>key)
			{
				A[i+1]=A[i];
				i=i-1;
			}
			A[i+1]=key;
		}
		
		data=A.clone();
		
	}
	
	
	public int [] getData()
	{
		return data.clone();
	}
	
	private int[] data;
}
