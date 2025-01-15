package sortinggfg;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 20, 5, 40, 60, 10, 30 };
		System.out.println(Arrays.toString(insertionSort(arr)));
	}

	// take first element start from second element compare both if elment is
	// smaller shift the elements and place it there
	private static int[] insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int element = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > element) {
				arr[j + 1] = arr[j];
				j--;
			}

			arr[j + 1] = element;
		}

		return arr;
	}
}
