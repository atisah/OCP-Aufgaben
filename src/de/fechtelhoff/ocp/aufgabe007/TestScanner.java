package de.fechtelhoff.ocp.aufgabe007;

import java.util.Scanner;

/**
 * Ausführung durch Aufruf von: </br>
 * </br>
 * <code>java de.fechtelhoff.ocp.aufgabe007.TestScanner</code> </br>
 * </br>
 * von der Kommandozeile aus dem bin-Verzeichnis des Projektes! </br>
 *
 */
public class TestScanner {

	public static void main(String[] args) {
		System.out.println("\nStart\n");

		String input;
		Scanner scanner = new Scanner(System.in);

		if (scanner != null) {
			do {
				input = scanner.nextLine();
				if (input.length() == 0) {
					break;
				} else {
					System.out.println(input + " (" + input.length() + ")\n");

				}
			} while (true);
		}
		scanner.close();

		System.out.println("\nEnd\n");
	}
}
