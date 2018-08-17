package run_order;

import org.junit.Test;
import org.junit.Assert;
import java.util.ArrayList;

public class ConflictTest {

/*************************************************
 *		Test DancerConflict class
 *************************************************/

	@Test
	public void testDancerConflict() {
		String[] dancers1 = {"a1","b1","c1"};
		Dance d1 = new Dance(dancers1,"dance1");
		String[] dancers2 = {"a2","b2","c2"};
		Dance d2 = new Dance(dancers2,"dance2");

		Conflict c = new DancerConflict(d1,d2);
		DancerConflict d = new DancerConflict(d1,d2);
	}

	@Test
	public void testGetDances() {
		String[] dancers1 = {"a1","b1","c1"};
		Dance d1 = new Dance(dancers1,"dance1");
		String[] dancers2 = {"a2","b2","c2"};
		Dance d2 = new Dance(dancers2,"dance2");

		Conflict c = new DancerConflict(d1,d2);
		Assert.assertEquals(d1,c.getDance1());
		Assert.assertEquals(d2,c.getDance2());
	}

	@Test
	public void testGetOverlapDancers() {
		String[] dancers1 = {"a1","b1","c1"};
		Dance d1 = new Dance(dancers1,"dance1");
		String[] dancers2 = {"a2","b2","c2"};
		Dance d2 = new Dance(dancers2,"dance2");
		String[] dancers3 = {"a1","b2","c2"};
		Dance d3 = new Dance(dancers3,"dance3");
		String[] dancers4 = {"a2","b2","c2"};
		Dance d4 = new Dance(dancers4,"dance4");

		// no overlap
		DancerConflict c1 = new DancerConflict(d1,d2);
		Assert.assertEquals(0,c1.getOverlapDancers().size());

		// one overlap
		DancerConflict c2 = new DancerConflict(d1,d3);
		Assert.assertEquals(1,c2.getOverlapDancers().size());
		Assert.assertEquals("a1",c2.getOverlapDancers().get(0));

		//all overlap
		DancerConflict c3 = new DancerConflict(d2,d4);
		Assert.assertEquals(3,c3.getOverlapDancers().size());
		ArrayList<String> dancersList = new ArrayList<String>();
		for (int i = 0; i < dancers2.length; i++) {
			dancersList.add(dancers2[i]);
		}
		Assert.assertEquals(dancersList,c3.getOverlapDancers());
	}

	@Test
	public void testContainsOverlap() {
		String[] dancers1 = {"a1","b1","c1"};
		Dance d1 = new Dance(dancers1,"dance1");
		String[] dancers2 = {"a2","b2","c2"};
		Dance d2 = new Dance(dancers2,"dance2");
		String[] dancers3 = {"a1","b2","c2"};
		Dance d3 = new Dance(dancers3,"dance3");
		String[] dancers4 = {"a2","b2","c2"};
		Dance d4 = new Dance(dancers4,"dance4");

		// no overlap
		Assert.assertFalse(DancerConflict.containsOverlap(d1,d2));

		// one overlap
		Assert.assertTrue(DancerConflict.containsOverlap(d1,d3));

		//all overlap
		Assert.assertTrue(DancerConflict.containsOverlap(d2,d4));
	}

	@Test
	public void testEquals() {

		String[] dancers1 = {"a1","b1","c1"};
		Dance d1 = new Dance(dancers1,"dance1");
		String[] dancers2 = {"a2","b2","c2"};
		Dance d2 = new Dance(dancers2,"dance2");
		String[] dancers3 = {"a1","b2","c2"};
		Dance d3 = new Dance(dancers3,"dance3");
		String[] dancers4 = {"a2","b2","c2"};
		Dance d4 = new Dance(dancers4,"dance4");

		DancerConflict c1 = new DancerConflict(d1,d3);
		DancerConflict c2 = new DancerConflict(d1,d3);
		DancerConflict c3 = new DancerConflict(d2,d4);

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