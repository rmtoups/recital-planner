package run_order;

import org.junit.Test;
import org.junit.Assert;
import java.util.ArrayList;

public class DanceTest {

	@Test
	public void testDance() {
		ArrayList<String> dancers = new ArrayList<String>();
		dancers.add("a1");
		dancers.add("b1");
		dancers.add("c1");
		Dance d1 = new Dance(dancers,"dance1");
		Dance d2 = new Dance("dance2");
	}

	@Test
	public void testGetDancers() {
		ArrayList<String> dancers = new ArrayList<String>();
		dancers.add("a1");
		dancers.add("b1");
		dancers.add("c1");
		Dance d = new Dance(dancers,"dance1");
		Assert.assertEquals(dancers,d.getDancers());
	}

	@Test
	public void testAddDancer() {

		ArrayList<String> dancers1 = new ArrayList<String>();
		dancers1.add("a1");
		dancers1.add("b1");
		dancers1.add("c1");
		Dance d1 = new Dance(dancers1,"dance1");

		ArrayList<String> dancers1s = new ArrayList<String>();
		dancers1s.add("a1");
		dancers1s.add("b1");
		dancers1s.add("c1");
		dancers1s.add("d1");

		d1.addDancer("d1");
		Assert.assertEquals(dancers1s,d1.getDancers());

		Dance d2 = new Dance("dance2");
		ArrayList<String> dancers2 = new ArrayList<String>();

		dancers2.add("a2");
		d2.addDancer("a2");

		Assert.assertEquals(dancers2,d2.getDancers());

		dancers2.add("b2");
		d2.addDancer("b2");

		Assert.assertEquals(dancers2,d2.getDancers());
	}

	@Test
	public void testRemoveDancer() {

		ArrayList<String> dancers1 = new ArrayList<String>();
		dancers1.add("a1");
		dancers1.add("b1");
		dancers1.add("c1");
		Dance d1 = new Dance(dancers1,"dance1");

		ArrayList<String> dancers1s = new ArrayList<String>();
		dancers1s.add("a1");
		dancers1s.add("c1");

		Assert.assertTrue(d1.removeDancer("b1"));
		Assert.assertEquals(dancers1s,d1.getDancers());
		Assert.assertFalse(d1.removeDancer("b1"));
		Assert.assertEquals(dancers1s,d1.getDancers());
		Assert.assertFalse(d1.removeDancer("h7"));
		Assert.assertEquals(dancers1s,d1.getDancers());

		Dance d2 = new Dance("dance2");
		ArrayList<String> dancers2 = new ArrayList<String>();

		Assert.assertFalse(d1.removeDancer("b1"));
		Assert.assertEquals(dancers2,d2.getDancers());
	}

	@Test
	public void testGetTitle() {
		ArrayList<String> dancers = new ArrayList<String>();
		dancers.add("a1");
		dancers.add("b1");
		dancers.add("c1");
		Dance d = new Dance(dancers,"dance1");
		Assert.assertEquals("dance1",d.getTitle());
	}

	@Test
	public void testEquals() {
		ArrayList<String> dancers1 = new ArrayList<String>();
		dancers1.add("a1");
		dancers1.add("b1");
		dancers1.add("c1");
		Dance d1a = new Dance(dancers1,"dance1");
		Dance d1b = new Dance(dancers1,"dance1");

		ArrayList<String> dancers2 = new ArrayList<String>();
		dancers2.add("a2");
		dancers2.add("b2");
		dancers2.add("c2");
		Dance d2 = new Dance(dancers2,"dance2");

		// reflexive
		Assert.assertTrue(d1a.equals(d1a));
		Assert.assertEquals(d1a,d1a);

		// equal
		Assert.assertTrue(d1a.equals(d1b));
		Assert.assertEquals(d1a,d1b);
		Assert.assertTrue(d1b.equals(d1a));
		Assert.assertEquals(d1b,d1a);

		// not equal
		Assert.assertFalse(d1a.equals(d2));
		Assert.assertFalse(d2.equals(d1a));
		Assert.assertFalse("hi".equals(d2));
		Assert.assertFalse(d2.equals("hi"));

	}
}