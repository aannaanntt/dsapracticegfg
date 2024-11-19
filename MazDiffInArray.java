package arrays;

public class MazDiffInArray {

	public static void main(String[] args) {
		int arr[] = { 2, 3, 10, 6, 4, 8, 1 };
		System.out.println(maxDiffOpt(arr));
	}

	public static int maxDiffOpt(int[] arr) {
		int diff = arr[1] - arr[0];
		int minVal = arr[0];
		for (int i = 1; i < arr.length; i++) {
			diff = Math.max(diff, arr[i] - minVal);
			minVal = Math.min(minVal, arr[i]);
		}
		return diff;
	}

	// o(n2)
	private static int maxDiff(int[] arr) {
		int diff = 0;
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				diff = Math.max(diff, arr[j] - arr[i]);
			}
		}
		return diff;
	}
}
