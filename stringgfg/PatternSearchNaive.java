package stringgfg;

public class PatternSearchNaive {

	public static void main(String[] args) {
		String str = "geeksforgeeks";
		String pat = "eks";
		// o/p 2,10

		naivePatternMatch(str, pat);
	}

	private static void naivePatternMatch(String str, String pat) {
		int n = str.length();
		int m = pat.length();
		for (int i = 0; i <= n - m; i++) {
			int j;
			for (j = 0; j < m; j++) {
				if (str.charAt(i + j) != pat.charAt(j)) {
					break;

				}

			}

			if (j == m) {
				System.out.print(i + " ");
			}
		}

	}
}
