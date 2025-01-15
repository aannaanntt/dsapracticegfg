package sortinggfg;

import java.util.Arrays;

public class Sortzeroesonesandtwos {

	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 2, 1, 2 };
		System.out.println(Arrays.toString(threeWayPartiotn(arr, 3)));
	}

	public static int[] partitionAroundRange(int[] arr) {
		int low_pointer = 0;
		int high_pointer = arr.length - 1;
		int mid = 0;
		int lr = 5;
		int hr = 10;

		while (mid <= high_pointer) {
			if (arr[mid] < lr) {
				swap(arr, low_pointer, mid);
				low_pointer++;
				mid++;
			}
			if (arr[mid] > hr) {
				swap(arr, mid, high_pointer);
				high_pointer--;
			} else {
				mid++;
			}
		}

		return arr;

	}

	static void swap(int[] array, int first, int second) {
		int temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}

	public static int[] threeWayPartiotn(int[] arr, int pivot) {
		int low_pointer = 0;
		int high_pointer = arr.length - 1;
		int mid = 0;
		while (mid <= high_pointer) {
			if (arr[mid] < arr[pivot]) {
				swap(arr, mid, low_pointer);
				mid++;
				low_pointer++;
			}

			if (arr[mid] == arr[pivot]) {
				mid++;
			}

			if (arr[mid] > arr[pivot]) {
				swap(arr, mid, high_pointer);
				high_pointer--;
			}
		}

		return arr;
	}

	// dutch national flag algo
	public static int[] sortDutchNationalFlag(int[] arr) {
		int n = arr.length;
		int low_pointer = 0;
		int high_pointer = n - 1;
		int mid = 0;
		while (mid <= high_pointer) {
			if (arr[mid] == 0) {
				swap(arr, low_pointer, mid);
				low_pointer++;
				mid++;
			}

			if (arr[mid] == 1) {
				mid++;
			}

			else {
				swap(arr, mid, high_pointer);
				high_pointer--;
			}
		}

		return arr;
	}

	private static int[] sortAllNaive(int[] arr) {
		int n = arr.length;
		int i = 0;
		int temp[] = new int[n];
		for (int j = 0; j < n; j++) {
			if (arr[j] == 0) {
				temp[i] = arr[j];
				i++;
			}
		}

		for (int k = 0; k < n; k++) {
			if (arr[k] == 1) {
				temp[i] = arr[k];
				i++;
			}
		}

		for (int l = 0; l < n; l++) {
			if (arr[l] == 2) {
				temp[i] = arr[l];
				i++;
			}
		}

		for (int m = 0; m < n; m++) {
			arr[m] = temp[m];
		}

		return arr;
	}

}
