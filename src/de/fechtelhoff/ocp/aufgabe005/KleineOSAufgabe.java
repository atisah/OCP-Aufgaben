package de.fechtelhoff.ocp.aufgabe005;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

enum OS {
	UNIX, WINDOWS, MAC
}

class MyOS {
	private String name;
	private int ordinal;

	public static final MyOS UNIX = new MyOS("UNIX", 0);
	public static final MyOS WINDOWS = new MyOS("WINDOWS", 1);
	public static final MyOS MAC = new MyOS("MAC", 2);

	private MyOS(String name, int ordinal) {
		this.name = name;
		this.ordinal = ordinal;
	}

	public static MyOS[] values() {
		return new MyOS[] { UNIX, WINDOWS, MAC };
	}
	
	public int ordinal() {
		return ordinal;
	}

	@Override
	public String toString() {
		return name;
	}
}

public class KleineOSAufgabe {

	public static void main(String[] args) {
		int counter = 1;
		
		// Aufgabe 1
		System.out.println("-----> Aufgabe " + counter++);
		System.out.println();
		
		// Aufgabe 2
		System.out.println("-----> Aufgabe " + counter++);
		for (OS os : OS.values()) {
			System.out.println(os);
		}
		System.out.println();

		// Aufgabe 3
		System.out.println("-----> Aufgabe " + counter++);
		MyOS[] allValues = MyOS.values();
		for (MyOS os : allValues) {
			System.out.println(os);
		}
		System.out.println();

		// Aufgabe 4
		System.out.println("-----> Aufgabe " + counter++);
		for (OS os : OS.values()) {
			System.out.println(os + " = " + os.ordinal());
		}
		System.out.println();

		// Aufgabe 5
		System.out.println("-----> Aufgabe " + counter++);
		for (MyOS os : allValues) {
			System.out.println(os + " = " + os.ordinal());
		}
		System.out.println();

		// Aufgabe 6
		System.out.println("-----> Aufgabe " + counter++);
		List<String> list = new ArrayList<>();
		for (OS os : OS.values()) {
			list.add(os.name());
		}
		list.sort(Comparator.reverseOrder());
		for (String string : list) {
			System.out.println(string);
		}
		System.out.println();

		// Aufgabe 6
		System.out.println("-----> Aufgabe " + counter++);

//		for (OS os : Arrays.sort(OS.values(), Comparator.reverseOrder())) {
//			System.out.println(os);
//		};
		
		System.out.println();

	}
}
