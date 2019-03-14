package de.fechtelhoff.ocp.aufgabe005;

import java.util.Arrays;
import java.util.Comparator;

enum EnumOS {
	UNIX, WINDOWS, MAC
}

class ClassOSReverseComparator implements Comparator<ClassOS> {
	@Override
	public int compare(ClassOS o1, ClassOS o2) {
		return o2.compareTo(o1);
	}
}

class ClassOS implements Comparable<ClassOS> {
	private String name;
	private int ordinal;

	public static final ClassOS UNIX = new ClassOS("UNIX", 0);
	public static final ClassOS WINDOWS = new ClassOS("WINDOWS", 1);
	public static final ClassOS MAC = new ClassOS("MAC", 2);

	private ClassOS(String name, int ordinal) {
		this.name = name;
		this.ordinal = ordinal;
	}

	public static ClassOS[] values() {
		return new ClassOS[] { UNIX, WINDOWS, MAC };
	}

	public int ordinal() {
		return ordinal;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(ClassOS that) {
		return this.ordinal - that.ordinal;
	}
}

public class KleineOSAufgabe {

	public static void main(String[] args) {
		System.out.println("\nStarts here ...\n");

		int counter = 1;

		// Aufgabe 1
		System.out.println("-----> Aufgabe " + counter++);
		System.out.println();

		// Aufgabe 2
		System.out.println("-----> Aufgabe " + counter++);
		for (EnumOS os : EnumOS.values()) {
			System.out.println(os);
		}
		System.out.println();

		// Aufgabe 3
		System.out.println("-----> Aufgabe " + counter++);
		for (ClassOS os : ClassOS.values()) {
			System.out.println(os);
		}
		System.out.println();

		// Aufgabe 4
		System.out.println("-----> Aufgabe " + counter++);
		for (EnumOS os : EnumOS.values()) {
			System.out.println(os + " = " + os.ordinal());
		}
		System.out.println();

		// Aufgabe 5
		System.out.println("-----> Aufgabe " + counter++);
		for (ClassOS os : ClassOS.values()) {
			System.out.println(os + " = " + os.ordinal());
		}
		System.out.println();

		// Aufgabe 6
		System.out.println("-----> Aufgabe " + counter++);
		EnumOS[] osArrayEnums = EnumOS.values();
		Arrays.sort(osArrayEnums, Comparator.reverseOrder());
		for (EnumOS os : Arrays.asList(osArrayEnums)) {
			System.out.println(os + " = " + os.ordinal());
		}
		System.out.println();

		// Aufgabe 7
		System.out.println("-----> Aufgabe " + counter++);
		ClassOS[] osArrayClass = ClassOS.values();
		Arrays.sort(osArrayClass, new ClassOSReverseComparator());
		for (ClassOS os : Arrays.asList(osArrayClass)) {
			System.out.println(os + " = " + os.ordinal());
		}

		System.out.println("\n...that's it!\n");
	}
}
