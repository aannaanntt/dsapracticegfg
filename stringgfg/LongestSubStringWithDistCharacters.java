package stringgfg;

import java.util.HashMap;

public class LongestSubStringWithDistCharacters {

	public static void main(String[] args) {
		String str = "abcdabc";

		System.out.println(longDistOpt(str));
	}
	
	
	//optApp
	public static int longDistOpt(String str) {
		int n = str.length();
		int maxLen =0;
		int start=0;// starting of the window
		HashMap<Character,Integer> map = new HashMap<>();
		for(int end=0;end<n;end++) {
			char currentCharacter = str.charAt(end);
			
			if(map.containsKey(currentCharacter)) {
				start = Math.max(start, map.get(currentCharacter) + 1);
			}
			
			map.put(currentCharacter, end);
			
			
			maxLen = Math.max(maxLen, end - start +1);
		}
		
		return maxLen;
		
	}

	private static int longestDist(String str) {
		int n = str.length();
		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (isDist(str, i, j)) {
					res = Math.max(res, j - i + 1);
				}
			}
		}

		return res;

	}

	private static boolean isDist(String str, int startingIndex, int endingIndex) {
		boolean[] visited = new boolean[256];
		for (int i = startingIndex; i <= endingIndex; i++) {
			if (visited[str.charAt(i)]) {
				return false;
			}

			visited[str.charAt(i)] = true;
		}

		return true;
	}
}
