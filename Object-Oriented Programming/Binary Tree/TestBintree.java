package BTree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestBintree {

	@Test
	void test() {
		bintree<Integer> L = new leafnode<Integer>(2);
		bintree<Integer> R = new leafnode<Integer>(3);
		bintree<Integer> T = new interiornode<Integer>(1,L,R);
		bintree<Integer> L1 = new leafnode<Integer>(2);
		bintree<Integer> R1 = new leafnode<Integer>(3);
		bintree<Integer> T1 = new interiornode<Integer>(1,L1,R1);
		bintree<Integer> DL = new leafnode<Integer>(4);
		bintree<Integer> DR = new leafnode<Integer>(6);
		bintree<Integer> DT = new interiornode<Integer>(2,DL,DR);
		
		//new test values
		bintree<Integer> DOUBLED = new interiornode<Integer>(2, DT, DT);
		bintree<Integer> DOUBLEME = new interiornode<Integer>(2, L, L);
		
		try
		{ assertEquals(L.getRootval().intValue(),2);
		assertEquals(T.getRootval().intValue(),1);
		assertEquals(T.getLeftbt(), L);
		assertEquals(T.getRightbt(), R);
		assertEquals(R.equals(R1), true);
		assertEquals(T.equals(T1), true);
		assertEquals(L1.inorderString(), "2");
		assertEquals(T.inorderString(), "2 1 3");
		assertEquals(R1.btMap(x -> 2 * x).equals(DR), true);
		assertEquals(T.btMap(x -> 2 * x).equals(DT), true); 
		assertEquals(T1.getRootval().intValue(), 1);
		
		//new tests
		assertEquals(DT.doubleTree().equals(DOUBLED), true);
		assertEquals(L.doubleTree().equals(DOUBLEME), true);
		}
		catch(Exception e)
		{ System.out.println("Error in test: " + e.getMessage()); }
	}

}
