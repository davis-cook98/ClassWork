package Hashing;

public class DHash<K, E> extends Hash<K, E> {
	public DHash(int s, HashComparator<K> hc) { 
		super(s, hc);
	}
	//Purpose: to give a reference for the second hash key
	public int secondHash(int j) {
		return j * 4993;
	}
	//Purpose: to pick a new value for J
	public int pickJ(int j, int i) {
		return Math.abs((j + (this.Collisions*secondHash(i))) % N);
	}
}
