package stringgfg;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		String str = "silent";
		String str2 = "listef";

		// System.out.println(isAnagramNaive(str,str2));
		System.out.println(isAnagramEff(str, str2));
	}

	static int CHAR = 256;

	private static boolean isAnagramEff(String str, String str2) {
		if (str.length() != str2.length())
			return false;
		int[] count = new int[CHAR];
		for (int i = 0; i < str.length(); i++) {
			count[str.charAt(i)]++;
			count[str2.charAt(i)]--;
		}

		for (int i = 0; i < CHAR; i++) {
			if (count[i] != 0) {
				return false;
			}
		}

		return true;
	}

	private static boolean isAnagramNaive(String str, String str2) {

		if (str.length() != str2.length())
			return false;
		char[] ch1 = str.toCharArray();
		char[] ch2 = str2.toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch2);

		return Arrays.equals(ch1, ch2);

	}

}
