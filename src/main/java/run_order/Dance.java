package run_order;

import java.lang.*;
import java.util.Arrays;

public class Dance {
	private String[] dancers;
	private String title;

	public Dance(String[] d, String t) {
		dancers = d;
		Arrays.sort(dancers);
		title = t;
	}

	public String[] getDancers() {
		return dancers;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof Dance)) {
			return false;
		}

		Dance d = (Dance) o;
		return (dancers.equals(d.getDancers()) && title.equals(d.getTitle()));
	}
}