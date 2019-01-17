package dictionaries;

public class Item<K, E> { private K key;
	private E elem;
	public Item(K k, E e) { 
		key = k;
		elem = e;
	}
	public K getKey() {
		return(key);
	}
	
	public E getElem() {
		return(elem);
	}
}