package binarysearchgfg;

public class CountOccurencesInSortedArray {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 20, 20, 30, 40, 50 };
		System.out.println(countOccurencesBS(arr, 20));
	}

	public static int countOccurencesBS(int[] arr, int element) {

		int firstOccurence = getFirstOccurence(arr, element);
		if (firstOccurence == -1)
			return -1;
		else
			return getLastOccurence(arr, element) - firstOccurence + 1;

	}

	private static int getLastOccurence(int[] arr, int element) {
		int n = arr.length;
		int start = 0;
		int end = n - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] > element) {
				end = mid - 1;
			} else if (arr[mid] < element) {
				start = mid + 1;
			} else {
				if (mid == n - 1 || arr[mid] != arr[mid + 1]) {
					return mid;
				} else {
					start = mid + 1;
				}
			}
		}
		return -1;
	}

	private static int getFirstOccurence(int[] arr, int element) {
		int n = arr.length;
		int start = 0;
		int end = n - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] > element) {
				end = mid - 1;
			} else if (arr[mid] < element) {
				start = mid + 1;
			} else {
				if (mid == 0 || arr[mid] != arr[mid - 1]) {
					return mid;
				} else {
					end = mid - 1;
				}
			}
		}

		return -1;
	}

	private static int countOccurences(int[] arr, int element) {
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == element) {
				counter++;
			}
			if (i + 1 < arr.length && arr[i + 1] != element) {
				break;
			}
		}

		return counter;
	}

}
