package stringgfg;

public class CheckIfSubseq {
	
	
	public static void main(String[] args) {
		String str = "ABCD";
		String str2 = "AD";
		
		System.out.println(checkIfSubs(str,str2,str.length(),str2.length()));
	}
	
	
	
	public static boolean checkIfSubs(String str1, String st2,int n,int m) {
		int j=0;
		for(int i=0;i<n && j<m;i++) {
			if(str1.charAt(i)==st2.charAt(j)) {
				j++;
			}
		}
		
		return (j==m);
	}
	

	private static boolean checkIfSub(String str, String str2,int i,int j) {
		if(j == str2.length()) return true;
		if(i == str.length()) return false;
		if(str.charAt(i) == str2.charAt(j)) {
		return	checkIfSub(str, str2, i+1, j+1);
		}
		
		return checkIfSub(str, str2, i+1, j);
		
		
	}

}
