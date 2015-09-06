package heapSortAlgorithm;
/**
 * 
 * @author Luiz Medeiros
 *
 */
public class HeapSort 
{
	
	public HeapSort()
	{
		
	}
   
	public int parent(int i)
	{
		return i/2;
	}
	public int left(int i)
	{
		return 2*i+1;
	}
	public int right(int i)
	{
		return 2*i+2;
	}
	
	public void maxHeapify(int [] A, int i)
	{
		int n=A.length;
		int l=left(i);
		int r=right(i),largest=0;
		if(l<=n-1 && A[l]>A[i])
		{
			largest=l;
		}
		else
		{
			largest=i;
		}
		if(r<=n-1 && A[r]>A[largest])
		{
			largest=r;
			
			
		}
		if (largest!=i)
		{
			A=swap(A,i,largest);
			maxHeapify(A,largest);
		}
		//data=A.clone();
	}
	
	public void buildMaxHeap(int [] A)
	{
		data=A;
		int n=A.length-1;
		for (int i=n/2;i>=0;i--)
		{
			maxHeapify(data, i);
		}
	}
	
	public void heapSort(int [] A)
	{
		data=A.clone();
		int n=A.length;
		buildMaxHeap(data);
		//A=data.clone();
		for (int i=n-1;i>0;i--)
		{
			data=swap(data,0,i);
			n=n-1;
			maxHeapify(data, 0);
		}
		
	}
	
	public int [] swap( int [] A, int i, int j)
	{
		int t= A[i];
		A[i]=A[j];
		A[j]=t;
		return A.clone();
	}
	
	
	public int [] getData()
	{
		return data.clone();
	}
	
	private int [] data;
}
