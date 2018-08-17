package run_order;

import org.junit.Test;
import org.junit.Assert;
import java.util.ArrayList;

public class RunOrderTest {

	@Test
	public void testRunOrder() {
		String[] dancers1 = {"a1","b1","c1"};
		Dance d1 = new Dance(dancers1,"dance1");

		String[] dancers2 = {"a2","b2","c2"};
		Dance d2 = new Dance(dancers2,"dance2");

		String[] dancers3 = {"a3","b3","c3"};
		Dance d3 = new Dance(dancers3,"dance3");

		Dance[] order = {d1,d2,d3};
		RunOrder r = new RunOrder(order);
	}

	@Test
	public void testFindConflicts() {
		String[] dancers1 = {"a1","b1","c1"};
		Dance d1 = new Dance(dancers1,"dance1");
		String[] dancers2 = {"a2","b2","c2"};
		Dance d2 = new Dance(dancers2,"dance2");
		String[] dancers3 = {"a3","b3","c3"};
		Dance d3 = new Dance(dancers3,"dance3");
		String[] dancers4 = {"a1"};
		Dance d4 = new Dance(dancers4,"dance4");
		String[] dancers5 = {"b2"};
		Dance d5 = new Dance(dancers5,"dance5");
		String[] dancers6 = {"c3"};
		Dance d6 = new Dance(dancers6,"dance6");

		// no conflicts
		Dance[] order1 = {d1,d2,d3};
		RunOrder r1 = new RunOrder(order1);
		ArrayList<Conflict> conflicts1 = r1.findConflicts();
		Assert.assertEquals(0,conflicts1.size());

		// beginning conflict
		Dance[] order2 = {d1,d2,d3};
		RunOrder r2 = new RunOrder(order2);
		ArrayList<Conflict> conflicts2 = r2.findConflicts();
		Assert.assertEquals(0,conflicts2.size());

		// end conflict


		// middle conflict

		// multiple conflicts

		// all conflicts


	}
}