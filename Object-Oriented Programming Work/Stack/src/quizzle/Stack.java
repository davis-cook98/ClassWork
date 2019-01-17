package quizzle;

public interface Stack<X> {
	//Top: Stack -> item
	//Purpose: to return the first item in a stack
	public X top() throws Exception;
	//Pop: Stack -> Stack
	//Purpose: to return the stack without the first item
	public Stack<X> pop() throws Exception;
	//Push: Item -> Stack
	//Purpose: to put an item into the stack
	public Stack<X> push(X v);
	//isEmpty: Stack -> boolean
	//Purpose: determines if the stack is empty
	public boolean isEmpty();
}
