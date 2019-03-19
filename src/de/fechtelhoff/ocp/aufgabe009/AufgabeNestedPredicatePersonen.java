package de.fechtelhoff.ocp.aufgabe009;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

class Person {
	private String vorname;
	private String nachname;
	private int geburtsjahr;

	public Person(String vorname, String nachname, int geburtsjahr) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.geburtsjahr = geburtsjahr;
	}

	public String getNachname() {
		return nachname;
	}

	public int getGeburtsjahr() {
		return geburtsjahr;
	}

	@Override
	public String toString() {
		return vorname + " " + nachname + ", " + geburtsjahr;
	}
}

class ToplevelFilterClass implements Predicate<Person> {
	private final int YEAR;

	public ToplevelFilterClass(int year) {
		this.YEAR = year;
	}

	@Override
	public boolean test(Person person) {
		return (person.getGeburtsjahr() > this.YEAR);
	}
}

public class AufgabeNestedPredicatePersonen {

	private static class InnerFilterClass implements Predicate<Person> {
		private final char LETTER;

		public InnerFilterClass(char letter) {
			this.LETTER = letter;
		}

		@Override
		public boolean test(Person person) {
			return person.getNachname().contains(String.valueOf(this.LETTER));
		}
	}

	public static void main(String[] args) {
		System.out.println("\nStarts here ...\n");

		class LocalFilterClass implements Predicate<Person> {
			private final int NUMBER;

			public LocalFilterClass(int number) {
				this.NUMBER = number;
			}

			@Override
			public boolean test(Person person) {
				return (person.getNachname().length() >= this.NUMBER);
			}
		}

		List<Person> personenListe;
		Person[] personenArray = new Person[4];

		// s. Wikipedia -> Liste der Bewohner Entenhausens
		personenArray[0] = new Person("Donal", "Duck", 1970);
		personenArray[1] = new Person("Micky", "Mouse", 1981);
		personenArray[2] = new Person("Gustav", "Gans", 1992);
		personenArray[3] = new Person("Daniel", "Düsentrieb", 2003);

		System.out.println("========== 0 ==========");
		printPersonenListe(Arrays.asList(personenArray));
		newLine();

		// 1. Toplevel-Klasse: nach einem bestimmten Jahr geboren
		System.out.println("========== 1 ==========");
		personenListe = filtern(personenArray, new ToplevelFilterClass(1990));
		printPersonenListe(personenListe);
		newLine();

		// 2. Innere Klasse: Nachname enthält mindestens ein 'a'
		System.out.println("========== 2 ==========");
		personenListe = filtern(personenArray, new InnerFilterClass('a'));
		printPersonenListe(personenListe);
		newLine();

		// 3. Lokale Klasse: Nachname ist mindestens 4 (5) Zeichen lang
		System.out.println("========== 3 ==========");
		personenListe = filtern(personenArray, new LocalFilterClass(5));
		printPersonenListe(personenListe);
		newLine();

		// 4. Anonyme Klasse: zwei weitere Filter (A und B)
		System.out.println("========= 4 a =========");
		personenListe = filtern(personenArray, new Predicate<Person>() {
			@Override
			public boolean test(Person person) {
				ToplevelFilterClass toplevelFilterClass = new ToplevelFilterClass(2000);
				InnerFilterClass innerClassFiler = new InnerFilterClass('s');
				LocalFilterClass localFilterClass = new LocalFilterClass(3);
				return toplevelFilterClass.test(person) && innerClassFiler.test(person) && localFilterClass.test(person);
			}
		});
		printPersonenListe(personenListe);
		newLine();

		// 4. Anonyme Klasse: zwei weitere Filter (A und B)
		System.out.println("========= 4 b =========");
		personenListe = filtern(personenArray, new Predicate<Person>() {
			@Override
			public boolean test(Person person) {
				return new ToplevelFilterClass(2000).test(person) && new InnerFilterClass('s').test(person) && new LocalFilterClass(3).test(person);
			}
		});
		printPersonenListe(personenListe);
		newLine();

		// 4. Anonyme Klasse: zwei weitere Filter (A und B)
		System.out.println("========= 4 c =========");
		personenListe = filtern(personenArray, new ToplevelFilterClass(2000).and(new InnerFilterClass('s')).and(new LocalFilterClass(3)));
		printPersonenListe(personenListe);
		newLine();

		// 5. Lamda-Funktion: in einem Schaltjahr geboren
		System.out.println("========== 5 ==========");
		personenListe = filtern(personenArray, person -> isLeapYear(person.getGeburtsjahr()));
		printPersonenListe(personenListe);
		newLine();

		// 6. mit Methoden-Referenz: in einem Schaltjahr geboren
		System.out.println("========== 6 ==========");
		personenListe = filtern(personenArray, AufgabeNestedPredicatePersonen::isBornInLeapYear);
		printPersonenListe(personenListe);

		System.out.println("\n...that's it!\n");
	}

	private static List<Person> filtern(Person[] personenArray, Predicate<Person> filter) {
		List<Person> personenListe = new ArrayList<>();
		for (Person person : personenArray) {
			if (filter.test(person)) {
				personenListe.add(person);
			}
		}
		if (personenListe.size() == 0) {
			personenListe = Collections.emptyList();
		}
		return personenListe;
	}

	private static void printPersonenListe(List<Person> personenListe) {
		for (Person person : personenListe) {
			System.out.println(person);
		}
	}

	private static boolean isBornInLeapYear(Person person) {
		return isLeapYear(person.getGeburtsjahr());
	}

	private static boolean isLeapYear(int year) {
		class Number {
			private final int NUMBER;

			public Number(int number) {
				this.NUMBER = number;
			}

			public boolean isDivisibleBy(int divider) {
				return (this.NUMBER % divider) == 0;
			}
		}

		Number number = new Number(year);

		if (number.isDivisibleBy(400)) {
			return true;
		} else if (number.isDivisibleBy(4) && (!number.isDivisibleBy(100))) {
			return true;
		}
		return false;
	}

	private static void newLine() {
		System.out.println();
	}
}
