package run_order;

import org.junit.Test;
import org.junit.Assert;

public class DanceTest {

	@Test
	public void testDance() {
		String[] dancers = {"a1","b1","c1"};
		Dance d = new Dance(dancers,"dance1");
	}

	@Test
	public void testGetDancers() {
		String[] dancers = {"a1","b1","c1"};
		Dance d = new Dance(dancers,"dance1");
		Assert.assertArrayEquals(dancers,d.getDancers());
	}

	@Test
	public void testGetTitle() {
		String[] dancers = {"a1","b1","c1"};
		Dance d = new Dance(dancers,"dance1");
		Assert.assertEquals("dance1",d.getTitle());
	}

	@Test
	public void testEquals() {
		String[] dancers1 = {"a1","b1","c1"};
		Dance d1a = new Dance(dancers1,"dance1");
		Dance d1b = new Dance(dancers1,"dance1");
		String[] dancers2 = {"a2","b2","c2"};
		Dance d3 = new Dance(dancers2,"dance2");

		// reflexive
		Assert.assertTrue(d1a.equals(d1a));
		Assert.assertEquals(d1a,d1a);

		// equal
		Assert.assertTrue(d1a.equals(d1b));
		Assert.assertEquals(d1a,d1b);
		Assert.assertTrue(d1b.equals(d1a));
		Assert.assertEquals(d1b,d1a);

		// not equal
		Assert.assertFalse(d1a.equals(d3));
		Assert.assertFalse(d3.equals(d1a));
		Assert.assertFalse("hi".equals(d3));
		Assert.assertFalse(d3.equals("hi"));

	}
}