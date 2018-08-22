package run_order;

import org.junit.Test;
import org.junit.Assert;
import java.util.ArrayList;

public class RunOrderTest {

	@Test
	public void testRunOrder() {
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
		dancers3.add("a3");
		dancers3.add("b3");
		dancers3.add("c3");
		Dance d3 = new Dance(dancers3,"dance3");

		Dance[] order = {d1,d2,d3};
		RunOrder r = new RunOrder(order);
	}

	@Test
	public void testFindConflicts() {
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
		dancers3.add("a3");
		dancers3.add("b3");
		dancers3.add("c3");
		Dance d3 = new Dance(dancers3,"dance3");

		ArrayList<String> dancers4 = new ArrayList<String>();
		dancers4.add("a1");
		Dance d4 = new Dance(dancers4,"dance4");

		ArrayList<String> dancers5 = new ArrayList<String>();
		dancers5.add("b2");
		Dance d5 = new Dance(dancers5,"dance5");

		ArrayList<String> dancers6 = new ArrayList<String>();
		dancers6.add("c3");
		Dance d6 = new Dance(dancers6,"dance6");

		ArrayList<String> dancers7 = new ArrayList<String>();
		dancers7.add("a1");
		dancers7.add("b1");
		dancers7.add("b2");
		Dance d7 = new Dance(dancers7,"dance7");

		// no conflicts
		Dance[] order1 = {d1,d2,d3};
		RunOrder r1 = new RunOrder(order1);
		ArrayList<Conflict> conflicts1 = r1.findConflicts();
		Assert.assertEquals(0,conflicts1.size());

		// beginning conflict
		Dance[] order2 = {d1,d4,d2,d3};
		RunOrder r2 = new RunOrder(order2);
		ArrayList<Conflict> conflicts2 = r2.findConflicts();
		Assert.assertEquals(1,conflicts2.size());
		Assert.assertEquals(d1,conflicts2.get(0).getDance1());
		Assert.assertEquals(d4,conflicts2.get(0).getDance2());
		Assert.assertEquals(1,conflicts2.get(0).getOverlapDancers().size());
		Assert.assertEquals("a1",conflicts2.get(0).getOverlapDancers().get(0));

		// end conflict
		Dance[] order3 = {d1,d2,d3,d6};
		RunOrder r3 = new RunOrder(order3);
		ArrayList<Conflict> conflicts3 = r3.findConflicts();
		Assert.assertEquals(1,conflicts3.size());
		Assert.assertEquals(d3,conflicts3.get(0).getDance1());
		Assert.assertEquals(d6,conflicts3.get(0).getDance2());
		Assert.assertEquals(1,conflicts3.get(0).getOverlapDancers().size());
		Assert.assertEquals("c3",conflicts3.get(0).getOverlapDancers().get(0));

		// middle conflict
		Dance[] order4 = {d1,d2,d5,d3};
		RunOrder r4 = new RunOrder(order4);
		ArrayList<Conflict> conflicts4 = r4.findConflicts();
		Assert.assertEquals(1,conflicts4.size());
		Assert.assertEquals(d2,conflicts4.get(0).getDance1());
		Assert.assertEquals(d5,conflicts4.get(0).getDance2());
		Assert.assertEquals(1,conflicts4.get(0).getOverlapDancers().size());
		Assert.assertEquals("b2",conflicts4.get(0).getOverlapDancers().get(0));

		// multiple conflicts, multiple dancers
		Dance[] order5 = {d1,d7,d2,d3,d6};
		RunOrder r5 = new RunOrder(order5);
		ArrayList<Conflict> conflicts5 = r5.findConflicts();
		Assert.assertEquals(3,conflicts5.size());
		// d1,d7
		Assert.assertEquals(d1,conflicts5.get(0).getDance1());
		Assert.assertEquals(d7,conflicts5.get(0).getDance2());
		Assert.assertEquals(2,conflicts5.get(0).getOverlapDancers().size());
		ArrayList<String> overlap = new ArrayList<String>();
		overlap.add("a1");
		overlap.add("b1");
		Assert.assertEquals(overlap,conflicts5.get(0).getOverlapDancers());
		// d7,d2
		Assert.assertEquals(d7,conflicts5.get(1).getDance1());
		Assert.assertEquals(d2,conflicts5.get(1).getDance2());
		Assert.assertEquals(1,conflicts5.get(1).getOverlapDancers().size());
		Assert.assertEquals("b2",conflicts5.get(1).getOverlapDancers().get(0));
		// d3,d6
		Assert.assertEquals(d3,conflicts5.get(2).getDance1());
		Assert.assertEquals(d6,conflicts5.get(2).getDance2());
		Assert.assertEquals(1,conflicts5.get(2).getOverlapDancers().size());
		Assert.assertEquals("c3",conflicts5.get(2).getOverlapDancers().get(0));

	}

	@Test
	public void testFindOptimal() {
		// TODO: implement
	}
}