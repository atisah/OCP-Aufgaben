package de.fechtelhoff.ocp.aufgabe001;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person implements Comparable<Person> {
	static private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

	private String vorname;
	private String nachname;
	private LocalDate geburtsjahr;

	public Person(String vorname, String nachname) {
		this.vorname = vorname;
		this.nachname = nachname;
	}

	public Person(String vorname, String nachname, LocalDate geburtsjahr) {
		this(vorname, nachname);
		this.geburtsjahr = geburtsjahr;
	}

	public Person(String vorname, String nachname, String geburtsjahr) {
		this(vorname, nachname);
		try {
			this.geburtsjahr = LocalDate.parse(geburtsjahr, dateFormatter);
		} catch (Exception e) {
			this.geburtsjahr = null;
		}
	}

	@Override
	public String toString() {
		return nachname + ", " + vorname + ((geburtsjahr != null) ? ", *" + geburtsjahr.format(dateFormatter) : "");
	}

	@Override
	public int compareTo(Person that) {
		int result = this.nachname.compareTo(that.nachname);
		if (result == 0) {
			result = this.vorname.compareTo(that.vorname);
		}
		if (result == 0) {
			if ((this.geburtsjahr != null) && (that.geburtsjahr != null)) {
				result = Period.between(that.geburtsjahr, this.geburtsjahr).getDays();
			}
		}
		return result;
	}
}
