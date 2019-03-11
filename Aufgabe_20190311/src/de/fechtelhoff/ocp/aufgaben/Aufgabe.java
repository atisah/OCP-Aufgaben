package de.fechtelhoff.ocp.aufgaben;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Person implements Comparable<Person> {
	static private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

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
			setGeburtsjahr(LocalDate.parse(geburtsjahr, dateTimeFormatter));
		} catch (Exception e) {
			setGeburtsjahr(null);
		}		
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
		return vorname + " " + nachname + ((geburtsjahr != null) ? ", *" + geburtsjahr.format(dateTimeFormatter) : "");
	}

	@Override
	public int compareTo(Person that) {
		int result = this.nachname.compareTo(that.nachname);
		if (result == 0) {
			result = this.vorname.compareTo(that.vorname);
		}
		if (result == 0) {
			if ((this.getGeburtsjahr() != null) && (that.getGeburtsjahr() != null)) {
				result = Period.between(that.getGeburtsjahr(), this.getGeburtsjahr()).getDays();
			}
		}
		return result;
	}
}

class PersonReverseComparator implements Comparator<Person> {
	@Override
	public int compare(Person p1, Person p2) {
		return p2.compareTo(p1);
	}
}

public class Aufgabe {
	public static Person searchForPerson;

	public static void main(String[] args) {
		System.out.println("\nStarts here ...\n");

		// Speichern Sie in einem Array vier Personen (keine Strings).
		Person[] personenArray = {
				new Person("Paul", "Smith"),
				new Person("Paul", "Black"),
				new Person("John", "Smith"),
				new Person("John", "Black"),
				new Person("John", "Black"),
				new Person("John", "Smith"),
		};

		// Optional: ein weiteres Attribut 'geburtsjahr' in der Klasse 'Person' definieren
		// und bei der Sortierung berücksichtigen, falls die Nachnamen und Vornamen gleich sind.
		Person[] personenArrayWithBirthday = {
				new Person("Paul", "Smith", "01.01.1970"),
				new Person("Paul", "Black", "11.09.2001"),
				new Person("John", "Smith", "10.10.1995"),
				new Person("John", "Black", "03.02.1982"),
				new Person("John", "Black", "02.02.1982"),
				new Person("John", "Smith", "07.03.2019"),
		};
				
		personenArray = personenArrayWithBirthday;

		// Geben Sie den Inhalt des Arrays auf der Konsole aus.
		System.out.println("Unsortiertes Array auf der Konsole ausgeben");
		printArray(personenArray);

		// Sortieren Sie das Array mit Hilfe der Methode `java.util.Arrays.sort(Object[])`.
		// Dabei müssen die Personen nach dem Nachnamen und bei gleichen Nachnamen nach dem Vornamen verglichen werden.
		// Geben Sie erneut den Inhalt des Arrays auf der Konsole aus.
		System.out.println("Array aufsteigend sortieren");
		ascendingSort(personenArray);

		// Das Array bitte absteigend sortieren und ausgeben.
		System.out.println("Array absteigend sortieren");
		descendingSort(personenArray);

		// Variante zum absteigend Sortieren.
		System.out.println("Array absteigend sortieren (zweite Variante)");
		ascendingSort(personenArray);

		System.out.println("Absteigend Sortiert!");
		Arrays.sort(personenArray, new PersonReverseComparator());
		printArray(personenArray);
		
		// Suchen Sie in dem aufsteigend sortiertem Array nach der Person 'John Black'
		System.out.println("Suchen im aufsteigend sortierten Array");
		ascendingSort(personenArray);
		searchForPerson = new Person("John", "Black");
		System.out.println("Index of \"John Black:\" = " + Arrays.binarySearch(personenArray, searchForPerson) + "\n");
		
		// Suchen Sie in dem absteigend sortiertem Array nach der Person 'John Smith'
		System.out.println("Suchen im absteigend sortierten Array");
		descendingSort(personenArray);
		searchForPerson = new Person("John", "Smith");
		System.out.println("Index of \"John Smith:\" = " + Arrays.binarySearch(personenArray, searchForPerson) + "\n");
		System.out.println("Index of \"John Smith:\" = " + Arrays.binarySearch(personenArray, searchForPerson, new PersonReverseComparator()) + "\n");
		searchForPerson = new Person("John", "Smith", "07.03.2019");
		System.out.println("Index of \"John Smith, 07.03.2019:\" = " + Arrays.binarySearch(personenArray, searchForPerson) + "\n");
		System.out.println("Index of \"John Smith, 07.03.2019:\" = " + Arrays.binarySearch(personenArray, searchForPerson, new PersonReverseComparator()) + "\n");
		
		System.out.println("... that's it!\n");
	}

	public static void printArray(Object[] array) {
		for (Object element : array) {
			System.out.println(element);
		}
		System.out.println();
	}
	
	public static void ascendingSort(Object[] array) {
		System.out.println("Aufsteigend Sortiert!");
		Arrays.sort(array);
		printArray(array);
	}

	public static void descendingSort(Object[] array) {
		System.out.println("Absteigend Sortiert!");
		Arrays.sort(array, Collections.reverseOrder());
		printArray(array);
	}
}
