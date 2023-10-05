package lab2;

import java.util.Arrays;

public class PascalTriangle {
	// This method is used to display a Pascal triangle based on the parameter n.
	// Where n represents the number of rows
	public static void printPascalTriangle(int row) {
		if (row == 0) {
			return;
		} else {
			printPascalTriangle(--row);
			System.out.println(Arrays.toString(generateNextRow(getPascalTriangle(row))));
		}
	}

	// get the nth row.
	// For example: n=1 ==> {1}, n=2 ==> {1, 1}, ...
	public static int[] getPascalTriangle(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			if (i == 0 || i == arr.length - 1) {
				arr[i] = 1;
			} else {
				arr[i] = getPascalTriangle(n - 1)[i - 1] + getPascalTriangle(n - 1)[i];
			}

		}
		return arr;
	}

	// generate the next row based on the previous row
	// Ex. prevRow = {1} ==> nextRow = {1, 1}
	// Ex. prevRow = {1, 1} ==> nextRow = {1, 2, 1}
	public static int[] generateNextRow(int[] prevRow) {
		int[] arr = new int[prevRow.length + 1];
		for (int i = 0; i < arr.length; i++) {
			if (i == 0 || i == arr.length - 1) {
				arr[i] = 1;
			} else {
				arr[i] = prevRow[i - 1] + prevRow[i];
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		printPascalTriangle(5);
	}
}
