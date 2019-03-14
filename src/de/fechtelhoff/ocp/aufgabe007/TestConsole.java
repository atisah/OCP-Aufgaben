package de.fechtelhoff.ocp.aufgabe007;

import java.io.Console;

/**
 * Aufgrund eines Bugs in Eclipse funktioniert der Reader über die Klasse Console nicht!!! </br>
 * Der Aufruf: <code>System.console()</code> liefert unter Eclipse immer <code>null</code>. </br>
 * Auf der Kommandozeile funktioniert der Reader einwandfrei! </br>
 * </br>
 * Ausführung durch Aufruf von: </br>
 * </br>
 * <code>java de.fechtelhoff.ocp.aufgabe007.TestConsole</code> </br>
 * </br>
 * von der Kommandozeile aus dem bin-Verzeichnis des Projektes!
 */
public class TestConsole {

	public static void main(String[] args) {
		System.out.println("\nStart\n");

		String input;
		Console console = System.console();

		if (console != null) {
			do {
				input = console.readLine();
				if (input.length() == 0) {
					break;
				} else {
					System.out.println(input + " (" + input.length() + ")\n");

				}
			} while (true);
		} else {
			System.out.println("Console ist nicht verfügbar!");
		}

		System.out.println("\nEnd\n");
	}
}
