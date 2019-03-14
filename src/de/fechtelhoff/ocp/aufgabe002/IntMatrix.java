package de.fechtelhoff.ocp.aufgabe002;

import java.util.Random;

public class IntMatrix {

	private int x, y;

	private int[][] intArray;

	public IntMatrix(int x, int y) {
		this.x = x;
		this.y = y;
		intArray = new int[x][y];
	}

	public IntMatrix(int x, int y, int value) {
		this(x, y);
		for (int i = 0; i < intArray.length; i++) {
			for (int j = 0; j < intArray[i].length; j++) {
				intArray[i][j] = value;
			}
		}
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void set(int x, int y, int value) {
		intArray[x][y] = value;
	}

	public int get(int x, int y) {
		return intArray[x][y];
	}

	public boolean haveEqualDimensions(IntMatrix that) {
		return (this.getX() == that.getX()) && (this.getY() == that.getY());
	}

	public IntMatrix transpose() {
		IntMatrix resultMatrix;
		if (x == y) {
			resultMatrix = this;
		} else {
			resultMatrix = new IntMatrix(y, x);
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					resultMatrix.set(j, i, this.get(i, j));
				}
			}
		}
		return resultMatrix;
	}

	public IntMatrix add(IntMatrix that) {
		IntMatrix resultMatrix = null;
		if (haveEqualDimensions(that)) {
			resultMatrix = new IntMatrix(x, y);
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					resultMatrix.set(i, j, this.get(i, j) + that.get(i, j));
				}
			}
		}
		return resultMatrix;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y - 1; j++) {
				result.append(intArray[i][j] + ", ");
			}
			result.append(intArray[i][y - 1] + "\n");
		}
		return result.toString();
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj instanceof IntMatrix) {
			return false;
		}
		IntMatrix that = (IntMatrix) obj;
		if (haveEqualDimensions(that)) {
			for (int i = 0; i < this.getX(); i++) {
				for (int j = 0; j < this.getY(); j++) {
					if (this.get(i, j) == that.get(i, j)) {
						result = true;
					} else {
						return false;
					}
				}
			}
		}
		return result;
	}

	public static IntMatrix getRandomMatrix(int x, int y, int maxValue) {
		Random random = new Random();
		IntMatrix intMatrix = new IntMatrix(x, y);
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				intMatrix.set(i, j, random.nextInt(maxValue));
			}
		}
		return intMatrix;
	}
}
