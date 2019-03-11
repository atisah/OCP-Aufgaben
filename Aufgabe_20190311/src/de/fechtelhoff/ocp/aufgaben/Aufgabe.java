package de.fechtelhoff.ocp.aufgaben;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

class Person {
	static private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
	
	public String vorname;
	public String nachname;
	public LocalDate geburtsjahr;

	public Person(String vorname, String nachname) {
		this.vorname = vorname;
		this.nachname = nachname;
	}

	public Person(String vorname, String nachname, LocalDate geburtsjahr) {
		this(vorname, nachname);
		this.geburtsjahr = geburtsjahr;
	}

	public Person(String vorname, String nachname, String geburtsjahr) {
		this(vorname, nachname, LocalDate.parse(geburtsjahr, dateTimeFormatter)); 
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public LocalDate getGeburtsjahr() {
		return geburtsjahr;
	}

	public void setGeburtsjahr(LocalDate geburtsjahr) {
		this.geburtsjahr = geburtsjahr;
	}

	@Override
	public String toString() {
		return vorname + " " + nachname + ((geburtsjahr != null) ? ", *" + geburtsjahr.format(dateTimeFormatter): "" );
	}
}

public class Aufgabe {

	public static void main(String[] args) {
		System.out.println("\nStarts here ...\n");

		Person[] personenArray = {
				new Person("Paul", "Smith", "01.01.1970"),
				new Person("Paul", "Black", "11.09.2001"),
				new Person("John", "Smith", "10.10.1995"),
				new Person("John", "Black", "02.02.1982")
		};

		printArray(personenArray);
		System.out.println();
		
//		Arrays.sort(personenArray);
//		System.out.println(Arrays.toString(personenArray));
		
		System.out.println("\n... that's it!\n");
	}

	public static void printArray(Object[] array) {
		for (Object element : array) {
			System.out.println(element);
		}
	}
	
}
