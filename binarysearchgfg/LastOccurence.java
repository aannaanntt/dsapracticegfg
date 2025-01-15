package binarysearchgfg;

public class LastOccurence {

	public static void main(String[] args) {
		int[] arr = { 10, 15, 20, 20, 40, 40 };
		System.out.println(getLastOccurenceRec(arr, 20, 0, arr.length));
	}

	public static int getLastOccurenceRec(int[] arr, int element, int start, int end) {
		if (start > end)
			return -1;
		int mid = start + (end - start) / 2;
		if (arr[mid] > element)
			return getLastOccurenceRec(arr, element, start, mid - 1);
		else if (arr[mid] < element)
			return getLastOccurenceRec(arr, element, mid + 1, end);
		else {
			if (mid == arr.length - 1 || arr[mid] != arr[mid + 1]) {
				return mid;
			} else {
				getLastOccurenceRec(arr, element, mid + 1, end);
			}
		}

		return -1;

	}

	public static int getLastOccurenceBS(int[] arr, int element) {
		int n = arr.length;
		int start = 0;
		int end = n - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] > element)
				end = mid - 1;
			else if (arr[mid] < element)
				start = mid + 1;
			else {
				if (mid == n - 1 || arr[mid] != arr[mid + 1]) {
					return mid;
				} else {
					start = mid + 1;
				}
			}
		}

		return -1;
	}

	private static int lastOccurence(int[] arr, int element) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == element && arr[i] != arr[i + 1]) {
				return i;

			}
		}
		return -1;
	}
}
