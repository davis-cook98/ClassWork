package quizzle;

public class NMTLIST<X> implements IList<X> 
{
	private X car;
	private IList<X> cdr;
	
	public NMTLIST(X f, IList<X> r)
	{
		car = f;
		cdr = r;
	}
	
	public IList<X> cons(X v)
	{
		return(new NMTLIST<X>(v, this));
	}
	
	public int length()
	{
		return(1 + this.cdr.length());
	}
	
	public boolean isEmpty()
	{
		return(false);
	}
	
	public boolean equals(IList<X> I)
	{
		try
		{
			return((this.first().equals(I.first())) && this.rest().equals(I.rest()));
		}
		catch(Exception e)
		{
			System.out.println("Error NMTLIST equals: " + e.getMessage());
			return(false);
		}
	}
	
	public X first() throws Exception
	{
		return(car);
	}
	
	public IList<X> rest() throws Exception
	{
		return(cdr);
	}
	
	public X listref(int i) throws Exception
	{
		if (i == 0)
		{
			return (car);
		}
		else
		{
			return(this.cdr.listref(i-1));
		}
	}
	
	public IList<X> append(IList<X> L)
	{
		try
		{
			return(new NMTLIST<X>(this.first(), this.rest().append(L)));
		}
		catch (Exception e)
		{
			System.out.println("Error NMTLIST append: " + e.getMessage());
			return(this);
		}
	}
	
	private IList<X> revhelper(IList<X> I, IList<X> res)
	// ACCUM INV: reverse(this) == append(reverse(I), res)
	{
		try
		{
			if(I.isEmpty())
			{
				return(res);
			}
			else
			{
				return(revhelper(I.rest(), res.cons(I.first())));
			}
		}
		catch(Exception e)
		{
			System.out.println("Error NMTLIST reverse: " + e.getMessage());
			return(res);
		}
	}
	
	public IList<X> reverse()
	{
		return(revhelper(this, new MTLIST<X>()));
	}
	
	public <R> IList<R> map(IFun<X,R> f)
	{
		try
		{
			return(new NMTLIST<R>(f.f(this.first()), this.rest().map(f)));
		}
		catch(Exception e)
		{
			System.out.println("Error NMTLIST map: " + e.getMessage());
			return(new MTLIST<R>());
		}
	}
	
	public IList<X> filter(IPred<X> p)
	{
		try
		{
			if(p.p(this.first()))
			{
				return(new NMTLIST<X>(this.first(), this.rest().filter(p)));
			}
			else
			{
				return(this.rest().filter(p));
			}
		}
		catch(Exception e)
		{
			System.out.println("Error NMTLIST filter: " + e.getMessage());
			return(new MTLIST<X>());
		}
	}
	
	public <R> R foldl(IFun2<X, R> f, R res)
	{
		try
		{  
			return(this.rest().foldl(f,	f.f(this.first(), res)));  
		}
		catch(Exception e)
		{
			System.out.println("Error NMTLIST foldl:" +	e.getMessage());
			return(res);
		}
	}
	
	public <R> R foldr(IFun2<X, R> f, R res)
	{
		return(this.reverse().foldl(f, res));
	}
}
