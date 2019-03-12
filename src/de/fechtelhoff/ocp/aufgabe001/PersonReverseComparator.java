package de.fechtelhoff.ocp.aufgabe001;

import java.util.Comparator;

public class PersonReverseComparator implements Comparator<Person> {
	@Override
	public int compare(Person p1, Person p2) {
		return p2.compareTo(p1);
	}
}