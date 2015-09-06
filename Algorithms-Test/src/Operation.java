
public class Operation 
{
	private int result;
	
	private int [] b;
	public void arrayMod()
	{
		int [] a={1,2,3};
		b=a.clone();
	}
	
	public int [] getB()
	{
		return b;
	}
	public Operation()
	{
		result=0;
	}
	
	public int add(int a, int b)
	{
		int g=a+b;
		result=g;
		return g;
	}
	
	public int getResult()
	{
		return result;
	}


	
}
