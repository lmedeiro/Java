import heapSortAlgorithm.HeapSort;
import insertionSort.Insertion;
import quickSort.Quick;


public class Test {

	
	
	public void add(int a, int b)
	{
		a=a+b;
	}
	
	
	public static void main (String [] arg0)
	{
		System.out.println("working");
		int i=0;
		
		int x=0;
		
		Quick quickS=new Quick();
		Insertion insertS=new Insertion();
		HeapSort heap=new HeapSort();
		//int [] test= new int [100];
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
		x=0;
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
				heap.heapSort(testB);
				RT[z]=System.nanoTime()-start;
				System.out.println("\nRT"+ "["+ i11+ "]"+"["+ x+ "]"+ ": "+ RT[z] + " nanoseconds\n");
				for(int i2=0;i2<testB.length;i2++){
		            System.out.print(heap.getData()[i2] + " ");
		        }
//				start=System.nanoTime();
//				quickS.quickSort(testB, 0, testB.length-1);
//				RT[z]=System.nanoTime()-start;
//				System.out.println("\nRT"+ "["+ i11+ "]"+"["+ x+ "]"+ ": "+ RT[z] + " nanoseconds\n");
//				for(int i2=0;i2<testB.length;i2++){
//		            System.out.print(quickS.getData()[i2] + " ");
//		        }
//				start=System.nanoTime();
//				insertS.insertionSort(testB);
//				RT[z]=System.nanoTime()-start;
//				System.out.println("\nRT"+ "["+ i11+ "]"+"["+ x+ "]"+ ": "+ RT[z] + " nanoseconds\n");
//				for(int i2=0;i2<testB.length;i2++){
//		            System.out.print(insertS.getData()[i2] + " ");
//		        }
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
//		
//		Quick quickS=new Quick();
//		int [] a= {2,3,8,9,10,88,10,0};
//		quickS.quickSort(a, 0, a.length-1);
//		System.out.println(quickS.getData()[2]);
//		
//		
	
	
}
