package quizzle;

public interface IList<X>
{
	public IList<X> cons(X val);
	// Purpose: add the given value to this list
	public int length();
	// Purpose: return the length of this list
	public boolean isEmpty();
	// Purpose: Determine if this list is empty
	public boolean equals(IList<X> L);
	// Purpose: To determine if the given list is equal to this list
	public X first() throws Exception;
	// Purpose: To return the first element of this list
	public IList<X> rest() throws Exception;
	// Purpose: To return the rest of this list
	public X listref(int i) throws Exception;
	//Purpose: To return the ith element of this list
	public IList<X> append(IList<X> L);
	// Purpose: To append the given list to this list
	public IList<X> reverse();
	// Purpose: To reverse this list
	public <R> IList<R> map(IFun<X, R> f);
	// Purpose: To map the given function to the elements of this list
	public IList<X> filter(IPred<X> p);
	// Purpose: Return a list w/ elements of this list satisfying the given predicate
	public <R> R foldl(IFun2<X, R> f, R res);
	// Purpose: To apply the given function to all the elements of the given list
	//			from left to right and return the accumulated result
	public <R> R foldr(IFun2<X, R> f, R res);
	// Purpose: To apply the given function to all the elements of the given list
	//	        from right to left and return the accumulated result
}
