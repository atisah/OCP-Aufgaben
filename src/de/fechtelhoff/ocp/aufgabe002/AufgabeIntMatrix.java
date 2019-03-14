package de.fechtelhoff.ocp.aufgabe002;

public class AufgabeIntMatrix {

	public static void main(String[] args) {
		System.out.println("\nStarts here ... \n");

		System.out.println("==============================\n");
		System.out.println("m1 -->");
		IntMatrix m1 = new IntMatrix(2, 3);
		System.out.println(m1);

		System.out.println("==============================\n");
		System.out.println("m2 -->");
		IntMatrix m2 = new IntMatrix(5, 3, 100);
		System.out.println(m2);

		System.out.println("==============================\n");
		System.out.println("m1(1, 2) -->");
		System.out.println(m1.get(1, 2) + "\n");

		System.out.println("==============================\n");
		System.out.println("m3 -->");
		IntMatrix m3 = IntMatrix.getRandomMatrix(4, 6, 200);
		System.out.println(m3);

		System.out.println("==============================\n");
		System.out.println("m3(1, 2) -->");
		System.out.println(m3.get(1, 2) + "\n");

		System.out.println("==============================\n");
		System.out.println("m1.equals(m2) -->");
		System.out.println(m1.equals(m2) + "\n");

		System.out.println("==============================\n");
		System.out.println("m1.equals(m1) -->");
		System.out.println(m1.equals(m1) + "\n");

		System.out.println("==============================\n");
		System.out.println("m3.transpose() -->");
		IntMatrix m4 = m3.transpose();
		System.out.println(m4 + "\n");

		System.out.println("==============================\n");
		System.out.println("m3.add(m3) -->");
		IntMatrix m5 = m3.add(m3);
		System.out.println(m5 + "\n");

		System.out.println("==============================\n");
		System.out.println("m3.add(m4) -->");
		IntMatrix m6 = m3.add(m4);
		System.out.println(m6 + "\n");

		System.out.println("==============================\n");
		System.out.println("Array -->");
		IntMatrix[] array = new IntMatrix[6];
		array[0] = m1;
		array[1] = m2;
		array[2] = m3;
		array[3] = m4;
		array[4] = m5;
		array[5] = m6;
		for (IntMatrix intMatrix : array) {
			System.out.println(intMatrix);
		}
		System.out.println();

		System.out.println("==============================");
		System.out.println("\n... that's it!\n");
	}

}
