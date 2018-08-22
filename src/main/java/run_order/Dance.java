package run_order;

import java.lang.*;
import java.util.ArrayList;
import java.util.Collections;

public class Dance {
	private ArrayList<String> dancers;
	private String title;

	public Dance(String t) {
		dancers = new ArrayList<String>();
		title = t;
	}

	public Dance(ArrayList<String> d, String t) {
		dancers = d;
		title = t;
	}

	public ArrayList<String> getDancers() {
		Collections.sort(dancers);
		return dancers;
	}

	public void addDancer(String name) {
		dancers.add(name);
	}

	public boolean removeDancer(String name) {
		return dancers.remove(name);
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