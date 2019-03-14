package de.fechtelhoff.ocp.aufgabe003;

import java.util.Arrays;
import java.util.Random;

public class ArrayUtil {

	public static void initializeArrayWithRandom(int[] array, int maxNumber) {
		int number;
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			Arrays.sort(array, 0, i);
			do {
				number = random.nextInt(maxNumber) + 1;
			} while (Arrays.binarySearch(array, 0, i, number) >= 0);
			array[i] = number;
		}
		Arrays.sort(array);
	}

	public static int countNumberOfMatches(int[] thisArray, int[] thatArray) {
		int number = 0;
		for (int i : thisArray) {
			if (Arrays.binarySearch(thatArray, i) >= 0) {
				number++;
			}
		}
		return number;
	}
}
