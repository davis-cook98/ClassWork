package RSort;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


class RadixSortTest {
	Integer one = new Integer(1);
	Integer two = new Integer(2);
	Integer three = new Integer(3);
	Integer forty = new Integer(43);
	Integer helpme = new Integer(57);
	Integer please = new Integer(493);
	Integer whatshappening = new Integer(594);
	Integer whyisthishere = new Integer(748);
	Integer pleasekillme = new Integer(3938);
	Integer pleaseKillMeCamalCase = new Integer(4928);
	Integer[] HELLSCAPE = {one, two, three, forty, helpme, please, whatshappening, whyisthishere, pleasekillme, pleaseKillMeCamalCase};
	Integer[] SHUFFLEDHELL = {two, forty, whatshappening, pleasekillme, one, helpme, pleaseKillMeCamalCase, please, three, whyisthishere};


	@Test
	void test() {
		RadixSort.radix(SHUFFLEDHELL);

		assertEquals(SHUFFLEDHELL[0].equals(HELLSCAPE[0]) , true);
		assertEquals(SHUFFLEDHELL[1].equals(HELLSCAPE[1]) , true);
		assertEquals(SHUFFLEDHELL[2].equals(HELLSCAPE[2]) , true);
		assertEquals(SHUFFLEDHELL[3].equals(HELLSCAPE[3]) , true);
		assertEquals(SHUFFLEDHELL[4].equals(HELLSCAPE[4]) , true);
		assertEquals(SHUFFLEDHELL[5].equals(HELLSCAPE[5]) , true);
		assertEquals(SHUFFLEDHELL[6].equals(HELLSCAPE[6]) , true);
		assertEquals(SHUFFLEDHELL[7].equals(HELLSCAPE[7]) , true);
		assertEquals(SHUFFLEDHELL[8].equals(HELLSCAPE[8]) , true);
		assertEquals(SHUFFLEDHELL[9].equals(HELLSCAPE[9]) , true);
	
		
	}

}
