package diosoft.com;

import java.util.Comparator;

public class Compar implements Comparator<Person> {

	@Override
	public int compare(Person arg0, Person arg1) {
		if (arg0.equals(arg1)) return 1;
		return 0;
	}

}
