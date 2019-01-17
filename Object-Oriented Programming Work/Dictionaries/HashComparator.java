package dictionaries;

public interface HashComparator<K> {
	
	public int hashIndex(K k);
	public Boolean keyEqual(K k1, K k2);
	
}