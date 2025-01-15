package stringgfg;

import java.util.Arrays;

public class StringFreqDemo {

	public static void main(String[] args) {
		String str = "anant";
		int [] cnt = new int[126];
		//getCountArray(str);
		getCountArrayRec(str,cnt,0);
		
		for(int i=0;i<cnt.length;i++) {
			if(cnt[i]>0) {
				System.out.println((char)(i+'a')+" "+cnt[i]);
			}
		}
	}

	private static void getCountArrayRec(String str, int[] cnt,int pointer) {
		if(pointer>=str.length())
			return;
			
		cnt[str.charAt(pointer)-'a']++;
		getCountArrayRec(str, cnt, pointer+1);
			
			
		
	}

	private static void getCountArray(String str) {
		int[] count = new int[126];
		for (int i = 0; i < str.length(); i++) {
			count[str.charAt(i) - 'a']++;
		}

		System.out.println(Arrays.toString(count));

	}
}
