package mathmaticsfordsa;

import java.util.Arrays;

public class LengthOfANumber {

	public static void main(String[] args) {
		System.out.print(getCount(9235));
//		getCount_rec(789);
//		System.out.print(isPalindrome(367));
		// factorial(5);
		// System.out.print(fact_rec(10));
		// System.out.print(facxtorialTrailingZero(10));
		// System.out.print(GCDorHCF(4,6));
		// System.out.print(gcdEculiOpt(4,6));
		// primeFactors(12);
		// primeFactorsOptimized(84);
		// primeDivisorss(6);
		// printDivisorsOptimized(6);
		// printFactorsWithSorting(6);
		// sieveOFEratothenes(10);
		// sieve1(10);
		//System.out.println(powerEfficient(3, 5));
		//System.out.println(powerIterative(3,5));
	}
	
	

	static int powerIterative(int x, int n) {
		int res = 1;
		while (n > 0) {
			if (n % 2 != 0) {
				res = res * x;
			}
			

			x = x * x;

			n = n / 2;
		}
		return res;
	}

	static int powerEfficient(int x, int n) {
		if (n == 0)
			return 1;
		int temp = powerEfficient(x, n / 2);
		temp = temp * temp;
		if (n % 2 == 0)
			return temp;
		else
			return temp * x;
	}

	static void sieve1(int n) {
		boolean isPrime[] = new boolean[n + 1];
		Arrays.fill(isPrime, true);

		for (int i = 2; i <= n; i++) {
			if (isPrimeOpt(i)) {
				System.out.println(i);
			}
			for (int j = i * i; j <= n; j = j + i) {
				isPrime[j] = false;
			}
		}
	}

	static void sieve(int n) {
		boolean isPrime[] = new boolean[n + 1];
		Arrays.fill(isPrime, true);

		for (int i = 2; i * i <= n; i++) {
			if (isPrimeOpt(i)) {
				for (int k = 2 * i; k <= n; k = k + i) {
					isPrime[k] = false;
				}
			}
		}

		for (int j = 2; j <= n; j++) {
			if (isPrime[j])
				System.out.println(j);
		}

	}

	static void sieveOFEratothenes(int n) {
		for (int i = 2; i <= n; i++) {
			if (isPrimeOpt(i)) {
				System.out.println(i);
			}
		}
	}

	static void printFactorsWithSorting(int n) {
		int i;
		for (i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				System.out.print(i + " ");
			}
		}
		for (; i > 1;) {
			i--;
			if (i != n / i && n % i == 0)
				System.out.print(n / i + " ");
		}

	}

	public static void printDivisorsOptimized(int n) {
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				System.out.println(i);
			}

			if (i != n / i) {
				System.out.println(n / i);
			}
		}

	}

	public static void primeDivisorss(int n) {
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				System.out.println(i);
			}
		}

	}

	public static void primeFactorsOptimized(int n) {
		if (n <= 1)
			return;
		for (int i = 2; i * i <= n; i++) {
			while (n % i == 0) {
				System.out.println(i);
				n = n / i;

			}
		}
		if (n > 1)
			System.out.print(n);

	}

	public static void primeFactors(int x) {
		for (int i = 2; i < x; i++) {
			if (isPrimeOpt(i)) {
				int s = i;
				while (x % s == 0) {
					System.out.println(i);
					s = s * i;
				}

			}
		}
	}

	public static boolean isPrimeOPT2(int c) {
		if (c == 1)
			return false;
		if (c == 2 || c == 3)
			return true;
		if (c % 2 == 0 || c % 3 == 0)
			return false;
		for (int i = 5; i * i <= c; i = i + 6) {
			if (c % i == 0 || c % (i + 2) == 0)
				return false;
		}
		return true;

	}

	public static boolean isPrimeOpt(int x) {
		if (x == 1)
			return false;
		for (int i = 2; i <= Math.sqrt(x); i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;

	}

	public static boolean isPrime(int x) {
		if (x == 1)
			return false;
		for (int i = 2; i < x - 1; i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;

	}

	public static int getLCMEfficent(int a, int b) {
		return (a * b) / gcdEculiOpt(a, b);
	}

	public static int getLCM(int a, int b) {
		int res = Math.max(a, b);
		while (true) {
			if (res % a == 0 && res % b == 0) {
				return res;
			}
			res++;
		}
	}

	public static int getCount(int x) {
		int res = 0;
		while (x > 0) {
			x = x % 10;
			res++;
			x = x / 10;
		}
		return res;

	}

	public static void factorial(int n) {
		int res = 1;
		for (int i = 2; i <= n; i++) {
			res = res * i;
		}
		System.out.print(res);
	}

	public static int gcdEuclidean(int a, int b) {
		while (a != b) {
			if (a > b) {
				a = a - b;
			} else {
				b = b - a;
			}

		}

		return a;

	}

	public static int gcdEculiOpt(int a, int b) {
		if (b == 0)
			return a;
		return gcdEculiOpt(b, a % b);
	}

	public static int GCDorHCF(int a, int b) {
		int res = Math.min(a, b);
		while (res > 0) {
			if (a % res == 0 && b % res == 0) {
				break;
			}
			res--;

		}

		return res;
	}

	public static int facxtorialTrailingZero(int n) {
		int res = 1;
		int cnt = 0;
		for (int i = 2; i <= n; i++) {
			if (i == 2 || i == 5) {
				cnt++;
			}
			res = res * i;
		}

		return cnt;

	}

	public static int fact_rec(int n) {
		if (n == 1)
			return 1;
		return n * fact_rec(n - 1);
	}

	public static boolean isPalindrome(int x) {
		int rev = 0;
		int temp = x;
		while (temp > 0) {
			temp = temp % 10;
			rev = rev * 10 + x;
			x = x / 10;
		}

		return rev == x;
	}

	public static int getCount_rec(int x) {

		if (x == 0) {
			return 0;
		}

		return 1 + getCount(x / 10);

	}

}
