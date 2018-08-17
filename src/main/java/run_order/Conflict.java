package run_order;

import java.lang.*;
import java.util.ArrayList;

public abstract class Conflict {
	private Dance dance1;
	private Dance dance2;

	public Conflict(Dance d1, Dance d2) {
		dance1 = d1;
		dance2 = d2;
	}

	public Dance getDance1() {
		return dance1;
	}

	public Dance getDance2() {
		return dance2;
	}
}

class DancerConflict extends Conflict {
	private ArrayList<String> overlapDancers;

	public DancerConflict(Dance d1, Dance d2) {
		super(d1,d2);
		overlapDancers = null;
	}

	public ArrayList<String> getOverlapDancers() {
		if (overlapDancers != null) {
			return overlapDancers;
		}
		overlapDancers = getOverlapHelper(getDance1(),getDance2());
		return overlapDancers;
	}

	public static ArrayList<String> getOverlapHelper(Dance d1, Dance d2) {
		ArrayList<String> overlap = new ArrayList<String>();
		for (int i = 0; i < d1.getDancers().length; i++) {
			for (int j = 0; j < d2.getDancers().length; j++) {
				if (d1.getDancers()[i].equals(d2.getDancers()[j])) {
					overlap.add(d1.getDancers()[i]);
				}
			}
		}
		return overlap;
	}

	public static boolean containsOverlap(Dance d1, Dance d2) {
		ArrayList<String> overlap = getOverlapHelper(d1,d2);
		if (overlap.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof DancerConflict)) {
			return false;
		}

		DancerConflict c = (DancerConflict) o;
		return (getDance1().equals(c.getDance1()) && getDance2().equals(c.getDance2()));
	}
}