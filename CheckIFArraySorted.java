package arrays;

public class CheckIFArraySorted {

	public static void main(String[] args) {
		int a[] = { 12, 14, 15 };
		System.out.println(isSortedOpt(a));

	}

	public static boolean isSortedOpt(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) {
				return false;
			}
		}

		return true;

	}

	// time complexity o(n2)
	private static boolean isSorted(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[i]) {
					return false;
				}
			}
		}

		return true;
	}

}
