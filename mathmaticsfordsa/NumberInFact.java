package mathmaticsfordsa;

public class NumberInFact {
	public static int digitsInFactorial(int N) {
		long fact = getFact(N);

		int cnt = 0;
		while (fact > 0) {
			fact = fact / 10;
			cnt++;
		
		}
		


		return cnt;
	}

	static long getFact(int n) {
		long res = 1;
		for (int i = 2; i <= n; i++) {
			res = res * i;
		}
		
	System.out.println(res);

		return res;
	}

	public static void main(String[] args) {
		System.out.println(digitsInFactorial(42));
	}
}
