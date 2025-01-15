package binarysearchgfg;

import java.util.Arrays;

public class TwoPointerApproach {
	public static void main(String[] args) {
		int arr[] = { 2, 5, 8, 12, 30 };
		System.out.println(Arrays.toString(isPair(arr, 17)));
	}

	public static int[] isPairTwoPointer(int[] arr, int sum) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			if (arr[start] + arr[end] > sum) {
				end--;
			} else {
				start++;
			}
			if (arr[start] + arr[end] == sum) {
				return new int[] { start, end };
			}
		}

		return new int[] { -1, -1 };

	}

	private static int[] isPair(int[] arr, int sum) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == sum) {
					return new int[] { i, j };
				}
			}
		}
		return new int[] { -1, -1 };
	}
}
