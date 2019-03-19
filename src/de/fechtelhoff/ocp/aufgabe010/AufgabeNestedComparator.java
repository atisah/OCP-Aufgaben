package de.fechtelhoff.ocp.aufgabe010;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class ToplevelComparatorClass implements Comparator<String> {
	@Override
	public int compare(String s1, String s2) {
		return s1.length() - s2.length();
	}
}

public class AufgabeNestedComparator {

	static class InnerComparatorClass implements Comparator<String> {
		@Override
		public int compare(String s1, String s2) {
			return s2.length() - s1.length();
		}
	}

	public static void main(String[] args) {
		System.out.println("\nStarts here ...\n");

		class LocalComparatorClass implements Comparator<String> {
			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		}

		String[] stringArray = {
				"Donald Duck",
				"Tick Duck",
				"Trick Duck",
				"Track Duck",
				"Dagobert Duck",
				"Daniel Düsentrieb",
		};

		String[] tempStringArray;
		List<String> tempStringList;

		System.out.println("========== 0 ==========");
		printArray(stringArray);
		newLine();

		// 1. mit einer Toplevel-Klasse
		System.out.println("========== 1 ==========");
		tempStringArray = cloneStringArray(stringArray);
		Arrays.sort(tempStringArray, new ToplevelComparatorClass());
		printArray(tempStringArray);
		newLine();

		// 2. mit einer inneren (nested) Klasse
		System.out.println("========== 2 ==========");
		tempStringArray = cloneStringArray(stringArray);
		Arrays.sort(tempStringArray, new InnerComparatorClass());
		printArray(tempStringArray);
		newLine();

		// 3. mit einer lokalen Klasse
		System.out.println("========== 3 ==========");
		tempStringArray = cloneStringArray(stringArray);
		Arrays.sort(tempStringArray, new LocalComparatorClass());
		printArray(tempStringArray);
		newLine();

		// 4. mit einer anonymen Klasse
		System.out.println("========== 4 ==========");
		tempStringArray = cloneStringArray(stringArray);
		Arrays.sort(tempStringArray, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s2.length() - s1.length();
			}
		});
		printArray(tempStringArray);
		newLine();

		// 5. mit einer Lambda-Funktion
		System.out.println("========== 5 ==========");
		tempStringArray = cloneStringArray(stringArray);
		Arrays.sort(tempStringArray, (String s1, String s2) -> {
			return s1.length() - s2.length();
		});
		printArray(tempStringArray);
		newLine();

		// 6. mit einer Methodenreferenz
		System.out.println("========== 6 ==========");
		tempStringArray = cloneStringArray(stringArray);
		Arrays.sort(tempStringArray, new ToplevelComparatorClass()::compare);
		printArray(tempStringArray);
		newLine();

		System.out.println("\n...that's it!\n");
	}

	public static boolean compare(String stringA, String stringB) {
		return false;
	}

	private static String[] cloneStringArray(String[] stringArray) {
		return stringArray.clone();
	}

	private static void printArray(String[] stringArray) {
		for (String string : stringArray) {
			System.out.println(string);
		}
	}

	private static void newLine() {
		System.out.println();
	}
}
