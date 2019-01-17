package quizzle;

public class MTLIST<X> implements IList<X> 
{
	public MTLIST() {}
	
	public IList<X> cons(X v)
	{
		return(new NMTLIST<X>(v, this));
	}
	
	public int length()
	{
		return(0);
	}
	
	public boolean isEmpty()
	{
		return(true);
	}
	
	public boolean equals(IList<X> I)
	{
		return(I.isEmpty());
	}
	
	public X first() throws Exception
	{
		throw new Exception("Method first applied to an empty list.");
	}
	
	public IList<X> rest() throws Exception
	{
		throw new Exception("Method rest applied to an empty list.");
	}
	
	public X listref(int i) throws Exception
	{
		throw new Exception("Method listref applied to an empty list.");
	}
	
	public IList<X> append(IList<X> L)
	{
		return(L);
	}
	
	public IList<X> reverse()
	{
		return(this);
	}
	
	public <R> IList<R> map(IFun<X,R> f)
	{
		return(new MTLIST<R>());
	}
	
	public IList<X> filter(IPred<X> p)
	{
		return(this);
	}
	
	public <R> R foldl(IFun2<X,R> f, R res)
	{
		return(res);
	}
	
	public <R> R foldr(IFun2<X,R> f, R res)
	{
		return(res);
	}

}
