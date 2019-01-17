package BTree;

public class interiornode<X> extends Abintree<X>
{
	bintree<X> l,r;
	
	public interiornode(X v, bintree<X> left, bintree<X> right)
	{
		val = v;
		l = left;
		r = right;
	}
	
	public Boolean isLeaf() { return(false);}
	
	public bintree<X> getRightbt() throws Exception
	{
		return(this.r);
	}
	
	
	public bintree<X> getLeftbt() throws Exception
	{
		return(this.l);
	}
	
	public Boolean equals(bintree<X> t) 
	{
		try
		{
			return( !t.isLeaf() && 
					this.getRootval().equals(t.getRootval()) &&
					this.getLeftbt().equals(t.getLeftbt()) &&
					this.getRightbt().equals(t.getRightbt()));
		}
		catch(Exception e)
		{
			System.out.println("Error equals in interior node: " + e.getMessage());
			return(false);
		}
	}
	
	public String inorderString() 
	{
		try
		{
			return(this.getLeftbt().inorderString()+ " " + this.getRootval().toString() + " " + this.getRightbt().inorderString());
		}
		catch(Exception e)
		{
			System.out.println("Error inorderString in interiornode:" + e.getMessage());
			return(null);
		}
	}
	
	public <Y> bintree<Y> btMap(IBTreeF<X,Y> f)
	{
		try
		{
			return(new interiornode<Y>(f.f(this.getRootval()), this.getLeftbt().btMap(f), this.getRightbt().btMap(f)));
		}
		catch(Exception e)
		{
			System.out.println("Error map in interiornode:" + e.getMessage());
			return(null);
		}
	}
	
}

