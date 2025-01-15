package sortinggfg;

import java.util.Arrays;

public class SortArrayOf2Types {

	public static void main(String[] args) {
		int[] array = { 15, -3, -2, 18 };
		// segPosveAndNeve(array);
		int[] array2 = { 15, 14, 13, 12 };
		int[] array3 = { 0, 1, 1, 1, 0 };
		// segEvenOdd(array2);
		// sortBinaryArray(array3);
		// System.out.println(Arrays.toString(array));
		// System.out.println(Arrays.toString(array2));
		// segEvenOddRec(array, 0, array.length, 0);
		// System.out.println(Arrays.toString(array2));
		// System.out.println(Arrays.toString(array3));
		System.out.println(Arrays.toString(segEvenOddHoares(array2)));

	}

	public static int[] segEvenOddHoares(int[] arr) {
		int i = -1;
		int j = arr.length;
		while (true) {
			do {
				i++;
			} while (i < arr.length && arr[i] % 2 != 0);
			do {
				j--;
			} while (j >= 0 && arr[i] % 2 == 0);

			if (i >= j)
				return arr;
			swap(arr, i, j);
		}

	}

	public static int[] segPositiveNegativeOptHoare(int[] arr) {
		int n = arr.length;
		int i = -1;
		int j = n;
		while (true) {
			do {
				i++;
			} while (arr[i] < 0);
			do {
				j--;
			} while (arr[j] >= 0);
			if (i >= j)
				return arr;
			swap(arr, i, j);
		}
	}

	public static void sortBinaryArray(int[] arr) {
		int zero_count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 1) {
				swap(arr, i, zero_count);
				zero_count++;
			}
		}
	}

	private static void segEvenOddRec(int array[], int pointer, int length, int counter) {
		if (pointer >= length) {
			return;
		}

		if (array[pointer] % 2 == 0) {
			swap(array, pointer, counter);
			counter++;
		}

		segEvenOddRec(array, pointer + 1, length, counter);
	}

	private static void segEvenOdd(int[] array2) {
		int even_count = 0;
		for (int i = 0; i < array2.length; i++) {
			if (array2[i] % 2 == 0) {
				swap(array2, i, even_count);
				even_count++;
			}
		}

	}

	static void swap(int[] array, int first, int second) {
		int temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}

	private static void segPosveAndNeve(int[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < 0) {
				swap(array, i, count);
				count++;
			}
		}

	}
}
