package BTree;

public interface bintree<X> {
	//purpose: to get the value of the root of the current bintree
	public X getRootval();
	//purpose: to return true if the bintree is a leaf
	public Boolean isLeaf();
	//purpose: to return the right tree
	public bintree<X> getRightbt() throws Exception;
	//purpose: to return the left tree
	public bintree<X> getLeftbt() throws Exception;
	//purpose: to determine if two trees are extentionally equal
	public Boolean equals(bintree<X> t);
	//purpose: to return a string representation of the bintree
	public String inorderString();
	//purpose: to map a function to a bintree
	public <Y> bintree<Y> btMap(IBTreeF<X,Y> f);
	//purpose: to double a given bintree
	public bintree<X> doubleTree();
}
