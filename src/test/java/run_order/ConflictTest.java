package run_order;

import org.junit.Test;
import org.junit.Assert;

public class ConflictTest {

	@Test
	public void testDancerConflict() {
		String[] dances = {"a1","b1","c1"};
		String[] dancers = {"a2","b2","c2"};
		Conflict c = new DancerConflict(dances,dancers);
		DancerConflict d = new DancerConflict(dances,dancers);
	}
}