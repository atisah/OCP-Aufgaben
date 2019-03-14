package de.fechtelhoff.ocp.aufgabe001;

import java.util.Arrays;
import java.util.Comparator;

public class AufgabeInterfacesComparableComparator {
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

		// Optional: ein weiteres Attribut 'geburtsjahr' in der Klasse 'Person'
		// definieren
		// und bei der Sortierung berücksichtigen, falls die Nachnamen und Vornamen
		// gleich sind.
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

		// Sortieren Sie das Array mit Hilfe der Methode
		// `java.util.Arrays.sort(Object[])`.
		// Dabei müssen die Personen nach dem Nachnamen und bei gleichen Nachnamen nach
		// dem Vornamen verglichen werden.
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
		System.out.println("Index of \"John Black:\" = " + Arrays.binarySearch(personenArray, searchForPerson, new PersonReverseComparator()) + "\n");

		// Suchen Sie in dem absteigend sortiertem Array nach der Person 'John Smith'
		Comparator<Person> cmp = Comparator.reverseOrder();
		System.out.println("Suchen im absteigend sortierten Array");
		descendingSort(personenArray);
		searchForPerson = new Person("John", "Smith");
		System.out.println("Falsch! Index of \"John Smith:\" = " + Arrays.binarySearch(personenArray, searchForPerson) + "\n");
		System.out.println("Index of \"John Smith:\" = " + Arrays.binarySearch(personenArray, searchForPerson, new PersonReverseComparator()) + "\n");
		System.out.println("Index of \"John Smith:\" = " + Arrays.binarySearch(personenArray, searchForPerson, cmp) + "\n");
		searchForPerson = new Person("John", "Smith", "07.03.2019");
		System.out.println("Falsch! Index of \"John Smith, 07.03.2019:\" = " + Arrays.binarySearch(personenArray, searchForPerson) + "\n");
		System.out.println("Index of \"John Smith, 07.03.2019:\" = " + Arrays.binarySearch(personenArray, searchForPerson, new PersonReverseComparator()) + "\n");
		System.out.println("Index of \"John Smith, 07.03.2019:\" = " + Arrays.binarySearch(personenArray, searchForPerson, cmp) + "\n");

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

	public static void descendingSort(Person[] array) {
		System.out.println("Absteigend Sortiert!");
		Comparator<Person> cmp = Comparator.reverseOrder();
		Arrays.sort(array, cmp);
		printArray(array);
	}
}
