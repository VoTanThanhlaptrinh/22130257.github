package lab4;

import java.util.Arrays;
import java.util.Random;

public class Sort {
	public static void recursiveSelectionSort(int[] array) {
		swapRecursiveSelectionSort(array, 0, 0, 0);
	}

	public static void swapRecursiveSelectionSort(int[] arr, int i, int j, int stepNum) {
		if (stepNum > arr.length - 1) {
			return;
		} else {

			for (int k = stepNum; k < arr.length; k++) {
				j = arr[stepNum];
				if (j < arr[k]) {
					j = arr[k];
					i = k;
				}
				if (j == arr[stepNum]) {
					i = stepNum;
				} else {
					arr[i] = arr[stepNum];
					arr[stepNum] = j;
				}
			}
		}
		swapRecursiveSelectionSort(arr, i, j, stepNum + 1);
	}

	public static void bubbleSort(int[] array) {
		int a = 0;
		boolean b = true;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] < array[j + 1]) {
					a = array[j];
					array[j] = array[j + 1];
					array[j + 1] = a;
					b = false;
				}
			}
			if (b)
				break;
		}
		return;
	}

	public static void insertionSort(int[] array) {
		int a = 0;
		for (int i = 1; i < array.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (array[i] > array[j]) {
					a = array[i];
					array[i] = array[j];
					array[j] = a;
				}
			}
		}
		return;
	}

	public static void mergeSort(int[] array) {
		// TODO
		if (array.length < 2) {
			return;
		} else {
			int mid = array.length / 2;
			int[] leftArray = new int[mid];
			int[] rightArray = new int[array.length - mid];
			for (int i = 0; i < mid; i++) {
				leftArray[i] = array[i];
			}
			for (int i = mid; i < array.length; i++) {
				rightArray[i - mid] = array[i];
			}
			mergeSort(leftArray);
			mergeSort(rightArray);
			merge(array, leftArray, rightArray);
		}
	}

	private static void merge(int[] array, int[] leftArray, int[] rightArray) {
		int i = 0, j = 0, k = 0;
		int left = leftArray.length;
		int right = rightArray.length;
		while (i < left && j < right) {
			if (leftArray[i] > rightArray[j]) {
				array[k] = leftArray[i];
				i++;
			} else {
				array[k] = rightArray[j];
				j++;
			}
			k++;
		}
		while (i < left) {
			array[k] = leftArray[i];
			i++;
			k++;
		}
		while (j < right) {
			array[k] = rightArray[j];
			j++;
			k++;
		}
	}
	// sort by ascending order
	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	public static void quickSort(int[] array, int low, int high) {
		if (low < high) {
			int pivotIndex = partition(array, low, high);
			quickSort(array, low, pivotIndex - 1);
			quickSort(array, pivotIndex + 1, high);
		}
	}

	public static int partition(int[] array, int low, int high) {
		int pivot = getPivot_MedianOfThree(array);
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (array[j] > pivot) {
				i++;
				swap(array, i, j);
			}
		}

		swap(array, i + 1, high);
		return i + 1;
	}

	private static void swap(int[] array, int leftPointer, int rightPointer) {
		int a = array[leftPointer];
		array[leftPointer] = array[rightPointer];
		array[rightPointer] = a;
	}

	private static int getPivot_MedianOfThree(int[] array) {
		int[] values = { getPivot_First(array), getPivot_Random(array), getPivot_Last(array) };
		Arrays.sort(values);
		int median = values[1];
		return median;
	}

	// select pivot element based on the first element in the array

	private static int getPivot_First(int[] array) {
		// TODO
		return array[0];
	}

	// select pivot element based on the last element in the array

	private static int getPivot_Last(int[] array) {
		// TODO
		return array[array.length - 1];
	}

	// select pivot element based on choosing a randomly element in the array

	private static int getPivot_Random(int[] array) {
		// TODO
		Random random = new Random();
		return array[random.nextInt(array.length)];
	}

	public static void main(String[] args) {
		Random random = new Random();
		int[] array = new int[10];
		int[] array1 = new int[10];
		int[] array2 = new int[10];
		int[] array3 = new int[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(100);
			array1[i] = random.nextInt(100);
			array2[i] = random.nextInt(100);
			array3[i] = random.nextInt(100);
		}

		System.out.println(Arrays.toString(array));
		bubbleSort(array);
		System.out.println("bubbleSort \n" + Arrays.toString(array) + "\n");

		System.out.println(Arrays.toString(array1));
		recursiveSelectionSort(array1);
		System.out.println("SelectionSort \n" + Arrays.toString(array1) + "\n");

		System.out.println(Arrays.toString(array2));
		mergeSort(array2);
		System.out.println("mergeSort \n" + Arrays.toString(array2) + "\n");

		System.out.println(Arrays.toString(array3));
		quickSort(array3);
		System.out.println("quickSort \n" + Arrays.toString(array3) + "\n");

	}
}
