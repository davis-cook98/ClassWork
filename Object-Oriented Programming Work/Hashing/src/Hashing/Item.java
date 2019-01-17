package Hashing;

public class Item<K, E> { 
	private K key;
	private E elem;
	
	public Item(K k, E e) { 
		key = k;
		elem = e;
	}
	//Purpose: to get a key
	public K getKey() {
		return(key);
	}
	//Purpose: to get an element
	public E getElem() {
		return(elem);
	}
}