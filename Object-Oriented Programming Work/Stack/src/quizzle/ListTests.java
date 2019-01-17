package quizzle;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ListTests {

	@Test
	public void test() 
	{
		IList<String> E = new MTLIST<String>();
		IList<String> L0 = new MTLIST<String>();
		IList<String> L1 = new MTLIST<String>();
		IList<String> L2 = new MTLIST<String>();
		IList<Integer> N = new MTLIST<Integer>();
		IList<Integer> N1 = N.cons(new Integer(4)).cons(new Integer(6)).cons(new Integer(3));
		IList<Integer> N2 = N.cons(new Integer(1)).cons(new Integer(30)).cons(new Integer(30));
		L0 = L0.cons("pal!").cons("there ").cons("Hi ");
		L1 = L1.cons("you?").cons("are ").cons("How ");
		L2 = (new MTLIST<String>()).cons("you?").cons("are ").cons("How ").cons("pal!").cons("there ").cons("Hi ");
		
		try
		{
			assertEquals(E.length(), 0);
			assertEquals(L0.length(), 3);
			assertEquals(E.isEmpty(), true);
			assertEquals(L0.isEmpty(), false);
			assertEquals(L0.first(), "Hi ");
			assertEquals(L0.rest().rest().first(), "pal!");
			assertEquals(L0.listref(1), "there ");
			assertEquals(L1.equals(E.append(L1)), true);
			assertEquals(L2.equals(L0.append(L1)), true);
			
			assertEquals(E.reverse().equals(E), true);
			assertEquals(L0.reverse().equals(E.cons("Hi ").cons("there ").cons("pal!")), true);
			
			assertEquals(E.map(s -> s.length()).equals(N), true);
			assertEquals(L0.map(s -> s.length()).equals(N1), true);
			
			assertEquals(N.filter((n -> n % 2 == 0)).equals(N), true);
			assertEquals(N2.filter((n -> n % 2 == 0)).equals(N.cons(new Integer(30)).cons(new Integer(30))), true);
			
			assertEquals(N.foldl((n, r)	-> r.cons(n), N).equals(N), true);
			assertEquals(N2.foldl((n, r) ->	r.cons(n), N).equals(N2.reverse()), true);
			
			assertEquals(N.foldr((n, r) -> r.cons(n), N).equals(N), true);
			assertEquals(N2.foldr((n, r) -> r.cons(n), N).equals(N2), true);
		}
		catch(Exception e)
		{
			System.out.println("Error ListTests: " + e.getMessage());
		}
	}

}
