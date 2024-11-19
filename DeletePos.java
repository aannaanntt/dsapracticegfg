package arrays;

import java.util.Arrays;

public class DeletePos {

	public static void main(String[] args) {
		int arr[] = { 3, 8, 12, 5, 6 };
		int pos = 3;
		System.out.println(Arrays.toString(deletePos(arr, pos)));
	}

	private static int[] deletePos(int[] arr, int pos) {
		int n = arr.length;
		if (n < pos)
			return new int[] { -1, -1 };

		int idx = pos - 1;
		for (int i = 0; i < n; i++) {
			if (i == idx) {
				arr[i] = arr[i + 1];
			}
		}

		return arr;
	}
}
