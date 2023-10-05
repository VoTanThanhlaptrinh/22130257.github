package lab3;

import java.util.Arrays;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		super();
		this.array = array;
	}

	// To find the index of the target in the array. If the target
	// is not found in the array, then the method returns -1.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 45
	// Output: 3
	public int iterativeLinearSearch(int target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				return i;
			}

		}
		return -1;
	}

	// To find the index of the target in the array. If the target
	// is not found in the array, then the method returns -1.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 15
	// Output: -1
	public int recursiveLinearSearch(int target) {
		return help(target, 0);
	}

	public int help(int target, int index) {
		if (index == array.length) {
			return -1;
		} else {
			if (array[index] == target) {
				return index;
			} else {
				return help(target, index + 1);
			}
		}
	}

	// To find the index of the target in the sorted array. If the
	// target is not found in the array, then the method returns -1.
	public int iterativeBinarySearch(int target) {
		Arrays.sort(array);
		if (array[(array.length - 1) / 2] == target) {
			return (array.length - 1) / 2;
		} else {
			if (target > array[(array.length - 1) / 2]) {
				for (int i = array.length / 2 + 1; i < array.length; i++) {
					if (array[i] == target) {
						return i;
					}
				}
			} else {
				for (int i = 0; i < array.length / 2; i++) {
					if (array[i] == target) {
						return i;
					}
				}
			}
		}
		return -1;

	}

	// To find the index of the target in the sorted array. If the target is not
	// found in the array, then the method returns -1.
	public int recursiveBinarySearch(int target) {
		return help2(target, 0, array.length-1);
	}

	public int help2(int target ,int start, int end) {
		Arrays.sort(array);
		if(start > end) {
			return -1;
		}
		else {
			int mid = (start+ end)/2;
			if(array[mid] == target) {
				return mid;
			}
			else {
				if(target > array[mid]) {
					return help2(target, mid+1, end);
				}
				else {
					return help2(target, start, mid-1);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 12, 10, 9, 45, 2, 10, 10, 45 };
		MyArray myArray = new MyArray(array);
		System.out.println(Arrays.toString(array));
		System.out.println(myArray.iterativeLinearSearch(45));
		System.out.println(myArray.recursiveLinearSearch(10));
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		System.out.println(myArray.iterativeBinarySearch(10));
		System.out.println(myArray.recursiveBinarySearch(12));
	}
}
