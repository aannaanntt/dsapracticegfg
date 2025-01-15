package bitwiseoperatos;

public class TwoOddOccuring {

	public static void main(String[] args) {
		int arr[] = { 3, 4, 3, 4, 5, 4, 4, 6, 7, 7 };

		printOddOccuring(arr, arr.length);
	}

	private static void printOddOccuring(int[] arr, int n) {
		int x = arr[0];
		for (int i = 1; i < n; i++) {
			x ^= arr[i];
		}

		int k = x & (x - 1);
		int res1 = 0;
		int res2 = 0;
		for (int i = 0; i < n; i++) {
			if ((arr[i] & k) != 0) {
				res1 = res1 ^ arr[i];
			} else {
				res2 = res2 ^ arr[i];
			}
		}

		System.out.println(res1 + " " + res2);

	}

}
