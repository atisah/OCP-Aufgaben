package de.fechtelhoff.ocp.aufgabe006;

enum Hunderasse {
	DACKEL(0.5), COLLIE(1.0), DOGGE(1.5);

	private final double MAX_GROESSE;

	Hunderasse(double groesse) {
		this.MAX_GROESSE = groesse;
	}

	public double getMaxGroesse() {
		return MAX_GROESSE;
	}

	@Override
	public String toString() {
		return name().charAt(0) + name().substring(1).toLowerCase() + ", max. Größe: " + MAX_GROESSE;
	}
}

public class AufgabeEnumsHunderassen {

	public static void main(String[] args) {
		System.out.println("\nStarts here ...\n");

		for (Hunderasse hund : Hunderasse.values()) {
			System.out.println(hund);
		}

		System.out.println("\n...that's it!\n");
	}
}
