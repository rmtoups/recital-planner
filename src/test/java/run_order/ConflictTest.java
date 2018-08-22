package run_order;

import org.junit.Test;
import org.junit.Assert;
import java.util.ArrayList;

public class ConflictTest {

/*************************************************
 *		Test DancerConflict class
 *************************************************/

	@Test
	public void Conflict() {

		ArrayList<String> dancers1 = new ArrayList<String>();
		dancers1.add("a1");
		dancers1.add("b1");
		dancers1.add("c1");
		Dance d1 = new Dance(dancers1,"dance1");

		ArrayList<String> dancers2 = new ArrayList<String>();
		dancers2.add("a2");
		dancers2.add("b2");
		dancers2.add("c2");
		Dance d2 = new Dance(dancers2,"dance2");

		Conflict c = new Conflict(d1,d2);
	}

	@Test
	public void testGetDances() {

		ArrayList<String> dancers1 = new ArrayList<String>();
		dancers1.add("a1");
		dancers1.add("b1");
		dancers1.add("c1");
		Dance d1 = new Dance(dancers1,"dance1");

		ArrayList<String> dancers2 = new ArrayList<String>();
		dancers2.add("a2");
		dancers2.add("b2");
		dancers2.add("c2");
		Dance d2 = new Dance(dancers2,"dance2");

		Conflict c = new Conflict(d1,d2);
		Assert.assertEquals(d1,c.getDance1());
		Assert.assertEquals(d2,c.getDance2());
	}

	@Test
	public void testGetOverlapDancers() {

		ArrayList<String> dancers1 = new ArrayList<String>();
		dancers1.add("a1");
		dancers1.add("b1");
		dancers1.add("c1");
		Dance d1 = new Dance(dancers1,"dance1");

		ArrayList<String> dancers2 = new ArrayList<String>();
		dancers2.add("a2");
		dancers2.add("b2");
		dancers2.add("c2");
		Dance d2 = new Dance(dancers2,"dance2");

		ArrayList<String> dancers3 = new ArrayList<String>();
		dancers3.add("a1");
		dancers3.add("b2");
		dancers3.add("c2");
		Dance d3 = new Dance(dancers3,"dance3");
		
		ArrayList<String> dancers4 = new ArrayList<String>();
		dancers4.add("a2");
		dancers4.add("b2");
		dancers4.add("c2");
		Dance d4 = new Dance(dancers4,"dance4");

		// no overlap
		Conflict c1 = new Conflict(d1,d2);
		Assert.assertEquals(0,c1.getOverlapDancers().size());

		// one overlap
		Conflict c2 = new Conflict(d1,d3);
		Assert.assertEquals(1,c2.getOverlapDancers().size());
		Assert.assertEquals("a1",c2.getOverlapDancers().get(0));

		//all overlap
		Conflict c3 = new Conflict(d2,d4);
		Assert.assertEquals(3,c3.getOverlapDancers().size());
		ArrayList<String> dancersList = new ArrayList<String>();
		for (int i = 0; i < dancers2.size(); i++) {
			dancersList.add(dancers2.get(i));
		}
		Assert.assertEquals(dancersList,c3.getOverlapDancers());
	}

	@Test
	public void testContainsOverlap() {

		ArrayList<String> dancers1 = new ArrayList<String>();
		dancers1.add("a1");
		dancers1.add("b1");
		dancers1.add("c1");
		Dance d1 = new Dance(dancers1,"dance1");

		ArrayList<String> dancers2 = new ArrayList<String>();
		dancers2.add("a2");
		dancers2.add("b2");
		dancers2.add("c2");
		Dance d2 = new Dance(dancers2,"dance2");

		ArrayList<String> dancers3 = new ArrayList<String>();
		dancers3.add("a1");
		dancers3.add("b2");
		dancers3.add("c2");
		Dance d3 = new Dance(dancers3,"dance3");

		ArrayList<String> dancers4 = new ArrayList<String>();
		dancers4.add("a2");
		dancers4.add("b2");
		dancers4.add("c2");
		Dance d4 = new Dance(dancers4,"dance4");

		// no overlap
		Assert.assertFalse(Conflict.containsOverlap(d1,d2));

		// one overlap
		Assert.assertTrue(Conflict.containsOverlap(d1,d3));

		//all overlap
		Assert.assertTrue(Conflict.containsOverlap(d2,d4));
	}

	@Test
	public void testEquals() {

		ArrayList<String> dancers1 = new ArrayList<String>();
		dancers1.add("a1");
		dancers1.add("b1");
		dancers1.add("c1");
		Dance d1 = new Dance(dancers1,"dance1");

		ArrayList<String> dancers2 = new ArrayList<String>();
		dancers2.add("a2");
		dancers2.add("b2");
		dancers2.add("c2");
		Dance d2 = new Dance(dancers2,"dance2");

		ArrayList<String> dancers3 = new ArrayList<String>();
		dancers3.add("a1");
		dancers3.add("b2");
		dancers3.add("c2");
		Dance d3 = new Dance(dancers3,"dance3");

		ArrayList<String> dancers4 = new ArrayList<String>();
		dancers4.add("a2");
		dancers4.add("b2");
		dancers4.add("c2");
		Dance d4 = new Dance(dancers4,"dance4");

		Conflict c1 = new Conflict(d1,d3);
		Conflict c2 = new Conflict(d1,d3);
		Conflict c3 = new Conflict(d2,d4);

		// reflexive
		Assert.assertTrue(c1.equals(c1));
		Assert.assertEquals(c1,c1);

		// equal
		Assert.assertTrue(c1.equals(c2));
		Assert.assertEquals(c1,c2);
		Assert.assertTrue(c2.equals(c1));
		Assert.assertEquals(c2,c1);

		// not equal
		Assert.assertFalse(c1.equals(c3));
		Assert.assertFalse(c3.equals(c1));
		Assert.assertFalse("hi".equals(c3));
		Assert.assertFalse(c3.equals("hi"));

	}

}