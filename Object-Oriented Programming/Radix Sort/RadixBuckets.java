package RSort;

import java.util.ArrayList;

public class RadixBuckets implements IBuckets<Integer>{
	Bucket<Integer> zero  = new Bucket<Integer>();
	Bucket<Integer> one   = new Bucket<Integer>();
	Bucket<Integer> two   = new Bucket<Integer>();
	Bucket<Integer> three = new Bucket<Integer>();
	Bucket<Integer> four  = new Bucket<Integer>();
	Bucket<Integer> five  = new Bucket<Integer>();
	Bucket<Integer> six   = new Bucket<Integer>();
	Bucket<Integer> seven = new Bucket<Integer>();
	Bucket<Integer> eight = new Bucket<Integer>();
	Bucket<Integer> nine  = new Bucket<Integer>();
	
	ArrayList<Bucket<Integer>> bucketList = new ArrayList<Bucket<Integer>>();

	public RadixBuckets() {
		bucketList.add(zero);
		bucketList.add(one);
		bucketList.add(two);
		bucketList.add(three);
		bucketList.add(four);
		bucketList.add(five);
		bucketList.add(six);
		bucketList.add(seven);
		bucketList.add(eight);
		bucketList.add(nine);
	}
	
	//Purpose: to dump all the buckets into an array
	public void dumpBuckets(Integer[] v) {
		int x = 0; //purpose: to denote which bucket will be dump
		int index = 0; //purpose: to denote where in the vector you will start to cpy values from buckets
		//Accumulator Invariant = index is incremented by an int (natural number, always positive) that is returned
		//                          from toArray, a function on a bucket that returns the length of that bucket after
		//                          the bucket is moved into an array. Because the index is incremented by how many
		//                          Integers were written into the array, the array can continue to be written at
		//                          at index, because index is the next available space in the array
		//
		//Termination Argument = because x is necessarily a positive natnum (as it is initialized at 0 and only ever
		//                      increased by one), and 10 is also a positive natural number that is greater than 
		//                      zero, eventually x will stop being less than 10, and the loop will exit
		//
		//Loop Invariant = the contents of the buckets in the bucketList from bucketList[0] to bucketList[x] will be copied
		//                  into the given array v starting at v[index] at any given point in the recursion
		while(x<10) {
			//x < 10
			//index = the first available space in the array v that can be overwritten without disturbing the array's order
			//the contents of bucketList[0]...bucketList[x-1] will be copied into the array v
			index += bucketList.get(x).toArray(v, index);
			//x < 10
			//the contents of bucketList[0]...bucketList[x] will be copied into the array v
			x++;
			//x <= 10
			//the contents of bucketList[0]...bucketList[x-1] will be copied into the array v
		}
		//x = 10
		//the contents of bucketList[0]...bucketList[9] will be copied into the array v
	}
	
	//Purpose: to find the longest number in a vector
	public int longest(Integer[] vec, int max, int mov){
		if(mov < 0){
			return(vec[max]);
			}
		if(vec[mov] > vec[max]){
			return(longest(vec, mov, (mov - 1)));
		}
		else{
			return(longest(vec, max, (mov - 1)));
		}
	}
	
	//Purpose: To determine how long a given number is
	public int findLongest(int input, int n){
		int temp = (int) (input % (Math.pow(10, n)));
		if(input == temp){
			return(n);
		}
		else{ 
			return findLongest(input, (n + 1));
		}
	}
		
	//Purpose: to sort an array in place
	public void bucketize(Integer[] v) {
        int length = findLongest(longest(v, v.length - 1, v.length - 1), 1) ; //purpose: length = number of digits in largest number
        int exp = 0; //purpose: exp is which digit is currently being sorted, starting with the ones digit.
        //loop invariant: v[] is sorted based on exp digit place into bucketList && bucketList dumped back into v[] beginning at v[0]
        //               && 0 <= exp <= length.
        while(exp<=length) {
               //v[] exists sorted by exp digit place && bucketlist not dumped into v[]
               bucketizeHelper(v, exp);
               //v[] is sorted by based on exp-1 digit place && bucketList not dumped into v[]
               this.dumpBuckets(v);
               //v[] is sorted based on exp-1 digit place && bucketList dumped into v[]
               exp++;
               //v[] is sorted based on exp digit place && bucketList dumped into v[]
        }
        //Termination Argument: exp is a natnum, only ever increased by one, length is a natnum such that exp <= length
        //                     because exp steadily increases by one, eventually exp > length and the loop will terminate
        //exp > length
        //PostCondition: sorted bucketList is placed into v[]
  }

	//Purpose: to put all numbers in an array into buckets
	public void bucketizeHelper(Integer[] v, int div) {
		//max = length of the given array
		int max = v.length ;
		//Accumulator Invariant: index == n where n is the current iteration of the recursion
		//
		//Termination Argument: index is a natnum, only ever increased by one, max is a natnum
		//                     index is necessarily smaller than max, and is consistently
		//                     increasing by one, and will eventually become equal to max
		//                     and the loop will exit
		//
		//Loop Invariant: v[0]...v[index] are copied into their respective buckets
		//                by the digit denoted by div. The array is not mutated.
		//                Termination happens when index!<max
		int index = 0;
		while(index<max) {
			int current = v[index];
			//index < max
			//buckets are unchanged
			//v[0] --> v[index-1] are bucketized (sorted into their respective buckets by the digit denoted by div)
			int digit = (int) (((current * 1.0)%(Math.pow(10, div + 1))) / (Math.pow(10, div)));
			//index < max
			//buckets are unchanged
			//v[0] --> v[index-1] are bucketized (sorted into their respective buckets by the digit denoted by div)
			bucketList.get(digit).add(current);
			//index < max
			//v[index] --> bucketList[digit]
			//v[0] --> v[index] are bucketized (sorted into their respective buckets by the digit denoted by div)
			index++;
			//index <= max
			//v[0] --> v[index-1] are bucketized (sorted into their respective buckets by the digit denoted by div)
		}
		//index==max
		//PostCondition: v[0]...v[max-1] are bucketized
	}
}
