package Hashing;

import java.util.Iterator;
import java.util.ArrayList;

public class Dict<K,E> implements IDictionary<K,E> {

	private ArrayList<K> keys;
	private ArrayList<E> elems;
	private int size;
	
	public Dict() {
		keys = new ArrayList<K>();
		elems = new ArrayList<E>();
		size = 0;
	}
	//Purpose: to return the size of the dictionary
	public Integer size() {
		return (size);
	}
	//Purpose: to determine if a dictionary is empty
	public Boolean isEmpty() {
		return (size == 0);
	}
	//Purpose: to return the elements of a dictionary
	public Iterator<E> elements() {
		return (elems.iterator());
	}
	//Purpose: t return the keys of a dictionary
	public Iterator<K> keys() {
		return (keys.iterator());
	}
	//Purpose: To find an element in a dictionary
	public E findElement(K k) { 
		int i = keys.indexOf(k);
		if (i > -1) { 
			return (elems.get(i)); 
		} 
		else { 
			return(null); 
		}
	}
	//Purpose: to insert an element and key into a dictionary
	public int insert(K k, E e) {
		keys.add(k);
		elems.add(e);
		size = size + 1;
		return 0;
	}
	//Purpose: to delete an element and key in a dictionary
	public void delete(K k) {
		int i = keys.indexOf(k);
		keys.remove(i);
		elems.remove(i);
		size = size - 1;
	}
	
}
