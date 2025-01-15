package bitwiseoperatos;

public class XorRange {

	public static void main(String[] args) {
		xorFromZeroToA(5);
		int a = 3;
		int b = 9;
		int ans = xorFromZeroToA(b) ^ xorFromZeroToA(a - 1);
		System.out.println(ans);
	}

	public static int xorFromZeroToA(int a) {
		// Determine the result based on a % 4
		switch (a % 4) {
		case 0:
			return a;
		case 1:
			return 1;
		case 2:
			return a + 1;
		case 3:
			return 0;
		default:
			return -1; // This case should never be reached
		}

	}
}
