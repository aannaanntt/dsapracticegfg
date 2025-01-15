package stringgfg;

import java.util.Arrays;

public class LeftMostRepeating {


	static int CHAR= 256;
	
	public static void main(String[] args) {
		String str = "vaishali";
		
		
		//System.out.println((char)leftMostRep((str)));
		
		System.out.println(leftMostRepAPP3(str));
	}
	
	
	public static int leftMostRepAPP3(String str) {
		boolean[] visited = new boolean[CHAR];
		int res = -1;
		for(int i=str.length() -1;i>=0;i--) {
			if(visited[str.charAt(i)]) {
				res =i;
			}else {
				visited[str.charAt(i)] =true;
			}
		}
		
		return res;
	}
	
	public static int leftMostApp2(String str) {
		int [] fIndex = new int[CHAR];
		Arrays.fill(fIndex, -1);
		
		
		int res = Integer.MAX_VALUE;
		for(int i=0;i<str.length();i++) {
			int fI= fIndex[str.charAt(i)];
			
			if(fI==-1) {
				fIndex[str.charAt(i)]= i ;
			}else {
				res = Math.min(res, fI);
			}
		}
		
		return (res == Integer.MAX_VALUE) ? -1 : res;
	}

	private static int leftMostEffApp(String str) {
		int[] count = new int[CHAR];
		
		for(int i=0;i<str.length();i++) {
			count[str.charAt(i)]++;
		}
		
		for(int i=0;i<str.length();i++) {
			if(count[str.charAt(i)]>1) {
				return i;
			}
		}
		
		return -1;
	
	}

	private static int leftMostRep(String str) {
		int n = str.length();
		
		for(int i=0;i<str.length();i++) {
			boolean isRepeated= false;
			for(int j=0;j<i;j++) {
				if(i!=j && str.charAt(i)==str.charAt(j) ) {
					isRepeated=true;
					break;
				}
			}
			
			if(isRepeated) return str.charAt(i);
		}
		
		return -1;
		
	}
}
