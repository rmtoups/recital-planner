package run_order;

import java.lang.*;

public class Dance {
	private String[] dancers;
	private String title;

	Dance(String[] d, String t) {
		dancers = d;
		title = t;
	}

	public String[] getDancers() {
		return dancers;
	}

	public String getTitle() {
		return title;
	}
}