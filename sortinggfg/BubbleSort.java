package sortinggfg;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		bubbleSortRec(arr, arr.length);

		System.out.println(Arrays.toString(arr));
	}

	// this function will compare adjacentelements of the array and if next element
	// is greater than simpley swap it worst case is o(n2)

	public static void bubbleSortRec(int[] arr, int n) {
		if (n == 1)
			return;
		for (int j = 1; j < n - 1; j++) {
			if (arr[j - 1] > arr[j]) {
				int temp = arr[j - 1];
				arr[j - 1] = arr[j];
				arr[j] = temp;
			}

		}

		bubbleSortRec(arr, n - 1);
	}

	private static int[] bubbleSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			boolean isSwapped = false;
			for (int j = 1; j < n - i; j++) {
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
					isSwapped = true;
				}
			}

			if (!isSwapped)
				break;
		}

		return arr;

	}
}
