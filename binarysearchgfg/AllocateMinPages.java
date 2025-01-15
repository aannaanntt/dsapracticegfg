package binarysearchgfg;

//humko pages die gye h books k or students number humko aise distribute krni k koi b student overload na ho or minimize the maximum number of pages a student can get
public class AllocateMinPages {

	public static void main(String[] args) {
		int[] arr = { 12, 34, 67, 90 };
		int numberOfStudent = 2;

		System.out.println(minPagesBS(arr, numberOfStudent));
	}

	static int minPagesBS(int[] arr, int students) {
		int sum = 0;
		int mx = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			mx = Math.max(mx, arr[i]);
		}
		int low = mx;
		int high = sum;
		int res = 0;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (isFeasable(arr, arr.length, students, mid)) {
				res = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return res;
	}

	private static boolean isFeasable(int[] arr, int length, int students, int mid) {
		int req = 1;
		int sum = 0;
		for (int i = 0; i < length; i++) {
			if (sum + arr[i] > mid) {
				req++;
				sum = arr[i];
			} else {
				sum += arr[i];
			}
		}

		return (req <= students);
		// TODO Auto-generated method stub

	}

	// please see explaination
	private static int minPages(int[] arr, int numberOfStudent) {
		// Base cases
		if (numberOfStudent == 1) {
			return sum(arr, 0, arr.length - 1); // If only one student, they get all books
		}
		if (arr.length == 1) {
			return arr[0]; // If only one book, that's the minimum
		}

		int res = Integer.MAX_VALUE;

		// Iterate to split books into two parts
		for (int i = 1; i <= arr.length - numberOfStudent; i++) { // Fix: Ensure at least one book per student
			int firstPart = sum(arr, 0, i - 1); // Sum of the first part of the books
			int restPart = minPages(subArray(arr, i, arr.length - 1), numberOfStudent - 1); // Recursive call for the
																							// rest
			res = Math.min(res, Math.max(firstPart, restPart)); // Minimize the maximum number of pages
		}
		return res;
	}

	private static int sum(int[] arr, int i, int j) {
		int s = 0;
		for (int k = i; k <= j; k++) { // Fix: Ensure proper range from i to j
			s += arr[k];
		}
		return s;
	}

	private static int[] subArray(int[] arr, int start, int end) {
		int[] result = new int[end - start + 1];
		for (int i = start; i <= end; i++) {
			result[i - start] = arr[i];
		}
		return result;
	}
}