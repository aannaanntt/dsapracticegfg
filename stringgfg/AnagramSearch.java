//package stringgfg;
//
//import java.util.Arrays;
//
//public class AnagramSearch {
//
//	public static void main(String[] args) {
//		String text = "cbabcacab";
//		String pattern = "abc";
//
//		findAnagrams(text, pattern);
//	}
//	
//	//sliding window and count freq array
//	public  static void findAnagramsOpt(String text,String pattern) {
//		int n= 
//	}
//
//	private static void findAnagrams(String text, String pattern) {
//		int n = text.length();
//		int m = pattern.length();
//
//		char[] patArray = pattern.toCharArray();
//		Arrays.sort(patArray);
//
//		for (int i = 0; i <= n - m; i++) {
//			String subString = text.substring(i, i + m);
//			char[] subArray = subString.toCharArray();
//			Arrays.sort(subArray);
//			if (Arrays.equals(patArray, subArray)) {
//				System.out.println("Anagram found at index: " + i);
//			}
//		}
//
//	}
//}
