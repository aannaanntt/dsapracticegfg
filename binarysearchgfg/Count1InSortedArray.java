package binarysearchgfg;

public class Count1InSortedArray {

	public static void main(String[] args) {
		int[] arr = { 0, 0, 0, 0, 1, 1, 1, 1, 1 };
		System.out.println(countOneBinarySearch(arr));
	}

	public static int countOneBinarySearch(int[] arr) {
		int n = arr.length;
		int start = 0;
		int end = n - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == 0) {
				start = mid + 1;
			} else {
				end = mid - 1;

			}
		}

		return n - start;
	}

	private static int countOneLinearly(int[] arr) {
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
				counter++;
			}
		}
		return counter;
	}

}
