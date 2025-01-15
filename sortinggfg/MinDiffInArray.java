package sortinggfg;

import java.util.Arrays;

public class MinDiffInArray {

	public static void main(String[] args) {
		int[] arr = { 1, 8, 12, 5, 18 };
		System.out.println(getMinDiffOpt(arr));
	}

	public static int getMinDiffOpt(int[] array) {
		Arrays.sort(array);
		int min_diif = Integer.MAX_VALUE;
		for (int i = 1; i < array.length; i++) {
			min_diif = Math.min(min_diif, Math.abs(array[i] - array[i - 1]));
		}

		return min_diif;

	}

	private static int getMinDiff(int[] arr) {
		int min_diff = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int curr_diff = 0;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					curr_diff = arr[i] - arr[j];
					min_diff = Math.min(curr_diff, min_diff);
				}
			}
		}

		return min_diff;
	}

}
