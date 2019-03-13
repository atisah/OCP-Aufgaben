package de.fechtelhoff.ocp.aufgabe004;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

interface Transformation {
	String execute(String input);
}

class ToUpperCase implements Transformation {
	@Override
	public String execute(String input) {
		return input.toUpperCase();
	}
}

class ToCamelCase implements Transformation {
	@Override
	public String execute(String input) {
		return input.substring(0, 1).toUpperCase() + input.substring(1);
	}
}

class AddDot implements Transformation {
	@Override
	public String execute(String input) {
		return input + ".";
	}
}

class AddLength implements Transformation {
	@Override
	public String execute(String input) {
		return input + "(" + input.length() + ")";
	}
}

public class AufgabeInterfacesStringTransform {

	private static List<String> transform(String[] array) {
		List<String> list = new ArrayList<String>();
		for (String element : array) {
			list.add(element.toUpperCase());
		}
		return list;
	}

	private static List<String> transform(String[] array, Transformation transformationObject) {
		List<String> list = new ArrayList<String>();
		for (String element : array) {
			list.add(transformationObject.execute(element));
		}
		return list;
	}

	private static List<String> transformWithLambda(String[] array, UnaryOperator<String> operator) {
		List<String> list = Arrays.asList(array.clone());
		list.replaceAll(operator);
		return list;
	}

	public static void main(String[] args) {
		System.out.println("\nStarts here ...\n");

		String[] array = { "mo", "di", "mi" };

		System.out.println("===== Initial Array =====");
		
		System.out.println(Arrays.toString(array) + "\n");

		System.out.println("===== Using simple transform Method =====");

		System.out.println(transform(array) + "\n");

		System.out.println("===== Using tranform Classes =====");

		System.out.println(transform(array, new ToUpperCase()) + "\n");

		System.out.println(transform(array, new AddDot()) + "\n");

		System.out.println(transform(array, new ToCamelCase()) + "\n");

		System.out.println(transform(array, new AddLength()) + "\n");

		System.out.println("===== Using transform with Lambdas =====");

		System.out.println(transformWithLambda(array, e -> e.toUpperCase()) + "\n");

		System.out.println(transformWithLambda(array, e -> e.substring(0, 1).toUpperCase() + e.substring(1) + ".") + "\n");
		
		System.out.println(transformWithLambda(array, e -> e.substring(0, 1).toUpperCase() + e.substring(1) + ". (" + e.length() + ")") + "\n");

		System.out.println("\n...that's it!\n");
	}
}
