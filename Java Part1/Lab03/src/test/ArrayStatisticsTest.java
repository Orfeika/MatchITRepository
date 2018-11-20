package test;
import static org.junit.Assert.*;


import org.junit.Test;

import general.ArrayStatistics;

public class ArrayStatisticsTest {

	@Test
	public  void testIndexfirstNegative() {
		double [] list = {1,-2};
		double result = ArrayStatistics.indexfirstNegative(list);
		assertEquals(0,result,0);
	}

	/*@Test
	public final void testMin() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testMax() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testAvg() {
		fail("Not yet implemented"); // TODO
	} */

}
