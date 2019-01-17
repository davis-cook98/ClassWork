package quizzle;

public class NMTStack<X> implements Stack<X>
	{
		private X top;
		private Stack<X> bottom;
		
		public NMTStack(X t, Stack<X> p)
		{
			top = t;
			bottom = p;
		}
		
		public Stack<X> push(X v)
		{
			return(new NMTStack<X>(v, this));
		}
		
		public Stack<X> pop() throws Exception
		{
			return(bottom);
		}
		
		public X top() throws Exception
		{
			return(top);
		}
		
		public boolean isEmpty()
		{
			return(false);
		}
	}
