package Hashing;

public class LPHash<K, E> extends Hash<K, E> {	
	public LPHash(int s, HashComparator<K> hc) { 
		super(s, hc);
	}
	//Purpose: to get a new value for j
	public int pickJ(int j, int i) {
		return (j + 1) % N;
	}
}
