package BTree;

public class leafnode<X> extends Abintree<X>
{
	public leafnode(X v) {val = v;}
	
	public Boolean isLeaf() { return(true);}
	
	public bintree<X> getRightbt() throws Exception
	{
		throw new Exception("getRightbt: A leaf doesnot have a right subtree");
	}
	
	public bintree<X> getLeftbt() throws Exception
	{
		throw new Exception("getLeftbt: A leaf doesnot have a left subtree");
	}
	
	public Boolean equals(bintree<X> t) { 
		//Marco, I changed this function. It seemed wrong.
		// before it was just returning true if they were both leaves
		// and that didn't seem like it was going to do what it
		// needed to do
		return (t.isLeaf() && t.getRootval().equals(val));
		}
	
	public String inorderString() {return(this.getRootval().toString());}
	
	public <Y> bintree<Y> btMap(IBTreeF<X,Y> f)
	{
		return(new leafnode<Y>(f.f(this.getRootval())));
	}

}
