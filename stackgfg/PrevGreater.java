package stackgfg;

import java.util.ArrayDeque;
import java.util.Stack;

public class PrevGreater {

	public static void main(String[] args) {
		int arr[] = { 15, 10, 18, 12, 4, 6, 2, 8 };
		printPrevStack(arr);

	}

	public static void printPrevStack(int[] arr) {
		ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
		ad.push(arr[0]);
		for (int i = 0; i < arr.length; i++) {
			while (!ad.isEmpty() && ad.peek() <= arr[i]) {
				ad.pop();

			}
			int pg = ad.isEmpty() ? -1 : ad.peek();
			System.out.print(pg + " ");
			ad.push(arr[i]);
		}
	}

	public static void printPrevRec(int[] arr, int idx) {
		if (idx >= arr.length) {
			return; // Base case: Stop when index exceeds array length
		}

		int prev_greater = -1; // Default value if no greater element is found

		// Check previous elements for the first greater value
		for (int j = idx - 1; j >= 0; j--) {
			if (arr[j] > arr[idx]) {
				prev_greater = arr[j];
				break;
			}
		}

		// Print first, then call recursion for the next index
		System.out.print(prev_greater + " ");

		printPrevRec(arr, idx + 1);
	}

	private static void printPrevGreaterNaive(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int prev_greater = -1;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] > arr[i]) {
//					System.out.print(arr[j]+"");
					prev_greater = arr[j];
					break;
				}
			}
			System.out.print(prev_greater + " ");
		}

	}
}
