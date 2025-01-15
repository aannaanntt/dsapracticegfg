package bitwiseoperatos;

public class AmazonQuestionNthMagicalNunmber {

	public static void main(String[] args) {
		int n = 3;
		System.out.print(magicalNumber(n));
	}

	private static int magicalNumber(int n) {
		int ans = 0;
		int base = 5;
		while (n > 0) {
			int lastDigit = n & 1;
			n = n >> 1;
			ans = ans + lastDigit * base;
			base = base * 5;
		}
		return ans;
	}
}
