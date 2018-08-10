package run_order;

import java.lang.*;

public abstract class Conflict {
	private String[] relevantDances;

	public Conflict(String[] dances) {
		relevantDances = dances;
	}

	public String[] getRelevantDances() {
		throw new UnsupportedOperationException("method not yet implemented");
	}
}

class DancerConflict extends Conflict {
	private String[] overlapDancers;

	public DancerConflict(String[] dances, String[] dancers) {
		super(dances);
		overlapDancers = dancers;
	}

	public String[] getOverlapDancers() {
		throw new UnsupportedOperationException("method not yet implemented");
	}
}