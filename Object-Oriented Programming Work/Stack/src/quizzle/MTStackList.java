package quizzle;

public class MTStackList<X> implements Stack<X> 
{
	private IList<X> l = new MTLIST<X>();
	
	public MTStackList() {}
	
	public Stack<X> push(X v) 
	{
		return(new NMTStackList<X>(l.cons(v)));
	}

	public Stack<X> pop() throws Exception
	{
		throw new Exception("Method rest applied to an empty list.");
	}

	public X top() throws Exception
	{
		throw new Exception("Method first applied to an empty list.");
	}

	public boolean isEmpty() 
	{
		return(true);
	}
	
}

