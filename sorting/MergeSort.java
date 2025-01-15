package sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = { 10, 5, 30, 15, 7 };

		mergeSort(arr, 0, arr.length - 1);

		System.out.println(Arrays.toString(arr));
	}

	private static void mergeSort(int[] arr, int low, int high) {

		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			mergeArray(arr, mid, low, high);

		}

	}
	
	//study its reccuresnce relation and time complexity breakdown ek br dry run

	private static void mergeArray(int[] arr, int mid, int low, int high) {
		int[] left = new int[mid - low + 1];
		int[] right = new int[high - mid];
		for (int i = 0; i < left.length; i++) {
			left[i] = arr[low + i];
		}
		for (int j = 0; j < right.length; j++) {
			right[j] = arr[mid + j + 1];
		}

		int i = 0, j = 0, k = low;
		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				arr[k] = left[i];
				i++;
				k++;
			} else {
				arr[k] = right[j];
				k++;
				j++;
			}
		}

		while (i < left.length) {
			arr[k] = left[i];
			i++;
			k++;
		}
		while (j < right.length) {
			arr[k] = right[j];
			j++;
			k++;
		}

	}

}
