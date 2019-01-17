package RSort;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IBucketTest {

	@Test
	void test() {
		IBucket<Integer> B = new Bucket<Integer>();
		B.add(0);
		B.add(1);
		B.add(2);
		B.add(3);
		Integer X[] = {0, 0, 0, 0};
		assertEquals(B.toArray(X, 0), 4);
		assertArrayEquals(X, new Integer[] {0, 1, 2, 3});
		assertEquals(B.getSize(), 0); // Needs selector to test
	}

}
