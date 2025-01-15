package stringgfg;

public class KMPAlgorithm {

	public static void main(String[] args) {
		String text = "ababcabcabababd";
		String pattern = "ababd";

		KMPSearch(text, pattern);
	}

	// KMP Search Algorithm
	private static void KMPSearch(String text, String pattern) {
		int m = text.length(); // Length of text
		int n = pattern.length(); // Length of pattern

		// Compute LPS array
		int lps[] = computeLps(pattern, n);

		int i = 0; // Index for text
		int j = 0; // Index for pattern

		// Search loop
		while (i < m) { // Loop until the end of the text
			// Match condition
			if (text.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			}
			// Full match found
			if (j == n) {
				System.out.println("Pattern found at index " + (i - j));
				j = lps[j - 1]; // Move j based on LPS
			}
			// Mismatch after some matches
			else if (i < m && text.charAt(i) != pattern.charAt(j)) {
				if (j != 0) {
					j = lps[j - 1]; // Shift based on LPS
				} else {
					i++; // Move to next character in text
				}
			}
		}
	}

	// Compute LPS Array
	private static int[] computeLps(String pattern, int n) {
		int lps[] = new int[n];
		int prefixArrayLen = 0; // Length of the previous LPS
		int index = 1;

		while (index < n) {
			// Characters match
			if (pattern.charAt(index) == pattern.charAt(prefixArrayLen)) {
				prefixArrayLen++;
				lps[index] = prefixArrayLen;
				index++;
			}
			// Mismatch
			else {
				if (prefixArrayLen != 0) {
					prefixArrayLen = lps[prefixArrayLen - 1];
				} else {
					lps[index] = 0;
					index++;
				}
			}
		}
		return lps;
	}
}
