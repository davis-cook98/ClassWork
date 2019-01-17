package quizzle;

public class MTStack<X> implements Stack<X>
{
	public MTStack() {}
	
	public Stack<X> push(X v)
	{
		return(new NMTStack<X>(v, this));
	}
	
	public Stack<X> pop() throws Exception
	{
		throw new Exception("Method pop applied to an empty stack.");
	}
	
	public X top() throws Exception
	{
		throw new Exception("Method top applied to an empty stack.");
	}
	
	public boolean isEmpty()
	{
		return(true);
	}
}
