package arrays;

import java.util.Arrays;

public class LeftArrayDPlaces {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int d = 2;
//		int[] rotatedArr = new int[arr.length];
//		for (int i = 1; i <= d; i++) {
//			rotatedArr = leftrotateByOne(arr, 1);
//		}
		// System.out.println(Arrays.toString(rotatedArr));
		System.out.println(Arrays.toString(rotateDplacesOptimalSolution(arr, d)));

	}

	public static int[] rotateDplacesOptimalSolution(int[] arr, int d) {
		int n = arr.length;
		d = d % n;
		reverse(arr, 0, d - 1);
		reverse(arr, d, n - 1);
		reverse(arr, 0, n - 1);

		return arr;

	}

	private static void reverse(int[] arr, int i, int j) {
		while (i < j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;

			i++;
			j--;
		}

	}

	public static int[] rotateDPlaces(int[] arr, int d) {
		int n = arr.length;
		int[] temp = new int[arr.length];
		for (int i = 0; i < d; i++) {
			temp[i] = arr[i];
		}
		for (int i = d; i < arr.length; i++) {
			arr[i - d] = arr[i];
		}

		for (int i = 0; i < d; i++) {
			arr[n - d + i] = temp[i];
		}

		return arr;

	}

	private static int[] leftrotateByOne(int[] arr, int pos) {
		int temp = arr[0];
		for (int i = 1; i < arr.length; i++) {
			arr[i - pos] = arr[i];
		}
		arr[arr.length - 1] = temp;
		return arr;
	}

}
