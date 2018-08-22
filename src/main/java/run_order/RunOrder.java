package run_order;

import java.lang.*;
import java.util.ArrayList;

public class RunOrder {
	private Dance[] order;

	public RunOrder(Dance[] o) {
		order = o;
	}

	public ArrayList<Conflict> findConflicts() {
		ArrayList<Conflict> conflicts = new ArrayList<Conflict>();
		for (int i = 0; i < order.length - 1; i++) {
			if (Conflict.containsOverlap(order[i],order[i+1])){
				conflicts.add(new Conflict(order[i],order[i+1]));
			}
		}
		return conflicts;
	}

	public Dance[] findOptimal() {
		// TODO: implement this much later
		throw new UnsupportedOperationException("Method not yet implemented");
	}
}

//throw new UnsupportedOperationException("Method not yet implemented.");