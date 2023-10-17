package lab5;

import java.util.Arrays;

public class Task1 {
	public static int[][] add(int[][] a, int[][] b) {
		if (a.length != b.length || a[0].length != b[0].length) {
			return null;
		} else {
			int[][] c = new int[a.length][a[0].length];
			for (int i = 0; i < b.length; i++) {
				for (int j = 0; j < b.length; j++) {
					c[i][j] = a[i][j] + b[i][j];
				}
			}

			return c;
		}
	}

	public static int[][] subtract(int[][] a, int[][] b) {
		if (a.length != b.length || a[0].length != b[0].length) {
			return null;
		} else {
			int[][] c = new int[a.length][a[0].length];
			for (int i = 0; i < b.length; i++) {
				for (int j = 0; j < b.length; j++) {
					c[i][j] = a[i][j] - b[i][j];
				}
			}

			return c;
		}
	}

	public static int[][] multiply(int[][] a, int[][] b) {
		if (a[0].length != b[0].length) {
			return null;
		} else {
			int assign = 0;
			int[][] c = new int[a.length][b[0].length];
			for (int i = 0; i < c.length; i++) {
				for (int j = 0; j < c[i].length; j++) {
					for (int j2 = 0; j2 < c.length; j2++) {
						assign += a[i][j2] * b[j2][j];
					}
					c[i][j] = assign;
					assign = 0;
				}
			}

			return c;
		}
	}

	public static int[][] transpose(int[][] a) {
		if (a[0].length == 0 || a.length == 0) {
			return null;
		} else {
			int[][] b = new int[a[0].length][a.length];
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					b[j][i] = a[i][j];
				}
			}
			return b;
		}
	}

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3 }, { 3, 4, 5 }, { 8, 5, 7 } }, b = { { -3, 5, 7 }, { 1, 0, 5 }, { 9, 6, 8 } };
		int[][] a1 = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
		System.out.println(Arrays.deepToString(a) + "\t" + Arrays.deepToString(b) + "\n");
		System.out.println("add " + Arrays.deepToString(add(a, b)) + "\n");
		System.out.println("subtract " + Arrays.deepToString(subtract(a, b)) + "\n");
		System.out.println("multiply " + Arrays.deepToString(multiply(a, b)) + "\n");
		System.out.println(Arrays.deepToString(a1));
		System.out.println("transpot " + Arrays.deepToString(transpose(a1)));
	}
}
