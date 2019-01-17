package BTree;

public abstract class Abintree<X> implements bintree<X>
	{
		protected X val;
		
		public X getRootval() {return(val);}
		
		//purpose: to double a binary tree with the original root value as
		//         the root for the new tree.
		public bintree<X> doubleTree(){
			return new interiornode<X>(val, this, this);
		}
	}

