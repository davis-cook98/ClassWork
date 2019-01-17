package RSort;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RadixBucketsTest {
	
	Integer one = new Integer(1);
	Integer two = new Integer(12);
	Integer three = new Integer(23);
	Integer forty = new Integer(43);
	Integer helpme = new Integer(57);
	Integer please = new Integer(394);
	Integer whatshappening = new Integer(494);
	Integer whyisthishere = new Integer(748);
	Integer pleasekillme = new Integer(3939);
	Integer pleaseKillMeCamalCase = new Integer(54923);
	Integer[] EMPT = {1};
	Integer[] HELLSCAPE = {one, two, three, forty, helpme, please, whatshappening, whyisthishere, pleasekillme, pleaseKillMeCamalCase};
	Integer[] SHUFFLEDHELL = {two, forty, whatshappening, pleasekillme, one, helpme, pleaseKillMeCamalCase, please, three, whyisthishere};
	
	RadixBuckets helpTho = new RadixBuckets();

	@Test
	void test() {
		assertEquals(helpTho.longest(HELLSCAPE, (HELLSCAPE.length - 1), (HELLSCAPE.length - 1)), 54923);
		assertEquals(helpTho.longest(SHUFFLEDHELL, 9,9), 54923);
		
		assertEquals(helpTho.findLongest(1,0),1);
		assertEquals(helpTho.findLongest(1234,0),4);
		
		helpTho.bucketizeHelper(HELLSCAPE, 0);
		assertEquals(helpTho.bucketList.get(1).getB().get(0), one);
		assertEquals(helpTho.bucketList.get(2).getB().get(0), two);
		assertEquals(helpTho.bucketList.get(3).getB().get(0), three);
		assertEquals(helpTho.bucketList.get(3).getB().get(1), forty);
		assertEquals(helpTho.bucketList.get(3).getB().get(2), pleaseKillMeCamalCase);
		assertEquals(helpTho.bucketList.get(4).getB().get(0), please);
		assertEquals(helpTho.bucketList.get(4).getB().get(1), whatshappening);
		assertEquals(helpTho.bucketList.get(7).getB().get(0), helpme);
		assertEquals(helpTho.bucketList.get(8).getB().get(0), whyisthishere);
		assertEquals(helpTho.bucketList.get(9).getB().get(0), pleasekillme);
		
		
	}

}
