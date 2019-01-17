package quizzle;

public class NMTStackList<X> implements Stack<X>{
	
		private IList<X> l;
		
		public NMTStackList(IList<X> r)
		{
			r = l;
		}
		
		public Stack<X> push(X v) 
		{
			return(new NMTStackList<X>(l.cons(v)));
		}

		public Stack<X> pop() throws Exception 
		{
			if(l.length() == 1)
			{
				return(new MTStackList<X>());
			}
			else
			{
				return(new NMTStackList<X>(l.rest()));
			}
		}

		public X top() throws Exception 
		{
			return(l.first());
		}

		public boolean isEmpty() 
		{
			return(false);
		}
		
	}
