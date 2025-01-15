package sorting;

import java.util.Arrays;

public class SelectionSort {
	
	public static void main(String[] args) {
		int[] arr = {10, 5, 8, 20, 2, 18};
		System.out.println("Original Array: " + Arrays.toString(arr));
		System.out.println("Sorted Array: " + Arrays.toString(selectionSort(arr)));
	}
	
	// Helper method to swap two elements in the array
	static void swap(int arr[], int first, int second) {
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}

	// Selection Sort implementation
	private static int[] selectionSort(int[] arr) {
		int n = arr.length;

		// Iterate over the array, shrinking the unsorted portion
		for (int i = 0; i < n - 1; i++) {
			// Find the maximum element in the unsorted portion
			int lastIndex = n - i - 1; // Last index of the unsorted portion
			int maxIndex = getMaxIndex(arr, 0, lastIndex);

			// Swap the maximum element with the last element of the unsorted portion
			swap(arr, maxIndex, lastIndex);
		}
		return arr;
	}

	// Helper method to find the index of the maximum element in a range
	private static int getMaxIndex(int[] arr, int start, int end) {
		int max = start;
		for (int i = start; i <= end; i++) {
			if (arr[max] < arr[i]) {
				max = i;
			}
		}
		return max;
	}
}
