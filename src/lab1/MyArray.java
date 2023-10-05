package lab1;

import java.util.Arrays;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		super();
		this.array = array;
	}

	public int[] mirror() {
		int[] arr = new int[array.length * 2];
		for (int i = 0; i < array.length; i++) {
			arr[i] = array[i];
			arr[arr.length - i - 1] = array[i];
		}
		return arr;
	}

	public int[] removeDuplicates() {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j]) {
					count++;
					break;
				}
			}

		}
		int[] arr = new int[array.length - count];
		int count1 = 0;
		boolean a;
		for (int i = 0; i < array.length; i++) {
			a = false;
			for (int j = 0; j < i; j++) {
				if (array[i] == array[j]) {
					a = true;
				}
			}
			if (!a) {
				arr[count1] = array[i];
				count1++;
			}

		}

		return arr;

	}

	public int[] getMissingValues() {
		int start = array[0];
		int end = array[array.length - 1];
		int[] arr = new int[end - start - array.length + 1];
		int index = 0;
		for (int i = start; i <= end; i++) {
			boolean found = false;
			for (int num : array) {
				if (num == i) {
					found = true;
					break;
				}

			}
			if (!found) {
				arr[index] = i;
				index++;
			}
		}
		return arr;
	}

	public int[] fillMissingValues(int k) {
		int assign = 0;
		if (array[0] == -1) {
			for (int i = 1; i <= k; i++) {
				assign += array[i];
			}
			array[0] = assign / k;
		}
		for (int i = 1; i < array.length - (k - 1); i++) {
			if (array[i] < array[i - 1]) {
				assign = array[i - 1];
				for (int j = i + 1; j < i + k; j++) {
					assign += array[j];
				}
				array[i] = assign / k;
				assign = 0;
			}
		}
		if (array[array.length - 1] == -1) {
			for (int i = array.length - k - 1; i < array.length - 1; i++) {
				assign += array[i];
			}
			array[array.length - 1] = assign / k;

		}

		return array;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3 };
		int[] array2 = { 1, 3, 5, 1, 3, 7, 9, 8 };
		int[] array3 = { 10, 11, 12, 13, 14, 16, 17, 19, 20 };
		int[] array4 = { 10, 11, 12, -1, 14, 10, 17, 19, 20 };

		MyArray myArray = new MyArray(array);
		MyArray myArray2 = new MyArray(array2);
		MyArray myArray3 = new MyArray(array3);
		MyArray myArray4 = new MyArray(array4);
		
		System.out.println(Arrays.toString(myArray.mirror()));
		System.out.println(Arrays.toString(myArray2.removeDuplicates()));
		System.out.println(Arrays.toString(myArray3.getMissingValues()));
		System.out.println(Arrays.toString(myArray4.fillMissingValues(3)));

	}
}
