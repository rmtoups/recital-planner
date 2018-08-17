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
		
	}
}