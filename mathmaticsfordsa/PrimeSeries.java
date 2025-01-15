package mathmaticsfordsa;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeSeries {

	public static void main(String[] args) {
		int n = 40;
//		for (int i = 2; i <= n - 1; i++) {
//			System.out.println(i + " " + printPrimeSeries(i));
//			
//		}

		// sieve(40);
		// System.out.println(squareRoot(40, 3));
		//factorsOpt(20);
		factorsOptsorted(20);
	}

	static void factorsOpt(int n) {
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				if (n / i == i) {
					System.out.print(i + " ");
				} else {
					System.out.print(i + "  " + n / i + " ");
				}

			}
		}
	}

	static void factorsOptsorted(int n) {
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				if (n / i == i) {
					System.out.print(i + " ");
				} else {
					System.out.print(i + "  ");
					al.add(n / i);
				}

			}
		}

		al.sort((x, y) -> x - y);
		al.forEach(System.out::print);
	}

	static double squareRoot(int n, int p) {
		int i = 2;
//		while(i<n) {
//			if(i * i == n) {
//				System.out.println(i);
//			}
//			
//			i++;
//		}

		int start = 0;
		int end = n;
		double root = 0.0;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			int val = mid * mid;
			if (val == n) {
				root = mid;
				System.out.println(root);
				return root;
			} else if (val > n) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		double incr = 0.1;
		System.out.println(root);
		for (int k = 0; k < p; k++) {
			while (root * root <= n) {
				root += incr;
			}
			root -= incr;
			incr /= 10;
		}

		return root;
	}

	public static void sieve(int n) {
		boolean[] isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);
		int i = 2;
		while (i * i < n) {
			if (printPrimeSeries(i)) {
				for (int k = 2 * i; k <= n; k = k + i) {
					isPrime[k] = false;
				}
			}
			i++;
		}

		for (int j = 2; j <= n; j++) {
			if (isPrime[j])
				System.out.println(j);
		}

	}

	private static boolean printPrimeSeries(int n) {
		if (n <= 1)
			return false;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;

	}

}
