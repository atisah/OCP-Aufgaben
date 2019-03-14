package de.fechtelhoff.ocp.aufgabe007;

import java.io.Console;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class AufgabeExceptionsParseDate {

	public static void main(String[] args) {
		System.out.println("\nStarts here ...\n");

		String dateAsString = null;
		LocalDate date = null;
		long days;
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

		do {
			System.out.println("Bitte gib ein Datum ein (dd.mm.yyyy): ");
			dateAsString = getUserInput();
			try {
				date = LocalDate.parse(dateAsString, dateTimeFormatter);
			} catch (DateTimeParseException ex) {
				System.out.println("\nFalsche Eingabe! Versuch es nochmal.");
			}
		} while (date == null);

		System.out.println();
		System.out.println(date.format(dateTimeFormatter));
		System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
		System.out.println();

		days = numberOfDaysTillNow(date);
		if (days == 0) {
			System.out.println("Das ist ja heute!");
		} else if (days > 0) {
			System.out.println("Das war vor " + (days == 1 ? "einem Tag" : formatDays(days) + " Tagen") + "!");
		} else /* if (days < 0) */ {
			System.out.println("Das ist in " + (days == 1 ? "einem Tag" : formatDays((-1) * days) + " Tagen") + "!");
		}

		System.out.println("\n...that's it!\n");
	}

	private static String formatDays(long days) {
		return String.format("%,d", days);
	}

	private static long numberOfDaysTillNow(LocalDate date) {
		return ChronoUnit.DAYS.between(date, LocalDate.now());
	}

	private static String getUserInput() {
		return getUserInputUsingScanner();
	}

	private static String getUserInputUsingScanner() {
		String input = null;
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			input = scanner.nextLine();
			input = replaceCommaWithDot(input);
		} catch (Exception ex) {
			System.out.println("Problem beim Lesen von der Console!");
			ex.getStackTrace();
		}
		return input;
	}

	/**
	 * Aufgrund eines Bugs in Eclipse funktioniert der Reader über die Klasse
	 * Console nicht!!! </br>
	 * </br>
	 * Der Aufruf: <code>System.console()</code> liefert unter Eclipse immer
	 * <code>null</code>. </br>
	 * </br>
	 * Auf der Kommandozeile funktioniert der Reader einwandfrei!
	 */
	private static String getUserInputUsingConsole() {
		String input = null;
		Console console = System.console();
		if (console != null) {
			input = console.readLine();
			input = replaceCommaWithDot(input);
		}
		return input;
	}

	private static String replaceCommaWithDot(String input) {
		return input.replaceAll(",", ".");
	}
}
