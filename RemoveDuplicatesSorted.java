package arrays;

import java.util.Arrays;

public class RemoveDuplicatesSorted {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 3, 3, 4, 4, 5, 5 };
		int uniqueElements = getSortedArraywithoutdupsOpt(arr);
		for (int i = 0; i < uniqueElements; i++) {
			System.out.println(arr[i] + " ");
		}
	}

	public static int getSortedArraywithoutdupsOptmizedremoveelementsAswell(int[] arr) {
		if (arr.length == 0) {
			return 0; // No elements in the array
		}

		int i = 0; // Pointer to track unique elements

		for (int j = 1; j < arr.length; j++) {
			if (arr[j] != arr[i]) {
				i++; // Move the pointer for unique elements
				arr[i] = arr[j]; // Place the next unique element
			}
		}

		return i + 1; // Number of unique elements
	}

	// this will give count but we need to remove it from array as well
	public static int getSortedArraywithoutdupsOpt(int[] arr) {
		int res = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[res - 1] != arr[i]) {
				arr[res] = arr[i];
				res++;
			}
		}


		return res;
	}

	// naive approach
	private static int getSortedArraywithoutdups(int[] arr) {
		int n = arr.length;
		int temp[] = new int[n];
		temp[0] = arr[0];
		int res = 1;
		for (int i = 1; i < n; i++) {
			if (temp[res - 1] != arr[i]) {
				temp[res] = arr[i];
				res++;
			}
		}

		for (int i = 0; i < n; i++) {
			arr[i] = temp[i];
		}

		return res;
	}

}
