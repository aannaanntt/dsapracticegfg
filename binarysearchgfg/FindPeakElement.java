package binarysearchgfg;

public class FindPeakElement {
	// an element is peak element if its greater than its neighbour
	public static void main(String[] args) {
		int[] arr = { 5, 6};

		System.out.println(getPeakElementBS(arr));
	}

	public static int getPeakElementBS(int[] arr) {
		int n = arr.length;
		int start = 0;
		int end = n - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (mid == 0 || arr[mid] >= arr[mid - 1] && mid == n - 1 || arr[mid] >= arr[mid + 1]) {
				return mid;
			}
			if (mid > 0 && arr[mid - 1] >= arr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		return -1;
	}

	private static int getPeakElement(int[] arr) {
		int n = arr.length;
		if (n == 1)
			return arr[0];
		if (arr[0] > arr[1])
			return arr[0];
		if (arr[n - 1] > arr[n - 2])
			return arr[n - 1];
		for (int i = 1; i < n - 1; i++) {
			if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
				return i;
			}

		}
		return -1;
	}

}
