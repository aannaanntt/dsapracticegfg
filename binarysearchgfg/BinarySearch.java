package binarysearchgfg;

public class BinarySearch {

	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 40, 50, 60 };
		int target = 30;

//		System.out.println(binarySearch(arr, target));
//		System.out.println(linearSearch(arr, target));
		System.out.println(binarySearchRec(arr, target, 0, arr.length - 1));
	}

	private static int binarySearchRec(int[] arr, int target, int start, int end) {

		if (start > end)
			return -1;
		int mid = start + (end - start) / 2;
		if (arr[mid] == target)
			return mid;
		if (arr[mid] > target)
			return binarySearchRec(arr, target, start, mid - 1);
		else
			return binarySearchRec(arr, target, mid + 1, end);
	}

	private static int binarySearch(int[] arr, int target) {
		int start = 0;
		int end = arr.length;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	private static int linearSearch(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				return i;
			}
		}

		return -1;
	}

}
