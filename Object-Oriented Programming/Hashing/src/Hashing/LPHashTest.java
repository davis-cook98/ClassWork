package Hashing;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Iterator;

public class LPHashTest {
	HashComparator<String> scomp = new StringComparator();
	LPHash<String, String> ht = new LPHash<String, String>(101, scomp);
	@Test
	public void testHT() { 
		assertEquals(ht.size().intValue(), 0); assertEquals(ht.isEmpty(), true);
		assertEquals(ht.findElement("Marco"), null);
		ht.insert("Marco", "Morazan"); ht.insert("Nick", "Olson");
		ht.insert("Jean Luc", "Picard"); ht.insert("Kathryn", "Janeway");
		assertEquals(ht.size().intValue(), 4);
		assertEquals(ht.isEmpty(), false);
		assertEquals(ht.findElement("Marco"), "Morazan");
		assertEquals(ht.findElement("Cathryn"), null);
		assertEquals(ht.findElement("Kathryn"), "Janeway");
		ht.delete("Kathryn");
		assertEquals(ht.findElement("Kathryn"), null);
		Iterator<String> klooper = ht.keys();
		Iterator<String> elooper = ht.elements();
		String res = "";
		while (klooper.hasNext()) { 
			res = res + " " + klooper.next() + " " + elooper.next(); 
		}
		assertEquals(res, " Jean Luc Picard Nick Olson Marco Morazan");
	}
}
