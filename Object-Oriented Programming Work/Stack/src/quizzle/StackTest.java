package stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StackTest {

	@Test
	public void test() {
		IList<Integer> EE = new MTLIST<Integer>();
		IList<Integer> K1 = EE.cons(new Integer(4)).cons(new Integer(6)).cons(new Integer(3));
		IList<Integer> KK = EE.cons(new Integer(3)).cons(new Integer(6)).cons(new Integer(4));
		
		Stack<Integer> E = new MTStack<Integer>();
		Stack<Integer> N1 = E.push(new Integer(4));
		Stack<Integer> N2 = E.push(new Integer(4)).push(new Integer(6));
		Stack<Integer> LE = new MTStackList<Integer>();
		Stack<Integer> L1 = LE.push(new Integer(2));
		Stack<Integer> L2 = L1.push(new Integer(4));
		
		assertEquals(E.isEmpty(), true);
		assertEquals(LE.isEmpty(), true);
		assertEquals(N1.isEmpty(), false);
		assertEquals(L1.isEmpty(), false);
		
		try {
			assertEquals(N1.top(),new Integer(6));
			assertEquals(L1.top(),new Integer(2));
			
		}
		catch(Exception e){
			System.out.println("Error Top tests: " + e.getMessage());
		}
		try {
			assertEquals(N2.pop(),N1);
			assertEquals(L2.pop(),L1);
		}
		catch(Exception e) {
			System.out.println("Error pop tests: " + e.getMessage());
		}
		try {
			assertEquals(Reverse.reverse(EE, N2), EE);
			assertEquals(Reverse.reverse(K1, E),KK);
		}
		catch(Exception e) {
			System.out.println("Error reverse tests: " + e.getMessage());
		}
	}

}
