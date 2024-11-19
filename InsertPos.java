package arrays;

import java.util.Arrays;

public class InsertPos {

	public static void main(String[] args) {
		int arr[] = { 5, 10, 20, 0, 0 };
		System.out.println(Arrays.toString(insertAtPosition(arr, 5, 5)));
	}

	private static int[] insertAtPosition(int[] arr, int position, int element) {
		int n = arr.length;
		int idx = position - 1;
		if (position > n)
			return new int[] { -1, -1 };

		for (int i = 0; i <= idx; i++) {
			arr[idx] = element;
		}

		return arr;

	}

}