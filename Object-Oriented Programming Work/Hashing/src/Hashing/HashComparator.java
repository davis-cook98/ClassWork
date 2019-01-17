package Hashing;

public interface HashComparator<K> {
	//Purpose: returns the hash index
	public int hashIndex(K k);
	//Purpose: to determine if two keys are equal
	public Boolean keyEqual(K k1, K k2);
	
}