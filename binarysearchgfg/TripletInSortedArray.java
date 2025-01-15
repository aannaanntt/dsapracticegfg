package binarysearchgfg;

public class TripletInSortedArray {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 4, 8, 9, 20, 40 };
		int tripSum = 32;
		System.out.println(isTripletExist(arr, tripSum));
	}

	public static boolean isTripletMoreOptimized(int[] arr, int tripSum) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if (isPair(arr, tripSum - arr[i], i + 1)) {
				return true;
			}
		}

		return false;
	}

	private static boolean isPair(int[] arr, int i, int j) {
		int s = 0;
		int e = arr.length - 1;
		while (s <= e) {
			if (arr[s] + arr[e] > j) {
				e--;
			} else if (arr[s] + arr[e] < j) {
				s++;
			} else {
				return true;
			}
		}
		return false;
	}

	private static boolean isTripletExist(int[] arr, int tripSum) {
		int n = arr.length;
		if (n == 0)
			return false;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					if (arr[i] + arr[j] + arr[k] == tripSum) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
