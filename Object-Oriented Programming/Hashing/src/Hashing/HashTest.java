package Hashing;

import java.util.ArrayList;

public class HashTest {
	public static StringComparator TheComp = new StringComparator();
	public static LPHash<String, String> LPhashBud = new LPHash<String, String>(10007, TheComp);
	public static DHash<String, String> DhashBud = new DHash<String, String>(10007, TheComp);
	
	//purpose: returns all the collisions when all elements of a are added to the table t
	public static int returnCollisions(ArrayList<Item<String, String>> a, Hash<String, String> t) {
		int collisionsH = 0;
		while (a.size() != 0) {
			Item<String, String> current = a.get(0);
			collisionsH = collisionsH + t.insert(current.getKey(), current.getElem());
			t.Collisions = 0;
			a.remove(0);
		}
		return collisionsH;
	}

	//to fill a list of length "limit" with randomly generated numbers
	public static ArrayList<Item<String, String>> generateList(int first, int second, ArrayList<Item<String, String>> list, int limit) {
		while (limit != 0) {
			if (first == 120) {
				first = 32;
				second += 1;
			}
			else {
				first += 1;
			}
			int random = (int) Math.floor((Math.random() * 90) + 32);
			String theFirst = Character.toString((char) first);
			String theSecond = Character.toString((char) second); 
			String theRandom = Character.toString((char) random);
			String theFinal = theFirst.concat(theSecond).concat(theRandom);
			Item<String, String> item = new Item<String, String>(theFinal, theFinal);
			list.add(item);
			limit--;
		}
		return list;
	}
	public static void main(String[] args) {
	  System.out.println("One");
		for(int i = 0; i<=5; i++) {
			ArrayList<Item<String, String>> testLista = new ArrayList<Item<String, String>>();
			ArrayList<Item<String, String>> testListb = new ArrayList<Item<String, String>>();
			ArrayList<Item<String, String>> length1000 = generateList(32, 32, new ArrayList<Item<String, String>>(), 1000);
			testLista.addAll(length1000);
			testListb.addAll(testLista);
			System.out.println(returnCollisions(testLista, LPhashBud));
			System.out.println(returnCollisions(testListb, DhashBud));
			LPhashBud = new LPHash<String, String>(10007, TheComp);
			DhashBud = new DHash<String, String>(10007, TheComp);
		}
		System.out.println("Two");
		for(int i = 0; i<=5; i++) {
			ArrayList<Item<String, String>> testLista = new ArrayList<Item<String, String>>();
			ArrayList<Item<String, String>> testListb = new ArrayList<Item<String, String>>();
			ArrayList<Item<String, String>> length2000 = generateList(32, 32, new ArrayList<Item<String, String>>(), 2000);
			testLista.addAll(length2000);
			testListb.addAll(testLista);
			System.out.println(returnCollisions(testLista, LPhashBud));
			System.out.println(returnCollisions(testListb, DhashBud));
			LPhashBud = new LPHash<String, String>(10007, TheComp);
			DhashBud = new DHash<String, String>(10007, TheComp);
		}
		
		System.out.println("Three");
		for(int i = 0; i<=5; i++) {
			ArrayList<Item<String, String>> testLista = new ArrayList<Item<String, String>>();
			ArrayList<Item<String, String>> testListb = new ArrayList<Item<String, String>>();
			ArrayList<Item<String, String>> length3000 = generateList(32, 32, new ArrayList<Item<String, String>>(), 3000);
			testLista.addAll(length3000);
			testListb.addAll(testLista);
			System.out.println(returnCollisions(testLista, LPhashBud));
			System.out.println(returnCollisions(testListb, DhashBud));
			LPhashBud = new LPHash<String, String>(10007, TheComp);
			DhashBud = new DHash<String, String>(10007, TheComp);
		}
		System.out.println("Four");
		for(int i = 0; i<=5; i++) {
			ArrayList<Item<String, String>> testLista = new ArrayList<Item<String, String>>();
			ArrayList<Item<String, String>> testListb = new ArrayList<Item<String, String>>();
			ArrayList<Item<String, String>> length4000 = generateList(32, 32, new ArrayList<Item<String, String>>(), 4000);
			testLista.addAll(length4000);
			testListb.addAll(testLista);
			System.out.println(returnCollisions(testLista, LPhashBud));
			System.out.println(returnCollisions(testListb, DhashBud));
			LPhashBud = new LPHash<String, String>(10007, TheComp);
			DhashBud = new DHash<String, String>(10007, TheComp);
		}
		
		System.out.println("Five");
		for(int i = 0; i<=5; i++) {
			ArrayList<Item<String, String>> testLista = new ArrayList<Item<String, String>>();
			ArrayList<Item<String, String>> testListb = new ArrayList<Item<String, String>>();
			ArrayList<Item<String, String>> length5000 = generateList(32, 32, new ArrayList<Item<String, String>>(), 5000);
			testLista.addAll(length5000);
			testListb.addAll(testLista);
			System.out.println(returnCollisions(testLista, LPhashBud));
			System.out.println(returnCollisions(testListb, DhashBud));
			LPhashBud = new LPHash<String, String>(10007, TheComp);
			DhashBud = new DHash<String, String>(10007, TheComp);
		}
		
		System.out.println("Six");
		for(int i = 0; i<=5; i++) {
			ArrayList<Item<String, String>> testLista = new ArrayList<Item<String, String>>();
			ArrayList<Item<String, String>> testListb = new ArrayList<Item<String, String>>();
			ArrayList<Item<String, String>> length6000 = generateList(32, 32, new ArrayList<Item<String, String>>(), 6000);
			testLista.addAll(length6000);
			testListb.addAll(testLista);
			System.out.println(returnCollisions(testLista, LPhashBud));
			System.out.println(returnCollisions(testListb, DhashBud));
			LPhashBud = new LPHash<String, String>(10007, TheComp);
			DhashBud = new DHash<String, String>(10007, TheComp);
		}
		System.out.println("Seven");
		for(int i = 0; i<=5; i++) {
			ArrayList<Item<String, String>> testLista = new ArrayList<Item<String, String>>();
			ArrayList<Item<String, String>> testListb = new ArrayList<Item<String, String>>();
			ArrayList<Item<String, String>> length7000 = generateList(32, 32, new ArrayList<Item<String, String>>(), 7000);
			testLista.addAll(length7000);
			testListb.addAll(testLista);
			System.out.println(returnCollisions(testLista, LPhashBud));
			System.out.println(returnCollisions(testListb, DhashBud));
			LPhashBud = new LPHash<String, String>(10007, TheComp);
			DhashBud = new DHash<String, String>(10007, TheComp);
		}
		System.out.println("Eight");
		for(int i = 0; i<=5; i++) {
			ArrayList<Item<String, String>> testLista = new ArrayList<Item<String, String>>();
			ArrayList<Item<String, String>> testListb = new ArrayList<Item<String, String>>();
			ArrayList<Item<String, String>> length8000 = generateList(32, 32, new ArrayList<Item<String, String>>(), 8000);
			testLista.addAll(length8000);
			testListb.addAll(testLista);
			System.out.println(returnCollisions(testLista, LPhashBud));
			System.out.println(returnCollisions(testListb, DhashBud));
			LPhashBud = new LPHash<String, String>(10007, TheComp);
			DhashBud = new DHash<String, String>(10007, TheComp);
		}
		System.out.println("Nine");
		for(int i = 0; i<=5; i++) {
			ArrayList<Item<String, String>> testLista = new ArrayList<Item<String, String>>();
			ArrayList<Item<String, String>> testListb = new ArrayList<Item<String, String>>();
			ArrayList<Item<String, String>> length9000 = generateList(32, 32, new ArrayList<Item<String, String>>(), 9000);
			testLista.addAll(length9000);
			testListb.addAll(testLista);
			System.out.println(returnCollisions(testLista, LPhashBud));
			System.out.println(returnCollisions(testListb, DhashBud));
			LPhashBud = new LPHash<String, String>(10007, TheComp);
			DhashBud = new DHash<String, String>(10007, TheComp);
		}
		System.out.println("Ten");
		for(int i = 0; i<=5; i++) {
			ArrayList<Item<String, String>> testLista = new ArrayList<Item<String, String>>();
			ArrayList<Item<String, String>> testListb = new ArrayList<Item<String, String>>();
			ArrayList<Item<String, String>> length10000 = generateList(32, 32, new ArrayList<Item<String, String>>(), 10000);
			testLista.addAll(length10000);
			testListb.addAll(testLista);
			System.out.println(returnCollisions(testLista, LPhashBud));
			System.out.println(returnCollisions(testListb, DhashBud));
			LPhashBud = new LPHash<String, String>(10007, TheComp);
			DhashBud = new DHash<String, String>(10007, TheComp);
		}	
	}
}
