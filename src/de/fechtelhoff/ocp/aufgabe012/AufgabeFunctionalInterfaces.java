package de.fechtelhoff.ocp.aufgabe012;

import java.io.IOException;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class AufgabeFunctionalInterfaces {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("\nStart here ...\n");

		String testString;

		/*
		 * 1. checkString soll einen String auf null überprüfen. Wenn der übergebene
		 * String null ist, wirft die Methode eine IllegalArgumentException
		 */
		System.out.println("========== 1 ==========");

		System.out.println("--> Test 1.1");
		testString = null;
		try {
			testString = checkString("Test the West!");
		} catch (IllegalArgumentException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		System.out.println("Test String: " + testString);
		newLine();

		System.out.println("--> Test 1.2");
		testString = null;
		try {
			testString = checkString(null);
		} catch (IllegalArgumentException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		System.out.println("Test String: " + testString);
		newLine();

		/*
		 * 2. checkString soll einen String überprüfen. Wenn der übergebene String die
		 * Prüfung nicht besteht, wirft die Methode eine IllegalArgumentException. Die
		 * Logik der Überprüfung bekommt die Methode mit einem Predicate übergeben.
		 */
		System.out.println("========== 2 ==========");

		System.out.println("--> Test 2.1");
		testString = null;
		try {
			testString = checkString("Test the West!", s -> s.length() > 0);
		} catch (IllegalArgumentException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		System.out.println("Test String: " + testString);
		newLine();

		System.out.println("--> Test 2.2");
		testString = null;
		try {
			testString = checkString("", s -> s.length() > 0);
		} catch (IllegalArgumentException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		System.out.println("Test String: " + testString);
		newLine();

		System.out.println("--> Test 2.3");
		testString = null;
		try {
			testString = checkString(null, s -> s.length() > 0);
		} catch (IllegalArgumentException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		System.out.println("Test String: " + testString);
		newLine();

		/*
		 * 3. checkString soll einen String überprüfen. Wenn der übergebene String die
		 * Prüfung nicht besteht, wirft die Methode eine IllegalArgumentException. Die
		 * Logik der Überprüfung bekommt die Methode mit einem Predicate übergeben. Die
		 * evtl. zu werfende Exception (das Exception-Objekt durch seine Referenz)
		 * bekommt die Methode auch übergeben.
		 */
		System.out.println("========== 3 ==========");

		System.out.println("--> Test 3.1");
		testString = null;
		try {
			testString = checkString("Was soll das!", s -> s.length() > 0, new IllegalArgumentException("Was soll das Exception!"));
		} catch (RuntimeException e) {
			System.out.println("RuntimeException: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		System.out.println("Test String: " + testString);
		newLine();

		System.out.println("--> Test 3.2");
		testString = null;
		try {
			testString = checkString("", s -> s.length() > 0, new NullPointerException("Was soll das Exception!"));
		} catch (RuntimeException e) {
			System.out.println("RuntimeException: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		System.out.println("Test String: " + testString);
		newLine();

		System.out.println("--> Test 3.3");
		testString = null;
		try {
			testString = checkString(null, s -> s.length() > 0, new IOException("Was soll das Exception!"));
		} catch (RuntimeException e) {
			System.out.println("RuntimeException: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		System.out.println("Test String: " + testString);
		newLine();

		/*
		 * 4. checkString soll einen String überprüfen. Wenn der übergebene String die
		 * Prüfung nicht besteht, wirft die Methode eine IllegalArgumentException. Die
		 * Logik der Überprüfung bekommt die Methode mit einem Predicate übergeben. Die
		 * evtl. zu werfende EException bekommt diech checkString mithilfe des Supplier,
		 * der auch an die Methode übergeben wird.
		 */
		System.out.println("========== 4 ==========");

		Supplier<Exception> exceptionSupplier = () -> new NullPointerException("Darf nicht null sein!");

		System.out.println("--> Test 4.1");
		testString = null;
		try {
			testString = checkString("Was soll das!", s -> s.length() > 0, exceptionSupplier);
		} catch (RuntimeException e) {
			System.out.println("RuntimeException: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		System.out.println("Test String: " + testString);
		newLine();

		System.out.println("--> Test 4.2");
		testString = null;
		try {
			testString = checkString("", s -> s.length() > 0, exceptionSupplier);
		} catch (RuntimeException e) {
			System.out.println("RuntimeException: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		System.out.println("Test String: " + testString);
		newLine();

		System.out.println("--> Test 4.3");
		testString = null;
		try {
			testString = checkString(null, s -> s.length() > 0, exceptionSupplier);
		} catch (RuntimeException e) {
			System.out.println("RuntimeException: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		System.out.println("Test String: " + testString);
		newLine();

		/*
		 * 5. Optional: mit Function exFunction die evtl. zu werfende Exception bilden.
		 */
//		checkString(s, testLogik, exFunction, "String ist null!");
		

		System.out.println("\n...that's it!\n");
	}

	
	
	// Aufgabe 4
	public static String checkString(String s, Predicate<String> test, Supplier<Exception> supplier) throws Exception {
		if ((s == null) || (test.test(s) == false)) {
			throw supplier.get();
		}
		return s;
	}

	// Aufgabe 3
	public static String checkString(String s, Predicate<String> test, Exception exc) throws Exception {
		if ((s == null) || (test.test(s) == false)) {
			throw exc;
		}
		return s;
	}

	// Aufgabe 2
	public static String checkString(String s, Predicate<String> test) {
		if ((s == null) || (test.test(s) == false)) {
			throw new IllegalArgumentException("Der String erfüllt die Anforderungen nicht!");
		}
		return s;
	}

	// Aufgabe 1
	public static String checkString(String s) {
		if (s == null) {
			throw new IllegalArgumentException("Der String darf nicht \"null\" sein!");
		}
		return s;
	}

	public static void newLine() {
		System.out.println();
	}
}
