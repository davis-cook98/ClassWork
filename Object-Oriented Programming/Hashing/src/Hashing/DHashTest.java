package Hashing;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

class DHashTest {

	HashComparator<String> scomp = new StringComparator();
	DHash<String, String> ht = new DHash<String, String>(101, scomp);
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
