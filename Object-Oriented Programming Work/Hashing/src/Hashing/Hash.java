package Hashing;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Hash<K, E> implements IDictionary<K, E> {
	protected Item<K, E> AVAILABLE = new Item<K, E>(null, null); // deleted cell item
	protected int n; // number of elements in the hash table
	protected int N; //size of the array
	protected ArrayList<Item<K, E>> A;
	protected HashComparator<K> h; // provides hashIndex and Equals
	protected int Collisions = 0;
	
	abstract int pickJ(int j, int i);
	
	public Hash(int s, HashComparator<K> hc) { 
		n = 0; h = hc; 
		N = s; 
		int i = -1;
		A = new ArrayList<Item<K, E>>(s);
		while (i < s - 1) { 
			i = i + 1;
			A.add(i, null);
		}
	}
	
	//Purpose: to determine if a spot is available
	protected boolean available(int i) { 
		return(A.get(i) == AVAILABLE); 
	}
	//Purpose: to determine if a spot is empty
	protected boolean empty(int i) { 
		return(A.get(i) == null);
	}
	//Purpose: to define a key
	protected K key(int i) {
		return(A.get(i).getKey());
	}
	//Purpose: to define an element
	protected E elem(int i) {
		return(A.get(i).getElem());
	}
	// Dictionary methods
	public Integer size() {
		return(n);
	}
	public Boolean isEmpty() {
		return(n == 0);
	}
	//Iterators
	//Purpose: to go through the elements in a dictionary
	public Iterator<E> elements() { 
		Iterator<Item<K, E>> htlooper = A.iterator();
		ArrayList<E> elems = new ArrayList<E>();
		Item<K, E> k;
		while (htlooper.hasNext()) { 
			k = htlooper.next();
			if ((k != null) && (k != AVAILABLE)) { 
				elems.add(k.getElem()); 
			}
		}
		return(elems.iterator());
	}
	//Purpose: to go through the keys in a dictionary
	public Iterator<K> keys() {
		Iterator<Item<K, E>> htlooper = A.iterator();
		ArrayList<K> keys = new ArrayList<K>();
		Item<K, E> k;
		while (htlooper.hasNext()) { 
			k = htlooper.next();
			if ((k != null) && (k != AVAILABLE)) { 
				keys.add(k.getKey()); 
			}
		}
		return(keys.iterator());
	}
	//Purpose: to find an element
	public E findElement(K k) {
		int i = find(k);
		if (i < 0) { 
			return (null); 
		}
		else { 
			return (elem(i)); 
		}
	}
	//Purpose: to delete an element and key
	public void delete(K k) {
		int i = find(k);
		if (i > -1) {
			A.set(i, AVAILABLE);
			n = n - 1;
		}
	}
	//Purpose: to insert an element and key
	public int insert(K k, E e) {
		int i = h.hashIndex(k) % N;
		int j = i;
		boolean done = false;
		while (!done) { 
			if (empty(j) || available(j)) { 
				A.set(j, new Item<K, E>(k, e));
				n = n + 1;
				done = true;
			}
			else {
				this.Collisions++;
				j = pickJ(j, i);
			}	
		}
		return this.Collisions;
	}
	//Purpose: to find a key in a Table
	public int find(K k) {
		// returns the index of the given key or -1 if there is no such key
		int i = (this.h.hashIndex(k) % N); // division method compression map
		int j = i;
		int res = -1;
		boolean done = false; // indicates that the search is done
		while (!done) {
			if (this.empty(j)) { 
				done = true; 
			}
			else if (this.available(j)) { 
				j = (j + 1) % N; // change 1 to increment, which for double would be secondHash 
				if (j == i) { 
					done = true; 
				}	 
			}
			else if (h.keyEqual(key(j), k)) { 
				res = j;
				done = true;
			}
			else { 
				j = pickJ(j, i); //allows us to wrap around to the beginning, start back at 0
				if (j == i) { 
					done = true; 
				}
			}
		}
		return(res); 
	}	
}
