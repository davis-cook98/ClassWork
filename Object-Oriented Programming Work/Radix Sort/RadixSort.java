package RSort;

import java.util.ArrayList;

public class RadixSort {
	static ArrayList<Integer> myList = new ArrayList<Integer>();
	
	public static Integer[] radix(Integer[] v) {
		RadixBuckets buckets = new RadixBuckets();
		buckets.bucketize(v);
		return v;
	}
	
}
